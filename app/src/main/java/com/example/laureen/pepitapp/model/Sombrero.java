package com.example.laureen.pepitapp.model;

import android.widget.GridView;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Chewbs on 20/07/2018.
 */

public class Sombrero {

    @SerializedName("id_game")
    @Expose private static int id_game;
    @SerializedName("name")
    @Expose private static String name;
    @SerializedName("cell_count")
    @Expose private static int cell_count;
    @SerializedName("difficulty")
    @Expose private static int difficulty;
    @SerializedName("f1")
    @Expose private static int f1;
    @SerializedName("f2")
    @Expose private static int f2;
    @SerializedName("f3")
    @Expose private static int f3;
    @SerializedName("f4")
    @Expose private static int f4;
    @SerializedName("cell_list")
    @Expose private static List<SombreroCell> cell_list;

    public Sombrero(int id_game, String name, int difficulty, int cell_count, int f1, int f2, int f3, int f4, List<SombreroCell> cell_list) {
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

    public GridView addCellToSombreroGridView(GridView gridView, SombreroCell sombreroCell) {

        /*
        * String[][] color_cell = new String[cell][cell];
        String[][] item_cell = new String[cell][cell];
        int cell_i = 0, cell_y = 0;

        List<String> cell_list = parseJSON(String.valueOf(value));

        for (Object aList : cell_list) {
            String[] o = aList.toString().split(":");
            String k = o[0];
            String v = o[1];

            if (cell_y == cell) {
                cell_i++;
                cell_y = 0;
            }

            switch (k) {
                case "COLOR" : {
                    color_cell[cell_i][cell_y] = convertColor(v);
                    break;
                }
                case "description" : {
                    item_cell[cell_i][cell_y] = v;
                    cell_y++;
                    break;
                }
                default: break;
            }
        }

        for (int i = 0; i < cell; i++) {
            for (int j = 0; j < cell; j++) {

                Pane pane = new Pane();
                pane.setStyle(color_cell[i][j]);

                if (item_cell[i][j].equals("null")){
                    item_cell[i][j] = "";
                }

                if (cell == 10){
                    pane.setMinSize(60.0,60.0);
                } else if (cell == 15){
                    pane.setMinSize(40.0,40.0);
                }

                switch (item_cell[i][j]) {
                    case "up" : {
                        arrow = setArrowOrientation(270,i,j);
                        pane.getChildren().add(arrow);
                        break;
                    }
                    case "down" : {
                        arrow = setArrowOrientation(90,i,j);
                        pane.getChildren().add(arrow);
                        break;
                    }
                    case "left" : {
                        arrow = setArrowOrientation(180,i,j);
                        pane.getChildren().add(arrow);
                        break;
                    }
                    case "right" : {
                        arrow = setArrowOrientation(0,i,j);
                        pane.getChildren().add(arrow);
                        break;
                    }
                    case "item" : {
                        SombreroItem imageView = new SombreroItem("file:src/contents/images/stargold.png", i, j);
                        imageView.setFitHeight(30);
                        imageView.setFitWidth(30);
                        imageView.setLayoutX(15);
                        imageView.setLayoutY(15);
                        pane.getChildren().add(imageView);
                        break;
                    }
                    default:
                        break;
                }
                GridPane.setRowIndex(pane, i);
                GridPane.setColumnIndex(pane, j);
                board.getChildren().addAll(pane);
            }
        }
        grid.setGridLinesVisible(true);
        grid.setVisible(true);
        *
        * */

        return gridView;

    }

    public int getId_game() {
        return id_game;
    }

    private void setId_game(int id_game) {
        Sombrero.id_game = id_game;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        Sombrero.name = name;
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
        Sombrero.difficulty = difficulty;
    }

    public int getF1() {
        return f1;
    }

    public void setF1(int f1) {
        Sombrero.f1 = f1;
    }

    public int getF2() {
        return f2;
    }

    private void setF2(int f2) {
        Sombrero.f2 = f2;
    }

    public int getF3() {
        return f3;
    }

    private void setF3(int f3) {
        Sombrero.f3 = f3;
    }

    public int getF4() {
        return f4;
    }

    private void setF4(int f4) {
        Sombrero.f4 = f4;
    }

    public List<SombreroCell> getCellList() {
        return cell_list;
    }

    private void setCellList(List<SombreroCell> grid_list) {
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
