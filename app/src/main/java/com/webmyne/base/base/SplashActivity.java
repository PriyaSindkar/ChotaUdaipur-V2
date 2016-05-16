package com.webmyne.base.base;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.webmyne.R;
import com.webmyne.base.base.api.RegisterApi;
import com.webmyne.base.base.model.RegisterResponse;
import com.webmyne.base.base.model.Regrequest;
import com.webmyne.base.utils.Functions;

import github.nisrulz.easydeviceinfo.EasyDeviceInfo;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by vaibhavirana on 09-03-2016.
 */
public class SplashActivity extends AppCompatActivity {

    private GoogleCloudMessaging gcm;
    private String GCM_ID;
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_main);

        init();

    }

    private void init() {
        dialog = new ProgressDialog(this);
        dialog.setCancelable(false);

       /* ProgressBar v = (ProgressBar) findViewById(R.id.progressBar);
        v.getIndeterminateDrawable().setColorFilter(0xFFFFFFFF,
                android.graphics.PorterDuff.Mode.MULTIPLY);*/

        Functions.setPrefs(this);
        if (Functions.preferences.getBoolean("IS_REG", false)) {
            // not frst time
            Log.d("",Functions.getIsRegister()+"");
            navigateToHome();
        } else {
            // frst time
            Log.d("",Functions.getIsRegister()+"");
            Functions.setIsRegister(false);
            if (Functions.haveNetworkConnection(this)) {
                dialog.setMessage(getString(R.string.dialog_wait));
                dialog.show();
                getGCM_ID();
            } else {
                dialog.setMessage(getString(R.string.dialog_CheckInternet));
                dialog.show();
            }
        }
    }

    private void navigateToHome() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                Intent i1=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i1);
                finish();
            }
        }, 2000);

    }

    private String getGCM_ID() {
        //get GCM
        try {
            if (gcm == null) {

                if (Functions.isGooglePlayServiceAvailable(this)) {
                    new AsyncTask<Void, Void, String>() {
                        @Override
                        protected String doInBackground(Void... params) {
                            try {
                                if (gcm == null) {
                                    gcm = GoogleCloudMessaging.getInstance(SplashActivity.this);
                                }
                                GCM_ID = gcm.register(getString(R.string.project_id));
                               // Log.d("GCM_ID ", " " + GCM_ID);
                                callRegisterAPI();

                            } catch (Exception ex) {
                                GCM_ID = "";
                            }

                            return GCM_ID;
                        }

                        @Override
                        protected void onPostExecute(String regId) {
                            super.onPostExecute(regId);
                            if (!regId.equals("")) {
                                GCM_ID = regId;
                            } else {
                                Toast.makeText(SplashActivity.this, getString(R.string.gcm_error), Toast.LENGTH_SHORT).show();
                            }
                        }
                    }.execute();

                } else {
                    Toast.makeText(this, getString(R.string.gcm_error), Toast.LENGTH_SHORT).show();
                }

            }

        } catch (Exception e) {
            Toast.makeText(this, getString(R.string.gcm_error), Toast.LENGTH_SHORT).show();
        }
        return GCM_ID;
    }

    private void callRegisterAPI() {

        EasyDeviceInfo easyDeviceInfo = new EasyDeviceInfo(this);
        //Log.d("Device info: ", easyDeviceInfo.getAndroidID() + " || " + easyDeviceInfo.getModel());
        String deviceId = easyDeviceInfo.getAndroidID();
        String model = easyDeviceInfo.getModel();
        try {
            final Regrequest registerRequest = new Regrequest(deviceId, model, GCM_ID, "A");
            RegisterApi service = MyApplication.retrofit.create(RegisterApi.class);
            Call<RegisterResponse> call = service.callRegisterDevice(registerRequest);
            call.enqueue(new Callback<RegisterResponse>() {
                @Override
                public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                    //Toast.makeText(SplashActivity.this, response.body().RegisterDeviceResult.ResponseCode, Toast.LENGTH_SHORT).show();
                   // Log.e("resp", response.body().RegisterDeviceResult.ResponseCode + "");
                    if (response.body().RegisterDeviceResult.ResponseCode.equals("1")) {
                        dialog.dismiss();
                        Functions.setIsRegister(true);
                        navigateToHome();
                    }
                    else
                    {
                        finish();
                    }
                }

                @Override
                public void onFailure(Call<RegisterResponse> call, Throwable t) {
                    t.printStackTrace();

                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
