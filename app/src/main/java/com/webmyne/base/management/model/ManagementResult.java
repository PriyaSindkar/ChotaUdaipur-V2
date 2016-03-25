package com.webmyne.base.management.model;

/**
 * Created by vaibhavirana on 25-03-2016.
 */
public class ManagementResult {
    public int DepartmentID;
    public int ManagementID;
    public String Designation;
    public String Email;
    public String Image;
    public String MobileNo;
    public String Name;

    public String getOfficeNo() {
        return OfficeNo;
    }

    public void setOfficeNo(String officeNo) {
        OfficeNo = officeNo;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getMobileNo() {
        return MobileNo;
    }

    public void setMobileNo(String mobileNo) {
        MobileNo = mobileNo;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getDesignation() {
        return Designation;
    }

    public void setDesignation(String designation) {
        Designation = designation;
    }

    public int getManagementID() {
        return ManagementID;
    }

    public void setManagementID(int managementID) {
        ManagementID = managementID;
    }

    public int getDepartmentID() {
        return DepartmentID;
    }

    public void setDepartmentID(int departmentID) {
        DepartmentID = departmentID;
    }

    public String OfficeNo;

}
