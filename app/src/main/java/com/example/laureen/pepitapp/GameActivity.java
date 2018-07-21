package com.example.laureen.pepitapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

public class GameActivity extends MenuActivity {

    View homeView;


    ImageView btnSombrero;
    ImageView btnAdventure;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        homeView = inflater.inflate(R.layout.activity_game, null);
        content.addView(homeView);

        ImageView btnQuizz = findViewById(R.id.btn_gameQuizz);
        ImageView btnSombrero = findViewById(R.id.btn_gameSombrero);
        btnAdventure = (ImageView) findViewById(R.id.btn_gameAdventure);


        btnQuizz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Quizz imv click", null);
                Intent intent = new Intent(getApplicationContext(), QuizzActivity.class);
                startActivity(intent);

            }
        });

        btnSombrero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Sombrero imv click", null);
                Intent intent = new Intent(getApplicationContext(), SombreroListActivity.class);
                startActivity(intent);
            }
        });

        btnAdventure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });





    }
}
