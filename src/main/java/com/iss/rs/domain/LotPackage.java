package com.iss.rs.domain;

import com.iss.rs.entity.Lot;

import java.util.List;

public class LotPackage extends AbstractPersistable {

    private List<Lot> lotList;
    private Long lotPackageId;

    private int tempaerture;
    private int requireTime;

    private double size;

    public LotPackage(List<Lot> lotList, Long lotPackageId, int tempaerture, int requireTime, double size) {
        this.lotList = lotList;
        this.lotPackageId = lotPackageId;
        this.tempaerture = tempaerture;
        this.requireTime = requireTime;
        this.size = size;
    }

    public List<Lot> getLotList() {
        return lotList;
    }

    public void setLotList(List<Lot> lotList) {
        this.lotList = lotList;
    }

    public Long getLotPackageId() {
        return lotPackageId;
    }

    public void setLotPackageId(Long lotPackageId) {
        this.lotPackageId = lotPackageId;
    }

    public int getTempaerture() {
        return tempaerture;
    }

    public void setTempaerture(int tempaerture) {
        this.tempaerture = tempaerture;
    }

    public int getRequireTime() {
        return requireTime;
    }

    public void setRequireTime(int requireTime) {
        this.requireTime = requireTime;
    }

    public String getLabel() {
        return this.lotPackageId.toString();
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }
}
