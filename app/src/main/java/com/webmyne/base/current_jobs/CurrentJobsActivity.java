package com.webmyne.base.current_jobs;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.webmyne.R;
import com.webmyne.base.current_jobs.adapter.CurrentJobsAdapter;
import com.webmyne.base.current_jobs.model.CurrentJobsDataObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by priyasindkar on 21-03-2016.
 */
public class CurrentJobsActivity extends AppCompatActivity implements View.OnClickListener{
    private CurrentJobsAdapter adapter;
    private RecyclerView recyclerView;
    private TextView txtTitle, txtBack;
    private List<CurrentJobsDataObject> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_jobs);

        txtTitle = (TextView) findViewById(R.id.txtTitle);
        txtTitle.setText("CURRENT JOBS");
        txtBack = (TextView) findViewById(R.id.txtBack);
        txtBack.setOnClickListener(this);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        setData();
        adapter = new CurrentJobsAdapter(this, data);
        recyclerView.setAdapter(adapter);
    }

    private void setData() {
        data.add(new CurrentJobsDataObject());
        data.add(new CurrentJobsDataObject());
        data.add(new CurrentJobsDataObject());
        data.add(new CurrentJobsDataObject());
        data.add(new CurrentJobsDataObject());
        data.add(new CurrentJobsDataObject());
        data.add(new CurrentJobsDataObject());
        data.add(new CurrentJobsDataObject());
        data.add(new CurrentJobsDataObject());
        data.add(new CurrentJobsDataObject());

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
