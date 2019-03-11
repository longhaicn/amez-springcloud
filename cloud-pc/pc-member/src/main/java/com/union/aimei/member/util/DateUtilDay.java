package com.union.aimei.member.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author houji
 * @date 2018/4/19  15:16
 */
public class DateUtilDay {
    public static String getDate(Calendar now, int days){
        now.add(Calendar.DAY_OF_MONTH, -days+1);
        now.set(Calendar.HOUR_OF_DAY, 0);
        now.set(Calendar.MINUTE, 0);
        now.set(Calendar.SECOND, 0);
        String endDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(now.getTime());
        return endDate;
    }
}
