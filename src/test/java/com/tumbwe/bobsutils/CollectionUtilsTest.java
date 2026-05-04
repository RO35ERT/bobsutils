package com.tumbwe.bobsutils;

import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class CollectionUtilsTest {

    @Test
    void testIsEmpty() {
        assertTrue(CollectionUtils.isEmpty(null));
        assertTrue(CollectionUtils.isEmpty(Collections.emptyList()));
        assertFalse(CollectionUtils.isEmpty(List.of("item")));
    }

    @Test
    void testFirstOrElse() {
        List<String> list = Arrays.asList("a", "b", "c");
        assertEquals("a", CollectionUtils.firstOrElse(list, "default"));
        assertEquals("default", CollectionUtils.firstOrElse(null, "default"));
        assertEquals("default", CollectionUtils.firstOrElse(Collections.emptyList(), "default"));
    }

    @Test
    void testLastOrElse() {
        List<String> list = Arrays.asList("a", "b", "c");
        assertEquals("c", CollectionUtils.lastOrElse(list, "default"));
        assertEquals("default", CollectionUtils.lastOrElse(null, "default"));
        assertEquals("default", CollectionUtils.lastOrElse(Collections.emptyList(), "default"));
    }

    @Test
    void testShuffled() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> shuffled = CollectionUtils.shuffled(list);
        assertEquals(list.size(), shuffled.size());
        assertTrue(shuffled.containsAll(list));
        // Note: Theoretically shuffled could be identical to list, but highly unlikely for 10 items.
        assertNotNull(CollectionUtils.shuffled(null));
        assertTrue(CollectionUtils.shuffled(null).isEmpty());
    }

    @Test
    void testDistinctBy() {
        List<String> list = Arrays.asList("apple", "apricot", "banana", "blueberry", "cherry");
        // Distinct by first letter
        List<String> distinct = CollectionUtils.distinctBy(list, s -> s.charAt(0));
        assertEquals(3, distinct.size());
        assertTrue(distinct.contains("apple"));
        assertTrue(distinct.contains("banana"));
        assertTrue(distinct.contains("cherry"));
    }

    @Test
    void testEmptyIfNull() {
        List<String> list = List.of("a");
        assertSame(list, CollectionUtils.emptyIfNull(list));
        assertNotNull(CollectionUtils.emptyIfNull(null));
        assertTrue(CollectionUtils.emptyIfNull(null).isEmpty());
    }

    @Test
    void testPartition() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        List<List<Integer>> partitions = CollectionUtils.partition(list, 2);
        assertEquals(3, partitions.size());
        assertEquals(Arrays.asList(1, 2), partitions.get(0));
        assertEquals(Arrays.asList(3, 4), partitions.get(1));
        assertEquals(List.of(5), partitions.get(2));

        assertTrue(CollectionUtils.partition(null, 2).isEmpty());
        assertTrue(CollectionUtils.partition(list, 0).isEmpty());
    }
}
