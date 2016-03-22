package com.webmyne.base.Complain;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.webmyne.R;
import com.webmyne.base.news.NewsActivity;

/**
 * Created by vaibhavirana on 21-03-2016.
 */
public class Complaint_statusActivity extends AppCompatActivity implements View.OnClickListener{
    Button edtRegNew;
    private TextView txtBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.complaint_status_main);
        txtBack = (TextView) findViewById(R.id.txtBack);
        txtBack.setOnClickListener(this);

        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        ImageView imgNew= (ImageView) toolbar.findViewById(R.id.imgNews);
        imgNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), NewsActivity.class);
                startActivity(intent);
            }
        });


        edtRegNew = (Button) findViewById(R.id.edtRegNew);
        edtRegNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Complaint_statusActivity.this, ComplainRegisterActivity.class);
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
