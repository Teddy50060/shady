package dev.teddy.shady.model;

import java.time.LocalDateTime;

public class SunPosition {
    private double azimuth;
    private double elevation;
    public SunPosition(double azimuth, double elevation) {
        this.azimuth = azimuth;
        this.elevation = elevation;
    }

    public double getAzimuth() {
        return azimuth;
    }

    public double getElevation() {
        return elevation;
    }

}
