package com.musala.drones.common.util;

public final class StringUtils {
    private StringUtils() {
    }

    public static String toPercentage(float percent) {
        return Math.round(percent) + "%";
    }

    public static String toGrams(float weight) {
        return Math.round(weight * 100.0) / 100.0 + "gm";
    }
}
