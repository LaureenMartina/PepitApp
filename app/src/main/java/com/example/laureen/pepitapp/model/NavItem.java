package com.example.laureen.pepitapp.model;

public class NavItem {
    public String mTitle;
    public String mSubtitle;
    public int mIcon;
    public boolean isSelected;

    public NavItem(String title, String subtitle, int icon) {
        mTitle = title;
        mSubtitle = subtitle;
        mIcon = icon;
    }
}
