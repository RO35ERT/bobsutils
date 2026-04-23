package com.tumbwe.bobsutils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Utilities for mapping objects between classes (e.g., entity to DTO).
 */
public class MappingUtils {

    private static final Logger log = LoggerFactory.getLogger(MappingUtils.class);
    private static final ObjectMapper MAPPER = JsonUtils.getMapper();

    /**
     * Maps an object to another class.
     * Useful for converting between Entities and DTOs.
     *
     * @param from  The source object.
     * @param toClass The class to map to.
     * @param <T>    The destination type.
     * @return The mapped object, or null if mapping fails.
     */
    public static <T> T map(Object from, Class<T> toClass) {
        if (from == null) return null;
        try {
            return MAPPER.convertValue(from, toClass);
        } catch (Exception e) {
            log.error("Error mapping {} to {}: {}", 
                from.getClass().getSimpleName(), 
                toClass.getSimpleName(), 
                e.getMessage(), 
                e);
            return null;
        }
    }

    /**
     * Maps an object to a Response DTO.
     */
    public static <T> T toResponse(Object from, Class<T> responseClass) {
        return map(from, responseClass);
    }

    /**
     * Maps an object to a Domain Model.
     */
    public static <T> T toModel(Object from, Class<T> modelClass) {
        return map(from, modelClass);
    }

    /**
     * Maps an object to a target class and then converts it to a JSON string.
     */
    public static <T> String toJson(Object from, Class<T> toClass) {
        T mapped = map(from, toClass);
        return JsonUtils.toJson(mapped);
    }

    /**
     * Maps a list of objects to a list of the target class.
     */
    public static <T> java.util.List<T> mapList(java.util.Collection<?> from, Class<T> toClass) {
        if (from == null) return java.util.Collections.emptyList();
        return from.stream()
                .map(item -> map(item, toClass))
                .filter(java.util.Objects::nonNull)
                .collect(java.util.stream.Collectors.toList());
    }
}
