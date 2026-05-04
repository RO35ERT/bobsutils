package com.tumbwe.bobsutils;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DateUtilsTest {

    @Test
    void testDateUtils() {
        java.time.LocalDateTime date = java.time.LocalDateTime.of(2024, 1, 1, 10, 0);
        assertEquals("01/01/2024", DateUtils.toDayMonthYear(date));
        assertEquals("Jan 1, 2024", DateUtils.toFriendlyDate(date));
        assertTrue(DateUtils.toWeekDayMonthYear(date).contains("Monday"));
        assertEquals("20240101", DateUtils.format(date, DateUtils.COMPACT_DATE));

        // String auto-parsing
        assertEquals("01/01/2024", DateUtils.toDayMonthYear("2024-01-01"));
        
        // JS style ISO with 'T' and 'Z'
        String jsDate = "2024-01-01T10:00:00.000Z";
        assertEquals("Jan 1, 2024", DateUtils.toFriendlyDate(jsDate));
        
        // Custom now format
        assertNotNull(DateUtils.now(DateUtils.DAY_MONTH_YEAR));
    }
}
