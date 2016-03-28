package com.webmyne.base.Complain.model;

/**
 * Created by priyasindkar on 25-03-2016.
 */
public class ComplainRegisterRequest {
    public String Address, DateGenerated, Description, DeviceID, DeviceType, Email, Image, Mobile, PersonName, Zipcode;
    public int CategoryID, CategoryTypeID, StatusID, Ward;

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getDateGenerated() {
        return DateGenerated;
    }

    public void setDateGenerated(String dateGenerated) {
        DateGenerated = dateGenerated;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getDeviceID() {
        return DeviceID;
    }

    public void setDeviceID(String deviceID) {
        DeviceID = deviceID;
    }

    public String getDeviceType() {
        return DeviceType;
    }

    public void setDeviceType(String deviceType) {
        DeviceType = deviceType;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }

    public String getPersonName() {
        return PersonName;
    }

    public void setPersonName(String personName) {
        PersonName = personName;
    }

    public String getZipcode() {
        return Zipcode;
    }

    public void setZipcode(String zipcode) {
        Zipcode = zipcode;
    }

    public int getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(int categoryID) {
        CategoryID = categoryID;
    }

    public int getCategoryTypeID() {
        return CategoryTypeID;
    }

    public void setCategoryTypeID(int categoryTypeID) {
        CategoryTypeID = categoryTypeID;
    }

    public int getStatusID() {
        return StatusID;
    }

    public void setStatusID(int statusID) {
        StatusID = statusID;
    }

    public int getWard() {
        return Ward;
    }

    public void setWard(int ward) {
        Ward = ward;
    }
}
