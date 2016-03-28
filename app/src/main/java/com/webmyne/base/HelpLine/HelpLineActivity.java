package com.webmyne.base.HelpLine;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Paint;
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
import com.webmyne.base.Achievement.adapter.AchievementAdapter;
import com.webmyne.base.Achievement.api.AchievementApi;
import com.webmyne.base.Achievement.model.AchievementResp;
import com.webmyne.base.Achievement.model.AchievementResult;
import com.webmyne.base.HelpLine.adapter.HelpLineAdapter;
import com.webmyne.base.HelpLine.api.HelpLineApi;
import com.webmyne.base.HelpLine.model.HelpLineResult;
import com.webmyne.base.HelpLine.model.HelplineResp;
import com.webmyne.base.base.MyApplication;
import com.webmyne.base.news.NewsActivity;
import com.webmyne.base.utils.Functions;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by vaibhavirana on 21-03-2016.
 */
public class HelpLineActivity extends AppCompatActivity implements View.OnClickListener{

    private HelpLineAdapter adapter;
    private RecyclerView recyclerView;
   // ArrayList<String> items;
    private TextView txtBack;
    private ProgressDialog dialog;
    private List<HelpLineResult> helpline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.helpline_main);

        init_toolbar();
        init();

    }

    private void init() {
        txtBack = (TextView) findViewById(R.id.txtBack);
        txtBack.setOnClickListener(this);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        helpline=new ArrayList<HelpLineResult>();
        if(Functions.haveNetworkConnection(HelpLineActivity.this)) {
            HelpLineApi api = MyApplication.retrofit.create(HelpLineApi.class);
            Call<HelplineResp> call = api.getResp();
            call.enqueue(new Callback<HelplineResp>() {
                @Override
                public void onResponse(Call<HelplineResp> call, Response<HelplineResp> response) {

                    try {
                        // Log.e("onResponse", response.body().getAchievementResultl().toString());
                        if (response.body().HelpLineResult != null) {
                            helpline = response.body().getHelpLineResult();
                        }

                        /*for(int i=0;i<dataArray.size();i++)
                        {
                            // Log.e("onResponse", dataArray.get(i).toString());
                            helpline.add(dataArray.get(i));
                        }*/
                        setDataAdapter();

                        //   Log.e("onResponse", achivements.toString());
                    } catch (Exception e) {
                        Log.e("### exc", e.toString());
                    }

                }

                @Override
                public void onFailure(Call<HelplineResp> call, Throwable t) {
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

    private void setDataAdapter(){

        adapter = new HelpLineAdapter(helpline);
        recyclerView.setAdapter(adapter);
    }

  /*  private void setdata() {
        items=new ArrayList<>();
        items.add("All Indian Railway Helpline number : 1512");
        items.add("Police Control Room (All over in India): 100");
        items.add("Women's Helpline (All Over in India) : 181");
        items.add("Ambulance helpline : 108");
        items.add("AIDS Helpline (All Over in India) : 1097");
        items.add("Fire Services (All Over in India) : 101");
        items.add("Railway Inquiry : 139/2457901");
        items.add("Traffic Branch  : 22865012");
        items.add("Sterling Hospital : 2588002/04");
        items.add("GEB Complain : 155333");
        items.add("Bhaktinagar Railway Inquiry : 2463352");
    }
*/
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.txtBack:
                onBackPressed();
                break;
        }
    }

}
