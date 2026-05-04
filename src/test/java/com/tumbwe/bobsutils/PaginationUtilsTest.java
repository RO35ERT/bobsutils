package com.tumbwe.bobsutils;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PaginationUtilsTest {

    @Test
    void testGetOffset() {
        assertEquals(0, PaginationUtils.getOffset(1, 10));
        assertEquals(10, PaginationUtils.getOffset(2, 10));
        assertEquals(0, PaginationUtils.getOffset(0, 10));
    }

    @Test
    void testGetTotalPages() {
        assertEquals(5, PaginationUtils.getTotalPages(50, 10));
        assertEquals(6, PaginationUtils.getTotalPages(51, 10));
        assertEquals(1, PaginationUtils.getTotalPages(0, 10));
        assertEquals(1, PaginationUtils.getTotalPages(50, 0));
    }

    @Test
    void testIsFirstPage() {
        assertTrue(PaginationUtils.isFirstPage(1));
        assertTrue(PaginationUtils.isFirstPage(0));
        assertFalse(PaginationUtils.isFirstPage(2));
    }

    @Test
    void testIsLastPage() {
        assertTrue(PaginationUtils.isLastPage(5, 50, 10));
        assertTrue(PaginationUtils.isLastPage(6, 50, 10));
        assertFalse(PaginationUtils.isLastPage(4, 50, 10));
    }

    @Test
    void testGetPageFromOffset() {
        assertEquals(1, PaginationUtils.getPageFromOffset(0, 10));
        assertEquals(2, PaginationUtils.getPageFromOffset(10, 10));
        assertEquals(2, PaginationUtils.getPageFromOffset(15, 10));
        assertEquals(1, PaginationUtils.getPageFromOffset(10, 0));
    }
}
