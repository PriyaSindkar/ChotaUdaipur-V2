package com.webmyne.base.AboutUs;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.webmyne.R;
import com.webmyne.base.AboutUs.api.AboutusApi;
import com.webmyne.base.AboutUs.model.AboutUsModel;
import com.webmyne.base.AboutUs.model.AboutUsResp;
import com.webmyne.base.base.MainActivity;
import com.webmyne.base.base.MyApplication;
import com.webmyne.base.news.NewsActivity;
import com.webmyne.base.ui.JustifiedTextView;
import com.webmyne.base.utils.Functions;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by vaibhavirana on 21-03-2016.
 */
public class About_UsActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView  txtBack;
    private JustifiedTextView txtAboutUs;
    private Toolbar toolbar;
    private ImageView imgNew,img;
    private ProgressDialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_us_main);

        init_toolbar();
        init();

    }

    private void init_toolbar() {
        toolbar=(Toolbar)findViewById(R.id.toolbar);
        imgNew= (ImageView) toolbar.findViewById(R.id.imgNews);
        imgNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), NewsActivity.class);
                startActivity(intent);
            }
        });
    }

    private void init() {
        txtBack = (TextView) findViewById(R.id.txtBack);
        txtBack.setOnClickListener(this);
        img=(ImageView)findViewById(R.id.imageView2);

        txtAboutUs=(JustifiedTextView)findViewById(R.id.activity_main_jtv);
        txtAboutUs.setAlignment(Paint.Align.LEFT);
       // txtAboutUs.setText(R.string.aboutChhotaUdepur);

        if(Functions.haveNetworkConnection(About_UsActivity.this)) {
            AboutusApi api = MyApplication.retrofit.create(AboutusApi.class);
            Call<AboutUsResp> call = api.getResp();
            call.enqueue(new Callback<AboutUsResp>() {
                @Override
                public void onResponse(Call<AboutUsResp> call, Response<AboutUsResp> response) {

                   // Log.e("onResponse", response.body().toString());

                    try {
                        ArrayList<AboutUsModel> dataArray = response.body().getAboutUSResult();
                        txtAboutUs.setText(String.valueOf(Html.fromHtml(dataArray.get(0).getDescription())));
                        // Toast.makeText(About_UsActivity.this, "" + dataArray.get(0).getImage(), Toast.LENGTH_SHORT).show();
                        Glide.with(getApplicationContext())
                                .load(dataArray.get(0).getImage())
                                .diskCacheStrategy(DiskCacheStrategy.ALL)
                                .into(img);
                        //Picasso.with(getApplicationContext()).load(dataArray.get(0).getImage()).into(img);
                        //  img.setImageResource(Integer.parseInt(dataArray.get(0).getImage()));
                    } catch (Exception e) {
                        Log.e("### exc", e.toString());
                    }

                }

                @Override
                public void onFailure(Call<AboutUsResp> call, Throwable t) {
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


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.txtBack:
                onBackPressed();
                break;
        }
    }

}