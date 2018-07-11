package com.example.laureen.pepitapp;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

public class InformationActivity extends MenuActivity {

    View homeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_information);

        enhanceMenuItem(MENU1);

        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        homeView = inflater.inflate(R.layout.activity_information, null);
        content.addView(homeView);
    }
}
