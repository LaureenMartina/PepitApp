package com.example.laureen.pepitapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Chewbs on 20/07/2018.
 */

public class Level {

    @SerializedName("id")
    @Expose private int id;
    @SerializedName("id_game")
    @Expose private String id_game;
    @SerializedName("name")
    @Expose private String name;
    @SerializedName("difficulty")
    @Expose private int difficulty;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getId_game() {
        return id_game;
    }

    public void setId_game(String id_game) {
        this.id_game = id_game;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    @Override
    public String toString() {
        return "Level{" +
                "id=" + id +
                ", id_game='" + id_game + '\'' +
                ", name='" + name + '\'' +
                ", difficulty=" + difficulty +
                '}';
    }
}
