package com.example.laureen.pepitapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultQuizzActivity extends AppCompatActivity {

    private String score;

    Button backGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_quizz);

        Intent intent = getIntent();
        score = intent.getStringExtra("score");

        TextView scoreTv = findViewById(R.id.score_player);
        scoreTv.setText(score);

        backGame = findViewById(R.id.btnBackQuizz);

        backGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultQuizzActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}
