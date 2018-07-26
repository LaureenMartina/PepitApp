package com.example.laureen.pepitapp;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.laureen.pepitapp.presenter.MainPresenter;
import com.example.laureen.pepitapp.view.MainView;

import java.util.ArrayList;

import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements MainView {

    MainPresenter mainPresenter;
    ImageView gif;
    Button inscrip;
    Button connexion;

    public static retrofit2.Retrofit retrofit;
    public static PepitService pepitService;

    private static String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //instancier le Presenter de Main
        mainPresenter = new MainPresenter(this);

        inscrip = findViewById(R.id.inscription);
        connexion = findViewById(R.id.connexion);

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
                .baseUrl("http://10.0.2.2:3000/")
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
