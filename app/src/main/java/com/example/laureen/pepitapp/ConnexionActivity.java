package com.example.laureen.pepitapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.laureen.pepitapp.model.SaveUserDataPreferences;
import com.example.laureen.pepitapp.presenter.ConnectPresenter;
import com.example.laureen.pepitapp.view.ConnectView;

public class ConnexionActivity extends AppCompatActivity implements ConnectView {

    Button btnConnexion;
    ConnectPresenter connectPresenter;

    EditText username;
    EditText password;

    SaveUserDataPreferences dataUser = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);

        connectPresenter = new ConnectPresenter(this, MainActivity.pepitService);

        btnConnexion = findViewById(R.id.btn_signin);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        btnConnexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String _username = username.getText().toString();
                String _password = password.getText().toString();

                connectPresenter.verifyData(_username,_password);
            }
        });
    }

    public void onClickOnButtonSignIn(){
        TextView textV = findViewById(R.id.text);
        // mettre la progressbar a gone visibility
        textV.setText("Connexion reussie");
    }

    @Override
    public void validationData(String token) {
        // TODO : enlever le toast
        // TODO : gestion des errors si pb sur token !
        Toast.makeText(this, "GOOD", Toast.LENGTH_SHORT).show();

        //Créer le fichier spécifique au user
        String name = username.getText().toString();
        SaveUserDataPreferences dataUser = new SaveUserDataPreferences(name);

        //Sauvegarder avec SharedPreferences
        dataUser.setToken(this, token);

        Intent intent = new Intent(ConnexionActivity.this, HomeActivity.class);
        startActivity(intent);
    }
}
