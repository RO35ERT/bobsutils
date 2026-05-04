package com.tumbwe.bobsutils;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

class MoneyUtilsTest {

    @Test
    void testAdd() {
        assertEquals(new BigDecimal("30.00"), MoneyUtils.add(new BigDecimal("10.00"), new BigDecimal("20.00")));
        assertEquals(new BigDecimal("10.00"), MoneyUtils.add(new BigDecimal("10.00"), null));
    }

    @Test
    void testPercentage() {
        BigDecimal result = MoneyUtils.percentage(new BigDecimal("100.00"), 10.0);
        assertEquals(new BigDecimal("10.00"), result);
    }

    @Test
    void testOf() {
        assertEquals(new BigDecimal("10.50"), MoneyUtils.of(10.5));
    }

    @Test
    void testAddTax() {
        BigDecimal result = MoneyUtils.addTax(new BigDecimal("100.00"), 0.16);
        assertEquals(new BigDecimal("116.00"), result);
    }

    @Test
    void testOperations() {
        BigDecimal a = new BigDecimal("100.00");
        BigDecimal b = new BigDecimal("50.00");
        
        assertEquals(new BigDecimal("50.00"), MoneyUtils.subtract(a, b));
        assertEquals(new BigDecimal("5000.00"), MoneyUtils.multiply(a, b));
        assertEquals(new BigDecimal("2.00"), MoneyUtils.divide(a, b));
        assertEquals(BigDecimal.ZERO, MoneyUtils.divide(a, BigDecimal.ZERO));
    }
}
