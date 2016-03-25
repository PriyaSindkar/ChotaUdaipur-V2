package com.webmyne.base.news.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vaibhavirana on 25-03-2016.
 */
public class NewsResp {
    public ArrayList<FetchNewsResult> FetchNewsResult;

    public ArrayList<com.webmyne.base.news.model.FetchNewsResult> getFetchNewsResult() {
        return FetchNewsResult;
    }

    public void setFetchNewsResult(ArrayList<com.webmyne.base.news.model.FetchNewsResult> fetchNewsResult) {
        FetchNewsResult = fetchNewsResult;
    }
}
