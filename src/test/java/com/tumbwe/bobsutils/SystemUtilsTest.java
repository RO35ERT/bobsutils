package com.tumbwe.bobsutils;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SystemUtilsTest {

    @Test
    void testGetEnv() {
        assertNotNull(SystemUtils.getEnv("PATH", "default"));
        assertEquals("default", SystemUtils.getEnv("NON_EXISTENT_VAR_XYZ", "default"));
    }

    @Test
    void testGetProperty() {
        assertNotNull(SystemUtils.getProperty("os.name", "default"));
        assertEquals("default", SystemUtils.getProperty("non.existent.prop", "default"));
    }

    @Test
    void testOsChecks() {
        // At least one should be true on common CI/dev environments
        assertTrue(SystemUtils.isWindows() || SystemUtils.isMac() || SystemUtils.isLinux());
    }

    @Test
    void testDirs() {
        assertNotNull(SystemUtils.getUserDir());
        assertNotNull(SystemUtils.getUserHome());
        assertNotNull(SystemUtils.getTempDir());
    }
}
