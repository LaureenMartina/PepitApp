package com.example.laureen.pepitapp.presenter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.example.laureen.pepitapp.model.Level;
import com.example.laureen.pepitapp.model.SaveUserDataPreferences;
import com.example.laureen.pepitapp.model.Sombrero;
import com.example.laureen.pepitapp.model.SombreroItem;
import com.example.laureen.pepitapp.view.SombreroSelectedView;
import com.example.laureen.pepitapp.view.SombreroListView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



/**
 * Created by Chewbs on 20/07/2018.
 */

public class SombreroPresenter {

    private static final String TAG = "SombreroPresenter";

    @NonNull private SombreroListView sombreroListView;
    @NonNull private SombreroSelectedView sombreroSelectedView;


    public SombreroPresenter(@NonNull SombreroListView view) {
        sombreroListView = view;
    }
    public SombreroPresenter(@NonNull SombreroSelectedView view) {
        sombreroSelectedView = view;
    }

    public void findAllSombrero(Context context, int id_game) {

        SaveUserDataPreferences dataUser = new SaveUserDataPreferences("truc");
        String token = dataUser.getToken(context);
        String baseUrl = "http://10.0.2.2:3000";//192.168.1.25

        AndroidNetworking.get(baseUrl + "/levels/" + id_game )
                .addHeaders("AUTHORIZATION", token)
                .setTag("Connect")
                .build()
                .getAsJSONArray(new JSONArrayRequestListener() {
                    @Override
                    public void onResponse(JSONArray response) {

                        JsonParser parser = new JsonParser();
                        JsonElement arr = parser.parse(response.toString());
                        Gson gson = new GsonBuilder().create();
                        Level[] levels = gson.fromJson(arr, Level[].class);

                        List<Level> list_level = new ArrayList<>();
                        list_level.addAll(Arrays.asList(levels));

                        sombreroListView.getSombreroLevels(list_level);

                    }

                    @Override public void onError(ANError anError) {
                        Log.e(TAG, anError.toString());
                    }
                });

        Log.i(TAG, token);
    }

    public void findOneSombrero(Context context, int id_game, int id_level) {

        SaveUserDataPreferences dataUser = new SaveUserDataPreferences("truc");
        String token = dataUser.getToken(context);
        String baseUrl = "http://10.0.2.2:3000";//192.168.1.25


        AndroidNetworking.get(baseUrl + "/levels/" + id_game + "/" + id_level)
                .addHeaders("AUTHORIZATION", token)
                .setTag("Connect")
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        int id_game = 0;
                        String name = "";
                        int cell_count = 0;
                        int difficulty = 0;
                        int f1 = 0;
                        int f2 = 0;
                        int f3 = 0;
                        int f4 = 0;


                        try {
                            id_game = response.getInt("id_game");
                            name = response.getString("name");
                            cell_count = response.getInt("cell");
                            difficulty = response.getInt("difficulty");
                            f1 = response.getInt("f1");
                            f2 = response.getInt("f2");
                            f3 = response.getInt("f3");
                            f4 = response.getInt("f4");

                            List<SombreroItem> grid_list = new ArrayList<>();
                            JSONArray array = new JSONArray(response.getString("grid_list"));
                            String color ="";
                            String description = "";

                            for (int i = 0; i < array.length(); i++) {

                                JSONObject obj = new JSONObject(array.getString(i));
                                color = obj.getString("COLOR");
                                description = obj.getString("description");

                                SombreroItem sombreroItem = new SombreroItem(color,description);
                                grid_list.add(sombreroItem);
                            }

                            Sombrero sombrero = new Sombrero(id_game, name, difficulty, cell_count, f1, f2, f3, f4, grid_list);
                            sombreroSelectedView.getSelectedSombrero(sombrero);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(ANError anError) {
                        anError.printStackTrace();
                    }
                });

        Log.i(TAG, token);
    }

}

class InputStreamOperations {

    /**
     * @param in : buffer with the php result
     * @param bufSize : size of the buffer
     * @return : the string corresponding to the buffer
     */
    public static String InputStreamToString (InputStream in, int bufSize) {
        final StringBuilder out = new StringBuilder();
        final byte[] buffer = new byte[bufSize];
        try {
            for (int ctr; (ctr = in.read(buffer)) != -1;) {
                out.append(new String(buffer, 0, ctr));
            }
        } catch (IOException e) {
            throw new RuntimeException("Cannot convert stream to string", e);
        }
        // On retourne la chaine contenant les donnees de l'InputStream
        return out.toString();
    }

    /**
     * @param in : buffer with the php result
     * @return : the string corresponding to the buffer
     */
    public static String InputStreamToString (InputStream in) {
        // On appelle la methode precedente avec une taille de buffer par defaut
        return InputStreamToString(in, 1024);
    }

}