package com.webmyne.base.base.model;

/**
 * Created by vaibhavirana on 13-05-2016.
 */
public class Regrequest {
    public String DeviceID,DeviceModel,DeviceToken,DeviceType;

    public Regrequest(String DeviceId, String DeviceModel, String DeviceToken, String DeviceType)
    {
        this.DeviceID=DeviceId;
        this.DeviceModel=DeviceModel;
        this.DeviceToken=DeviceToken;
        this.DeviceType=DeviceType;
    }
}
