package com.jomchen.springtest.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

/**
 * create by Jomchen on 5/6/18
 */
public class DateTimeUtils {

    public static final String DATE_TIME_FOR_MATTER_STRING = "DATE_TIME_FOR_MATTER";
    public static final String DATE_FOR_MATTER_STRING = "DATE_FOR_MATTER";
    public static final String TIME_FOR_MATTER_STRING = "TIME_FOR_MATTER";
    public static final String DATE_TIME_NO_SPLITE_FOR_MATTER_STRING = "DATE_TIME_NO_SPLITE_FOR_MATTER";
    public static final String DATE_NO_SPLITE_FOR_MATTER_NO_SPLITE_STRING = "DATE_NO_SPLITE_FOR_MATTER_NO_SPLITE";
    public static final String TIME_NO_SPLITE_FOR_MATTER_NO_SPLITE_STRING = "TIME_NO_SPLITE_FOR_MATTER_NO_SPLITE";

    public static final DateTimeFormatter DATE_TIME_FOR_MATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public static final DateTimeFormatter DATE_FOR_MATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static final DateTimeFormatter TIME_FOR_MATTER = DateTimeFormatter.ofPattern("HH:mm:ss");
    public static final DateTimeFormatter DATE_TIME_NO_SPLITE_FOR_MATTER = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
    public static final DateTimeFormatter DATE_NO_SPLITE_FOR_MATTER_NO_SPLITE = DateTimeFormatter.ofPattern("yyyyMMdd");
    public static final DateTimeFormatter TIME_NO_SPLITE_FOR_MATTER_NO_SPLITE = DateTimeFormatter.ofPattern("HHmmss");

    public static Map<String, DateTimeFormatter> localDateTimeMap = new HashMap<>();
    {
        localDateTimeMap.put(DATE_TIME_FOR_MATTER_STRING, DATE_TIME_FOR_MATTER);
        localDateTimeMap.put(DATE_FOR_MATTER_STRING, DATE_FOR_MATTER);
        localDateTimeMap.put(TIME_FOR_MATTER_STRING, TIME_FOR_MATTER);
        localDateTimeMap.put(DATE_TIME_FOR_MATTER_STRING, DATE_TIME_FOR_MATTER);
        localDateTimeMap.put(DATE_TIME_NO_SPLITE_FOR_MATTER_STRING, DATE_TIME_NO_SPLITE_FOR_MATTER);
        localDateTimeMap.put(DATE_NO_SPLITE_FOR_MATTER_NO_SPLITE_STRING, DATE_NO_SPLITE_FOR_MATTER_NO_SPLITE);
        localDateTimeMap.put(TIME_NO_SPLITE_FOR_MATTER_NO_SPLITE_STRING, TIME_NO_SPLITE_FOR_MATTER_NO_SPLITE);
    }

    public LocalDateTime getLocalDateTime(String str) {
        return null;
    }

}
