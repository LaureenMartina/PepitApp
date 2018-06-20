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

import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements MainView {

    MainPresenter mainPresenter;
    ImageView gif;
    Button inscrip;
    Button connexion;

    public static retrofit2.Retrofit retrofit;
    public static PepitService pepitService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //instancier le Presenter de Main
        mainPresenter = new MainPresenter(this);

        //gif = findViewById(R.id.gif);
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
        okhttp3.OkHttpClient client = new okhttp3.OkHttpClient().newBuilder().build();

        com.androidnetworking.AndroidNetworking.initialize(getApplicationContext(), client);

        retrofit = new retrofit2.Retrofit.Builder()
                //.baseUrl("http://192.168.1.18:3000/")
                .baseUrl("http://10.33.1.196:3000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        pepitService = retrofit.create(PepitService.class);
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
