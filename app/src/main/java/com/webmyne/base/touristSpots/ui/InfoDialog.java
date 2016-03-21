package com.webmyne.base.touristSpots.ui;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialog;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import com.webmyne.R;

/**
 * Created by priyasindkar on 21-03-2016.
 */
public class InfoDialog extends Dialog {
    ImageView imgCancel;

    public InfoDialog(Context context) {
        super(context);
    }

    public InfoDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.tourist_spot_info_dialog);

        imgCancel = (ImageView) findViewById(R.id.imgCancel);
        imgCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }
}
