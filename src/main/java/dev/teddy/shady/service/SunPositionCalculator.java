package dev.teddy.shady.service;

import dev.teddy.shady.model.SunPosition;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SunPositionCalculator {

    public SunPosition currentSunPosition(double currentLatitude, double currentLongitude, LocalDateTime dateTime) {
        int hour = dateTime.getHour();
        int day = dateTime.getDayOfYear();
        int minute = dateTime.getMinute();
        double timeZoneOffset = currentLongitude / 15;
        double gamma = 2 * Math.PI * (day - 1 + (hour - 12) * 1.0 / 24);
        double solarDeclination = 0.006918 - 0.399912 * Math.cos(gamma) - 0.006758 * Math.cos(2 * gamma) + 0.000907 * Math.sin(2 * gamma);
        double equationOfTime = 229.18 * (0.000075 + 0.001868 * Math.cos(gamma) - 0.032077 * Math.sin(gamma) - 0.014615 * Math.cos(2 * gamma) - 0.040849 * Math.sin(2 * gamma));
        double trueSolarTime = (60 * hour + minute) + 4 * currentLongitude - 60 * timeZoneOffset + equationOfTime;
        double solarHourAngle = (trueSolarTime - 720) * 0.25;
        double solarAltitude = Math.asin(Math.sin(currentLatitude) * Math.sin(gamma) + Math.cos(currentLatitude) * Math.cos(gamma) * Math.cos(solarHourAngle));
        double solarAzimuth = Math.acos((Math.sin(gamma) - Math.sin(currentLatitude) * Math.sin(solarAltitude)) / (Math.cos(currentLatitude) * Math.cos(solarAltitude)));
        return new SunPosition(solarAzimuth, solarAltitude);
    }
}
