package com.example.laureen.pepitapp.presenter;

import android.content.Context;
import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.example.laureen.pepitapp.model.SaveUserDataPreferences;
import com.example.laureen.pepitapp.model.User;
import com.example.laureen.pepitapp.view.ProfilUserView;

/**
 * Created by Florian on 21/07/2018.
 */

public class ProfilUserPresenter {
    private static final String TAG = "ProfilUserPresenter";

    private ProfilUserView profilUserView;

    public ProfilUserPresenter(ProfilUserView view){

        profilUserView = view;
    }

    public void getProfilUser(Context context){
        Log.e("in getProfilUser", getClass().toString());
        //SaveUserDataPreferences dataUser = new SaveUserDataPreferences("flowpsouille");
        String token = SaveUserDataPreferences.getToken(context);
        String baseUrl = "http://10.0.2.2:3000/";


        AndroidNetworking.get(baseUrl+"users/profilbytoken")
                .addHeaders("AUTHORIZATION", token)
                .setTag("Connect")
                .build()
                .getAsObject(User.class, new ParsedRequestListener<User>() {
                    @Override
                    public void onResponse(User user) {
                        // do anything with response
                        Log.e(TAG, "id profil : " + user.getId_type_profil());
                        if(user.getId_type_profil() == 0){
                            profilUserView.setProfilIdUser(0);
                        }
                        else {
                            Log.e("in getProfilUser", String.valueOf(user.getId_type_profil()));
                            profilUserView.setProfilIdUser(user.getId_type_profil());
                        }

                        profilUserView.setExpUser(user.getExp());
                        profilUserView.setLevelUser(user.getLevel());

                    }
                    @Override
                    public void onError(ANError anError) {
                        Log.e("on error : ",anError.toString());
                    }
                });

        Log.i("token user : ", token);
    }
}
