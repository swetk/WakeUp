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

        Button buttonTest = (Button) findViewById(R.id.button2);
        buttonTest.setText(getVstopnaPostaja(this) + " - " + getIztopnaPostaja(this));

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
        setVstopnaPostaja(this, autoCompleteTextViewVstopna.getText().toString());
        setIztopnaPostaja(this, autoCompleteTextViewIztop.getText().toString());
/*
        //generira random id
        Random r = new Random();
        int id = (r.nextInt(100)+1);

        RelativeLayout layout = (RelativeLayout) findViewById(R.id.activity_main);
        Button b = new Button(this);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        b.setLayoutParams(params);
        b.setText("Button");
        layout.addView(b);

*/

        /*Button buttonKoncaj = (Button) findViewById(R.id.buttonKoncaj);
        buttonKoncaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doAddButton();
            }
        });
        LinearLayout llButtons = (LinearLayout) findViewById(R.id.ll_buttons);

        MainActivity.lwButtons = (ListView) findViewById(R.id.listView);
        MainActivity.button = new Button(this);
        MainActivity.button.setText("Button " + ++MainActivity.buttonCount);
        MainActivity.button.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        MainActivity.lwButtons.addView(MainActivity.button);*/

        Button buttonTest = (Button) findViewById(R.id.buttonDestionation);
        buttonTest.setText(getVstopnaPostaja(this) + " - " + getIztopnaPostaja(this));

        //pojdi na main
        Intent back = new Intent(UrediDestinacijo.this, MainActivity.class);
        //startActivity(back);
        //finish();
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
