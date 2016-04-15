package com.example.dagrawa.walmarthack315;

/**
 * Created by dagrawa on 4/3/16.
 */
public class OrderDetail {
    String orderNo;

    public String getGrpId() {
        return grpId;
    }

    public void setGrpId(String grpId) {
        this.grpId = grpId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(String shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    public String getShipDiscount() {
        return shipDiscount;
    }

    public void setShipDiscount(String shipDiscount) {
        this.shipDiscount = shipDiscount;
    }

    public String getShipCost() {
        return shipCost;
    }

    public void setShipCost(String shipCost) {
        this.shipCost = shipCost;
    }

    public String getShipTotal() {
        return shipTotal;
    }

    public void setShipTotal(String shipTotal) {
        this.shipTotal = shipTotal;
    }

    String grpId;
    String status;
    String shippingMethod;
    String shipDiscount;
    String shipCost;
    String shipTotal;

    public OrderDetail(String orderNo, String grpId, String status, String shippingMethod, String shipDiscount, String shipCost, String shipTotal) {
        this.orderNo = orderNo;
        this.grpId = grpId;
        this.status = status;
        this.shippingMethod = shippingMethod;
        this.shipDiscount = shipDiscount;
        this.shipCost = shipCost;
        this.shipTotal = shipTotal;
    }
}
