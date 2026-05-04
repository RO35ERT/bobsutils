package com.tumbwe.bobsutils;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NumberUtilsTest {

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
}
