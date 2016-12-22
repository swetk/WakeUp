package com.sveval.wakeup;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.sveval.wakeup.MainActivity.items;
import static com.sveval.wakeup.MainActivity.k;
import static com.sveval.wakeup.MainActivity.l;

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
        autoCompleteTextViewIztop.setAdapter(adapter2);

    }

    @Override
    protected void onStart() {
        super.onStart();
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


    public void koncajDestinacijo (View view) {
        //save data
        setVstopnaPostaja(this, autoCompleteTextViewVstopna.getText().toString());
        setIztopnaPostaja(this, autoCompleteTextViewIztop.getText().toString());
        //get data
        items.add(getVstopnaPostaja(this));
        items.add(getIztopnaPostaja(this));

        ListView listt = (ListView) findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.destination_list, R.id.buttonDestionation, items);
        listt.setAdapter(adapter);



    }

    public void goBackMain (View view) {
        Intent intent = new Intent(UrediDestinacijo.this, MainActivity.class);
        startActivity(intent);
        finish();
    }


    public static void setVstopnaPostaja(Context context, String vstopnaPostaja) {
        SharedPreferences prefs = context.getSharedPreferences("autoCompleteTextViewVstopna", 0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("autoCompleteTextViewVstopna", vstopnaPostaja);
        editor.commit();
    }

    public static String getVstopnaPostaja(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("autoCompleteTextViewVstopna", 0);
        return prefs.getString("autoCompleteTextViewVstopna", "");

    }

    public static void setIztopnaPostaja(Context context, String iztopnaPostaja) {
        SharedPreferences prefs = context.getSharedPreferences("autoCompleteTextViewIztop", 0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("autoCompleteTextViewIztop", iztopnaPostaja);
        editor.commit();
    }

    public static String getIztopnaPostaja(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("autoCompleteTextViewIztop", 0);
        return prefs.getString("autoCompleteTextViewIztop", "");

    }
}
