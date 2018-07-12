package com.example.laureen.pepitapp;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

public class ProfilUserActivity extends MenuActivity {

    View homeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        homeView = inflater.inflate(R.layout.activity_profil_user, null);
        content.addView(homeView);

    }
}
