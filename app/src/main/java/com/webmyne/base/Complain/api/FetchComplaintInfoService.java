package com.webmyne.base.Complain.api;

import com.webmyne.base.Complain.model.MainFetchComplainInfo;
import com.webmyne.base.utils.Conts;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by priyasindkar on 25-03-2016.
 */
public interface FetchComplaintInfoService {
    @GET(Conts.FETCH_COMPLAINT_INFO_URL)
    Call<MainFetchComplainInfo> getResp();
}
