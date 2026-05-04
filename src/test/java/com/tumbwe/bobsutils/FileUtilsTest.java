package com.tumbwe.bobsutils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.io.IOException;
import java.nio.file.Path;
import static org.junit.jupiter.api.Assertions.*;

class FileUtilsTest {

    @Test
    void testGetExtension() {
        assertEquals("txt", FileUtils.getExtension("test.txt"));
        assertEquals("pdf", FileUtils.getExtension("document.PDF"));
        assertEquals("", FileUtils.getExtension("noextension"));
        assertEquals("", FileUtils.getExtension(null));
    }

    @Test
    void testReadAndWriteString(@TempDir Path tempDir) throws IOException {
        Path file = tempDir.resolve("test.txt");
        String content = "Hello, World!";
        
        FileUtils.writeString(file.toString(), content);
        assertTrue(FileUtils.exists(file.toString()));
        assertEquals(content, FileUtils.readString(file.toString()));
    }

    @Test
    void testHumanReadableSize() {
        assertEquals("500 B", FileUtils.humanReadableSize(500));
        assertEquals("1.0 kB", FileUtils.humanReadableSize(1000));
        assertEquals("1.0 MB", FileUtils.humanReadableSize(1_000_000));
        assertEquals("1.5 GB", FileUtils.humanReadableSize(1_500_000_000));
    }

    @Test
    void testExists() {
        assertFalse(FileUtils.exists(null));
        assertFalse(FileUtils.exists("non_existent_file_xyz_123"));
    }
}
