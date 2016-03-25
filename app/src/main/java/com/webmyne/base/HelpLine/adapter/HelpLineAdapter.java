package com.webmyne.base.HelpLine.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.webmyne.R;
import com.webmyne.base.HelpLine.model.HelpLineResult;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vaibhavirana on 10-03-2016.
 */
public class HelpLineAdapter extends RecyclerView.Adapter<HelpLineAdapter.MyViewHolder> {

    List<HelpLineResult> items;

    public HelpLineAdapter(List<HelpLineResult> items) {
        this.items=items;
    }

    @Override
    public HelpLineAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.helpline_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(HelpLineAdapter.MyViewHolder holder, int position) {
        holder.txtViewTitle.setText(items.get(position).Name + " : "+ items.get(position).ContactNo);
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView txtViewTitle;

        public MyViewHolder(View itemView) {
            super(itemView);
            txtViewTitle = (TextView) itemView.findViewById(R.id.item_title);
        }
    }
}
