package com.example.laureen.pepitapp.presenter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.androidnetworking.interfaces.StringRequestListener;
import com.example.laureen.pepitapp.model.Personality;
import com.example.laureen.pepitapp.model.SaveUserDataPreferences;
import com.example.laureen.pepitapp.view.TestPersonalityUserView;
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
 * Created by Florian on 21/07/2018.
 */

public class TestPersonalityUserPresenter {
    private static final String TAG = "PersonalityUsePresenter";

    private TestPersonalityUserView testPersonalityUserView;

    private ArrayList<String> questionsPersonality = new ArrayList<>();
    private ArrayList<ArrayList<String>> answerPersonality = new ArrayList<>();

    public TestPersonalityUserPresenter(TestPersonalityUserView view){

        testPersonalityUserView = view;
    }

    public void getTestPersonality(Context context){
        Log.e("in getTestPersonality", getClass().toString());
        String token = SaveUserDataPreferences.getToken(context);
        String baseUrl = "http://10.0.2.2:3000/";


        AndroidNetworking.get(baseUrl+"test_personality")
                .addHeaders("AUTHORIZATION", token)
                .setTag("Connect")
                .build()
                .getAsObjectList(Personality.class, new ParsedRequestListener<List<Personality>>() {
                    @Override
                    public void onResponse(List<Personality> test) {
                        // do anything with response
                        Log.d(TAG, "userList size : " + test.size());
                        for (Personality question : test) {
                            Log.d(TAG, "reponse : " + question.getAnswer1());
                            Log.d(TAG, "question : " + question.getQuestion());

                            ArrayList<String> answer = new ArrayList<>();
                            answer.add(question.getAnswer1());
                            answer.add(question.getAnswer2());
                            answer.add(question.getAnswer3());
                            answerPersonality.add(answer);
                            questionsPersonality.add(question.getQuestion());
                        }

                        Log.d(TAG, "reponse : " + answerPersonality.toString());
                        Log.d(TAG, "question : " + questionsPersonality.toString());

                        testPersonalityUserView.getPersonalityTest(questionsPersonality, answerPersonality);
                    }
                    @Override
                    public void onError(ANError anError) {
                        Log.e("on error : ",anError.toString());
                    }
                });
                /*
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
                        Personality[] results = gson.fromJson(arr, Personality[].class);

                        Log.d("result", results.toString());
                        for (int i = 0; i < results.length; i++){
                                ArrayList<String> answer = new ArrayList<>();
                                answer.add(results[i].getAnswer1());
                                answer.add(results[i].getAnswer2());
                                answer.add(results[i].getAnswer3());
                                answerPersonality.add(answer);
                                questionsPersonality.add(results[i].getQuestion());


                        }

                        testPersonalityUserView.getPersonalityTest(questionsPersonality, answerPersonality);
                    }

                    @Override
                    public void onError(ANError anError) {
                        Log.e("on error : ",anError.toString());
                    }
                });
                */

        Log.i("token user : ", token);

    }

    public void updateTypeProfil(Context context, int idTypeProfil){
        String token = SaveUserDataPreferences.getToken(context);
        String baseUrl = "http://10.0.2.2:3000/";
        JSONObject userJson = new JSONObject();
        Log.i("update profil", String.valueOf(idTypeProfil));
        try {
            userJson.put("id_type_profil", idTypeProfil);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        AndroidNetworking.post(baseUrl+"users/update_profil")
                .addJSONObjectBody(userJson)
                .setTag("Connect")
                .addHeaders("AUTHORIZATION", token)
                .build()
                .getAsString(new StringRequestListener() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("data save : ", "succed");
                    }

                    @Override
                    public void onError(ANError anError) {
                        anError.printStackTrace();
                    }
                });
    }

}
