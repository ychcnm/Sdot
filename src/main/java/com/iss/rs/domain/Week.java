package com.iss.rs.domain;

public class Week {

    private int[] startingHourOfDayOptions = {
            0 * 60, // 00:00
            1 * 60, // 01:00
            2 * 60, // 02:00
            3 * 60, // 03:00
            4 * 60, // 04:00
            5 * 60, // 05:00
            6 * 60, // 06:00
            7 * 60, // 07:00
            8 * 60, // 08:00
            9 * 60, // 09:00
            10 * 60, // 10:00
            11 * 60, // 11:00
            13 * 60, // 13:00
            14 * 60, // 14:00
            15 * 60, // 15:00
            16 * 60, // 16:00
            17 * 60, // 17:00
            18 * 60, // 18:00
            19 * 60, // 19:00
            20 * 60, // 20:00
            21 * 60, // 21:00
            22 * 60, // 22:00
            23 * 60, // 23:00
    };

    public int[] getStartingHourOfDayOptions() {
        return startingHourOfDayOptions;
    }

    public void setStartingHourOfDayOptions(int[] startingHourOfDayOptions) {
        this.startingHourOfDayOptions = startingHourOfDayOptions;
    }
}
