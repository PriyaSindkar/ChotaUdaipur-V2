package com.webmyne.base.Tender.model;

import java.io.Serializable;

/**
 * Created by vaibhavirana on 25-03-2016.
 */
public class TenderResult implements Serializable {
    public String TenderNo,ModeOfSubmission,StartDate,EndDate,Description,DateGenerated,Attachment,IPAddress;
    public int TenderID;

    public String getTenderNo() {
        return TenderNo;
    }

    public void setTenderNo(String tenderNo) {
        TenderNo = tenderNo;
    }

    public String getModeOfSubmission() {
        return ModeOfSubmission;
    }

    public void setModeOfSubmission(String modeOfSubmission) {
        ModeOfSubmission = modeOfSubmission;
    }

    public String getStartDate() {
        return StartDate;
    }

    public void setStartDate(String startDate) {
        StartDate = startDate;
    }

    public String getEndDate() {
        return EndDate;
    }

    public void setEndDate(String endDate) {
        EndDate = endDate;
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

    public String getAttachment() {
        return Attachment;
    }

    public void setAttachment(String attachment) {
        Attachment = attachment;
    }

    public String getIPAddress() {
        return IPAddress;
    }

    public void setIPAddress(String IPAddress) {
        this.IPAddress = IPAddress;
    }

    public int getTenderID() {
        return TenderID;
    }

    public void setTenderID(int tenderID) {
        TenderID = tenderID;
    }
}
