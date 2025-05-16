package com.mycompany.library.ui.admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.mycompany.library.ui.styles.ComponentStyles;
import com.mycompany.library.ui.mainpage.OLD_LibraryLogInPage;

public class OLD_AdminPage implements MouseListener{
    
    static JFrame adminFrame = new JFrame();
    ComponentStyles.RoundedPanel header = new ComponentStyles.RoundedPanel(20);

    ComponentStyles.RoundedPanel addBooksPanel = new ComponentStyles.RoundedPanel(20);
    ComponentStyles.RoundedPanel viewBooksPanel = new ComponentStyles.RoundedPanel(20);

    ComponentStyles.RoundedPanel burgerPanel = new ComponentStyles.RoundedPanel(30);
    ComponentStyles.RoundedPanel burgerMenuPanel = new ComponentStyles.RoundedPanel(20);
    JPanel logOutLabelContainer = new JPanel();

    String currUser;
    
    public OLD_AdminPage(String username){

        this.currUser = username;

        adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        adminFrame.setSize(950,600);
        adminFrame.setResizable(false);
        adminFrame.setTitle("Admin Page");
        adminFrame.setLayout(new BorderLayout());
        adminFrame.setLocationRelativeTo(null);

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
        
        ImageIcon origIcon = new ImageIcon("src/main/resources/images/addBooks.png");
        Image scaledIcon = origIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon addBooksIcon = new ImageIcon(scaledIcon);

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

        //--------------------------ADD BOOKS----------------------------//
        JLabel addBooksLabel = new JLabel("Add Books");
        addBooksLabel.setBounds(5,10,240,190);
        addBooksLabel.setIcon(addBooksIcon);
        addBooksLabel.setFont(new Font("Serif", Font.BOLD,20));
        addBooksLabel.setHorizontalTextPosition(JLabel.CENTER);
        addBooksLabel.setVerticalTextPosition(JLabel.BOTTOM);
        addBooksLabel.setHorizontalAlignment(JLabel.CENTER);
        addBooksLabel.setIconTextGap(20);

        addBooksPanel.setBounds(5,15,240,190);
        addBooksPanel.setLayout(null);
        addBooksPanel.add(addBooksLabel);
        addBooksPanel.setBackground(new Color(229,239,218,120));
        addBooksPanel.addMouseListener(this);

        //-----------------------VIEW BORROWED BOOKS-------------------------//
        JLabel viewBooksLabel = new JLabel("View Books");
        viewBooksLabel.setBounds(5,5,240,190);
        viewBooksLabel.setIcon(viewBorrowedBooksIcon);
        viewBooksLabel.setFont(new Font("Serif", Font.BOLD,20));
        viewBooksLabel.setHorizontalTextPosition(JLabel.CENTER);
        viewBooksLabel.setVerticalTextPosition(JLabel.BOTTOM);
        viewBooksLabel.setHorizontalAlignment(JLabel.CENTER);
        viewBooksLabel.setIconTextGap(25);

        viewBooksPanel.setBounds(255,15,240,190);
        viewBooksPanel.setLayout(null);
        viewBooksPanel.add(viewBooksLabel);
        viewBooksPanel.setBackground(new Color(229,239,218,120));
        viewBooksPanel.addMouseListener(this);

        mainButtonsContainer.add(addBooksPanel);
        mainButtonsContainer.add(viewBooksPanel);
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
        adminFrame.add(bgPanel);
        adminFrame.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==burgerPanel){
            burgerMenuPanel.setVisible(!burgerMenuPanel.isVisible());
        }

        if(e.getSource()==viewBooksPanel){
            adminFrame.setVisible(false);
            new OLD_LibraryViewBooksAdmin();
        }

        if(e.getSource()==addBooksPanel){
            adminFrame.setVisible(false);
            new OLD_LibraryAddBooks();
        }

        if(e.getSource()==logOutLabelContainer){
            burgerMenuPanel.setVisible(false);
            adminFrame.dispose();
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
        if(e.getSource()==addBooksPanel){
            addBooksPanel.setLocation(addBooksPanel.getX(), addBooksPanel.getY()-10);
        }

        if(e.getSource()==viewBooksPanel){
            viewBooksPanel.setLocation(viewBooksPanel.getX(), viewBooksPanel.getY()-10);
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
        if(e.getSource()==addBooksPanel){
            addBooksPanel.setLocation(addBooksPanel.getX(), addBooksPanel.getY()+10);
        }

        if(e.getSource()==viewBooksPanel){
            viewBooksPanel.setLocation(viewBooksPanel.getX(), viewBooksPanel.getY()+10);
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
        new OLD_AdminPage("admin");
    }
}
