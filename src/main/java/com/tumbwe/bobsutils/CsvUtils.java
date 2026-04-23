package com.tumbwe.bobsutils;

import java.util.ArrayList;
import java.util.List;

/**
 * Lightweight utilities for parsing and generating CSV data.
 */
public class CsvUtils {

    /**
     * Parses a simple CSV string into a List of String arrays.
     */
    public static List<String[]> parse(String csv, String separator) {
        List<String[]> rows = new ArrayList<>();
        if (StringUtils.isBlank(csv)) return rows;

        String[] lines = csv.split("\\r?\\n");
        for (String line : lines) {
            if (StringUtils.isBlank(line)) continue;
            rows.add(line.split(separator, -1));
        }
        return rows;
    }

    public static List<String[]> parse(String csv) {
        return parse(csv, ",");
    }

    /**
     * Converts a List of String arrays into a CSV string.
     */
    public static String build(List<String[]> rows, String separator) {
        StringBuilder sb = new StringBuilder();
        for (String[] row : rows) {
            for (int i = 0; i < row.length; i++) {
                sb.append(escape(row[i]));
                if (i < row.length - 1) sb.append(separator);
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static String build(List<String[]> rows) {
        return build(rows, ",");
    }

    private static String escape(String value) {
        if (value == null) return "";
        if (value.contains(",") || value.contains("\"") || value.contains("\n")) {
            return "\"" + value.replace("\"", "\"\"") + "\"";
        }
        return value;
    }
}
