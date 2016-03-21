package com.webmyne.base;

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

import com.webmyne.R;
import com.webmyne.base.adapter.MyRecyclerViewAdapter;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;

    ArrayList menu = new ArrayList<String>();
    ArrayList menuicon = new ArrayList<Integer>();
    ArrayList menubgcolor = new ArrayList<String>();

    private int actionBarHeight, useheight, totalheight;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setLogo(getResources().getDrawable(R.mipmap.logo));
        //toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.menu));

        toolbar.setTitleTextColor(getResources().getColor(R.color.colorAccent));
        toolbar.setSubtitleTextColor(Color.BLACK);
        getSupportActionBar().setSubtitle("CHHOTA UDEPUR");
        getSupportActionBar().setTitle("NAGAR SEVA SADAN");

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

        mAdapter = new MyRecyclerViewAdapter(menu, menuicon, menubgcolor, (getHeight() / 4));
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        //RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        // mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAdapter);

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
        useheight = actionBarHeight + getStatusBarHeight() + 10;
        return totalheight - useheight;
    }
}
