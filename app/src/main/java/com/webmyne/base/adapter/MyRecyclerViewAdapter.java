package com.webmyne.base.adapter;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.webmyne.R;

import java.util.ArrayList;

/**
 * Created by vaibhavirana on 10-03-2016.
 */
public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> {
    ArrayList<String> mDataset, mDatasetBgColor;
    ArrayList<Integer> mDatasetIcon;
    int h;

    public MyRecyclerViewAdapter(ArrayList<String> data, ArrayList menuicon, ArrayList menubgcolor, int height) {
        mDataset = data;
        mDatasetIcon = menuicon;
        mDatasetBgColor = menubgcolor;
        h = height;
    }

    @Override
    public MyRecyclerViewAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_main, parent, false);
        itemView.setLayoutParams(new RecyclerView.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, h));
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyRecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.ll1.setBackgroundColor(Color.parseColor(mDatasetBgColor.get(position)));
        holder.title.setText(mDataset.get(position).toString());
        holder.imgIcon.setImageResource(mDatasetIcon.get(position));
    }


    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView imgIcon;
        LinearLayout ll1;

        public MyViewHolder(View itemView) {
            super(itemView);
            ll1 = (LinearLayout) itemView.findViewById(R.id.ll1);
            title = (TextView) itemView.findViewById(R.id.txtMenuName);
            imgIcon = (ImageView) itemView.findViewById(R.id.imgIcon);
        }
    }
}
