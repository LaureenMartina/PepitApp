package com.example.laureen.pepitapp;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class RateActivity extends MenuActivity {

    View homeView;

    RatingBar ratingBar;
    TextView textValue;
    Button validateRate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        homeView = inflater.inflate(R.layout.activity_rate, null);
        content.addView(homeView);

        listenerOnRatingBar();
    }

    public void listenerOnRatingBar() {

        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        textValue = (TextView) findViewById(R.id.textRate);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                switch (String.valueOf(rating)){
                    case "1.0":
                        textValue.setText("Pas Mal !");
                        ratingBar.setRating(1);
                        break;
                    case "2.0":
                        textValue.setText("Très Bien !");
                        ratingBar.setRating(2);
                        break;
                    case "3.0":
                        textValue.setText("Super !");
                        ratingBar.setRating(3);
                        break;
                    case "4.0":
                        textValue.setText("Excellent !!");
                        ratingBar.setRating(4);
                        break;
                    default:
                        textValue.setText("Vous n'avez pas encore noté notre application");
                        ratingBar.setRating(0);
                        break;
                }
            }
        });
    }
}
