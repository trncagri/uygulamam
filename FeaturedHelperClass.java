package com.cagritaran.bitkitakibi.HelperClasses.HomeAdapter;

import java.io.Serializable;

public class FeaturedHelperClass implements Serializable {

    int image;
    String title, description;

    public FeaturedHelperClass(int image, String title, String description) {
        this.image = image;
        this.title = title;
        this.description = description;
    }


    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
