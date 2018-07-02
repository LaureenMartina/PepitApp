package com.example.laureen.pepitapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.laureen.pepitapp.presenter.ConnectPresenter;
import com.example.laureen.pepitapp.presenter.InscriptPresenter;
import com.example.laureen.pepitapp.view.ConnectView;

public class ConnexionActivity extends AppCompatActivity implements ConnectView {

    Button btnConnexion;
    ConnectPresenter connectPresenter;

    EditText username;
    EditText password;

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
    public void validationData() {
        Toast.makeText(this, "GOOD", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(ConnexionActivity.this, HomeActivity.class);
        startActivity(intent);
    }
}
