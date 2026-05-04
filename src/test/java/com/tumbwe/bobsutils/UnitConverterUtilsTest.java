package com.tumbwe.bobsutils;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UnitConverterUtilsTest {

    @Test
    void testTemperature() {
        assertEquals(32, UnitConverterUtils.celsiusToFahrenheit(0));
        assertEquals(100, UnitConverterUtils.celsiusToFahrenheit(37.7778), 0.001);
        assertEquals(0, UnitConverterUtils.fahrenheitToCelsius(32));
    }

    @Test
    void testWeight() {
        assertEquals(2.20462, UnitConverterUtils.kgToLbs(1.0), 0.001);
        assertEquals(1.0, UnitConverterUtils.lbsToKg(2.20462), 0.001);
    }

    @Test
    void testDistance() {
        assertEquals(3.28084, UnitConverterUtils.metersToFeet(1.0), 0.001);
        assertEquals(1.0, UnitConverterUtils.feetToMeters(3.28084), 0.001);
    }

    @Test
    void testVolume() {
        assertEquals(0.264172, UnitConverterUtils.litersToGallons(1.0), 0.001);
        assertEquals(1.0, UnitConverterUtils.gallonsToLiters(0.264172), 0.001);
    }
}
