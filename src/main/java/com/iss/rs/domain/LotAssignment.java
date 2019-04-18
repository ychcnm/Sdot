package com.iss.rs.domain;

import com.iss.rs.entity.Oven;
import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

@PlanningEntity()
public class LotAssignment extends AbstractPersistable {

    private LotPackage lotPackage;

    private TimeGrain startingTimeGrain;
    private Oven oven;

    public LotPackage getLotPackage() {
        return lotPackage;
    }

    public void setLotPackage(LotPackage lotPackage) {
        this.lotPackage = lotPackage;
    }

    @PlanningVariable(valueRangeProviderRefs = {"timeGrainRange"})
    public TimeGrain getStartingTimeGrain() {
        return startingTimeGrain;
    }

    public void setStartingTimeGrain(TimeGrain startingTimeGrain) {
        this.startingTimeGrain = startingTimeGrain;
    }

    @PlanningVariable(valueRangeProviderRefs = {"ovenRange"})
    public Oven getOven() {
        return oven;
    }

    public void setOven(Oven oven) {
        this.oven = oven;
    }

    // ************************************************************************
    // Complex methods
    // ************************************************************************
    public int calculateOverlap(LotAssignment other) {
        if (startingTimeGrain == null || other.getStartingTimeGrain() == null) {
            return 0;
        }
        int start = startingTimeGrain.getGrainIndex();
        int end = start + lotPackage.getRequireTime();
        int otherStart = other.startingTimeGrain.getGrainIndex();
        int otherEnd = otherStart + other.getLotPackage().getRequireTime();
        if (end < otherStart) {
            return 0;
        } else if (otherEnd < start) {
            return 0;
        }
        return Math.min(end, otherEnd) - Math.max(start, otherStart);
    }

    public String getStartingDateTimeString() {
        if (startingTimeGrain == null) {
            return null;
        }
        return startingTimeGrain.getDateTimeString();
    }

    public Integer getLastTimeGrainIndex() {
        if (startingTimeGrain == null) {
            return null;
        }
        return startingTimeGrain.getGrainIndex() + lotPackage.getRequireTime() / 12 - 1;
    }

    public int getOvenCapacity() {
        if (oven == null) {
            return 0;
        }
        return 100;
    }

    public int getRequiredCapacity() {
        return (int) lotPackage.getSize();
    }

    public int getOvenTemperature() {
        if (oven == null) {
            return 0;
        }
        return oven.getTemperature();
    }

    public int getRequiredTemperature() {
        return lotPackage.getTempaerture();
    }

    @Override
    public String toString() {
        return lotPackage.toString();
    }

}
