package com.example.laureen.pepitapp;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

public class HomeActivity extends MenuActivity {

    View homeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_home);

        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            homeView = inflater.inflate(R.layout.activity_home, null);
        content.addView(homeView);

        TextView pourCentTextView = (TextView) findViewById(R.id.pourcent);
        pourCentTextView.setText(this.getString(R.string.pourcentString, 67));
    }

}
