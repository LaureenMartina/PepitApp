package com.example.laureen.pepitapp.model;

public class User {

    public transient int id;
    public String firstname;
    public String lastname;
    public String username;
    public String password;
    public String confirmPassword;
    public int age;
    public  String email;
    public String profil;
    public int level;
    public int exp;
    public int type;

    public User(String firstname, String lastname, String username, String password, String confirmPassword, int age, String email, String profil) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.age = age;
        this.email = email;
        this.profil = profil;
    }
}
