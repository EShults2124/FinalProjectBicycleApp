package com.example.back4appmvcsubactivity.Model;

import com.parse.ParseClassName;
import com.parse.ParseObject;

@ParseClassName("InterestPoint")
public class Bicycle extends ParseObject {
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
        return getInt("battery_level");
    }
    public void setBatteryLevel(int batteryLevel) {
        put("battery_level", batteryLevel);
    }

    public double getRange() {
        return getDouble("range");
    }
    public void setRange(double range) {
        put("range", range);
    }

    public double getKmTraveled() {
        return getDouble("km_traveled");
    }
    public void setKmTraveled(double kmTraveled) {
        put("km_traveled", kmTraveled);
    }

    public String getAssistanceMode() {
        return getString("assistance_mode");
    }
    public void setAssistanceMode(String assistanceMode) {
        put("assistance_mode", assistanceMode);
    }

    public String getPowerMode() {
        return getString("power_mode");
    }
    public void setPowerMode(String powerMode) {
        put("power_mode", powerMode);
    }

    public double getCurrentPower() {
        return getDouble("current_power");
    }
    public void setCurrentPower(double currentPower) {
        put("current_power", currentPower);
    }

    @Override
    public String toString() {
        return "Bicycle{" +
                "batteryLevel=" + batteryLevel +
                ", range=" + range +
                ", kmTraveled=" + kmTraveled +
                ", assistanceMode='" + assistanceMode + '\'' +
                ", powerMode='" + powerMode + '\'' +
                ", currentPower=" + currentPower +
                '}';
    }
}