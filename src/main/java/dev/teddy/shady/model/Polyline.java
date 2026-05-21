package dev.teddy.shady.model;

public class Polyline {
    private String encodedPolyline;

    public Polyline(String encodedPolyline){
        this.encodedPolyline=encodedPolyline;
    }

    public String getEncodedPolyline() {
        return encodedPolyline;
    }

}
