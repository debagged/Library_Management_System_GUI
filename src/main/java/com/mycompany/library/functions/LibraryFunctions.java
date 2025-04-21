package com.mycompany.library.functions;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.time.LocalDate;


import javax.swing.JOptionPane;

import com.mycompany.library.users.UserData;
// import com.mycompany.library.database.LibraryDatabase;

public class LibraryFunctions {

    public static void addBooksTODB (String ISBN, String book_title, String edition, String book_author, String publisher, 
                                     int year_published, int pages, String date_acquired, String call_number, List<String> genres, List<String> tags, String course, String status){
        Connection connect = null;  

        try {
            connect = UserData.checkDatabaseConnection();
            if (connect == null) return;
            
            connect.setAutoCommit(false); //Starts Transaction
  
            String insertIntoBooks = "INSERT INTO Books (ISBN, book_title, edition, book_author, publisher, year_published, pages, date_acquired, call_number) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement addBook_stmt = connect.prepareStatement(insertIntoBooks)){
                
                String formattedDate = date_acquired.substring(0, 4) + "-" + date_acquired.substring(4, 6) + "-" + date_acquired.substring(6, 8);

                addBook_stmt.setString(1, ISBN);
                addBook_stmt.setString(2, book_title);
                addBook_stmt.setString(3, edition);
                addBook_stmt.setString(4, book_author);
                addBook_stmt.setString(5, publisher);
                addBook_stmt.setInt(6, year_published);
                addBook_stmt.setInt(7, pages);
                addBook_stmt.setDate(8, java.sql.Date.valueOf(formattedDate));
                addBook_stmt.setString(9, call_number);
                addBook_stmt.executeUpdate();
            }

            String insertIntoBookGenre = "INSERT INTO Book_Genre (ISBN, genre_ID) VALUES (?, ?)";
            try (PreparedStatement book_Genre_stmt = connect.prepareStatement(insertIntoBookGenre)){
                for (String genre : genres){
                    int genre_ID = genreChecker(genre);
                    if (genre_ID == 0) {
                        genreAdder(genre);
                        genre_ID = genreChecker(genre);
                    }
                    book_Genre_stmt.setString(1, ISBN);
                    book_Genre_stmt.setInt(2, genre_ID);
                    book_Genre_stmt.executeUpdate();
                }
                
            }

            String insertIntoBookTags = "INSERT INTO Book_Tags (ISBN, tags_ID) VALUES (?, ?)";
            try (PreparedStatement book_tags_stmt = connect.prepareStatement(insertIntoBookTags)){
                for (String tag : tags){
                    int tags_ID = tagChecker(tag);
                    book_tags_stmt.setString(1, ISBN);
                    book_tags_stmt.setInt(2, tags_ID);
                    book_tags_stmt.executeUpdate();
                }
            }

            String insertIntoCourse = "INSERT INTO Book_Course (ISBN, course_ID) VALUES (?, ?)";
            try (PreparedStatement book_course_stmt = connect.prepareStatement(insertIntoCourse)){
                    String course_ID = UserData.courseChecker(course);
                    book_course_stmt.setString(1, ISBN);
                    book_course_stmt.setString(2, course_ID);
                    book_course_stmt.executeUpdate();
            }

            String insertIntoStatus = "INSERT INTO Book_Status (ISBN, course_ID) VALUES (?, ?)";
            try (PreparedStatement book_status_stmt = connect.prepareStatement(insertIntoStatus)){
                    int status_ID = statusChecker(status);
                    book_status_stmt.setString(1, ISBN);
                    book_status_stmt.setInt(2, status_ID);
                    book_status_stmt.executeUpdate();
            }

            connect.commit();
            JOptionPane.showMessageDialog(null, "Book Added Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException e) {
            try {
                if (connect != null) 
                    connect.rollback();
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Registration failed. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (SQLException rollback) {
                rollback.printStackTrace();
            }
        } finally {
            if (connect != null) {
                try {
                    connect.setAutoCommit(true); // reset autocommit
                    connect.close(); 
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }  
        } 
    }


    public static void borrowBook (String ISBN, String user_ID){
        Connection connect = null;  
        LocalDate today = LocalDate.now();
        LocalDate returnDate = today.plusDays(7);

        try {
            connect = UserData.checkDatabaseConnection();
            if (connect == null) return;
            
            connect.setAutoCommit(false);  //Starts Transaction


            String borrowQuery = "INSERT INTO Borrowed_Books (ISBN, user_ID, borrowed_date, return_date) VALUES (?, ?, ?, ?)";
            try (PreparedStatement borrowStmt = connect.prepareStatement(borrowQuery)){
                borrowStmt.setString(1, ISBN);
                borrowStmt.setString(2, user_ID);
                borrowStmt.setDate(3, java.sql.Date.valueOf(today));
                borrowStmt.setDate(4, java.sql.Date.valueOf(returnDate));

                borrowStmt.executeUpdate();

                connect.commit();
                JOptionPane.showMessageDialog(null, "Book Added Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
    
            } catch (SQLException e) {
                try {
                    if (connect != null) 
                        connect.rollback();
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Registration failed. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (SQLException rollback) {
                    rollback.printStackTrace();
                }
            } finally {
                if (connect != null) {
                    try {
                        connect.setAutoCommit(true); // reset autocommit
                        connect.close(); // ✅ make sure it's closed
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }  
            } 
        } catch (SQLException e)  {
            e.printStackTrace();

        }
    }



    public static void genreAdder (String genreToAdd){
        Connection connect = UserData.checkDatabaseConnection(); 

        int existingGenreID = genreChecker(genreToAdd);

        String insertIntoGenre = "INSERT INTO Genres (genre_name) VALUES (?)";
        if (existingGenreID != 0) {
            JOptionPane.showMessageDialog(null, "Genre already exists in the database", "Duplicate Genre", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try(PreparedStatement addToGenre = connect.prepareStatement(insertIntoGenre)) {
            
            addToGenre.setString(1, genreToAdd);
            int rowsAffected = addToGenre.executeUpdate(); // Use executeUpdate here

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Genre added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Genre insertion failed.", "Error", JOptionPane.ERROR_MESSAGE);
            }
    
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "An error occurred while inserting genre.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static int genreChecker (String genre){
        Connection connect = UserData.checkDatabaseConnection(); 
        int genre_ID = 0;

        String genre_query = "SELECT genre_ID FROM Genres WHERE genre_name = ?";
        try(PreparedStatement genreStmt = connect.prepareStatement(genre_query)) {
            genreStmt.setString(1, genre);
            ResultSet genreResult = genreStmt.executeQuery();

            if (genreResult.next()) {
                // Course exists, get its ID
                genre_ID = genreResult.getInt("genre_ID");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return genre_ID;
    }

    
    public static void tagAdder(String tagToAdd) {
        Connection connect = UserData.checkDatabaseConnection();
    
        int existingTagID = tagChecker(tagToAdd);
    
        String insertIntoTag = "INSERT INTO Tags (tag_name) VALUES (?)";
        if (existingTagID != 0) {
            JOptionPane.showMessageDialog(null, "Tag already exists in the database", "Duplicate Tag", JOptionPane.WARNING_MESSAGE);
            return;
        }
    
        try (PreparedStatement addToTag = connect.prepareStatement(insertIntoTag)) {
    
            addToTag.setString(1, tagToAdd);
            int rowsAffected = addToTag.executeUpdate();
    
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Tag added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Tag insertion failed.", "Error", JOptionPane.ERROR_MESSAGE);
            }
    
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "An error occurred while inserting tag.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }    

    public static int tagChecker (String tags){
        Connection connect = UserData.checkDatabaseConnection(); 
        int tags_ID = 0;

        String tag_query = "SELECT genre_ID FROM Genres WHERE genre_name = ?";
        try(PreparedStatement tagStmt = connect.prepareStatement(tag_query)) {
            tagStmt.setString(1, tags);
            ResultSet tagResult = tagStmt.executeQuery();

            if (tagResult.next()) {
                // Course exists, get its ID
                tags_ID = tagResult.getInt("genre_ID");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tags_ID;
    }
    
    public static int statusChecker(String statusName) {
        Connection connect = UserData.checkDatabaseConnection(); 
        int status_ID = 0;
    
        String status_query = "SELECT status_ID FROM Status WHERE status_name = ?";
        try (PreparedStatement statusStmt = connect.prepareStatement(status_query)) {
            statusStmt.setString(1, statusName);
            ResultSet statusResult = statusStmt.executeQuery();
    
            if (statusResult.next()) {
                status_ID = statusResult.getInt("status_ID");
            }
    
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status_ID;
    }
    























    public File sourceFile;
    protected String book_title = "",
                        book_author = "", 
                        book_isbn = "";

    ///////////////
    ///  BOOKS  ///
    ///////////////
    public void fileWriterBooks(String book_title, String book_author, String book_isbn) {
        try (FileWriter fileWrite = new FileWriter("src/main/resources/Books.txt", true)) { 
            fileWrite.append(String.format("%s|%s|%s%n", 
                        book_author, book_title, book_isbn));

        } catch(IOException e){}
    }
    // Library Books Functions


    //////////////////////
    ///  BORROW BOOKS  ///
    //////////////////////
    public void fileWriterBorrowers(String student_name,
                                    String student_ID,
                                    String book_title,
                                    String book_author) {
        // Check if the file is empty, if so, write the header
        try (FileWriter fileWriter = new FileWriter("src/main/resources/Borrowed_Books.txt", true)) {
            fileWriter.append(String.format("%s|%s|%s|%s|%n", 
                            student_name, student_ID, book_title, book_author));
        } catch(IOException e){}
    }
    
    public void tempQueue(String book_title, String book_author, String book_isbn) {
        
        try (FileWriter fileWrite = new FileWriter("tempQueue.txt", true)) { 
            fileWrite.append(String.format("%s|%s|%s%n", book_author, book_title, book_isbn));

        } catch(IOException e){}
    }
    
    public boolean checkQueue(String isbn){
        try(BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/tempQueue.txt"))){
            String borrowedLine;

            while((borrowedLine = reader.readLine()) != null){
                String[] parts = borrowedLine.split("\\|");

                String foundISBN = parts[2].trim();

                if(foundISBN.equals(isbn)) return true;
            }
        } catch(IOException e){}

        return false;
    }
    
    public void addBooksFromQueue(){
        
        File file = new File("src/main/resources/tempQueue.txt");
        
        try(BufferedReader tempReader = new BufferedReader(new FileReader(file));
            BufferedWriter tempWriter = new BufferedWriter(new FileWriter("src/main/resources/Books.txt", true))) {
            
            String line;
            // Read and write line by line
            while ((line = tempReader.readLine()) != null) {
                tempWriter.write(line);
                tempWriter.newLine(); // Add a newline character after each line
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // Delete the source file after moving its content
        file.delete();

    }
    
    public boolean checkAddedBooks(String isbn){

        try(BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/Books.txt"))){
            String borrowedLine;

            while((borrowedLine = reader.readLine()) != null){
                String[] parts = borrowedLine.split("\\|");

                String foundISBN = parts[2].trim();

                if(foundISBN.equals(isbn)) return true;
            }
        } catch(IOException e){}

        return false;
    }
    
    public boolean checkBorrowedBooks(String isbn){

        try(BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/Borrowed_Books.txt"))){
            String borrowedLine;

            while((borrowedLine = reader.readLine()) != null){
                String[] parts = borrowedLine.split("\\|");

                String foundISBN = parts[4].trim();

                if(foundISBN.equals(isbn)) return true;
            }
            
        } catch(IOException e){}

        return false;
    }
    
    public boolean checkIfBorrowed(String title, String author){

        String bookInfo = title + "|" + author;

        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/Borrowed_Books.txt"))){
                
            // Read the file content into a String
            String borrowedLine;

            while((borrowedLine = reader.readLine()) != null){
                String[] parts = borrowedLine.split("\\|");

                String foundTitle = parts[2].trim();
                String foundAuthor = parts[3].trim();

                String book = foundTitle + "|" + foundAuthor;

                // Check if the file content contains the Book
                if(book.equals(bookInfo)){
                    return true;
                }
            }
        } catch (IOException e) {}
        return false;
    }

    public boolean isBorrowed = false;
    
    //Library Functions
    /* public void borrowBooks(String isbn, String studName, String studID){

        // Ensure the borrowed books file exists
        borrowedBooksFile = new File("Borrowed_Books.txt");

        try (BufferedReader br = new BufferedReader(new FileReader("Books.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");

                //extracted info from splits, creates new fields
                String  foundAuthor = parts[0].trim(),
                        foundTitle = parts[1].trim(),
                        foundISBN = parts[2].trim();

                if (isbn.equalsIgnoreCase(foundISBN)){
                    
                    // return info to rightful fields
                    book_author = foundAuthor;
                    book_title = foundTitle;
                    book_isbn = foundISBN;

                    fileWriterBorrowers(studName, studID, book_title, book_author, book_isbn);
                }
            }
        } catch(IOException e){}
    } */

    public void borrowBooks(String title,String author, String studName, String studID){

        String book = title + "_" + author;

        File bookCoversFolder = new File("src/main/resources/BookCovers");

        File[] bookCoversFolderFiles = bookCoversFolder.listFiles(File::isFile);
        
        if(bookCoversFolderFiles != null){
            for(File cover : bookCoversFolderFiles) {
                String[] bookDescription = cover.getName().split("[_.]");

                String bookTitle = bookDescription[0].trim();
                String bookAuthor = bookDescription[1].trim();

                if(book.equalsIgnoreCase(bookTitle + "_" + bookAuthor)){
                    fileWriterBorrowers(studName, studID, bookTitle,bookAuthor);
                }
                
            }
        }
    }
}