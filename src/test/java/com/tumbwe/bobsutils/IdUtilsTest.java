package com.tumbwe.bobsutils;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class IdUtilsTest {

    @Test
    void testUuid() {
        String uuid = IdUtils.uuid();
        assertNotNull(uuid);
        assertEquals(36, uuid.length());
        assertTrue(uuid.contains("-"));
    }

    @Test
    void testShortId() {
        String shortId = IdUtils.shortId();
        assertNotNull(shortId);
        assertEquals(8, shortId.length());
    }
}
