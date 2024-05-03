package com.example.electricbicycle;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.electricbicycle.databinding.ActivityHistoricalTripsBinding;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class HistoricalTrips extends AppCompatActivity {
    private BarChart barChart;
    private ActivityHistoricalTripsBinding binding;
    ListView listView;
    ArrayAdapter<Trip> todoItemsAdapter;
    TravelPointsApplication tpa;
    private static final int SHOW_BICYCLE_STATUS_ACTIVITY = 1;
    private static final int SHOW_NEW_TRIP_ACTIVITY = 2;

    private static final int SHOW_DISPLAY_TRIP_ACTIVITY = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHistoricalTripsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.newTrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AddTripActivity.class);
                startActivityForResult(intent, SHOW_NEW_TRIP_ACTIVITY);
            }
        });

        binding.bicycleStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), BicycleStatus.class);
                startActivityForResult(intent, SHOW_BICYCLE_STATUS_ACTIVITY);
            }
        });
        barChart = findViewById(R.id.barChart);
        ArrayList<BarEntry> entries  = new ArrayList<>();

        entries.add(new BarEntry(2014, 420));
        entries.add(new BarEntry(2015, 230));
        entries.add(new BarEntry(2016, 532));
        entries.add(new BarEntry(2017, 132));
        entries.add(new BarEntry(2018, 234));

        BarDataSet barDataSet = new BarDataSet(entries, "Data");
        barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        barDataSet.setValueTextColor(Color.BLACK);
        barDataSet.setValueTextSize(16f);

        BarData barData = new BarData(barDataSet);
        barChart.setFitBars(true);
        barChart.setData(barData);
        barChart.getDescription().setText("Bar Chart");
        barChart.animateY(2000);

        listView = (ListView) findViewById(R.id.list);
        tpa = (TravelPointsApplication)getApplicationContext();
        todoItemsAdapter = new ArrayAdapter<Trip>(this, R.layout.row_layout, R.id.listText,  tpa.getPoints());
        listView.setAdapter(todoItemsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Trip trip = (Trip)listView.getItemAtPosition(position);
                Bundle bundle = new Bundle();
                bundle.putString("origin",trip.getOrigin());
                bundle.putString("destination",trip.getDestination() );
                bundle.putString("powerMode", trip.getPowerMode());
                bundle.putString("assistance", trip.getAssistance());
                bundle.putString("time", trip.getTime());
                bundle.putDouble("kmTraveled", trip.getKmTraveled());
                Intent intent = new Intent(getApplicationContext(), DisplayTrip.class);
                intent.putExtras(bundle);
                startActivityForResult(intent, SHOW_DISPLAY_TRIP_ACTIVITY);
            }
        });

    }
    public void updateLastTrip(String origin, String destination, String powerMode, String assistance, String time, double kmTraveled) {
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


            }else if (requestCode == SHOW_DISPLAY_TRIP_ACTIVITY){
                Bundle bundle = data.getExtras();
                todoItemsAdapter.notifyDataSetChanged();
            }

        }
    }
}