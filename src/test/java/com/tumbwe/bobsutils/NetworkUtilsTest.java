package com.tumbwe.bobsutils;

import org.junit.jupiter.api.Test;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

class NetworkUtilsTest {

    @Test
    void testIsReachable() {
        // We expect this to fail quickly without a real network or with a fake URL
        assertFalse(NetworkUtils.isReachable("http://invalid.url.xyz.123", 100));
    }

    @Test
    void testGetQueryParams() {
        String url = "https://example.com/search?q=junit&lang=en&flag";
        Map<String, String> params = NetworkUtils.getQueryParams(url);
        
        assertEquals("junit", params.get("q"));
        assertEquals("en", params.get("lang"));
        assertEquals("", params.get("flag"));
        assertEquals(3, params.size());
    }
}
