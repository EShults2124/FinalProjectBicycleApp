package com.example.back4appmvcsubactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.back4appmvcsubactivity.Model.Trip;

import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


import com.example.back4appmvcsubactivity.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private static final int SHOW_EDIT_ACTIVITY = 1;
    private static final int SHOW_ADD_ACTIVITY = 2;
    private ListView listView;
    TripsApplication tpa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);
        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(tpa, AddPointActivity.class);
                startActivityForResult(intent, SHOW_ADD_ACTIVITY);
            }
        });

        listView = (ListView) findViewById(R.id.list);
        tpa = (TripsApplication)getApplicationContext();

        tpa.getServerPointsUpdate(listView);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Trip item = (Trip) listView.getItemAtPosition(position);
                Bundle bundle = new Bundle();
                bundle.putInt("position", position);
                bundle.putDouble("latitud", item.getLatitud());
                bundle.putDouble("longitud", item.getLongitud());
                bundle.putDouble("kmTotales", item.getKmTotales());
                Intent intent = new Intent(tpa, DisplayActivity.class);
                intent.putExtras(bundle);
                startActivityForResult(intent, SHOW_EDIT_ACTIVITY);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

       if (id == R.id.action_get) {
               tpa.getServerPointsUpdate(listView);
        }
        if (id == R.id.action_new) {
                Intent intent = new Intent(tpa, AddPointActivity.class);
                startActivityForResult(intent, SHOW_ADD_ACTIVITY);
        }
        return super.onOptionsItemSelected(item);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == SHOW_EDIT_ACTIVITY) {
                Bundle bundle = data.getExtras();
                String name = bundle.getString("name");
                int position = bundle.getInt("position");
                Trip item = (Trip) listView.getItemAtPosition(position);
                item.setNombre(name);

                tpa.updateObjectUpdate(item,listView);


            } else if (requestCode == SHOW_ADD_ACTIVITY) {
                Bundle bundle = data.getExtras();
                Double latitud = bundle.getDouble("latitud");
                Double longitud = bundle.getDouble("longitud");
                Double kmTotales = bundle.getDouble("kmTotales");
                Trip aTrip = new Trip();
                //aInterestPoint.setNombre(name);
                aTrip.setLatitud(latitud);
                aTrip.setLongitud(longitud);
                aTrip.setKmTotales(kmTotales);

                tpa.addObjectUpdate(aTrip,listView);

            }

        }
    }




}