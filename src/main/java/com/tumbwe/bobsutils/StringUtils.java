package com.tumbwe.bobsutils;

/**
 * Utilities for String manipulation.
 */
public class StringUtils {

    /**
     * Checks if a string is null or empty.
     * @param str the string to check
     * @return true if null or empty
     */
    public static boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    /**
     * Checks if a string is null, empty, or only whitespace.
     * @param str the string to check
     * @return true if null, empty, or whitespace
     */
    public static boolean isBlank(String str) {
        return str == null || str.trim().isEmpty();
    }

    /**
     * Safely trims a string, returning an empty string if null.
     * @param str the string to trim
     * @return the trimmed string, or "" if null
     */
    public static String safeTrim(String str) {
        return str == null ? "" : str.trim();
    }

    /**
     * Capitalizes the first letter of a string.
     * @param str the string to capitalize
     * @return the capitalized string
     */
    public static String capitalize(String str) {
        if (isEmpty(str)) return str;
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }

    /**
     * Convert string to URL-friendly slug.
     * @param input the string to slugify
     * @return the URL slug
     */
    public static String slugify(String input) {
        if (isEmpty(input)) return "";
        return input.toLowerCase()
                .replaceAll("[^a-z0-9\\s]", "")
                .replaceAll("\\s+", "-")
                .replaceAll("^-|-$", "");
    }

    /**
     * Masks an email or sensitive string (e.g. j***@example.com).
     * @param input the string to mask
     * @return the masked string
     */
    public static String mask(String input) {
        if (isEmpty(input) || input.length() < 3) return "****";
        if (input.contains("@")) {
            String[] parts = input.split("@");
            return parts[0].charAt(0) + "***@" + parts[1];
        }
        return input.substring(0, 1) + "***" + input.substring(input.length() - 1);
    }

    /**
     * Truncates a string and adds ellipsis if it exceeds maxLength.
     * @param input the string to truncate
     * @param maxLength the maximum length allowed
     * @return the truncated string
     */
    public static String truncate(String input, int maxLength) {
        if (isEmpty(input) || input.length() <= maxLength) return input;
        return input.substring(0, maxLength - 3) + "...";
    }

    /**
     * Generates a random alphanumeric string of a given length.
     * @param length the desired length
     * @return the random string
     */
    public static String randomAlphanumeric(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder();
        java.util.Random random = new java.util.Random();
        for (int i = 0; i < length; i++) {
            sb.append(chars.charAt(random.nextInt(chars.length())));
        }
        return sb.toString();
    }

    /**
     * Checks if a string contains another string, ignoring case.
     * @param str the string to check
     * @param searchStr the string to look for
     * @return true if found
     */
    public static boolean containsIgnoreCase(String str, String searchStr) {
        if (str == null || searchStr == null) return false;
        return str.toLowerCase().contains(searchStr.toLowerCase());
    }

    /**
     * Extracts only the digits from a string.
     * @param input the string to extract from
     * @return only numeric characters
     */
    public static String extractDigits(String input) {
        if (isEmpty(input)) return "";
        return input.replaceAll("\\D", "");
    }

    /**
     * Returns a default string if the input is empty or null.
     * @param input the string to check
     * @param defaultStr the fallback value
     * @return the original string or fallback
     */
    public static String defaultIfEmpty(String input, String defaultStr) {
        return isEmpty(input) ? defaultStr : input;
    }

    /**
     * Checks if a string consists entirely of digits.
     * @param str the string to check
     * @return true if numeric
     */
    public static boolean isNumeric(String str) {
        if (isEmpty(str)) return false;
        return str.matches("\\d+");
    }

    /**
     * Counts how many times a substring appears in a string.
     * @param str the main string
     * @param sub the substring to count
     * @return frequency of occurrence
     */
    public static int countMatches(String str, String sub) {
        if (isEmpty(str) || isEmpty(sub)) return 0;
        int count = 0;
        int idx = 0;
        while ((idx = str.indexOf(sub, idx)) != -1) {
            count++;
            idx += sub.length();
        }
        return count;
    }

    /**
     * Extracts a substring that is nested between two strings.
     * @param str the main string
     * @param open the starting delimiter
     * @param close the ending delimiter
     * @return the content between open and close
     */
    public static String substringBetween(String str, String open, String close) {
        if (str == null || open == null || close == null) return null;
        int start = str.indexOf(open);
        if (start != -1) {
            int end = str.indexOf(close, start + open.length());
            if (end != -1) {
                return str.substring(start + open.length(), end);
            }
        }
        return null;
    }

    /**
     * Reverses a string.
     * @param str the string to reverse
     * @return the reversed string
     */
    public static String reverse(String str) {
        if (str == null) return null;
        return new StringBuilder(str).reverse().toString();
    }

    /**
     * Removes a substring from the beginning of a string if it exists.
     * @param str the main string
     * @param remove the prefix to remove
     * @return the modified string
     */
    public static String removeStart(String str, String remove) {
        if (isEmpty(str) || isEmpty(remove)) return str;
        if (str.startsWith(remove)) {
            return str.substring(remove.length());
        }
        return str;
    }

    /**
     * Repeats a string n times.
     * @param str the string to repeat
     * @param repeat how many times
     * @return the repeated string
     */
    public static String repeat(String str, int repeat) {
        if (str == null || repeat <= 0) return "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < repeat; i++) {
            sb.append(str);
        }
        return sb.toString();
    }

    /**
     * Pads a string with spaces on the left to a total length.
     * @param str the string to pad
     * @param size total desired length
     * @return the left-padded string
     */
    public static String leftPad(String str, int size) {
        if (str == null) return null;
        if (size <= str.length()) return str;
        return repeat(" ", size - str.length()) + str;
    }

    /**
     * Pads a string with spaces on the right to a total length.
     * @param str the string to pad
     * @param size total desired length
     * @return the right-padded string
     */
    public static String rightPad(String str, int size) {
        if (str == null) return null;
        if (size <= str.length()) return str;
        return str + repeat(" ", size - str.length());
    }

    /**
     * Swaps the case of all characters in a string.
     * @param str the string to swap
     * @return string with swapped case
     */
    public static String swapCase(String str) {
        if (isEmpty(str)) return str;
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (Character.isUpperCase(c)) {
                chars[i] = Character.toLowerCase(c);
            } else if (Character.isLowerCase(c)) {
                chars[i] = Character.toUpperCase(c);
            }
        }
        return new String(chars);
    }

    /**
     * Converts a string to camelCase.
     * @param input the string to convert
     * @return the camelCase string
     */
    public static String toCamelCase(String input) {
        if (isEmpty(input)) return "";
        String[] parts = input.toLowerCase().split("[\\s_-]+");
        StringBuilder sb = new StringBuilder(parts[0]);
        for (int i = 1; i < parts.length; i++) {
            sb.append(capitalize(parts[i]));
        }
        return sb.toString();
    }
}
