package com.example.laureen.pepitapp.presenter;

import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.example.laureen.pepitapp.PepitService;
import com.example.laureen.pepitapp.model.User;
import com.example.laureen.pepitapp.view.ConnectView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

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
                //if (response.isSuccessful()) {
                    connectView.validationData();
                //} else {
                   // Log.d("QuestionsCallback", "Code: " + response.code() + " Message: " + response.message());
               // }
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
