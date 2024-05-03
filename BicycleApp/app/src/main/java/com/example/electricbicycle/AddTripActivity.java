package com.example.electricbicycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import com.example.electricbicycle.databinding.ActivityAddTripBinding;

import java.util.Timer;
import java.util.TimerTask;

public class AddTripActivity extends AppCompatActivity {
    private ActivityAddTripBinding binding;
    private Timer timer;
    private int secondsPassed = 0;
    private double distanceTraveled = 0;
    private String powerMode = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddTripBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }


    public void startTrip(View view) {
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                secondsPassed += 1;
                distanceTraveled += 0.1;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        updateTimeTextView();
                        updateDistanceTextView();
                    }
                });
            }
        }, 0, 1000);
    }
    public void stopTrip(View view) {
        if (timer != null) {
            timer.cancel();
        }

        String origin = binding.varOrigin.getText().toString();
        String destination = binding.varDestination.getText().toString();
        String assistance = binding.varAssistance.getText().toString();

        RadioGroup radioGroupPowerModes = binding.radioGroupPowerModes;
        String powerMode = getSelectedPowerMode(radioGroupPowerModes);

        Bundle bundle = new Bundle();
        bundle.putString("origin",origin);
        bundle.putString("destination",destination );
        bundle.putString("powerMode", powerMode);
        bundle.putString("assistance", assistance);
        bundle.putString("time", calculateTime());
        bundle.putDouble("kmTraveled", distanceTraveled);

        Intent intent = new Intent();
        intent.putExtras(bundle);
        setResult(RESULT_OK, intent);
        finish();
    }

    private String calculateTime() {
        int hours = secondsPassed / 3600;
        int minutes = (secondsPassed % 3600) / 60;
        int seconds = secondsPassed % 60;
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }


    private void updateTimeTextView() {
        String timeString = calculateTime();
        binding.varTripTime.setText(timeString);
    }

    private void updateDistanceTextView() {
        String distanceString = String.format("%.1f", distanceTraveled);
        binding.varTripKmTraveled.setText(distanceString);
    }

    private String getSelectedPowerMode(RadioGroup radioGroup) {
        int checkedRadioButtonId = radioGroup.getCheckedRadioButtonId();
        if (checkedRadioButtonId == R.id.radioButton_eco) {
            return "Eco";
        } else if (checkedRadioButtonId == R.id.radioButton_normal) {
            return "Normal";
        } else if (checkedRadioButtonId == R.id.radioButton_sport) {
            return "Sport";
        } else {
            return "";
        }
    }

}