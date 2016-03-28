package com.webmyne.base.Achievement;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.webmyne.R;
import com.webmyne.base.AboutUs.About_UsActivity;
import com.webmyne.base.AboutUs.api.AboutusApi;
import com.webmyne.base.AboutUs.model.AboutUsModel;
import com.webmyne.base.AboutUs.model.AboutUsResp;
import com.webmyne.base.Achievement.adapter.AchievementAdapter;
import com.webmyne.base.Achievement.api.AchievementApi;
import com.webmyne.base.Achievement.model.AchievementResp;
import com.webmyne.base.Achievement.model.AchievementResult;
import com.webmyne.base.base.MyApplication;
import com.webmyne.base.news.NewsActivity;
import com.webmyne.base.news.adapter.NewsAdapter;
import com.webmyne.base.utils.Functions;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by vaibhavirana on 21-03-2016.
 */
public class Achievement_Activity extends AppCompatActivity implements View.OnClickListener {

    private AchievementAdapter adapter;
    private RecyclerView recyclerView;
    private TextView  txtBack;
    private Toolbar toolbar;
    private ImageView imgNew;
    private ProgressDialog dialog;
    private List<AchievementResult> achivements;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.achievement_main);

        init_toolbar();
        init();

    }

    private void init() {
        txtBack = (TextView) findViewById(R.id.txtBack);
        txtBack.setOnClickListener(this);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);


        achivements=new ArrayList<AchievementResult>();
        if(Functions.haveNetworkConnection(Achievement_Activity.this)) {
            AchievementApi api = MyApplication.retrofit.create(AchievementApi.class);
            Call<AchievementResp> call = api.getResp();
            call.enqueue(new Callback<AchievementResp>() {
                @Override
                public void onResponse(Call<AchievementResp> call, Response<AchievementResp> response) {
                    try {
                       // Log.e("onResponse", response.body().getAchievementResultl().toString());
                        achivements=response.body().getAchievementResultl();
                        /*ArrayList<AchievementResult> dataArray = response.body().getAchievementResultl();

                        for(int i=0;i<dataArray.size();i++)
                        {
                           // Log.e("onResponse", dataArray.get(i).toString());
                            achivements.add(dataArray.get(i));
                        }*/
                        setAdapterData();

                     //   Log.e("onResponse", achivements.toString());
                    } catch (Exception e) {
                        Log.e("### exc", e.toString());
                    }

                }

                @Override
                public void onFailure(Call<AchievementResp> call, Throwable t) {
                    Log.e("onFailure", t.toString());
                }
            });
        }
        else {
            dialog = new ProgressDialog(this);
            dialog.setMessage(getString(R.string.check_conn));
            dialog.show();
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {
                    dialog.dismiss();
                    finish();
                }
            }, 2500);
        }


    }

    private void setAdapterData(){

        adapter = new AchievementAdapter(Achievement_Activity.this,achivements);
        recyclerView.setAdapter(adapter);
    }


    private void init_toolbar() {
        toolbar=(Toolbar)findViewById(R.id.toolbar);
        imgNew= (ImageView) toolbar.findViewById(R.id.imgNews);
        imgNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), NewsActivity.class);
                startActivity(intent);
            }
        });
    }

    
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.txtBack:
                onBackPressed();
                break;
        }
    }

}
