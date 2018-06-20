package com.example.laureen.pepitapp.model;

public class User {

    public transient int id;
    public String firstname;
    public String lastname;
    public String username;
    public int age;
    public  String email;
    public String profil;
    public int level;
    public int exp;
    public int type;

    public User(String firstname, String lastname, String username, int age, String email, String profil, int type) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.age = age;
        this.email = email;
        this.profil = profil;
        this.type = type;
    }
}
