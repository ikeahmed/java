package com.me.date;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeParse {
    public static void main(String[] args) {
        DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSxxxx");
        String dateString = "2019-08-29T00:00:00.000+0000";
        ZonedDateTime zonedDateTime = ZonedDateTime.parse(dateString, DATE_TIME_FORMATTER);
        System.out.println(zonedDateTime);
        }
    }

