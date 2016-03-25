package com.webmyne.base.news;

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
import com.webmyne.base.base.MyApplication;
import com.webmyne.base.current_jobs.api.CurrentJobApi;
import com.webmyne.base.current_jobs.model.CurrentJobResp;
import com.webmyne.base.current_jobs.model.FetchJobResult;
import com.webmyne.base.news.adapter.NewsAdapter;
import com.webmyne.base.news.api.NewsApi;
import com.webmyne.base.news.model.FetchNewsResult;
import com.webmyne.base.news.model.NewsResp;
import com.webmyne.base.utils.Functions;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by priyasindkar on 21-03-2016.
 */
public class NewsActivity extends AppCompatActivity implements View.OnClickListener{
    private NewsAdapter adapter;
    private RecyclerView recyclerView;
    private TextView txtTitle, txtBack;
    private ProgressDialog dialog;
    private List<FetchNewsResult> data1 = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        init_toolbar();
        init();
    }

    private void init() {
        txtTitle = (TextView) findViewById(R.id.txtTitle);
        txtTitle.setText(R.string.news);
        txtBack = (TextView) findViewById(R.id.txtBack);
        txtBack.setOnClickListener(this);

        if(Functions.haveNetworkConnection(NewsActivity.this)) {
            NewsApi api = MyApplication.retrofit.create(NewsApi.class);
            Call<NewsResp> call = api.getResp();
            call.enqueue(new Callback<NewsResp>() {
                @Override
                public void onResponse(Call<NewsResp> call, Response<NewsResp> response) {

                    try {
                        // Log.e("onResponse", response.body().getAchievementResultl().toString());
                        ArrayList<FetchNewsResult> dataArray = response.body().getFetchNewsResult();
                        for(int i=0;i<dataArray.size();i++)
                        {
                            // Log.e("onResponse", dataArray.get(i).toString());
                            data1.add(dataArray.get(i));
                        }
                           //Log.e("onResponse", data1.toString());
                    } catch (Exception e) {
                        Log.e("### exc", e.toString());
                    }
                }

                @Override
                public void onFailure(Call<NewsResp> call, Throwable t) {
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
        adapter = new NewsAdapter(NewsActivity.this,data1);
        recyclerView.setAdapter(adapter);
    }

    private void init_toolbar() {
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        ImageView imgNew= (ImageView) toolbar.findViewById(R.id.imgNews);
        imgNew.setVisibility(View.INVISIBLE);
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
