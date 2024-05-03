package com.example.electricbicycle;

public class Bicycle {
    private int batteryLevel;
    private double range;
    private double kmTraveled;
    private String assistanceMode;
    private String powerMode;
    private double currentPower;

    public Bicycle(int batteryLevel, double range,double kmTraveled,String assistanceMode,
                   String powerMode,double currentPower ) {
        this.batteryLevel = batteryLevel;
        this.range = range;
        this.kmTraveled = kmTraveled;
        this.assistanceMode = assistanceMode;
        this.powerMode = powerMode;
        this.currentPower = currentPower;
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }
    public void setBatteryLevel(int batteryLevel) {
        this.batteryLevel = batteryLevel;
    }

    public double getRange() {
        return range;
    }
    public void setRange(double range) {
        this.range = range;
    }

    public double getKmTraveled() {
        return kmTraveled;
    }
    public void setKmTraveled(double kmTraveled) {
        this.kmTraveled = kmTraveled;
    }

    public String getAssistanceMode() {
        return assistanceMode;
    }
    public void setAssistanceMode(String assistanceMode) {
        this.assistanceMode = assistanceMode;
    }

    public String getPowerMode() {
        return powerMode;
    }
    public void setPowerMode(String powerMode) {
        this.powerMode = powerMode;
    }

    public double getCurrentPower() {
        return currentPower;
    }
    public void setCurrentPower(double currentPower) {
        this.currentPower = currentPower;
    }
}
