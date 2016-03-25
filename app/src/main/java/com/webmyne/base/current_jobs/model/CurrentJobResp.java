package com.webmyne.base.current_jobs.model;

import java.util.ArrayList;

/**
 * Created by vaibhavirana on 23-03-2016.
 */
public class CurrentJobResp {
    public ArrayList<FetchJobResult> FetchJobResult;

    public ArrayList<com.webmyne.base.current_jobs.model.FetchJobResult> getFetchJobResult() {
        return FetchJobResult;
    }

    public void setFetchJobResult(ArrayList<com.webmyne.base.current_jobs.model.FetchJobResult> fetchJobResult) {
        FetchJobResult = fetchJobResult;
    }
}
