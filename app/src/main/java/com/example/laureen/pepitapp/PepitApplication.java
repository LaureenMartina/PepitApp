package com.example.laureen.pepitapp;

import android.app.Application;

import com.androidnetworking.AndroidNetworking;

public class PepitApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AndroidNetworking.initialize(this);
    }
}
