package com.tumbwe.bobsutils;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Scanner;

/**
 * Utilities for reading resources from the Classpath (src/main/resources).
 */
public class ResourceUtils {

    /**
     * Reads a resource file as a String.
     */
    public static String readResource(String path) {
        try (InputStream is = ResourceUtils.class.getClassLoader().getResourceAsStream(path)) {
            if (is == null) return null;
            // Use legacy scanner constructor for maximum compatibility
            try (Scanner scanner = new Scanner(is, "UTF-8").useDelimiter("\\A")) {
                return scanner.hasNext() ? scanner.next() : "";
            }
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Reads a resource file as a byte array (Java 8 compatible).
     */
    public static byte[] readResourceAsBytes(String path) {
        try (InputStream is = ResourceUtils.class.getClassLoader().getResourceAsStream(path)) {
            if (is == null) return null;
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            int nRead;
            byte[] data = new byte[16384];
            while ((nRead = is.read(data, 0, data.length)) != -1) {
                buffer.write(data, 0, nRead);
            }
            return buffer.toByteArray();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Checks if a resource exists in the classpath.
     */
    public static boolean exists(String path) {
        return ResourceUtils.class.getClassLoader().getResource(path) != null;
    }
}
