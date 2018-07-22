package com.example.laureen.pepitapp.presenter;

import android.content.Context;
import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.androidnetworking.interfaces.StringRequestListener;
import com.example.laureen.pepitapp.model.Personality;
import com.example.laureen.pepitapp.model.SaveUserDataPreferences;
import com.example.laureen.pepitapp.view.TestPersonalityUserView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


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

        AndroidNetworking.get(baseUrl+"/personality/test_personality")
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

                        Log.d(TAG, "response : " + answerPersonality.toString());
                        Log.d(TAG, "question : " + questionsPersonality.toString());

                        testPersonalityUserView.getPersonalityTest(questionsPersonality, answerPersonality);
                    }
                    @Override
                    public void onError(ANError anError) {
                        Log.e("on error : ",anError.toString());
                    }
                });

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
