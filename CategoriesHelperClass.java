package com.cagritaran.bitkitakibi.HelperClasses.HomeAdapter;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;

public class CategoriesHelperClass {

    int image;
    Drawable relativeLayout;
    String title;

    public CategoriesHelperClass(GradientDrawable relativeLayout, int image, String title) {
        this.image = image;
        this.title = title;
        this.relativeLayout = relativeLayout;
    }


    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public Drawable getGradient() {
        return relativeLayout;
    }


}