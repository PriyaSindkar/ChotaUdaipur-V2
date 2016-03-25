package com.webmyne.base.Complain.model;

/**
 * Created by priyasindkar on 25-03-2016.
 */
public class ComplainStatusResult {
    public String  Remark;
    public int Status;

    @Override
    public String toString() {
        return "ComplainStatusResult{" +
                "Remark='" + Remark + '\'' +
                ", Status=" + Status +
                '}';
    }
}
