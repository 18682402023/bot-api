package com.yunva.admin.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    /**
     * 字符串转时间
     * @param json
     * @param pattern
     * @return
     */
    public static Date strToDate(String json, String pattern){
        DateFormat sdf = new SimpleDateFormat(pattern);
        try {
            return sdf.parse(json);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 时间转字符串
     * @param date
     * @param pattern
     * @return
     */
    public static String dateToStr(Date date, String pattern){
        DateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

}
