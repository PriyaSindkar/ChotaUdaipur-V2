package com.webmyne.base.utils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by vaibhavirana on 23-03-2016.
 */
public class Conts {
    //http://ws-srv-net.in.webmyne.com/Applications/CUSevaSadan/CUSevaSadan_WS/Service.svc/
    final public static  String BASE_URL="http://ws-srv-net.in.webmyne.com/Applications/CUSevaSadan/CUSevaSadan_WS/Service.svc/";
    final public static  String ABOUT_US_URL="json/AboutUS";
    final public static  String ACHIVEMENT_URL="json/Achievement";
    final public static  String CURRENTJOB_URL="json/FetchJob";
    final public static  String NEWS_URL="json/FetchNews";
    final public static  String HELPLINE_URL="json/HelpLine";
    final public static  String MANAGEMENT_URL="json/Management";
    final public static  String TOURIST_URL="json/Tourist";
    final public static  String TENDER_URL="json/Tender";
}
