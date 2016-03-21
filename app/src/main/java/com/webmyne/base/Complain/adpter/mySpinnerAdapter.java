package com.webmyne.base.Complain.adpter;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SpinnerAdapter;
import android.widget.TextView;


import com.webmyne.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by krishnakumar on 14-03-2016.
 */
public class mySpinnerAdapter extends BaseAdapter implements SpinnerAdapter {

    LayoutInflater layoutInflator;

    ArrayList values;
    Context ctx;
    int mainSpinnerView, dropSpinnerView;

    public mySpinnerAdapter(Context context, ArrayList<String> list, int mainView, int dropView) {
        this.values = list;
        ctx = context;
        mainSpinnerView = mainView;
        dropSpinnerView = dropView;

    }

    @Override
    public int getCount() {
        return values.size();
    }

    @Override
    public Object getItem(int i) {
        return values.get(i);
    }

    @Override
    public long getItemId(int position) {
        return (long)position;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        layoutInflator = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = convertView;

        view = layoutInflator.inflate(dropSpinnerView, parent, false);

        TextView txt = (TextView) view.findViewById(R.id.spID);

        txt.setPadding(12, 12, 12, 12);
        txt.setTextSize(12);
        txt.setGravity(Gravity.CENTER_VERTICAL);
    //    txt.setTypeface(PrefUtils.getNexaLight(ctx));
//        txt.setTextColor(Color.parseColor("#000000"));
        txt.setText(values.get(position).toString());

        return view;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewgroup) {
        layoutInflator = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = convertView;

        view = layoutInflator.inflate(mainSpinnerView, viewgroup, false);

        TextView txt = (TextView) view.findViewById(R.id.spID);

        txt.setGravity(Gravity.CENTER_VERTICAL);
        txt.setPadding(12, 12, 12, 12);
        txt.setTextSize(12);
  //      txt.setTypeface(PrefUtils.getNexaLight(ctx));
//        txt.setTextColor(Color.parseColor("#000000"));
        txt.setText(values.get(position).toString());
        return view;
    }
}
