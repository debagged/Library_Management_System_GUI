package com.mycompany.library.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.mycompany.library.functions.LibraryFunctions;
// import com.mycompany.library.users.UserData;


public class LibraryDatabase {
    
    static Scanner scan = new Scanner(System.in);
    static PreparedStatement preparedStatement;

    public static void main(String[] args) {

        // String user_ID = null , 
        //        given_name = null, 
        //        middle_name = null, 
        //        last_name = null, 
        //        gender = null, 
        //        campus_email = null,
        //        course = null, 
        //        username = null,
        //        password = null;

    
        // //AI generated Person
        // user_ID = "06240002298";
        // given_name = "Lorenzo";
        // middle_name = "Miguel";
        // last_name = "Del Rosario";
        // gender = "Male";
        // campus_email = "lmdelrosario2298lag@student.fatima.edu.ph";
        // course = "Computer Science";
        // username = "lorenzo_rosario";
        // password = "itStrong#2025";

        // UserData.registerUserToDB(user_ID, given_name, middle_name, last_name, gender, campus_email, course, username, password);
    
        // System.out.print("Enter Username: ");
        // String input_username = scan.nextLine();

        // System.out.print("Enter Password: ");
        // String input_password = scan.nextLine();

        // UserData.authenticateUser(input_username, input_password);

        // Input 1
        // String ISBN = "978-0262033848";
        // String book_title = "Introduction to Algorithms";
        // String edition = "3rd Edition";
        // String book_author = "Thomas H. Cormen, Charles E. Leiserson, Ronald L. Rivest, Clifford Stein";
        // String publisher = "The MIT Press";
        // int year_published = 2009;
        // int pages = 1312;
        // String date_acquired = "20240110"; // January 10, 2024
        // String call_number = "QA76.6 .I5858 2009";
        // List<String> genres = Arrays.asList("Algorithms", "Computer Science");
        // List<String> tags = Arrays.asList("Data Structures", "Algorithms", "MIT", "CLRS");
        
        // Input 2
        String ISBN = "978-0134767246";
        String book_title = "Algorithms, Part I";
        String edition = "1st Edition";
        String book_author = "Robert Sedgewick, Kevin Wayne";
        String publisher = "Addison-Wesley";
        int year_published = 2019;
        int pages = 400;
        String date_acquired = "20240215"; // February 15, 2024
        String call_number = "QA76.6 .S4235 2019";
        List<String> genres = Arrays.asList("Algorithms", "Computer Science");
        List<String> tags = Arrays.asList("Data Structures", "Algorithms", "Princeton", "Coursera");
        String course = "Computer Science";
        String status = "Available";

        LibraryFunctions.addBooksTODB(ISBN, book_title, edition, book_author, publisher, year_published, pages, date_acquired, call_number, genres, tags, course, status);




    }

    //function connected to the private getConnected function
    public static Connection getConnection(){
        return getConnected();
    }

    private static Connection getConnected() {
        // Corrected URL, username, and password
        String url = "jdbc:mysql://sql12.freesqldatabase.com:3306/sql12767889?zeroDateTimeBehavior=CONVERT_TO_NULL";
        String username = "sql12767889";
        String password = "iQz13TG7uL";
        
        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
/*
    To Access MYSQL in XAMPP or TERMINAL
    use mysql -h [hostname]-u [username]-p 

    USE:
    mysql -h sql12.freesqldatabase.com -u sql12767889 -p

    PASS:
    iQz13TG7uL
    */
