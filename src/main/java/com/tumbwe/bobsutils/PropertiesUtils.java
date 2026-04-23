package com.tumbwe.bobsutils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Utilities for loading and saving .properties files.
 */
public class PropertiesUtils {

    /**
     * Loads a properties file into a Map.
     */
    public static Map<String, String> load(String path) {
        Map<String, String> map = new HashMap<>();
        try (FileInputStream fis = new FileInputStream(path)) {
            Properties props = new Properties();
            props.load(fis);
            for (String key : props.stringPropertyNames()) {
                map.put(key, props.getProperty(key));
            }
        } catch (Exception ignored) {}
        return map;
    }

    /**
     * Saves a Map into a properties file.
     */
    public static void save(String path, Map<String, String> data, String comments) {
        Properties props = new Properties();
        data.forEach(props::setProperty);
        try (FileOutputStream fos = new FileOutputStream(path)) {
            props.store(fos, comments);
        } catch (Exception ignored) {}
    }
}
