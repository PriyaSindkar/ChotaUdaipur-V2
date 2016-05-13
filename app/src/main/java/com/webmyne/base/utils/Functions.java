package com.webmyne.base.utils;

import android.app.Activity;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.gson.GsonBuilder;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by priyasindkar on 21-03-2016.
 */
public class Functions {

    static SharedPreferences preferences;

    static SharedPreferences.Editor editor;


    public static String fontFamilyPathThin = "font/shruti.ttf";

    public static DisplayMetrics getDeviceMetrics(Activity context) {
        DisplayMetrics metrics = new DisplayMetrics();
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        display.getMetrics(metrics);
        return metrics;
    }

    // set SharePrefernce
    public static void setPrefs(Context context) {
        preferences = context.getSharedPreferences("Prefs", Context.MODE_PRIVATE);
        editor = preferences.edit();
    }

    // set Is_REG
    public static void setIsRegister(boolean value) {
       editor.putBoolean("IS_REG",value);
        editor.apply();
    }

    // get Is_REG
    public static boolean getIsRegister() {
        return preferences.getBoolean("IS_REG",false);
    }


    // check GooglePlayService Availablity
    public static boolean isGooglePlayServiceAvailable(Context mContext) {
        boolean flag = false;
        int status = GooglePlayServicesUtil.isGooglePlayServicesAvailable(mContext.getApplicationContext());
        if (status == ConnectionResult.SUCCESS) {
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }
    public static Typeface getTypeFace(Context ctx) {
        Typeface typeface = Typeface.createFromAsset(ctx.getAssets(), fontFamilyPathThin);
        return typeface;
    }

    public static boolean haveNetworkConnection(Activity context) {
        boolean haveConnectedWifi = false;
        boolean haveConnectedMobile = false;

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo[] netInfo = cm.getAllNetworkInfo();
        for (NetworkInfo ni : netInfo) {
            if (ni.getTypeName().equalsIgnoreCase("WIFI"))
                if (ni.isConnected())
                    haveConnectedWifi = true;
            if (ni.getTypeName().equalsIgnoreCase("MOBILE"))
                if (ni.isConnected())
                    haveConnectedMobile = true;
        }
        return haveConnectedWifi || haveConnectedMobile;
    }

    public static boolean emailValidator(String email) {
        Pattern pattern;
        Matcher matcher;
        final String EMAIL_PATTERN =
                "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static Bitmap getResizedBitmap(Bitmap bm, int newWidth, int newHeight) {
        int width = bm.getWidth();
        int height = bm.getHeight();
        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;
        // CREATE A MATRIX FOR THE MANIPULATION
        Matrix matrix = new Matrix();
        // RESIZE THE BIT MAP
        matrix.postScale(scaleWidth, scaleHeight);

        // "RECREATE" THE NEW BITMAP
        Bitmap resizedBitmap = Bitmap.createBitmap(
                bm, 0, 0, width, height, matrix, false);
        //bm.recycle();
        return resizedBitmap;
    }

    public static String returnBas64Image(Bitmap thumbnail1) {

        Bitmap thumbnail = getResizedBitmap(thumbnail1, 540, 960);

        //complete code to save image on server
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        thumbnail.compress(Bitmap.CompressFormat.JPEG, 10, baos); //bm is the bitmap object
        byte[] b = baos.toByteArray();
        String encodedImage = Base64.encodeToString(b, Base64.DEFAULT);
        return encodedImage;
    }

    public static void downloadFile(Context context, String DownloadUrl, String name) {
        // String DownloadUrl = mData.get();
        if (haveNetworkConnection((Activity) context)) {
            File dir = new File(Environment.getExternalStorageDirectory()
                    + "/ChhotaUdepur");
            if (dir.exists() == false) {
                dir.mkdirs();
            }

            Log.e("### DownloadUrl", DownloadUrl);
            String s = DownloadUrl.replaceAll(" ", "%20");
            Uri link = Uri.parse(s);

            DownloadManager.Request request = new DownloadManager.Request(link);
            request.setDescription("download file ");   //appears the same in Notification bar while downloading
            request.setTitle(name);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
                request.allowScanningByMediaScanner();
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
            }
            request.setDestinationInExternalPublicDir("/ChhotaUdepur", name);

            // get download service and enqueue file
            DownloadManager manager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
            manager.enqueue(request);
        } else {
            Toast.makeText(context, "Check Internet Connection", Toast.LENGTH_LONG).show();
        }
    }

    public static boolean isDownloadManagerAvailable(Context context) {
        try {
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.GINGERBREAD) {
                return false;
            }
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_LAUNCHER);
            intent.setClassName("com.android.providers.downloads.ui", "com.android.providers.downloads.ui.DownloadList");
            List<ResolveInfo> list;
            list = context.getPackageManager().queryIntentActivities(intent,
                    PackageManager.MATCH_DEFAULT_ONLY);
            return list.size() > 0;
        } catch (Exception e) {
            Log.e("### EXc", e.toString());
            return false;
        }
    }

    public static String jsonString(Object obj) {
        return "" + new GsonBuilder().create().toJson(obj).toString();
    }
}
