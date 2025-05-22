package com.mycompany.library.ui.admin;

import java.awt.Color;
import java.awt.Window;

import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class adminEditBook extends javax.swing.JPanel {
    
    public adminEditBook() {
        initComponents();
        initListeners();
        setBackground(new java.awt.Color(255,255,244));

    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addBookHeader = new javax.swing.JLabel();
        separator = new javax.swing.JSeparator();
        bookTitleField = new custom.components.RoundedTextField();
        bookAuthorField = new custom.components.RoundedTextField();
        bookTagComboBox = new custom.components.RoundedComboBox();
        bookNumOfPagesField = new custom.components.RoundedTextField();
        confirmButton = new custom.components.CustomRoundedButton();
        backButton = new custom.components.CustomRoundedButton();
        addCoverPanel = new custom.components.RoundedPanel();
        coverLabel = new javax.swing.JLabel();
        bookYearPublished = new custom.components.RoundedTextField();
        bookEditionField = new custom.components.RoundedTextField();
        bookDescriptionLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        bookDescriptionField = new custom.components.RoundedTextArea();
        ISBNLabel = new javax.swing.JLabel();
        callNumLabel = new javax.swing.JLabel();

        addBookHeader.setBackground(new java.awt.Color(103, 120, 97));
        addBookHeader.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        addBookHeader.setForeground(new java.awt.Color(103, 120, 97));
        addBookHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        addBookHeader.setText("EDIT BOOK");

        separator.setBackground(new java.awt.Color(103, 120, 97));

        bookTitleField.setForeground(new java.awt.Color(79, 82, 78));
        bookTitleField.setText("Book Title:");
        bookTitleField.setBorderRadius(40);
        bookTitleField.setBorderThickness(2.0F);

        bookAuthorField.setForeground(new java.awt.Color(79, 82, 78));
        bookAuthorField.setText("Book Author:");
        bookAuthorField.setBorderRadius(35);
        bookAuthorField.setBorderThickness(2.0F);

        bookTagComboBox.setForeground(new java.awt.Color(79, 82, 78));
        bookTagComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Arts & Recreation", "History & Geography", "Literature", "Philosophy & Psychology", "Religion", "Science", "Social Sciences", "Technology", "General Information" }));
        bookTagComboBox.setBorderRadius(40);
        bookTagComboBox.setBorderThickness(2.0F);
        bookTagComboBox.setPreferredSize(new java.awt.Dimension(138, 40));

        bookNumOfPagesField.setForeground(new java.awt.Color(79, 82, 78));
        bookNumOfPagesField.setText("No. Of Pages:");
        bookNumOfPagesField.setBorderRadius(35);
        bookNumOfPagesField.setBorderThickness(2.0F);

        confirmButton.setForeground(new java.awt.Color(255, 255, 242));
        confirmButton.setText("CONFIRM");
        confirmButton.setPreferredSize(new java.awt.Dimension(93, 40));
        confirmButton.setRadius(40);

        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/left_arrow_white.png"))); // NOI18N
        backButton.setText("");
        backButton.setRadius(40);

        addCoverPanel.setBorderColor(new Color(103,120,97));
        addCoverPanel.setBorderThickness(2);
        addCoverPanel.setBorderVisible(true);
        addCoverPanel.setPreferredSize(new java.awt.Dimension(265, 272));

        coverLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout addCoverPanelLayout = new javax.swing.GroupLayout(addCoverPanel);
        addCoverPanel.setLayout(addCoverPanelLayout);
        addCoverPanelLayout.setHorizontalGroup(
            addCoverPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addCoverPanelLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(coverLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        addCoverPanelLayout.setVerticalGroup(
            addCoverPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addCoverPanelLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(coverLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bookYearPublished.setForeground(new java.awt.Color(79, 82, 78));
        bookYearPublished.setText("Year Published:");
        bookYearPublished.setBorderRadius(40);
        bookYearPublished.setBorderThickness(2.0F);

        bookEditionField.setForeground(new java.awt.Color(79, 82, 78));
        bookEditionField.setText("Book Edition:");
        bookEditionField.setBorderRadius(35);
        bookEditionField.setBorderThickness(2.0F);

        bookDescriptionLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        bookDescriptionLabel.setForeground(new java.awt.Color(79, 82, 78));
        bookDescriptionLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bookDescriptionLabel.setText("Description:");

        jScrollPane2.setBorder(null);

        bookDescriptionField.setBorderThickness(2.0F);
        jScrollPane2.setViewportView(bookDescriptionField);

        ISBNLabel.setForeground(new java.awt.Color(79, 82, 78));
        ISBNLabel.setText("ISBN:");

        callNumLabel.setForeground(new java.awt.Color(79, 82, 78));
        callNumLabel.setText("Call Number:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(confirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(211, 211, 211)
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ISBNLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(callNumLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(bookTagComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bookAuthorField, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bookTitleField, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bookYearPublished, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bookNumOfPagesField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bookEditionField, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(bookDescriptionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(addCoverPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 25, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(addBookHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(277, 277, 277)
                .addComponent(separator, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(addBookHeader)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(separator, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bookTitleField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bookDescriptionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bookAuthorField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bookTagComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)
                                .addComponent(bookEditionField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bookYearPublished, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(bookNumOfPagesField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)
                                .addComponent(ISBNLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(callNumLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                        .addGap(6, 6, 6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(addCoverPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(confirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void updateFocusedButton(Object source, int thickness) {
        JComponent[] components = {
            bookTitleField, bookAuthorField, bookTagComboBox,
            bookEditionField, bookYearPublished, bookNumOfPagesField,
            bookDescriptionField
        };

        for (JComponent comp : components) {
            if (source == comp) {
                if(comp instanceof custom.components.RoundedTextField){
                    ((custom.components.RoundedTextField) comp).setBorderThickness(thickness);
                    ((custom.components.RoundedTextField) comp).selectAll();
                }

                if(comp instanceof custom.components.RoundedTextArea){
                    ((custom.components.RoundedTextArea) comp).setBorderThickness(thickness);
                }

                if(comp instanceof custom.components.RoundedComboBox){
                    ((custom.components.RoundedComboBox) comp).setBorderThickness(thickness);
                }
                repaint();
                break;
            }
        }
    }

    private void initListeners(){

        //add focus listeners to fields

        java.awt.event.FocusListener fieldFocusListener = new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                FocusGained(evt);
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                FocusLost(evt);
            }
        };

        JComponent[] components = {
            bookTitleField, bookAuthorField, bookTagComboBox,
            bookEditionField, bookYearPublished, bookNumOfPagesField,
            bookDescriptionField
        };

        for (JComponent comp : components) {
            comp.addFocusListener(fieldFocusListener);
        }

        //add mouse listeners to buttons

        java.awt.event.MouseListener buttonsMouseListener = new java.awt.event.MouseAdapter() {
           public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MousePressed(evt);
            }
        };

        JComponent[] buttons = {
            confirmButton, backButton
        };

        for (JComponent comp : buttons){
            comp.addMouseListener(buttonsMouseListener);
        }
        
    }

    private void FocusGained(java.awt.event.FocusEvent evt){
        updateFocusedButton(evt.getSource(), 3);
    }
    
    String callNum = null;

    private void FocusLost(java.awt.event.FocusEvent evt){
        updateFocusedButton(evt.getSource(), 2);

        if(evt.getSource()==bookTagComboBox){
            if(!bookAuthorField.getText().isBlank() && !bookAuthorField.getText().equals("Book Author:") && 
                !AdminPage.editBookTag.equals(bookTagComboBox.getSelectedItem().toString())){

                String[] name = bookAuthorField.getText().trim().split(" ");
                String authorLastName = name[name.length-1];

                String tag = bookTagComboBox.getSelectedItem().toString();

                callNum = com.mycompany.library.functions.LibraryFunctions.generateCallNumber(tag, authorLastName);
                callNumLabel.setText("Call Number: " + callNum);
                repaint();
            } else{
                callNum = AdminPage.editBookcallNum;
            }
        }

    }

    private void buttonHover(Object source){

        JComponent[] buttons = {
            confirmButton, backButton
        };

        for (JComponent comp : buttons){
            if(source==comp){
                comp.setLocation(comp.getX(), comp.getY()-5);
            }
        }
    }

    private void buttonUnHover(Object source){

        JComponent[] buttons = {
            confirmButton, backButton
        };

        for (JComponent comp : buttons){
            if(source==comp){
                comp.setLocation(comp.getX(), comp.getY()+5);
            }
        }
    }

    private void MouseEntered(java.awt.event.MouseEvent evt){
        buttonHover(evt.getSource());
    }

    private void MouseExited(java.awt.event.MouseEvent evt){
        buttonUnHover(evt.getSource());
    }

    private void MousePressed(java.awt.event.MouseEvent evt){

        if(evt.getSource()==backButton){
            Window parentWindow = SwingUtilities.getWindowAncestor(this);
            if (parentWindow instanceof JDialog) {
                parentWindow.dispose();
            }
        }

        if(evt.getSource()==confirmButton){
            String title = bookTitleField.getText().trim();
            String author = bookAuthorField.getText().trim();
            String tag = bookTagComboBox.getSelectedItem().toString();
            String edition = bookEditionField.getText().trim();
            int yearPublished = Integer.parseInt(bookYearPublished.getText().trim());
            String description = bookDescriptionField.getText().trim();
            String[] isbnLabel = ISBNLabel.getText().split(":");
            String ISBN = isbnLabel[1].trim();
            int numOfPages = Integer.parseInt(bookNumOfPagesField.getText().trim());
            
            if(!AdminPage.editBookTag.equals(tag)){
                String[] name = author.split(" ");
                String authorLastName = name[name.length-1];

                callNum = com.mycompany.library.functions.LibraryFunctions.generateCallNumber(tag, authorLastName);
            } else{
                callNum = AdminPage.editBookcallNum;
            }
            

            if(com.mycompany.library.functions.LibraryFunctions.updateBookInDatabase(ISBN, title, edition, author, yearPublished, numOfPages, callNum, description, tag)){
                JOptionPane.showMessageDialog(this, "Book info edit success!");
                AdminFunctions.refreshBooksPanels();
                
                Window parentWindow = SwingUtilities.getWindowAncestor(this);

                if (parentWindow instanceof JDialog) parentWindow.dispose();

            } else{
                JOptionPane.showMessageDialog(this, "Failed");
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(adminEditBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(adminEditBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(adminEditBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(adminEditBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new adminEditBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel ISBNLabel;
    private javax.swing.JLabel addBookHeader;
    private custom.components.RoundedPanel addCoverPanel;
    private custom.components.CustomRoundedButton backButton;
    public custom.components.RoundedTextField bookAuthorField;
    public custom.components.RoundedTextArea bookDescriptionField;
    private javax.swing.JLabel bookDescriptionLabel;
    public custom.components.RoundedTextField bookEditionField;
    public custom.components.RoundedTextField bookNumOfPagesField;
    public custom.components.RoundedComboBox bookTagComboBox;
    public custom.components.RoundedTextField bookTitleField;
    public custom.components.RoundedTextField bookYearPublished;
    protected javax.swing.JLabel callNumLabel;
    private custom.components.CustomRoundedButton confirmButton;
    public javax.swing.JLabel coverLabel;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator separator;
    // End of variables declaration//GEN-END:variables
}
