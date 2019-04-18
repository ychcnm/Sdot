package com.iss.rs.entity;


public class Lot extends AbstractPersistable {

    private String lotId;
    private String productType;
    private Productinfo productinfo;
    private long lotSize;

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

    public long getLotSize() {
        return lotSize;
    }

    public void setLotSize(long lotSize) {
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

    public int getDurationInGrains() {
        return productinfo.getBakeTime() / 12;
    }

}
