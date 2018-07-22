package com.example.laureen.pepitapp;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.laureen.pepitapp.presenter.ProfilUserPresenter;
import com.example.laureen.pepitapp.view.ProfilUserView;

public class HomeActivity extends MenuActivity implements ProfilUserView {

    View homeView;

    ImageView imgProfil;
    TextView experience;
    TextView levelUser;

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

        //experience.setText("blabla");

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
    public void setLevelUser(int levelUser) {

    }
}
