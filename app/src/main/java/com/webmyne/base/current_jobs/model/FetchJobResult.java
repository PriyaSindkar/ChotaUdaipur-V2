package com.webmyne.base.current_jobs.model;

/**
 * Created by vaibhavirana on 25-03-2016.
 */
public class FetchJobResult {

    public String Attachment;
    public String DateGenerated;
    public String Description;
    public int JobId;
    public int NoOfPost;
    public String Post;
    public String Title;
    public String ValidFrom;
    public String ValidTo;

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

    public int getJobId() {
        return JobId;
    }

    public void setJobId(int jobId) {
        JobId = jobId;
    }

    public int getNoOfPost() {
        return NoOfPost;
    }

    public void setNoOfPost(int noOfPost) {
        NoOfPost = noOfPost;
    }

    public String getPost() {
        return Post;
    }

    public void setPost(String post) {
        Post = post;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getValidFrom() {
        return ValidFrom;
    }

    public void setValidFrom(String validFrom) {
        ValidFrom = validFrom;
    }

    public String getValidTo() {
        return ValidTo;
    }

    public void setValidTo(String validTo) {
        ValidTo = validTo;
    }
}
