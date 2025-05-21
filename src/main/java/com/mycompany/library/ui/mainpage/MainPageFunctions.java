package com.mycompany.library.ui.mainpage;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.mycompany.library.ui.student.StudentPage;
import com.mycompany.library.users.UserData;

public class MainPageFunctions {
    
    //-------------------------------------FORGOT PASS PAGE------------------------------------------//

    protected static void resetValidation(){
        ForgotPassPage.emptyUnameMessage.setText(null);
        ForgotPassPage.emptyPassMessage.setText(null);
        ForgotPassPage.emptyConfirmPassMessage.setText(null);

        java.awt.Color defaultColor = java.awt.Color.decode("#667961");

        ForgotPassPage.unameField.setBorderColor(defaultColor);
        ForgotPassPage.passField.setBorderColor(defaultColor);
        ForgotPassPage.confirmPassField.setBorderColor(defaultColor);
    }

    protected static boolean validateInput(String uname, String pass, String confirmPass){

        if(uname.isBlank()){
            showError(ForgotPassPage.unameField, ForgotPassPage.emptyUnameMessage, "please enter your username");
            return false;
        }

        if(pass.isBlank()){
            showError(ForgotPassPage.passField, ForgotPassPage.emptyPassMessage, "please enter your new password");
            return false;
        }

        if(confirmPass.isBlank()){
            showError(ForgotPassPage.confirmPassField, ForgotPassPage.emptyConfirmPassMessage, "please confirm your password");
            return false;
        }

        if(uname.equals("admin") || uname.equals("Admin")){
            showError(ForgotPassPage.unameField, ForgotPassPage.emptyUnameMessage, "Invalid Input");
            return false;
        }

        if(!pass.equals(confirmPass)){
            showError(ForgotPassPage.passField, ForgotPassPage.emptyPassMessage, "passwords must match");

            showError(ForgotPassPage.confirmPassField, ForgotPassPage.emptyConfirmPassMessage, "passwords must match");
            return false;

        }
        return true;
    }

    protected static void showSuccess(){

        JOptionPane.showMessageDialog(ForgotPassPage.jPanel2, "Password successfully reset!");
        ForgotPassPage.unameField.setText(null);
        ForgotPassPage.passField.setText(null);
        ForgotPassPage.confirmPassField.setText(null);
        ForgotPassPage.unameField.requestFocusInWindow();
    }

    protected static void showError(JTextField field, JLabel messageLabel, String message) {
        messageLabel.setText(message);
        if (field instanceof custom.components.RoundedTextField){
            ((custom.components.RoundedTextField) field).setBorderThickness(2);
            ((custom.components.RoundedTextField) field).setBorderColor(new java.awt.Color(204, 0, 0));
        }

        if (field instanceof custom.components.RoundedPasswordField){
            ((custom.components.RoundedPasswordField) field).setBorderThickness(2);
            ((custom.components.RoundedPasswordField) field).setBorderColor(new java.awt.Color(204, 0, 0));
        }
    }

    protected static void resetPass(){

        String uname = ForgotPassPage.unameField.getText();
        String pass = String.valueOf(ForgotPassPage.passField.getPassword());
        String confirmPass = String.valueOf(ForgotPassPage.confirmPassField.getPassword());

        resetValidation();

        if(!MainPageFunctions.validateInput(uname, pass, confirmPass)){ return; }

        if(!UserData.resetPassword(uname, confirmPass)){
            showError(ForgotPassPage.unameField, ForgotPassPage.emptyUnameMessage, "username not found");
            return;
        }

        MainPageFunctions.showSuccess();
    }

    //------------------------------------------------------------------------------------------------------//

    //---------------------------------------LOG IN PAGE----------------------------------------------------//

    protected static void resetFields(){
        LogInPage.emptyUnameMessage.setText(null);
        LogInPage.emptyPassMessage.setText(null);
        LogInPage.invalidLogInMessage.setText(null);

        LogInPage.unameField.setBorderColor(java.awt.Color.decode("#667961"));
        LogInPage.passField.setBorderColor(java.awt.Color.decode("#667961"));

    }

    protected static void emptyFieldError(JTextField field, javax.swing.JLabel messageLabel, String message ){
        messageLabel.setText(message);
        if(field instanceof custom.components.RoundedTextField){
            ((custom.components.RoundedTextField)field).setBorderColor(new java.awt.Color(204,0,0));
             ((custom.components.RoundedTextField)field).setBorderThickness(2);
        
        } else if(field instanceof custom.components.RoundedPasswordField){
            ((custom.components.RoundedPasswordField)field).setBorderColor(new java.awt.Color(204,0,0));
             ((custom.components.RoundedPasswordField)field).setBorderThickness(2);
        }
    }

    protected static void borderError(JTextField field){
        if(field instanceof custom.components.RoundedTextField){
            ((custom.components.RoundedTextField)field).setBorderColor(new java.awt.Color(204,0,0));
             ((custom.components.RoundedTextField)field).setBorderThickness(2);
        
        } else if(field instanceof custom.components.RoundedPasswordField){
            ((custom.components.RoundedPasswordField)field).setBorderColor(new java.awt.Color(204,0,0));
             ((custom.components.RoundedPasswordField)field).setBorderThickness(2);
        }
    }

    protected static String signIn(){

        String uname = LogInPage.unameField.getText();
        String pass = String.valueOf(LogInPage.passField.getPassword());
        
        MainPageFunctions.resetFields();


        if(uname.isBlank()){
            MainPageFunctions.emptyFieldError(LogInPage.unameField, LogInPage.emptyUnameMessage, "please enter your username");
            return null;
        }

        if(pass.isBlank()){
            MainPageFunctions.emptyFieldError(LogInPage.passField, LogInPage.emptyPassMessage, "please enter your password");
            return null;
        }
        
        if(UserData.authenticateUser(uname, pass)){

            boolean isAdmin = uname.equals("admin");
            if(isAdmin && UserData.isUserIDExisting("Admin")){
                JOptionPane.showMessageDialog(null, "Welcome Admin!");
                return "Admin";

            } else{
                JOptionPane.showMessageDialog(null, "Welcome Student!");
                StudentPage.userID = UserData.getStudID(uname);
                return uname;
            }

        }else{
            LogInPage.invalidLogInMessage.setText("Username/Password not found");
            MainPageFunctions.borderError(LogInPage.unameField);
            MainPageFunctions.borderError(LogInPage.passField);
        }

        return null;
    }

    //-----------------------------------------------------------------------------------------------------//
    
    //-------------------------------------REGISTER PAGE---------------------------------------------------//

    protected static boolean validateRegisterInput(String uname, String pass, String confirmPass){
        if(uname.isBlank()){
            MainPageFunctions.emptyFieldError(RegisterPage2.newUnameField, RegisterPage2.emptyUnameMessage,"please enter your username");
            return false;
        }

        if(pass.isBlank()){
            MainPageFunctions.emptyFieldError(RegisterPage2.newPassField, RegisterPage2.emptyNewPassMessage, "please enter your password");
            return false;
        }

        if(confirmPass.isBlank()){
            MainPageFunctions.emptyFieldError(RegisterPage2.confirmNewPassField, RegisterPage2.emptyConfirmPassMessage, "please confirm your password");
            return false;
        }

        if(!pass.equals(confirmPass)){
            MainPageFunctions.emptyFieldError(RegisterPage2.newPassField, RegisterPage2.emptyNewPassMessage, "passwords must match");
            MainPageFunctions.emptyFieldError(RegisterPage2.confirmNewPassField, RegisterPage2.emptyConfirmPassMessage, "passwords must match");
            return false;
        }

        return true;
    }

    protected static void resetRegisterValidation(){
        RegisterPage2.emptyUnameMessage.setText(null);
        RegisterPage2.emptyNewPassMessage.setText(null);
        RegisterPage2.emptyConfirmPassMessage.setText(null);
        RegisterPage2.newUnameField.setBorderColor(java.awt.Color.decode("#667961"));
        RegisterPage2.newPassField.setBorderColor(java.awt.Color.decode("#667961"));
        RegisterPage2.confirmNewPassField.setBorderColor(java.awt.Color.decode("#667961"));
    }

    protected static void showRegisterSuccess(){
        JOptionPane.showMessageDialog(RegisterPage2.instance, "Successfully registered!");
        RegisterPage2.newUnameField.setText(null);
        RegisterPage2.newPassField.setText(null);
        RegisterPage2.confirmNewPassField.setText(null);
        resetRegisterValidation();
        RegisterPage2.instance.dispose();
        new LogInPage().setVisible(true);
    }

    protected static void registerUser(){

        String username = RegisterPage2.newUnameField.getText().trim();
        String pass = String.valueOf(RegisterPage2.newPassField.getPassword());
        String confirmPass = String.valueOf(RegisterPage2.confirmNewPassField.getPassword());
        String userID = RegisterPage.studIDField.getText().trim();
        resetRegisterValidation();

        if(!validateRegisterInput(username, pass, confirmPass)){ return; }

        if(UserData.registerUserLoginToDB(userID, username, confirmPass)){
            showRegisterSuccess();
            return;
        }else{
            JOptionPane.showMessageDialog(RegisterPage2.instance, "Register Failed!");
        }
    }

}
