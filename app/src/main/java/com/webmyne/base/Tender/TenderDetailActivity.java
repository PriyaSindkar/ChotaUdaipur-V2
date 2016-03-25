package com.webmyne.base.Tender;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.webmyne.R;
import com.webmyne.base.Tender.adapter.TenderAdapter;
import com.webmyne.base.Tender.adapter.TenderDetailAdapter;
import com.webmyne.base.Tender.model.TenderDataObject;
import com.webmyne.base.news.NewsActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vaibhavirana on 22-03-2016.
 */
public class TenderDetailActivity extends AppCompatActivity implements View.OnClickListener {

    private TenderDetailAdapter adapter;
    private RecyclerView recyclerView;
    private TextView  txtBack;
    private List<String> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tender_detail_main);
        init_toolbar();
        init();

    }

    private void init() {
        txtBack = (TextView) findViewById(R.id.txtBack);
        txtBack.setOnClickListener(this);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        setData();
        adapter = new TenderDetailAdapter((ArrayList<String>) data);
        recyclerView.setAdapter(adapter);
    }

    private void init_toolbar() {
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        ImageView imgNew= (ImageView) toolbar.findViewById(R.id.imgNews);
        imgNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), NewsActivity.class);
                startActivity(intent);
            }
        });

    }

    private void setData() {
        //getIntent().getSerializableExtra("MyClass");
        String desc="Description : "+R.string.lorem_ipsum;
        data.add(desc);
        String tenderno="Tender Notice No : "+getIntent().getStringExtra("tenderNo");
        data.add(tenderno);
        String tenderdate="Tender Notice Date : "+getIntent().getStringExtra("StrtDate");
        data.add(tenderdate);
       /* data.add(getIntent().getStringExtra("tenderNo"));
        data.add(getIntent().getStringExtra("StrtDate"));
        data.add(getIntent().getStringExtra("EndDate"));*/
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
