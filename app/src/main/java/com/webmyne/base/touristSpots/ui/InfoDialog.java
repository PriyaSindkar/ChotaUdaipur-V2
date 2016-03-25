package com.webmyne.base.touristSpots.ui;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialog;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.webmyne.R;
import com.webmyne.base.touristSpots.model.TouristResult;

/**
 * Created by priyasindkar on 21-03-2016.
 */
public class InfoDialog extends Dialog {
    ImageView imgCancel;
    TouristResult touristResult;
    private TextView txtTitle,txtDesc;

    public InfoDialog(Context context, int themeResId,TouristResult touristResult) {
        super(context, themeResId);
        this.touristResult=touristResult;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.tourist_spot_info_dialog);
        txtTitle= (TextView) findViewById(R.id.txtTitle);
        txtDesc= (TextView) findViewById(R.id.txtDescription);

        txtTitle.setText(touristResult.PlaceName);
        txtDesc.setText(touristResult.Description);
        Log.d("desc",touristResult.PlaceName + " || "+touristResult.Description);
        imgCancel = (ImageView) findViewById(R.id.imgCancel);
        imgCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }
}
