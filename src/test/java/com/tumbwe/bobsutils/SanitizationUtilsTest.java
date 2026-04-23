package com.tumbwe.bobsutils;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SanitizationUtilsTest {

    @Test
    void testStripHtml() {
        String input = "<p>Hello <b>World</b></p>";
        assertEquals("Hello World", SanitizationUtils.stripHtml(input));
    }

    @Test
    void testSanitizeSqlInput() {
        String input = "SELECT * FROM users WHERE name = 'admin' --";
        String sanitized = SanitizationUtils.sanitizeSqlInput(input);
        assertFalse(sanitized.contains("'"));
        assertFalse(sanitized.contains("--"));
    }

    @Test
    void testSanitizeFilename() {
        String badFile = "my/file?name<.txt";
        assertEquals("my_file_name_.txt", SanitizationUtils.sanitizeFilename(badFile));
    }

    @Test
    void testNormalizeWhitespace() {
        String messy = "  Hello \n  \t World  ";
        assertEquals("Hello World", SanitizationUtils.normalizeWhitespace(messy));
    }
}
