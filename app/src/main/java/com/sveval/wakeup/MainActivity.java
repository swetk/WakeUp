package com.sveval.wakeup;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static int buttonCount;
    public static ListView lwButtons;
    public static Button button;
    private Toolbar toolbar;
    public String[] items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        String[] items = {"kckc,", "tim", "tim je drek"};
        ListView listt = (ListView) findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.destination_list, R.id.buttonDestionation, items);
        listt.setAdapter(adapter);


        //DestinationListAdapter adapter = new DestinationListAdapter(AddNewPerson.this, R.layout.destination_list, editPersonData.getAtomPayments());
        //ListView atomPaysListView = (ListView)findViewById(R.id.listView);
        //atomPaysListView.setAdapter(adapter);

        //llButtons.addView(button);

        /*Button btnAdd = (Button) findViewById(R.id.btn_add);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doAddButton();
            }
        });
        llButtons = (LinearLayout) findViewById(R.id.ll_buttons);*/

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

    public void doAddButton(View view) {
        lwButtons = (ListView) findViewById(R.id.listView);
        Button button = new Button(this);
        button.setText("Button " + ++buttonCount);
        button.setLayoutParams(new AbsListView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        lwButtons.setAdapter((ListAdapter) button);

    }

    public void newDestination(View view) {
        Intent intent = new Intent(MainActivity.this, UrediDestinacijo.class);
        startActivity(intent);
    }
}
