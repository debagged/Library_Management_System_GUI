package com.mycompany.library.ui.student;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import com.mycompany.library.ui.styles.ComponentStyles;
import com.mycompany.library.ui.mainpage.OLD_LibraryLogInPage;

public class StudentPage implements MouseListener{
    
    static JFrame studentFrame = new JFrame();
    ComponentStyles.RoundedPanel header = new ComponentStyles.RoundedPanel(20);

    ComponentStyles.RoundedPanel borrowBooksPanel = new ComponentStyles.RoundedPanel(20);
    ComponentStyles.RoundedPanel viewBorrowedBooksPanel = new ComponentStyles.RoundedPanel(20);

    ComponentStyles.RoundedPanel burgerPanel = new ComponentStyles.RoundedPanel(30);
    ComponentStyles.RoundedPanel burgerMenuPanel = new ComponentStyles.RoundedPanel(20);
    JPanel logOutLabelContainer = new JPanel();

    String currUser;
    
    public StudentPage(String username){

        this.currUser = username;

        studentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        studentFrame.setSize(950,600);
        studentFrame.setResizable(false);
        studentFrame.setTitle("Student Page");
        studentFrame.setLayout(new BorderLayout());
        studentFrame.setLocationRelativeTo(null);

        ComponentStyles.BackgroundPanel bgPanel = new ComponentStyles.BackgroundPanel("src/main/resources/images/mainBG.jpg");
        bgPanel.setPreferredSize(new Dimension(950,600));
        bgPanel.setLayout(null);

        //-----------------------------Header------------------------------//
        header.setBounds(10,10,910,150);
        header.setLayout(null);
        header.setBackground(new Color(123,143,116,150));

        JLabel title = new JLabel();
        title.setBounds(70,20,350,50);
        title.setText("LRC LIBRARY");
        title.setForeground(Color.white);
        title.setFont(new Font("Serif", Font.BOLD, 50));
        
        JLabel line = new JLabel("__________________________");
        line.setBounds(70,45,400,30);
        line.setForeground(Color.white);
        line.setFont(new Font("Serif", Font.BOLD, 25));
        
        JLabel titleDescription = new JLabel();
        titleDescription.setBounds(70,70,250,30);
        titleDescription.setText("OUR LADY OF FATIMA LIBRARY SYSTEM");
        titleDescription.setForeground(Color.white);
        titleDescription.setFont(new Font("Serif", Font.BOLD, 12));

        header.add(title);
        header.add(line);
        header.add(titleDescription);

        //------------------------------------------------------------------//

        //----------------------Main Buttons--------------------------------//
        
        ImageIcon origIcon = new ImageIcon("src/main/resources/images/BorrowBook.png");
        Image scaledIcon = origIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon borrowBooksIcon = new ImageIcon(scaledIcon);

        ImageIcon origIcon2 = new ImageIcon("src/main/resources/images/viewBorrowedBook.png");
        Image scaledIcon2 = origIcon2.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon viewBorrowedBooksIcon = new ImageIcon(scaledIcon2);

        ImageIcon origIcon3 = new ImageIcon("src/main/resources/images/burger.png");
        Image scaledIcon3 = origIcon3.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon burgerIcon = new ImageIcon(scaledIcon3);

        ImageIcon origIcon4 = new ImageIcon("src/main/resources/images/logout.png");
        Image scaledIcon4 = origIcon4.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        ImageIcon logOutIcon = new ImageIcon(scaledIcon4);

        JPanel mainButtonsContainer = new JPanel();
        mainButtonsContainer.setBounds(215,200,500,210);
        mainButtonsContainer.setLayout(null);
        mainButtonsContainer.setOpaque(false);

        //--------------------------BORROW BOOKS----------------------------//
        JLabel borrowBooksLabel = new JLabel("Borrow Books");
        borrowBooksLabel.setBounds(60,10,240,190);
        borrowBooksLabel.setIcon(borrowBooksIcon);
        borrowBooksLabel.setFont(new Font("Serif", Font.BOLD,20));
        borrowBooksLabel.setHorizontalTextPosition(JLabel.CENTER);
        borrowBooksLabel.setVerticalTextPosition(JLabel.BOTTOM);
        borrowBooksLabel.setIconTextGap(20);

        borrowBooksPanel.setBounds(5,15,240,190);
        borrowBooksPanel.setLayout(null);
        borrowBooksPanel.add(borrowBooksLabel);
        borrowBooksPanel.setBackground(new Color(229,239,218,120));
        borrowBooksPanel.addMouseListener(this);

        //-----------------------VIEW BORROWED BOOKS-------------------------//
        JLabel viewBorrowedBooksLabel = new JLabel("View Borrowed Books");
        viewBorrowedBooksLabel.setBounds(30,10,240,190);
        viewBorrowedBooksLabel.setIcon(viewBorrowedBooksIcon);
        viewBorrowedBooksLabel.setFont(new Font("Serif", Font.BOLD,20));
        viewBorrowedBooksLabel.setHorizontalTextPosition(JLabel.CENTER);
        viewBorrowedBooksLabel.setVerticalTextPosition(JLabel.BOTTOM);
        viewBorrowedBooksLabel.setIconTextGap(20);

        viewBorrowedBooksPanel.setBounds(255,15,240,190);
        viewBorrowedBooksPanel.setLayout(null);
        viewBorrowedBooksPanel.add(viewBorrowedBooksLabel);
        viewBorrowedBooksPanel.setBackground(new Color(229,239,218,120));
        viewBorrowedBooksPanel.addMouseListener(this);

        mainButtonsContainer.add(borrowBooksPanel);
        mainButtonsContainer.add(viewBorrowedBooksPanel);
        //--------------------------------------------------------------------//
        //--------------------------------------------------------------------//

        //---------------------------BURGER MENU------------------------------//
        
        burgerMenuPanel.setBounds(-5,400,100,80);
        burgerMenuPanel.setLayout(null);
        burgerMenuPanel.setBackground(new Color(103,120,97,130));
        burgerMenuPanel.setVisible(false);

        //-----------------------------USER INFO-----------------------------//
        ComponentStyles.RoundedPanel userPanel = new ComponentStyles.RoundedPanel(20);
        userPanel.setBounds(10,10,80,30);
        //userPanel.setLayout(null);
        userPanel.setBackground(Color.decode("#667860"));

        currUser = currUser.substring(0,1).toUpperCase() + currUser.substring(1);
        JLabel userLabel = new JLabel(currUser);
        //userLabel.setBounds(10,0,80,20);
        userLabel.setHorizontalTextPosition(JLabel.CENTER);
        userLabel.setVerticalTextPosition(JLabel.CENTER);
        userLabel.setFont(new Font("Serif", Font.PLAIN, 15));

        userPanel.add(userLabel);
        //--------------------------------------------------------------------//
        //-------------------------LOG OUT BUTTON----------------------------//
        JLabel logOutLabel = new JLabel("Log Out");
        logOutLabel.setBounds(10,0,95,17);
        logOutLabel.setIcon(logOutIcon);
        logOutLabel.setHorizontalTextPosition(JLabel.RIGHT);
        logOutLabel.setIconTextGap(5);
        logOutLabel.setFont(new Font("Serif", Font.PLAIN, 15));
        
        logOutLabelContainer.setBounds(0,50,100,20);
        logOutLabelContainer.setLayout(null);
        logOutLabelContainer.setBackground(new Color(229,239,218,120));
        logOutLabelContainer.setOpaque(false);
        logOutLabelContainer.add(logOutLabel);
        logOutLabelContainer.addMouseListener(this);

        burgerMenuPanel.add(userPanel);
        burgerMenuPanel.add(logOutLabelContainer);
        
        burgerPanel.setBounds(15,500,40,40);
        burgerPanel.setBackground(new Color(0,0,0,0));
        burgerPanel.setLayout(null);
        burgerPanel.addMouseListener(this);

        JLabel burger = new JLabel();
        burger.setBounds(5,5,30,30);
        burger.setIcon(burgerIcon);

        //-------------------------------------------------------------------//

        burgerPanel.add(burger);
        
        bgPanel.add(burgerMenuPanel);
        bgPanel.add(burgerPanel);
        bgPanel.add(mainButtonsContainer);
        bgPanel.add(header);
        studentFrame.add(bgPanel);
        studentFrame.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==burgerPanel){
            burgerMenuPanel.setVisible(!burgerMenuPanel.isVisible());
        }

        if(e.getSource()==viewBorrowedBooksPanel){
            studentFrame.setVisible(false);
            new LibraryViewBorrowedBooks();
        }

        if(e.getSource()==borrowBooksPanel){
            studentFrame.setVisible(false);
            new BorrowBooks();
        }

        if(e.getSource()==logOutLabelContainer){
            burgerMenuPanel.setVisible(false);
            studentFrame.dispose();
            OLD_LibraryLogInPage.mainFrame.setVisible(true);
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
        if(e.getSource()==borrowBooksPanel){
            borrowBooksPanel.setLocation(borrowBooksPanel.getX(), borrowBooksPanel.getY()-10);
        }

        if(e.getSource()==viewBorrowedBooksPanel){
            viewBorrowedBooksPanel.setLocation(viewBorrowedBooksPanel.getX(), viewBorrowedBooksPanel.getY()-10);
        }
        
        if(e.getSource()==burgerPanel){
            burgerPanel.setBackground(new Color(0,0,0,30));
        }

        if(e.getSource()==logOutLabelContainer){
            logOutLabelContainer.setOpaque(true);
            logOutLabelContainer.repaint();
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource()==borrowBooksPanel){
            borrowBooksPanel.setLocation(borrowBooksPanel.getX(), borrowBooksPanel.getY()+10);
        }

        if(e.getSource()==viewBorrowedBooksPanel){
            viewBorrowedBooksPanel.setLocation(viewBorrowedBooksPanel.getX(), viewBorrowedBooksPanel.getY()+10);
        }

        if(e.getSource()==burgerPanel){
            burgerPanel.setBackground(new Color(0,0,0,0));
        }

        if(e.getSource()==logOutLabelContainer){
            logOutLabelContainer.setOpaque(false);
            logOutLabelContainer.repaint();
        }
    }
    
    public static void main(String[] args){
        new StudentPage("admin");
    }
}
