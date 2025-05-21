package com.mycompany.library.ui.admin;

import java.awt.Image;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;

import com.mycompany.library.functions.LibraryFunctions;

public class AdminFunctions {

    protected static void showDialog(javax.swing.JPanel panel, String title, boolean modal){
        JDialog dialog = new JDialog((JFrame) null, title, modal);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setContentPane(panel);
        dialog.pack();
        dialog.setLocationRelativeTo(panel.getParent());
        dialog.setVisible(true);
    }

    protected static void showViewBookDialog(List<com.mycompany.library.functions.LibraryFunctions.bookInfos> bookInfos){

        if(bookInfos.isEmpty()) return;
        com.mycompany.library.functions.LibraryFunctions.bookInfos info = bookInfos.get(0);

        adminViewBooks viewBookInfos = new adminViewBooks();
        viewBookInfos.bookTitleLabel.setText(info.title);
        viewBookInfos.bookAuthorLabel.setText(info.author);
        viewBookInfos.bookPublishedLabel.setText("Published: " + info.yearPublished);
        viewBookInfos.bookGenreLabel.setText("Tag: " + info.tag);
        viewBookInfos.bookEditionLabel.setText("Edition: " + info.edition);
        viewBookInfos.bookISBNLabel.setText("ISBN: " + info.isbn);
        viewBookInfos.bookPagesLabel.setText("Pages: " + info.pages);
        viewBookInfos.bookAcquiredLabel.setText("Date Acquired: " + info.dateAcquired);
        viewBookInfos.bookCallNumLabel.setText("Call Number: " + info.callNumber);
        viewBookInfos.bookDescription.setText(info.description);

        Image scaled = info.cover.getImage().getScaledInstance(205, 275, Image.SCALE_SMOOTH);
        viewBookInfos.bookCoverLabel.setIcon(new ImageIcon(scaled));

        showDialog(viewBookInfos, "View Book", true);
    }

    protected static void showEditBookDialog(List<com.mycompany.library.functions.LibraryFunctions.bookInfos> bookInfos){
        if (bookInfos.isEmpty()) return;
        LibraryFunctions.bookInfos info = bookInfos.get(0);

        adminEditBook editBook = new adminEditBook();
        editBook.bookTitleField.setText(info.title);
        editBook.bookAuthorField.setText(info.author);
        editBook.bookYearPublished.setText(String.valueOf(info.yearPublished));
        editBook.bookTagComboBox.setSelectedItem(info.tag);
        editBook.bookEditionField.setText(info.edition);
        editBook.bookNumOfPagesField.setText(String.valueOf(info.pages));
        editBook.bookDescriptionField.setText(info.description);
        editBook.ISBNLabel.setText("ISBN: " + info.isbn);
        editBook.callNumLabel.setText("Call Number: " + info.callNumber);

        Image scaled = info.cover.getImage().getScaledInstance(240, 380, Image.SCALE_SMOOTH);
        editBook.coverLabel.setIcon(new ImageIcon(scaled));

        AdminPage.editBookTag = info.tag;
        AdminPage.editBookcallNum = info.callNumber;

        showDialog(editBook, "Edit Book", true);
    }
    
}
