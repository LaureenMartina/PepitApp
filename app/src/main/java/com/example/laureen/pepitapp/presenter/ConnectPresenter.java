package com.example.laureen.pepitapp.presenter;

import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.example.laureen.pepitapp.view.ConnectView;

import org.json.JSONException;
import org.json.JSONObject;

public class ConnectPresenter {

    public ConnectView connectView;
    private static final String TAG = "SignInActivity";

    public ConnectPresenter(ConnectView connectView) {
        this.connectView = connectView;
    }


    public void signin(/*String username, String password*/) {
        AndroidNetworking.post("http://localhost:3000/auth/signup")
                .addBodyParameter("username", "oreo")
                .addBodyParameter("password", "azerty")
                .setPriority(Priority.LOW)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() { //get reponse sous forme de json
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d(TAG, "onResponse: response : >" + response.toString());
                        connectView.onClickOnButtonSignIn();//affichage visuel
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
                        connectView.onClickOnButtonSignIn();//affichage visuel
                        Log.d(TAG, "onError: " + error);
                    }
                });
    }
}
