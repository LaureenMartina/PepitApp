package com.example.laureen.pepitapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.laureen.pepitapp.presenter.ConnectPresenter;
import com.example.laureen.pepitapp.presenter.InscriptPresenter;
import com.example.laureen.pepitapp.view.ConnectView;

public class ConnexionActivity extends AppCompatActivity implements ConnectView {

    Button btnConnexion;
    ConnectPresenter connectPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);

        connectPresenter = new ConnectPresenter(this);

        btnConnexion = findViewById(R.id.btn_signin);

        btnConnexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //connectPresenter.verifyData("aa","bb","aze","azerty","azerty");
            }
        });
    }

    public void onClickOnButtonSignIn(){
        //btnInscrip.setTextColor(Color.GREEN);
        TextView textV = findViewById(R.id.text);
        // mettre la progressbar a gone visibility
        textV.setText("T'as reussi c genial");
    }
}
