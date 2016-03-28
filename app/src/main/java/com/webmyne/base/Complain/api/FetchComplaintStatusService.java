package com.webmyne.base.Complain.api;

import com.webmyne.base.Complain.model.ComplainStatusResult;
import com.webmyne.base.Complain.model.MainComplainStatusResult;
import com.webmyne.base.utils.Conts;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by priyasindkar on 25-03-2016.
 */
public interface FetchComplaintStatusService {
    @GET(Conts.FETCH_COMPLAINT_STATUS_URL)
    Call<MainComplainStatusResult> getResp(@Path("COMPLAINTID") String complaintId);
}
