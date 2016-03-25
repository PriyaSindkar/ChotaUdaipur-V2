package com.webmyne.base.Complain.model;

import java.util.List;

/**
 * Created by priyasindkar on 25-03-2016.
 */
public class FetchComplainInfoResult {
    public List<ComplainCategoryModel> lstComplaintCategory;
    public List<ComplainWardType> lstWard;

    @Override
    public String toString() {
        return "FetchComplainInfoResult{" +
                "lstComplaintCategory=" + lstComplaintCategory +
                ", lstWard=" + lstWard +
                '}';
    }
}
