package com.example.laureen.pepitapp.presenter;

import android.util.Log;

import com.example.laureen.pepitapp.PepitService;
import com.example.laureen.pepitapp.model.User;
import com.example.laureen.pepitapp.view.InscriptView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
    public void verifyData(String lastname, String firstname, String username, String email, String password, String confirmPassword, Integer age){
        if(lastname.equals("") || firstname.equals("") || username.equals("") || email.equals("") || password.equals("") || confirmPassword.equals("") || (age < 12 && age > 80)) {
            inscriptView.failedVerif();
        }
        else if (!password.equals(confirmPassword)){
                inscriptView.failedVerifPassword();
        }
        else {
                inscriptView.validationData(firstname, lastname, username, password, confirmPassword, age, email);
                signup(firstname, lastname, username, password, confirmPassword, age, email);
        }
    }

    public void signup(String firstname, String lastname, String username, String password, String confirmPassword, int age, String email){

        Callback<List<User>> userCallback = new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if (response.isSuccessful()) {
                    // TODO :
                } else {
                    Log.d("QuestionsCallback", "Code: " + response.code() + " Message: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                t.printStackTrace();
            }
        };

        Callback<User> createUserCallback = new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    // TODO
                } else {
                    Log.d("QuestionsCallback", "Code: " + response.code() + " Message: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                t.printStackTrace();
            }
        };

        /*Call<List<User>> list = service.getUser();
        list.enqueue(userCallback);*/

        //Call<User> createUser = service.createUser(new User("Escape", "game", "fun", "azerty", "azerty", 21, "fun@gmail.com", "ninja", 1));
        //Call<User> createUser = service.createUser(new User(firstname, lastname, username, password, confirmPassword, age, email, "junior", 1));
        //createUser.enqueue(createUserCallback);
    }

}
