package com.webmyne.base.touristSpots;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.webmyne.R;
import com.webmyne.base.base.MyApplication;
import com.webmyne.base.news.NewsActivity;
import com.webmyne.base.news.api.NewsApi;
import com.webmyne.base.news.model.FetchNewsResult;
import com.webmyne.base.news.model.NewsResp;
import com.webmyne.base.touristSpots.adapter.TouristSpotsAdapter;
import com.webmyne.base.touristSpots.api.TouristApi;
import com.webmyne.base.touristSpots.model.TouristResult;
import com.webmyne.base.touristSpots.model.ToutistResp;
import com.webmyne.base.utils.Functions;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by priyasindkar on 21-03-2016.
 */
public class TouristSpotsActivity extends AppCompatActivity implements View.OnClickListener{
    private TouristSpotsAdapter adapter;
    private RecyclerView recyclerView;
    private TextView txtTitle, txtBack;
    private ProgressDialog dialog;
    ArrayList<TouristResult> dataArray1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        ImageView imgNew= (ImageView) toolbar.findViewById(R.id.imgNews);
        imgNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), NewsActivity.class);
                startActivity(intent);
            }
        });

        txtTitle = (TextView) findViewById(R.id.txtTitle);
        txtTitle.setText("TOURIST SPOTS");
        txtBack = (TextView) findViewById(R.id.txtBack);
        txtBack.setOnClickListener(this);

        dataArray1=new ArrayList<>();
        if(Functions.haveNetworkConnection(TouristSpotsActivity.this)) {
            TouristApi api = MyApplication.retrofit.create(TouristApi.class);
            Call<ToutistResp> call = api.getResp();
            call.enqueue(new Callback<ToutistResp>() {
                @Override
                public void onResponse(Call<ToutistResp> call, Response<ToutistResp> response) {

                    try {
                        // Log.e("onResponse", response.body().getAchievementResultl().toString());
                        ArrayList<TouristResult> dataArray = response.body().getTouristResult();
                        for(int i=0;i<dataArray.size();i++)
                        {
                            // Log.e("onResponse", dataArray.get(i).toString());
                            dataArray1.add(dataArray.get(i));
                        }
                        Log.e("onResponse", dataArray1.toString());
                    } catch (Exception e) {
                        Log.e("### exc", e.toString());
                    }
                }

                @Override
                public void onFailure(Call<ToutistResp> call, Throwable t) {
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
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        adapter = new TouristSpotsAdapter(this,dataArray1);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);
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
