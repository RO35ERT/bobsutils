package com.tumbwe.bobsutils;

import java.util.UUID;

/**
 * Utilities for generating unique identifiers.
 */
public class IdUtils {

    /**
     * Generates a standard random UUID string.
     */
    public static String uuid() {
        return UUID.randomUUID().toString();
    }

    /**
     * Generates a random short ID (first 8 characters of a UUID).
     */
    public static String shortId() {
        return uuid().substring(0, 8);
    }
}
