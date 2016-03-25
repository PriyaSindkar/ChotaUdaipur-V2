package com.webmyne.base.current_jobs.api;

import com.webmyne.base.Achievement.model.AchievementResp;
import com.webmyne.base.current_jobs.model.CurrentJobResp;
import com.webmyne.base.utils.Conts;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by vaibhavirana on 23-03-2016.
 */
public interface CurrentJobApi {
    @GET(Conts.CURRENTJOB_URL)
        //here is the other url part.best way is to start using /
    Call<CurrentJobResp> getResp();
}
