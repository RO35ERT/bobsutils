package com.tumbwe.bobsutils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * Utilities for hashing and encoding.
 */
public class SecurityUtils {

    /**
     * Generates a SHA-256 hash of a string.
     */
    public static String sha256(String input) {
        return hash(input, "SHA-256");
    }

    /**
     * Generates an MD5 hash of a string.
     */
    public static String md5(String input) {
        return hash(input, "MD5");
    }

    /**
     * Encodes a string to Base64.
     */
    public static String base64Encode(String input) {
        if (input == null) return null;
        return Base64.getEncoder().encodeToString(input.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * Decodes a Base64 string.
     */
    public static String base64Decode(String encoded) {
        if (encoded == null) return null;
        return new String(Base64.getDecoder().decode(encoded), StandardCharsets.UTF_8);
    }

    private static String hash(String input, String algorithm) {
        if (input == null) return null;
        try {
            MessageDigest digest = MessageDigest.getInstance(algorithm);
            byte[] hash = digest.digest(input.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    /**
     * Generates a random secure hexadecimal token.
     */
    public static String generateRandomToken(int length) {
        java.security.SecureRandom random = new java.security.SecureRandom();
        byte[] bytes = new byte[length / 2];
        random.nextBytes(bytes);
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}
