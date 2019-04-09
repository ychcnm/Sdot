package com.iss.rs.entity;


public class Machine {

  private String machineId;
  private String yarnType;
  private String capacity;
  private String cost;


  public String getMachineId() {
    return machineId;
  }

  public void setMachineId(String machineId) {
    this.machineId = machineId;
  }


  public String getYarnType() {
    return yarnType;
  }

  public void setYarnType(String yarnType) {
    this.yarnType = yarnType;
  }


  public String getCapacity() {
    return capacity;
  }

  public void setCapacity(String capacity) {
    this.capacity = capacity;
  }


  public String getCost() {
    return cost;
  }

  public void setCost(String cost) {
    this.cost = cost;
  }

}
