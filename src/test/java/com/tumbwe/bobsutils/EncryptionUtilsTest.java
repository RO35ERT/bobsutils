package com.tumbwe.bobsutils;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EncryptionUtilsTest {

    private static final String SECRET_KEY = "1234567890123456"; // 16 chars for AES

    @Test
    void testEncryptDecrypt() {
        String original = "This is a secret message!";
        String encrypted = EncryptionUtils.encrypt(original, SECRET_KEY);
        assertNotEquals(original, encrypted);
        
        String decrypted = EncryptionUtils.decrypt(encrypted, SECRET_KEY);
        assertEquals(original, decrypted);
    }

    @Test
    void testInvalidKey() {
        assertThrows(RuntimeException.class, () -> EncryptionUtils.encrypt("test", "short"));
    }
}
