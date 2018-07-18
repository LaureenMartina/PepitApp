package com.example.laureen.pepitapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultQuizzActivity extends AppCompatActivity {

    private String score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_quizz);

        Intent intent = getIntent();
        score = intent.getStringExtra("score");

        TextView scoreTv = findViewById(R.id.score_player);
        scoreTv.setText(score);
    }
}
