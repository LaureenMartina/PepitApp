package com.example.laureen.pepitapp.model;

import android.content.Context;
import android.content.SharedPreferences;

public class SaveUserDataPreferences {

    private static String PREF_USERNAME; // nom du fichier
    private static String TOKEN_KEY;
    private static SharedPreferences prefs;

    public SaveUserDataPreferences(String username) {
        PREF_USERNAME = username;
    }

    public static String getToken(Context c) {
        prefs = c.getSharedPreferences(PREF_USERNAME, Context.MODE_PRIVATE); // MODE_... = mode de fonctionnement
        // MODE_PRIVATE : le mode par défaut, où le fichier créé n'est accessible que par l'application appelante
        return prefs.getString(TOKEN_KEY, "");
    }

    public static void setToken(Context c, String token) {
        prefs = c.getSharedPreferences(PREF_USERNAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(TOKEN_KEY, token);
        editor.apply();
    }
}
