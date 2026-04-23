package com.tumbwe.bobsutils;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Utilities for working with Collections, Lists, and Sets.
 */
public class CollectionUtils {

    /**
     * Checks if a collection is null or empty.
     */
    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    /**
     * Returns the first element of a list, or a default value if empty.
     */
    public static <T> T firstOrElse(List<T> list, T defaultValue) {
        if (isEmpty(list)) return defaultValue;
        return list.get(0);
    }

    /**
     * Returns the last element of a list, or a default value if empty.
     */
    public static <T> T lastOrElse(List<T> list, T defaultValue) {
        if (isEmpty(list)) return defaultValue;
        return list.get(list.size() - 1);
    }

    /**
     * Returns a new list with elements in random order.
     */
    public static <T> List<T> shuffled(Collection<T> collection) {
        if (collection == null) return Collections.emptyList();
        List<T> list = new ArrayList<>(collection);
        Collections.shuffle(list);
        return list;
    }

    /**
     * Filters a collection to only unique elements based on a key extractor.
     */
    public static <T, K> List<T> distinctBy(Collection<T> collection, Function<? super T, K> keyExtractor) {
        if (isEmpty(collection)) return Collections.emptyList();
        Set<K> seen = ConcurrentHashMap.newKeySet();
        return collection.stream()
                .filter(t -> seen.add(keyExtractor.apply(t)))
                .collect(Collectors.toList());
    }

    /**
     * Safely returns an empty list if the input is null.
     */
    public static <T> List<T> emptyIfNull(List<T> list) {
        return list == null ? Collections.emptyList() : list;
    }

    /**
     * Splits a list into smaller sub-lists of a specified size.
     */
    public static <T> List<List<T>> partition(List<T> list, int size) {
        if (isEmpty(list) || size <= 0) return Collections.emptyList();
        List<List<T>> partitions = new ArrayList<>();
        for (int i = 0; i < list.size(); i += size) {
            partitions.add(list.subList(i, Math.min(i + size, list.size())));
        }
        return partitions;
    }
}

// Minimal ConcurrentHashMap proxy to avoid extra imports if only using core Java
class ConcurrentHashMap {
    public static <K> Set<K> newKeySet() {
        return Collections.newSetFromMap(new java.util.concurrent.ConcurrentHashMap<K, Boolean>());
    }
}
