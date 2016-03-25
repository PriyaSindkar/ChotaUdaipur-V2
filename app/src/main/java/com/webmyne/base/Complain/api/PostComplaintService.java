package com.webmyne.base.Complain.api;

import com.webmyne.base.Complain.model.ComplainRegisterRequest;
import com.webmyne.base.Complain.model.MainComplainRegisterResult;
import com.webmyne.base.utils.Conts;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by priyasindkar on 25-03-2016.
 */
public interface PostComplaintService {
    @POST(Conts.POST_COMPLAINT_URL)
    Call<MainComplainRegisterResult> doPostComplain(@Body ComplainRegisterRequest registerRequest);
}
