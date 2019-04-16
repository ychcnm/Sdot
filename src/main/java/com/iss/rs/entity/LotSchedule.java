package com.iss.rs.entity;

import org.optaplanner.core.api.domain.constraintweight.ConstraintConfigurationProvider;
import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningScore;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.drools.ProblemFactCollectionProperty;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;

import java.util.List;

@PlanningSolution
public class LotSchedule extends AbstractPersistable {
    @ConstraintConfigurationProvider
    private LotConstrainConfiguration constraintConfiguration;

    @ProblemFactCollectionProperty
    private List<Lot> LotList;

    @ProblemFactCollectionProperty
    private List<Day> dayList;

    @ValueRangeProvider(id = "timeGrainRange")
    @ProblemFactCollectionProperty
    private List<TimeGrain> timeGrainList;

    @ValueRangeProvider(id = "ovenRange")
    @ProblemFactCollectionProperty
    private List<Oven> ovenList;

    @PlanningEntityCollectionProperty
    private List<LotAssignment> lotAssignmentList;

    @PlanningScore
    private HardSoftScore score;

    public LotConstrainConfiguration getConstraintConfiguration() {
        return constraintConfiguration;
    }

    public void setConstraintConfiguration(LotConstrainConfiguration constraintConfiguration) {
        this.constraintConfiguration = constraintConfiguration;
    }

    public List<Lot> getLotList() {
        return LotList;
    }

    public void setLotList(List<Lot> lotList) {
        LotList = lotList;
    }

    public List<Day> getDayList() {
        return dayList;
    }

    public void setDayList(List<Day> dayList) {
        this.dayList = dayList;
    }

    public List<TimeGrain> getTimeGrainList() {
        return timeGrainList;
    }

    public void setTimeGrainList(List<TimeGrain> timeGrainList) {
        this.timeGrainList = timeGrainList;
    }

    public List<Oven> getOvenList() {
        return ovenList;
    }

    public void setOvenList(List<Oven> ovenList) {
        this.ovenList = ovenList;
    }

    public List<LotAssignment> getLotAssignmentList() {
        return lotAssignmentList;
    }

    public void setLotAssignmentList(List<LotAssignment> lotAssignmentList) {
        this.lotAssignmentList = lotAssignmentList;
    }

    public HardSoftScore getScore() {
        return score;
    }

    public void setScore(HardSoftScore score) {
        this.score = score;
    }

}
