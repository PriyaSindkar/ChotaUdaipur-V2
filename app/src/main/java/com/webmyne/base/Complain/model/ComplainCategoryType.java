package com.webmyne.base.Complain.model;

/**
 * Created by priyasindkar on 25-03-2016.
 */
public class ComplainCategoryType {
    public String  CategoryTypeName;
    public int CategoryTypeID;

    @Override
    public String toString() {
        return "ComplainCategoryType{" +
                "CategoryTypeName='" + CategoryTypeName + '\'' +
                ", CategoryTypeID=" + CategoryTypeID +
                '}';
    }
}
