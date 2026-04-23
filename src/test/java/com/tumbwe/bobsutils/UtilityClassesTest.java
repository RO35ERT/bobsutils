package com.tumbwe.bobsutils;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UtilityClassesTest {

    @Test
    void testStringUtils() {
        assertTrue(StringUtils.isBlank(" "));
        assertEquals("Bob", StringUtils.capitalize("bOB"));
        assertEquals("hello-world", StringUtils.slugify("Hello World!"));
        assertEquals("b***@example.com", StringUtils.mask("bob@example.com"));
        assertEquals("He...", StringUtils.truncate("HelloWorld", 5));
        assertEquals(10, StringUtils.randomAlphanumeric(10).length());
    }

    @Test
    void testIsStrongPassword() {
        assertTrue(ValidationUtils.isStrongPassword("Pass1234"));
        assertFalse(ValidationUtils.isStrongPassword("pass1234")); // No upper
        assertTrue(ValidationUtils.isStrongPassword("P@ss1", 5, true, true)); // Short but strong with symbols
        assertFalse(ValidationUtils.isStrongPassword("Pass1", 5, true, true)); // No symbol
    }

    @Test
    void testNumberUtils() {
        assertEquals(10, NumberUtils.parseInteger(" 10 "));
        assertEquals(100L, NumberUtils.parseLong("100"));
        assertEquals(10.5, NumberUtils.parseDouble("10.5"));
        assertEquals(5, NumberUtils.toInt("invalid", 5));
        assertEquals(10, NumberUtils.clamp(15, 0, 10));
        assertEquals("1,234.50", NumberUtils.formatCurrency(1234.5));
        assertEquals(50.0, NumberUtils.percentage(5, 10));
        assertEquals("21st", NumberUtils.toOrdinal(21));
        assertEquals("22nd", NumberUtils.toOrdinal(22));
        assertEquals("0001", NumberUtils.padLeft(1, 4));
        assertEquals("$1,234.50", NumberUtils.formatCurrency(1234.5, "$"));
        assertEquals("1.000.000", NumberUtils.formatCustom(1000000, 0, '.', ','));
        assertEquals("X", NumberUtils.toRoman(10));
    }

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
