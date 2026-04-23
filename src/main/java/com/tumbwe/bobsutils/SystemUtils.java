package com.tumbwe.bobsutils;

/**
 * Utilities for interacting with the operating system and environment.
 */
public class SystemUtils {

    /**
     * Gets an environment variable or returns a default value if not found.
     */
    public static String getEnv(String key, String defaultValue) {
        String value = System.getenv(key);
        return StringUtils.isBlank(value) ? defaultValue : value;
    }

    /**
     * Gets a system property or returns a default value.
     */
    public static String getProperty(String key, String defaultValue) {
        String value = System.getProperty(key);
        return StringUtils.isBlank(value) ? defaultValue : value;
    }

    public static boolean isWindows() {
        return getProperty("os.name", "").toLowerCase().contains("win");
    }

    public static boolean isMac() {
        return getProperty("os.name", "").toLowerCase().contains("mac");
    }

    public static boolean isLinux() {
        return getProperty("os.name", "").toLowerCase().contains("nux");
    }

    /**
     * Returns the current working directory.
     */
    public static String getUserDir() {
        return System.getProperty("user.dir");
    }

    /**
     * Returns the home directory of the current user.
     */
    public static String getUserHome() {
        return System.getProperty("user.home");
    }

    /**
     * Returns the system temporary directory.
     */
    public static String getTempDir() {
        return System.getProperty("java.io.tmpdir");
    }
}
