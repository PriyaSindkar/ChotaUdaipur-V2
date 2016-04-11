package com.webmyne.base.HelpLine.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.webmyne.R;
import com.webmyne.base.HelpLine.model.HelpLineResult;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vaibhavirana on 10-03-2016.
 */
public class HelpLineAdapter extends RecyclerView.Adapter<HelpLineAdapter.MyViewHolder> {

    List<HelpLineResult> items;
    Context mContext;

    public HelpLineAdapter(Context mContext, List<HelpLineResult> items) {
        this.items = items;
        this.mContext = mContext;
    }

    @Override
    public HelpLineAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.helpline_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(HelpLineAdapter.MyViewHolder holder, final int position) {
        holder.txtViewTitle.setText(items.get(position).Name);
        holder.txtViewNum.setText(items.get(position).ContactNo);
        holder.imgCall.setOnClickListener(new View.OnClickListener() {
                                              @Override
                                              public void onClick(final View v) {
                                                  //Toast.makeText(mContext, "click", Toast.LENGTH_SHORT).show();

                                                  final AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                                                  builder.setTitle(R.string.alert_msg);
                                                  builder.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                                                      public void onClick(DialogInterface dialog, int id) {
                                                          // Toast.makeText(mContext, "Call", Toast.LENGTH_SHORT).show();
                                                          String number = "tel:" + items.get(position).ContactNo.trim();
                                                          if (ContextCompat.checkSelfPermission(mContext, android.Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                                                              Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse(number));
                                                              v.getContext().startActivity(callIntent);
                                                          }


                                                      }
                                                  })
                                                          .setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {

                                                              @Override
                                                              public void onClick(DialogInterface dialog, int which) {
                                                              }
                                                          });

                                                  builder.show();
                                              }
                                          }

        );
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView txtViewTitle, txtViewNum;
        public ImageView imgCall;

        public MyViewHolder(View itemView) {
            super(itemView);
            txtViewTitle = (TextView) itemView.findViewById(R.id.item_title);
            txtViewNum = (TextView) itemView.findViewById(R.id.item_title1);
            imgCall = (ImageView) itemView.findViewById(R.id.imgCall);
        }
    }
}
