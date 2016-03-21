package com.webmyne.base.HelpLine;

import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.webmyne.R;
import com.webmyne.base.HelpLine.adapter.HelpLineAdapter;

import java.util.ArrayList;

/**
 * Created by vaibhavirana on 21-03-2016.
 */
public class HelpLineActivity extends AppCompatActivity {

    private HelpLineAdapter adapter;
    private RecyclerView recyclerView;
    ArrayList<String> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.helpline_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        items=new ArrayList<>();
        items.add("All Indian Railway Helpline number : 1512");
        items.add("Police Control Room (All over in India): 100");
        items.add("Women's Helpline (All Over in India) : 181");
        items.add("Ambulance helpline : 108");
        items.add("AIDS Helpline (All Over in India) : 1097");
        items.add("Fire Services (All Over in India) : 101");
        items.add("Railway Inquiry : 139/2457901");
        items.add("Traffic Branch  : 22865012");
        items.add("Sterling Hospital : 2588002/04");
        items.add("GEB Complain : 155333");
        items.add("Bhaktinagar Railway Inquiry : 2463352");


        adapter = new HelpLineAdapter(items);
        recyclerView.setAdapter(adapter);
    }

}
