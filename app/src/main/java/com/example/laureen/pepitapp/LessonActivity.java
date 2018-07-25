package com.example.laureen.pepitapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

public class LessonActivity extends MenuActivity {

    View homeView;

    Button btnLinux;
    Button btnJs;
    Button btnPython;
    Button btnC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        homeView = inflater.inflate(R.layout.activity_lesson, null);
        content.addView(homeView);

        btnLinux = (Button) findViewById(R.id.learnLinux);
        btnJs = (Button) findViewById(R.id.learnJs);
        btnPython = (Button) findViewById(R.id.learnPython);
        btnC = (Button) findViewById(R.id.learnC);

        btnLinux.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://openclassrooms.com/fr/courses/43538-reprenez-le-controle-a-laide-de-linux";
                Intent link = new Intent(Intent.ACTION_VIEW);
                link.setData(Uri.parse(url));
                startActivity(link);
            }
        });

        btnJs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://openclassrooms.com/fr/courses/2984401-apprenez-a-coder-avec-javascript";
                Intent link = new Intent(Intent.ACTION_VIEW);
                link.setData(Uri.parse(url));
                startActivity(link);
            }
        });

        btnPython.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://python.sdv.univ-paris-diderot.fr/";
                Intent link = new Intent(Intent.ACTION_VIEW);
                link.setData(Uri.parse(url));
                startActivity(link);
            }
        });

        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://c.developpez.com/cours/poly-c/";
                Intent link = new Intent(Intent.ACTION_VIEW);
                link.setData(Uri.parse(url));
                startActivity(link);
            }
        });
    }
}
