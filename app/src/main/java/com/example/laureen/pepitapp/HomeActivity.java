package com.example.laureen.pepitapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeActivity extends MenuActivity {

    View homeView;

    Button buttonGoQuizz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_home);

        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        homeView = inflater.inflate(R.layout.activity_home, null);
        content.addView(homeView);

        buttonGoQuizz = findViewById(R.id.btn_go_quizz);

        // Modifier les pourcentages de jeux effectués
        TextView pourcentTextView = (TextView) findViewById(R.id.pourcent);
        //pourcentTextView.setText(this.getString(R.string.pourcentString, 67));

        TextView pourcent2TextView = (TextView) findViewById(R.id.pourcent2);
        //pourcent2TextView.setText(this.getString(R.string.pourcent2String, 10));

        TextView pourcent3TextView = (TextView) findViewById(R.id.pourcent3);
        //pourcent3TextView.setText(this.getString(R.string.pourcent3String, 0));


        buttonGoQuizz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), QuizzActivity.class);
                startActivity(intent);
            }
        });

    }




}
