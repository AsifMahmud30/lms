package JFrame;
import java.sql.*;
import javax.swing.*;

public class StudentSignUpPage extends javax.swing.JFrame {
    
    private String name;
    private String password;
    private String studentID;
    private String email;
    private String batch;
    private String depertment;
    
    
    
    public StudentSignUpPage() {
        initComponents();
    }
    public StudentSignUpPage(String studentID){
        this.studentID=studentID;
    }
    
    //implimenting a method to insert the login information into the database
    public void insertSingupDetails(){
        name=txtStudentName.getText();
        password=txtStudentPassword.getText();
        studentID=txtStudentID.getText();
        email=txtStudentEmail.getText();
        batch=txtBatch.getText();
        depertment=txtDepertment.getText();
        
        try{
           Connection connection=DatabaseConnectionClass.getConnection();
           String sql="insert into students (name,studentID,email,password,batch,depertment) values(?,?,?,?,?,?)";
           PreparedStatement  statement=  connection.prepareStatement(sql);
           
           statement.setString(1,name);
           statement.setString(2,studentID);
           statement.setString(3,email);
           statement.setString(4,password);
           statement.setString(5,batch);
           statement.setString(6,depertment);
           
           int updateRowCount =statement.executeUpdate();
           
           if(updateRowCount>0){
               JOptionPane.showMessageDialog(this,"Done");
               StudentLoginPage loginPage=new StudentLoginPage();
               loginPage.setVisible(true);
               dispose();
           }else{
               JOptionPane.showMessageDialog(this,"Failed");
           }
          
        }catch(Exception e){ 
            e.getMessage();
        }
    }
    public String ID(){
        return studentID;
    }
    
    //data validation
    public boolean validationSignup(){
        String name=txtStudentName.getText();
        String password=txtDepertment.getText();
        String userName=txtStudentID.getText();
        String email=txtStudentEmail.getText();
        if(name.equals("")||password.equals("")||userName.equals("")||email.equals("")){
            JOptionPane.showMessageDialog(this,"Please fill up the information");
            return false;
        }
        return true;
    }
    //check duplicate user
    public boolean duplicateUserNameChecker(){
        String userName=txtStudentID.getText();
        
        boolean userNameExist=false;
        try{
            Connection connection = DatabaseConnectionClass.getConnection();
            
            PreparedStatement statement= connection.prepareStatement("select * from users where userName =?");
            statement.setString(1, userName);
            ResultSet resultState=statement.executeQuery();
            if(resultState.next()){
                userNameExist=true;
            }else {
                userNameExist=false;
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return userNameExist;
    }
    public boolean duplicateEmailChecker(){
        String email=txtStudentEmail.getText();
        
        boolean emailExist=false;
        try{
            Connection connection = DatabaseConnectionClass.getConnection();
            
            PreparedStatement statement= connection.prepareStatement("select * from users where email =?");
            statement.setString(1, email);
            ResultSet resultState=statement.executeQuery();
            if(resultState.next()){
                emailExist=true;
            }else {
                emailExist=false;
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return emailExist;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */ 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        StudentSignupPagePanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        SSignUpPageLabel = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtStudentID = new app.bolivia.swing.JCTextField();
        txtDepertment = new app.bolivia.swing.JCTextField();
        txtStudentEmail = new app.bolivia.swing.JCTextField();
        txtStudentName = new app.bolivia.swing.JCTextField();
        studentLoginButton = new rojeru_san.complementos.RSButtonHover();
        jLabel7 = new javax.swing.JLabel();
        studentSignupButton = new rojeru_san.complementos.RSButtonHover();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtStudentPassword = new app.bolivia.swing.JCTextField();
        txtBatch = new app.bolivia.swing.JCTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        StudentSignupPagePanel.setBackground(new java.awt.Color(255, 255, 255));
        StudentSignupPagePanel.setForeground(new java.awt.Color(0, 0, 0));
        StudentSignupPagePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(102, 102, 102));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(99, 166, 211));
        jLabel3.setText("Library Managemnet System");
        StudentSignupPagePanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        SSignUpPageLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons/library-concept-students-coworking-space-vector-27466179.jpg"))); // NOI18N
        SSignUpPageLabel.setText("jLabel5");
        StudentSignupPagePanel.add(SSignUpPageLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, 490, 600));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Already have an account?");
        StudentSignupPagePanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, 210, 30));

        txtStudentID.setBackground(new java.awt.Color(255, 255, 255));
        txtStudentID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(99, 166, 211)));
        txtStudentID.setForeground(new java.awt.Color(102, 102, 102));
        txtStudentID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtStudentID.setPlaceholder("Student ID");
        txtStudentID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtStudentIDFocusLost(evt);
            }
        });
        txtStudentID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStudentIDActionPerformed(evt);
            }
        });
        StudentSignupPagePanel.add(txtStudentID, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 290, -1));

        txtDepertment.setBackground(new java.awt.Color(255, 255, 255));
        txtDepertment.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(99, 166, 211)));
        txtDepertment.setForeground(new java.awt.Color(102, 102, 102));
        txtDepertment.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtDepertment.setPlaceholder("Depertment");
        txtDepertment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDepertmentActionPerformed(evt);
            }
        });
        StudentSignupPagePanel.add(txtDepertment, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 290, -1));

        txtStudentEmail.setBackground(new java.awt.Color(255, 255, 255));
        txtStudentEmail.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(99, 166, 211)));
        txtStudentEmail.setForeground(new java.awt.Color(102, 102, 102));
        txtStudentEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtStudentEmail.setPlaceholder("Email");
        txtStudentEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtStudentEmailFocusLost(evt);
            }
        });
        txtStudentEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStudentEmailActionPerformed(evt);
            }
        });
        StudentSignupPagePanel.add(txtStudentEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 290, -1));

        txtStudentName.setBackground(new java.awt.Color(255, 255, 255));
        txtStudentName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(99, 166, 211)));
        txtStudentName.setForeground(new java.awt.Color(102, 102, 102));
        txtStudentName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtStudentName.setPlaceholder("Name");
        txtStudentName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStudentNameActionPerformed(evt);
            }
        });
        StudentSignupPagePanel.add(txtStudentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 290, -1));

        studentLoginButton.setBackground(new java.awt.Color(99, 166, 211));
        studentLoginButton.setText("LOGIN");
        studentLoginButton.setColorHover(new java.awt.Color(51, 153, 255));
        studentLoginButton.setColorTextHover(new java.awt.Color(204, 204, 204));
        studentLoginButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        studentLoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentLoginButtonActionPerformed(evt);
            }
        });
        StudentSignupPagePanel.add(studentLoginButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 490, 160, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Please insert your information to SIGNUP");
        jLabel7.setFocusable(false);
        StudentSignupPagePanel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 340, 30));

        studentSignupButton.setBackground(new java.awt.Color(99, 166, 211));
        studentSignupButton.setText("SIGNUP");
        studentSignupButton.setColorHover(new java.awt.Color(51, 153, 255));
        studentSignupButton.setColorTextHover(new java.awt.Color(204, 204, 204));
        studentSignupButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        studentSignupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentSignupButtonActionPerformed(evt);
            }
        });
        StudentSignupPagePanel.add(studentSignupButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 160, 30));

        jLabel2.setBackground(new java.awt.Color(102, 102, 102));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 51));
        jLabel2.setText("Error");
        StudentSignupPagePanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, -1, -1));

        jLabel8.setBackground(new java.awt.Color(102, 102, 102));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Runtime");
        StudentSignupPagePanel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        txtStudentPassword.setBackground(new java.awt.Color(255, 255, 255));
        txtStudentPassword.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(99, 166, 211)));
        txtStudentPassword.setForeground(new java.awt.Color(102, 102, 102));
        txtStudentPassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtStudentPassword.setPlaceholder("Password");
        txtStudentPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStudentPasswordActionPerformed(evt);
            }
        });
        StudentSignupPagePanel.add(txtStudentPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 290, -1));

        txtBatch.setBackground(new java.awt.Color(255, 255, 255));
        txtBatch.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(99, 166, 211)));
        txtBatch.setForeground(new java.awt.Color(102, 102, 102));
        txtBatch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtBatch.setPlaceholder("Batch");
        txtBatch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBatchActionPerformed(evt);
            }
        });
        StudentSignupPagePanel.add(txtBatch, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 290, -1));

        getContentPane().add(StudentSignupPagePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 600));

        setSize(new java.awt.Dimension(871, 602));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtStudentIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStudentIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStudentIDActionPerformed

    private void txtDepertmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDepertmentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDepertmentActionPerformed

    private void txtStudentEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStudentEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStudentEmailActionPerformed

    private void txtStudentNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStudentNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStudentNameActionPerformed

    private void studentLoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentLoginButtonActionPerformed
        StudentLoginPage loginPage= new StudentLoginPage();
                loginPage.setVisible(true);
                this.dispose();
    }//GEN-LAST:event_studentLoginButtonActionPerformed

    private void studentSignupButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentSignupButtonActionPerformed
        if(validationSignup()==true){
            if(duplicateUserNameChecker()==false||duplicateEmailChecker()==false){
                insertSingupDetails();
            }
            else{
                JOptionPane.showMessageDialog(this,"Already exist");
            }
        }
    }//GEN-LAST:event_studentSignupButtonActionPerformed

    private void txtStudentIDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtStudentIDFocusLost
        if(duplicateUserNameChecker()==true){
            JOptionPane.showMessageDialog(this,"Username already exist");
        }
    }//GEN-LAST:event_txtStudentIDFocusLost

    private void txtStudentEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtStudentEmailFocusLost
        if(duplicateEmailChecker()==true){
            JOptionPane.showMessageDialog(this,"Email already exist");
        }
    }//GEN-LAST:event_txtStudentEmailFocusLost

    private void txtStudentPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStudentPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStudentPasswordActionPerformed

    private void txtBatchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBatchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBatchActionPerformed

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
            java.util.logging.Logger.getLogger(StudentSignUpPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentSignUpPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentSignUpPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentSignUpPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentSignUpPage().setVisible(true);
            }
            
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel SSignUpPageLabel;
    private javax.swing.JPanel StudentSignupPagePanel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private rojeru_san.complementos.RSButtonHover studentLoginButton;
    private rojeru_san.complementos.RSButtonHover studentSignupButton;
    private app.bolivia.swing.JCTextField txtBatch;
    private app.bolivia.swing.JCTextField txtDepertment;
    private app.bolivia.swing.JCTextField txtStudentEmail;
    private app.bolivia.swing.JCTextField txtStudentID;
    private app.bolivia.swing.JCTextField txtStudentName;
    private app.bolivia.swing.JCTextField txtStudentPassword;
    // End of variables declaration//GEN-END:variables
}
