package com.sveval.wakeup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

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
}
