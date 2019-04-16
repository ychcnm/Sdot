package com.iss.rs.entity;

import org.optaplanner.core.api.domain.constraintweight.ConstraintConfiguration;
import org.optaplanner.core.api.domain.constraintweight.ConstraintWeight;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;

@ConstraintConfiguration(constraintPackage = "solver")
public class LotConstrainConfiguration extends AbstractPersistable {

    public static final String TEMPERATURE_CONFLICT = "Temperature conflict";
    public static final String LOT_TIME_DURATION_CONFILCT = "Lot Time Duration Conflict";
    public static final String OVEN_CAPACITY_CONFLICT = "Oven Capacity Conflict";
    //public static final String DO_ALL_LOT_AS_SOON_AS_POSSIBLE = "Do all lot as soon as possible";

    @ConstraintWeight(TEMPERATURE_CONFLICT)
    private HardSoftScore temperatureConflict = HardSoftScore.ofHard(1);

    @ConstraintWeight(LOT_TIME_DURATION_CONFILCT)
    private HardSoftScore lotTimeDurationConflict = HardSoftScore.ofHard(1);

    @ConstraintWeight(OVEN_CAPACITY_CONFLICT)
    private HardSoftScore ovenCapacityConflict = HardSoftScore.ofHard(1);

    //@ConstraintWeight(DO_ALL_LOT_AS_SOON_AS_POSSIBLE)
    // private HardSoftScore doLotASAPPossible = HardSoftScore.ofSoft(100);

    public static String getTemperatureConflict() {
        return TEMPERATURE_CONFLICT;
    }

    public void setTemperatureConflict(HardSoftScore temperatureConflict) {
        this.temperatureConflict = temperatureConflict;
    }

    public static String getLotTimeDurationConfilct() {
        return LOT_TIME_DURATION_CONFILCT;
    }

    public static String getOvenCapacityConflict() {
        return OVEN_CAPACITY_CONFLICT;
    }

    public void setOvenCapacityConflict(HardSoftScore ovenCapacityConflict) {
        this.ovenCapacityConflict = ovenCapacityConflict;
    }

    //public static String getDoAllLotAsSoonAsPossible() {
    //     return DO_ALL_LOT_AS_SOON_AS_POSSIBLE;
    // }

    public HardSoftScore getLotTimeDurationConflict() {
        return lotTimeDurationConflict;
    }

    public void setLotTimeDurationConflict(HardSoftScore lotTimeDurationConflict) {
        this.lotTimeDurationConflict = lotTimeDurationConflict;
    }

    //  public HardSoftScore getDoLotASAPPossible() {
    //     return doLotASAPPossible;
    //}

    // public void setDoLotASAPPossible(HardSoftScore doLotASAPPossible) {
    //    this.doLotASAPPossible = doLotASAPPossible;
    //}
}
