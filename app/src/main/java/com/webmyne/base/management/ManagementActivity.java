package com.webmyne.base.management;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.webmyne.R;
import com.webmyne.base.management.adapter.ManagementAdapter;
import com.webmyne.base.management.model.ManagementDataObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by priyasindkar on 21-03-2016.
 */
public class ManagementActivity extends AppCompatActivity {
    private ManagementAdapter adapter;
    private RecyclerView recyclerView;
    private TextView txtTitle;
    private List<ManagementDataObject> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        txtTitle = (TextView) findViewById(R.id.txtTitle);
        txtTitle.setText("MANAGEMENT");
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        setData();
        adapter = new ManagementAdapter(this, data);
        recyclerView.setAdapter(adapter);

    }

    private void setData() {
        ManagementDataObject managementDataObject = new ManagementDataObject("Pramukh", "Mr. Aakash Sharma", "aakash.sharma@gmail.com", "0265-22665658", "+91 8495689963");
        data.add(managementDataObject);
        managementDataObject = new ManagementDataObject("Municipal Commissioner", "Mr. Susam Patel", "susam.patel@gmail.com", "0265-22665658", "+91 8495689963");
        data.add(managementDataObject);
        managementDataObject = new ManagementDataObject("Chief Office", "Mr. Rasiklal Bhatt", "rasiklal.bhatt@gmail.com", "0265-22665658", "+91 8495689963");
        data.add(managementDataObject);
    }
}
