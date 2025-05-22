package com.mycompany.library.ui.student;

import java.awt.Color;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.mycompany.library.functions.LibraryFunctions;

public class StudentPageFunctions {

    private static void setPanelBackground(JPanel panel, Color color) {
        panel.setOpaque(true);
        panel.setBackground(color);
        panel.getParent().repaint();
    }
    
    protected static boolean setPanelHoverBackground(ArrayList<JPanel> list, Object source, Color bgColor) {
        for (JPanel panel : list) {
            if (source == panel) {
                setPanelBackground(panel, bgColor);
                return true;
            }
        }
        return false;
    }

    public static class BookInfo{
        public String title, author, isbn, edition, callNum, tag, dateAcquired, description;
        public int yearPublished, pages;
        public ImageIcon cover;
    }

    public static class BorrowedBookInfo{
        public String title, author, isbn;
        public ImageIcon cover;
    }

    protected static String getTitleFromLabel(javax.swing.JLabel label){
        String text = label.getText().replaceAll("<[^>]*>", "_").trim();

        String[] info = text.split("__");
        return info.length > 1 ? info[1] : null;
    }

    protected static BookInfo getBookInfo(String bookTitle){

        List<LibraryFunctions.bookInfos> bookInfos = LibraryFunctions.fetchBookByTitle(bookTitle);
        if(bookInfos.isEmpty()) return null;

        LibraryFunctions.bookInfos b = bookInfos.get(0);
        BookInfo infos = new BookInfo();
        infos.title = b.title;
        infos.author = b.author;
        infos.yearPublished = b.yearPublished;
        infos.edition = b.edition;
        infos.isbn = b.isbn;
        infos.pages = b.pages;
        infos.dateAcquired = b.dateAcquired;
        infos.callNum = b.callNumber;
        infos.description = b.description;
        infos.tag = b.tag;
        infos.cover = new ImageIcon(b.cover.getImage().getScaledInstance(205, 290, Image.SCALE_SMOOTH));
        return infos;

    }

    protected static BorrowedBookInfo getBorrowedBookInfo(String bookTitle){

        List<LibraryFunctions.bookInfos> bookInfos = LibraryFunctions.fetchBookByTitle(bookTitle);
        List<LibraryFunctions.BorrowedBookInfos> borrowedBookInfosFromDB = LibraryFunctions.fetchBorrowedBookData();

        for (LibraryFunctions.bookInfos b : bookInfos){
            for(LibraryFunctions.BorrowedBookInfos bb : borrowedBookInfosFromDB){
                if(bb.isbn.equals(b.isbn)){
                    BorrowedBookInfo borrowedBooksInfos = new BorrowedBookInfo();
                    borrowedBooksInfos.title = b.title;
                    borrowedBooksInfos.author = b.author;
                    borrowedBooksInfos.isbn = b.isbn;
                    borrowedBooksInfos.cover = new ImageIcon(b.cover.getImage().getScaledInstance(155, 240, Image.SCALE_SMOOTH));
                    return borrowedBooksInfos;
                }
            }
        }
        return null;
    }

    protected static void showViewBookDialog(javax.swing.JDialog dialog, BookInfo bookInfo){

        studentViewBookPopUp viewBookInfos = new studentViewBookPopUp();
        
        viewBookInfos.bookTitleLabel.setText(bookInfo.title);
        viewBookInfos.bookAuthorLabel.setText(bookInfo.author);
        viewBookInfos.bookPublishedLabel.setText(String.valueOf("Published: " + bookInfo.yearPublished));
        viewBookInfos.bookGenreLabel.setText("Tag: " + bookInfo.tag);
        viewBookInfos.bookEditionLabel.setText("Edition: " + bookInfo.edition);
        viewBookInfos.bookISBNLabel.setText("ISBN: " + bookInfo.isbn);
        viewBookInfos.bookPagesLabel.setText("Pages: " + String.valueOf(bookInfo.pages));
        viewBookInfos.bookAcquiredLabel.setText("Date Acquired: " + bookInfo.dateAcquired);
        viewBookInfos.bookCallNumLabel.setText("Call Number: " + bookInfo.callNum);
        viewBookInfos.bookDescription.setText(bookInfo.description);
        viewBookInfos.bookCoverLabel.setIcon(bookInfo.cover);

        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setContentPane(viewBookInfos);
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }

    protected static String isbn = null;
    protected static void showReturnBookDialog(BorrowedBookInfo borrowedBookInfo){

        studentReturnBookPopUp returnBook = new studentReturnBookPopUp();

        returnBook.bookTitleLabel.setText(borrowedBookInfo.title);
        returnBook.bookAuthorLabel.setText(borrowedBookInfo.author);
        returnBook.bookCoverLabel.setIcon(borrowedBookInfo.cover);
        isbn = borrowedBookInfo.isbn;

        JDialog returnBookDialog = new JDialog((JFrame) null, "Return Book", true);
        returnBookDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        returnBookDialog.setContentPane(returnBook);
        returnBookDialog.pack();
        returnBookDialog.setLocationRelativeTo(null);
        returnBookDialog.setVisible(true);
    }

    public static void refreshBookPanels() {
        StudentPage.booksPanel.removeAll();
        StudentPage.borrowedBooksPanel.removeAll();

        StudentPage.instance.addBooksToPanel();
        StudentPage.instance.addBorrowedBooksToPanel();

        StudentPage.booksPanel.revalidate();
        StudentPage.booksPanel.repaint();
        StudentPage.borrowedBooksPanel.revalidate();
        StudentPage.borrowedBooksPanel.repaint();
    }

}
