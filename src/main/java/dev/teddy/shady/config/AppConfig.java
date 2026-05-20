package dev.teddy.shady.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class AppConfig {

    @Value("${google.routes.base-url}")
    private String googleRoutesBaseURL;

    @Value("${osm.overpass.base-url}")
    private String osmBaseURL;

    @Bean
    public RestClient googleMapRestClient() {
        return RestClient.builder()
                .baseUrl(googleRoutesBaseURL)
                .build();
    }

    @Bean
    public RestClient osmRestClient() {
        return RestClient.builder()
                .baseUrl(osmBaseURL)
                .build();
    }

}
