package com.mycompany.library.ui.admin;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.mycompany.library.ui.styles.ComponentStyles;
import com.mycompany.library.functions.*;

public class LibraryAddBooks implements MouseListener{

    JFrame borrowBooksFrame = new JFrame();

    public static JTextField bookTitleField = new JTextField();
    public static JTextField bookAuthorField = new JTextField();

    JLabel emptyBookTitleMessage = new JLabel();
    JLabel emptyBookAuthorMessage = new JLabel();

    JPanel addCoverPanel = new JPanel();
    JLabel addIconLabel = new JLabel();
    JLabel cover = new JLabel();

/*     ComponentStyles.CustomRoundedButton2 confirmButton = new ComponentStyles.CustomRoundedButton2("Confirm");
    ComponentStyles.CustomRoundedButton2 resetButton = new ComponentStyles.CustomRoundedButton2("Reset"); */

    JPanel mainPanel = new JPanel();
    ArrayList<JPanel> bookPanelsList = new ArrayList<>();

    HashMap<JPanel, JLabel> bookLabelsList = new HashMap<>();

    ComponentStyles.RoundedPanel homeButtonPanel = new ComponentStyles.RoundedPanel(20);

    LibraryFunctions libFuncs = new LibraryFunctions();

    ComponentStyles.RoundedPanel inputPanel = new ComponentStyles.RoundedPanel(20);

    public LibraryAddBooks(){

        // ---------------------------------FRAME SET UP------------------------------//
        ImageIcon logo = new ImageIcon("src/main/resources/images/logo.png");

        borrowBooksFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        borrowBooksFrame.setSize(950,600);
        borrowBooksFrame.setResizable(false);
        borrowBooksFrame.setTitle("Add/Remove Books");
        borrowBooksFrame.setIconImage(logo.getImage());
        borrowBooksFrame.setLayout(new BorderLayout());
        borrowBooksFrame.setLocationRelativeTo(null);

        ComponentStyles.BackgroundPanel bgPanel = new ComponentStyles.BackgroundPanel("src/main/resources/images/mainBG.jpg");
        bgPanel.setPreferredSize(new Dimension(950,600));
        bgPanel.setLayout(null);
        //--------------------------------------------------------------------------//

        //--------------------------------INPUT PANEL------------------------------//
        
        inputPanel.setBounds(110,350,725,200);
        inputPanel.setLayout(null);
        inputPanel.setBackground(new Color(103,120,97,160));

        JLabel bookTitleLabel = new JLabel("Enter Book Title:");
        bookTitleLabel.setBounds(30,20,200,25);
        bookTitleLabel.setFont(new Font("Sans-Serif", Font.BOLD, 20));
        bookTitleLabel.setForeground(Color.decode("#fbf8ef"));

        bookTitleField.setBounds(30,50,200,35);
        bookTitleField.setBackground(Color.decode("#e5efda"));
        bookTitleField.setBorder(new EmptyBorder(5,5,0,0));
        bookTitleField.setFont(new Font("Calibri", Font.PLAIN, 17));

        emptyBookTitleMessage.setBounds(30,85,135,15);
        emptyBookTitleMessage.setForeground(Color.decode("#BE3144"));
        emptyBookTitleMessage.setFont(new Font(null, Font.ITALIC,11));

        JLabel bookAuthorLabel = new JLabel("Enter Book Author:");
        bookAuthorLabel.setBounds(30,100,185,25);
        bookAuthorLabel.setFont(new Font("Sans-Serif", Font.BOLD, 20));
        bookAuthorLabel.setForeground(Color.decode("#fbf8ef"));

        bookAuthorField.setBounds(30,130,200,35);
        bookAuthorField.setBackground(Color.decode("#e5efda"));
        bookAuthorField.setBorder(new EmptyBorder(5,5,0,0));
        bookAuthorField.setFont(new Font("Calibri", Font.PLAIN, 17));

        emptyBookAuthorMessage.setBounds(30,165,135,15);
        emptyBookAuthorMessage.setForeground(Color.decode("#BE3144"));
        emptyBookAuthorMessage.setFont(new Font(null, Font.ITALIC,11));

        JLabel addBookLabel = new JLabel("Add Book Cover:");
        addBookLabel.setBounds(300,20,200,25);
        addBookLabel.setFont(new Font("Sans-Serif", Font.BOLD, 20));
        addBookLabel.setForeground(Color.decode("#fbf8ef"));

        ImageIcon a = new ImageIcon("src/main/resources/images/addCover.png");
        Image b = a.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon addIcon = new ImageIcon(b);

        // add Cover
        addCoverPanel.setBounds(340,50,80,115);
        addCoverPanel.setLayout(new BorderLayout());
        addCoverPanel.setBackground(new Color(229,239,218,255));
        addCoverPanel.addMouseListener(this);
        
        addIconLabel.setIcon(addIcon);
        addIconLabel.setVerticalAlignment(JLabel.CENTER);
        addIconLabel.setHorizontalAlignment(JLabel.CENTER);
        addIconLabel.setVisible(false);
        addCoverPanel.add(addIconLabel);

      /*   confirmButton.setBounds(500,60,150,40);
        confirmButton.addMouseListener(this);

        resetButton.setBounds(500,110,150,40);
        resetButton.addMouseListener(this); */
        //-------------------------------------------------------------------------//

        //-------------------------------MAIN PANEL--------------------------------//
        ComponentStyles.RoundedPanel upperLine = new ComponentStyles.RoundedPanel(10);
        upperLine.setBounds(10,10,910,2);

        ComponentStyles.RoundedPanel bottomLine = new ComponentStyles.RoundedPanel(10);
        bottomLine.setBounds(10,330,910,2);

        mainPanel.setLayout(new GridLayout(0,4,10,10));
        mainPanel.setBorder(new EmptyBorder(10,10,15,10));
        mainPanel.setOpaque(false);

        addPanel();

        JScrollPane mainScrollPane = new JScrollPane(mainPanel);
        mainScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        mainScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        mainScrollPane.getVerticalScrollBar().setUnitIncrement(10);
        mainScrollPane.setBounds(20,20,890,300);
        mainScrollPane.setOpaque(false);
        mainScrollPane.getViewport().setOpaque(false);
        mainScrollPane.setBorder(null);
        //--------------------------------------------------------------------------//

        //--------------------------HOME BUTTON-------------------------------------//
        ImageIcon origIcon = new ImageIcon("src/main/resources/images/home.png");
        Image scaledIcon = origIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon homeIcon = new ImageIcon(scaledIcon);

        homeButtonPanel.setBounds(10,510,40,40);
        homeButtonPanel.setBackground(new Color(252,255,242,120));
        homeButtonPanel.addMouseListener(this);

        JLabel homeIconLabel = new JLabel(homeIcon);
        homeButtonPanel.add(homeIconLabel);

        //---------------------------------------------------------------------------//

        //--------------------ADDING OF COMPONENTS (INPUT PANEL)---------------------//
        inputPanel.add(bookTitleLabel);
        inputPanel.add(bookTitleField);
        inputPanel.add(emptyBookTitleMessage);
        inputPanel.add(bookAuthorField);
        inputPanel.add(bookAuthorLabel);
        inputPanel.add(emptyBookAuthorMessage);
        inputPanel.add(addBookLabel);
        inputPanel.add(addCoverPanel);
       /*  inputPanel.add(confirmButton);
        inputPanel.add(resetButton); */
        //----------------------------------------------------------------------------//
        
        //--------------------ADDING OF COMPONENTS (MAIN PANEL)-----------------------//
        bgPanel.add(inputPanel);
        bgPanel.add(mainScrollPane);
        bgPanel.add(upperLine);
        bgPanel.add(bottomLine);
        bgPanel.add(homeButtonPanel);

        borrowBooksFrame.add(bgPanel);
        borrowBooksFrame.setVisible(true);
        //----------------------------------------------------------------------------//
    }

    public void addPanel(){

        File bookCoversFolder = new File("src/main/resources/BookCovers");

        File[] bookCoversFolderFiles = bookCoversFolder.listFiles(File::isFile);
        if(bookCoversFolderFiles != null){
            for(File cover : bookCoversFolderFiles){

                String[] bookDescription = cover.getName().split("[_.]");

                String title = bookDescription[0];
                String author = bookDescription[1];

                if(libFuncs.checkIfBorrowed(title, author)){
                    mainPanel.revalidate();
                    mainPanel.repaint();
                    continue;
                }

                ImageIcon origIcon = new ImageIcon(cover.getPath());
                Image scaledIcon = origIcon.getImage().getScaledInstance(160, 230, Image.SCALE_SMOOTH);
                ImageIcon bookCover = new ImageIcon(scaledIcon);
                
                JPanel books = new JPanel();
                books.setPreferredSize(new Dimension(200,290));
                books.setLayout(new FlowLayout(FlowLayout.CENTER,0,10));
                books.setOpaque(true);
                books.setBackground(new Color(255,255,255,0));
                books.addMouseListener(this);

                JLabel booksLabel = new JLabel();
                booksLabel.setIcon(bookCover);
                booksLabel.setText("<html><div style='text-align: center;'>" + title + "<br><i>" + author + "</i></div></html>");
                booksLabel.setFont(new Font("Serif", Font.BOLD,15));
                booksLabel.setHorizontalTextPosition(JLabel.CENTER);
                booksLabel.setVerticalTextPosition(JLabel.BOTTOM);
                booksLabel.setHorizontalAlignment(JLabel.CENTER);
                booksLabel.setIconTextGap(5);

                books.add(booksLabel);
                mainPanel.add(books);
                
                bookPanelsList.add(books);
                bookLabelsList.put(books,booksLabel);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if(e.getSource()==homeButtonPanel){
            borrowBooksFrame.dispose();
            AdminPage.adminFrame.setVisible(true);
        }

        if(e.getSource()==homeButtonPanel){

            bookTitleField.setText(null);
            bookTitleField.requestFocusInWindow();
            bookAuthorField.setText(null);
            emptyBookTitleMessage.setText(null);
            emptyBookAuthorMessage.setText(null);
            addCoverPanel.removeAll();
            addCoverPanel.add(addIconLabel);
            inputPanel.revalidate();
            inputPanel.repaint();
            
        }

        if(e.getSource()==homeButtonPanel){
            
            String bookTitle = bookTitleField.getText();
            String bookAuthor = bookAuthorField.getText();

            emptyBookTitleMessage.setText(null);
            emptyBookAuthorMessage.setText(null);

            if(bookTitle.isEmpty()){
                emptyBookTitleMessage.setText("Please enter book title");
                return;
            }

            if(bookAuthor.isEmpty()){
                emptyBookAuthorMessage.setText("Please enter book author");
                return;
            }

            File bookCoversFolder = new File("src/main/resources/BookCovers");

            File[] bookCoversFolderFiles = bookCoversFolder.listFiles(File::isFile);
            if(bookCoversFolderFiles != null){
                for(File cover : bookCoversFolderFiles){

                    String[] bookDescription = cover.getName().split("[_.]");

                    String title = bookDescription[0];
                    String author = bookDescription[1];

                    if(bookTitle.equals(title) && bookAuthor.equals(author)){
                        JOptionPane.showMessageDialog(AdminPage.adminFrame, "This Book is already added!", "Already Added", JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }
                    
                }
            }
            new MoveFiles();

            addCoverPanel.removeAll();
            addCoverPanel.add(addIconLabel);
            bookTitleField.setText(null);
            bookAuthorField.setText(null);
            inputPanel.revalidate();
            inputPanel.repaint();

            mainPanel.removeAll();
            addPanel();
            mainPanel.revalidate();
            mainPanel.repaint();

            JOptionPane.showMessageDialog(AdminPage.adminFrame, "Book Added Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

            
        }

        for(JPanel book : bookPanelsList){
            if(e.getSource()==book){
                JLabel bookLabel = bookLabelsList.get(book);
                
                String text = bookLabel.getText().replaceAll("<[^>]*>", "_").trim();

                String[] info = text.split("__");

                JLabel infoLabel = new JLabel("<html>" + info[1] + "&emsp;-&emsp;" + info[2] + "</html>");
                infoLabel.setFont(new Font("Serif", Font.BOLD,12));
                infoLabel.setHorizontalTextPosition(JLabel.LEFT);
                break;
            }
        }

        if(e.getSource()==addCoverPanel){
            AddCover getCoverPath = new AddCover();
            String getCover = getCoverPath.getCover();

            ImageIcon origIcon = new ImageIcon(getCover);
            Image scaledImage = origIcon.getImage().getScaledInstance(80, 115, Image.SCALE_SMOOTH);
            ImageIcon addCover = new ImageIcon(scaledImage); 

            cover.setIcon(addCover);
            addCoverPanel.add(cover);

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
        if(e.getSource()==homeButtonPanel){
            homeButtonPanel.setBackground(new Color(252,255,242,60));
            
        }

        if(e.getSource()==addCoverPanel){
            addCoverPanel.setBackground(new Color(229,239,218,60));
            addIconLabel.setVisible(true);
            inputPanel.revalidate();
            inputPanel.repaint();
        }

        for(JPanel panels : bookPanelsList){
            if(e.getSource()==panels){
                panels.setOpaque(true);
                panels.setBackground(new Color(255,255,255,80));

                panels.getParent().repaint();
            }
        }

    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource()==homeButtonPanel){
            homeButtonPanel.setBackground(new Color(252,255,242,120));
        }

        if(e.getSource()==addCoverPanel){
            addCoverPanel.setBackground(new Color(229,239,218,255));
            addIconLabel.setVisible(false);
            inputPanel.revalidate();
            inputPanel.repaint();
        }

        for(JPanel panels : bookPanelsList){
            if(e.getSource()==panels){
                panels.setBackground(new Color(255,255,255,0));
                panels.setOpaque(false);
                
                panels.getParent().repaint();
            }
        }
    }
    public static void main(String[] args){
        new LibraryAddBooks();
    }
}
