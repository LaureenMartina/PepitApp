package com.example.laureen.pepitapp.presenter;

import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.StringRequestListener;
import com.example.laureen.pepitapp.PepitService;
import com.example.laureen.pepitapp.view.InscriptView;

import org.json.JSONException;
import org.json.JSONObject;

public class InscriptPresenter {

    public InscriptView inscriptView;
    private static final String TAG = "SignUpActivity";
    private PepitService service;

    //constructeur
    public InscriptPresenter(InscriptView inscriptView, PepitService service) {
        this.inscriptView = inscriptView;
        this.service = service;
    }

    // fonction vérifiant le remplissage du formulaire d'inscription
    public void verifyData(String username, String lastname, String firstname, String email, String password, String confirmPassword, Integer age){
        if(username.equals("") || lastname.equals("") || firstname.equals("") || email.equals("") || password.equals("") || confirmPassword.equals("") || (age < 12 && age > 80)) {
            inscriptView.failedVerif();
        }
        else if (!password.equals(confirmPassword)){
            inscriptView.failedVerifPassword();
        }
        else {
            signup(username, firstname, lastname, password, confirmPassword, age, email);
        }
    }

    public void signup(String username, String firstname, String lastname, String password, String confirmPassword, int age, String email){
        String baseUrl = "http://10.0.2.2:3000/";
        JSONObject userJson = new JSONObject();
        try {
            userJson.put("username", username);
            userJson.put("firstname", firstname);
            userJson.put("lastname", lastname);
            userJson.put("password", password);
            userJson.put("confirmPassword", confirmPassword);
            userJson.put("age", age);
            userJson.put("email", email);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        Log.e("username:", username);
        Log.e("lastname:", lastname);

        AndroidNetworking.post(baseUrl+"auth/signup")
                .addJSONObjectBody(userJson)
                .setTag("Inscription")
                .build()
                .getAsString(new StringRequestListener() {
                    @Override
                    public void onResponse(String response) {
                        String token = response; //stocker le token crypté envoyé par le serveur
                        inscriptView.validationData(token);
                    }

                    @Override
                    public void onError(ANError anError) {
                        anError.printStackTrace();
                    }
                });

    }

}
