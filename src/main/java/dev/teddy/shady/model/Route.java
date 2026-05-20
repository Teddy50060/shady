package dev.teddy.shady.model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Route {
    private String polyline;
    private List<Leg> legs;
    private int distanceMeters;
    private String duration;

    public Route(String polyline, List<Leg> legs, int distanceMeters, String duration){
        this.polyline = polyline;
        this.legs = legs;
        this.distanceMeters = distanceMeters;
        this.duration = duration;
    }

    public String getPolyline() {
        return polyline;
    }

    public List<Leg> getLegs() {
        return legs;
    }

    public int getDistanceMeters() {
        return distanceMeters;
    }

    public String getDuration() {
        return duration;
    }
}
