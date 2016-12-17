package com.sveval.wakeup;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import android.view.ViewGroup.LayoutParams;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UrediDestinacijo extends AppCompatActivity {

    AutoCompleteTextView autoCompleteTextView;
    String[] imenaPostaj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uredi_destinacijo);

        autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.vstopnaPostaja);
        imenaPostaj = getResources().getStringArray(R.array.postaje);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,imenaPostaj);
        autoCompleteTextView.setAdapter(adapter);

        autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.iztopnaPostaja);
        imenaPostaj = getResources().getStringArray(R.array.postaje);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,imenaPostaj);
        autoCompleteTextView.setAdapter(adapter2);

    }

    public void getBackMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void koncajDestinacijo (View view) {
                Random r = new Random();
                int id = (r.nextInt(100)+1);    //generira random id
                RelativeLayout layout = (RelativeLayout) findViewById(R.id.activity_main);
                Button createdButton = new Button(this);
                createdButton.setText("Ljubljana-Maribor");
                createdButton.setId(id);
                layout.addView(createdButton);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
