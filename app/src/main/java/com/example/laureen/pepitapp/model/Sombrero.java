package com.example.laureen.pepitapp.model;

import android.util.Log;
import android.widget.GridView;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Chewbs on 20/07/2018.
 */

public class Sombrero {

    @SerializedName("id_game")
    @Expose private int id_game;
    @SerializedName("name")
    @Expose private String name;
    @SerializedName("cell_count")
    @Expose private int cell_count;
    @SerializedName("difficulty")
    @Expose private int difficulty;
    @SerializedName("f1")
    @Expose private int f1;
    @SerializedName("f2")
    @Expose private int f2;
    @SerializedName("f3")
    @Expose private int f3;
    @SerializedName("f4")
    @Expose private int f4;
    @SerializedName("cell_list")
    @Expose private List<SombreroItem> cell_list;

    public Sombrero(int id_game, String name, int difficulty, int cell_count, int f1, int f2, int f3, int f4, List<SombreroItem> cell_list) {
        setId_game(id_game);
        setName(name);
        setCellCount(cell_count);
        setDifficulty(difficulty);
        setF1(f1);
        setF2(f2);
        setF3(f3);
        setF4(f4);
        setCellList(cell_list);
    }

    public int getId_game() {
        return id_game;
    }

    private void setId_game(int id_game) {
        this.id_game = id_game;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCellCount() {
        return cell_count;
    }

    private void setCellCount(int cell) {
        cell_count = cell;
    }

    public int getDifficulty() {
        return difficulty;
    }

    private void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public int getF1() {
        return f1;
    }

    public void setF1(int f1) {
        this.f1 = f1;
    }

    public int getF2() {
        return f2;
    }

    private void setF2(int f2) {
        this.f2 = f2;
    }

    public int getF3() {
        return f3;
    }

    private void setF3(int f3) {
        this.f3 = f3;
    }

    public int getF4() {
        return f4;
    }

    private void setF4(int f4) {
        this.f4 = f4;
    }

    public List<SombreroItem> getCellList() {
        return cell_list;
    }

    private void setCellList(List<SombreroItem> grid_list) {
        cell_list = grid_list;
    }

    @Override
    public String toString() {
        return "Sombrero{" +
                "id_game=" + id_game +
                ", name='" + name + '\'' +
                ", cell_count=" + cell_count +
                ", difficulty=" + difficulty +
                ", f1=" + f1 +
                ", f2=" + f2 +
                ", f3=" + f3 +
                ", f4=" + f4 +
                ", cell_list=" + cell_list +
                '}';
    }
}
