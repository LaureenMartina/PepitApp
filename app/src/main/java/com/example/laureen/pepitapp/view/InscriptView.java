package com.example.laureen.pepitapp.view;

public interface InscriptView {
    public void onClickOnButtonSignUp();
    public void showProgressBar();
    void failedVerif();
    void failedVerifPassword();
    void popupValidationInscription();
    void validationData(String token);

}
