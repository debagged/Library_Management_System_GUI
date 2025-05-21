package com.mycompany.library.ui.mainpage;

import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.mycompany.library.users.UserData;

public class RegisterPage extends javax.swing.JFrame {

    public RegisterPage() {
        initComponents();
        initListeners();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new custom.components.RoundedPanel();
        headerLabel = new javax.swing.JLabel();
        fnameLabel = new javax.swing.JLabel();
        mnameLabel = new javax.swing.JLabel();
        nextButton = new custom.components.CustomRoundedButton();
        logInLabel = new javax.swing.JLabel();
        lnameLabel = new javax.swing.JLabel();
        suffixLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        studIDLabel = new javax.swing.JLabel();
        courseLabel = new javax.swing.JLabel();
        sexLabel = new javax.swing.JLabel();
        errorMessage = new javax.swing.JLabel();
        login_seperator = new javax.swing.JSeparator();
        fnameField = new custom.components.RoundedTextField();
        mnameField = new custom.components.RoundedTextField();
        lnameField = new custom.components.RoundedTextField();
        studIDField = new custom.components.RoundedTextField();
        emailField = new custom.components.RoundedTextField();
        suffixComboBox = new custom.components.RoundedComboBox();
        sexComboBox = new custom.components.RoundedComboBox();
        courseComboBox = new custom.components.RoundedComboBox();
        register_seperator = new javax.swing.JSeparator();
        mainBackground_label = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Register");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(252, 255, 242));
        jPanel2.setMaximumSize(new java.awt.Dimension(24, 24));
        jPanel2.setPreferredSize(new java.awt.Dimension(460, 430));

        headerLabel.setBackground(new java.awt.Color(103, 120, 97));
        headerLabel.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        headerLabel.setForeground(new java.awt.Color(79, 82, 78));
        headerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headerLabel.setText("REGISTER");

        fnameLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        fnameLabel.setForeground(new java.awt.Color(79, 82, 78));
        fnameLabel.setText("First Name:");
        fnameLabel.setFocusable(false);
        fnameLabel.setRequestFocusEnabled(false);

        mnameLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        mnameLabel.setForeground(new java.awt.Color(79, 82, 78));
        mnameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mnameLabel.setText("Middle Name:");
        mnameLabel.setFocusable(false);
        mnameLabel.setRequestFocusEnabled(false);

        nextButton.setBackground(new java.awt.Color(103, 120, 97));
        nextButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        nextButton.setForeground(new java.awt.Color(252, 255, 242));
        nextButton.setText("Next");

        logInLabel.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        logInLabel.setForeground(new java.awt.Color(79, 82, 78));
        logInLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logInLabel.setText("Log in");
        logInLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lnameLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lnameLabel.setForeground(new java.awt.Color(79, 82, 78));
        lnameLabel.setText("Last Name:");
        lnameLabel.setFocusable(false);
        lnameLabel.setRequestFocusEnabled(false);

        suffixLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        suffixLabel.setForeground(new java.awt.Color(79, 82, 78));
        suffixLabel.setText("Suffix:");
        suffixLabel.setFocusable(false);
        suffixLabel.setRequestFocusEnabled(false);

        emailLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        emailLabel.setForeground(new java.awt.Color(79, 82, 78));
        emailLabel.setText("Fatima Email:");
        emailLabel.setFocusable(false);
        emailLabel.setRequestFocusEnabled(false);

        studIDLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        studIDLabel.setForeground(new java.awt.Color(79, 82, 78));
        studIDLabel.setText("Student ID:");
        studIDLabel.setFocusable(false);
        studIDLabel.setRequestFocusEnabled(false);

        courseLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        courseLabel.setForeground(new java.awt.Color(79, 82, 78));
        courseLabel.setText("Course:");
        courseLabel.setFocusable(false);
        courseLabel.setRequestFocusEnabled(false);

        sexLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        sexLabel.setForeground(new java.awt.Color(79, 82, 78));
        sexLabel.setText("Sex:");
        sexLabel.setFocusable(false);
        sexLabel.setRequestFocusEnabled(false);

        errorMessage.setFont(new java.awt.Font("Segoe UI", 2, 10)); // NOI18N
        errorMessage.setForeground(new java.awt.Color(204, 0, 0));
        errorMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        login_seperator.setBackground(new java.awt.Color(103, 120, 97));

        fnameField.setBorderRadius(30);
        fnameField.setBorderThickness(2.0F);

        mnameField.setBorderThickness(2.0F);

        lnameField.setBorderThickness(2.0F);

        studIDField.setBorderThickness(2.0F);

        emailField.setBorderThickness(2.0F);

        suffixComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "None", "Jr.", "II.", "Other(input)" }));
        suffixComboBox.setBorderRadius(35);
        suffixComboBox.setBorderThickness(2.0F);

        sexComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Male", "Female" }));
        sexComboBox.setBorderRadius(35);
        sexComboBox.setBorderThickness(2.0F);

        courseComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Science, Technology, Engineering, and Mathematics", "Humanities and Social Sciences", "Accountancy, Business, and Management", "Hospitality and International Management", "Nursing", "Medical Laboratory Science", "Pharmacy", "Physical Therapy", "Accountancy", "Computer Science" }));
        courseComboBox.setBorderRadius(35);
        courseComboBox.setBorderThickness(2.0F);
        courseComboBox.setMaximumSize(new java.awt.Dimension(206, 30));

        register_seperator.setBackground(new java.awt.Color(103, 120, 97));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(147, 147, 147)
                .addComponent(headerLabel)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logInLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(199, 199, 199))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(login_seperator, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addComponent(fnameLabel))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addComponent(suffixLabel))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addComponent(lnameLabel))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(mnameLabel))
                            .addComponent(suffixComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mnameField, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lnameField, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fnameField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(84, 84, 84)
                                        .addComponent(sexLabel))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(studIDLabel)
                                        .addGap(75, 75, 75))
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(studIDField, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(sexComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(courseComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(89, 89, 89)
                                .addComponent(courseLabel))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(emailLabel)
                                .addGap(72, 72, 72))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(errorMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(headerLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(login_seperator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fnameLabel)
                    .addComponent(sexLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fnameField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sexComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mnameLabel)
                    .addComponent(courseLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mnameField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(courseComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lnameLabel)
                    .addComponent(studIDLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lnameField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(studIDField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailLabel)
                    .addComponent(suffixLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(suffixComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(errorMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logInLabel)
                .addGap(18, 18, 18))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, -1, -1));

        mainBackground_label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mainBackground.png"))); // NOI18N
        mainBackground_label.setText("jLabel1");
        getContentPane().add(mainBackground_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
  
    private void initListeners(){

        java.awt.event.MouseAdapter mouseAdapter = new java.awt.event.MouseAdapter(){
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

        JComponent[] buttons = { nextButton, logInLabel };

        for (JComponent comp : buttons) comp.addMouseListener(mouseAdapter);


        suffixComboBox.addActionListener(evt ->{
            suffixComboBoxActionPerformed(evt);
        });

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
            fnameField, mnameField, lnameField,
            suffixComboBox, sexComboBox, courseComboBox,
            studIDField, emailField
        };

        for (JComponent comp : components) comp.addFocusListener(fieldFocusListener);
    }

    private void suffixComboBoxActionPerformed(java.awt.event.ActionEvent evt) {
        String selected = (String) suffixComboBox.getSelectedItem();

        if("Other(input)".equals(selected)){
            suffixComboBox.setEditable(true);
            suffixComboBox.requestFocusInWindow();
        
        }else{
            suffixComboBox.setEditable(false);
        }
    }

    //method to update border thickness of components on focus
    private void updateBorderThickness(Object source, int thickness) {
        JComponent[] components = {
            fnameField, mnameField, lnameField,
            suffixComboBox, sexComboBox, courseComboBox,
            studIDField, emailField
        };

        for (JComponent comp : components) {
            if (source == comp) {
                if(comp instanceof custom.components.RoundedTextField){
                    ((custom.components.RoundedTextField) comp).setBorderThickness(thickness);
                }

                if(comp instanceof custom.components.RoundedComboBox){
                    ((custom.components.RoundedComboBox) comp).setBorderThickness(thickness);
                }
                repaint();
                break;
            }
        }
    }

    private void FocusGained(java.awt.event.FocusEvent evt){
        updateBorderThickness(evt.getSource(), 3);
    }
    
    private void FocusLost(java.awt.event.FocusEvent evt){
        updateBorderThickness(evt.getSource(), 2);
    }

    private void MouseEntered(java.awt.event.MouseEvent evt) {
        if(evt.getSource()==logInLabel){
            logInLabel.setText("<html><u>Log&nbsp;In</html>");
        }

        if(evt.getSource()==nextButton){
            nextButton.setLocation(nextButton.getX(), nextButton.getY()-3);
        }
    }

    private void MouseExited(java.awt.event.MouseEvent evt) {
        if(evt.getSource()==logInLabel){
            logInLabel.setText("Log In");
        }

        if(evt.getSource()==nextButton){
            nextButton.setLocation(nextButton.getX(), nextButton.getY()+3);
        }
    }

    private void MousePressed(java.awt.event.MouseEvent evt){ 

        String given_name = fnameField.getText().trim().toUpperCase();
        String middle_name = mnameField.getText().trim().toUpperCase();
        String last_name = lnameField.getText().trim().toUpperCase();
        String suffix = suffixComboBox.isEditable() ? (String) suffixComboBox.getEditor().getItem() : (String) suffixComboBox.getSelectedItem();
        String sex = sexComboBox.getSelectedItem().toString().trim();
        String course = courseComboBox.getSelectedItem().toString().trim();
        String user_ID = studIDField.getText().trim();
        String campus_email = emailField.getText().trim();

        if(evt.getSource()==logInLabel){
            this.setVisible(false);
            new com.mycompany.library.ui.mainpage.LogInPage().setVisible(true);
        }

        if(evt.getSource()==nextButton){

            if(given_name.isBlank() ||
                middle_name.isBlank()||
                last_name.isBlank() ||
                user_ID.isBlank() ||
                campus_email.isBlank()){

                JTextField[] components = {
                    fnameField, mnameField, lnameField,
                    studIDField, emailField
                };

                for(JTextField comp1 : components){
                    if(comp1.getText().isBlank()) continue;
                    ((custom.components.RoundedTextField) comp1).setBorderColor(java.awt.Color.decode("#667961"));
                }

                for(JTextField comp : components){
                    if(!comp.getText().isBlank()) continue;
                    MainPageFunctions.borderError(comp);
                }

                errorMessage.setText("Please fill out empty fields");
                return;
            }
            
            if(suffix.equals("None")) suffix = "";

            if (!UserData.isEmailValid(given_name, middle_name, last_name, user_ID, campus_email)) {
                JOptionPane.showMessageDialog(null, "Invalid OLFU email. Registration failed.", "Wrong Email",JOptionPane.ERROR_MESSAGE);
                return;
            }

            if(UserData.isUserIDExisting(user_ID)){
                JOptionPane.showMessageDialog(null, "User ID already Exisiting, Please Try Again", "User ID Duplication",JOptionPane.ERROR_MESSAGE);
                return;
            }

            boolean isUserRegistered =
            UserData.registerUserDataToDB(user_ID, given_name, middle_name, last_name, sex, campus_email, course);

            if(isUserRegistered){
                this.dispose();
                new RegisterPage2().setVisible(true);;
            }else{
                JOptionPane.showMessageDialog(rootPane, "Register Failed!");
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
            java.util.logging.Logger.getLogger(RegisterPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new com.mycompany.library.ui.mainpage.RegisterPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private custom.components.RoundedComboBox courseComboBox;
    private javax.swing.JLabel courseLabel;
    private custom.components.RoundedTextField emailField;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JLabel errorMessage;
    protected static custom.components.RoundedTextField fnameField;
    private javax.swing.JLabel fnameLabel;
    private javax.swing.JLabel headerLabel;
    private javax.swing.JPanel jPanel2;
    private custom.components.RoundedTextField lnameField;
    private javax.swing.JLabel lnameLabel;
    private javax.swing.JLabel logInLabel;
    private javax.swing.JSeparator login_seperator;
    private javax.swing.JLabel mainBackground_label;
    private custom.components.RoundedTextField mnameField;
    private javax.swing.JLabel mnameLabel;
    private javax.swing.JButton nextButton;
    private javax.swing.JSeparator register_seperator;
    private custom.components.RoundedComboBox sexComboBox;
    private javax.swing.JLabel sexLabel;
    protected static custom.components.RoundedTextField studIDField;
    private javax.swing.JLabel studIDLabel;
    private custom.components.RoundedComboBox suffixComboBox;
    private javax.swing.JLabel suffixLabel;
    // End of variables declaration//GEN-END:variables
}
