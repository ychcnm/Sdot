package com.iss.rs.entity;


public class Productinfo {

    private String productType;
    private double volume;
    private int temperature;
    private int bakeTime;
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

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getBakeTime() {
        return bakeTime;
    }

    public void setBakeTime(int bakeTime) {
        this.bakeTime = bakeTime;
    }

    public double getAoiTime() {
        return aoiTime;
    }

    public void setAoiTime(double aoiTime) {
        this.aoiTime = aoiTime;
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
}
