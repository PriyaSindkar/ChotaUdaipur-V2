package com.webmyne.base.Complain;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.webmyne.R;
import com.webmyne.base.Complain.adpter.ComplainSpinnerAdapter;
import com.webmyne.base.Complain.adpter.ComplainSpinnerModel;
import com.webmyne.base.Complain.adpter.mySpinnerAdapter;
import com.webmyne.base.Complain.api.FetchComplaintInfoService;
import com.webmyne.base.Complain.api.PostComplaintService;
import com.webmyne.base.Complain.model.ComplainCategoryModel;
import com.webmyne.base.Complain.model.ComplainCategoryType;
import com.webmyne.base.Complain.model.ComplainRegisterRequest;
import com.webmyne.base.Complain.model.ComplainRegisterResult;
import com.webmyne.base.Complain.model.ComplainWardType;
import com.webmyne.base.Complain.model.FetchComplainInfoResult;
import com.webmyne.base.Complain.model.MainComplainRegisterResult;
import com.webmyne.base.Complain.model.MainFetchComplainInfo;
import com.webmyne.base.base.MyApplication;
import com.webmyne.base.news.NewsActivity;
import com.webmyne.base.utils.Functions;

import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by vaibhavirana on 21-03-2016.
 */
public class ComplainRegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private Spinner spComplaintCategory, spComplaintCode, spWard;
    private EditText edtDesc, edtName, edtAddr, edtPincode, edtMobile, edtEmail;
    private TextView txtBack, txtImageUploaded, txtUpload;
    private LinearLayout linearUploadImage, linearSubmit;
    private ProgressDialog dialog;
    private List<ComplainCategoryModel> categoryModels = new ArrayList<>();
    private ArrayList<ComplainSpinnerModel> Category = new ArrayList<>();
    private ArrayList<ComplainSpinnerModel> categoryCode = new ArrayList<>();
    private ArrayList<ComplainSpinnerModel> ward = new ArrayList<>();

    //select image constants
    int REQUEST_CAMERA = 0, SELECT_FILE = 1, CANCEL_REQUEST = 2;
    private boolean isProfilePicUpdated = false, isProfilePicRemoved = false;
    private String profileImageBase64 = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.complain_main);
        init_toolbar();
        init();
    }

    @Override
    protected void onResume() {
        super.onResume();


    }

    private void init() {
        txtBack = (TextView) findViewById(R.id.txtBack);
        txtBack.setOnClickListener(this);

        spComplaintCategory = (Spinner) findViewById(R.id.spComplaintCategory);
        spComplaintCode = (Spinner) findViewById(R.id.spComplaintCode);
        spWard = (Spinner) findViewById(R.id.spWard);
        edtDesc = (EditText) findViewById(R.id.edtDesc);
        edtName = (EditText) findViewById(R.id.edtName);
        edtAddr = (EditText) findViewById(R.id.edtAddr);
        edtPincode = (EditText) findViewById(R.id.edtPincode);
        edtMobile = (EditText) findViewById(R.id.edtMobile);
        edtEmail = (EditText) findViewById(R.id.edtEmail);

        txtUpload = (TextView) findViewById(R.id.txtUpload);
        txtImageUploaded = (TextView) findViewById(R.id.txtImageUploaded);
        linearUploadImage = (LinearLayout) findViewById(R.id.linearUploadImage);
        linearUploadImage.setOnClickListener(this);
        linearSubmit = (LinearLayout) findViewById(R.id.linearSubmit);
        linearSubmit.setOnClickListener(this);


        fetchComplainInfo();

        spComplaintCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                categoryCode = new ArrayList<ComplainSpinnerModel>();
                categoryCode.add(new ComplainSpinnerModel(-1, getString(R.string.complain_type_spinner)));

                if(position != 0) {
                    if (categoryModels.get(position - 1).lstComplaintCategoryType != null) {
                        for (ComplainCategoryType complainCategoryType : categoryModels.get(position - 1).lstComplaintCategoryType) {
                            categoryCode.add(new ComplainSpinnerModel(complainCategoryType.CategoryTypeID, complainCategoryType.CategoryTypeName));
                        }
                    } else {
                        categoryCode = new ArrayList<ComplainSpinnerModel>();

                    }
                    ComplainSpinnerAdapter boardAdapter1 = new ComplainSpinnerAdapter(ComplainRegisterActivity.this, categoryCode, R.layout.spinner_main_view, R.layout.spinner_drop_view);
                    spComplaintCode.setAdapter(boardAdapter1);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


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

    /*public void doFileUploadAnother(File f) throws Exception {

        HttpClient httpclient = new DefaultHttpClient();
        httpclient.getParams().setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);
        HttpPost httppost = new HttpPost("gfgfggfg");
        String boundary = "--";
        httppost.setHeader("Content-type", "multipart/form-data; boundary=" + boundary);

        Bitmap b = BitmapFactory.decodeFile(f.getAbsolutePath());
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        b.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] imageBytes = baos.toByteArray();
        ByteArrayBody bab = new ByteArrayBody(imageBytes, new File(f.getAbsolutePath()).getName() + ".jpg");

        HttpEntity entity = MultipartEntityBuilder.create()
                .setMode(HttpMultipartMode.BROWSER_COMPATIBLE)
                .setBoundary(boundary)
                .addPart("UserID", new StringBody("2"))
                .addPart("ProfilePic", bab)

                .build();

        httppost.setEntity(entity);
        try {
            HttpResponse response = httpclient.execute(httppost);

            entity = response.getEntity();
            final String response_str = EntityUtils.toString(entity);
            if (entity != null) {
                Log.e("RESPONSE", response_str);
                runOnUiThread(new Runnable() {
                    public void run() {
                        try {
                            //res.setTextColor(Color.GREEN);
                            // res.setText("n Response from server : n " + response_str);
                            Toast.makeText(getApplicationContext(), "Upload Complete. Check the server uploads directory.", Toast.LENGTH_LONG).show();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        } catch (Exception e) {

        }


    }*/

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.txtBack:
                onBackPressed();
                break;
            case R.id.linearUploadImage:
                selectImage();
                break;

            case R.id.linearSubmit:
                validateData();
                break;
        }
    }

    private void validateData() {

        if (((ComplainSpinnerModel) spComplaintCategory.getSelectedItem()).id == -1) {
            Toast.makeText(getApplicationContext(), "Please Select Complain Category", Toast.LENGTH_LONG).show();
        } else if (categoryCode.size() > 0 && ((ComplainSpinnerModel) spComplaintCode.getSelectedItem()).id == -1) {
            Toast.makeText(getApplicationContext(), "Please Select Complain Category Type", Toast.LENGTH_LONG).show();
        } else if (((ComplainSpinnerModel) spWard.getSelectedItem()).id == -1) {
            Toast.makeText(getApplicationContext(), "Please Select Ward No.", Toast.LENGTH_LONG).show();
        } else if (edtDesc.getText().toString().trim().length() == 0) {
            Toast.makeText(getApplicationContext(), "Please Enter Complain Description", Toast.LENGTH_LONG).show();
        } else if (edtName.getText().toString().trim().length() == 0) {
            Toast.makeText(getApplicationContext(), "Please Enter Name", Toast.LENGTH_LONG).show();
        } else if (edtAddr.getText().toString().trim().length() == 0) {
            Toast.makeText(getApplicationContext(), "Please Enter Address", Toast.LENGTH_LONG).show();
        } else if (edtPincode.getText().toString().trim().length() == 0) {
            Toast.makeText(getApplicationContext(), "Please Enter Pincode", Toast.LENGTH_LONG).show();
        } else if (edtMobile.getText().toString().trim().length() == 0) {
            Toast.makeText(getApplicationContext(), "Please Enter Phone No.", Toast.LENGTH_LONG).show();
        } else if (edtEmail.getText().toString().trim().length() == 0) {
            Toast.makeText(getApplicationContext(), "Please Enter Email", Toast.LENGTH_LONG).show();
        } else if (!Functions.emailValidator(edtEmail.getText().toString().trim())) {
            Toast.makeText(getApplicationContext(), "Please Enter Valid Email", Toast.LENGTH_LONG).show();
        } else {
            //post complain
            callPostComplain();

        }

    }

    private void fetchComplainInfo() {
        if (Functions.haveNetworkConnection(ComplainRegisterActivity.this)) {
            FetchComplaintInfoService service = MyApplication.retrofit.create(FetchComplaintInfoService.class);
            Call<MainFetchComplainInfo> call = service.getResp();

            call.enqueue(new Callback<MainFetchComplainInfo>() {
                @Override
                public void onResponse(Call<MainFetchComplainInfo> call, Response<MainFetchComplainInfo> response) {

                    if (response.body().FetchComplainInfoResult != null) {
                        setData(response.body().FetchComplainInfoResult);
                    }
                }

                @Override
                public void onFailure(Call<MainFetchComplainInfo> call, Throwable t) {
                    Log.e("onFailure", t.toString());
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

    private void setData(FetchComplainInfoResult infoResult) {
        categoryModels = new ArrayList<>();
        Category = new ArrayList<>();
        ward = new ArrayList<>();
        categoryModels = infoResult.lstComplaintCategory;

        Category.add(new ComplainSpinnerModel(-1, getString(R.string.complain_category_spinner)));
        ward.add(new ComplainSpinnerModel(-1, getString(R.string.complain_ward_spinner)));

        for (ComplainCategoryModel complainCategoryModel : infoResult.lstComplaintCategory) {
            Category.add(new ComplainSpinnerModel(complainCategoryModel.ComplaintCategoryID, complainCategoryModel.CategoryName));
        }

        for (ComplainWardType complainWardType : infoResult.lstWard) {
            ward.add(new ComplainSpinnerModel(complainWardType.WardID, complainWardType.WardName));
        }

        ComplainSpinnerAdapter boardAdapter = new ComplainSpinnerAdapter(ComplainRegisterActivity.this, Category, R.layout.spinner_main_view, R.layout.spinner_drop_view);
        spComplaintCategory.setAdapter(boardAdapter);

        ComplainSpinnerAdapter boardAdapter2 = new ComplainSpinnerAdapter(ComplainRegisterActivity.this, ward, R.layout.spinner_main_view, R.layout.spinner_drop_view);
        spWard.setAdapter(boardAdapter2);
    }

    // select image from cam/gallery
    private void selectImage() {
        final CharSequence[] items = {"Take Photo", "Choose from Gallery", "Remove"};

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Add Photo!");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                if (items[item].equals("Take Photo")) {
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(intent, REQUEST_CAMERA);
                } else if (items[item].equals("Choose from Gallery")) {
                    Intent intent = new Intent();
                    intent.setType("image/*");
                    intent.setAction(Intent.ACTION_GET_CONTENT);
                    startActivityForResult(Intent.createChooser(intent, "Select Picture"), SELECT_FILE);
                } else if (items[item].equals("Remove")) {
                    isProfilePicUpdated = false;
                    isProfilePicRemoved = true;
                    profileImageBase64 = "";
                    txtUpload.setText(getString(R.string.upload));
                    txtImageUploaded.setVisibility(View.GONE);
                }
            }
        });
        builder.show();
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == SELECT_FILE)
                onSelectFromGalleryResult(data);
            else if (requestCode == REQUEST_CAMERA)
                onCaptureImageResult(data);
        }
    }

    private void onCaptureImageResult(Intent data) {
        Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        thumbnail.compress(Bitmap.CompressFormat.JPEG, 90, bytes);
        profileImageBase64 = Functions.returnBas64Image(thumbnail);
        isProfilePicUpdated = true;
        txtImageUploaded.setVisibility(View.VISIBLE);
        txtUpload.setText(getString(R.string.remove_image));
    }

    @SuppressWarnings("deprecation")
    private void onSelectFromGalleryResult(Intent data) {
        Uri uri = data.getData();
        try {
            Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
            profileImageBase64 = Functions.returnBas64Image(bitmap);
            isProfilePicUpdated = true;
            txtImageUploaded.setVisibility(View.VISIBLE);
            txtUpload.setText(getString(R.string.remove_image));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void callPostComplain() {
        ComplainRegisterRequest registerRequest = new ComplainRegisterRequest();
        registerRequest.setAddress(edtAddr.getText().toString().trim());
        registerRequest.setPersonName(edtName.getText().toString().trim());
        registerRequest.setDescription(edtDesc.getText().toString().trim());
        registerRequest.setZipcode(edtPincode.getText().toString().trim());
        registerRequest.setMobile(edtMobile.getText().toString().trim());
        registerRequest.setEmail(edtEmail.getText().toString().trim());
        registerRequest.setCategoryID(((ComplainSpinnerModel) spComplaintCategory.getSelectedItem()).id);
        registerRequest.setCategoryTypeID(((ComplainSpinnerModel) spComplaintCode.getSelectedItem()).id);
        registerRequest.setWard(((ComplainSpinnerModel) spWard.getSelectedItem()).id);
        String deviceId = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);
        registerRequest.setDeviceID(deviceId);
        registerRequest.setDeviceType("A");

        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = df.format(c.getTime());

        registerRequest.setDateGenerated(formattedDate);
        //registerRequest.setStatusID(0);
        registerRequest.setImage(profileImageBase64);

        Log.e("COMPLAIN_REGISTER", Functions.jsonString(registerRequest));

        PostComplaintService service = MyApplication.retrofit.create(PostComplaintService.class);
        Call<MainComplainRegisterResult> call = service.doPostComplain(registerRequest);
        call.enqueue(new Callback<MainComplainRegisterResult>() {
            @Override
            public void onResponse(Call<MainComplainRegisterResult> call, Response<MainComplainRegisterResult> response) {
                if (response.body() != null) {
                    Log.e("onResponse", response.body().toString());
                    if (response.body().ComplainRegisterResult != null) {
                        if (response.body().ComplainRegisterResult.ComplaintCode.equalsIgnoreCase("Fail")) {
                            Toast.makeText(ComplainRegisterActivity.this, "Failed to Register Complain", Toast.LENGTH_SHORT).show();
                        } else {
                            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(ComplainRegisterActivity.this);
                            alertDialogBuilder.setTitle("Complain Registered Successfully");
                            alertDialogBuilder
                                    .setMessage("Please Note Down Your Complain Code To Check Status: " + response.body().ComplainRegisterResult.ComplaintCode)
                                    .setCancelable(false)
                                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            dialog.dismiss();
                                            finish();
                                        }
                                    });
                            AlertDialog alertDialog = alertDialogBuilder.create();
                            alertDialog.show();
                            alertDialog.setCancelable(false);
                        }
                    } else {

                        Toast.makeText(ComplainRegisterActivity.this, "Failed to Register Complain", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(ComplainRegisterActivity.this, "Failed to Register Complain", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<MainComplainRegisterResult> call, Throwable t) {
                Toast.makeText(ComplainRegisterActivity.this, "Failed to Register Complain", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
