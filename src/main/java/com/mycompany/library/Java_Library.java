package com.mycompany.library;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import java.awt.Window;

public class Java_Library{
    public static void main(String[] args){

        System.setProperty("sun.java2d.d3d", "false");
        System.setProperty("sun.java2d.opengl", "false");

        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");

            // Update all open windows with the new Look and Feel
            for (Window window : Window.getWindows()) {
                SwingUtilities.updateComponentTreeUI(window);
            }

        } catch (Exception e) {e.printStackTrace();}

        new com.mycompany.library.ui.mainpage.LogInPage().setVisible(true);
    }

}