package com.eso.memorableplaces;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView mListView;
    public static List<String> places;
    public static List<LatLng> location;
    public static ArrayAdapter<? extends String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = findViewById(R.id.listView);
        places = new ArrayList<>();
        location = new ArrayList<>();
        places.add("Add a new place...");
        location.add(new LatLng(0,0));
        arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,places);
        mListView.setAdapter(arrayAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(getApplicationContext(),MapsActivity.class).putExtra("placeNumber",position));
            }
        });
    }
}
