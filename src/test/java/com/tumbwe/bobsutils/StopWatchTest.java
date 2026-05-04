package com.tumbwe.bobsutils;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StopWatchTest {
    @Test
    void testStopWatch() throws Exception {
        StopWatch sw = new StopWatch();
        sw.start();
        Thread.sleep(10);
        sw.stop();
        assertTrue(sw.getElapsedTime() >= 10);
    }
}
