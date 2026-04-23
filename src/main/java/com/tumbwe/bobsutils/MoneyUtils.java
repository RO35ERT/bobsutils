package com.tumbwe.bobsutils;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Utilities for high-precision financial calculations using BigDecimal.
 */
public class MoneyUtils {

    /**
     * Safely adds two amounts.
     */
    public static BigDecimal add(BigDecimal a, BigDecimal b) {
        if (a == null) return b;
        if (b == null) return a;
        return a.add(b);
    }

    /**
     * Calculates the percentage of an amount.
     */
    public static BigDecimal percentage(BigDecimal amount, double percent) {
        if (amount == null) return BigDecimal.ZERO;
        return amount.multiply(BigDecimal.valueOf(percent))
                     .divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);
    }

    /**
     * Rounds an amount to 2 decimal places.
     */
    public static BigDecimal round(BigDecimal amount) {
        if (amount == null) return BigDecimal.ZERO;
        return amount.setScale(2, RoundingMode.HALF_UP);
    }

    /**
     * Converts a double to BigDecimal safely.
     */
    public static BigDecimal of(double value) {
        return BigDecimal.valueOf(value).setScale(2, RoundingMode.HALF_UP);
    }

    /**
     * Adds tax (e.g., 0.16 for 16%) to an amount.
     */
    public static BigDecimal addTax(BigDecimal amount, double taxRate) {
        if (amount == null) return BigDecimal.ZERO;
        BigDecimal tax = amount.multiply(BigDecimal.valueOf(taxRate));
        return amount.add(tax).setScale(2, RoundingMode.HALF_UP);
    }

    public static BigDecimal subtract(BigDecimal a, BigDecimal b) {
        if (a == null) return b == null ? BigDecimal.ZERO : b.negate();
        if (b == null) return a;
        return a.subtract(b);
    }

    public static BigDecimal multiply(BigDecimal a, BigDecimal b) {
        if (a == null || b == null) return BigDecimal.ZERO;
        return a.multiply(b).setScale(2, RoundingMode.HALF_UP);
    }

    public static BigDecimal divide(BigDecimal a, BigDecimal b) {
        if (a == null || b == null || b.compareTo(BigDecimal.ZERO) == 0) return BigDecimal.ZERO;
        return a.divide(b, 2, RoundingMode.HALF_UP);
    }
}
