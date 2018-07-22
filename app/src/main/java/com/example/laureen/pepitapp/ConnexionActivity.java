package com.example.laureen.pepitapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
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
        textV.setText("Connexion reussie");
    }

    public void popupAlert() {

        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(this, android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(this);
        }
        builder.setTitle("Attention")
                .setMessage("Veuillez saisir tous les champs")
                .setNeutralButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    @Override
    public void validationData(String token) {
        //Créer le fichier spécifique au user
        String name = username.getText().toString();
        SaveUserDataPreferences dataUser = new SaveUserDataPreferences(name);

        //Sauvegarder avec SharedPreferences
        dataUser.setToken(this, token);

        Intent intent = new Intent(ConnexionActivity.this, HomeActivity.class);
        startActivity(intent);
    }

    public void errorConnectData(){
        Toast.makeText(this, "Données insérées incorrectes", Toast.LENGTH_SHORT).show();
    }
}
