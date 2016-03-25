package com.webmyne.base.touristSpots.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vaibhavirana on 25-03-2016.
 */
public class ToutistResp {
    ArrayList<TouristResult> TouristResult;

    public ArrayList<com.webmyne.base.touristSpots.model.TouristResult> getTouristResult() {
        return TouristResult;
    }

    public void setTouristResult(ArrayList<com.webmyne.base.touristSpots.model.TouristResult> touristResult) {
        TouristResult = touristResult;
    }
}
