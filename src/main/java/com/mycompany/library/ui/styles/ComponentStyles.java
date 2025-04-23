package com.mycompany.library.ui.styles;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ComponentStyles {
    
    public static class RoundedPanel extends JPanel {
        
        private int cornerRadius;

        public RoundedPanel(int radius) {   
            super();
            this.cornerRadius = radius; // Set the corner radius
            setOpaque(false); // Makes the background transparent
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // Paint background with rounded corners
            g2.setColor(getBackground());
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius);

            g2.dispose();
        }
    }
    
    public static class CustomRoundedButton extends JButton {
        public CustomRoundedButton(String text) {
            super(text);
            setFocusPainted(false); // Remove the default focus painting
            setContentAreaFilled(false); // Make the background transparent
            setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Add some padding inside the button
        }
    
        @Override
        protected void paintComponent(Graphics g) {
            
            if (getModel().isPressed()) {
                g.setColor(Color.decode("#287750")); // Pressed color
            
            }else {
                g.setColor(Color.decode("#123524")); // Normal color
            }

            // Draw the rounded rectangle
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30); // Corner radius of 30

            super.paintComponent(g); // Call the original paint method to paint the text
        }
    }
    

    /*public static class CustomRoundedButton2 extends JButton {
        public CustomRoundedButton2(String text) {
            super(text);
            setFocusPainted(false); // Remove the default focus painting
            setContentAreaFilled(false); // Make the background transparent
            setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Add some padding inside the button
        }
    
        @Override
        protected void paintComponent(Graphics g) {
            
            if (getModel().isPressed()) {
                g.setColor(Color.decode("#287750")); // Pressed color
            
            }else {
                g.setColor(Color.decode("#677861")); // Normal color
            }

            // Draw the rounded rectangle
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20); // Corner radius of 30

            super.paintComponent(g); // Call the original paint method to paint the text
        }
    }*/
    
    public static class BackgroundPanel extends JPanel {

        private Image backgroundImage;

        // Constructor to load the background image
        public BackgroundPanel(String imagePath) {
            backgroundImage = new ImageIcon(imagePath).getImage();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g); // Ensures proper rendering
            // Draw the image to fill the panel
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }

    }
}
