package com.webmyne.base.touristSpots.model;

/**
 * Created by vaibhavirana on 25-03-2016.
 */
public class TouristResult {

    public int TouristID;
    public String Description ;
    public String DateGenerated;
    public String Image;
    public String PlaceName;

    public int getTouristID() {
        return TouristID;
    }

    public void setTouristID(int touristID) {
        TouristID = touristID;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getDateGenerated() {
        return DateGenerated;
    }

    public void setDateGenerated(String dateGenerated) {
        DateGenerated = dateGenerated;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getPlaceName() {
        return PlaceName;
    }

    public void setPlaceName(String placeName) {
        PlaceName = placeName;
    }
}
