package com.tumbwe.bobsutils;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Utilities for Number manipulation.
 */
public class NumberUtils {

    /**
     * Safely parses a string to an Integer. Returns null if parsing fails.
     */
    public static Integer parseInteger(String str) {
        if (str == null) return null;
        try {
            return Integer.parseInt(str.trim());
        } catch (NumberFormatException e) {
            return null;
        }
    }

    /**
     * Rounds a double to the specified number of decimal places.
     */
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();
        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    /**
     * Safely parses a string to a Long. Returns null if parsing fails.
     */
    public static Long parseLong(String str) {
        if (str == null) return null;
        try {
            return Long.parseLong(str.trim());
        } catch (NumberFormatException e) {
            return null;
        }
    }

    /**
     * Safely parses a string to a Double. Returns null if parsing fails.
     */
    public static Double parseDouble(String str) {
        if (str == null) return null;
        try {
            return Double.parseDouble(str.trim());
        } catch (NumberFormatException e) {
            return null;
        }
    }

    /**
     * Returns a default value if the parsed integer is null.
     */
    public static int toInt(String str, int defaultValue) {
        Integer val = parseInteger(str);
        return val == null ? defaultValue : val;
    }

    /**
     * Clamps a value between a minimum and maximum range.
     */
    public static int clamp(int value, int min, int max) {
        return Math.max(min, Math.min(max, value));
    }

    /**
     * Formats a number as a simple currency string (e.g., 1234.5 -> "1,234.50").
     */
    public static String formatCurrency(double value) {
        return formatCurrency(value, "");
    }

    /**
     * Formats a number as a currency string with a symbol (e.g., (1234.5, "$") -> "$1,234.50").
     */
    public static String formatCurrency(double value, String symbol) {
        return symbol + String.format("%,.2f", value);
    }

    /**
     * Formats a number with specific thousand and decimal separators.
     * Example: (1000000, '.', ',') -> "1.000.000"
     */
    public static String formatCustom(double value, int decimals, char thousandSeparator, char decimalSeparator) {
        String pattern = "%." + decimals + "f";
        String formatted = String.format(java.util.Locale.US, pattern, value);
        
        String[] parts = formatted.split("\\.");
        StringBuilder res = new StringBuilder();
        String integerPart = parts[0];
        
        int count = 0;
        for (int i = integerPart.length() - 1; i >= 0; i--) {
            res.insert(0, integerPart.charAt(i));
            count++;
            if (count == 3 && i > 0) {
                res.insert(0, thousandSeparator);
                count = 0;
            }
        }
        
        if (parts.length > 1) {
            res.append(decimalSeparator).append(parts[1]);
        }
        return res.toString();
    }

    /**
     * Pads a number with leading zeros (e.g., (1, 4) -> "0001").
     */
    public static String padLeft(int value, int length) {
        return String.format("%0" + length + "d", value);
    }

    /**
     * Calculates what percentage 'part' is of 'total'.
     */
    public static double percentage(double part, double total) {
        if (total == 0) return 0;
        return (part / total) * 100;
    }

    /**
     * Returns the ordinal representation of a number (e.g., 1 -> "1st", 2 -> "2nd").
     */
    public static String toOrdinal(int i) {
        String[] suffixes = new String[] { "th", "st", "nd", "rd", "th", "th", "th", "th", "th", "th" };
        switch (i % 100) {
            case 11:
            case 12:
            case 13:
                return i + "th";
            default:
                return i + suffixes[i % 10];
        }
    }

    /**
     * Checks if a number is even.
     */
    public static boolean isEven(int n) {
        return n % 2 == 0;
    }

    /**
     * Checks if a number is odd.
     */
    public static boolean isOdd(int n) {
        return n % 2 != 0;
    }

    /**
     * Checks if a number is within a range [min, max] inclusive.
     */
    public static boolean inRange(double val, double min, double max) {
        return val >= min && val <= max;
    }

    /**
     * Safely compares two Integers, handling nulls.
     */
    public static int compare(Integer a, Integer b) {
        if (a == null && b == null) return 0;
        if (a == null) return -1;
        if (b == null) return 1;
        return a.compareTo(b);
    }

    /**
     * Converts a number to Roman Numerals (supports 1 to 3999).
     */
    public static String toRoman(int number) {
        if (number < 1 || number > 3999) return String.valueOf(number);
        String[] romanNumerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (number >= values[i]) {
                number -= values[i];
                res.append(romanNumerals[i]);
            }
        }
        return res.toString();
    }
}
