package com.webmyne.base.current_jobs.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.webmyne.R;
import com.webmyne.base.current_jobs.model.FetchJobResult;
import com.webmyne.base.utils.Functions;

import java.util.List;

/**
 * Created by vaibhavirana on 10-03-2016.
 */
public class CurrentJobsAdapter extends RecyclerView.Adapter<CurrentJobsAdapter.CurrentJobsItemHolder> {
    private Context mContext;
    private List<FetchJobResult> mData;

    public CurrentJobsAdapter(Context _ctx, List<FetchJobResult> data) {
        this.mContext = _ctx;
        mData = data;
    }

    @Override
    public CurrentJobsItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.current_jobs_item, parent, false);
        return new CurrentJobsItemHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CurrentJobsItemHolder holder, final int position) {
        holder.txtIndex.setText(String.valueOf(position + 1)+". ");
        holder.txtTitle.setText(mData.get(position).getTitle());
        holder.txtTitle.setTypeface(Functions.getTypeFace(mContext));
        holder.txtDescription.setText(mData.get(position).getDescription());
        holder.txtDescription.setTypeface(Functions.getTypeFace(mContext));
        holder.txtNoOFOpening.setText("No of Post : "+mData.get(position).NoOfPost);
        holder.txtValidTo.setText("Valid To : "+mData.get(position).getValidTo());
        holder.txtValidFrom.setText("Valid From : " +mData.get(position).getValidFrom());
        if(!mData.get(position).Attachment.equals("")) {
            holder.imgDownload.setVisibility(View.VISIBLE);
            Boolean result=Functions.isDownloadManagerAvailable(mContext);
            if (result) {
                holder.imgDownload.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(mContext, "downloading....", Toast.LENGTH_SHORT).show();
                        Functions.downloadFile(mContext, mData.get(position).Attachment, mData.get(position).getPost());
                    }
                });
            }
        }else
        {
            holder.imgDownload.setVisibility(View.INVISIBLE);
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

    public class CurrentJobsItemHolder extends RecyclerView.ViewHolder {
        private TextView txtIndex, txtTitle, txtDescription,txtNoOFOpening,txtValidTo,txtValidFrom;
        private ImageView imgDownload;
        public CurrentJobsItemHolder(View itemView) {
            super(itemView);
            txtTitle = (TextView) itemView.findViewById(R.id.txtTitle);
            txtDescription = (TextView) itemView.findViewById(R.id.txtDescription);
            txtIndex = (TextView) itemView.findViewById(R.id.txtIndex);
            txtNoOFOpening = (TextView) itemView.findViewById(R.id.txtNoOFOpening);
            txtValidTo = (TextView) itemView.findViewById(R.id.txtValidTo);
            txtValidFrom = (TextView) itemView.findViewById(R.id.txtValidFrom);
            imgDownload=(ImageView)itemView.findViewById(R.id.imgdownload);
        }
    }
}
