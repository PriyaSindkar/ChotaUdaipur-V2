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

    //here is the other url part.best way is to start using /
    // Call<AboutUsResp> getResp();
    //
    @POST(Conts.REGISTER_URL)
    Call<RegisterResponse> callRegisterDevice(@Body Regrequest registerRequest);
}
