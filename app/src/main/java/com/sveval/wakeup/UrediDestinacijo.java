package com.sveval.wakeup;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class UrediDestinacijo extends AppCompatActivity {

    AutoCompleteTextView autoCompleteTextViewVstopna;
    AutoCompleteTextView autoCompleteTextViewIztop;
    String[] imenaPostaj;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uredi_destinacijo);

        autoCompleteTextViewVstopna = (AutoCompleteTextView) findViewById(R.id.vstopnaPostaja);
        imenaPostaj = getResources().getStringArray(R.array.postaje);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, imenaPostaj);
        autoCompleteTextViewVstopna.setAdapter(adapter);

        autoCompleteTextViewIztop = (AutoCompleteTextView) findViewById(R.id.iztopnaPostaja);
        imenaPostaj = getResources().getStringArray(R.array.postaje);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, imenaPostaj);
        autoCompleteTextViewIztop.setAdapter(adapter2);

    }

    public void koncajDestinacijo(View view) {
        //save data
        setVstopnaPostaja(this, autoCompleteTextViewVstopna.getText().toString());
        setIztopnaPostaja(this, autoCompleteTextViewIztop.getText().toString());
        //get data
        Destination.destinations.add(new Destination(getVstopnaPostaja(this), getIztopnaPostaja(this)));

        finish();
    }

    public void goBackMain(View view) {
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
