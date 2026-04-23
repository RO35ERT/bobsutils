package com.tumbwe.bobsutils;

/**
 * Utilities for common physical and measurement unit conversions.
 */
public class UnitConverterUtils {

    // Temperature
    public static double celsiusToFahrenheit(double c) {
        return (c * 9 / 5) + 32;
    }

    public static double fahrenheitToCelsius(double f) {
        return (f - 32) * 5 / 9;
    }

    // Weight
    public static double kgToLbs(double kg) {
        return kg * 2.20462;
    }

    public static double lbsToKg(double lbs) {
        return lbs / 2.20462;
    }

    // Distance
    public static double metersToFeet(double m) {
        return m * 3.28084;
    }

    public static double feetToMeters(double ft) {
        return ft / 3.28084;
    }

    // Volume
    public static double litersToGallons(double l) {
        return l * 0.264172;
    }

    public static double gallonsToLiters(double gal) {
        return gal / 0.264172;
    }
}
