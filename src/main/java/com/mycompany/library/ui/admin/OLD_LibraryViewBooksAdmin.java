package com.mycompany.library.ui.admin;

import com.mycompany.library.functions.LibraryFunctions;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class OLD_LibraryViewBooksAdmin implements ActionListener{
    
    LibraryFunctions libFuncs = new LibraryFunctions();

    JFrame frame = new JFrame();
    JPanel panelContainer = new JPanel();
    JPanel labelFooter = new JPanel();
    JPanel labelHeader = new JPanel();
    JLabel authorLabel = new JLabel("Author");
    JLabel titleLabel = new JLabel("Title");
    JLabel ISBNLabel = new JLabel("ISBN");
    JPanel bookAuthorPanel = new JPanel();
    JPanel bookTitlePanel = new JPanel();
    JPanel bookISBNPanel = new JPanel();
    JLabel bookAuthorLabel;
    JLabel bookTitleLabel;
    JLabel bookISBNLabel;
    
    JButton addBooksButton = new JButton("Add Books");
    JButton backButton = new JButton("Back");
    
    private Set<String> currentLabels;

    public OLD_LibraryViewBooksAdmin() {
        
        currentLabels = new HashSet<>();
        
        panelContainer.setLayout(new BoxLayout(panelContainer, BoxLayout.X_AXIS));
        
        bookAuthorPanel.setBackground(Color.decode("#03346E"));
        bookAuthorPanel.setLayout(new BoxLayout(bookAuthorPanel, BoxLayout.Y_AXIS));
        bookAuthorPanel.setMaximumSize(new Dimension(333,Integer.MAX_VALUE));
        
        bookTitlePanel.setBackground(Color.decode("#03346E"));
        bookTitlePanel.setLayout(new BoxLayout(bookTitlePanel, BoxLayout.Y_AXIS));
        bookTitlePanel.setMaximumSize(new Dimension(333,Integer.MAX_VALUE));
        
        bookISBNPanel.setBackground(Color.decode("#03346E"));
        bookISBNPanel.setLayout(new BoxLayout(bookISBNPanel, BoxLayout.Y_AXIS));
        bookISBNPanel.setMaximumSize(new Dimension(333,Integer.MAX_VALUE));
        
        panelContainer.add(bookAuthorPanel);
        panelContainer.add(bookTitlePanel);
        panelContainer.add(bookISBNPanel);
        
        JScrollPane scrollPane = new JScrollPane(panelContainer);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        loadLabels();
        
        authorLabel.setBounds(135,15,50,12);
        authorLabel.setForeground(Color.decode("#E2E2B6"));
        authorLabel.setFont(new Font(null, Font.BOLD, 15));
        
        titleLabel.setBounds(460,15,50,12);
        titleLabel.setForeground(Color.decode("#E2E2B6"));
        titleLabel.setFont(new Font(null, Font.BOLD, 15));
        
        ISBNLabel.setBounds(775,15,50,12);
        ISBNLabel.setForeground(Color.decode("#E2E2B6"));
        ISBNLabel.setFont(new Font(null, Font.BOLD, 15));
        
        labelHeader.setLayout(null); // Center the panel
        labelHeader.setPreferredSize(new Dimension(40,40));
        labelHeader.setBackground(Color.decode("#021526"));
        labelHeader.add(authorLabel);
        labelHeader.add(titleLabel);
        labelHeader.add(ISBNLabel);
        
        backButton.setBounds(270,65,180,60);
        backButton.addActionListener(this);
        backButton.setFocusable(false);
        
        addBooksButton.setBounds(510,65,180,60);
        addBooksButton.addActionListener(this);
        addBooksButton.setFocusable(false);
        
        labelFooter.setLayout(null);
        labelFooter.setBackground(Color.decode("#021526"));
        labelFooter.setPreferredSize(new Dimension(1000,200));

        labelFooter.add(addBooksButton);
        labelFooter.add(backButton);     
        
        JPanel container = new JPanel();
        JPanel border1 = new JPanel();
        JPanel border2 = new JPanel();
        JPanel border3 = new JPanel();
        JPanel border4 = new JPanel();
        
        container.setLayout(new BorderLayout());
        container.add(labelHeader, BorderLayout.NORTH);
        container.add(scrollPane, BorderLayout.CENTER);
        container.add(labelFooter, BorderLayout.SOUTH);
        
        border1.setBackground(Color.decode("#6EACDA"));
        border1.setPreferredSize(new Dimension(5,5));
        
        border2.setBackground(Color.decode("#6EACDA"));
        border2.setPreferredSize(new Dimension(5,5));
        
        border3.setBackground(Color.decode("#6EACDA"));
        border3.setPreferredSize(new Dimension(5,5));
        
        border4.setBackground(Color.decode("#6EACDA"));
        border4.setPreferredSize(new Dimension(5,5));
        
        frame.setLayout(new BorderLayout());
        frame.add(border1, BorderLayout.NORTH);
        frame.add(border2, BorderLayout.WEST);
        frame.add(border3, BorderLayout.SOUTH);
        frame.add(border4, BorderLayout.EAST);

        frame.add(container, BorderLayout.CENTER);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("View Books");
        frame.setSize(1000, 600);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==backButton){
            frame.dispose();
            OLD_AdminPage.adminFrame.setVisible(true);
        }
        
        if(e.getSource()==addBooksButton){
            frame.dispose();
            new OLD_LibraryAddBooks();
        }
    }
    
    private void loadLabels() {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/Books.txt"))) {
            String line;
            
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                
                String  bookAuthor = parts[0].trim(),
                        bookTitle = parts[1].trim(),
                        bookISBN = parts[2].trim();
                
                addLabel(bookAuthor, bookTitle, bookISBN);
                
            }
        } catch (IOException e){}
    }
    
    private void addLabel(String author, String title, String isbn) {
        
        // Create a unique key by concatenating author, title, and isbn
        String uniqueBookKey = author + "|" + title + "|" + isbn;

        // Check if the combination of author, title, and isbn already exists
        if (!currentLabels.contains(uniqueBookKey)) {
            // Create and add author label
            
            /* if(libFuncs.checkIfBorrowed(title, author)){
                bookAuthorLabel = new JLabel("(Borrowed)"+author);
                
            } else{
                bookAuthorLabel = new JLabel(author);
            } */
            
            bookAuthorLabel.setForeground(Color.decode("#E2E2B6"));
            bookAuthorLabel.setFont(new Font(null, Font.PLAIN, 15));
            bookAuthorPanel.add(bookAuthorLabel);
            bookAuthorLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

            // Create and add title label
            bookTitleLabel = new JLabel(title);
            bookTitleLabel.setForeground(Color.decode("#E2E2B6"));
            bookTitleLabel.setFont(new Font(null, Font.PLAIN, 15));
            bookTitlePanel.add(bookTitleLabel);
            bookTitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

            // Create and add ISBN label
            bookISBNLabel = new JLabel(isbn);
            bookISBNLabel.setForeground(Color.decode("#E2E2B6"));
            bookISBNLabel.setFont(new Font(null, Font.PLAIN, 15));
            bookISBNPanel.add(bookISBNLabel);
            bookISBNLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        }
    }
        
    public static void main(String[] args) {
        new OLD_LibraryViewBooksAdmin();
    }
}