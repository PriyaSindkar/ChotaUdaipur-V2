package com.webmyne.base.management;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.webmyne.R;
import com.webmyne.base.AboutUs.api.AboutusApi;
import com.webmyne.base.AboutUs.model.AboutUsModel;
import com.webmyne.base.AboutUs.model.AboutUsResp;
import com.webmyne.base.Achievement.model.AchievementResult;
import com.webmyne.base.base.MyApplication;
import com.webmyne.base.management.adapter.ManagementAdapter;
import com.webmyne.base.management.api.MangamentApi;
import com.webmyne.base.management.model.ManagementDataObject;
import com.webmyne.base.management.model.ManagementResp;
import com.webmyne.base.management.model.ManagementResult;
import com.webmyne.base.news.NewsActivity;
import com.webmyne.base.utils.Functions;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by priyasindkar on 21-03-2016.
 */
public class ManagementActivity extends AppCompatActivity implements View.OnClickListener{
    private ManagementAdapter adapter;
    private RecyclerView recyclerView;
    private TextView txtTitle, txtBack;
    //private List<ManagementDataObject> data = new ArrayList<>();
    private ProgressDialog dialog;
    private ArrayList<ManagementResult> dataArray1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        init_toolbar();
        init();
    }

    private void init() {

        txtTitle = (TextView) findViewById(R.id.txtTitle);
        txtTitle.setText(R.string.management);
        txtBack = (TextView) findViewById(R.id.txtBack);
        txtBack.setOnClickListener(this);

        dataArray1=new ArrayList<>();
        if(Functions.haveNetworkConnection(ManagementActivity.this)) {
            MangamentApi api = MyApplication.retrofit.create(MangamentApi.class);
            Call<ManagementResp> call = api.getResp();
            call.enqueue(new Callback<ManagementResp>() {
                @Override
                public void onResponse(Call<ManagementResp> call, Response<ManagementResp> response) {

                    try {
                        // Log.e("onResponse", response.body().getAchievementResultl().toString());
                        ArrayList<ManagementResult> dataArray = response.body().getManagementResult();

                        for(int i=0;i<dataArray.size();i++)
                        {
                            // Log.e("onResponse", dataArray.get(i).toString());
                            dataArray1.add(dataArray.get(i));
                        }
                        //   Log.e("onResponse", achivements.toString());
                    } catch (Exception e) {
                        Log.e("### exc", e.toString());
                    }
                }

                @Override
                public void onFailure(Call<ManagementResp> call, Throwable t) {
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


        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        //setData();
        adapter = new ManagementAdapter(this, dataArray1);
        recyclerView.setAdapter(adapter);

    }

    private void init_toolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        ImageView imgNew= (ImageView) toolbar.findViewById(R.id.imgNews);
        imgNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), NewsActivity.class);
                startActivity(intent);
            }
        });
    }
   /* private void setData() {
        ManagementDataObject managementDataObject = new ManagementDataObject("Pramukh", "Mr. Aakash Sharma", "aakash.sharma@gmail.com", "0265-22665658", "+91 8495689963");
        data.add(managementDataObject);
        managementDataObject = new ManagementDataObject("Municipal Commissioner", "Mr. Susam Patel", "susam.patel@gmail.com", "0265-22665658", "+91 8495689963");
        data.add(managementDataObject);
        managementDataObject = new ManagementDataObject("Chief Office", "Mr. Rasiklal Bhatt", "rasiklal.bhatt@gmail.com", "0265-22665658", "+91 8495689963");
        data.add(managementDataObject);
    }*/

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.txtBack:
                onBackPressed();
                break;
        }
    }
}
