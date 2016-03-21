package com.webmyne.base.management.model;

/**
 * Created by priyasindkar on 21-03-2016.
 */
public class ManagementDataObject {
    public String designation, name, email, officeNo, mobileNo;

    public ManagementDataObject() {
    }

    public ManagementDataObject(String designation, String name, String email, String officeNo, String mobileNo) {
        this.designation = designation;
        this.name = name;
        this.email = email;
        this.officeNo = officeNo;
        this.mobileNo = mobileNo;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOfficeNo() {
        return officeNo;
    }

    public void setOfficeNo(String officeNo) {
        this.officeNo = officeNo;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }
}
