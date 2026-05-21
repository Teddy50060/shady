package dev.teddy.shady.controller;

import dev.teddy.shady.model.Route;
import dev.teddy.shady.service.RouteFetcher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class RouteController {
    private final RouteFetcher routeFetcher;

    public RouteController(RouteFetcher routeFetcher) {
        this.routeFetcher = routeFetcher;
    }

    @GetMapping("/routes")
    public List<Route> getRoutes(
            @RequestParam(defaultValue = "13.7294") double currentLatitude,
            @RequestParam(defaultValue = "100.5316") double currentLongitude,
            @RequestParam(defaultValue = "13.7455") double destLatitude,
            @RequestParam(defaultValue = "100.5342") double destLongitude
    ){
        return routeFetcher.fetchRoutes(currentLatitude,currentLongitude,destLatitude,destLongitude);
    }

}
