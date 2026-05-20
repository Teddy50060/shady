package dev.teddy.shady.model;

public class Leg {
    private String polyline;
    private int distanceMeters;
    private String duration;

    public Leg(String polyline, int distanceMeters, String duration){
        this.polyline=polyline;
        this.distanceMeters=distanceMeters;
        this.duration=duration;
    }

    public String getEncodedPolyline() {
        return polyline;
    }

    public int getDistanceMeters() {
        return distanceMeters;
    }

    public String getDuration() {
        return duration;
    }
}
