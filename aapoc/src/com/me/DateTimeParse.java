package com.me;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateTimeParse {

    public static void main(String[] args) {
        LocalDateTime datetime1 = LocalDateTime.now();
        System.out.println(datetime1);

        DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSxxxx");
        try {
            ZonedDateTime zonedDateTime = ZonedDateTime.parse("2019-10-29T00:00:00.000+0000", DATE_TIME_FORMATTER);
            System.out.println(zonedDateTime);
            zonedDateTime = ZonedDateTime.parse("2019-10-29T00:00:00.000", DATE_TIME_FORMATTER);
            System.out.println(zonedDateTime);
        } catch (DateTimeParseException e) {
            System.out.println(e);
        }

    }


}

