package com.webmyne.base.news;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.webmyne.R;
import com.webmyne.base.ui.JustifiedTextView;
import com.webmyne.base.utils.Functions;

public class NewsDetailActivity extends Activity {

    private TextView JustifiedTextView,title,txtNewsDate,txtBack;
    private ImageView imageView2;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);

        init();

        setData();
    }

    private void setData() {
        JustifiedTextView.setText(getIntent().getStringExtra("Description"));
        title.setText(getIntent().getStringExtra("Title"));

        txtNewsDate.setText(getIntent().getStringExtra("Date"));

        JustifiedTextView.setTypeface(Functions.getTypeFace(NewsDetailActivity.this));
        title.setTypeface(Functions.getTypeFace(NewsDetailActivity.this));
        txtNewsDate.setTypeface(Functions.getTypeFace(NewsDetailActivity.this));

        progressBar.setVisibility(View.VISIBLE);
        Glide.with(NewsDetailActivity.this)
                .load(getIntent().getStringExtra("ImageURL"))
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .listener(new RequestListener<String, GlideDrawable>() {
                    @Override
                    public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                        progressBar.setVisibility(View.GONE);
                        return false;
                    }
                })
                .into(imageView2);
    }

    private void init() {
        progressBar = (ProgressBar)findViewById(R.id.progressBar);
        imageView2 = (ImageView)findViewById(R.id.imageView2);
        JustifiedTextView = (TextView)findViewById(R.id.activity_main_jtv);
        title = (TextView)findViewById(R.id.title);
        txtNewsDate = (TextView)findViewById(R.id.txtNewsDate);
        txtBack= (TextView)findViewById(R.id.txtBack);
        txtBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
