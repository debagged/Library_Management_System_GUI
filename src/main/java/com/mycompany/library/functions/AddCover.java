package com.mycompany.library.functions;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class AddCover {

    static String cover;

    public AddCover(){
        JFileChooser chooser = new JFileChooser();
        
        // Set the default folder to the Downloads directory
        String userHome = System.getProperty("user.home");
        File downloadsFolder = new File(userHome, "Downloads");
        chooser.setCurrentDirectory(downloadsFolder);

        FileNameExtensionFilter imageFilter = new FileNameExtensionFilter(
            "Image Files (*.jpg, *.jpeg, *.png)",
            "jpg", "jpeg", "png"
        );

        chooser.setFileFilter(imageFilter);

        int returnValue = chooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFolder = chooser.getSelectedFile();
            cover = selectedFolder.getAbsolutePath();
        }
    }
    
    public static byte[] getCoverBytes() {
        if (cover != null) {
            try {
                return Files.readAllBytes(new File(cover).toPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null; // if no image is selected or error occurred
    }

    public static String getCover(){
        return cover;
    }
    
    public static void main(String[] args) {
        
    }

}
