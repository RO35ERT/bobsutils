package com.tumbwe.bobsutils;

/**
 * A simple utility for measuring elapsed time.
 */
public class StopWatch {
    private long startTime;
    private long endTime;
    private boolean running;

    public void start() {
        this.startTime = System.currentTimeMillis();
        this.running = true;
    }

    public void stop() {
        this.endTime = System.currentTimeMillis();
        this.running = false;
    }

    public void reset() {
        this.startTime = 0;
        this.endTime = 0;
        this.running = false;
    }

    /**
     * Returns the elapsed time in milliseconds.
     */
    public long getElapsedTime() {
        if (running) {
            return System.currentTimeMillis() - startTime;
        }
        return endTime - startTime;
    }

    /**
     * Returns a formatted execution string (e.g., "Execution took 1250ms").
     */
    public String getFormattedResult() {
        return "Execution took " + getElapsedTime() + "ms";
    }

    /**
     * Helper to time a Runnable task.
     */
    public static long time(Runnable task) {
        long start = System.currentTimeMillis();
        task.run();
        return System.currentTimeMillis() - start;
    }
}
