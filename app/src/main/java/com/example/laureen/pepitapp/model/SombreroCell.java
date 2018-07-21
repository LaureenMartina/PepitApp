package com.example.laureen.pepitapp.model;

import com.example.laureen.pepitapp.R;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Chewbs on 21/07/2018.
 */

public class SombreroCell {

    @SerializedName("COLOR")
    @Expose private String color;
    @SerializedName("description")
    @Expose private String description;

    private int color_url;
    private int item_url;

    public SombreroCell(String color, String description) {
        this.color = color;
        this.description = description;

        defineColorUrl(color);
        defineItemUrl(description);
    }

    private void defineItemUrl(String item) {
        int url;
        switch (item) {
            case "item": {
                url = R.drawable.stargold;
                break;
            }
            case "null": {
                url=0;
                break;
            }
            default:{
                url = R.drawable.arrow;
                break;
            }
        }
        setItem_url(url);
    }

    private void defineColorUrl(String color) {
        int url;
        switch (color) {
            case "BLUE": {
                url = R.drawable.blue;
                break;
            }
            case "GREEN": {
                url = R.drawable.green;
                break;
            }
            case "RED": {
                url = R.drawable.red;
                break;
            }
            default:{
                url = R.drawable.black;
                break;
            }
        }
        setColor_url(url);
    }

    public int getColor_url() {
        return color_url;
    }

    private void setColor_url(int color_url) {
        this.color_url = color_url;
    }

    public int getItem_url() {
        return item_url;
    }

    private void setItem_url(int item_url) {
        this.item_url = item_url;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "SombreroCell{" +
                "color='" + color + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
