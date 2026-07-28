package com.company.common;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    private DateUtils() {
    }

    public static String today() {
        return LocalDate.now()
                .format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }
}