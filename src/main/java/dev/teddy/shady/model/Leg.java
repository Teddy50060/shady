package dev.teddy.shady.model;

public class Leg {
    private Polyline polyline;
    private int distanceMeters;
    private String duration;

    public Leg(Polyline polyline, int distanceMeters, String duration){
        this.polyline = polyline;
        this.distanceMeters=distanceMeters;
        this.duration=duration;
    }

    public String getPolyline() {
        return polyline;
    }

    public int getDistanceMeters() {
        return distanceMeters;
    }

    public String getDuration() {
        return duration;
    }
}
