package com.iss.rs.entity;

import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

import java.util.List;

@PlanningEntity()
public class LotAssignment extends AbstractPersistable {
    private List<Lot> lot;
    private Oven oven;
    private TimeGrain startingTimeGrain;

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

    public List<Lot> getLot() {
        return lot;
    }

    public void setLot(List<Lot> lot) {
        this.lot = lot;
    }

// ************************************************************************
    // Complex methods
    // ************************************************************************


    public String getStartingDateTimeString() {
        if (startingTimeGrain == null) {
            return null;
        }
        return startingTimeGrain.getDateTimeString();
    }

    public int getOvenCapacity() {
        if (oven == null) {
            return 0;
        }
        return 100;
    }

    public double getAllCapacity() {
        double sum = 0;
        for (Lot l : lot) {
            sum += l.getLotSize() * l.getProductinfo().getVolume();
        }
        return sum;
    }

    public boolean ifTimeEqual() {
        boolean flag = true;
        int bakeTime = lot.get(0).getProductinfo().getBakeTime();
        for (Lot l : lot) {
            if (l.getProductinfo().getBakeTime() != bakeTime)
                flag = false;
            break;
        }
        return flag;
    }

    public boolean ifTempEqual() {
        boolean flag = true;
        int temp = oven.getTemperature();
        for (Lot l : lot) {
            if (l.getProductinfo().getTemperature() != temp)
                flag = false;
            break;
        }
        return flag;
    }

    @Override
    public String toString() {
        return lot.toString();
    }

}
