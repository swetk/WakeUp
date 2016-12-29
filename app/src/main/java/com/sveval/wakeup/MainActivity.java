package com.sveval.wakeup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<String> items = new ArrayList<>();
    public static ListView listt;
    Button btn;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //postavimo toolbar
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        TinyDB tinydb = new TinyDB(this);
        items = tinydb.getListString("ww");

        System.out.println(items);

        listt = (ListView) findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.destination_list, R.id.buttonDestionation, items);
        listt.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        //llButtons.bringToFront();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void newDestination(View view) {
        Intent intent = new Intent(MainActivity.this, UrediDestinacijo.class);
        startActivity(intent);
    }

    public void removeDestination(View view) {
        TinyDB tinydb = new TinyDB(this);
        items.remove(0);
        tinydb.putListString("ww", items);
        listt = (ListView) findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.destination_list, R.id.buttonDestionation, items);
        listt.setAdapter(adapter);
    }

}

