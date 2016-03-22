package com.webmyne.base.news;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.webmyne.R;
import com.webmyne.base.news.adapter.NewsAdapter;

/**
 * Created by priyasindkar on 21-03-2016.
 */
public class NewsActivity extends AppCompatActivity implements View.OnClickListener{
    private NewsAdapter adapter;
    private RecyclerView recyclerView;
    private TextView txtTitle, txtBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        ImageView imgNew= (ImageView) toolbar.findViewById(R.id.imgNews);
        imgNew.setVisibility(View.INVISIBLE);


        txtTitle = (TextView) findViewById(R.id.txtTitle);
        txtTitle.setText(R.string.news);
        txtBack = (TextView) findViewById(R.id.txtBack);
        txtBack.setOnClickListener(this);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new NewsAdapter();
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
