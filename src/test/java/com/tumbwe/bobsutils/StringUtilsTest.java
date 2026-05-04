package com.tumbwe.bobsutils;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

    @Test
    void testBasicUtils() {
        assertTrue(StringUtils.isBlank(" "));
        assertEquals("Bob", StringUtils.capitalize("bOB"));
        assertEquals("hello-world", StringUtils.slugify("Hello World!"));
        assertEquals("b***@example.com", StringUtils.mask("bob@example.com"));
        assertEquals("He...", StringUtils.truncate("HelloWorld", 5));
        assertEquals(10, StringUtils.randomAlphanumeric(10).length());
    }

    @Test
    void testToSnakeCase() {
        assertEquals("camel_case", StringUtils.toSnakeCase("camelCase"));
        assertEquals("camel_case", StringUtils.toSnakeCase("CamelCase"));
        assertEquals("some_text_with_spaces", StringUtils.toSnakeCase("some text with spaces"));
    }

    @Test
    void testToggleCase() {
        assertEquals("HeLlO", StringUtils.toggleCase("hElLo"));
    }
}
