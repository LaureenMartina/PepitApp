package com.example.laureen.pepitapp.presenter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
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

    @NonNull
    private QuizzView QuizzView;

    private List<String> questionsList = new ArrayList<>();
    private List<List<String>> incorrectAnswer = new ArrayList<>();
    private List<String> correctAnswer = new ArrayList<>();

    public QuizzPresenter(@NonNull QuizzView view){

        QuizzView = view;
    }

    public void questionQuizz(Context context){
        Log.e("in question quizz", getClass().toString());
        SaveUserDataPreferences dataUser = new SaveUserDataPreferences("flowpsouille");
        String token = dataUser.getToken(context);
        String baseUrl = "http://10.0.2.2:3000/";//192.168.1.25


        AndroidNetworking.get(baseUrl+"level_quiz/questions_quiz")
                .addHeaders("AUTHORIZATION", token)
                .setTag("Connect")
                .build()
                .getAsJSONArray(new JSONArrayRequestListener() {
                    @Override
                    public void onResponse(JSONArray response) {
                        //Log.e("on response : ",response.toString());
                        //Log.d(TAG, "onResponse: response : >" + response.toString());
                        JSONArray array = response;
                        //JSONArray array = response.getJSONArray(Integer.parseInt("results"));
                        JsonParser parser = new JsonParser();
                        JsonElement arr = parser.parse(array.toString());
                        Gson gson = new GsonBuilder().create();
                        Quizz[] results = gson.fromJson(arr, Quizz[].class);
                        Log.d(TAG, "onResponse: " + results[0].toString());
                        Log.d(TAG, "question : " + results[0].getQuestion());

                        for (int i = 0; i<9; i++){
                            questionsList.add(results[i].getQuestion());
                        }
                        for (int i = 0; i<9; i++){
                            ArrayList<String> answer = new ArrayList<>();
                            answer.add(results[i].getAnswer1());
                            answer.add(results[i].getAnswer2());
                            answer.add(results[i].getAnswer3());
                            answer.add(results[i].getAnswer4());
                            incorrectAnswer.add(answer);
                        }
                        for (int i = 0; i<9; i++){
                            correctAnswer.add(results[i].getCorrectAnswer());
                        }

                        Log.d(TAG, "answers : " + incorrectAnswer.toString());
                        Log.d(TAG, "correct answer : " + results[9].getCorrectAnswer());

                        QuizzView.getQuizz(questionsList, incorrectAnswer, correctAnswer);
                        //questionOfQuizz = results[0].getQuestion().toString();
                        //questionQuizz.setText(questionOfQuizz);
                        //setAnswerQuizz(results[0].getIncorrectAnswers(), results[0].getCorrectAnswer());
                        //System.out.println(results[1].getQuestion().toString()); //Incrementer question pour questionnaire
                    }

                    @Override
                    public void onError(ANError anError) {
                        Log.e("on error : ",anError.toString());
                    }
                });

        Log.i("token user : ", token);
    /*
        AndroidNetworking.get(baseUrl+"level_quiz/questions_quiz")
                .addHeaders("AUTHORIZATION", token)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {

                        Log.d(TAG, "onResponse: response : >" + response.toString());
                        try {
                            JSONArray array = response.getJSONArray("results");
                            JsonParser parser = new JsonParser();
                            JsonElement arr = parser.parse(array.toString());
                            Gson gson = new GsonBuilder().create();
                            Quizz[] results = gson.fromJson(arr, Quizz[].class);
                            Log.d(TAG, "onResponse: " + results[0].toString());

                            for (int i = 0; i<10; i++){
                                questionsList.add(results[i].getQuestion());
                            }
                            for (int i = 0; i<10; i++){
                                ArrayList<String> answer = new ArrayList<>();
                                answer.add(results[i].getAnswer1());
                                answer.add(results[i].getAnswer2());
                                answer.add(results[i].getAnswer3());
                                answer.add(results[i].getAnswer4());
                                incorrectAnswer.add(answer);
                            }
                            for (int i = 0; i<10; i++){
                                correctAnswer.add(results[i].getCorrectAnswer());
                            }

                            QuizzView.getQuizz(correctAnswer, incorrectAnswer, questionsList);
                            //questionOfQuizz = results[0].getQuestion().toString();
                            //questionQuizz.setText(questionOfQuizz);
                            //setAnswerQuizz(results[0].getIncorrectAnswers(), results[0].getCorrectAnswer());
                            //System.out.println(results[1].getQuestion().toString()); //Incrementer question pour questionnaire
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    @Override
                    public void onError(ANError error) {
                        Log.e(TAG, "onError: " + error);
                    }
                });
        */
    }


}
