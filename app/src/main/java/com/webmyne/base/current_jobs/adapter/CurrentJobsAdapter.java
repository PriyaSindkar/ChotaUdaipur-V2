package com.webmyne.base.current_jobs.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.webmyne.R;
import com.webmyne.base.current_jobs.model.CurrentJobsDataObject;

import java.util.List;

/**
 * Created by vaibhavirana on 10-03-2016.
 */
public class CurrentJobsAdapter extends RecyclerView.Adapter<CurrentJobsAdapter.CurrentJobsItemHolder> {
    private Context mContext;
    private List<CurrentJobsDataObject> mData;

    public CurrentJobsAdapter(Context _ctx, List<CurrentJobsDataObject> data) {
        this.mContext = _ctx;
        mData = data;
    }

    @Override
    public CurrentJobsItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.current_jobs_item, parent, false);
        return new CurrentJobsItemHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CurrentJobsItemHolder holder, int position) {
        holder.txtIndex.setText(String.valueOf(position + 1)+". ");
    }


    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class CurrentJobsItemHolder extends RecyclerView.ViewHolder {
        private TextView txtIndex, txtTitle, txtDescription;

        public CurrentJobsItemHolder(View itemView) {
            super(itemView);
            txtTitle = (TextView) itemView.findViewById(R.id.txtTitle);
            txtDescription = (TextView) itemView.findViewById(R.id.txtDescription);
            txtIndex = (TextView) itemView.findViewById(R.id.txtIndex);
        }
    }
}
