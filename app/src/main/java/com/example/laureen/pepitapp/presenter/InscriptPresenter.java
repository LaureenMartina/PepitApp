package com.example.laureen.pepitapp.presenter;

import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.example.laureen.pepitapp.view.InscriptView;

import org.json.JSONException;
import org.json.JSONObject;

public class InscriptPresenter {

    public InscriptView inscriptView;
    private static final String TAG = "SignUpActivity";

    //constructeur
    public InscriptPresenter(InscriptView inscriptView) {
        this.inscriptView = inscriptView;
    }

    public void verifyData(String lastname, String firstname, String pseudo, String password, String confirmPassword){
        if(lastname == "" || firstname == "" || pseudo == "" || password == ""){
            //show msg
        } else {
            if (password != confirmPassword){
                //show msg
            } else {
                //return true;
                inscriptView.showProgressBar();
            }
        }
    }

    public void signup(/*String lastname, String firstname, String pseudo, String password, String confirmPassword*/){
        AndroidNetworking.post("http://localhost:3000/auth/signup")
                .addBodyParameter("lastname", "oreo")
                .addBodyParameter("firstname", "kitkat")
                .addBodyParameter("pseudo", "biscuit")
                .addBodyParameter("password", "azerty")
                .addBodyParameter("confirmPassword", "azerty")
                .setPriority(Priority.LOW)
                .build()
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
                        inscriptView.onClickOnButtonSignUp();//affichage visuel
                        Log.d(TAG, "onError: " + error);
                    }
                });
    }
}
