package com.tumbwe.bobsutils;

import org.jsoup.Jsoup;
import org.jsoup.safety.Safelist;

/**
 * Utilities for sanitizing and cleaning user input to prevent XSS, SQL injection, and path traversal.
 */
public class SanitizationUtils {

    /**
     * Removes all HTML tags from a string.
     */
    public static String stripHtml(String input) {
        if (StringUtils.isBlank(input)) return "";
        return Jsoup.clean(input, Safelist.none());
    }

    /**
     * Sanitizes HTML, allowing only a safe subset of tags (links, formatting).
     */
    public static String sanitizeHtml(String input) {
        if (StringUtils.isBlank(input)) return "";
        return Jsoup.clean(input, Safelist.basic());
    }

    /**
     * Prevents basic SQL injection characters by escaping or removing them.
     * Note: Always use PreparedStatements for real database queries.
     */
    public static String sanitizeSqlInput(String input) {
        if (StringUtils.isBlank(input)) return "";
        return input.replaceAll("['\"\\\\;\\-\\-]", "");
    }

    /**
     * Sanitizes a filename by removing illegal characters.
     */
    public static String sanitizeFilename(String filename) {
        if (StringUtils.isBlank(filename)) return "file_" + System.currentTimeMillis();
        return filename.replaceAll("[\\\\/:*?\"<>|]", "_");
    }

    /**
     * Normalizes whitespace by replacing multiple spaces/tabs/newlines with a single space.
     */
    public static String normalizeWhitespace(String input) {
        if (StringUtils.isBlank(input)) return "";
        return input.trim().replaceAll("\\s+", " ");
    }

    /**
     * Strips all non-alphanumeric characters.
     */
    public static String stripNonAlphanumeric(String input) {
        if (StringUtils.isBlank(input)) return "";
        return input.replaceAll("[^a-zA-Z0-9]", "");
    }

    /**
     * Sanitizes a search query by removing special symbols that might break search logic.
     */
    public static String sanitizeSearchQuery(String query) {
        if (StringUtils.isBlank(query)) return "";
        return query.replaceAll("[\\+\\-\\&\\|\\!\\(\\)\\{\\}\\[\\]\\^\\\"\\~\\*\\?\\:\\\\\\/]", " ")
                    .replaceAll("\\s+", " ").trim();
    }
}
