package com.webmyne.base.news.model;

/**
 * Created by vaibhavirana on 25-03-2016.
 */
public class FetchNewsResult {
    public int NewsID ;
    public String Attachment;
    public String DateGenerated;
    public String Description;
    public String Title;

    public int getNewsID() {
        return NewsID;
    }

    public void setNewsID(int newsID) {
        NewsID = newsID;
    }

    public String getAttachment() {
        return Attachment;
    }

    public void setAttachment(String attachment) {
        Attachment = attachment;
    }

    public String getDateGenerated() {
        return DateGenerated;
    }

    public void setDateGenerated(String dateGenerated) {
        DateGenerated = dateGenerated;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }
}
