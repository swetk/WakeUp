package com.sveval.wakeup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import java.util.ArrayList;
import java.util.List;

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
}
