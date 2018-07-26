package com.example.laureen.pepitapp.presenter;

import android.content.Context;
import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.androidnetworking.interfaces.StringRequestListener;
import com.example.laureen.pepitapp.model.Quizz;
import com.example.laureen.pepitapp.model.SaveUserDataPreferences;
import com.example.laureen.pepitapp.view.QuizzView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Florian on 17/07/2018.
 */

public class QuizzPresenter {
    private static final String TAG = "QuizzPresenter";


    private QuizzView QuizzView;

    private List<String> questionsList = new ArrayList<>();
    private List<List<String>> incorrectAnswer = new ArrayList<>();
    private List<String> correctAnswer = new ArrayList<>();
    private ArrayList<Integer> idLevelsList = new ArrayList<>();

    public QuizzPresenter(QuizzView view){

        QuizzView = view;
    }

    public void questionQuizz(Context context){

        Log.e("in question quizz", getClass().toString());

        String token = SaveUserDataPreferences.getToken(context);
        String baseUrl = "http://10.0.2.2:3000/";


        AndroidNetworking.get(baseUrl+"level_quizz/questions_quizz")
                .addHeaders("AUTHORIZATION", token)
                .setTag("Connect")
                .build()
                .getAsJSONArray(new JSONArrayRequestListener() {
                    @Override
                    public void onResponse(JSONArray response) {
                        JSONArray array = response;
                        JsonParser parser = new JsonParser();
                        JsonElement arr = parser.parse(array.toString());
                        Gson gson = new GsonBuilder().create();
                        Quizz[] results = gson.fromJson(arr, Quizz[].class);
                        Log.d(TAG, "onResponse: " + results[0].toString());
                        Log.d(TAG, "question : " + results[0].getQuestion());

                        for (Quizz quizz : results) {
                            questionsList.add(quizz.getQuestion());
                            idLevelsList.add(quizz.getIdLevels());

                            ArrayList<String> answer = new ArrayList<>();
                            answer.add(quizz.getAnswer1());
                            answer.add(quizz.getAnswer2());
                            answer.add(quizz.getAnswer3());
                            answer.add(quizz.getAnswer4());
                            incorrectAnswer.add(answer);

                            correctAnswer.add(quizz.getCorrectAnswer());
                        }

                        QuizzView.getQuizz(questionsList, incorrectAnswer, correctAnswer, idLevelsList);
                    }

                    @Override
                    public void onError(ANError anError) {
                        Log.e("on error : ",anError.toString());
                    }
                });

        Log.i("token user : ", token);

    }

    public void updateExperience(int exp, Context context){
        String token = SaveUserDataPreferences.getToken(context);
        String baseUrl = "http://10.0.2.2:3000/";
        JSONObject userJson = new JSONObject();
        Log.i(TAG, "update experience");
        try {
            userJson.put("exp", exp);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        AndroidNetworking.post(baseUrl+"users/update_exp")
                .addJSONObjectBody(userJson)
                .setTag("Connect")
                .addHeaders("AUTHORIZATION", token)
                .build()
                .getAsString(new StringRequestListener() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("data experience save : ", "succed");
                    }

                    @Override
                    public void onError(ANError anError) {
                        anError.printStackTrace();
                    }
                });
    }

    public void updateHistoric(ArrayList<Integer> id_levels, int exp, Context context){
        String token = SaveUserDataPreferences.getToken(context);
        String baseUrl = "http://10.0.2.2:3000/";
        JSONObject userJson = new JSONObject();
        JSONObject levelJson = new JSONObject();
        JSONArray idLevelArray = new JSONArray();
        Log.i("update historic", id_levels.toString());
        try {
            levelJson.put("id_levels", id_levels);
            for (int idLevel : id_levels){
                idLevelArray.put(idLevel);
            }

            userJson.put("id_levels", idLevelArray);
            userJson.put("id_game", 4);
            userJson.put("score", exp);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        AndroidNetworking.post(baseUrl+"historic/create")
                .addJSONObjectBody(userJson)
                .setTag("Connect")
                .addHeaders("AUTHORIZATION", token)
                .build()
                .getAsString(new StringRequestListener() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("data historic save : ", "succed");
                    }

                    @Override
                    public void onError(ANError anError) {
                        anError.printStackTrace();
                    }
                });
    }


}
