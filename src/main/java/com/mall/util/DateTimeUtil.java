package com.mall.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;

/**
 * 时间工具类
 * @author suiguozhen on 19/01/29 10:34
 */
public class DateTimeUtil {
    /**
     * 获取今日00:00的时间戳
     * @return Long
     */
    public static Long getTodayStartTimestamp(){
       return LocalDateTime.of(LocalDate.now(),  LocalTime.of(0, 0, 0)).toEpochSecond(ZoneOffset.of("+8"));
    }

    /**
     * 获取今日00:00的LocalDateTime
     * @return LocalDateTime
     */
    public static LocalDateTime getTodayLocalDateTime(){
        return LocalDateTime.of(LocalDate.now(ZoneOffset.of("+8")),LocalTime.of(0,0,0));
    }
}
