package com.webmyne.base.Tender.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.webmyne.R;
import com.webmyne.base.Tender.model.TenderDataObject;
import com.webmyne.base.listeners.OnItemSelected;
import com.webmyne.base.management.model.ManagementDataObject;

import java.util.List;

/**
 * Created by vaibhavirana on 10-03-2016.
 */
public class TenderAdapter extends RecyclerView.Adapter<TenderAdapter.ManagementItemHolder> {
    private Context mContext;
    private List<TenderDataObject> mData;
    private OnItemSelected onItemSelected;
    public TenderAdapter(Context _ctx, List<TenderDataObject> data) {
        this.mContext = _ctx;
        mData = data;
    }

    @Override
    public ManagementItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.tender_item, parent, false);
        return new ManagementItemHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ManagementItemHolder holder, int position) {
        holder.txtSrNo.setText("Sr No: "+mData.get(position).SrNo);
        holder.txtTenderNo.setText("Tender No: "+mData.get(position).tenderNo);
        holder.txtStartDate.setText("Start Date: "+mData.get(position).StrtDate);
        holder.txtEndDate.setText("End Date: "+ mData.get(position).EndDate);
        //holder.txtMobileNo.setText("Mobile: "+ mData.get(position).mobileNo);
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
        private TextView txtSrNo, txtTenderNo, txtStartDate, txtEndDate;

        public ManagementItemHolder(View itemView) {
            super(itemView);
            txtSrNo = (TextView) itemView.findViewById(R.id.txtSrNo);
            txtTenderNo = (TextView) itemView.findViewById(R.id.txtTenderNo);
            txtStartDate = (TextView) itemView.findViewById(R.id.txtStartDate);
            txtEndDate = (TextView) itemView.findViewById(R.id.txtEndDate);

        }
    }
    public void setOnItemSelectedListener(OnItemSelected _obj) {
        this.onItemSelected = _obj;
    }
}
