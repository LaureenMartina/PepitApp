package com.example.laureen.pepitapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.example.laureen.pepitapp.model.SaveUserDataPreferences;
import com.example.laureen.pepitapp.presenter.ProfilUserPresenter;
import com.example.laureen.pepitapp.view.ProfilUserView;

import java.util.Locale;

import static com.example.laureen.pepitapp.model.SaveUserDataPreferences.PREF_USERNAME;

public class HomeActivity extends MenuActivity implements ProfilUserView {

    View homeView;

    ImageView imgProfil;
    TextView experience;
    TextView levelUser;
    TextView username;

    //Switch fr;
    //Button lang;

    private ProfilUserPresenter profilUserPresenter;
    private ProfilUserView dataUser;
    public int typeProfilUser;
    //public String lang;
    Button buttonGoQuizz;
    Button buttonGoSombrero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        homeView = inflater.inflate(R.layout.activity_home, null);
        content.addView(homeView);

        imgProfil = findViewById(R.id.imgProfil);
        experience = findViewById(R.id.nbExp);
        levelUser = findViewById(R.id.nbLevel);
        username = findViewById(R.id.nameGamer);
        buttonGoQuizz = findViewById(R.id.btn_go_quizz);
        buttonGoSombrero = findViewById(R.id.btn_go_sombrero);

        username.setText(PREF_USERNAME);

        //lang = findViewById(R.id.change);
        /*lang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LocaleManager.setLocale(this);
                finish();
                startActivity(new Intent(HomeActivity.this, MainActivity.class));
            }
        });*/
        });

        buttonGoSombrero.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SombreroListActivity.class);
                startActivity(intent);
            }
        });

        profilUserPresenter = new ProfilUserPresenter((ProfilUserView) this);
        profilUserPresenter.getProfilUser(this);
    }

    @Override
    public void setExpUser(int exp) {
        experience.setText(String.valueOf(exp));

        if(exp < 2500){
            levelUser.setText("Débutant");
        }else if(exp > 2500 && exp < 7000){
            levelUser.setText("Intermédiaire");
        }else if(exp > 7000 && exp < 12000){
            levelUser.setText("Pro");
        }else {
            levelUser.setText("Avancé");
        }
    }

    @Override
    public void setProfilIdUser(int profilIdUser) {
        switch (profilIdUser){
            case 1:
                imgProfil.setImageDrawable(getResources().getDrawable(R.drawable.ninja));
                break;
            case 2:
                imgProfil.setImageDrawable(getResources().getDrawable(R.drawable.prof));
                break;
            case 3:
                imgProfil.setImageDrawable(getResources().getDrawable(R.drawable.explorer));
                break;
            default:
                break;
        }
    }

    @Override
    public void setLevelUser(int levelUser) {}

}
