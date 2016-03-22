package com.webmyne.base.Tender.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by priyasindkar on 21-03-2016.
 */
public class TenderDataObject  {
    public String tenderNo, SrNo, StrtDate, EndDate;

    public TenderDataObject() {
    }

    public TenderDataObject(String SrNo, String tenderNo, String StrtDate, String EndDate) {
        this.SrNo = SrNo;
        this.tenderNo = tenderNo;
        this.StrtDate = StrtDate;
        this.EndDate = EndDate;
    }

    public String getTenderNo() {
        return tenderNo;
    }

    public void setTenderNo(String tenderNo) {
        this.tenderNo = tenderNo;
    }

    public String getSrNo() {
        return SrNo;
    }

    public void setSrNo(String srNo) {
        SrNo = srNo;
    }

    public String getStrtDate() {
        return StrtDate;
    }

    public void setStrtDate(String strtDate) {
        StrtDate = strtDate;
    }

    public String getEndDate() {
        return EndDate;
    }

    public void setEndDate(String endDate) {
        EndDate = endDate;
    }


}


