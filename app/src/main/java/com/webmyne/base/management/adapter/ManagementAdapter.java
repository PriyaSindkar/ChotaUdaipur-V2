package com.webmyne.base.management.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.webmyne.R;
import com.webmyne.base.management.model.ManagementDataObject;

import java.util.List;

/**
 * Created by vaibhavirana on 10-03-2016.
 */
public class ManagementAdapter extends RecyclerView.Adapter<ManagementAdapter.ManagementItemHolder> {
    private Context mContext;
    private List<ManagementDataObject> mData;

    public ManagementAdapter(Context _ctx, List<ManagementDataObject> data) {
        this.mContext = _ctx;
        mData = data;
    }

    @Override
    public ManagementItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.management_item, parent, false);
        return new ManagementItemHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ManagementItemHolder holder, int position) {
        holder.txtDesignation.setText(mData.get(position).designation);
        holder.txtName.setText(mData.get(position).name);
        holder.txtEmail.setText(mData.get(position).email+ "\n");
        holder.txtOfficeNo.setText("Office: "+ mData.get(position).officeNo);
        holder.txtMobileNo.setText("Mobile: "+ mData.get(position).mobileNo);
    }


    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ManagementItemHolder extends RecyclerView.ViewHolder {
        private TextView txtDesignation, txtName, txtEmail, txtOfficeNo, txtMobileNo;

        public ManagementItemHolder(View itemView) {
            super(itemView);
            txtDesignation = (TextView) itemView.findViewById(R.id.txtDesignation);
            txtName = (TextView) itemView.findViewById(R.id.txtName);
            txtEmail = (TextView) itemView.findViewById(R.id.txtEmail);
            txtOfficeNo = (TextView) itemView.findViewById(R.id.txtOfficeNo);
            txtMobileNo = (TextView) itemView.findViewById(R.id.txtMobileNo);
        }
    }
}
