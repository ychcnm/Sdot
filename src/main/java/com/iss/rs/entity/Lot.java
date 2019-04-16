package com.iss.rs.entity;


public class Lot {

    private String lotId;
    private String productType;
    private Productinfo productinfo;
    private long lotSize;

    /**
     * Multiply by {@link TimeGrain#GRAIN_LENGTH_IN_MINUTES} to get duration in minutes.
     */
    private int durationInGrains;

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

    public int getDurationInGrains() {
        return durationInGrains;
    }

    public void setDurationInGrains(int durationInGrains) {
        this.durationInGrains = durationInGrains;
    }

// ************************************************************************
    // Complex methods
    // ************************************************************************


    public String getDurationString() {
        return (durationInGrains * TimeGrain.GRAIN_LENGTH_IN_MINUTES) / 60 + " hours";
    }

    public String getLabel() {
        return lotId;
    }

    @Override
    public String toString() {
        return lotId;
    }
}
