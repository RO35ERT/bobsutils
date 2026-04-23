package com.tumbwe.bobsutils;

/**
 * Utilities for normalizing and validating phone numbers, specifically for Zambia (+260).
 */
public class PhoneUtils {

    /**
     * Normalizes a Zambian phone number to the standard format: 260XXXXXXXXX.
     * Handles formats like 097..., +26097..., 97...
     */
    public static String normalizeZambian(String phone) {
        if (StringUtils.isBlank(phone)) return null;
        
        // Remove all non-digits
        String digits = StringUtils.extractDigits(phone);
        
        // If it starts with 0 and has 10 digits, replace 0 with 260
        if (digits.startsWith("0") && digits.length() == 10) {
            return "260" + digits.substring(1);
        }
        
        // If it has 9 digits, assume it's a mobile without leading 0 or 260
        if (digits.length() == 9) {
            return "260" + digits;
        }
        
        // If it already has 12 digits and starts with 260, it's already normalized
        if (digits.startsWith("260") && digits.length() == 12) {
            return digits;
        }
        
        return digits;
    }

    /**
     * Validates if a string is a valid Zambian mobile number.
     */
    public static boolean isValidZambian(String phone) {
        String normalized = normalizeZambian(phone);
        if (normalized == null || normalized.length() != 12) return false;
        
        // Standard ZM mobile prefixes (after 260): 
        // Airtel: 97, 77, 57
        // MTN: 96, 76, 56
        // Zamtel: 95, 75, 55
        // ZED Mobile: 98, 78, 58
        return normalized.matches("^260(97|77|57|96|76|56|95|75|55|98|78|58)\\d{7}$");
    }

    /**
     * Identifies the network carrier for a Zambian mobile number.
     */
    public static String getZambianNetwork(String phone) {
        String normalized = normalizeZambian(phone);
        if (!isValidZambian(normalized)) return "UNKNOWN";
        
        String prefix = normalized.substring(3, 5);
        switch (prefix) {
            case "97":
            case "77":
            case "57":
                return "AIRTEL";
            case "96":
            case "76":
            case "56":
                return "MTN";
            case "95":
            case "75":
            case "55":
                return "ZAMTEL";
            case "98":
            case "78":
            case "58":
                return "ZED MOBILE";
            default:
                return "UNKNOWN";
        }
    }

    /**
     * Formats a normalized number for display: +260 97 1234567
     */
    public static String formatDisplay(String phone) {
        String normalized = normalizeZambian(phone);
        if (!isValidZambian(normalized)) return phone;
        
        return String.format("+260 %s %s", 
            normalized.substring(3, 5), 
            normalized.substring(5));
    }
}
