package com.webmyne.base.AboutUs.model;

import java.util.ArrayList;

/**
 * Created by vaibhavirana on 23-03-2016.
 */
public class AboutUsResp {
    public ArrayList<AboutUsModel> AboutUSResult;

    public ArrayList<AboutUsModel> getAboutUSResult() {
        return AboutUSResult;
    }

    public void setAboutUSResult(ArrayList<AboutUsModel> aboutUSResult) {
        AboutUSResult = aboutUSResult;
    }

    @Override
    public String toString() {
        return "AboutUsResp{" +
                "AboutUSResult=" + AboutUSResult +
                '}';
    }
}
