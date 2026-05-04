package com.tumbwe.bobsutils;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserAgentUtilsTest {

    @Test
    void testIsMobile() {
        assertTrue(UserAgentUtils.isMobile("Mozilla/5.0 (iPhone; CPU iPhone OS 14_7_1 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/14.1.2 Mobile/15E148 Safari/604.1"));
        assertFalse(UserAgentUtils.isMobile("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.159 Safari/537.36"));
    }

    @Test
    void testIsTablet() {
        assertTrue(UserAgentUtils.isTablet("Mozilla/5.0 (iPad; CPU OS 12_2 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/12.1 Mobile/15E148 Safari/604.1"));
    }

    @Test
    void testGetBrowserType() {
        assertEquals("CHROME", UserAgentUtils.getBrowserType("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.159 Safari/537.36"));
        assertEquals("FIREFOX", UserAgentUtils.getBrowserType("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:91.0) Gecko/20100101 Firefox/91.0"));
    }

    @Test
    void testIsBot() {
        assertTrue(UserAgentUtils.isBot("Mozilla/5.0 (compatible; Googlebot/2.1; +http://www.google.com/bot.html)"));
        assertFalse(UserAgentUtils.isBot("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebkit/537.36"));
    }
}
