package com.mycompany.library.functions;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import com.mycompany.library.ui.admin.OLD_LibraryAddBooks;

public class MoveFiles {

    public MoveFiles(){
        String coverPath = AddCover.cover;

        // Define source file (change path as needed)
        Path sourcePath = Paths.get(coverPath);

        String[] parts = coverPath.split("\\.");
        String extension = parts[1];

        // Define target directory and new file name
        Path targetDirectory = Paths.get("src/main/resources/BookCovers");

        String author = OLD_LibraryAddBooks.bookAuthorField.getText();
        String title = OLD_LibraryAddBooks.bookTitleField.getText();

        Path targetPath = targetDirectory.resolve(title + "_" + author + "." +extension);

        try {
            // Ensure the target directory exists
            if (!Files.exists(targetDirectory)) {
                Files.createDirectories(targetDirectory);
            }

            // Move and rename the file
            Files.move(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);

            System.out.println("File moved and renamed successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        
    }   
}


