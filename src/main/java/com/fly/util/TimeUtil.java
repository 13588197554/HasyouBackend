package com.fly.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author david
 * @date 05/08/18 17:01
 */
public class TimeUtil {
    private static String FULL_FORMAT = "YYYY-MM-dd HH:mm:ss";
    private static String DAY_FORMAT = "YYYY-MM-dd";
    private static String TIMEZONE = "Asia/Shanghai";
    private static ZoneId ZONE_ID = ZoneId.of(TIMEZONE);

    /**
     * 获取当前的凌晨时间
     * @return 时间字符串
     */
    public static String getCurrDayStartFormatTime() {
        LocalDate now = LocalDate.now(ZONE_ID);
        return now + " 00:00:00";
    }

    /**
     * 获取当前时间字符串，以默认格式
     * @param timestamp
     * @return
     */
    public static String getTime(Long timestamp) {
        DateFormat dateFormat = new SimpleDateFormat(FULL_FORMAT);
        dateFormat.setTimeZone(TimeZone.getTimeZone(TIMEZONE));
        Date date = new Date(timestamp);
        return dateFormat.format(date);
    }

    /**
     * 获取当天凌晨时间戳
     * @return
     */
    public static long getCurrDayStartTimestamp() {
        LocalTime now = LocalTime.now();
        int hour = now.getHour();
        int minute = now.getMinute();
        int second = now.getSecond();
        long timestamp = (hour * 3600 + minute * 60 + second) * 1000;
        long timestamp2 = Instant.now().toEpochMilli();
        return timestamp2 - timestamp;
    }

    /**
     * 获取当前时间戳
     * @return
     */
    public static long getCurrTimestamp() {
        return Instant.now().getEpochSecond();
    }

    /**
     * 获取当前几号
     * @return
     */
    public static int getCurrDay() {
        LocalDate now = LocalDate.now(ZONE_ID);
        return now.getDayOfMonth();
    }

    /**
     * 获取当前月份
     * @return
     */
    public static int getCurrMonth() {
        LocalDate now = LocalDate.now(ZONE_ID);
        return now.getMonthValue();
    }

    /**
     * 获取当前年份
     * @return
     */
    public static int getCurrYear() {
        LocalDate now = LocalDate.now(ZONE_ID);
        return now.getYear();
    }

    public static void main(String[] args) {
        Long t1 = 1538974846 * 1000L;
        String s = getTime(t1);
        System.out.println(s);
    }

}
