package com.iss.rs.domain;

import org.optaplanner.core.api.domain.constraintweight.ConstraintConfiguration;
import org.optaplanner.core.api.domain.constraintweight.ConstraintWeight;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;

@ConstraintConfiguration(constraintPackage = "solver")
public class LotConstrainConfiguration extends AbstractPersistable {


    public static final String OVEN_CONFLICT = "Oven conflict";
    public static final String DONT_GO_IN_OVERTIME = "Don't go in overtime";
    public static final String CAPACITY_CONFLICT = "Capacity conflict";
    public static final String TEMPERATURE_CONFLICT = "Temperature conflict";
    public static final String DO_ALL_MEETINGS_AS_SOON_AS_POSSIBLE = "Do all lot as soon as possible";

    @ConstraintWeight(OVEN_CONFLICT)
    private HardSoftScore ovenConflict = HardSoftScore.ofHard(1);

    @ConstraintWeight(DONT_GO_IN_OVERTIME)
    private HardSoftScore dontGoInOvertime = HardSoftScore.ofHard(1);

    @ConstraintWeight(CAPACITY_CONFLICT)
    private HardSoftScore capacityConflict = HardSoftScore.ofHard(1);

    @ConstraintWeight(TEMPERATURE_CONFLICT)
    private HardSoftScore temperatureConflict = HardSoftScore.ofHard(1);

    @ConstraintWeight(DO_ALL_MEETINGS_AS_SOON_AS_POSSIBLE)
    private HardSoftScore doAllMeetingsAsSoonAsPossible = HardSoftScore.ofSoft(1);

    public LotConstrainConfiguration() {
    }

    public LotConstrainConfiguration(long id) {
        super(id);
    }

    // ************************************************************************
    // Simple getters and setters
    // ************************************************************************


    public HardSoftScore getOvenConflict() {
        return ovenConflict;
    }

    public void setOvenConflict(HardSoftScore ovenConflict) {
        this.ovenConflict = ovenConflict;
    }

    public HardSoftScore getDontGoInOvertime() {
        return dontGoInOvertime;
    }

    public void setDontGoInOvertime(HardSoftScore dontGoInOvertime) {
        this.dontGoInOvertime = dontGoInOvertime;
    }

    public HardSoftScore getCapacityConflict() {
        return capacityConflict;
    }

    public void setCapacityConflict(HardSoftScore capacityConflict) {
        this.capacityConflict = capacityConflict;
    }

    public HardSoftScore getTemperatureConflict() {
        return temperatureConflict;
    }

    public void setTemperatureConflict(HardSoftScore temperatureConflict) {
        this.temperatureConflict = temperatureConflict;
    }

    public HardSoftScore getDoAllMeetingsAsSoonAsPossible() {
        return doAllMeetingsAsSoonAsPossible;
    }

    public void setDoAllMeetingsAsSoonAsPossible(HardSoftScore doAllMeetingsAsSoonAsPossible) {
        this.doAllMeetingsAsSoonAsPossible = doAllMeetingsAsSoonAsPossible;
    }
}
