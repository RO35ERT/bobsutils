package com.tumbwe.bobsutils;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ReflectionUtilsTest {

    static class TestClass {
        private String secret = "hidden";
    }

    @Test
    void testGetFieldValue() {
        TestClass obj = new TestClass();
        assertEquals("hidden", ReflectionUtils.getFieldValue(obj, "secret"));
        assertNull(ReflectionUtils.getFieldValue(obj, "nonexistent"));
    }

    @Test
    void testSetFieldValue() {
        TestClass obj = new TestClass();
        boolean success = ReflectionUtils.setFieldValue(obj, "secret", "updated");
        assertTrue(success);
        assertEquals("updated", ReflectionUtils.getFieldValue(obj, "secret"));
    }
}
