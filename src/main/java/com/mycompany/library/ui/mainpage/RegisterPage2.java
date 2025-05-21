package com.mycompany.library.ui.mainpage;

import java.awt.event.KeyEvent;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.mycompany.library.users.UserData;

public class RegisterPage2 extends javax.swing.JFrame {

    public RegisterPage2() {
        initComponents();
        initListeners();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        headerLabel = new javax.swing.JLabel();
        createUnameLabel = new javax.swing.JLabel();
        createPassLabel = new javax.swing.JLabel();
        confirmButton = new custom.components.CustomRoundedButton();
        backLabel = new javax.swing.JLabel();
        confirmPassLabel = new javax.swing.JLabel();
        emptyUnameMessage = new javax.swing.JLabel();
        login_seperator = new javax.swing.JSeparator();
        emptyNewPassMessage = new javax.swing.JLabel();
        emptyConfirmPassMessage = new javax.swing.JLabel();
        newUnameField = new custom.components.RoundedTextField();
        newPassField = new custom.components.RoundedPasswordField();
        confirmNewPassField = new custom.components.RoundedPasswordField();
        mainBackground_label = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setMaximumSize(new java.awt.Dimension(24, 24));
        jPanel2.setPreferredSize(new java.awt.Dimension(280, 430));

        headerLabel.setBackground(new java.awt.Color(103, 120, 97));
        headerLabel.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        headerLabel.setForeground(new java.awt.Color(103, 120, 97));
        headerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headerLabel.setText("REGISTER");

        createUnameLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        createUnameLabel.setForeground(new java.awt.Color(79, 82, 78));
        createUnameLabel.setText("Create Username :");

        createPassLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        createPassLabel.setForeground(new java.awt.Color(79, 82, 78));
        createPassLabel.setText("Create Password :");

        confirmButton.setBackground(new java.awt.Color(103, 120, 97));
        confirmButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        confirmButton.setForeground(new java.awt.Color(255, 255, 255));
        confirmButton.setText("Confirm");
        confirmButton.setFocusable(false);

        backLabel.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        backLabel.setForeground(new java.awt.Color(79, 82, 78));
        backLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        backLabel.setText("Back");

        confirmPassLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        confirmPassLabel.setForeground(new java.awt.Color(79, 82, 78));
        confirmPassLabel.setText("Confirm Password :");

        emptyUnameMessage.setFont(new java.awt.Font("Segoe UI", 2, 10)); // NOI18N
        emptyUnameMessage.setForeground(new java.awt.Color(204, 0, 0));
        emptyUnameMessage.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        login_seperator.setBackground(new java.awt.Color(103, 120, 97));

        emptyNewPassMessage.setFont(new java.awt.Font("Segoe UI", 2, 10)); // NOI18N
        emptyNewPassMessage.setForeground(new java.awt.Color(204, 0, 0));
        emptyNewPassMessage.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        emptyConfirmPassMessage.setFont(new java.awt.Font("Segoe UI", 2, 10)); // NOI18N
        emptyConfirmPassMessage.setForeground(new java.awt.Color(204, 0, 0));
        emptyConfirmPassMessage.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(headerLabel)
                .addGap(64, 64, 64))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 8, Short.MAX_VALUE)
                        .addComponent(confirmPassLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(emptyConfirmPassMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(backLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(confirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(createPassLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(emptyNewPassMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(createUnameLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(emptyUnameMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap(14, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(login_seperator, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(newUnameField, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(newPassField, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(confirmNewPassField, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(headerLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(login_seperator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createUnameLabel)
                    .addComponent(emptyUnameMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(newUnameField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createPassLabel)
                    .addComponent(emptyNewPassMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newPassField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmPassLabel)
                    .addComponent(emptyConfirmPassMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(confirmNewPassField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(confirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(backLabel)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, 290, -1));

        mainBackground_label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mainBackground.png"))); // NOI18N
        mainBackground_label.setText("jLabel1");
        getContentPane().add(mainBackground_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void initListeners(){

        java.awt.event.MouseAdapter mouseAdapter = new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MousePressed(evt);
            }

            public void mouseEntered(java.awt.event.MouseEvent evt){
                MouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt){
                MouseExited(evt);
            }
        };

        JComponent[] buttons = { confirmButton, backLabel };

        for(JComponent comp : buttons) comp.addMouseListener(mouseAdapter);

        confirmNewPassField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if(evt.getKeyCode() == KeyEvent.VK_ENTER){
                    confirmButton.doClick();
                }
            }
        });
    }

    private void MouseEntered(java.awt.event.MouseEvent evt){
        if(evt.getSource()==backLabel){
            backLabel.setText("<html><u>Back</html>");
        }

        if(evt.getSource()==confirmButton){
            confirmButton.setLocation(confirmButton.getX(), confirmButton.getY()-3);
        }
    }

    private void MouseExited(java.awt.event.MouseEvent evt){
        if(evt.getSource()==backLabel){
            backLabel.setText("Back");
        }

        if(evt.getSource()==confirmButton){
            confirmButton.setLocation(confirmButton.getX(), confirmButton.getY()+3);
        }
    }

    private void MousePressed(java.awt.event.MouseEvent evt){

        String username = newUnameField.getText().trim();
        String pass = String.valueOf(newPassField.getPassword());
        String confirmPass = String.valueOf(confirmNewPassField.getPassword());
        String userID = RegisterPage.studIDField.getText().trim();

        if(evt.getSource()==backLabel){
            this.dispose();
            new RegisterPage().setVisible(true);
        }

        if(evt.getSource()==confirmButton){

            if(username.isBlank()){
                MainPageFunctions.emptyFieldError(newUnameField, emptyUnameMessage,"please enter your username");
                return;
            }

            if(pass.isBlank()){
                MainPageFunctions.emptyFieldError(newPassField, emptyNewPassMessage, "please enter your password");
                return;
            }

            if(confirmPass.isBlank()){
                MainPageFunctions.emptyFieldError(confirmNewPassField, emptyConfirmPassMessage, "please confirm your password");
                return;
            }

            if(!pass.equals(confirmPass)){
                MainPageFunctions.emptyFieldError(newPassField, emptyNewPassMessage, "passwords must match");
                MainPageFunctions.emptyFieldError(confirmNewPassField, emptyConfirmPassMessage, "passwords must match");
                return;
            }else{
                

                if(UserData.registerUserLoginToDB(userID, username, confirmPass)){

                    JOptionPane.showMessageDialog(rootPane, "Successfully registered!");
                    newPassField.setText(null);
                    newPassField.setText(null);
                    confirmNewPassField.setText(null);
                    this.dispose();
                    new LogInPage().setVisible(true);
                    
                }else{
                    JOptionPane.showMessageDialog(rootPane, "Register Failed!");
                }
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
            java.util.logging.Logger.getLogger(RegisterPage2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterPage2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterPage2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterPage2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisterPage2().setVisible(true);
            }});
        }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backLabel;
    private javax.swing.JButton confirmButton;
    private custom.components.RoundedPasswordField confirmNewPassField;
    private javax.swing.JLabel confirmPassLabel;
    private javax.swing.JLabel createPassLabel;
    private javax.swing.JLabel createUnameLabel;
    private javax.swing.JLabel emptyConfirmPassMessage;
    private javax.swing.JLabel emptyNewPassMessage;
    private javax.swing.JLabel emptyUnameMessage;
    private javax.swing.JLabel headerLabel;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator login_seperator;
    private javax.swing.JLabel mainBackground_label;
    private custom.components.RoundedPasswordField newPassField;
    private custom.components.RoundedTextField newUnameField;
    // End of variables declaration//GEN-END:variables
}
