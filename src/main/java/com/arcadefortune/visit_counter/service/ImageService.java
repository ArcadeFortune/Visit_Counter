// ChatGPT:
// generate a square image using java that contains a variable number with a transparent background.
package com.arcadefortune.visit_counter.service;

import org.springframework.stereotype.Service;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

@Service
public class ImageService {

    public BufferedImage generateImage(int viewCount) {
        int imageSize = 100; // Change this to your desired image size
        String text = String.valueOf(viewCount); // Change this to your desired variable number

        // Create a BufferedImage with a transparent background
        BufferedImage image = new BufferedImage(imageSize, imageSize, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = image.createGraphics();
        g2d.setColor(new Color(0, 0, 0)); // Dark background
        g2d.fillRect(0, 0, imageSize, imageSize);

        // Set font and color for the text
        g2d.setFont(new Font("Arial", Font.BOLD, 48)); // Change the font and size as needed
        g2d.setColor(Color.WHITE); // Change the text color as needed

        // Calculate the position to center the text in the square
        int x = (imageSize - g2d.getFontMetrics().stringWidth(text)) / 2;
        int y = (imageSize - g2d.getFontMetrics().getHeight()) / 2 + g2d.getFontMetrics().getAscent();

        // Draw the text on the image
        g2d.drawString(text, x, y);
        g2d.dispose();

        return image;
//        // Save the image to a file (you can change the format as needed, e.g., PNG, JPG)
//        try {
//            ImageIO.write(image, "PNG", new File("output.png"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

}