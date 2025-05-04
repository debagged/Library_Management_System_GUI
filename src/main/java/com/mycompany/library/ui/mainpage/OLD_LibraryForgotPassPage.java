package com.mycompany.library.ui.mainpage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.mycompany.library.ui.styles.ComponentStyles;
import com.mycompany.library.users.UserData;

import static com.mycompany.library.ui.mainpage.OLD_LibraryLogInPage.mainFrame;

public class OLD_LibraryForgotPassPage implements ActionListener, MouseListener{
    
    ComponentStyles.CustomRoundedButton resetPassButton = new ComponentStyles.CustomRoundedButton("Reset Password");
    JTextField usernameField = new JTextField();
    JPasswordField newPasswordField = new JPasswordField();
    JPasswordField confirmNewPasswordField = new JPasswordField();
    JLabel usernameLabel = new JLabel("Username:");
    JLabel newPasswordLabel = new JLabel("New Password:");
    JLabel confirmNewPasswordLabel = new JLabel("Confirm New Password:");
    JLabel emptyUsernameMessageLabel = new JLabel();
    JLabel emptyNewPasswordMessageLabel = new JLabel();
    JLabel emptyConfirmNewPasswordMessageLabel = new JLabel();
    JLabel matchPasswordMessageLabel = new JLabel();

    JPanel resetPassFieldPanel = new JPanel();
    JLayeredPane resetPassField = new JLayeredPane();
    
    static JLabel signIn = new JLabel("Sign In");
    JLabel signInLine = new JLabel("_______");
    
    
    
    public OLD_LibraryForgotPassPage(){
        
        //--------RIGHT OF MAIN PANEL (RESET PASSWORD FIELD) (1/2)---------- //
        resetPassFieldPanel.setPreferredSize(new Dimension(350,470));
        resetPassFieldPanel.setOpaque(false);
        resetPassFieldPanel.setBackground(Color.decode("#182c25"));
        resetPassFieldPanel.setLayout(null);
        
        resetPassField.setBounds(0,0,350,460);
        
        ComponentStyles.RoundedPanel resetPassFieldContainer = new ComponentStyles.RoundedPanel(20);
        resetPassFieldContainer.setBackground(Color.decode("#E8F1DC"));
        
        ComponentStyles.RoundedPanel resetPassContainerHeader = new ComponentStyles.RoundedPanel(20);
        resetPassContainerHeader.setBackground(Color.decode("#123524"));
        //------------------------------------------------------------------ //
        
        //------------------RESET PASSWORD FIELD HEADER--------------------- //
        JLabel resetPass = new JLabel("Reset Password");
        resetPass.setForeground(Color.white);
        resetPass.setFont(new Font("Calibri", Font.PLAIN,26));
        
        resetPassContainerHeader.setBounds(50,15,190,38);
        resetPassContainerHeader.add(resetPass);
        
        resetPassFieldContainer.setBounds(20,40,310,390);
        resetPassFieldContainer.setLayout(null);
        
        resetPassField.add(resetPassFieldContainer, Integer.valueOf(0));
        resetPassField.add(resetPassContainerHeader, Integer.valueOf(1));
        //------------------------------------------------------------------ //
        
        //--------RIGHT OF MAIN PANEL (RESET PASSWORD FIELD) (1/2)---------- //
        usernameLabel.setBounds(30,30,100,25);
        usernameLabel.setForeground(Color.decode("#404737"));
        usernameLabel.setFont(new Font("Calibri", Font.BOLD, 17));
        
        newPasswordLabel.setBounds(30,105,120,25);
        newPasswordLabel.setForeground(Color.decode("#404737"));
        newPasswordLabel.setFont(new Font("Calibri", Font.BOLD, 17));
        
        confirmNewPasswordLabel.setBounds(30,185,170,25);
        confirmNewPasswordLabel.setForeground(Color.decode("#404737"));
        confirmNewPasswordLabel.setFont(new Font("Calibri", Font.BOLD, 17));
        
        emptyUsernameMessageLabel.setBounds(30,85,225,15);
        emptyUsernameMessageLabel.setForeground(Color.decode("#BE3144"));
        emptyUsernameMessageLabel.setFont(new Font(null, Font.ITALIC, 11));
        
        emptyNewPasswordMessageLabel.setBounds(30,160,225,15);
        emptyNewPasswordMessageLabel.setForeground(Color.decode("#BE3144"));
        emptyNewPasswordMessageLabel.setFont(new Font(null, Font.ITALIC, 11));
        
        emptyConfirmNewPasswordMessageLabel.setBounds(30,240,225,15);
        emptyConfirmNewPasswordMessageLabel.setForeground(Color.decode("#BE3144"));
        emptyConfirmNewPasswordMessageLabel.setFont(new Font(null, Font.ITALIC, 11));
        
        matchPasswordMessageLabel.setBounds(30,240,225,15);
        matchPasswordMessageLabel.setForeground(Color.decode("#BE3144"));
        matchPasswordMessageLabel.setFont(new Font(null, Font.ITALIC, 11));
        
        usernameField.setBounds(30,50,250,35);
        usernameField.setBackground(Color.decode("#667860"));
        usernameField.setForeground(Color.decode("#E8F1DC"));
        usernameField.setCaretColor(Color.white);
        usernameField.setBorder(new EmptyBorder(5,10,0,0));
        usernameField.setFont(new Font("Calibri", Font.PLAIN, 17));
        
        newPasswordField.setBounds(30,125,250,35);
        newPasswordField.setBorder(new EmptyBorder(5,10,5,0));
        newPasswordField.setForeground(Color.decode("#E8F1DC"));
        newPasswordField.setBackground(Color.decode("#667860"));
        newPasswordField.setCaretColor(Color.white);
        newPasswordField.setFont(new Font(null, Font.PLAIN, 17));
        
        confirmNewPasswordField.setBounds(30,205,250,35);
        confirmNewPasswordField.setBorder(new EmptyBorder(5,10,5,0));
        confirmNewPasswordField.setBackground(Color.decode("#667860"));
        confirmNewPasswordField.setForeground(Color.decode("#E8F1DC"));
        confirmNewPasswordField.setCaretColor(Color.white);
        confirmNewPasswordField.setFont(new Font(null, Font.PLAIN, 17));
        
        resetPassButton.setBounds(30,280,250,45);
        resetPassButton.setFont(new Font("Calibri", Font.BOLD, 21));
        resetPassButton.setForeground(Color.white);
        resetPassButton.setBackground(Color.decode("#123524"));
        resetPassButton.addActionListener(this);
        resetPassButton.setFocusable(false);
        resetPassButton.addMouseListener(this);
        
        signIn.setBounds(130, 335, 55, 20);
        signIn.setForeground(Color.decode("#123524"));
        signIn.setFont(new Font(null, Font.BOLD, 15));
        signIn.addMouseListener(this);
        
        signInLine.setBounds(130, 340, 50, 15);
        signInLine.setForeground(Color.decode("#123524"));
        signInLine.setFont(new Font(null, Font.BOLD, 12));
        //----------------------------------------------------------------- //
        
        //===================================================================//
        //-----------------------ADDING COMPONENTS-------------------------- //
        //===================================================================//
        resetPassFieldContainer.add(usernameLabel);
        resetPassFieldContainer.add(newPasswordLabel);
        resetPassFieldContainer.add(confirmNewPasswordLabel);
        resetPassFieldContainer.add(emptyUsernameMessageLabel);
        resetPassFieldContainer.add(emptyNewPasswordMessageLabel);
        resetPassFieldContainer.add(emptyConfirmNewPasswordMessageLabel);
        resetPassFieldContainer.add(matchPasswordMessageLabel);
        resetPassFieldContainer.add(usernameField);
        resetPassFieldContainer.add(newPasswordField);
        resetPassFieldContainer.add(confirmNewPasswordField);
        resetPassFieldContainer.add(resetPassButton);
        resetPassFieldContainer.add(signIn);
        resetPassFieldContainer.add(signInLine);
        
        //------------------------------------------------------------------ //
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        
        UserData userData = new UserData();
        
        String userName = usernameField.getText();
        String newPass = String.valueOf(newPasswordField.getPassword());
        String confirmNewPass = String.valueOf(confirmNewPasswordField.getPassword());
        
        if(e.getSource()==resetPassButton){
                emptyUsernameMessageLabel.setText(null);
                emptyNewPasswordMessageLabel.setText(null);
                emptyConfirmNewPasswordMessageLabel.setText(null);
                matchPasswordMessageLabel.setText(null);
            
            if(userName.equals("admin")){
                JOptionPane.showMessageDialog(OLD_LibraryLogInPage.mainFrame, "NICE TRY", "OKAY", JOptionPane.PLAIN_MESSAGE);
                return;
            }
            
            if(userName.isEmpty()){
                emptyUsernameMessageLabel.setText("Please enter username");
                return;
            }
            
            if(newPass.isEmpty()){
                emptyNewPasswordMessageLabel.setText("Please enter new password");
                return;
            }
            
            if(confirmNewPass.isEmpty()){
                emptyConfirmNewPasswordMessageLabel.setText("Please confirm new password");
                return;
            }
            
            /* if(userData.checkUsername(userName)){
                
                if(!newPass.equals(confirmNewPass)){
                    matchPasswordMessageLabel.setText("Passwords Must Match");
                    return;
                }
            
                if(userData.forgotPassword(userName, newPass)){
                    JOptionPane.showMessageDialog(OLD_LibraryLogInPage.mainFrame, "New password cannot be the old password", "Same Password", JOptionPane.PLAIN_MESSAGE);
                    return;
                }
                
                JOptionPane.showMessageDialog(OLD_LibraryLogInPage.mainFrame, "Password Reset Successful", "Password Reset", JOptionPane.PLAIN_MESSAGE);
                usernameField.setText(null);
                newPasswordField.setText(null);
                confirmNewPasswordField.setText(null);
                usernameField.requestFocusInWindow();
                return;
            } */
            
            JOptionPane.showMessageDialog(OLD_LibraryLogInPage.mainFrame, "Username Not Found", "Username Not Found", JOptionPane.PLAIN_MESSAGE);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        CardLayout cl = (CardLayout) OLD_LibraryLogInPage.logInFieldPanel.getLayout();
        
        if(e.getSource()==signIn){
            emptyUsernameMessageLabel.setText(null);
            emptyNewPasswordMessageLabel.setText(null);
            emptyConfirmNewPasswordMessageLabel.setText(null);
            matchPasswordMessageLabel.setText(null);
            mainFrame.setTitle("Log In");
            cl.show(OLD_LibraryLogInPage.logInFieldPanel, "LogIn");
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
        if(e.getSource()==resetPassButton){
            resetPassButton.setLocation(resetPassButton.getX(), resetPassButton.getY()-2);
        }
        
        if(e.getSource()==signIn){
            signIn.setLocation(signIn.getX(), signIn.getY()-2);
            signInLine.setLocation(signInLine.getX(), signInLine.getY()-2);
        }
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
        if(e.getSource()==resetPassButton){
            resetPassButton.setLocation(resetPassButton.getX(), resetPassButton.getY()+2);
        }
        
        if(e.getSource()==signIn){
            signIn.setLocation(signIn.getX(), signIn.getY()+2);
            signInLine.setLocation(signInLine.getX(), signInLine.getY()+2);
        }
    }
    
    public static void main(String[] args){
        new OLD_LibraryForgotPassPage();
    }

}
