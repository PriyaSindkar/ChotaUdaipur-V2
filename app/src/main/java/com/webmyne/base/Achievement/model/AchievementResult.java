package com.webmyne.base.Achievement.model;

/**
 * Created by vaibhavirana on 23-03-2016.
 */
public class AchievementResult {
    public int AchievementID;
    public String Award;
    public String AwardBy;
    public String AwardFor;
    public String DateGenerated;
    public String Image;
    public String Year;

    public int getAchievementID() {
        return AchievementID;
    }

    public void setAchievementID(int achievementID) {
        AchievementID = achievementID;
    }

    public String getAward() {
        return Award;
    }

    public void setAward(String award) {
        Award = award;
    }

    public String getAwardBy() {
        return AwardBy;
    }

    public void setAwardBy(String awardBy) {
        AwardBy = awardBy;
    }

    public String getAwardFor() {
        return AwardFor;
    }

    public void setAwardFor(String awardFor) {
        AwardFor = awardFor;
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

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }
}
