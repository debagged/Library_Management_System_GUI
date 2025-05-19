package com.mycompany.library.functions;

import java.awt.Image;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.time.LocalDate;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import com.mycompany.library.users.UserData;
import java.sql.Statement;

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

    public static boolean borrowBook (String ISBN, String user_ID){
        Connection connect = null;  
        LocalDate today = LocalDate.now();
        LocalDate returnDate = today.plusDays(7);

        try {
            connect = UserData.checkDatabaseConnection();
            if (connect == null) return false;
            
            connect.setAutoCommit(false);  //Starts Transaction

            String borrowQuery = "INSERT INTO Borrowed_Books (ISBN, user_ID, borrowed_date, return_date) VALUES (?, ?, ?, ?)";
            try (PreparedStatement borrowStmt = connect.prepareStatement(borrowQuery)){
                borrowStmt.setString(1, ISBN);
                borrowStmt.setString(2, user_ID);
                borrowStmt.setDate(3, java.sql.Date.valueOf(today));
                borrowStmt.setDate(4, java.sql.Date.valueOf(returnDate));

                borrowStmt.executeUpdate();

                connect.commit();
                return true;
    
            } catch (SQLException e) {
                try {
                    if (connect != null) 
                        connect.rollback();
                    e.printStackTrace();
                    return false;
                } catch (SQLException rollback) {
                    rollback.printStackTrace();
                    return false;
                }
            } finally {
                if (connect != null) {
                    try {
                        connect.setAutoCommit(true);
                        connect.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                        return false;
                    }
                }  
            } 
        } catch (SQLException e)  {
            e.printStackTrace();
            return false;
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

    private static final Random random = new Random();

    public static String generateCallNumber(String genreName, String authorLastName) {
        String query = "SELECT tag_ID FROM Tags WHERE LOWER(tag_name) = ?";

        try (Connection conn = UserData.checkDatabaseConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, genreName.toLowerCase());
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String genreID = rs.getString("tag_ID");  // e.g., "001-099"
                String[] rangeParts = genreID.split("-");
                if (rangeParts.length != 3) return "Invalid genre_ID format.";

                int start = Integer.parseInt(rangeParts[1]);
                int end = Integer.parseInt(rangeParts[2]);

                int ddcNumber = start + random.nextInt(end - start + 1);
                String ddcCode = String.format("%03d", ddcNumber);

                String authorCode = authorLastName.length() >= 3
                        ? authorLastName.substring(0, 3).toUpperCase()
                        : authorLastName.toUpperCase();

                return ddcCode + "." + authorCode;
            } else {
                return "Genre not found.";
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return "Database error.";
        }
    }

    public static boolean saveBookToDatabase(
    String isbn,
    String title,
    String edition,
    String author,
    int yearPublished,
    int pages,
    String dateAcquired,
    String callNumber,
    String description,
    byte[] imageBytes
    ) {

        String sql = "INSERT INTO Books (ISBN, book_title, edition, book_author, year_published, pages, date_acquired, call_number, description, book_cover) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                
        String addStatus = "INSERT INTO Book_Status (ISBN) " + "VALUES (?)";

        try (Connection conn = UserData.checkDatabaseConnection()){
            conn.setAutoCommit(false); // Start transaction

            try (
                PreparedStatement stmt1 = conn.prepareStatement(sql);
                PreparedStatement stmt2 = conn.prepareStatement(addStatus)
            ) {
                stmt1.setString(1, isbn);
                stmt1.setString(2, title);
                stmt1.setString(3, edition);
                stmt1.setString(4, author);
                stmt1.setInt(5, yearPublished);
                stmt1.setInt(6, pages);
                stmt1.setString(7, dateAcquired);
                stmt1.setString(8, callNumber);
                stmt1.setString(9, description);
                stmt1.setBytes(10, imageBytes);
                stmt1.executeUpdate();

                // Insert into Books_Status
                stmt2.setString(1, isbn);
                stmt2.executeUpdate();

                conn.commit();
                return true;
            } catch (Exception e) {
                conn.rollback();
                e.printStackTrace();
                return false;
            } finally {
                conn.setAutoCommit(true);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static class bookInfos {
        public String isbn;
        public String title;
        public String edition;
        public String author;
        public int yearPublished;
        public int pages;
        public String dateAcquired;
        public String callNumber;
        public String description;
        public ImageIcon cover;

        public bookInfos(String isbn, String title, String edition, String author,
                        int yearPublished, int pages, String dateAcquired, String callNumber,
                        String description, ImageIcon cover) {
            this.isbn = isbn;
            this.title = title;
            this.edition = edition;
            this.author = author;
            this.yearPublished = yearPublished;
            this.pages = pages;
            this.dateAcquired = dateAcquired;
            this.callNumber = callNumber;
            this.description = description;
            this.cover = cover;
        }
    }

    public static List<bookInfos> fetchBookData() {
        List<bookInfos> books = new ArrayList<>();

        try (Connection conn = UserData.checkDatabaseConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM Books")) {

            while (rs.next()) {
                byte[] imageBytes = rs.getBytes("book_cover");
                ImageIcon icon = new ImageIcon(imageBytes);

                // Optionally scale the image
                Image scaled = icon.getImage().getScaledInstance(145, 215, Image.SCALE_SMOOTH);
                icon = new ImageIcon(scaled);

                bookInfos book = new bookInfos(
                        rs.getString("ISBN"),
                        rs.getString("book_title"),
                        rs.getString("edition"),
                        rs.getString("book_author"),
                        rs.getInt("year_published"),
                        rs.getInt("pages"),
                        rs.getString("date_acquired"),
                        rs.getString("call_number"),
                        rs.getString("description"),
                        icon
                );

                books.add(book);
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Or handle via your preferred method
        }

        return books;
    }

    public static List<bookInfos> fetchBookByTitle(String title) {
        List<bookInfos> books = new ArrayList<>();

        String query = "SELECT * FROM Books WHERE book_title = ?";

        try (Connection conn = UserData.checkDatabaseConnection();
            PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, title);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    byte[] imageBytes = rs.getBytes("book_cover");
                    ImageIcon icon = new ImageIcon(imageBytes);
                    Image scaledImage = icon.getImage().getScaledInstance(100, 140, Image.SCALE_SMOOTH);
                    icon = new ImageIcon(scaledImage);

                    bookInfos book = new bookInfos(
                            rs.getString("ISBN"),
                            rs.getString("book_title"),
                            rs.getString("edition"),
                            rs.getString("book_author"),
                            rs.getInt("year_published"),
                            rs.getInt("pages"),
                            rs.getString("date_acquired"),
                            rs.getString("call_number"),
                            rs.getString("description"),
                            icon
                    );
                    
                    books.add(book);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return books;
    }

    public static class BorrowedBookInfos {
        public String isbn;
        public String id;

        public BorrowedBookInfos(String isbn, String id) {
            this.isbn = isbn;
            this.id = id;
        }
    }

    public static List<BorrowedBookInfos> fetchBorrowedBookData() {
        List<BorrowedBookInfos> books = new ArrayList<>();

        try (Connection conn = UserData.checkDatabaseConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM Borrowed_Books")) {

            while (rs.next()) {
                
                BorrowedBookInfos book = new BorrowedBookInfos(
                        rs.getString("ISBN"),
                        rs.getString("user_ID")
                );

                books.add(book);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return books;
    }

    public static void returnBook(String ISBN, String ID){
        Connection conn = null;

        try{
            conn = UserData.checkDatabaseConnection();
            if(conn == null) return;

            conn.setAutoCommit(false);
            
            String removeBook = "DELETE FROM Borrowed_Books WHERE ISBN = ? AND user_ID = ?";

            try(PreparedStatement removeBook_stmt = conn.prepareStatement(removeBook)){

                removeBook_stmt.setString(1, ISBN);
                removeBook_stmt.setString(2,ID);

                removeBook_stmt.executeUpdate();
            }

            conn.commit();

        } catch(SQLException e){
            e.printStackTrace();
            try {
                if(conn != null)conn.rollback();
            } catch (SQLException err){
                err.printStackTrace();
            }
        } finally{
            if(conn != null){
                try{
                    conn.setAutoCommit(true);
                    conn.close();
                } catch(SQLException e){
                    e.printStackTrace();
                }
            }
            
        }
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

    public boolean isBorrowed = false;

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