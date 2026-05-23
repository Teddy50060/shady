package dev.teddy.shady.service;
import com.google.maps.internal.PolylineEncoding;
import com.google.maps.model.LatLng;
import dev.teddy.shady.model.Route;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Map;

@Service
public class BuildingFetcher {

    private final RestClient restClient;

    public BuildingFetcher(@Qualifier("osmRestClient")RestClient restClient){
        this.restClient=restClient;
    }

    public String fetchBuildingData(List<Route> routes){
        String fullRes="";
        for(Route route:routes) {
            List<LatLng> points = PolylineEncoding.decode(route.getPolyline().getEncodedPolyline());
            String requestBody = "data=" + "[out:json];\n";
            requestBody += "way[\"building\"](around:100,";
            for (LatLng point : points) {
                requestBody += Double.toString(point.lat);
                requestBody += ",";
                requestBody += Double.toString(point.lng);
                requestBody += ",";
            }
            requestBody += ");\nout geom;";
            String res = this.restClient.post()
                    .uri("/interpreter")
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(requestBody)
                    .retrieve()
                    .body(new ParameterizedTypeReference<String>() {
                    });
            fullRes+=res;
        }
        return fullRes;
    }
}
