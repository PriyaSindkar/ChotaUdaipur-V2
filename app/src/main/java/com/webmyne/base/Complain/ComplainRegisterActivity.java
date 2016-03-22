package com.webmyne.base.Complain;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.webmyne.R;
import com.webmyne.base.Complain.adpter.mySpinnerAdapter;
import com.webmyne.base.news.NewsActivity;

import java.util.ArrayList;

/**
 * Created by vaibhavirana on 21-03-2016.
 */
public class ComplainRegisterActivity extends AppCompatActivity implements View.OnClickListener{

    Spinner spComplaintCategory,spComplaintCode,spWard;
    private TextView txtBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.complain_main);
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


        ArrayList<String> Category=new ArrayList<>();
        Category.add("Complaint Category");
        for(int i=1;i<5;i++)
        {
            Category.add("Complaint category "+i+"");
        }
        spComplaintCategory=(Spinner)findViewById(R.id.spComplaintCategory);
        mySpinnerAdapter boardAdapter = new mySpinnerAdapter(ComplainRegisterActivity.this, Category, R.layout.spinner_main_view, R.layout.spinner_drop_view);
        spComplaintCategory.setAdapter(boardAdapter);

        ArrayList<String> code=new ArrayList<>();
        code.add("Complaint Code");
        for(int i=1;i<5;i++)
        {
            code.add("Complaint code "+i+"");
        }
        spComplaintCode=(Spinner)findViewById(R.id.spComplaintCode);
        mySpinnerAdapter boardAdapter1 = new mySpinnerAdapter(ComplainRegisterActivity.this, code, R.layout.spinner_main_view, R.layout.spinner_drop_view);
        spComplaintCode.setAdapter(boardAdapter1);

        ArrayList<String> ward=new ArrayList<>();
        ward.add("Ward");
        for(int i=1;i<12;i++)
        {
            ward.add("Ward "+i+"");
        }
        spWard=(Spinner)findViewById(R.id.spWard);
        mySpinnerAdapter boardAdapter2 = new mySpinnerAdapter(ComplainRegisterActivity.this, ward, R.layout.spinner_main_view, R.layout.spinner_drop_view);
        spWard.setAdapter(boardAdapter2);

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
