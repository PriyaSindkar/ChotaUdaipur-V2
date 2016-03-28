package com.webmyne.base.management.adapter;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.webmyne.R;
import com.webmyne.base.management.model.ManagementDataObject;
import com.webmyne.base.management.model.ManagementResult;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vaibhavirana on 10-03-2016.
 */
public class ManagementAdapter extends RecyclerView.Adapter<ManagementAdapter.ManagementItemHolder> {
    private Context mContext;
    private List<ManagementResult> mData;


    public ManagementAdapter(Context _ctx, ArrayList<ManagementResult> data) {
        this.mContext = _ctx;
        mData = data;
    }

    @Override
    public ManagementItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.management_item, parent, false);
        return new ManagementItemHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ManagementItemHolder holder, int position) {

        holder.progressBar.setVisibility(View.VISIBLE);

        holder.txtDesignation.setText(mData.get(position).Designation);
        holder.txtName.setText(mData.get(position).Name);
        holder.txtEmail.setText(mData.get(position).Email+ "\n");
        holder.txtOfficeNo.setText("Office: " + mData.get(position).OfficeNo);
        holder.txtMobileNo.setText("Mobile: " + mData.get(position).MobileNo);

        if(mData.get(position).getImage() != null) {

            Glide.with(mContext)
                    .load(mData.get(position).getImage())
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .listener(new RequestListener<String, GlideDrawable>() {
                        @Override
                        public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                            return false;
                        }

                        @Override
                        public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                            holder.img_profile.setPadding(0, 0, 0, 0);
                            holder.progressBar.setVisibility(View.GONE);
                            return false;
                        }
                    })
                    .into(holder.img_profile);
        }
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
        private ImageView img_profile;
        private ProgressBar progressBar;
        public ManagementItemHolder(View itemView) {
            super(itemView);
            img_profile = (ImageView) itemView.findViewById(R.id.imgProfile);
            txtDesignation = (TextView) itemView.findViewById(R.id.txtDesignation);
            txtName = (TextView) itemView.findViewById(R.id.txtName);
            txtEmail = (TextView) itemView.findViewById(R.id.txtEmail);
            txtOfficeNo = (TextView) itemView.findViewById(R.id.txtOfficeNo);
            txtMobileNo = (TextView) itemView.findViewById(R.id.txtMobileNo);
            progressBar=(ProgressBar) itemView.findViewById(R.id.progressBar);
        }
    }
}
