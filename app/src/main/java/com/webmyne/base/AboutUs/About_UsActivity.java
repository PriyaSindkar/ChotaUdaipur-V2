package com.webmyne.base.AboutUs;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.webmyne.R;
import com.webmyne.base.news.NewsActivity;
import com.webmyne.base.ui.JustifiedTextView;

/**
 * Created by vaibhavirana on 21-03-2016.
 */
public class About_UsActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView  txtBack;
    JustifiedTextView txtAboutUs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_us_main);
        txtBack = (TextView) findViewById(R.id.txtBack);
        txtBack.setOnClickListener(this);

        txtAboutUs=(JustifiedTextView)findViewById(R.id.activity_main_jtv);
        txtAboutUs.setAlignment(Paint.Align.LEFT);
        txtAboutUs.setText(R.string.aboutChhotaUdepur);

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
