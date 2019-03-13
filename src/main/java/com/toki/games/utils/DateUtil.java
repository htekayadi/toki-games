package com.toki.games.utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class DateUtil {
    public static LocalDateTime getLocalDateTime(String timemillis) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(Long.valueOf(timemillis)), ZoneId.systemDefault());
    }
}
