package com.webmyne.base;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;

import com.webmyne.R;

/**
 * Created by vaibhavirana on 09-03-2016.
 */
public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_main);

        ProgressBar v = (ProgressBar) findViewById(R.id.progressBar);
        v.getIndeterminateDrawable().setColorFilter(0xFFFFFFFF,
                android.graphics.PorterDuff.Mode.MULTIPLY);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                Intent i1=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i1);
                finish();
            }
        }, 2500);
    }

}
