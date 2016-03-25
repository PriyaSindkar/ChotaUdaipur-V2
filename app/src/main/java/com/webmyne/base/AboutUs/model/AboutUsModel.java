package com.webmyne.base.AboutUs.model;

/**
 * Created by vaibhavirana on 23-03-2016.
 */
public class AboutUsModel {
    public String Description;
    public String Image;

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    @Override
    public String toString() {
        return "AboutUsModel{" +
                "Description='" + Description + '\'' +
                ", Image='" + Image + '\'' +
                '}';
    }
}
