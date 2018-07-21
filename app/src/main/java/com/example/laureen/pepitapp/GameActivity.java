package com.example.laureen.pepitapp;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

public class GameActivity extends MenuActivity {

    View homeView;

    ImageView btnQuizz;
    ImageView btnSombrero;
    ImageView btnAdventure;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        homeView = inflater.inflate(R.layout.activity_game, null);
        content.addView(homeView);

        btnQuizz = (ImageView) findViewById(R.id.btn_gameQuizz);
        btnSombrero = (ImageView) findViewById(R.id.btn_gameSombrero);
        btnAdventure = (ImageView) findViewById(R.id.btn_gameAdventure);

        btnQuizz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnSombrero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnAdventure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*int id_user = 1;
                Intent intent = new Intent(this, com.example.androidcaller.unity.UnityPlayerActivity.class);
                intent.putExtra("ParamCallKey", id_user);

                startActivity(intent);*/
            }
        });

    }
}
