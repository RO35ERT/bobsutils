package com.tumbwe.bobsutils;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class CsvUtilsTest {

    @Test
    void testParse() {
        String csv = "name,age\nBob,30\nAlice,25";
        List<String[]> rows = CsvUtils.parse(csv);
        assertEquals(3, rows.size());
        assertArrayEquals(new String[]{"name", "age"}, rows.get(0));
        assertArrayEquals(new String[]{"Bob", "30"}, rows.get(1));
    }

    @Test
    void testParseWithSeparator() {
        String csv = "name;age\nBob;30";
        List<String[]> rows = CsvUtils.parse(csv, ";");
        assertEquals(2, rows.size());
        assertArrayEquals(new String[]{"name", "age"}, rows.get(0));
    }

    @Test
    void testBuild() {
        List<String[]> rows = new ArrayList<>();
        rows.add(new String[]{"name", "age"});
        rows.add(new String[]{"Bob", "30"});
        
        String csv = CsvUtils.build(rows);
        assertTrue(csv.contains("name,age"));
        assertTrue(csv.contains("Bob,30"));
    }

    @Test
    void testBuildWithEscaping() {
        List<String[]> rows = new ArrayList<>();
        rows.add(new String[]{"name", "notes"});
        rows.add(new String[]{"Bob", "likes \"coding\", coffee"});
        
        String csv = CsvUtils.build(rows);
        assertTrue(csv.contains("\"likes \"\"coding\"\", coffee\""));
    }
}
