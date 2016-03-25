package com.webmyne.base.HelpLine.model;

/**
 * Created by vaibhavirana on 25-03-2016.
 */
public class HelpLineResult {
    public int HelpLineID;
    public String Name;
    public String ContactNo;

    public int getHelpLineID() {
        return HelpLineID;
    }

    public void setHelpLineID(int helpLineID) {
        HelpLineID = helpLineID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getContactNo() {
        return ContactNo;
    }

    public void setContactNo(String contactNo) {
        ContactNo = contactNo;
    }
}
