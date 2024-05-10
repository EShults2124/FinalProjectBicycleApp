package com.example.back4appmvcsubactivity;

import android.app.Application;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;

import com.example.back4appmvcsubactivity.Model.Trip;
import com.parse.Parse;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

public class TripsApplication extends Application {
    private List<Trip> local_pointList = new ArrayList<>();

    @Override
    public void onCreate() {
        super.onCreate();

        ParseObject.registerSubclass(Trip.class);

		Parse.initialize(new Parse.Configuration.Builder(getApplicationContext())
                .applicationId(getString(R.string.back4app_app_id))
                .clientKey(getString(R.string.back4app_client_key))
                .server(getString(R.string.back4app_server_url))
                .build());
    }

    public void getServerPointsUpdate(ListView listView) {

        ParseQuery<Trip> query = ParseQuery.getQuery("Trip");
        query.findInBackground((objects, e) -> {
            if (e == null) {
                local_pointList = objects;
                ArrayAdapter<Trip> pointItemsAdapter =
                        new ArrayAdapter<Trip>(listView.getContext(),R.layout.row_layout,
                                R.id.listText,local_pointList);
                listView.setAdapter(pointItemsAdapter);
                pointItemsAdapter.notifyDataSetChanged();

                Log.d("object query server OK:", "getServerPointsUpdate()");
            } else {
                Log.d("fail query, reason: " + e.getMessage(), "getServerPointsUpdate()");
            }
        });
    }

    public void addObjectUpdate(@NonNull Trip aTrip, ListView listView) {

        aTrip.saveInBackground(e -> {
            if (e == null) {
                local_pointList.add(aTrip);
                ArrayAdapter<Trip> pointItemsAdapter =
                        new ArrayAdapter<Trip>(listView.getContext(),R.layout.row_layout,
                                R.id.listText,local_pointList);
                listView.setAdapter(pointItemsAdapter);
                pointItemsAdapter.notifyDataSetChanged();
                
                Log.d("object saved server OK:", "addObjectUpdate()");
            } else {
                Log.d("fail save, reason: "+ e.getMessage(), "addObjectUpdate()");
            }
        });
    }

    public void updateObjectUpdate(@NonNull Trip aTrip, ListView listView) {

        aTrip.saveInBackground(e -> {
            if (e == null) {
         //       local_pointList.add(aInterestPoint);
                ArrayAdapter<Trip> pointItemsAdapter;
                pointItemsAdapter = (ArrayAdapter<Trip>) listView.getAdapter();
                pointItemsAdapter.notifyDataSetChanged();
                
                Log.d("object updated srv OK:", "updateObjectUpdate()");
            } else {
                Log.d("fail update, reason: "+ e.getMessage(), "updateObjectUpdate()");
            }
        });
    }


}
