package com.webmyne.base.Complain;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.webmyne.R;

/**
 * Created by vaibhavirana on 21-03-2016.
 */
public class Complaint_statusActivity extends AppCompatActivity {
    Button edtRegNew;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.complaint_status_main);

        edtRegNew = (Button) findViewById(R.id.edtRegNew);
        edtRegNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Complaint_statusActivity.this, ComplainRegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}
