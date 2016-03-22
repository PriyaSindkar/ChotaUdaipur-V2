package com.webmyne.base.Achievement;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.webmyne.R;
import com.webmyne.base.Achievement.adapter.AchievementAdapter;
import com.webmyne.base.news.NewsActivity;
import com.webmyne.base.news.adapter.NewsAdapter;

/**
 * Created by vaibhavirana on 21-03-2016.
 */
public class Achievement_Activity extends AppCompatActivity implements View.OnClickListener {

    private AchievementAdapter adapter;
    private RecyclerView recyclerView;
    private TextView  txtBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.achievement_main);
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


        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new AchievementAdapter();
        recyclerView.setAdapter(adapter);
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
