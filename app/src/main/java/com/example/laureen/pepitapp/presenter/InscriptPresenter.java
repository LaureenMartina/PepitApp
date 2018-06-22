package com.example.laureen.pepitapp.presenter;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.example.laureen.pepitapp.PepitService;
import com.example.laureen.pepitapp.model.User;
import com.example.laureen.pepitapp.view.InscriptView;

import org.json.JSONException;
import org.json.JSONObject;

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
        } else {
            if (!password.equals(confirmPassword)){
                inscriptView.failedVerifPassword();
            } else {
                inscriptView.validationData(firstname, lastname, username, password, confirmPassword, age, email);
            }
        }
    }

    public void signup(String firstname, String lastname, String username, String password, String confirmPassword, int age, String email){

        Callback<List<User>> userCallback = new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if (response.isSuccessful()) {

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
        Call<User> createUser = service.createUser(new User(firstname, lastname, username, password, confirmPassword, age, email, "junior", 1));
        createUser.enqueue(createUserCallback);

        /*com.androidnetworking.common.ANRequest.PostRequestBuilder obj = AndroidNetworking.post("http://192.168.1.18:3000/auth/signup/")
                .addHeaders("content-Type", "application/json")
                .addBodyParameter("lastname", "oreo2")
                .addBodyParameter("firstname", "kitkat")
                .addBodyParameter("username", "biscuit")
                .addBodyParameter("password", "azerty")
                .addBodyParameter("confirmPassword", "azerty")
                .addBodyParameter("mail", "oreo@gmail.com")
                .addBodyParameter("age", "15")
                .addBodyParameter("profil", "ninja")
                .addBodyParameter("userType", "1")
                 .setTag("test")
                .setPriority(Priority.LOW);
                obj.build()
                .getAsJSONObject(new JSONObjectRequestListener() { //get reponse sous forme de json
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d(TAG, "onResponse: response : >" + response.toString());
                        inscriptView.onClickOnButtonSignUp();//affichage visuel
                        try {
                            String token = (String) response.get("token");
                            //JsonParser parser = new JsonParser();
                            //JsonElement arr = parser.parse(array.toString());
                            //Gson gson = new GsonBuilder().create();
                            //Quizz[] questions = gson.fromJson(arr, Quizz[].class);
                            //Log.d(TAG, "onResponse: " + questions[0].toString());
                            //questionOfQuizz = questions[0].getQuestion().toString();
                            //questionQuizz.setText(questionOfQuizz);

                            //System.out.println(questions[1].getQuestion().toString()); //Incrementer question pour questionnaire
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(ANError error) {
                        Log.d(TAG, "onError: " + error);
                    }
                });*/
    }

}
