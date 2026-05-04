package com.tumbwe.bobsutils;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QrCodeUtilsTest {

    @Test
    void testGeneratePng() {
        byte[] qr = QrCodeUtils.generatePng("https://example.com", 200);
        assertNotNull(qr);
        assertTrue(qr.length > 0);
    }

    @Test
    void testGenerateBase64() {
        String base64 = QrCodeUtils.generateBase64("Test", 100);
        assertNotNull(base64);
        assertTrue(base64.startsWith("data:image/png;base64,"));
    }

    @Test
    void testGenerateBase64CustomColors() {
        String base64 = QrCodeUtils.generateBase64("Test", 100, "#FF0000", "#FFFFFF");
        assertNotNull(base64);
        assertTrue(base64.startsWith("data:image/png;base64,"));
    }
}
