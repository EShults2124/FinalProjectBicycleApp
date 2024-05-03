package com.example.electricbicycle;

import java.util.Date;

public class Trip {
    private String origin;
    private String destination;

    private String powerMode;

    private String assistance;

    private String time;
    private double kmTraveled;

    public Trip() {
    }

    public Trip(String origin, String destination, String powerMode, String assistance, String time, double kmTraveled) {
        this.origin = origin;
        this.destination = destination;
        this.powerMode = powerMode;
        this.assistance = assistance;
        this.time = time;
        this.kmTraveled = kmTraveled;
    }

    public String getOrigin() {
        return origin;
    }
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getPowerMode() {
        return powerMode;
    }
    public void setPowerMode(String powerMode) {
        this.powerMode = powerMode;
    }

    public String getAssistance() {
        return assistance;
    }
    public void setAssistance(String assistance) {
        this.assistance = assistance;
    }

    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }

    public double getKmTraveled() {
        return kmTraveled;
    }
    public void setKmTraveled(double kmTraveled) {
        this.kmTraveled = kmTraveled;
    }

    @Override
    public String toString() {
        return String.format("%.2f", kmTraveled) + " km - " + time + "\n" + "Origin: " + origin + "\n" +  "Destination: " + destination;
    }
}
