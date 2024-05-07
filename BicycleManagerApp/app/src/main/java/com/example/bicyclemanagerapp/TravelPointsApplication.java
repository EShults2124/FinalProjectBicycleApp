package com.example.bicyclemanagerapp;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

public class TravelPointsApplication extends Application {

    private List<Trip> tripList = new ArrayList<>();

    @Override
    public void onCreate() {
        super.onCreate();
        initializeList();
    }

    public  List<Trip> getPoints(){
        return tripList;
    }
    public void initializeList() {
        tripList.clear();
        Trip aInterestPoint;

        String[] origins = {"Ayuntamiento", "Rochapea", "Mutilva", "Casco viejo", "Plaza de toros"};
        String[] destinations = {"Mutilva", "Burlada", "Plaza de toros", "Rochapea", "Mutilva"};
        String[] powerModes = {"Eco", "Normal", "Sport", "Eco", "Normal"};
        String[] assistances = {"Higher", "Lower", "Normal", "Higher", "Normal"};
        String[] times = {"00:30:02", "00:23:04", "00:30:02", "00:12:19", "00:09:02"};
        double[] kmTraveled = {2.3, 2.4, 1.3, 2.7, 1.0};

        for(int i=0; i<5; i++){
            aInterestPoint = new Trip(

            );
            tripList.add(i,aInterestPoint);

        }
    }
}
