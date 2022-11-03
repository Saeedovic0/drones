package com.musala.drones.common.util;

public final class StringUtils {
    private StringUtils() {
    }

    public static String toPercentage(float percent) {
        return ((int) (percent * 100)) + "%";
    }
}
