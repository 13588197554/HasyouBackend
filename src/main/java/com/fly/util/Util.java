package com.fly.util;

import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

public class Util {

    private static String FULL_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private static String DAY_FORMAT = "yyyy-MM-dd";
    private static String timeZone = "Asia/Shanghai";

    /**
     * return uuid
     * @return
     */
    public static String getUUid() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replaceAll("-", "");
    }

    /**
     * return FULL_FORMAT time by given timestamp
     * @param timestamp
     * @return
     */
    public static String getTime(Long timestamp) {
        DateFormat dateFormat = new SimpleDateFormat(FULL_FORMAT);
        dateFormat.setTimeZone(TimeZone.getTimeZone(timeZone));
        Date date = new Date(timestamp);
        return dateFormat.format(date);
    }

    public static Long getTimestamp(String formatTime) {
        try {
            DateFormat df = new SimpleDateFormat(FULL_FORMAT);
            return df.parse(formatTime).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * getString current sql timestamp
     * @return
     */
    public static Timestamp getCurrentSqlTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }

    /**
     * getString current timestamp
     * @return
     */
    public static long getCurrentTimestamp() {
        return System.currentTimeMillis();
    }

    /**
     * getString getBooks values from given map collection(key/value)
     * @param map
     * @return
     */
    public static List getValuesFromMap(Map map) {
        ArrayList<Object> list = new ArrayList<>();
        map.forEach((key, value) -> list.add(value));
        return list;
    }

    public static String getCurrentFormatTime() {
        SimpleDateFormat sdf = new SimpleDateFormat(FULL_FORMAT);
        sdf.setTimeZone(TimeZone.getTimeZone(timeZone));
        return sdf.format(new Date());
    }

    public static String getCurrentDayFormatTime() {
        LocalDate now = LocalDate.now();
        return now + " 00:00:00";
    }

    public static long getCurrentDayTimestamp() throws ParseException {
        String s = getCurrentDayFormatTime();
        SimpleDateFormat sdf = new SimpleDateFormat(FULL_FORMAT);
        Date date = sdf.parse(s);
        System.out.println(date);
        return 1l;
    }

    /**
     * getString getBooks keys from given map collection(key/value)
     * @param map
     * @return
     */
    public static<U, V> List<U> getKeysFromMap(Map<U, V> map) {
        ArrayList<U> list = new ArrayList<>();
        map.forEach((key, value) -> list.add(key));
        return list;
    }

    /**
     * question!
     * @param key
     * @param list
     * @param <T>
     * @return
     */
    public static<T> Map<String, T> getReferFromList(String key, List<T> list) {
        HashMap<String, T> map = new HashMap<>();
        list.forEach(item -> {
            Class<?> clazz = item.getClass();
            try {
                Field field = clazz.getDeclaredField(key);
                field.setAccessible(true);
                String k = (String) field.get(item);
                map.put(k, item);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        return map;
    }

    /**
     * delete key/value from given map
     * @return
     */
    @Deprecated
    public static Map removeKeyValueFromMap(Map map, String key) {
        return null;
    }

    /**
     * return a random number of int, >= begin and < end
     * @param begin
     * @param end
     * @return
     */
    public static int getRandomInt(int begin, int end) {
        Random random = new Random();
        if (end < begin) {
            throw new RuntimeException("end must grate than begin!");
        }
        return random.nextInt(end - begin + 1) + begin;
    }

    public static void getRandomSleep(int begin, int end) {
        try {
            Thread.sleep(getRandomInt(begin, end) * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void getRandomSleep(int second) {
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws ParseException {
        String s = getCurrentFormatTime();
        new SimpleDateFormat();
    }

}
