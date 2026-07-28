package com.company.common;

public class StringUtils {

    private StringUtils() {
    }

    public static String capitalize(String input) {

        if (input == null || input.isBlank()) {
            return input;
        }

        return input.substring(0, 1).toUpperCase()
                + input.substring(1).toLowerCase();
    }
}
