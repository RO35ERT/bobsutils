package com.tumbwe.bobsutils;

import java.util.Optional;

/**
 * Utilities for working with Enums.
 */
public class EnumUtils {

    /**
     * Safely converts a string to an Enum constant.
     * Returns Optional.empty() if no match is found, avoiding exceptions.
     */
    public static <T extends Enum<T>> Optional<T> getEnum(Class<T> enumClass, String value) {
        if (enumClass == null || StringUtils.isBlank(value)) return Optional.empty();
        try {
            return Optional.of(Enum.valueOf(enumClass, value.trim()));
        } catch (IllegalArgumentException e) {
            return Optional.empty();
        }
    }

    /**
     * Checks if a string is a valid constant of an Enum.
     */
    public static <T extends Enum<T>> boolean isValid(Class<T> enumClass, String value) {
        return getEnum(enumClass, value).isPresent();
    }
}
