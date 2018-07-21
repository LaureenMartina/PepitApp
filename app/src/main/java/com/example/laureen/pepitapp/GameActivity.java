package com.example.laureen.pepitapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.laureen.pepitapp.model.Quizz;
import com.example.laureen.pepitapp.presenter.ProfilUserPresenter;
import com.example.laureen.pepitapp.view.ProfilUserView;
import com.example.laureen.pepitapp.view.TestPersonalityUserView;

import butterknife.BindView;
import butterknife.OnClick;

public class GameActivity extends MenuActivity implements ProfilUserView {

    View homeView;
    private ProfilUserPresenter profilUserPresenter;
    private int userExp;
    private int idTypeProfil;

    private int ID_FIRST_CONNEXION = 0;


    ImageView btnSombrero;
    ImageView btnAdventure;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        homeView = inflater.inflate(R.layout.activity_game, null);
        content.addView(homeView);

        profilUserPresenter = new ProfilUserPresenter(this);
        profilUserPresenter.getProfilLUser(this);

        if (idTypeProfil == ID_FIRST_CONNEXION){
            dialogNewPlayer();
        }





        ImageView btnQuizz = findViewById(R.id.btn_gameQuizz);
        btnSombrero = (ImageView) findViewById(R.id.btn_gameSombrero);
        btnAdventure = (ImageView) findViewById(R.id.btn_gameAdventure);


        btnQuizz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), QuizzActivity.class);
                startActivity(intent);

            }
        });

        btnSombrero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Sombrero imv click", " ");
            }
        });

        btnAdventure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }

    @Override
    public void setExpUser(int exp) {
        this.userExp = exp;

    }

    @Override
    public void setProfilIdUser(int profilIdUser) {
        this.idTypeProfil = profilIdUser;
    }


    public void dialogNewPlayer() {
        //POPUP
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(this, android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(this);
        }
        builder.setTitle("Bienvenue sur notre application !")
                .setMessage("Pour vos premier pas sur notre application nous avons besoin d'en savoir plus sur vous, Pour cela lancer notre test de personalité")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(GameActivity.this, TestPersonalityUserActivity.class);
                        startActivity(intent);
                    }
                })

                .setIcon(android.R.drawable.ic_dialog_info)
                .show();
    }
}
