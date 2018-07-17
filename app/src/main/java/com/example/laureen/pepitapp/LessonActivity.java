package com.example.laureen.pepitapp;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

public class LessonActivity extends MenuActivity {

    View homeView;

    Button btnLinux;
    Button btnJs;
    Button btnPython;
    Button btnC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        homeView = inflater.inflate(R.layout.activity_lesson, null);
        content.addView(homeView);

        btnLinux = (Button) findViewById(R.id.learnLinux);
        btnJs = (Button) findViewById(R.id.learnJs);
        btnPython = (Button) findViewById(R.id.learnPython);
        btnC = (Button) findViewById(R.id.learnC);

        btnLinux.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnJs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnPython.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
