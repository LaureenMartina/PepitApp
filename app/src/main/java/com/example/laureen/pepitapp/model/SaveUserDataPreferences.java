package com.example.laureen.pepitapp.model;

import android.content.Context;
import android.content.SharedPreferences;

public class SaveUserDataPreferences {

    private static String PREF_USERNAME; // nom du fichier
    private static String TOKEN_KEY;
    private static SharedPreferences prefs;

    public SaveUserDataPreferences(String username) {
        PREF_USERNAME= username;
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

    /*public static void verifData(){
        //objectif : sauvegarder 1 seule fois le nom et l'age de l'utilisateur
        //pour cela, on commence par regarder si on a déjà des éléments sauvegardés
        if (prefs.contains(PREF_EMAIL) && prefs.contains(TOKEN_KEY)) {
            String token = sharedPreferences.getString(PREF_EMAIL, null);
            String name = sharedPreferences.getString(TOKEN_KEY, null);
        } else {
            //si aucun utilisateur n'est sauvegardé, on ajouter [token,nom]
            prefs
                    .edit()
                    .putString(PREF_EMAIL, "")
                    .putString(TOKEN_KEY, "")
                    .apply();
        }
    }*/
}
