package com.webmyne.base.news.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.webmyne.R;
import com.webmyne.base.news.NewsActivity;
import com.webmyne.base.news.model.FetchNewsResult;
import com.webmyne.base.utils.Functions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vaibhavirana on 10-03-2016.
 */
public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyViewHolder> {

    private Context c;
    private List<FetchNewsResult> mData;
    public NewsAdapter(NewsActivity newsActivity, List<FetchNewsResult> data1) {
        this.c=newsActivity;
        this.mData=data1;
    }

    @Override
    public NewsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(NewsAdapter.MyViewHolder holder, int position) {
        //holder.txtIndex.setText(String.valueOf(position + 1)+". ");
        holder.txtTitle.setText(mData.get(position).getTitle());
        holder.txtTitle.setTypeface(Functions.getTypeFace(c));
        holder.txtDescription.setText(mData.get(position).getDescription());
        holder.txtDescription.setTypeface(Functions.getTypeFace(c));
    }


    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView  txtTitle, txtDescription;
        public MyViewHolder(View itemView) {
            super(itemView);
            txtTitle = (TextView) itemView.findViewById(R.id.txtTitle);
            txtDescription = (TextView) itemView.findViewById(R.id.txtDescription);
           // txtIndex = (TextView) itemView.findViewById(R.id.txtIndex);
        }
    }
}
