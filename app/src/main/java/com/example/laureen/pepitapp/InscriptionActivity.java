package com.example.laureen.pepitapp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.laureen.pepitapp.presenter.InscriptPresenter;
import com.example.laureen.pepitapp.view.InscriptView;

public class InscriptionActivity extends AppCompatActivity implements InscriptView {

    Button btnInscrip;
    InscriptPresenter inscriptPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);

        inscriptPresenter = new InscriptPresenter(this);

        btnInscrip = findViewById(R.id.btn_signup);

        btnInscrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inscriptPresenter.verifyData("aa","bb","aze","azerty","azerty");
            }
        });
    }

    public void onClickOnButtonSignUp(){
        //btnInscrip.setTextColor(Color.GREEN);
        TextView textV = findViewById(R.id.text);
        // mettre la progressbar a gone visibility
        textV.setText("T'as reussi c genial");
    }

    public void showProgressBar(){
        //affichage de la progessbar animation
        ProgressBar progressBar = findViewById(R.id.login_progress);
        progressBar.setVisibility(View.VISIBLE);
        inscriptPresenter.signup();
    }
}
