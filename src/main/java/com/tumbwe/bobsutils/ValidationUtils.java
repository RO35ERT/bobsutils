package com.tumbwe.bobsutils;

import java.util.Collection;

/**
 * Utilities for common data validation and assertions.
 */
public class ValidationUtils {

    /**
     * Asserts that an object is not null.
     */
    public static void notNull(Object obj, String message) {
        if (obj == null) throw new IllegalArgumentException(message);
    }

    /**
     * Asserts that a string is not blank.
     */
    public static void hasText(String str, String message) {
        if (StringUtils.isBlank(str)) throw new IllegalArgumentException(message);
    }

    /**
     * Asserts that a collection is not empty.
     */
    public static void notEmpty(Collection<?> col, String message) {
        if (CollectionUtils.isEmpty(col)) throw new IllegalArgumentException(message);
    }

    /**
     * Validates if a string is a valid URL.
     */
    public static boolean isUrl(String url) {
        if (StringUtils.isBlank(url)) return false;
        try {
            new java.net.URL(url).toURI();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Validates if a string is a standard email address.
     */
    public static boolean isEmail(String email) {
        if (StringUtils.isBlank(email)) return false;
        return email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }

    /**
     * Validates if a password meets specific strength requirements.
     *
     * @param password       The password to check.
     * @param minLength      The minimum required length.
     * @param requireNumbers If true, at least one digit is required.
     * @param requireSymbols If true, at least one special character is required.
     * @return true if all selected criteria are met.
     */
    public static boolean isStrongPassword(String password, int minLength, boolean requireNumbers, boolean requireSymbols) {
        if (StringUtils.isBlank(password) || password.length() < minLength) return false;
        
        if (requireNumbers && !password.matches(".*\\d.*")) return false;
        if (requireSymbols && !password.matches(".*[!@#$%^&*(),.?\":{}|<>].*")) return false;
        
        // Always require both upper and lower case for "strong" classification
        return password.matches(".*[A-Z].*") && password.matches(".*[a-z].*");
    }

    /**
     * Default strong password check (8+ chars, numbers, and upper/lower case).
     */
    public static boolean isStrongPassword(String password) {
        return isStrongPassword(password, 8, true, false);
    }
}
