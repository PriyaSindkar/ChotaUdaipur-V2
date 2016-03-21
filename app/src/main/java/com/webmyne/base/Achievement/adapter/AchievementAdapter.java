package com.webmyne.base.Achievement.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.webmyne.R;

/**
 * Created by vaibhavirana on 10-03-2016.
 */
public class AchievementAdapter extends RecyclerView.Adapter<AchievementAdapter.MyViewHolder> {

    public AchievementAdapter() {
    }

    @Override
    public AchievementAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.achievement_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(AchievementAdapter.MyViewHolder holder, int position) {
    }


    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return 6;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public MyViewHolder(View itemView) {
            super(itemView);

        }
    }
}
