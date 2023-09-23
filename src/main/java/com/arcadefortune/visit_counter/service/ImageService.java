// ChatGPT 3.5:
// generate an image using java that contains a specific String with a black background. The width of the image should scale with the text.
package com.arcadefortune.visit_counter.service;

import org.springframework.stereotype.Service;

import java.awt.*;
import java.awt.image.BufferedImage;

@Service
public class ImageService {
  public BufferedImage generateImage(String text) {
    int padding = 12; // i made this one myself yay

    // Create a font for the text
    Font font = new Font("Arial", Font.PLAIN, 24); // You can adjust the font size

    // Create a BufferedImage
    return createImageWithText(text, font, padding);
}

public static BufferedImage createImageWithText(String text, Font font, int padding) {
    // Create a temporary Graphics2D object to calculate text width
    BufferedImage tempImage = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
    Graphics2D g2d = tempImage.createGraphics();
    g2d.setFont(font);

    // Calculate the text width and height
    FontMetrics fm = g2d.getFontMetrics();
    int textWidth = fm.stringWidth(text) + padding;
    int textHeight = fm.getHeight() + padding;

    // Create a new BufferedImage with the calculated width and height
    BufferedImage image = new BufferedImage(textWidth, textHeight, BufferedImage.TYPE_INT_ARGB);
    g2d.dispose(); // Dispose of the temporary Graphics2D

    // Create a Graphics2D object for the new image
    g2d = image.createGraphics();

    // Set the background color to black
    g2d.setColor(Color.BLACK);
    g2d.fillRect(0, 0, textWidth, textHeight);

    // Set the font and color for the text
    g2d.setFont(font);
    g2d.setColor(Color.WHITE);

    // Draw the text onto the image
    g2d.drawString(text, padding / 2, fm.getAscent() + padding/2);

    g2d.dispose(); // Dispose of the Graphics2D

    return image;
    }
}