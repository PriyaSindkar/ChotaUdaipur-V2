package com.webmyne.base.news.adapter;

import android.app.Activity;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.ms.square.android.expandabletextview.ExpandableTextView;
import com.webmyne.R;
import com.webmyne.base.news.InfoDialog2;
import com.webmyne.base.news.NewsActivity;
import com.webmyne.base.news.NewsDetailActivity;
import com.webmyne.base.news.model.FetchNewsResult;
import com.webmyne.base.touristSpots.ui.InfoDialog;
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
        this.c = newsActivity;
        this.mData = data1;
    }

    @Override
    public NewsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final NewsAdapter.MyViewHolder holder, final int position) {
        //holder.txtIndex.setText(String.valueOf(position + 1)+". ");

        holder.txtTitle.setText(mData.get(position).getTitle());
        holder.txtTitle.setTypeface(Functions.getTypeFace(c));


        holder.txtNewsDate.setText(mData.get(position).getDateGenerated());
        holder.txtNewsDate.setTypeface(Functions.getTypeFace(c));

        holder.txtDescription.setText(mData.get(position).getDescription());
        holder.txtDescription.setTypeface(Functions.getTypeFace(c));

        holder.progressBar.setVisibility(View.VISIBLE);
        Glide.with(c)
                .load(mData.get(position).Attachment)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .listener(new RequestListener<String, GlideDrawable>() {
                    @Override
                    public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                        holder.progressBar.setVisibility(View.GONE);
                        return false;
                    }
                })
                .into(holder.img);


        holder.txtReadMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent ii = new Intent(c,NewsDetailActivity.class);
                ii.putExtra("ImageURL",""+mData.get(position).getAttachment());
                ii.putExtra("Description",""+mData.get(position).Description);
                ii.putExtra("Title",""+mData.get(position).getTitle());
                ii.putExtra("Date",""+mData.get(position).getDateGenerated());
                c.startActivity(ii);

              /*  InfoDialog2 infoDialog = new InfoDialog2(c, R.style.CustomAlertDialogStyle2,mData.get(position));
                WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
                lp.copyFrom(infoDialog.getWindow().getAttributes());
                //lp.width = WindowManager.LayoutParams.MATCH_PARENT;
                lp.width =(int) (Functions.getDeviceMetrics((Activity) c).widthPixels * 0.8);
                lp.height = WindowManager.LayoutParams.WRAP_CONTENT;

                // infoDialog.getWindow().getAttributes().width = (int) (Functions.getDeviceMetrics((Activity) mContext).widthPixels * 0.8);
                // infoDialog.getWindow().setLayout((int) (Functions.getDeviceMetrics((Activity) mContext).widthPixels * 0.8), Window.FEATURE_PROGRESS );
                infoDialog.show();
                infoDialog.getWindow().setAttributes(lp);*/
            }
        });
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
        private TextView txtTitle,txtNewsDate, txtReadMore, txtDescription;
        private ImageView img;
        private ProgressBar progressBar;

        public MyViewHolder(View itemView) {
            super(itemView);
            txtNewsDate = (TextView) itemView.findViewById(R.id.txtNewsDate);
            txtTitle = (TextView) itemView.findViewById(R.id.txtTitle);
            txtDescription = (TextView) itemView.findViewById(R.id.txtDescription);
            img = (ImageView) itemView.findViewById(R.id.img);
            progressBar = (ProgressBar) itemView.findViewById(R.id.progressBar);
            txtReadMore = (TextView) itemView.findViewById(R.id.txtReadMore);

        }
    }
}
