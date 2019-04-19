package com.iss.rs.entity;


import com.iss.rs.domain.AbstractPersistable;

public class Lot extends AbstractPersistable {

    private String lotId;
    private String productType;
    private Productinfo productinfo;
    private int lotSize;

    public Lot(String lotId, String productType, Productinfo productinfo, int lotSize) {
        this.lotId = lotId;
        this.productType = productType;
        this.productinfo = productinfo;
        this.lotSize = lotSize;
    }

    public Lot(String s, Productinfo pi, String valueOf) {
    }

    public String getLotId() {
        return lotId;
    }

    public void setLotId(String lotId) {
        this.lotId = lotId;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public Productinfo getProductinfo() {
        return productinfo;
    }

    public void setProductinfo(Productinfo productinfo) {
        this.productinfo = productinfo;
    }

    public int getLotSize() {
        return lotSize;
    }

    public void setLotSize(int lotSize) {
        this.lotSize = lotSize;
    }

// ************************************************************************
    // Complex methods
    // ************************************************************************

    public double getRequiredCapacity() {
        return productinfo.getVolume() * lotSize;
    }

    public int getDuration() {
        return productinfo.getBakeTime();
    }

    public String getDurationString() {
        return (productinfo.getBakeTime()) + " hours";
    }

}
