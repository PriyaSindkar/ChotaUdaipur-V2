package com.webmyne.base.news;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.webmyne.R;
import com.webmyne.base.news.model.FetchNewsResult;
import com.webmyne.base.touristSpots.model.TouristResult;
import com.webmyne.base.utils.Functions;

/**
 * Created by priyasindkar on 21-03-2016.
 */
public class InfoDialog2 extends Dialog {
    ImageView imgCancel;
    FetchNewsResult newsResult;
    private TextView txtTitle,txtDesc;
    private Context _ctx;

    public InfoDialog2(Context context, int themeResId, FetchNewsResult touristResult) {
        super(context, themeResId);
        this.newsResult=touristResult;
        _ctx = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.tourist_spot_info_dialog);
        txtTitle= (TextView) findViewById(R.id.txtTitle);
        txtDesc= (TextView) findViewById(R.id.txtDescription);

        txtTitle.setText(newsResult.getTitle());
        txtDesc.setText(newsResult.getDescription());

        txtTitle.setTypeface(Functions.getTypeFace(_ctx));
        txtDesc.setTypeface(Functions.getTypeFace(_ctx));
        //Log.d("desc",touristResult.PlaceName + " || "+touristResult.Description);
        imgCancel = (ImageView) findViewById(R.id.imgCancel);
        imgCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }
}
