package com.tumbwe.bobsutils;

import org.junit.jupiter.api.Test;
import java.util.concurrent.atomic.AtomicInteger;
import static org.junit.jupiter.api.Assertions.*;

class RetryUtilsTest {

    @Test
    void testRetrySuccess() {
        String result = RetryUtils.retry(() -> "success", 3, 10);
        assertEquals("success", result);
    }

    @Test
    void testRetryAfterFailures() {
        AtomicInteger count = new AtomicInteger(0);
        String result = RetryUtils.retry(() -> {
            if (count.incrementAndGet() < 3) throw new RuntimeException("fail");
            return "eventual success";
        }, 5, 10);
        
        assertEquals(3, count.get());
        assertEquals("eventual success", result);
    }

    @Test
    void testRetryFailure() {
        assertThrows(RuntimeException.class, () -> {
            RetryUtils.retry(() -> {
                throw new RuntimeException("constant fail");
            }, 3, 10);
        });
    }
}
