package com.tumbwe.bobsutils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.io.ByteArrayOutputStream;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

/**
 * Utilities for generating customizable QR codes.
 */
public class QrCodeUtils {

    /**
     * Generates a QR code and returns it as a PNG byte array.
     */
    public static byte[] generatePng(String text, int width, int height, int foregroundColor, int backgroundColor) {
        try {
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            Map<EncodeHintType, Object> hints = new HashMap<>();
            hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
            hints.put(EncodeHintType.MARGIN, 1);

            BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height, hints);
            MatrixToImageConfig config = new MatrixToImageConfig(foregroundColor, backgroundColor);
            
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            MatrixToImageWriter.writeToStream(bitMatrix, "PNG", outputStream, config);
            return outputStream.toByteArray();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Generates a standard black and white QR code PNG byte array.
     */
    public static byte[] generatePng(String text, int size) {
        return generatePng(text, size, size, 0xFF000000, 0xFFFFFFFF);
    }

    /**
     * Generates a QR code and returns it as a Base64 encoded PNG string (for web display).
     */
    public static String generateBase64(String text, int size) {
        byte[] bytes = generatePng(text, size);
        if (bytes == null) return null;
        return "data:image/png;base64," + Base64.getEncoder().encodeToString(bytes);
    }

    /**
     * Generates a custom colored QR code and returns it as a Base64 string.
     */
    public static String generateBase64(String text, int size, String hexForeground, String hexBackground) {
        int fg = (int) Long.parseLong(hexForeground.replace("#", ""), 16) | 0xFF000000;
        int bg = (int) Long.parseLong(hexBackground.replace("#", ""), 16) | 0xFF000000;
        byte[] bytes = generatePng(text, size, size, fg, bg);
        if (bytes == null) return null;
        return "data:image/png;base64," + Base64.getEncoder().encodeToString(bytes);
    }
}
