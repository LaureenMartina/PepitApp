package com.example.laureen.pepitapp.model;

import android.support.annotation.DrawableRes;
import android.util.Log;

import com.example.laureen.pepitapp.R;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Chewbs on 21/07/2018.
 */

public class SombreroItem {

    @SerializedName("COLOR")
    @Expose private String color;
    @SerializedName("description")
    @Expose private String description;

    private int color_url;
    private int item_url;

    public SombreroItem(String color, String description) {
        this.color = color;
        this.description = description;
        defineColorUrl(color);
        defineItemUrl(description);
    }

    private void defineItemUrl(String item) {

        @DrawableRes int url = 0;
        switch (item) {
            case "item": {
                url = R.drawable.stargold;
                break;
            }
            case "up": {
                url = R.drawable.arrow;
                break;
            }
            case "down": {
                url = R.drawable.arrow;
                break;
            }
            case "left": {
                url = R.drawable.arrow;
                break;
            }
            case "right": {
                url = R.drawable.arrow;
                break;
            }
            case "null": {
                url=0;
                break;
            }
            default:
                break;
        }

        setItem_url(url);
    }

    private void defineColorUrl(String color) {

        @DrawableRes int url = 0;
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
            case "BLACK": {
                url = R.drawable.black;
                break;
            }
            default:
                break;
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
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
    }

    @Override
    public String toString() {
        return "SombreroItem{" +
                "color='" + color + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
