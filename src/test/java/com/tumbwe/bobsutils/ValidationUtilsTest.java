package com.tumbwe.bobsutils;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ValidationUtilsTest {

    @Test
    void testIsStrongPassword() {
        assertTrue(ValidationUtils.isStrongPassword("Pass1234"));
        assertFalse(ValidationUtils.isStrongPassword("pass1234")); // No upper
        assertTrue(ValidationUtils.isStrongPassword("P@ss1", 5, true, true)); // Short but strong with symbols
        assertFalse(ValidationUtils.isStrongPassword("Pass1", 5, true, true)); // No symbol
    }
}
