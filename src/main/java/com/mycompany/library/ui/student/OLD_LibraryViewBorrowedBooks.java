package com.mycompany.library.ui.student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class OLD_LibraryViewBorrowedBooks implements ActionListener{

    JFrame frame = new JFrame();
    JPanel panelContainer = new JPanel();
    JPanel labelHeader = new JPanel();
    JLabel borrowerNameLabel = new JLabel("Borrower Name");
    JLabel authorLabel = new JLabel("Author");
    JLabel titleLabel = new JLabel("Title");
    JLabel ISBNLabel = new JLabel("ISBN");
    JPanel bookBorrowerNamePanel = new JPanel();
    JPanel bookAuthorPanel = new JPanel();
    JPanel bookTitlePanel = new JPanel();
    JPanel bookISBNPanel = new JPanel();
    JLabel bookBorrowerNameLabel;
    JLabel bookAuthorLabel;
    JLabel bookTitleLabel;
    JLabel bookISBNLabel;
    
    JButton backButton = new JButton("<");
    
    private Set<String> currentLabels;

    public OLD_LibraryViewBorrowedBooks() {
        
        currentLabels = new HashSet<>();
        
        panelContainer.setLayout(new BoxLayout(panelContainer, BoxLayout.X_AXIS));
        
        bookBorrowerNamePanel.setBackground(Color.decode("#03346E"));
        bookBorrowerNamePanel.setLayout(new BoxLayout(bookBorrowerNamePanel, BoxLayout.Y_AXIS));
        bookBorrowerNamePanel.setMaximumSize(new Dimension(300, Integer.MAX_VALUE));
        
        bookAuthorPanel.setBackground(Color.decode("#03346E"));
        bookAuthorPanel.setLayout(new BoxLayout(bookAuthorPanel, BoxLayout.Y_AXIS));
        bookAuthorPanel.setMaximumSize(new Dimension(300, Integer.MAX_VALUE));
        
        bookTitlePanel.setBackground(Color.decode("#03346E"));
        bookTitlePanel.setLayout(new BoxLayout(bookTitlePanel, BoxLayout.Y_AXIS));
        bookTitlePanel.setMaximumSize(new Dimension(300, Integer.MAX_VALUE));
        
        bookISBNPanel.setBackground(Color.decode("#03346E"));
        bookISBNPanel.setLayout(new BoxLayout(bookISBNPanel, BoxLayout.Y_AXIS));
        bookISBNPanel.setMaximumSize(new Dimension(300, Integer.MAX_VALUE));
        
        panelContainer.add(bookBorrowerNamePanel);
        panelContainer.add(bookAuthorPanel);
        panelContainer.add(bookTitlePanel);
        panelContainer.add(bookISBNPanel);
        
        JScrollPane scrollPane = new JScrollPane(panelContainer);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        loadLabels();
        
        borrowerNameLabel.setBounds(95,15,150,12);
        borrowerNameLabel.setForeground(Color.decode("#E2E2B6"));
        borrowerNameLabel.setFont(new Font(null, Font.BOLD, 15));
        
        authorLabel.setBounds(410,15,50,12);
        authorLabel.setForeground(Color.decode("#E2E2B6"));
        authorLabel.setFont(new Font(null, Font.BOLD, 15));
        
        titleLabel.setBounds(700,15,50,12);
        titleLabel.setForeground(Color.decode("#E2E2B6"));
        titleLabel.setFont(new Font(null, Font.BOLD, 15));
        
        ISBNLabel.setBounds(990,15,50,12);
        ISBNLabel.setForeground(Color.decode("#E2E2B6"));
        ISBNLabel.setFont(new Font(null, Font.BOLD, 15));
        
        backButton.setBounds(10,10,20,20);
        backButton.setFont(new Font(null, Font.PLAIN, 12));
        backButton.setMargin(new Insets(0, 0, 0, 0));
        backButton.addActionListener(this);
        backButton.setFocusable(false);
        
        labelHeader.setLayout(null);
        labelHeader.setPreferredSize(new Dimension(1500,40));
        labelHeader.setBackground(Color.decode("#021526"));
        
        labelHeader.add(backButton);
        labelHeader.add(borrowerNameLabel);
        labelHeader.add(authorLabel);
        labelHeader.add(titleLabel);
        labelHeader.add(ISBNLabel);
        
        JPanel container = new JPanel();
        JPanel border1 = new JPanel();
        JPanel border2 = new JPanel();
        JPanel border3 = new JPanel();
        JPanel border4 = new JPanel();
        
        container.setLayout(new BorderLayout());
        container.add(labelHeader, BorderLayout.NORTH);
        container.add(scrollPane, BorderLayout.CENTER);
        
        border1.setBackground(Color.decode("#6EACDA"));
        border1.setPreferredSize(new Dimension(1200,5));
        
        border2.setBackground(Color.decode("#6EACDA"));
        border2.setPreferredSize(new Dimension(5,600));
        
        border3.setBackground(Color.decode("#6EACDA"));
        border3.setPreferredSize(new Dimension(1200,5));
        
        border4.setBackground(Color.decode("#6EACDA"));
        border4.setPreferredSize(new Dimension(5,600));
        
        frame.setLayout(new BorderLayout());
        
        frame.add(border1, BorderLayout.NORTH);
        frame.add(border2, BorderLayout.WEST);
        frame.add(border3, BorderLayout.SOUTH);
        frame.add(border4, BorderLayout.EAST);

        frame.add(container);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("View Borrowed Books");
        frame.setSize(1200, 600);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==backButton){
            frame.dispose();
            OLD_StudentPage.studentFrame.setVisible(true);
        }
    }

    private void loadLabels() {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/Borrowed_Books.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                
                String  bookBorrowerName = parts[0].trim(),
                        bookAuthor = parts[2].trim(),
                        bookTitle = parts[3].trim(),
                        bookISBN = parts[4].trim();
                
                addLabel(bookBorrowerName, bookAuthor, bookTitle, bookISBN);
                
            }
        } catch (IOException e) {}
    }
    
    private void addLabel(String bookBorrowerName,
                          String author,
                          String title,
                          String isbn){
        
        // Create a unique key by concatenating author, title, and isbn
        String uniqueBookKey = bookBorrowerName + "|" + author + "|" + title + "|" + isbn;

        // Check if the combination of author, title, and isbn already exists
        if (!currentLabels.contains(uniqueBookKey)) {
            
            // Create and add Borrower Name  label
            bookBorrowerNameLabel = new JLabel(bookBorrowerName);
            bookBorrowerNameLabel.setForeground(Color.decode("#E2E2B6"));
            bookBorrowerNameLabel.setFont(new Font(null, Font.PLAIN, 15));
            bookBorrowerNamePanel.add(bookBorrowerNameLabel);
            bookBorrowerNameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            
            //Create and add author label
            bookAuthorLabel = new JLabel(author);
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
        new OLD_LibraryViewBorrowedBooks();
    }
}