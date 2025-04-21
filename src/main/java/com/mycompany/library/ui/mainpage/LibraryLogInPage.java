package com.mycompany.library.ui.mainpage;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.mycompany.library.ui.admin.AdminPage;
import com.mycompany.library.ui.student.StudentPage;
import com.mycompany.library.ui.styles.ComponentStyles;
import com.mycompany.library.users.UserData;

public class LibraryLogInPage implements KeyListener, MouseListener{
    
    public static JFrame mainFrame = new JFrame();
    
    ComponentStyles.CustomRoundedButton loginButton = new ComponentStyles.CustomRoundedButton("Sign In");
    JTextField usernameField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JLabel usernameLabel = new JLabel("Username:");
    JLabel passwordLabel = new JLabel("Password:");
    JLabel invalidMessageLabel = new JLabel();
    JLabel emptyUsernameMessageLabel = new JLabel();
    JLabel emptyPasswordMessageLabel = new JLabel();
    JLabel headerLabel = new JLabel("TEST");
    
    JPanel headerPanel = new JPanel();
    JPanel leftPanel = new JPanel();
    JPanel rightPanel = new JPanel();
    JPanel footerPanel = new JPanel();
    JPanel centerPanel = new JPanel();
    
    JPanel titlePanel = new JPanel();
    static JPanel logInFieldPanel = new JPanel();
    
    //JLabel register1 = new JLabel("Don't have an account?");
    //JLabel register1Line = new JLabel("____________________");
    JLabel forgotPass = new JLabel("Forgot Password?");
    JLabel forgotPassLine = new JLabel("______________");
    JLabel register2 = new JLabel("Register");
    JLabel register2Line = new JLabel("_______");
    
    public LibraryLogInPage(){
        
        //===================================================================//
        //---------------------------FRAME SET UP--------------------------- //
        //===================================================================//
        ImageIcon icon = new ImageIcon("src/main/resources/images/logo.pg");
        
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setMinimumSize(new Dimension(800,600));
        mainFrame.setResizable(false);
        mainFrame.setTitle("Log In");
        mainFrame.setIconImage(icon.getImage());
        mainFrame.setLayout(new BorderLayout());
        mainFrame.setLocationRelativeTo(null);
        
        ComponentStyles.BackgroundPanel bgPanel = new ComponentStyles.BackgroundPanel("src/main/resources/images/mainBackground .png");
        bgPanel.setPreferredSize(new Dimension(800,600));
        bgPanel.setLayout(new BorderLayout());
        //--------------------------------------------------------------------//
        
        //----------------------------BORDERS--------------------------------//
        headerPanel.setBackground(Color.decode("#182c25"));
        headerPanel.setOpaque(false);
        headerPanel.setPreferredSize(new Dimension(950,50));
        
        leftPanel.setBackground(Color.decode("#182c25"));
        leftPanel.setOpaque(false);
        leftPanel.setPreferredSize(new Dimension(80,600));
        
        rightPanel.setBackground(Color.decode("#182c25"));
        rightPanel.setOpaque(false);
        rightPanel.setPreferredSize(new Dimension(70,600));
        //------------------------------------------------------------------ //
        
        //----------------------------FOOTER-------------------------------- //
        /*JLabel line2 = new JLabel("______");
        line2.setBounds(80,0,900,20);
        line2.setForeground(Color.white);
        line2.setFont(new Font("Serif", Font.BOLD, 15));*/
        
        JLabel footerDescription = new JLabel();
        footerDescription.setBounds(80,25,900,15);
        footerDescription.setText("OLFU LMS");
        footerDescription.setForeground(Color.white);
        footerDescription.setFont(new Font("Arial", Font.PLAIN, 11));

        /*JLabel footerDescription2 = new JLabel();
        footerDescription2.setBounds(80,40,900,12);
        footerDescription2.setText("specifically for the students and faculty of Our Lady of Fatima University(OLFU)");
        footerDescription2.setForeground(Color.white);
        footerDescription2.setFont(new Font("Arial", Font.PLAIN, 11));*/
        
        footerPanel.setBackground(Color.decode("#182c25"));
        footerPanel.setOpaque(false);
        footerPanel.setLayout(null);
        footerPanel.setPreferredSize(new Dimension(950,60));
        //footerPanel.add(line2);
        footerPanel.add(footerDescription);
        //footerPanel.add(footerDescription2);
        //------------------------------------------------------------------ //
        
        //===================================================================//
        //----------------------------MAIN PANEL---------------------------- //
        //===================================================================//
        centerPanel.setOpaque(false);
        centerPanel.setLayout(new BorderLayout());
        
        //------------------LEFT OF MAIN PANEL (TITLE)---------------------- //
        /*JLabel title = new JLabel();
        title.setBounds(0,100,250,30);
        title.setText("LRC LIBRARY");
        title.setForeground(Color.white);
        title.setFont(new Font("Serif", Font.BOLD, 35));18*/
        
        /*JLabel line = new JLabel("__________________________");
        line.setBounds(0,115,400,30);
        line.setForeground(Color.white);
        line.setFont(new Font("Serif", Font.BOLD, 25));*/
        
        /*JLabel titleDescription = new JLabel();
        titleDescription.setBounds(0,140,250,30);
        titleDescription.setText("OUR LADY OF FATIMA LIBRARY SYSTEM");
        titleDescription.setForeground(Color.white);
        titleDescription.setFont(new Font("Serif", Font.BOLD, 12));18*/

        titlePanel.setLayout(null);
        titlePanel.setPreferredSize(new Dimension(440,400));
        titlePanel.setOpaque(false);
        titlePanel.setBackground(Color.decode("#182c25"));
        //titlePanel.add(title);
        //titlePanel.add(line);
        //titlePanel.add(titleDescription);
        //------------------------------------------------------------------ //
        
        //------------RIGHT OF MAIN PANEL (LOG IN FIELD) (1/2)-------------- //
        logInFieldPanel.setPreferredSize(new Dimension(499,470));
        logInFieldPanel.setOpaque(false);
        logInFieldPanel.setBackground(Color.decode("#182c25"));
        logInFieldPanel.setLayout(new CardLayout());
        
        JLayeredPane logInField = new JLayeredPane();
        logInField.setBounds(0,0,350,460);
        
        ComponentStyles.RoundedPanel logInFieldContainer = new ComponentStyles.RoundedPanel(20);
        logInFieldContainer.setBackground(Color.decode("#E8F1DC"));
        
        //ComponentStyles.RoundedPanel logInContainerHeader = new ComponentStyles.RoundedPanel(20);
        //logInContainerHeader.setBackground(Color.decode("#123524"));
        //------------------------------------------------------------------ //
        
        //----------------------LOG IN FIELD HEADER------------------------- //
        JLabel logIn = new JLabel("Login", SwingConstants.CENTER);
        logIn.setForeground(Color.white);
        logIn.setFont(new Font("Calibri", Font.BOLD,30));
        
        //logInContainerHeader.setBounds(125,15,100,40);
        //logInContainerHeader.add(logIn);
        
        logInFieldContainer.setBounds(35,30,280,420);
        logInFieldContainer.setLayout(null);
        
        logInField.add(logInFieldContainer, Integer.valueOf(0));
        //logInField.add(logInContainerHeader, Integer.valueOf(1));
        //------------------------------------------------------------------ //
        
        //------------RIGHT OF MAIN PANEL (LOG IN FIELD) (2/2)-------------- //
        usernameLabel.setBounds(30,35,80,16);
        usernameLabel.setForeground(Color.decode("#404737"));
        usernameLabel.setFont(new Font("Calibri", Font.BOLD, 11));
        
        passwordLabel.setBounds(30,110,100,16);
        passwordLabel.setForeground(Color.decode("#404737"));
        passwordLabel.setFont(new Font("Calibri", Font.BOLD, 11));
        
        invalidMessageLabel.setBounds(30,170,150,15);
        invalidMessageLabel.setForeground(Color.decode("#BE3144"));
        invalidMessageLabel.setFont(new Font(null, Font.ITALIC, 11));
        
        emptyUsernameMessageLabel.setBounds(112,37,155,15);
        emptyUsernameMessageLabel.setForeground(Color.decode("#BE3144"));
        emptyUsernameMessageLabel.setFont(new Font(null, Font.ITALIC, 11));
        
        emptyPasswordMessageLabel.setBounds(110,112,150,15);
        emptyPasswordMessageLabel.setForeground(Color.decode("#BE3144"));
        emptyPasswordMessageLabel.setFont(new Font(null, Font.ITALIC, 11));
        
        headerLabel.setBounds(150,50,200,35);
        headerLabel.setFont(new Font(null, Font.PLAIN, 30));
        
        usernameField.setBounds(30,60,250,35);
        usernameField.setBackground(Color.decode("#667860"));
        usernameField.setForeground(Color.decode("#E8F1DC"));
        usernameField.setCaretColor(Color.white);
        usernameField.setBorder(new EmptyBorder(5,5,0,0));
        usernameField.setFont(new Font("Calibri", Font.PLAIN, 17));
        usernameField.addKeyListener(this);
        
        passwordField.setBounds(30,135,250,35);
        passwordField.setBorder(new EmptyBorder(5,5,5,0));
        passwordField.setBackground(Color.decode("#667860"));
        passwordField.setForeground(Color.decode("#E8F1DC"));
        passwordField.setCaretColor(Color.white);
        passwordField.setFont(new Font(null, Font.PLAIN, 17));
        passwordField.addKeyListener(this);
        
        loginButton.setBounds(30,225,250,45);
        loginButton.setFocusable(false);
        loginButton.setFont(new Font("Calibri", Font.BOLD, 20));
        loginButton.setForeground(Color.white);
        loginButton.setBackground(Color.decode("#123524"));
        loginButton.setMargin(new Insets(15,0,10,10));
        loginButton.addMouseListener(this);
        
        forgotPass.setBounds(30,200,110,15);
        forgotPass.setForeground(Color.decode("#123524"));
        forgotPass.setFont(new Font(null, Font.BOLD, 13));
        forgotPass.addMouseListener(this);
        
        forgotPassLine.setBounds(30,200,110,15);
        forgotPassLine.setForeground(Color.decode("#123524"));
        forgotPassLine.setFont(new Font(null, Font.BOLD, 12));
        forgotPassLine.setVisible(false);
        
        /*register1.setBounds(85, 300, 150, 15);
        register1.setForeground(Color.decode("#123524"));
        register1.setFont(new Font(null, Font.BOLD, 13));*/
        
        register2.setBounds(135, 320, 55, 15);
        register2.setForeground(Color.decode("#123524"));
        register2.setFont(new Font(null, Font.BOLD, 11));
        register2.addMouseListener(this);
        
        register2Line.setBounds(135, 320, 55, 15);
        register2Line.setForeground(Color.decode("#123524"));
        register2Line.setFont(new Font(null, Font.BOLD, 11));
        register2Line.setVisible(false);
        
        //----------------------------------------------------------------- //
        
        //===================================================================//
        //-----------------------ADDING COMPONENTS-------------------------- //
        //===================================================================//
        logInFieldContainer.add(logIn);
        logInFieldContainer.add(usernameLabel);
        logInFieldContainer.add(passwordLabel);
        logInFieldContainer.add(invalidMessageLabel);
        logInFieldContainer.add(emptyUsernameMessageLabel);
        logInFieldContainer.add(emptyPasswordMessageLabel);
        logInFieldContainer.add(usernameField);
        logInFieldContainer.add(passwordField);
        logInFieldContainer.add(loginButton);
        logInFieldContainer.add(forgotPass);
        logInFieldContainer.add(forgotPassLine);
        //logInFieldContainer.add(register1);
        //logInFieldContainer.add(register1Line);
        logInFieldContainer.add(register2);
        logInFieldContainer.add(register2Line);
        
        centerPanel.add(logInFieldPanel, BorderLayout.EAST);
        centerPanel.add(titlePanel, BorderLayout.WEST);
        
        bgPanel.add(headerPanel, BorderLayout.NORTH);
        bgPanel.add(leftPanel, BorderLayout.WEST);
        bgPanel.add(rightPanel, BorderLayout.EAST);
        bgPanel.add(footerPanel, BorderLayout.SOUTH);
        bgPanel.add(centerPanel, BorderLayout.CENTER);
        
        mainFrame.add(bgPanel, BorderLayout.CENTER);
        
        // ADDING LAYERED PANE TO LOG IN FIELD //
        logInFieldPanel.add(logInField, "LogIn");
        logInFieldPanel.add(new LibraryForgotPassPage().resetPassField, "ForgotPass");
        logInFieldPanel.add(new LibraryRegisterPage().registerField, "Register");
        
        //------------------------------------------------------------------ //
        
        mainFrame.setVisible(true);
    }
    
    private void handleMouseClick(Object e){
        
        CardLayout cl = (CardLayout) logInFieldPanel.getLayout();
        
        if(e == forgotPass) {
            
            emptyUsernameMessageLabel.setText(null);
            emptyPasswordMessageLabel.setText(null);
            invalidMessageLabel.setText(null);
            mainFrame.setTitle("Reset Password");
            cl.show(logInFieldPanel, "ForgotPass");
            
        } else if(e == register2) {
            
            emptyUsernameMessageLabel.setText(null);
            emptyPasswordMessageLabel.setText(null);
            invalidMessageLabel.setText(null);
            mainFrame.setTitle("Register");
            cl.show(logInFieldPanel, "Register");
        }
        
        UserData userData = new UserData();
        
        if(e == loginButton) {
            
            emptyUsernameMessageLabel.setText(null);
            emptyPasswordMessageLabel.setText(null);
            invalidMessageLabel.setText(null);
                
            String username = usernameField.getText();
            String password = String.valueOf(passwordField.getPassword());
            
            if(username.isEmpty()) {
                
                emptyUsernameMessageLabel.setText("Please enter your Username");
                return;
                
            }
            
            if (password.isEmpty()) {
                
                emptyPasswordMessageLabel.setText("Please enter your Password");
                return;
                
            }
            
            if (userData.readDataFromFile(username, password)) {
            
                String role = userData.roleValidation(username, password);
            
                if("Admin".equals(role)) {
                    
                    usernameField.setText(null);
                    passwordField.setText(null);
                    usernameField.requestFocusInWindow();
                    mainFrame.setVisible(false);
                    new AdminPage(username);
            
                } else {
                    
                    usernameField.setText(null);
                    passwordField.setText(null);
                    usernameField.requestFocusInWindow();
                    mainFrame.setVisible(false);
                    new StudentPage(username);
                }
            
            } else {
                emptyUsernameMessageLabel.setText(null);
                emptyPasswordMessageLabel.setText(null);
                invalidMessageLabel.setText("Invalid Passowrd/Username");
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        handleMouseClick(e.getSource());
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
        if(e.getSource()==loginButton) {
            
            loginButton.setLocation(loginButton.getX(), loginButton.getY()-2);
            
        }
        
        if(e.getSource()==forgotPass) {
            
            forgotPassLine.setVisible(true);
            
        }
        
        if(e.getSource()==register2) {
            
            register2.setLocation(register2.getX(), register2.getY()-2);
            register2Line.setLocation(register2Line.getX(), register2Line.getY()-2);
            register2Line.setVisible(true);
            
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
        if(e.getSource()==loginButton) {
            
            loginButton.setLocation(loginButton.getX(), loginButton.getY()+2);
            
        }
        
        if(e.getSource()==forgotPass) { 
            forgotPassLine.setVisible(false);
            
        }
        
        if(e.getSource()==register2) {
            
            register2.setLocation(register2.getX(), register2.getY()+2);
            register2Line.setLocation(register2Line.getX(), register2Line.getY()+2);
            register2Line.setVisible(false);
            
        }
    }   
    
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        String username = usernameField.getText();

        if(e.getKeyCode() == KeyEvent.VK_ENTER) {
            if(!username.isEmpty()){
                passwordField.requestFocusInWindow();
            }
            handleMouseClick(loginButton);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
    
    public static void main(String[] args){
        new LibraryLogInPage();
    }

 

}
