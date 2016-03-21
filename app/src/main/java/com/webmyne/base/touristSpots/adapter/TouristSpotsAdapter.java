package com.webmyne.base.touristSpots.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.webmyne.R;
import com.webmyne.base.touristSpots.ui.InfoDialog;
import com.webmyne.base.utils.Functions;

/**
 * Created by vaibhavirana on 10-03-2016.
 */
public class TouristSpotsAdapter extends RecyclerView.Adapter<TouristSpotsAdapter.ItemHolder> {
    private Context mContext;

    public TouristSpotsAdapter(Context _ctx) {
        this.mContext = _ctx;
    }

    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater mInflater = LayoutInflater.from(parent.getContext());
        if (viewType == 0) {
            ViewGroup viewgroup1 = (ViewGroup) mInflater.inflate(R.layout.tourist_spots_item_info, parent, false);
            TouristSpotsInfoItemHolder listHolder = new TouristSpotsInfoItemHolder(viewgroup1);
            return listHolder;
        } else {
            ViewGroup viewgroup1 = (ViewGroup) mInflater.inflate(R.layout.tourist_spots_item, parent, false);
            TouristSpotsItemHolder listHolder1 = new TouristSpotsItemHolder(viewgroup1);
            return listHolder1;
        }
    }

    @Override
    public void onBindViewHolder(ItemHolder holder, int position) {
       if(holder.getItemViewType() == 0) {
           TouristSpotsInfoItemHolder infoItemHolder = (TouristSpotsInfoItemHolder) holder;
           infoItemHolder.imgInfo.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   InfoDialog infoDialog = new InfoDialog(mContext, R.style.CustomAlertDialogStyle);
                   infoDialog.getWindow().getAttributes().width = (int) (Functions.getDeviceMetrics( (Activity)mContext).widthPixels * 0.8);
                   infoDialog.show();
               }
           });

       } else {
            TouristSpotsItemHolder itemHolder = (TouristSpotsItemHolder) holder;
       }
    }


    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class TouristSpotsItemHolder extends ItemHolder {
        private ImageView image;

        public TouristSpotsItemHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.image);
        }
    }

    public class TouristSpotsInfoItemHolder extends ItemHolder {
        private ImageView image, imgInfo;

        public TouristSpotsInfoItemHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.image);
            imgInfo = (ImageView) itemView.findViewById(R.id.imgInfo);
        }
    }

    public class ItemHolder extends RecyclerView.ViewHolder {
        private ImageView image;

        public ItemHolder(View itemView) {
            super(itemView);
        }
    }
}
