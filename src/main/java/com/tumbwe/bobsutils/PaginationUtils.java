package com.tumbwe.bobsutils;

/**
 * Utilities for API pagination logic.
 */
public class PaginationUtils {

    /**
     * Calculates the offset for a database query.
     */
    public static int getOffset(int page, int size) {
        return Math.max(0, (page - 1) * size);
    }

    /**
     * Calculates the total number of pages.
     */
    public static int getTotalPages(long totalRecords, int size) {
        if (size <= 0) return 1;
        return (int) Math.ceil((double) totalRecords / size);
    }

    public static boolean isFirstPage(int page) {
        return page <= 1;
    }

    public static boolean isLastPage(int page, long totalRecords, int size) {
        return page >= getTotalPages(totalRecords, size);
    }

    /**
     * Calculates the page number based on a given offset and page size.
     */
    public static int getPageFromOffset(int offset, int size) {
        if (size <= 0) return 1;
        return (offset / size) + 1;
    }
}
