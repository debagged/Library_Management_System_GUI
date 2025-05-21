package com.mycompany.library.ui.mainpage;
import java.awt.event.KeyEvent;

import javax.swing.JComponent;

import com.mycompany.library.ui.admin.AdminPage;
import com.mycompany.library.ui.student.StudentPage;

public class LogInPage extends javax.swing.JFrame {

    public static LogInPage instance;

    public LogInPage() {

        instance = this;

        initComponents();
        initListeners();
    }   

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new custom.components.RoundedPanel();
        headerLabel = new javax.swing.JLabel();
        unameLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        forgotPassLabel = new javax.swing.JLabel();
        signUpLabel = new javax.swing.JLabel();
        unameField = new custom.components.RoundedTextField();
        passField = new custom.components.RoundedPasswordField();
        signInButton = new custom.components.CustomRoundedButton();
        jSeparator1 = new javax.swing.JSeparator();
        invalidLogInMessage = new javax.swing.JLabel();
        emptyUnameMessage = new javax.swing.JLabel();
        emptyPassMessage = new javax.swing.JLabel();
        mainBackground_label = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Log In");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setMaximumSize(new java.awt.Dimension(24, 24));
        jPanel2.setPreferredSize(new java.awt.Dimension(280, 430));

        headerLabel.setBackground(new java.awt.Color(103, 120, 97));
        headerLabel.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        headerLabel.setForeground(new java.awt.Color(103, 120, 97));
        headerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headerLabel.setText("LOGIN");

        unameLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        unameLabel.setForeground(new java.awt.Color(79, 82, 78));
        unameLabel.setText("Username :");

        passwordLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        passwordLabel.setForeground(new java.awt.Color(79, 82, 78));
        passwordLabel.setText("Password :");

        forgotPassLabel.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        forgotPassLabel.setForeground(new java.awt.Color(79, 82, 78));
        forgotPassLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        forgotPassLabel.setText("Forgot Password?");
        forgotPassLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        signUpLabel.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        signUpLabel.setForeground(new java.awt.Color(79, 82, 78));
        signUpLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        signUpLabel.setText("Sign Up");

        unameField.setBorderThickness(2.0F);

        passField.setBorderThickness(2.0F);

        signInButton.setForeground(new java.awt.Color(255, 255, 255));
        signInButton.setText("Sign in");
        signInButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        invalidLogInMessage.setFont(new java.awt.Font("Segoe UI", 2, 10)); // NOI18N
        invalidLogInMessage.setForeground(new java.awt.Color(204, 0, 0));
        invalidLogInMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        emptyUnameMessage.setFont(new java.awt.Font("Segoe UI", 2, 10)); // NOI18N
        emptyUnameMessage.setForeground(new java.awt.Color(204, 0, 0));

        emptyPassMessage.setFont(new java.awt.Font("Segoe UI", 2, 10)); // NOI18N
        emptyPassMessage.setForeground(new java.awt.Color(204, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headerLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 22, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(passwordLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(emptyPassMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(unameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(emptyUnameMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator1)
                    .addComponent(passField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(unameField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(signInButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(invalidLogInMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addComponent(signUpLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(forgotPassLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(headerLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(unameLabel)
                    .addComponent(emptyUnameMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(unameField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordLabel)
                    .addComponent(emptyPassMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(invalidLogInMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(signInButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(forgotPassLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(signUpLabel)
                .addContainerGap())
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 92, 290, -1));

        mainBackground_label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mainBackground.png"))); // NOI18N
        mainBackground_label.setText("jLabel1");
        mainBackground_label.setMaximumSize(new java.awt.Dimension(800, 600));
        mainBackground_label.setMinimumSize(new java.awt.Dimension(800, 600));
        getContentPane().add(mainBackground_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    boolean isEnterPressed = false;

    private void initListeners(){

        //declaring methods for mouseAdapter
        java.awt.event.MouseAdapter mouseAdapter = new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MousePressed(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt){
                MouseExited(evt);
            }

            public void mouseEntered(java.awt.event.MouseEvent evt){
                MouseEntered(evt);
            }
        };

        //adding mouseAdapter to buttons
        JComponent[] buttons = {
            signInButton, forgotPassLabel, signUpLabel
        };

        for(JComponent comp : buttons){
            comp.addMouseListener(mouseAdapter);
        }

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
            unameField, passField
        };

        for (JComponent comp : components) {
            comp.addFocusListener(fieldFocusListener);
        }

        passField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if(evt.getKeyCode() == KeyEvent.VK_ENTER){

                    String result = MainPageFunctions.signIn();

                    if("Admin".equals(result)){
                        LogInPage.instance.setVisible(false);
                        new AdminPage().setVisible(true);

                    } else if(result != null){
                        LogInPage.instance.setVisible(false);
                        new StudentPage().setVisible(true);
                    }
                }
            }
        });

    }

    //method to update border thickness of components on focus
    private void updateBorderThickness(Object source, int thickness) {
        JComponent[] components = {
            unameField, passField
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

    private void MouseEntered(java.awt.event.MouseEvent evt){

        Object source = evt.getSource();

        if(source == forgotPassLabel){
            forgotPassLabel.setText("<html><u>Forgot&nbsp;Password?</html>");
        
        } else if(source == signUpLabel){
            signUpLabel.setText("<html><u>Sign&nbsp;Up</html>");
        
        } else if(source == signInButton){
            signInButton.setLocation(signInButton.getX(), signInButton.getY()-3);
        }

    }

    private void MouseExited(java.awt.event.MouseEvent evt){

        Object source = evt.getSource();

        if(source == forgotPassLabel){
            forgotPassLabel.setText("Forgot Password?");
        
        } else if(source == signUpLabel){
            signUpLabel.setText("Sign Up");
        
        } else if(source == signInButton){
            signInButton.setLocation(signInButton.getX(), signInButton.getY()+3);
        }
    
    }

    private void MousePressed(java.awt.event.MouseEvent evt) {
        
        if(evt.getSource()==signInButton){

            String result = MainPageFunctions.signIn();

            if("Admin".equals(result)){
                this.setVisible(false);
                new AdminPage().setVisible(true); 
            } else if (result != null){
                this.setVisible(false);
                new StudentPage().setVisible(true);
            }
        }

        if(evt.getSource()==forgotPassLabel){
            this.setVisible(false);
            new com.mycompany.library.ui.mainpage.ForgotPassPage().setVisible(true);
            return;
        }

        if(evt.getSource()==signUpLabel){
            this.setVisible(false);
            new com.mycompany.library.ui.mainpage.RegisterPage().setVisible(true);
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
            java.util.logging.Logger.getLogger(LogInPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LogInPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LogInPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LogInPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new com.mycompany.library.ui.mainpage.LogInPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected static javax.swing.JLabel emptyPassMessage;
    protected static javax.swing.JLabel emptyUnameMessage;
    private javax.swing.JLabel forgotPassLabel;
    private javax.swing.JLabel headerLabel;
    protected static javax.swing.JLabel invalidLogInMessage;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel mainBackground_label;
    protected static custom.components.RoundedPasswordField passField;
    private javax.swing.JLabel passwordLabel;
    private custom.components.CustomRoundedButton signInButton;
    private javax.swing.JLabel signUpLabel;
    protected static custom.components.RoundedTextField unameField;
    private javax.swing.JLabel unameLabel;
    // End of variables declaration//GEN-END:variables
}