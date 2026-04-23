package com.tumbwe.bobsutils;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PhoneUtilsTest {

    @Test
    void testNormalizeZambian() {
        assertEquals("260971234567", PhoneUtils.normalizeZambian("0971234567"));
        assertEquals("260971234567", PhoneUtils.normalizeZambian("+260 971 234567"));
        assertEquals("260971234567", PhoneUtils.normalizeZambian("971234567"));
    }

    @Test
    void testIsValidZambian() {
        assertTrue(PhoneUtils.isValidZambian("0971234567")); // Airtel
        assertTrue(PhoneUtils.isValidZambian("0581234567")); // ZED Mobile
        assertTrue(PhoneUtils.isValidZambian("260551234567")); // Zamtel
        assertFalse(PhoneUtils.isValidZambian("0941234567")); // Invalid prefix
        assertFalse(PhoneUtils.isValidZambian("12345"));     // Too short
    }

    @Test
    void testGetNetwork() {
        assertEquals("AIRTEL", PhoneUtils.getZambianNetwork("0971111111"));
        assertEquals("MTN", PhoneUtils.getZambianNetwork("0561111111"));
        assertEquals("ZED MOBILE", PhoneUtils.getZambianNetwork("0981111111"));
        assertEquals("ZAMTEL", PhoneUtils.getZambianNetwork("0551111111"));
    }

    @Test
    void testFormatDisplay() {
        assertEquals("+260 97 1234567", PhoneUtils.formatDisplay("0971234567"));
    }
}
