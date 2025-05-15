package com.mycompany.library.ui.admin;

import java.nio.file.*;
import java.sql.*;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class BookImageImporter {

    public static void main(String[] args) {
        final String folderPath = "C:\\Users\\LAYOSA\\Desktop\\OOPR\\LIbraryManagementSystem\\src\\main\\resources\\BookCovers"; // Change this
        final String jdbcURL = "jdbc:mysql://sql12.freesqldatabase.com:3306/sql12774281?zeroDateTimeBehavior=CONVERT_TO_NULL"; // Change this
        final String dbUser = "sql12774281"; // Change this
        final String dbPassword = "ANA1SUkuem"; // Change this

        try (Connection conn = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
             Scanner scanner = new Scanner(System.in)) {

            Files.list(Paths.get(folderPath))
                .filter(Files::isRegularFile)
                .filter(p -> p.toString().endsWith(".jpg") || p.toString().endsWith(".png"))
                .forEach(path -> {
                    try {
                        // Extract title and author from filename
                        String filename = path.getFileName().toString();
                        String nameWithoutExt = filename.substring(0, filename.lastIndexOf('.'));
                        String[] parts = nameWithoutExt.split("_", 2);
                        if (parts.length < 2) {
                            System.out.println("Skipping invalid filename: " + filename);
                            return;
                        }
                        String title = parts[0].replace("-", " ");
                        String author = parts[1].replace("-", " ");

                        // Prompt user for additional details
                        System.out.println("Processing book: " + title + " by " + author);

                        System.out.print("Enter ISBN: ");
                        String isbn = scanner.nextLine();

                        System.out.print("Enter Edition: ");
                        String edition = scanner.nextLine();

                        System.out.print("Enter Publisher: ");
                        String publisher = scanner.nextLine();

                        System.out.print("Enter Year Published: ");
                        int yearPublished = Integer.parseInt(scanner.nextLine());

                        System.out.print("Enter Number of Pages: ");
                        int pages = Integer.parseInt(scanner.nextLine());

                        JTextArea textArea = new JTextArea(10, 40);
                        textArea.setLineWrap(true);
                        textArea.setWrapStyleWord(true);
                        JScrollPane scrollPane = new JScrollPane(textArea);

                        int result = JOptionPane.showConfirmDialog(null, scrollPane, "Enter Book Description",
                                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                        String description;

                        if (result == JOptionPane.OK_OPTION) {
                            description = textArea.getText();
                        } else {
                            System.out.println("Cancelled by user.");
                            return;
                        }

                        // Read image as byte[]
                        byte[] imageBytes = Files.readAllBytes(path);

                        // Insert into DB
                        String sql = "INSERT INTO Books (ISBN, book_title, edition, book_author, publisher, year_published, pages, description, book_cover) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                            stmt.setString(1, isbn);
                            stmt.setString(2, title);
                            stmt.setString(3, edition);
                            stmt.setString(4, author);
                            stmt.setString(5, publisher);
                            stmt.setInt(6, yearPublished);
                            stmt.setInt(7, pages);
                            stmt.setString(8, description);
                            stmt.setBytes(9, imageBytes);
                            stmt.executeUpdate();
                            System.out.println("Book saved to database successfully.");
                        }

                    } catch (Exception e) {
                        System.out.println("Error processing file " + path.getFileName() + ": " + e.getMessage());
                    }
                });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
