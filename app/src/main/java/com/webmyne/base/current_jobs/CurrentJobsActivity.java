package com.webmyne.base.current_jobs;

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
import com.webmyne.base.current_jobs.adapter.CurrentJobsAdapter;
import com.webmyne.base.current_jobs.api.CurrentJobApi;
import com.webmyne.base.current_jobs.model.CurrentJobResp;
import com.webmyne.base.current_jobs.model.FetchJobResult;
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
public class CurrentJobsActivity extends AppCompatActivity implements View.OnClickListener{
    private CurrentJobsAdapter adapter;
    private RecyclerView recyclerView;
    private TextView txtTitle, txtBack, header;
    private List<FetchJobResult> data1 = new ArrayList<>();
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_jobs);
        init_toolbar();
        init();

    }

    private void init() {
        txtBack = (TextView) findViewById(R.id.txtBack);
        txtBack.setOnClickListener(this);

        txtTitle = (TextView) findViewById(R.id.txtTitle);
        txtTitle.setText("CURRENT JOBS");

        header = (TextView) findViewById(R.id.header);
        
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        if(Functions.haveNetworkConnection(CurrentJobsActivity.this)) {


            dialog = new ProgressDialog(CurrentJobsActivity.this);
            dialog.setMessage(""+getString(R.string.DialogMsg2));
            dialog.setCancelable(false);
            dialog.show();


            CurrentJobApi api = MyApplication.retrofit.create(CurrentJobApi.class);
            Call<CurrentJobResp> call = api.getResp();
            call.enqueue(new Callback<CurrentJobResp>() {
                @Override
                public void onResponse(Call<CurrentJobResp> call, Response<CurrentJobResp> response) {
                    dialog.dismiss();
                    try {
                        if (response.body().FetchJobResult != null) {
                            data1 = response.body().getFetchJobResult();
                        }
                       /* for(int i=0;i<dataArray.size();i++)
                        {
                            // Log.e("onResponse", dataArray.get(i).toString());
                            data1.add(dataArray.get(i));
                        }*/

                        setAdapterData();
                        //   Log.e("onResponse", achivements.toString());
                    } catch (Exception e) {
                        Log.e("### exc", e.toString());
                    }
                }

                @Override
                public void onFailure(Call<CurrentJobResp> call, Throwable t) {
                    dialog.dismiss();
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
        header.setText(data1.size()+" JOB FOUND");
        adapter = new CurrentJobsAdapter(this, data1);
        recyclerView.setAdapter(adapter);
    }

    private void init_toolbar() {
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        ImageView imgNew= (ImageView) toolbar.findViewById(R.id.imgNews);
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
