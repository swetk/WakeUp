package com.sveval.wakeup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private LinearLayout llButtons;
    private int buttonCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

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
        Button btnAdd = (Button) findViewById(R.id.btn_add);
        llButtons = (LinearLayout) findViewById(R.id.ll_buttons);
        Button button = new Button(this);
        button.setText("Button " + ++buttonCount);
        button.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        llButtons.addView(button);
    }

    public void newDestination(View view) {
        Intent intent = new Intent(MainActivity.this, UrediDestinacijo.class);
        startActivity(intent);
        finish();
    }
}
