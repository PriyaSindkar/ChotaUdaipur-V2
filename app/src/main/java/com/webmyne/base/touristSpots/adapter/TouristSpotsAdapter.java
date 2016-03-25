package com.webmyne.base.touristSpots.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.webmyne.R;
import com.webmyne.base.touristSpots.model.TouristResult;
import com.webmyne.base.touristSpots.ui.InfoDialog;
import com.webmyne.base.utils.Functions;

import java.util.ArrayList;
import java.util.prefs.PreferenceChangeEvent;

/**
 * Created by vaibhavirana on 10-03-2016.
 */
public class TouristSpotsAdapter extends RecyclerView.Adapter<TouristSpotsAdapter.ItemHolder> {
    private Context mContext;
    ArrayList<TouristResult> mData;

    public TouristSpotsAdapter(Context _ctx, ArrayList<TouristResult> dataArray1) {
        this.mContext = _ctx;
        mData = dataArray1;
    }

    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater mInflater = LayoutInflater.from(parent.getContext());

       /* View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.tourist_spots_item_info, parent, false);
        return new ItemHolder(itemView);*/
        ViewGroup viewgroup1 = (ViewGroup) mInflater.inflate(R.layout.tourist_spots_item_info, parent, false);
        TouristSpotsInfoItemHolder listHolder = new TouristSpotsInfoItemHolder(viewgroup1);
        return listHolder;
        /*if (viewType == 0) {
            ViewGroup viewgroup1 = (ViewGroup) mInflater.inflate(R.layout.tourist_spots_item_info, parent, false);
            TouristSpotsInfoItemHolder listHolder = new TouristSpotsInfoItemHolder(viewgroup1);
            return listHolder;
        } else {
            ViewGroup viewgroup1 = (ViewGroup) mInflater.inflate(R.layout.tourist_spots_item, parent, false);
            TouristSpotsItemHolder listHolder1 = new TouristSpotsItemHolder(viewgroup1);
            return listHolder1;
        }*/
    }

    @Override
    public void onBindViewHolder(ItemHolder holder, final int position) {
        //ItemHolder itemHolder = (ItemHolder) holder;
        final TouristSpotsInfoItemHolder infoItemHolder = (TouristSpotsInfoItemHolder) holder;
       // Log.d("image", mData.get(position).Image);
        infoItemHolder.progressBar.setVisibility(View.VISIBLE);
        Glide.with(mContext)
                .load(mData.get(position).Image)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .listener(new RequestListener<String, GlideDrawable>() {
                    @Override
                    public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                        infoItemHolder.progressBar.setVisibility(View.GONE);
                        return false;
                    }
                })
                .into(infoItemHolder.image);

       /* if (holder.getItemViewType() == 0) {

            TouristSpotsInfoItemHolder infoItemHolder = (TouristSpotsInfoItemHolder) holder;
            infoItemHolder.title.setText(mData.get(position).PlaceName);
            infoItemHolder.imgInfo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    InfoDialog infoDialog = new InfoDialog(mContext, R.style.CustomAlertDialogStyle,mData.get(position));
                    infoDialog.getWindow().getAttributes().width = (int) (Functions.getDeviceMetrics((Activity) mContext).widthPixels * 0.8);
                    infoDialog.show();
                }
            });

        } else {*/

        infoItemHolder.title.setText(mData.get(position).PlaceName);
        infoItemHolder.image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    infoItemHolder.imgInfo.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            InfoDialog infoDialog = new InfoDialog(mContext, R.style.CustomAlertDialogStyle,mData.get(position));
                            WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
                            lp.copyFrom(infoDialog.getWindow().getAttributes());
                            //lp.width = WindowManager.LayoutParams.MATCH_PARENT;
                            lp.width =(int) (Functions.getDeviceMetrics((Activity) mContext).widthPixels * 0.8);
                            lp.height = WindowManager.LayoutParams.WRAP_CONTENT;

                           // infoDialog.getWindow().getAttributes().width = (int) (Functions.getDeviceMetrics((Activity) mContext).widthPixels * 0.8);
                           // infoDialog.getWindow().setLayout((int) (Functions.getDeviceMetrics((Activity) mContext).widthPixels * 0.8), Window.FEATURE_PROGRESS );
                            infoDialog.show();
                            infoDialog.getWindow().setAttributes(lp);
                        }
                    });
                }
            });
        //}
    }


    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

  /*  public class TouristSpotsItemHolder extends ItemHolder {
        private ImageView image;

        public TouristSpotsItemHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.image);
        }
    }*/

    public class TouristSpotsInfoItemHolder extends ItemHolder {
        private ImageView image, imgInfo;
        private TextView title;
        private FrameLayout flClick;
        private ProgressBar progressBar;

        public TouristSpotsInfoItemHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.image);
            imgInfo = (ImageView) itemView.findViewById(R.id.imgInfo);
            title=(TextView) itemView.findViewById(R.id.txtTitle);
            flClick=(FrameLayout)itemView.findViewById(R.id.flclick);
            progressBar=(ProgressBar)itemView.findViewById(R.id.progressBar);
        }
    }

    public class ItemHolder extends RecyclerView.ViewHolder {
        private ImageView image;

        public ItemHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.image);
        }
    }
}
