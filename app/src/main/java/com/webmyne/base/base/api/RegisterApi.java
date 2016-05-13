package com.webmyne.base.base.api;

import com.webmyne.base.base.model.Regrequest;
import com.webmyne.base.base.model.RegisterResponse;
import com.webmyne.base.utils.Conts;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by vaibhavirana on 23-03-2016.
 */
public interface RegisterApi {

    @POST(Conts.REGISTER_URL)
    Call<RegisterResponse> callRegisterDevice(@Body Regrequest registerRequest);
}
