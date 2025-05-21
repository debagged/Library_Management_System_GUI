package com.mycompany.library.ui.mainpage;

import java.awt.event.KeyEvent;

import javax.swing.JComponent;

public class ForgotPassPage extends javax.swing.JFrame {

    public ForgotPassPage() {
        initComponents();
        initListeners();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new custom.components.RoundedPanel();
        headerLabel = new javax.swing.JLabel();
        newPassLabel = new javax.swing.JLabel();
        confirmNewPassLabel = new javax.swing.JLabel();
        confirmButton = new custom.components.CustomRoundedButton();
        logInLabel = new javax.swing.JLabel();
        emptyUnameMessage = new javax.swing.JLabel();
        unameLabel = new javax.swing.JLabel();
        emptyPassMessage = new javax.swing.JLabel();
        emptyConfirmPassMessage = new javax.swing.JLabel();
        passField = new custom.components.RoundedPasswordField();
        confirmPassField = new custom.components.RoundedPasswordField();
        unameField = new custom.components.RoundedTextField();
        jSeparator1 = new javax.swing.JSeparator();
        mainBackground_label = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Forgot Password");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(252, 255, 242));
        jPanel2.setMaximumSize(new java.awt.Dimension(24, 24));
        jPanel2.setPreferredSize(new java.awt.Dimension(280, 430));

        headerLabel.setBackground(new java.awt.Color(103, 120, 97));
        headerLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        headerLabel.setForeground(new java.awt.Color(103, 120, 97));
        headerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headerLabel.setText("PASSWORD RESET");

        newPassLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        newPassLabel.setForeground(new java.awt.Color(79, 82, 78));
        newPassLabel.setText("New Password:");

        confirmNewPassLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        confirmNewPassLabel.setForeground(new java.awt.Color(79, 82, 78));
        confirmNewPassLabel.setText("Confirm Password:");

        confirmButton.setBackground(new java.awt.Color(103, 120, 97));
        confirmButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        confirmButton.setForeground(new java.awt.Color(255, 255, 255));
        confirmButton.setText("Confirm");
        confirmButton.setFocusable(false);

        logInLabel.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        logInLabel.setForeground(new java.awt.Color(79, 82, 78));
        logInLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logInLabel.setText("Log In");
        logInLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        emptyUnameMessage.setFont(new java.awt.Font("Segoe UI", 2, 10)); // NOI18N
        emptyUnameMessage.setForeground(new java.awt.Color(204, 0, 0));
        emptyUnameMessage.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        unameLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        unameLabel.setForeground(new java.awt.Color(79, 82, 78));
        unameLabel.setText("Username:");

        emptyPassMessage.setFont(new java.awt.Font("Segoe UI", 2, 10)); // NOI18N
        emptyPassMessage.setForeground(new java.awt.Color(204, 0, 0));
        emptyPassMessage.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        emptyConfirmPassMessage.setFont(new java.awt.Font("Segoe UI", 2, 10)); // NOI18N
        emptyConfirmPassMessage.setForeground(new java.awt.Color(204, 0, 0));
        emptyConfirmPassMessage.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        passField.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(103, 120, 97)), javax.swing.BorderFactory.createEmptyBorder(0, 12, 0, 12)));
        passField.setBorderThickness(2.0F);

        confirmPassField.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(103, 120, 97)), javax.swing.BorderFactory.createEmptyBorder(0, 12, 0, 12)));
        confirmPassField.setBorderThickness(2.0F);

        unameField.setBorderThickness(2.0F);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(headerLabel))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(confirmNewPassLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(emptyConfirmPassMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(confirmPassField, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(confirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(logInLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(unameLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(emptyUnameMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(newPassLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(emptyPassMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(passField, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(unameField, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(headerLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(unameLabel)
                    .addComponent(emptyUnameMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(unameField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newPassLabel)
                    .addComponent(emptyPassMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(emptyConfirmPassMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(confirmNewPassLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(confirmPassField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(confirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logInLabel)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, 290, -1));

        mainBackground_label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mainBackground.png"))); // NOI18N
        mainBackground_label.setText("jLabel1");
        getContentPane().add(mainBackground_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void initListeners(){

        //declaring methods for mouseAdapter
        java.awt.event.MouseAdapter mouseAdapter = new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MousePressed(evt);
            }

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseExited(evt);
            }
        };

        //adding mouseAdapter to components
        JComponent[] buttons = { confirmButton, logInLabel };

        for (JComponent comp : buttons) comp.addMouseListener(mouseAdapter);

        //declaring methods for focusListener
        java.awt.event.FocusListener fieldFocusListener = new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                FocusGained(evt);
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                FocusLost(evt);
            }
        };

        //adding focus listener to components
        JComponent[] components = {
            unameField, passField, confirmPassField
        };

        for (JComponent comp : components) {
            comp.addFocusListener(fieldFocusListener);
        }

        confirmPassField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if(evt.getKeyCode() == KeyEvent.VK_ENTER){
                    MainPageFunctions.resetPass();
                }
            }
        });
    }

    //method to update border thickness of components on focus
    private void updateBorderThickness(Object source, int thickness) {
        JComponent[] components = {
            unameField, passField, confirmPassField
        };

        for (JComponent comp : components) {
            if (source == comp) {
                if(comp instanceof custom.components.RoundedTextField){
                    ((custom.components.RoundedTextField) comp).setBorderThickness(thickness);
                }

                if(comp instanceof custom.components.RoundedPasswordField){
                    ((custom.components.RoundedPasswordField) comp).setBorderThickness(thickness);
                }
                repaint();
                break;
            }
        }
    }

    public void FocusGained(java.awt.event.FocusEvent evt){
        updateBorderThickness(evt.getSource(), 3);
    }

    public void FocusLost(java.awt.event.FocusEvent evt){
        updateBorderThickness(evt.getSource(), 2);
    }

    private void MouseEntered(java.awt.event.MouseEvent evt) {
        if(evt.getSource()==logInLabel){
            logInLabel.setText("<html><u>Log&nbsp;In</html>");
        }

        if(evt.getSource()==confirmButton){
            confirmButton.setLocation(confirmButton.getX(), confirmButton.getY()-3);
        }
    }

    private void MouseExited(java.awt.event.MouseEvent evt) {
        if(evt.getSource()==logInLabel){
            logInLabel.setText("Log In");
        }

        if(evt.getSource()==confirmButton){
            confirmButton.setLocation(confirmButton.getX(), confirmButton.getY()+3);
        }
    }

    private void MousePressed(java.awt.event.MouseEvent evt) {

        if(evt.getSource()==confirmButton){
            MainPageFunctions.resetPass();

        } else if(evt.getSource()==logInLabel){
            this.setVisible(false);
            new com.mycompany.library.ui.mainpage.LogInPage().setVisible(true);
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
            java.util.logging.Logger.getLogger(ForgotPassPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ForgotPassPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ForgotPassPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);    
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ForgotPassPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new com.mycompany.library.ui.mainpage.ForgotPassPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton confirmButton;
    private javax.swing.JLabel confirmNewPassLabel;
    protected static custom.components.RoundedPasswordField confirmPassField;
    protected static javax.swing.JLabel emptyConfirmPassMessage;
    protected static javax.swing.JLabel emptyPassMessage;
    protected static javax.swing.JLabel emptyUnameMessage;
    private javax.swing.JLabel headerLabel;
    protected static javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel logInLabel;
    private javax.swing.JLabel mainBackground_label;
    private javax.swing.JLabel newPassLabel;
    protected static custom.components.RoundedPasswordField passField;
    protected static custom.components.RoundedTextField unameField;
    private javax.swing.JLabel unameLabel;
    // End of variables declaration//GEN-END:variables
}
