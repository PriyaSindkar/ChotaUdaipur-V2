package com.webmyne.base.Tender;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
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
import com.webmyne.base.AboutUs.About_UsActivity;
import com.webmyne.base.Achievement.Achievement_Activity;
import com.webmyne.base.Complain.Complaint_statusActivity;
import com.webmyne.base.HelpLine.HelpLineActivity;
import com.webmyne.base.Tender.adapter.TenderAdapter;
import com.webmyne.base.Tender.model.TenderDataObject;
import com.webmyne.base.current_jobs.CurrentJobsActivity;
import com.webmyne.base.listeners.OnItemSelected;
import com.webmyne.base.management.ManagementActivity;
import com.webmyne.base.management.adapter.ManagementAdapter;
import com.webmyne.base.management.model.ManagementDataObject;
import com.webmyne.base.news.NewsActivity;
import com.webmyne.base.touristSpots.TouristSpotsActivity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vaibhavirana on 22-03-2016.
 */
public class TenderActivity extends AppCompatActivity implements View.OnClickListener {

    private TenderAdapter adapter;
    private RecyclerView recyclerView;
    private TextView  txtBack;
    private List<TenderDataObject> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tender_main);

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
        adapter = new TenderAdapter(this, data);
        recyclerView.setAdapter(adapter);
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int position) {

                //Toast.makeText(getApplicationContext(), data.get(position).getSrNo() + " is selected!", Toast.LENGTH_SHORT).show();

                Intent intent=new Intent(getApplicationContext(),TenderDetailActivity.class);
                intent.putExtra("SrNo",data.get(position).SrNo);
                intent.putExtra("tenderNo",data.get(position).tenderNo);
                intent.putExtra("StrtDate",data.get(position).StrtDate);
                intent.putExtra("EndDate",data.get(position).EndDate);
                startActivity(intent);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
    }

    private void init_toolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        ImageView imgNew= (ImageView) toolbar.findViewById(R.id.imgNews);
        imgNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), NewsActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setData() {
        TenderDataObject TenderDataObject = new TenderDataObject("1", "AS.C.E./WestZone/13/2016-17",  "5/20/2016 11:00AM", "6/23/2016 5:00 PM");
        data.add(TenderDataObject);
        TenderDataObject = new TenderDataObject("2", "AS.C.E./WestZone/13/2016-17", "5/20/2016 11:00AM", "6/23/2016 5:00 PM");
        data.add(TenderDataObject);
        TenderDataObject = new TenderDataObject("3", "AS.C.E./WestZone/13/2016-17", "5/20/2016 11:00AM", "6/23/2016 5:00 PM");
        data.add(TenderDataObject);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.txtBack:
                onBackPressed();
                break;
        }
    }

    private class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {
        private GestureDetector gestureDetector;
        private TenderActivity.ClickListener clickListener;

        public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final TenderActivity.ClickListener clickListener) {
            this.clickListener = clickListener;
            gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                    if (child != null && clickListener != null) {
                        clickListener.onLongClick(child, recyclerView.getChildPosition(child));
                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
            View child = rv.findChildViewUnder(e.getX(), e.getY());
            if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
                clickListener.onClick(child, rv.getChildPosition(child));
            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {

        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }
    }

    public interface ClickListener {
        void onClick(View view, int position);

        void onLongClick(View view, int position);
    }
}
