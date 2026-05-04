package com.tumbwe.bobsutils;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ResourceUtilsTest {

    @Test
    void testReadResource() {
        // test_resource.txt should be in the classpath during tests
        String content = ResourceUtils.readResource("test_resource.txt");
        assertNotNull(content);
        assertTrue(content.contains("resource content"));
    }

    @Test
    void testReadResourceAsBytes() {
        byte[] bytes = ResourceUtils.readResourceAsBytes("test_resource.txt");
        assertNotNull(bytes);
        assertTrue(bytes.length > 0);
    }

    @Test
    void testExists() {
        assertTrue(ResourceUtils.exists("test_resource.txt"));
        assertFalse(ResourceUtils.exists("ghost.txt"));
    }
}
