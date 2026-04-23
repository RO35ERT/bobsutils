package com.tumbwe.bobsutils;

/**
 * Basic utilities for parsing User-Agent strings.
 */
public class UserAgentUtils {

    /**
     * Checks if the User-Agent likely belongs to a mobile device.
     */
    public static boolean isMobile(String userAgent) {
        if (StringUtils.isBlank(userAgent)) return false;
        String ua = userAgent.toLowerCase();
        return ua.contains("mobile") || ua.contains("android") || ua.contains("iphone") || ua.contains("ipod");
    }

    /**
     * Checks if the User-Agent likely belongs to a tablet.
     */
    public static boolean isTablet(String userAgent) {
        if (StringUtils.isBlank(userAgent)) return false;
        String ua = userAgent.toLowerCase();
        return ua.contains("ipad") || (ua.contains("android") && !ua.contains("mobile"));
    }

    /**
     * Simple check for common browsers.
     */
    public static String getBrowserType(String userAgent) {
        if (StringUtils.isBlank(userAgent)) return "UNKNOWN";
        String ua = userAgent.toLowerCase();
        if (ua.contains("edg/")) return "EDGE";
        if (ua.contains("chrome/")) return "CHROME";
        if (ua.contains("safari/")) return "SAFARI";
        if (ua.contains("firefox/")) return "FIREFOX";
        return "OTHER";
    }

    /**
     * Checks if the User-Agent likely belongs to a bot or crawler.
     */
    public static boolean isBot(String userAgent) {
        if (StringUtils.isBlank(userAgent)) return false;
        String ua = userAgent.toLowerCase();
        return ua.contains("bot") || ua.contains("crawler") || ua.contains("spider") || ua.contains("slurp");
    }
}
