package com.example.laureen.pepitapp.presenter;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.StringRequestListener;
import com.example.laureen.pepitapp.PepitService;
import com.example.laureen.pepitapp.view.ConnectView;

import org.json.JSONException;
import org.json.JSONObject;

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

    /*public void signin(String username, String password) {
        Callback<String> loginUserCallback = new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                // TODO : décommenter le if else
                if (response.isSuccessful()) {
                    String token = response.body(); //stocker le token crypté envoyé par le serveur
                    connectView.validationData(token);
                } else {
                   Log.d("QuestionsCallback", "Code: " + response.code() + " Message: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                t.printStackTrace();
            }
        };

        JsonObject userJson = new JsonObject();
        userJson.addProperty("username", username);
        userJson.addProperty("password", password);

        Call<String> loginUser = service.loginUser(userJson);
        loginUser.enqueue(loginUserCallback);
    }*/

    public void signin(String username, String password){
        String baseUrl = "http://10.0.2.2:3000/";
        JSONObject userJson = new JSONObject();
        try {
            userJson.put("username", username);
            userJson.put("password", password);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        AndroidNetworking.post(baseUrl+"auth/signin")
                .addJSONObjectBody(userJson)
                .setTag("Connect")
                .build()
                .getAsString(new StringRequestListener() {
                    @Override
                    public void onResponse(String response) {
                        String token = response; //stocker le token crypté envoyé par le serveur
                        connectView.validationData(token);
                    }

                    @Override
                    public void onError(ANError anError) {
                        anError.printStackTrace();
                    }
                });
    }
}
