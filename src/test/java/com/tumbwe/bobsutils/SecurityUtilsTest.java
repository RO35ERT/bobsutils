package com.tumbwe.bobsutils;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SecurityUtilsTest {

    @Test
    void testSha256() {
        String input = "password123";
        String hash = SecurityUtils.sha256(input);
        assertNotNull(hash);
        assertEquals(64, hash.length());
        assertEquals(hash, SecurityUtils.sha256(input)); // Consistent
    }

    @Test
    void testMd5() {
        String input = "hello";
        String hash = SecurityUtils.md5(input);
        assertNotNull(hash);
        assertEquals(32, hash.length());
        assertEquals("5d41402abc4b2a76b9719d911017c592", hash);
    }

    @Test
    void testBase64Encoding() {
        String original = "Hello World";
        String encoded = SecurityUtils.base64Encode(original);
        assertEquals("SGVsbG8gV29ybGQ=", encoded);
        assertEquals(original, SecurityUtils.base64Decode(encoded));
    }

    @Test
    void testGenerateRandomToken() {
        String token = SecurityUtils.generateRandomToken(16);
        assertEquals(16, token.length());
        assertNotEquals(token, SecurityUtils.generateRandomToken(16)); // Random
    }
}
