package com.example.laureen.pepitapp;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.laureen.pepitapp.presenter.InscriptPresenter;
import com.example.laureen.pepitapp.view.InscriptView;

public class InscriptionActivity extends AppCompatActivity implements InscriptView {

    Button btnInscrip;
    InscriptPresenter inscriptPresenter;

    EditText lastname;
    EditText firstname;
    EditText username;
    EditText password;
    EditText confirmPassword;
    EditText email;
    NumberPicker age;

    //LOG
    private static final String TAG = "NumberPicker";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);

        inscriptPresenter = new InscriptPresenter(this, MainActivity.pepitService);

        btnInscrip = findViewById(R.id.btn_signup);

        Drawable drawable = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            drawable = getDrawable(R.drawable.ic_warning);
        }

        lastname = findViewById(R.id.lastname);
        firstname = findViewById(R.id.firstname);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        confirmPassword = findViewById(R.id.confirm_password);
        email = findViewById(R.id.email);
        age = findViewById(R.id.age);

        age.setMinValue(12);
        age.setMaxValue(80);
        age.setValue(20);

        age.setOnValueChangedListener(onValueChangeListener);


        btnInscrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //récup data du formulaire android
                String _lastname = lastname.getText().toString();
                String _firstname = firstname.getText().toString();
                String _username = username.getText().toString();
                String _email = email.getText().toString();
                String _password = password.getText().toString();
                String _confirmPassword = confirmPassword.getText().toString();
                int _age = age.getValue();

                inscriptPresenter.verifyData(_lastname, _firstname, _username, _email, _password, _confirmPassword, _age);
            }
        });
    }

    public void onClickOnButtonSignUp(){
        //btnInscrip.setTextColor(Color.GREEN);
        TextView textV = findViewById(R.id.text);
        // mettre la progressbar a gone visibility
        textV.setText("T'as reussi c genial");
    }

    public void showProgressBar(){
        //affichage de la progessbar animation
        ProgressBar progressBar = findViewById(R.id.login_progress);
        progressBar.setVisibility(View.VISIBLE);
        inscriptPresenter.signup();
    }

    NumberPicker.OnValueChangeListener onValueChangeListener = new NumberPicker.OnValueChangeListener(){
        @Override
        public void onValueChange(NumberPicker numberPicker, int i, int i1) {
            Log.e(TAG, "numberPicker = " + numberPicker.getValue());
        }
    };

    @Override
    public void failedVerif() {
        //lastname.setError("Vous devez remplir", drawable);
        Toast.makeText(this, "Un ou pls champs sont mal rempli", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void failedVerifPassword() {
        Toast.makeText(this, "Mots de passe non identiques", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void validationData() {
        Toast.makeText(this, "GOOD", Toast.LENGTH_SHORT).show();
        inscriptPresenter.signup();
    }
}
