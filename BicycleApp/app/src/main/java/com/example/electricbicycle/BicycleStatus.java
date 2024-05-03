package com.example.electricbicycle;
import androidx.appcompat.app.AppCompatActivity;

import com.example.electricbicycle.databinding.ActivityBicycleStatusBinding;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

public class BicycleStatus extends AppCompatActivity {
    private ActivityBicycleStatusBinding binding;
    private Bicycle bicycle;

    private static final int SHOW_HISTORICAL_ACTIVITY = 1;
    private static final int SHOW_NEW_TRIP_ACTIVITY = 2;

    ArrayAdapter<Trip> todoItemsAdapter;
    TravelPointsApplication tpa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityBicycleStatusBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        bicycle = new Bicycle(75,35.0,138.4,"Higher","Normal",35.0);

        binding.historicalTrips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentHistorical = new Intent(getApplicationContext(), HistoricalTrips.class);
                startActivityForResult(intentHistorical, SHOW_HISTORICAL_ACTIVITY);
            }
        });

        binding.newTrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AddTripActivity.class);
                startActivityForResult(intent, SHOW_NEW_TRIP_ACTIVITY);
            }
        });
        tpa = (TravelPointsApplication)getApplicationContext();
        todoItemsAdapter = new ArrayAdapter<Trip>(this, R.layout.row_layout, R.id.listText,  tpa.getPoints());

        updateView();
    }

    private void updateView() {
        // PIECHART FOR THE BATTERY
        PieChart batteryChart = findViewById(R.id.batteryChart);
        List<PieEntry> entries = new ArrayList<>();

        entries.add(new PieEntry(bicycle.getBatteryLevel(), ""));
        entries.add(new PieEntry(100 - bicycle.getBatteryLevel(), ""));

        PieDataSet dataSet = new PieDataSet(entries, "");
        dataSet.setColors(Color.GREEN, Color.LTGRAY);
        dataSet.setDrawValues(false);

        PieData data = new PieData(dataSet);

        batteryChart.setData(data);
        batteryChart.getLegend().setEnabled(false);

        batteryChart.getDescription().setEnabled(false);
        batteryChart.setCenterText(bicycle.getBatteryLevel() + "%");
        batteryChart.setCenterTextColor(Color.BLACK);
        batteryChart.animateY(1000);
        batteryChart.invalidate();

        // TEXTVIEW FOR THE REST OF THE ATTRIBUTES
        binding.varRange.setText(bicycle.getRange() + " km");
        binding.varKmTraveled.setText(Double.toString(bicycle.getKmTraveled()));
        binding.varAssistance.setText(bicycle.getAssistanceMode());
        binding.varCurrentPower.setText(Double.toString(bicycle.getCurrentPower()));



    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == SHOW_NEW_TRIP_ACTIVITY) {
                Bundle bundle = data.getExtras();

                String origin = bundle.getString("origin");
                String destination = bundle.getString("destination");
                String powerMode = bundle.getString("powerMode");
                String assistance = bundle.getString("assistance");
                String time = bundle.getString("time");
                Double kmTraveled = bundle.getDouble("kmTraveled");

                Trip trip = new Trip();
                trip.setOrigin(origin);
                trip.setDestination(destination);
                trip.setPowerMode(powerMode);
                trip.setAssistance(assistance);
                trip.setTime(time);
                trip.setKmTraveled(kmTraveled);

                todoItemsAdapter.add(trip);
                todoItemsAdapter.notifyDataSetChanged();
            }

        }
    }
}