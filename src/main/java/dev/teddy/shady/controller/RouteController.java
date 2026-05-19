package dev.teddy.shady.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class RouteController {
    @GetMapping("/routes")
    public Map<String,String> getRoutes(){
        return Map.of(
                "status","working",
                "message","Shadow routing API is alive"
        );
    }
}
