package com.example.dagrawa.walmarthack315;

/**
 * Created by dagrawa on 4/3/16.
 */
public class CreditClass {
    String orderName;

    public CreditClass(String orderName, int refund) {
        this.orderName = orderName;
        this.refund = refund;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    int refund;

    public void setRefund(int refund) {
        this.refund = refund;
    }

    public int getRefund() {
        return refund;
    }
}
