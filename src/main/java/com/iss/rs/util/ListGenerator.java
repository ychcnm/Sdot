package com.iss.rs.util;

import com.iss.rs.domain.Day;
import com.iss.rs.domain.LotAssignment;
import com.iss.rs.domain.LotPackage;
import com.iss.rs.domain.TimeGrain;
import com.iss.rs.entity.Lot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ListGenerator {

    public void generateTimeList(List<Day> dayList, List<TimeGrain> timeGrainList, int start, int gap) {
        int k = 0;
        long dayId = 0L, timeGrainId = 0L;
        while (k <= gap) {
            Day day = new Day();
            day.setId(dayId++);
            day.setDayOfYear(start + k);
            dayList.add(day);

            for (int j = 0; j < 24; j++) {
                TimeGrain timeGrain = new TimeGrain();
                timeGrain.setId(timeGrainId);
                timeGrain.setGrainIndex((int) timeGrainId++);
                timeGrain.setDay(day);
                timeGrain.setStartingMinuteOfDay(0 + j * 60);
                timeGrainList.add(timeGrain);
            }
            k++;
        }
    }

    public void generatePackageList(List<Lot> lotList, List<LotPackage> lotPackagesList, List<LotAssignment> lotAssignment) {

        Long LPId = 0L;

        HashMap<String, Double> filter = new HashMap<>();
        HashMap<String, List<Lot>> container = new HashMap<>();

        for (Lot l : lotList) {
            int time = l.getProductinfo().getBakeTime();
            int temp = l.getProductinfo().getTemperature();
            String s = Integer.toString(time) + temp;
            if (filter.get(s) == null) {
                filter.put(s, l.getRequiredCapacity());
                List<Lot> llist = new ArrayList<>();
                llist.add(l);
                container.put(s, llist);
            } else {
                if (filter.get(s) + l.getRequiredCapacity() > 100.0) {
                    LotPackage lp = new LotPackage(container.get(s), LPId++, temp, time, filter.get(s));
                    lp.setId(lp.getLotPackageId());
                    lotPackagesList.add(lp);

                    filter.remove(s);
                    container.remove(s);

                    filter.put(s, l.getRequiredCapacity());
                    List<Lot> llist = new ArrayList<>();
                    llist.add(l);
                    container.put(s, llist);

                } else {
                    double n = filter.get(s) + l.getRequiredCapacity();
                    List<Lot> llist = container.get(s);
                    llist.add(l);
                    filter.put(s, n);
                    container.put(s, llist);
                }
            }
        }

        for (String key : filter.keySet()) {
            List<Lot> llist = container.get(key);
            LotPackage lp = new LotPackage(container.get(key), LPId++, container.get(key).get(0).getProductinfo().getTemperature(), container.get(key).get(0).getProductinfo().getBakeTime(), filter.get(key));
            lp.setId(lp.getLotPackageId());
            lotPackagesList.add(lp);
        }

        for (LotPackage l : lotPackagesList) {
            LotAssignment la = new LotAssignment();
            la.setLotPackage(l);
            la.setId(l.getId());
            lotAssignment.add(la);
        }
    }
}
