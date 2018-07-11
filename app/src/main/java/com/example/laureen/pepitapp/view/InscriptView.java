package com.example.laureen.pepitapp.view;

public interface InscriptView {
    public void onClickOnButtonSignUp();
    public void showProgressBar();
    void failedVerif();
    void failedVerifPassword();
    void validationData(String firstname, String lastname, String username, String password, String confirmPassword, Integer age, String email);

}
