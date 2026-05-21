package dev.teddy.shady.controller;

import dev.teddy.shady.service.RouteFetcher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class RouteController {
    private final RouteFetcher routeFetcher;

    public RouteController(RouteFetcher routeFetcher) {
        this.routeFetcher = routeFetcher;
    }

    @GetMapping("/routes")
    public String getRoutes(
            @RequestParam double currentLatitude,
            @RequestParam double currentLongitude,
            @RequestParam double destLatitude,
            @RequestParam double destLongitude
    ){
        return routeFetcher.fetchRoutes(currentLatitude,currentLongitude,destLatitude,destLongitude);
    }

}
