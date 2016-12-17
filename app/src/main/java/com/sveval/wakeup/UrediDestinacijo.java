package com.sveval.wakeup;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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

    AutoCompleteTextView autoCompleteTextViewVstopna;
    AutoCompleteTextView autoCompleteTextViewIztop;
    String[] imenaPostaj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uredi_destinacijo);

        autoCompleteTextViewVstopna = (AutoCompleteTextView) findViewById(R.id.vstopnaPostaja);
        imenaPostaj = getResources().getStringArray(R.array.postaje);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,imenaPostaj);
        autoCompleteTextViewVstopna.setAdapter(adapter);

        autoCompleteTextViewIztop = (AutoCompleteTextView) findViewById(R.id.iztopnaPostaja);
        imenaPostaj = getResources().getStringArray(R.array.postaje);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,imenaPostaj);
        autoCompleteTextViewVstopna.setAdapter(adapter2);

    }

    public void getBackMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void koncajDestinacijo (View view) {
        setVstopnaPostaja(this, autoCompleteTextViewVstopna.getText().toString());
        autoCompleteTextViewIztop.getText(getVstopnaPostaja(this));
    }

    public static void setVstopnaPostaja(Context context, String vstopnaPostaja) {
        SharedPreferences prefs = context.getSharedPreferences("autoCompleteTextViewVstopna", 0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("autoCompleteTextViewVstopna", vstopnaPostaja);
        editor.commit();
    }

    public static String getVstopnaPostaja(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("vstopnaPostaja", 0);
        return prefs.getString("vstopnaPostaja", "");

    }
}
