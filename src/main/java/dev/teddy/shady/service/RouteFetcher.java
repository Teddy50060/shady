package dev.teddy.shady.service;

import dev.teddy.shady.model.Route;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.Map;

@Service
public class RouteFetcher {

    @Value("${google.api.key}")
    private String googleApiKey;

    private final RestClient restClient;
    public RouteFetcher(@Qualifier("googleMapRestClient") RestClient restClient) {
        this.restClient = restClient;
    }

    public String fetchRoutes(double currentLatitude, double currentLongitude, double destLatitude, double destLongitude){

        Map<String,Object> requestBody = Map.of(
                "origin",Map.of("location",Map.of(
                                "latLng", Map.of(
                                        "latitude", currentLatitude,
                                        "longitude", currentLongitude
                                )
                        )
        ),
               "destination",
                       Map.of("location", Map.of(
                               "latLng", Map.of(
                                       "latitude", destLatitude,
                                       "longitude", destLongitude
                               )
                       )
                ),
                "travelMode", "WALK",
                "computeAlternativeRoutes", true
        );

        return this.restClient.post()
                .uri("/directions/v2:computeRoutes")
                .header("X-Goog-Api-Key", googleApiKey)
                .header("X-Goog-FieldMask", "routes.polyline,routes.legs,routes.distanceMeters,routes.duration")
                .contentType(MediaType.APPLICATION_JSON)
                .body(requestBody)
                .retrieve()
                .body(String.class);
    }
}
