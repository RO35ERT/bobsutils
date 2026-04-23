package com.tumbwe.bobsutils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

/**
 * Utilities for file system operations.
 */
public class FileUtils {

    /**
     * Gets the extension of a file (e.g. "txt", "pdf").
     */
    public static String getExtension(String filename) {
        if (StringUtils.isBlank(filename) || !filename.contains(".")) return "";
        return filename.substring(filename.lastIndexOf(".") + 1).toLowerCase();
    }

    /**
     * Reads a file's content as a UTF-8 string.
     */
    public static String readString(String path) throws IOException {
        return new String(Files.readAllBytes(Paths.get(path)), StandardCharsets.UTF_8);
    }

    /**
     * Writes a string to a file as UTF-8.
     */
    public static void writeString(String path, String content) throws IOException {
        Path p = Paths.get(path);
        if (p.getParent() != null) {
            Files.createDirectories(p.getParent());
        }
        Files.write(p, content.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * Converts a size in bytes to a human-readable format (e.g. 1.2 MB).
     */
    public static String humanReadableSize(long bytes) {
        if (-1000 < bytes && bytes < 1000) return bytes + " B";
        CharacterIterator ci = new StringCharacterIterator("kMGTPE");
        while (bytes <= -999_950 || bytes >= 999_950) {
            bytes /= 1000;
            ci.next();
        }
        return String.format("%.1f %cB", bytes / 1000.0, ci.current());
    }

    /**
     * Checks if a file exists.
     */
    public static boolean exists(String path) {
        if (StringUtils.isBlank(path)) return false;
        return Files.exists(Paths.get(path));
    }
}
