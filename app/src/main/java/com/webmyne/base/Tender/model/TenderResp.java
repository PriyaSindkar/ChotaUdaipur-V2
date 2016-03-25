package com.webmyne.base.Tender.model;

import java.util.ArrayList;

/**
 * Created by vaibhavirana on 25-03-2016.
 */
public class TenderResp {

    public ArrayList<TenderResult> TenderResult;

    public ArrayList<com.webmyne.base.Tender.model.TenderResult> getTenderResult() {
        return TenderResult;
    }

    public void setTenderResult(ArrayList<com.webmyne.base.Tender.model.TenderResult> tenderResult) {
        TenderResult = tenderResult;
    }
}
