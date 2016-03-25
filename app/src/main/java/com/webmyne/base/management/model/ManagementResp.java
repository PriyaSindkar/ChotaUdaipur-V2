package com.webmyne.base.management.model;

import java.util.ArrayList;

/**
 * Created by vaibhavirana on 25-03-2016.
 */
public class ManagementResp {
    ArrayList<ManagementResult> ManagementResult;

    public ArrayList<com.webmyne.base.management.model.ManagementResult> getManagementResult() {
        return ManagementResult;
    }

    public void setManagementResult(ArrayList<com.webmyne.base.management.model.ManagementResult> managementResult) {
        ManagementResult = managementResult;
    }
}
