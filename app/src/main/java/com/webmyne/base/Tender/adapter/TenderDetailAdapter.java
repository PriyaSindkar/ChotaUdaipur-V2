package com.webmyne.base.Tender.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.webmyne.R;

import java.util.ArrayList;

/**
 * Created by vaibhavirana on 10-03-2016.
 */
public class TenderDetailAdapter extends RecyclerView.Adapter<TenderDetailAdapter.MyViewHolder> {

    ArrayList<String> items;

    public TenderDetailAdapter(ArrayList<String> items) {
        this.items=items;
    }

    @Override
    public TenderDetailAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.tender_detail_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TenderDetailAdapter.MyViewHolder holder, int position) {
        holder.txtViewTitle.setGravity(Gravity.LEFT);
        holder.txtViewTitle.setText(items.get(position).toString());
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
