package JFrame;
import java.sql.*;
import javax.swing.*;

public class SingnupPage extends javax.swing.JFrame {
    
    private String name;
    private String password;
    private String userName;
    private String email;
    
    
    public SingnupPage() {
        initComponents();
    }
    
    //implimenting a method to insert the login information into the database
    public void insertSingupDetails(){
        name=txtName.getText();
        password=txtPassword.getText();
        userName=txtUsername.getText();
        email=txtEmail.getText();
        
        try{
           Connection connection=DatabaseConnectionClass.getConnection();
           String sql="insert into users(name,userName,password,email) values(?,?,?,?)";
           PreparedStatement  statement=  connection.prepareStatement(sql);
           
           statement.setString(1,name);
           statement.setString(2,userName);
           statement.setString(3,password);
           statement.setString(4,email);
           
           int updateRowCount =statement.executeUpdate();
           
           if(updateRowCount>0){
               JOptionPane.showMessageDialog(this,"Done");
               LoginPage loginPage=new LoginPage();
               loginPage.setVisible(true);
               dispose();
           }else{
               JOptionPane.showMessageDialog(this,"Failed");
           }
          
        }catch(Exception e){ 
            e.getMessage();
        }
    }
    
    //data validation
    public boolean validationSignup(){
        String name=txtName.getText();
        String password=txtPassword.getText();
        String userName=txtUsername.getText();
        String email=txtEmail.getText();
        if(name.equals("")||password.equals("")||userName.equals("")||email.equals("")){
            JOptionPane.showMessageDialog(this,"Please fill up the information");
            return false;
        }
        return true;
    }
    //check duplicate user
    public boolean duplicateUserNameChecker(){
        String userName=txtUsername.getText();
        
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
        String email=txtEmail.getText();
        
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

        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtUsername = new app.bolivia.swing.JCTextField();
        txtPassword = new app.bolivia.swing.JCTextField();
        txtEmail = new app.bolivia.swing.JCTextField();
        txtName = new app.bolivia.swing.JCTextField();
        rSButtonHover2 = new rojeru_san.complementos.RSButtonHover();
        jLabel7 = new javax.swing.JLabel();
        rSButtonHover3 = new rojeru_san.complementos.RSButtonHover();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(102, 102, 102));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(99, 166, 211));
        jLabel3.setText("Library Managemnet System");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons/library-concept-students-coworking-space-vector-27466179.jpg"))); // NOI18N
        jLabel5.setText("jLabel5");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, 490, 600));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Already have an account?");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, 210, 30));

        txtUsername.setBackground(new java.awt.Color(255, 255, 255));
        txtUsername.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(99, 166, 211)));
        txtUsername.setForeground(new java.awt.Color(102, 102, 102));
        txtUsername.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtUsername.setPlaceholder("Username");
        txtUsername.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtUsernameFocusLost(evt);
            }
        });
        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameActionPerformed(evt);
            }
        });
        jPanel2.add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 290, -1));

        txtPassword.setBackground(new java.awt.Color(255, 255, 255));
        txtPassword.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(99, 166, 211)));
        txtPassword.setForeground(new java.awt.Color(102, 102, 102));
        txtPassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPassword.setPlaceholder("Password");
        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });
        jPanel2.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 290, -1));

        txtEmail.setBackground(new java.awt.Color(255, 255, 255));
        txtEmail.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(99, 166, 211)));
        txtEmail.setForeground(new java.awt.Color(102, 102, 102));
        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtEmail.setPlaceholder("Email");
        txtEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEmailFocusLost(evt);
            }
        });
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });
        jPanel2.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 290, -1));

        txtName.setBackground(new java.awt.Color(255, 255, 255));
        txtName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(99, 166, 211)));
        txtName.setForeground(new java.awt.Color(102, 102, 102));
        txtName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtName.setPlaceholder("Name");
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });
        jPanel2.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 290, -1));

        rSButtonHover2.setBackground(new java.awt.Color(99, 166, 211));
        rSButtonHover2.setText("LOGIN");
        rSButtonHover2.setColorHover(new java.awt.Color(51, 153, 255));
        rSButtonHover2.setColorTextHover(new java.awt.Color(204, 204, 204));
        rSButtonHover2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rSButtonHover2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonHover2ActionPerformed(evt);
            }
        });
        jPanel2.add(rSButtonHover2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 480, 160, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Please insert your information to SIGNUP");
        jLabel7.setFocusable(false);
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 340, 30));

        rSButtonHover3.setBackground(new java.awt.Color(99, 166, 211));
        rSButtonHover3.setText("SIGNUP");
        rSButtonHover3.setColorHover(new java.awt.Color(51, 153, 255));
        rSButtonHover3.setColorTextHover(new java.awt.Color(204, 204, 204));
        rSButtonHover3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rSButtonHover3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonHover3ActionPerformed(evt);
            }
        });
        jPanel2.add(rSButtonHover3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 160, 30));

        jLabel2.setBackground(new java.awt.Color(102, 102, 102));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 51));
        jLabel2.setText("Error");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, -1, -1));

        jLabel8.setBackground(new java.awt.Color(102, 102, 102));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Runtime");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 600));

        setSize(new java.awt.Dimension(871, 602));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsernameActionPerformed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void rSButtonHover2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonHover2ActionPerformed
        LoginPage loginPage= new LoginPage();
                loginPage.setVisible(true);
                this.dispose();
    }//GEN-LAST:event_rSButtonHover2ActionPerformed

    private void rSButtonHover3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonHover3ActionPerformed
        if(validationSignup()==true){
            if(duplicateUserNameChecker()==false){
                insertSingupDetails();
            }
            else{
                JOptionPane.showMessageDialog(this,"Username already exist");
            }
        }
    }//GEN-LAST:event_rSButtonHover3ActionPerformed

    private void txtUsernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUsernameFocusLost
        if(duplicateUserNameChecker()==true){
            JOptionPane.showMessageDialog(this,"Username already exist");
        }
    }//GEN-LAST:event_txtUsernameFocusLost

    private void txtEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusLost
        if(duplicateEmailChecker()==true){
            JOptionPane.showMessageDialog(this,"Email already exist");
        }
    }//GEN-LAST:event_txtEmailFocusLost

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
            java.util.logging.Logger.getLogger(SingnupPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SingnupPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SingnupPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SingnupPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SingnupPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private rojeru_san.complementos.RSButtonHover rSButtonHover2;
    private rojeru_san.complementos.RSButtonHover rSButtonHover3;
    private app.bolivia.swing.JCTextField txtEmail;
    private app.bolivia.swing.JCTextField txtName;
    private app.bolivia.swing.JCTextField txtPassword;
    private app.bolivia.swing.JCTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
