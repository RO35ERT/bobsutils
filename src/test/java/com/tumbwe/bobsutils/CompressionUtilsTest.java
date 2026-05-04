package com.tumbwe.bobsutils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import static org.junit.jupiter.api.Assertions.*;

class CompressionUtilsTest {

    @Test
    void testZipAndUnzip(@TempDir Path tempDir) throws IOException {
        Path sourceFile = tempDir.resolve("test.txt");
        String content = "Zip me up!";
        Files.write(sourceFile, content.getBytes());
        
        Path zipFile = tempDir.resolve("test.zip");
        CompressionUtils.zip(sourceFile.toString(), zipFile.toString());
        assertTrue(Files.exists(zipFile));
        
        Path destDir = tempDir.resolve("extracted");
        CompressionUtils.unzip(zipFile.toString(), destDir.toString());
        
        Path extractedFile = destDir.resolve("test.txt");
        assertTrue(Files.exists(extractedFile));
        assertEquals(content, new String(Files.readAllBytes(extractedFile)));
    }
}
