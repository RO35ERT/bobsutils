package com.tumbwe.bobsutils;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EmailUtilsTest {

    @Test
    void testSendBrevoFailure() {
        // Should return false due to invalid API key and network call failure
        boolean result = EmailUtils.sendBrevo("invalid_key", "from@example.com", "to@example.com", "Subject", "Body");
        assertFalse(result);
    }

    @Test
    void testSendMailgunFailure() {
        boolean result = EmailUtils.sendMailgun("invalid_key", "example.com", "from@example.com", "to@example.com", "Subject", "Body");
        assertFalse(result);
    }
    
    @Test
    void testSendSendGridFailure() {
        boolean result = EmailUtils.sendSendGrid("invalid_key", "from@example.com", "to@example.com", "Subject", "Body");
        assertFalse(result);
    }

    @Test
    void testSendSparkPostFailure() {
        boolean result = EmailUtils.sendSparkPost("invalid_key", "from@example.com", "to@example.com", "Subject", "Body");
        assertFalse(result);
    }
}
