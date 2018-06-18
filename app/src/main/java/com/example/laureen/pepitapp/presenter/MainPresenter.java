package com.example.laureen.pepitapp.presenter;

import com.example.laureen.pepitapp.view.MainView;

public class MainPresenter {
    public MainView mainView;

    public MainPresenter(MainView mainView) {
        this.mainView = mainView;
    }

    public boolean verifConnexion(String pseudo, String password){
        return true;
    }
}
