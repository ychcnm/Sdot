package com.iss.rs.entity;


public class Productinfo {

    private String productType;
    private double volume;
    private long temperature;
    private long bakeTime;
    private double aoiTime;


    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }


    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }


    public long getTemperature() {
        return temperature;
    }

    public void setTemperature(long temperature) {
        this.temperature = temperature;
    }


    public long getBakeTime() {
        return bakeTime;
    }

    public void setBakeTime(long bakeTime) {
        this.bakeTime = bakeTime;
    }

    @Override
    public String toString() {
        return "Productinfo{" +
                "productType='" + productType + '\'' +
                ", volume=" + volume +
                ", temperature=" + temperature +
                ", bakeTime=" + bakeTime +
                ", aoiTime=" + aoiTime +
                '}';
    }

    public double getAoiTime() {
        return aoiTime;
    }

    public void setAoiTime(double aoiTime) {
        this.aoiTime = aoiTime;
    }

}
