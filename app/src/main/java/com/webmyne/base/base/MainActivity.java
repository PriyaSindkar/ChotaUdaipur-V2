package com.webmyne.base.base;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.webmyne.R;
import com.webmyne.base.AboutUs.About_UsActivity;
import com.webmyne.base.Achievement.Achievement_Activity;
import com.webmyne.base.Complain.ComplainRegisterActivity;
import com.webmyne.base.Complain.Complaint_statusActivity;
import com.webmyne.base.HelpLine.HelpLineActivity;
import com.webmyne.base.Tender.TenderActivity;
import com.webmyne.base.base.adapter.MyRecyclerViewAdapter;
import com.webmyne.base.current_jobs.CurrentJobsActivity;
import com.webmyne.base.listeners.OnItemSelected;
import com.webmyne.base.management.ManagementActivity;
import com.webmyne.base.news.NewsActivity;
import com.webmyne.base.touristSpots.TouristSpotsActivity;
import com.webmyne.base.touristSpots.adapter.TouristSpotsAdapter;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private MyRecyclerViewAdapter mAdapter;

    ArrayList menu = new ArrayList<String>();
    ArrayList menuicon = new ArrayList<Integer>();
    ArrayList menubgcolor = new ArrayList<String>();

    private int actionBarHeight, useheight, totalheight;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        ImageView imgNew= (ImageView) toolbar.findViewById(R.id.imgNews);
        imgNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), NewsActivity.class);
                startActivity(intent);
            }
        });


        menu.add("ABOUT US");
        menu.add("MANAGEMENT");
        menu.add("COMPLAINS");
        menu.add("ACHIVEMENTS");
        menu.add("JOBS");
        menu.add("TOURIST SPOTS");
        menu.add("HELPLINES");
        menu.add("TENDER");

        menuicon.add(R.drawable.aboutus);
        menuicon.add(R.drawable.management);
        menuicon.add(R.drawable.complains);
        menuicon.add(R.drawable.acheivments);
        menuicon.add(R.drawable.jobs);
        menuicon.add(R.drawable.tourists);
        menuicon.add(R.drawable.helpline);
        menuicon.add(R.drawable.tender);

        menubgcolor.add("#e91e63");
        menubgcolor.add("#ffc107");
        menubgcolor.add("#2196f3");
        menubgcolor.add("#e53935");
        menubgcolor.add("#2e7d32");
        menubgcolor.add("#4a148c");
        menubgcolor.add("#d500f9");
        menubgcolor.add("#f57c00");

        mAdapter = new MyRecyclerViewAdapter(this, menu, menuicon, menubgcolor, (getHeight() / 4));
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        //RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        // mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemSelectedListener(new OnItemSelected() {
            @Override
            public void onItemSelected(String itemName) {
                if(itemName.equalsIgnoreCase("MANAGEMENT")) {
                    Intent intent = new Intent(MainActivity.this, ManagementActivity.class);
                    startActivity(intent);
                } else if(itemName.equalsIgnoreCase("JOBS")) {
                    Intent intent = new Intent(MainActivity.this, CurrentJobsActivity.class);
                    startActivity(intent);
                } else if(itemName.equalsIgnoreCase("TOURIST SPOTS")) {
                    Intent intent = new Intent(MainActivity.this, TouristSpotsActivity.class);
                    startActivity(intent);
                } else if(itemName.equalsIgnoreCase("ABOUT US")) {
                    Intent intent = new Intent(MainActivity.this, About_UsActivity.class);
                    startActivity(intent);
                }  else if(itemName.equalsIgnoreCase("COMPLAINS")) {
                    Intent intent = new Intent(MainActivity.this, Complaint_statusActivity.class);
                    startActivity(intent);
                } else if(itemName.equalsIgnoreCase("ACHIVEMENTS")) {
                    Intent intent = new Intent(MainActivity.this, Achievement_Activity.class);
                    startActivity(intent);
                } else if(itemName.equalsIgnoreCase("HELPLINES")) {
                    Intent intent = new Intent(MainActivity.this, HelpLineActivity.class);
                    startActivity(intent);
                } else if(itemName.equalsIgnoreCase("TENDER")) {
                    Intent intent = new Intent(MainActivity.this, TenderActivity.class);
                    startActivity(intent);
                }
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
       /* if (id == R.id.action_settings) {
            return true;
        }
*/
        return super.onOptionsItemSelected(item);
    }

    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    public int getHeight() {
        TypedValue tv = new TypedValue();
        if (getTheme().resolveAttribute(android.R.attr.actionBarSize, tv, true)) {
            actionBarHeight = TypedValue.complexToDimensionPixelSize(tv.data, getResources().getDisplayMetrics());
        }
        Display display = getWindowManager().getDefaultDisplay();
        //int width = display.getWidth();  // deprecated
        totalheight = display.getHeight();
        /// 10 for padding
        useheight = actionBarHeight + getStatusBarHeight() + 20;
        return totalheight - useheight;
    }
}
