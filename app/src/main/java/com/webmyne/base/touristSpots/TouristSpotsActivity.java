package com.webmyne.base.touristSpots;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.webmyne.R;
import com.webmyne.base.touristSpots.adapter.TouristSpotsAdapter;

/**
 * Created by priyasindkar on 21-03-2016.
 */
public class TouristSpotsActivity extends AppCompatActivity implements View.OnClickListener{
    private TouristSpotsAdapter adapter;
    private RecyclerView recyclerView;
    private TextView txtTitle, txtBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        txtTitle = (TextView) findViewById(R.id.txtTitle);
        txtTitle.setText("TOURIST SPOTS");
        txtBack = (TextView) findViewById(R.id.txtBack);
        txtBack.setOnClickListener(this);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        adapter = new TouristSpotsAdapter(this);
        recyclerView.setLayoutManager(gridLayoutManager);
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
