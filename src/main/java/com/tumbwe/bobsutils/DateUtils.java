package com.tumbwe.bobsutils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Utilities for Date and Time manipulation.
 */
public class DateUtils {

    public static final String ISO_DATE = "yyyy-MM-dd";
    public static final String ISO_DATE_TIME = "yyyy-MM-dd'T'HH:mm:ss";
    public static final String DAY_MONTH_YEAR = "dd/MM/yyyy";
    public static final String WEEKDAY_DAY_MONTH_YEAR = "EEEE, d MMMM yyyy";
    public static final String FRIENDLY_DATE = "MMM d, yyyy";
    public static final String FRIENDLY_DATE_TIME = "MMM d, yyyy h:mm a";
    public static final String TIME_24H = "HH:mm:ss";
    public static final String TIME_12H = "h:mm a";
    public static final String MONTH_YEAR = "MMMM yyyy";
    public static final String DAY_MONTH = "d MMMM";
    public static final String COMPACT_DATE = "yyyyMMdd";
    public static final String COMPACT_DATE_TIME = "yyyyMMddHHmmss";
    public static final String DOT_DATE = "dd.MM.yyyy";
    public static final String REVERSE_ISO = "yyyy/MM/dd";

    /**
     * Formats a LocalDateTime using a custom pattern.
     */
    public static String format(LocalDateTime dateTime, String pattern) {
        if (dateTime == null || StringUtils.isBlank(pattern)) return null;
        try {
            return dateTime.format(DateTimeFormatter.ofPattern(pattern));
        } catch (Exception e) {
            return dateTime.toString();
        }
    }

    /**
     * Overloaded format method that takes a String date and auto-parses it before formatting.
     * Supports ISO (JS style), standard dates, and custom patterns.
     */
    public static String format(String dateStr, String pattern) {
        LocalDateTime dateTime = parse(dateStr);
        return format(dateTime, pattern);
    }

    /**
     * Automatically attempts to parse a String into a LocalDateTime.
     * Handles ISO 8601 (JS style with 'T'), standard formats, and compact formats.
     */
    public static LocalDateTime parse(String dateStr) {
        if (StringUtils.isBlank(dateStr)) return null;
        String cleaned = dateStr.trim();
        
        // Try common patterns
        String[] patterns = {
            ISO_DATE_TIME,
            "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", // JS ISO with millis and Z
            "yyyy-MM-dd'T'HH:mm:ss.SSS",
            ISO_DATE,
            DAY_MONTH_YEAR,
            FRIENDLY_DATE_TIME,
            COMPACT_DATE_TIME,
            COMPACT_DATE,
            DOT_DATE
        };

        for (String p : patterns) {
            try {
                if (p.equals(ISO_DATE) || p.equals(DAY_MONTH_YEAR) || p.equals(COMPACT_DATE) || p.equals(DOT_DATE)) {
                    return java.time.LocalDate.parse(cleaned, DateTimeFormatter.ofPattern(p)).atStartOfDay();
                }
                return LocalDateTime.parse(cleaned, DateTimeFormatter.ofPattern(p));
            } catch (Exception ignored) {}
        }
        
        // Last ditch effort for ISO with 'T' if not matched exactly
        try {
            return LocalDateTime.parse(cleaned.replace("Z", ""));
        } catch (Exception ignored) {}

        return null;
    }

    /**
     * Formats to: Monday, 1 January 2024 (Accepts String)
     */
    public static String toWeekDayMonthYear(String dateStr) {
        return format(dateStr, WEEKDAY_DAY_MONTH_YEAR);
    }
    public static String toWeekDayMonthYear(LocalDateTime date) {
        return format(date, WEEKDAY_DAY_MONTH_YEAR);
    }

    /**
     * Formats to: 01/01/2024 (Accepts String)
     */
    public static String toDayMonthYear(String dateStr) {
        return format(dateStr, DAY_MONTH_YEAR);
    }
    public static String toDayMonthYear(LocalDateTime date) {
        return format(date, DAY_MONTH_YEAR);
    }

    /**
     * Formats to: Jan 1, 2024 (Accepts String)
     */
    public static String toFriendlyDate(String dateStr) {
        return format(dateStr, FRIENDLY_DATE);
    }
    public static String toFriendlyDate(LocalDateTime date) {
        return format(date, FRIENDLY_DATE);
    }

    /**
     * Formats to: Jan 1, 2024 10:00 AM (Accepts String)
     */
    public static String toFriendlyDateTime(String dateStr) {
        return format(dateStr, FRIENDLY_DATE_TIME);
    }
    public static String toFriendlyDateTime(LocalDateTime date) {
        return format(date, FRIENDLY_DATE_TIME);
    }

    /**
     * Formats a LocalDateTime to ISO string.
     */
    public static String formatIso(LocalDateTime dateTime) {
        return format(dateTime, ISO_DATE_TIME);
    }

    /**
     * Parses an ISO string to LocalDateTime.
     */
    public static LocalDateTime parseIso(String isoString) {
        return parse(isoString);
    }

    /**
     * Returns the current date and time as a string in ISO format.
     */
    public static String nowIso() {
        return now(ISO_DATE_TIME);
    }

    /**
     * Returns current date/time in specified format.
     */
    public static String now(String pattern) {
        return format(LocalDateTime.now(), pattern);
    }
}
