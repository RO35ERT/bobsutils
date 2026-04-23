package com.tumbwe.bobsutils;

import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

/**
 * Utilities for URL parsing and network checks.
 */
public class NetworkUtils {

    /**
     * Checks if a URL is reachable by attempting a connection with a short timeout.
     */
    public static boolean isReachable(String urlStr, int timeoutMs) {
        try {
            URL url = new URI(urlStr).toURL();
            URLConnection connection = url.openConnection();
            connection.setConnectTimeout(timeoutMs);
            connection.setReadTimeout(timeoutMs);
            connection.connect();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Parses query parameters from a URL string into a Map.
     */
    public static Map<String, String> getQueryParams(String urlStr) {
        Map<String, String> params = new HashMap<>();
        try {
            URI uri = new URI(urlStr);
            String query = uri.getQuery();
            if (StringUtils.isBlank(query)) return params;
            
            String[] pairs = query.split("&");
            for (String pair : pairs) {
                String[] kv = pair.split("=");
                if (kv.length > 1) {
                    params.put(kv[0], java.net.URLDecoder.decode(kv[1], "UTF-8"));
                } else if (kv.length == 1) {
                    params.put(kv[0], "");
                }
            }
        } catch (Exception ignored) {}
        return params;
    }
}
