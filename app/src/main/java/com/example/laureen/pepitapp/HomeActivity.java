package com.example.laureen.pepitapp;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.laureen.pepitapp.model.User;

public class HomeActivity extends MenuActivity {

    View homeView;

    ImageView imgProfil;


    public int typeProfilUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        homeView = inflater.inflate(R.layout.activity_home, null);
        content.addView(homeView);

        imgProfil = findViewById(R.id.imgProfil);

        User profil = new User();
        int idProfil = profil.getId_type_profil();

        switch (idProfil){
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



        TextView pourcentTextView = (TextView) findViewById(R.id.pourcent);
        //pourcentTextView.setText(this.getString(R.string.pourcentString, 67));
        TextView pourcent2TextView = (TextView) findViewById(R.id.pourcent2);
        TextView pourcent3TextView = (TextView) findViewById(R.id.pourcent3);
    }
}
