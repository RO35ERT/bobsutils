package com.tumbwe.bobsutils;

import org.junit.jupiter.api.Test;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

class ImageUtilsTest {

    private byte[] createDummyImage() throws IOException {
        BufferedImage img = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(img, "png", baos);
        return baos.toByteArray();
    }

    @Test
    void testResize() throws IOException {
        byte[] original = createDummyImage();
        byte[] resized = ImageUtils.resize(original, 50, 50, "png");
        assertNotNull(resized);
        
        BufferedImage img = ImageIO.read(new java.io.ByteArrayInputStream(resized));
        assertEquals(50, img.getWidth());
        assertEquals(50, img.getHeight());
    }

    @Test
    void testToGrayscale() throws IOException {
        byte[] original = createDummyImage();
        byte[] gray = ImageUtils.toGrayscale(original, "png");
        assertNotNull(gray);
        
        BufferedImage img = ImageIO.read(new java.io.ByteArrayInputStream(gray));
        assertEquals(BufferedImage.TYPE_BYTE_GRAY, img.getType());
    }
}
