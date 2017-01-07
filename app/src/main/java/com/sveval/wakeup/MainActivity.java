package com.sveval.wakeup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    public static TinyDB tinydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //postavimo toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tinydb = new TinyDB(this);
        System.out.println("zagon onCreate");
    }

    public void populateDestinationList() {
        ArrayList<Destination> arrayDestination = Destination.getDestinations();
        DestinationsAdapter adapter = new DestinationsAdapter(this, arrayDestination);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
    }

    public void newDestination(View view) {
        Intent intent = new Intent(MainActivity.this, UrediDestinacijo.class);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("zagon onResume");
        populateDestinationList();
    }
}

