package com.webmyne.base.Complain;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.webmyne.R;
import com.webmyne.base.Complain.api.FetchComplaintStatusService;
import com.webmyne.base.Complain.model.ComplainStatusResult;
import com.webmyne.base.base.MyApplication;
import com.webmyne.base.news.NewsActivity;
import com.webmyne.base.utils.Functions;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by vaibhavirana on 21-03-2016.
 */
public class Complaint_statusActivity extends AppCompatActivity implements View.OnClickListener {
    private Button edtRegNew, btnCheckStatus, btnClear;
    private TextView txtBack;
    private EditText edtComplaintNo, edtComplainstatus;
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.complaint_status_main);
        init_toolbar();
        init();

    }

    private void init() {
        txtBack = (TextView) findViewById(R.id.txtBack);
        txtBack.setOnClickListener(this);

        btnCheckStatus = (Button) findViewById(R.id.btnCheckStatus);
        btnClear = (Button) findViewById(R.id.btnClear);

        edtRegNew = (Button) findViewById(R.id.edtRegNew);
        edtRegNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Complaint_statusActivity.this, ComplainRegisterActivity.class);
                startActivity(intent);
            }
        });

        edtComplaintNo = (EditText) findViewById(R.id.edtComplaintNo);
        edtComplainstatus = (EditText) findViewById(R.id.edtComplainstatus);
        btnClear.setOnClickListener(this);
        btnCheckStatus.setOnClickListener(this);
    }

    private void init_toolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        ImageView imgNew = (ImageView) toolbar.findViewById(R.id.imgNews);
        imgNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), NewsActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.txtBack:
                onBackPressed();
                break;
            case R.id.btnCheckStatus:
                fetchComplaintStatus();
                break;
            case R.id.btnClear:
                edtComplaintNo.setText("");
                edtComplainstatus.setText("");
                edtComplainstatus.setVisibility(View.GONE);
                break;
        }
    }

    private void fetchComplaintStatus() {
        if (Functions.haveNetworkConnection(Complaint_statusActivity.this)) {
            FetchComplaintStatusService service = MyApplication.retrofit.create(FetchComplaintStatusService.class);
            Call<ComplainStatusResult> call = service.getResp(edtComplaintNo.getText().toString().trim());

            call.enqueue(new Callback<ComplainStatusResult>() {
                @Override
                public void onResponse(Call<ComplainStatusResult> call, Response<ComplainStatusResult> response) {
                    if(response.body() != null) {
                        if(response.body().Status == 0) {
                            Toast.makeText(Complaint_statusActivity.this, "No Complaint Found For This Id.", Toast.LENGTH_SHORT).show();
                        } else {
                            edtComplainstatus.setVisibility(View.VISIBLE);
                            edtComplainstatus.setText(response.body().Remark);
                        }
                    } else {
                        Toast.makeText(Complaint_statusActivity.this, "No Complaint of this Id Found.", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<ComplainStatusResult> call, Throwable t) {
                    Toast.makeText(Complaint_statusActivity.this, "No Complaint of this Id Found.", Toast.LENGTH_SHORT).show();
                }
            });


        } else {
            dialog = new ProgressDialog(this);
            dialog.setMessage(getString(R.string.check_conn));
            dialog.show();
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {
                    dialog.dismiss();
                    finish();
                }
            }, 2500);
        }
    }

}
