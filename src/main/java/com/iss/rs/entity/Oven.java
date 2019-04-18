package com.iss.rs.entity;


import com.iss.rs.domain.AbstractPersistable;

public class Oven extends AbstractPersistable {

    private String ovenId;
    private int temperature;
    private String processType;


    public String getOvenId() {
        return ovenId;
    }

    public void setOvenId(String ovenId) {
        this.ovenId = ovenId;
    }


    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }


    public String getProcessType() {
        return processType;
    }

    public void setProcessType(String processType) {
        this.processType = processType;
    }

    public String getLabel() {
        return ovenId;
    }

    @Override
    public String toString() {
        return ovenId;
    }

}
