package com.yaoyili.utils;

import java.sql.Date;
import java.util.Calendar;

public class TimeUtils {

    public static long backDate(int type, Date curTime) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(curTime);

        switch (type) {
            case 0: {
                calendar.add(Calendar.DATE, -7);
                break;
            }
            case 1:{
                calendar.add(Calendar.MONTH, -1);
                break;
            }
            case 2:{
                calendar.add(Calendar.YEAR, -1);
                break;
            }
        }
        return calendar.getTimeInMillis();
    }
}
