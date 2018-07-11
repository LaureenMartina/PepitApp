package com.example.laureen.pepitapp.presenter;

import com.example.laureen.pepitapp.PepitService;
import com.example.laureen.pepitapp.view.ConnectView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ConnectPresenter {

    public ConnectView connectView;
    private static final String TAG = "SignInActivity";
    private PepitService service;

    public ConnectPresenter(ConnectView connectView, PepitService service) {
        this.connectView = connectView;
        this.service = service;
    }

    public void verifyData(String username, String password){
        if(username.equals("") || password.equals("")){
            //TODO show msg
        } else {
            signin(username, password);
        }
    }

    public void signin(String username, String password) {
        Callback<String> loginUserCallback = new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                // TODO : décommenter le if else
                //if (response.isSuccessful()) {
                    String token = response.body(); //stocker le token crypté envoyé par le serveur
                    connectView.validationData(token);
                /*} else {
                   Log.d("QuestionsCallback", "Code: " + response.code() + " Message: " + response.message());
                }*/
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                t.printStackTrace();
            }
        };

        Call<String> loginUser = service.loginUser(username, password);
        loginUser.enqueue(loginUserCallback);
    }
}
