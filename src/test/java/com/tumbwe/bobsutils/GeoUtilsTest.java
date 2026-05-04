package com.tumbwe.bobsutils;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GeoUtilsTest {

    @Test
    void testCalculateDistance() {
        // Distance between London (51.5074, -0.1278) and Paris (48.8566, 2.3522) is ~344km
        double dist = GeoUtils.calculateDistance(51.5074, -0.1278, 48.8566, 2.3522);
        assertTrue(dist > 340 && dist < 350);
    }

    @Test
    void testToMiles() {
        assertEquals(0.621371, GeoUtils.toMiles(1.0), 0.0001);
    }

    @Test
    void testIsWithinRadius() {
        // Within 400km? Yes.
        assertTrue(GeoUtils.isWithinRadius(51.5074, -0.1278, 48.8566, 2.3522, 400.0));
        // Within 100km? No.
        assertFalse(GeoUtils.isWithinRadius(51.5074, -0.1278, 48.8566, 2.3522, 100.0));
    }
}
