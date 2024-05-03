package com.example.electricbicycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.electricbicycle.databinding.ActivityAddTripBinding;
import com.example.electricbicycle.databinding.ActivityDisplayTripBinding;

public class DisplayTrip extends AppCompatActivity {
    private ActivityDisplayTripBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDisplayTripBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        String origin= bundle.getString("origin");
        String destination = bundle.getString("destination");
        binding.varTrip.setText(String.format("%s -> %s", origin, destination));

        Double kmTraveled = bundle.getDouble("kmTraveled");
        binding.varKmTraveled.setText(String.format("%.2f km", kmTraveled));

        String powerMode = bundle.getString("powerMode");
        binding.varPowerMode.setText(powerMode);

        String assistance = bundle.getString("assistance");
        binding.varAssistance.setText(assistance);

        String time = bundle.getString("time");
        binding.varTime.setText(time);
    }
}