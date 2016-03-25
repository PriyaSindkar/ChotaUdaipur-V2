package com.webmyne.base.Achievement.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
import com.webmyne.base.Achievement.model.AchievementResult;

import java.util.List;
import java.util.logging.Handler;

/**
 * Created by vaibhavirana on 10-03-2016.
 */
public class AchievementAdapter extends RecyclerView.Adapter<AchievementAdapter.MyViewHolder> {

    private List<AchievementResult> achivements;
    private Context c;

    public AchievementAdapter(Context c,List<AchievementResult> achivements) {
        this.c=c;
        this.achivements=achivements;
        //Log.d("achivemnets", achivements.toString());
    }

    @Override
    public AchievementAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.achievement_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final AchievementAdapter.MyViewHolder holder, int position) {
        holder.txtTitle.setText(achivements.get(position).Award + " (" + achivements.get(position).Year + ")");
        holder.txtDescription.setText("AwardBy : " + achivements.get(position).AwardBy);
        holder.txtDescription1.setText("AwardFor : " + achivements.get(position).AwardFor);
        holder.progressBar.setVisibility(View.VISIBLE);
        android.os.Handler handler = new android.os.Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                holder.progressBar.setVisibility(View.GONE);
               // holder.img.setBackgroundColor(c.getResources().getColor(R.color.profile_bg));
            }
        }, 5000);

        Glide.with(c)
                .load(achivements.get(position).getImage())
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
       // holder.img;
    }


    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return achivements.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView  txtTitle, txtDescription,txtDescription1;
        private ImageView img;
        private ProgressBar progressBar;

        public MyViewHolder(View itemView) {
            super(itemView);
            txtTitle = (TextView) itemView.findViewById(R.id.txtTitle);
            txtDescription = (TextView) itemView.findViewById(R.id.txtDescription);
            txtDescription1 = (TextView) itemView.findViewById(R.id.txtDescription1);
            img=(ImageView)itemView.findViewById(R.id.imgAchivement);
            progressBar=(ProgressBar)itemView.findViewById(R.id.progressBar);
        }
    }
}
