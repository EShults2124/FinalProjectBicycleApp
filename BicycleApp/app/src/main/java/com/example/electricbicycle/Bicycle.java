package com.example.electricbicycle;

import com.parse.ParseClassName;
import com.parse.ParseObject;

@ParseClassName("Bicycle")
public class Bicycle {

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
        return getInt("batteryLevel");
    }
    public void setBatteryLevel(int batteryLevel) {
        put("batteryLevel",batteryLevel);
    }

    public double getRange() {
        return getDouble("range");
    }
    public void setRange(double range) {
        put("range",range);
    }

    public double getKmTraveled() {
        return getDouble("kmTraveled");
    }
    public void setKmTraveled(double kmTraveled) {
        put("kmTraveled",kmTraveled);
    }

    public String getAssistanceMode() {
        return getString("assistanceMode");
    }
    public void setAssistanceMode(String assistanceMode) {
        put("assistanceMode",assistanceMode);
    }

    public String getPowerMode() {
        return getString("powerMode");
    }
    public void setPowerMode(String powerMode) {
        put("powerMode",powerMode);
    }

    public double getCurrentPower() {
        return getDouble("currentPower");
    }
    public void setCurrentPower(double currentPower) {
        put("currentPower",currentPower);
    }
}
