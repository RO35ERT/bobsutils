package com.tumbwe.bobsutils;

import java.util.function.Supplier;

/**
 * Utilities for retrying failed operations with backoff.
 */
public class RetryUtils {

    /**
     * Retries a supplier N times until it succeeds or runs out of attempts.
     */
    public static <T> T retry(Supplier<T> action, int maxAttempts, long sleepMs) {
        int attempts = 0;
        Exception lastException = null;
        
        while (attempts < maxAttempts) {
            try {
                return action.get();
            } catch (Exception e) {
                attempts++;
                lastException = e;
                if (attempts < maxAttempts) {
                    try { Thread.sleep(sleepMs); } catch (InterruptedException ignored) {}
                }
            }
        }
        throw new RuntimeException("Action failed after " + maxAttempts + " attempts", lastException);
    }
}
