package com.example.laureen.pepitapp;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.example.laureen.pepitapp.presenter.ProfilUserPresenter;
import com.example.laureen.pepitapp.view.ProfilUserView;

import java.util.Locale;

public class HomeActivity extends MenuActivity implements ProfilUserView {

    View homeView;

    ImageView imgProfil;
    TextView experience;
    TextView levelUser;
    Switch fr;
    Switch en;

    private ProfilUserPresenter profilUserPresenter;

    public int typeProfilUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        homeView = inflater.inflate(R.layout.activity_home, null);
        content.addView(homeView);

        imgProfil = findViewById(R.id.imgProfil);
        experience = findViewById(R.id.nbExp);
        levelUser = findViewById(R.id.nbLevel);

        fr = findViewById(R.id.switchFr);
        en = findViewById(R.id.switchEn);

        fr.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                en.setChecked(false);
                changeLanguage("fr");
            }
        });

        en.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                fr.setChecked(false);
                en.setChecked(true);
                changeLanguage("en");
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

    public void changeLanguage (String languageSelected) {
        Locale locale = new Locale(languageSelected);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale= locale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
    }
}
