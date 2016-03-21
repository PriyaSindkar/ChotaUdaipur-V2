package com.webmyne.base.news;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.webmyne.R;
import com.webmyne.base.news.adapter.NewsAdapter;

/**
 * Created by priyasindkar on 21-03-2016.
 */
public class NewsActivity extends AppCompatActivity {
    private NewsAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new NewsAdapter();
        recyclerView.setAdapter(adapter);

    }
}
