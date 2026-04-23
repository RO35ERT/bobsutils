package com.tumbwe.bobsutils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Utilities for basic image processing using standard Java AWT.
 */
public class ImageUtils {

    /**
     * Resizes an image to the specified width and height.
     */
    public static byte[] resize(byte[] imageData, int width, int height, String format) throws IOException {
        BufferedImage original = ImageIO.read(new ByteArrayInputStream(imageData));
        Image scaled = original.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        
        BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = resized.createGraphics();
        g2d.drawImage(scaled, 0, 0, null);
        g2d.dispose();
        
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(resized, format, baos);
        return baos.toByteArray();
    }

    /**
     * Converts an image to Grayscale.
     */
    public static byte[] toGrayscale(byte[] imageData, String format) throws IOException {
        BufferedImage original = ImageIO.read(new ByteArrayInputStream(imageData));
        BufferedImage gray = new BufferedImage(original.getWidth(), original.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
        
        Graphics g = gray.getGraphics();
        g.drawImage(original, 0, 0, null);
        g.dispose();
        
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(gray, format, baos);
        return baos.toByteArray();
    }
}
