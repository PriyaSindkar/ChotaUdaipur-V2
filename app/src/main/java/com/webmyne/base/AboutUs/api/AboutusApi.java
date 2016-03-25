package com.webmyne.base.AboutUs.api;

import com.webmyne.base.AboutUs.model.AboutUsResp;
import com.webmyne.base.utils.Conts;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by vaibhavirana on 23-03-2016.
 */
public interface AboutusApi {
    @GET(Conts.ABOUT_US_URL)
        //here is the other url part.best way is to start using /
    Call<AboutUsResp> getResp();
}
