package com.webmyne.base.management.api;

import com.webmyne.base.HelpLine.model.HelplineResp;
import com.webmyne.base.management.model.ManagementResp;
import com.webmyne.base.utils.Conts;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by vaibhavirana on 23-03-2016.
 */
public interface MangamentApi {
    @GET(Conts.MANAGEMENT_URL)
        //here is the other url part.best way is to start using /
    Call<ManagementResp> getResp();
}
