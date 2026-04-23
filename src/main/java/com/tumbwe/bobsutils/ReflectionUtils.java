package com.tumbwe.bobsutils;

import java.lang.reflect.Field;

/**
 * Utilities for Java Reflection (Accessing private fields/methods).
 */
public class ReflectionUtils {

    /**
     * Safely gets a field value from an object, even if private.
     */
    public static Object getFieldValue(Object obj, String fieldName) {
        try {
            Field field = obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            return field.get(obj);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Safely sets a field value on an object.
     */
    public static boolean setFieldValue(Object obj, String fieldName, Object value) {
        try {
            Field field = obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(obj, value);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
