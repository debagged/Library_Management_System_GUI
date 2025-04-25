package com.mycompany.library.ui.mainpage;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import static com.mycompany.library.ui.mainpage.OLD_LibraryLogInPage.mainFrame;
import com.mycompany.library.ui.styles.ComponentStyles;
import com.mycompany.library.users.UserData;

public class OLD_LibraryRegisterPage implements ActionListener, MouseListener{

    ComponentStyles.CustomRoundedButton registerButton = new ComponentStyles.CustomRoundedButton("Register");
    JTextField usernameField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JPasswordField confirmPasswordField = new JPasswordField();
    
    JLabel usernameLabel = new JLabel("Username:");
    JLabel passwordLabel = new JLabel("Password:");
    JLabel confirmPasswordLabel = new JLabel("Confirm Password:");
    JLabel emptyUsernameMessageLabel = new JLabel();
    JLabel emptyPasswordMessageLabel = new JLabel();
    JLabel emptyConfirmPasswordMessageLabel = new JLabel();
    JLabel matchPasswordMessageLabel = new JLabel();
    
    JPanel registerFieldPanel = new JPanel();
    JLayeredPane registerField = new JLayeredPane();
    
    JLabel haveAccount1 = new JLabel("Already have an Account?");
    static JLabel haveAccount2 = new JLabel("Log in");
    JLabel haveAccountLine = new JLabel("_____");
    
    public OLD_LibraryRegisterPage(){
        
        //--------RIGHT OF MAIN PANEL (RESET PASSWORD FIELD) (1/2)---------- //
        registerFieldPanel.setPreferredSize(new Dimension(350,470));
        registerFieldPanel.setOpaque(false);
        registerFieldPanel.setBackground(Color.decode("#182c25"));
        registerFieldPanel.setLayout(null);
        
        registerField.setBounds(0,0,350,460);
        
        ComponentStyles.RoundedPanel registerFieldContainer = new ComponentStyles.RoundedPanel(20);
        registerFieldContainer.setBackground(Color.decode("#E8F1DC"));
        
        ComponentStyles.RoundedPanel registerContainerHeader = new ComponentStyles.RoundedPanel(20);
        registerContainerHeader.setBackground(Color.decode("#123524"));
        //------------------------------------------------------------------ //
        
        //------------------RESET PASSWORD FIELD HEADER--------------------- //
        JLabel resetPass = new JLabel("Register");
        resetPass.setForeground(Color.white);
        resetPass.setFont(new Font("Calibri", Font.PLAIN,26));
        
        registerContainerHeader.setBounds(50,15,120,38);
        registerContainerHeader.add(resetPass);
        
        registerFieldContainer.setBounds(20,40,310,390);
        registerFieldContainer.setLayout(null);
        
        registerField.add(registerFieldContainer, Integer.valueOf(0));
        registerField.add(registerContainerHeader, Integer.valueOf(1));
        //------------------------------------------------------------------ //
        
        //--------RIGHT OF MAIN PANEL (RESET PASSWORD FIELD) (2/2)---------- //
        usernameLabel.setBounds(30,30,100,25);
        usernameLabel.setForeground(Color.decode("#404737"));
        usernameLabel.setFont(new Font("Calibri", Font.BOLD, 17));
        
        passwordLabel.setBounds(30,105,120,25);
        passwordLabel.setForeground(Color.decode("#404737"));
        passwordLabel.setFont(new Font("Calibri", Font.BOLD, 17));
        
        confirmPasswordLabel.setBounds(30,185,170,25);
        confirmPasswordLabel.setForeground(Color.decode("#404737"));
        confirmPasswordLabel.setFont(new Font("Calibri", Font.BOLD, 17));
        
        emptyUsernameMessageLabel.setBounds(30,85,225,15);
        emptyUsernameMessageLabel.setForeground(Color.decode("#BE3144"));
        emptyUsernameMessageLabel.setFont(new Font(null, Font.ITALIC, 11));
        
        emptyPasswordMessageLabel.setBounds(30,160,225,15);
        emptyPasswordMessageLabel.setForeground(Color.decode("#BE3144"));
        emptyPasswordMessageLabel.setFont(new Font(null, Font.ITALIC, 11));
        
        emptyConfirmPasswordMessageLabel.setBounds(30,240,225,15);
        emptyConfirmPasswordMessageLabel.setForeground(Color.decode("#BE3144"));
        emptyConfirmPasswordMessageLabel.setFont(new Font(null, Font.ITALIC, 11));
        
        matchPasswordMessageLabel.setBounds(30,240,225,15);
        matchPasswordMessageLabel.setForeground(Color.decode("#BE3144"));
        matchPasswordMessageLabel.setFont(new Font(null, Font.ITALIC, 11));
        
        usernameField.setBounds(30,50,250,35);
        usernameField.setBackground(Color.decode("#667860"));
        usernameField.setForeground(Color.decode("#E8F1DC"));
        usernameField.setCaretColor(Color.white);
        usernameField.setBorder(new EmptyBorder(5,10,0,0));
        usernameField.setFont(new Font("Calibri", Font.PLAIN, 17));
        
        passwordField.setBounds(30,125,250,35);
        passwordField.setBorder(new EmptyBorder(5,10,5,0));
        passwordField.setBackground(Color.decode("#667860"));
        passwordField.setForeground(Color.decode("#E8F1DC"));
        passwordField.setCaretColor(Color.white);
        passwordField.setFont(new Font(null, Font.PLAIN, 17));
        
        confirmPasswordField.setBounds(30,205,250,35);
        confirmPasswordField.setBorder(new EmptyBorder(5,10,5,0));
        confirmPasswordField.setBackground(Color.decode("#667860"));
        confirmPasswordField.setForeground(Color.decode("#E8F1DC"));
        confirmPasswordField.setCaretColor(Color.white);
        confirmPasswordField.setFont(new Font(null, Font.PLAIN, 17));
        
        registerButton.setBounds(30,280,250,45);
        registerButton.setFocusable(false);
        registerButton.setFont(new Font("Calibri", Font.BOLD, 21));
        registerButton.setForeground(Color.white);
        registerButton.setBackground(Color.decode("#123524"));
        registerButton.addActionListener(this);
        registerButton.addMouseListener(this);
        
        haveAccount1.setBounds(85, 335, 150, 15);
        haveAccount1.setForeground(Color.decode("#123524"));
        haveAccount1.setFont(new Font(null, Font.BOLD, 12));
        
        haveAccount2.setBounds(135, 350, 40, 15);
        haveAccount2.setForeground(Color.decode("#123524"));
        haveAccount2.setFont(new Font(null, Font.BOLD, 12));
        haveAccount2.addMouseListener(this);
        
        haveAccountLine.setBounds(135, 350, 40, 15);
        haveAccountLine.setForeground(Color.decode("#123524"));
        haveAccountLine.setFont(new Font(null, Font.BOLD, 12));
        //----------------------------------------------------------------- //
        
        //===================================================================//
        //-----------------------ADDING COMPONENTS-------------------------- //
        //===================================================================//
        registerFieldContainer.add(usernameLabel);
        registerFieldContainer.add(passwordLabel);
        registerFieldContainer.add(confirmPasswordLabel);
        registerFieldContainer.add(emptyUsernameMessageLabel);
        registerFieldContainer.add(emptyPasswordMessageLabel);
        registerFieldContainer.add(emptyConfirmPasswordMessageLabel);
        registerFieldContainer.add(matchPasswordMessageLabel);
        registerFieldContainer.add(usernameField);
        registerFieldContainer.add(passwordField);
        registerFieldContainer.add(confirmPasswordField);
        registerFieldContainer.add(registerButton);
        registerFieldContainer.add(haveAccount1);
        registerFieldContainer.add(haveAccount2);
        registerFieldContainer.add(haveAccountLine);
        
        //------------------------------------------------------------------ //
    }

    @Override
    public void actionPerformed(ActionEvent e){
        
        UserData userData = new UserData();
        
        String username = usernameField.getText();
        String password = String.valueOf(passwordField.getPassword());
        String confirmPass = String.valueOf(confirmPasswordField.getPassword());
        
        if(e.getSource()==registerButton){
            emptyUsernameMessageLabel.setText(null);
            emptyPasswordMessageLabel.setText(null);
            emptyConfirmPasswordMessageLabel.setText(null);
            matchPasswordMessageLabel.setText(null);
            
            if(username.isEmpty()){
                emptyUsernameMessageLabel.setText("Please enter username");
                return;
            }
            
            if(password.isEmpty()){
                emptyPasswordMessageLabel.setText("Please enter password");
                return;
            }
            
            if(confirmPass.isEmpty()){
                emptyConfirmPasswordMessageLabel.setText("Please confirm password");
                return;
            }
            
            if(password.equals(confirmPass)){
                userData.saveDataToFile(username, password);
                
                JOptionPane.showMessageDialog(OLD_LibraryLogInPage.mainFrame, "Registration Successful", "Registered", JOptionPane.PLAIN_MESSAGE);
                usernameField.setText(null);
                passwordField.setText(null);
                confirmPasswordField.setText(null);
                usernameField.requestFocusInWindow();
                
            } else{
                matchPasswordMessageLabel.setText("Passwords must match");
            }
        } 
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        
        CardLayout cl = (CardLayout) OLD_LibraryLogInPage.logInFieldPanel.getLayout();
        
        if(e.getSource()==haveAccount2){
            emptyUsernameMessageLabel.setText(null);
            emptyPasswordMessageLabel.setText(null);
            emptyConfirmPasswordMessageLabel.setText(null);
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
        
        if(e.getSource()==registerButton){
            registerButton.setLocation(registerButton.getX(), registerButton.getY()-2);
        }
        
        if(e.getSource()==haveAccount2){
            haveAccount2.setLocation(haveAccount2.getX(), haveAccount2.getY()-2);
            haveAccountLine.setLocation(haveAccountLine.getX(), haveAccountLine.getY()-2);
        }
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
        if(e.getSource()==registerButton){
            registerButton.setLocation(registerButton.getX(), registerButton.getY()+2);
        }
        
        if(e.getSource()==haveAccount2){
            haveAccount2.setLocation(haveAccount2.getX(), haveAccount2.getY()+2);
            haveAccountLine.setLocation(haveAccountLine.getX(), haveAccountLine.getY()+2);
        }
    }
    
    public static void main(String[] args){
        new OLD_LibraryRegisterPage();
    }

}
