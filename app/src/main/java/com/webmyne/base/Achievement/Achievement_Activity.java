package com.webmyne.base.Achievement;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.webmyne.R;
import com.webmyne.base.Achievement.adapter.AchievementAdapter;
import com.webmyne.base.news.adapter.NewsAdapter;

/**
 * Created by vaibhavirana on 21-03-2016.
 */
public class Achievement_Activity extends AppCompatActivity {

    private AchievementAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.achievement_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new AchievementAdapter();
        recyclerView.setAdapter(adapter);
    }
}
