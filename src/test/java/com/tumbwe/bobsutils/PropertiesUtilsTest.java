package com.tumbwe.bobsutils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

class PropertiesUtilsTest {

    @Test
    void testSaveAndLoad(@TempDir Path tempDir) {
        Path propFile = tempDir.resolve("config.properties");
        Map<String, String> data = new HashMap<>();
        data.put("app.name", "BobsUtils");
        data.put("app.version", "1.0");
        
        PropertiesUtils.save(propFile.toString(), data, "Test Config");
        assertTrue(FileUtils.exists(propFile.toString()));
        
        Map<String, String> loadedData = PropertiesUtils.load(propFile.toString());
        assertEquals("BobsUtils", loadedData.get("app.name"));
        assertEquals("1.0", loadedData.get("app.version"));
    }
}
