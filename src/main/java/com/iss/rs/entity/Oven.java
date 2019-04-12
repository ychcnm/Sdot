package com.iss.rs.entity;


public class Oven {

    private String ovenId;
    private long temperature;
    private String processType;


    public String getOvenId() {
        return ovenId;
    }

    public void setOvenId(String ovenId) {
        this.ovenId = ovenId;
    }


    public long getTemperature() {
        return temperature;
    }

    public void setTemperature(long temperature) {
        this.temperature = temperature;
    }


    public String getProcessType() {
        return processType;
    }

    public void setProcessType(String processType) {
        this.processType = processType;
    }

}
