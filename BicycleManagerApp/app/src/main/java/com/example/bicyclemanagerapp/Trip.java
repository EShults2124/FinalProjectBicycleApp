package com.example.bicyclemanagerapp;

import com.parse.ParseObject;


public class Trip extends ParseObject{

    public Trip() {
    }


    public String getOrigin() {
        return getString("origin");
    }
    public void setOrigin(String origin) {
        put("origin",origin);
    }

    public String getDestination() {
        return getString("destination");
    }
    public void setDestination(String destination) {
        put("destination",destination);
    }

    public String getPowerMode() {
        return getString("powerMode");
    }
    public void setPowerMode(String powerMode) {
        put("powerMode",powerMode);
    }

    public String getAssistance() {
        return getString("assistance");
    }
    public void setAssistance(String assistance) {
        put("assistance",assistance);
    }

    public String getTime() {
        return getString("time");
    }
    public void setTime(String time) {
        put("time",time);
    }

    public double getKmTraveled() {
        return getDouble("kmTraveled");
    }
    public void setKmTraveled(double kmTraveled) {
        put("kmTraveled",kmTraveled);
    }

    @Override
    public String toString() {
        return String.format("%.2f", getKmTraveled()) + " km - " + getTime() + "\n" + "Origin: " + getOrigin() + "\n" +  "Destination: " + getDestination();
    }
}
