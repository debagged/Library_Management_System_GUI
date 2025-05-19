package com.mycompany.library.users;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;

import javax.swing.JOptionPane;

import com.mycompany.library.database.LibraryDatabase;

public class UserData{

    static Connection connect = LibraryDatabase.getConnection(); // Direct access

    public static boolean registerUserDataToDB(String user_ID, String given_name, String middle_name, String last_name, String gender, String campus_email, String course){
        
        // Checks DB connection
        Connection connect = checkDatabaseConnection();
        if (connect == null) {
            return false;
        }

        try {
            connect.setAutoCommit(false);
            
            String register_query = "INSERT INTO Users (user_ID, given_name, middle_name, last_name, gender, campus_email, course_ID) VALUES (?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement registerStatement = connect.prepareStatement(register_query)){
                String course_ID = courseChecker(course);
    
                // Set the parameter values
                registerStatement.setString(1, user_ID);
                registerStatement.setString(2, given_name);
                registerStatement.setString(3, middle_name);
                registerStatement.setString(4, last_name);
                registerStatement.setString(5, gender);
                registerStatement.setString(6, campus_email);
                registerStatement.setString(7, course_ID);
    
                // Execute the prepared statementz`
                registerStatement.executeUpdate();
            }
            
            connect.commit();
            return true;

             
        } catch (SQLException e) {
            try {
                connect.rollback();
                e.printStackTrace();
                return false;
            } catch (SQLException rollback) {
                rollback.printStackTrace();
                return false;
            }
        } finally {
            try {
                connect.setAutoCommit(true);
                connect.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean registerUserLoginToDB(String user_ID, String username, String password){
        // Checks DB connection
        Connection connect = checkDatabaseConnection();
        if (connect == null) {
            return false;
        }

        String hashedPassword = hashPassword(password);

        try {
            connect.setAutoCommit(false);

            String login_query = "INSERT INTO Login (user_ID, username, password) VALUES (?, ?, ?)";
            try(PreparedStatement login_statement = connect.prepareStatement(login_query)){
                login_statement.setString(1, user_ID);
                login_statement.setString(2, username);
                login_statement.setString(3, hashedPassword);
    
                // Execute the prepared statement
                login_statement.executeUpdate();
            }
            
            connect.commit();
            return true;

             
        } catch (SQLException e) {
            try {
                connect.rollback();
            } catch (SQLException rollback) {
                rollback.printStackTrace();
            }
            e.printStackTrace();
            return false;

        } finally {
            try {
                connect.setAutoCommit(true);
                connect.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean authenticateUser(String inputUsername, String inputPassword) {
        Connection connection = LibraryDatabase.getConnection();
        if (connection == null) {
            return false; // Connection failed
        }
  
        String inputHashedPassword = hashPassword(inputPassword); // Hash the input password
        try {
            String sql = "SELECT password FROM Login WHERE username = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, inputUsername);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String storedPassword = resultSet.getString("password");

                if(storedPassword.equals(inputHashedPassword)) return true;

                //System.out.println("User Login Successfully");

                //return storedPassword.equals(inputHashedPassword); // Compare hashes
            }

            //System.out.println("User not found");
            return false; // User not found

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean resetPassword(String username, String confirmPassword) {
        Connection connection = LibraryDatabase.getConnection();
        if (connection == null) return false; // Connection failed

        String query = "UPDATE Login SET password = ? WHERE username = ?";
        String inputHashedPassword = hashPassword(confirmPassword);
        
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            
            stmt.setString(1, inputHashedPassword);
            stmt.setString(2, username);
            
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                return true; //password updated
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    
        return false; //uname not found
    }

    String filePath = "src/main/resources/UserData_Log_File.txt";

    public void saveDataToFile(String user_name, String password){
        try (FileWriter fw = new FileWriter(filePath, true);
                PrintWriter pw = new PrintWriter(fw)) {
                    pw.println(user_name + ":" + password);
                    pw.println("Role: Student");
                    pw.println("=====================");
                } catch (IOException e) {}       
    }

    public boolean readDataFromFile(String username, String password) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts[0].equals(String.valueOf(username))&& parts[1].equals(String.valueOf(password))) {
                    return true;
                }
            }
            return false; // Login failed
        } catch(IOException e){}
        return false;
    }
    
    public String roleValidation(String username, String password) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            //String fileRole;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(":");
                
                if (parts[0].equals(String.valueOf(username)) && parts[1].equals(String.valueOf(password))) {
                    String roleLine = br.readLine();
                    if (roleLine.startsWith("Role:")) {
                        return roleLine.split(":")[1].trim(); // Extract role of User
                    }
                }
            }
        } catch(IOException e){}
        return null;
    }

    // WITH DB PROPERTY //

    public static Connection checkDatabaseConnection(){
        Connection connect = LibraryDatabase.getConnection();
        if (connect == null){
            JOptionPane.showMessageDialog(null, "Database is not connected. Please try again", "Connection Error", JOptionPane.INFORMATION_MESSAGE);
        }
        return connect;
    }

    public static String courseChecker(String course){
        Connection connect = checkDatabaseConnection(); 
        
        String course_ID = null;
        try {
            String checkCourseSQL = "SELECT course_ID FROM Courses WHERE course_name = ?";
            PreparedStatement courseStmt = connect.prepareStatement(checkCourseSQL);
            courseStmt.setString(1, course);
            ResultSet courseResult = courseStmt.executeQuery();
                

            if (courseResult.next()) {
                // Course exists, get its ID
                course_ID = courseResult.getString("course_ID");
            }
            else{
                System.out.println("Chosen Course / Program is not currently avaibable at Our Lady Of Fatima University - Laguna Campus");
            }

        } catch (SQLException err) {
            err.printStackTrace();
        }
        return course_ID;
    }

    public static boolean isUserIDExisting(String user_ID){

        String userID_query = "SELECT * FROM Users WHERE user_ID = ?";
        try {
            PreparedStatement user_ID_checker = connect.prepareStatement(userID_query);

            user_ID_checker.setString(1, user_ID);
            ResultSet checkedID = user_ID_checker.executeQuery();

            if (checkedID.next()) {
                // User exists, get its ID
                String userID = checkedID.getString("user_ID");
                if (userID.equals(user_ID)) return true;
            }
            else{
                return false;
            }

        } catch (Exception e) {}
        
        return false;
    }

    public static String getStudID(String username){
        String getID_query = "SELECT user_ID from Login WHERE username = ?";

        try{
            PreparedStatement getUserID = connect.prepareStatement(getID_query);

            getUserID.setString(1, username);
            ResultSet ID = getUserID.executeQuery();

            if (ID.next()){
                String studID = ID.getString("user_ID");
                return studID;
            }
        } catch (Exception e){}

        return null;
    } 

    private static String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes());
            return Base64.getEncoder().encodeToString(hash); // Convert to Base64 for easier storage
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean isEmailValid(String given_name, String middle_name, String last_name, String user_ID, String campus_email){

        String firstG = String.valueOf(given_name.toLowerCase().trim().charAt(0));  // First char of given name
        String firstM;
            if (middle_name.trim().isEmpty()) { 
                firstM = "";  // Assign null character if no middle name (or use a placeholder)
            } 
            else {
                firstM = String.valueOf(middle_name.trim().toLowerCase().charAt(0)); // Get first letter
            }
        String lastName = last_name.trim().toLowerCase().replaceAll("\\s+", "");
        String lastFourID = user_ID.substring(user_ID.length() - 4);
        String emailTemplate = "lag@student.fatima.edu.ph";

        String emailChecker = "" + firstG + firstM + lastName + lastFourID + emailTemplate;

        if (campus_email.toLowerCase().equals(emailChecker)){
            return true;
        }
        else
            return false;
    }
    
}


