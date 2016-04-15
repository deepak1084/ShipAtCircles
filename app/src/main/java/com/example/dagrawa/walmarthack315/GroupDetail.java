package com.example.dagrawa.walmarthack315;

/**
 * Created by dagrawa on 4/3/16.
 */
public class GroupDetail {
    String addresses;
    String zipCode ;
    String grp;

    public GroupDetail(String addresses, String zipCode, String grp) {
        this.addresses = addresses;
        this.zipCode = zipCode;
        this.grp = grp;
    }

    public String getAddresses() {
        return addresses;
    }

    public void setAddresses(String addresses) {
        this.addresses = addresses;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getGrp() {
        return grp;
    }

    public void setGrp(String grp) {
        this.grp = grp;
    }
}
