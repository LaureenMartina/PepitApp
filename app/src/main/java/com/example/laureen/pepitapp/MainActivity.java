package com.example.laureen.pepitapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.laureen.pepitapp.presenter.MainPresenter;
import com.example.laureen.pepitapp.view.MainView;

public class MainActivity extends AppCompatActivity implements MainView {

    MainPresenter mainPresenter;
    ImageView gif;
    Button inscrip;
    Button connexion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //instancier le Presenter de Main
        mainPresenter = new MainPresenter(this);

        gif = findViewById(R.id.gif);
        inscrip = findViewById(R.id.inscription);
        connexion = findViewById(R.id.connexion);

        //animation et insertion du gif
        //Glide
                //.with(this)
                //.load(R.drawable.giphy) //mettre un gif dans le activity xml
                //.load(internetUrl)
                //.into(gif);

        inscrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoInscription();
            }
        });

        connexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoConnexion();
            }
        });
    }

    @Override
    public void gotoConnexion() {
        Intent intent = new Intent(MainActivity.this, ConnexionActivity.class);
        startActivity(intent);
    }

    @Override
    public void gotoInscription() {
        Intent intent = new Intent(MainActivity.this, InscriptionActivity.class);
        startActivity(intent);
    }
}
