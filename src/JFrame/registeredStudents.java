package JFrame;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class registeredStudents extends javax.swing.JFrame {


    private String name,studentID,email,batch,depertment;

    
    DefaultTableModel model;//creating a model which will be representing the calalogue table
    
    public registeredStudents() {
        
        initComponents();
        registeredStudentTable.setAutoCreateRowSorter(true);
        registeredStudentList();
    }
 
    public void registeredStudentList(){
        
        try{
            Connection connection = DatabaseConnectionClass.getConnection();
            Statement st=connection.createStatement();
            ResultSet resultSet=st.executeQuery("select * from students");
            
            while (resultSet.next()){
                
                String studentID=resultSet.getString("studentID");
                String name=resultSet.getString("name");
                String email=resultSet.getString("email");
                String batch=resultSet.getString("batch");
                String depertment=resultSet.getString("depertment");
               
                
                Object[] obj={studentID,name,email,batch,depertment};
                
                model =(DefaultTableModel)registeredStudentTable.getModel(); // using this model object to insert data inside the row
                model.addRow(obj); 
                
            }
            
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
        public void search(String string){
        model=(DefaultTableModel) registeredStudentTable.getModel();
        TableRowSorter<DefaultTableModel> trs=new TableRowSorter<>(model);
        registeredStudentTable.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter("(?i)"+string));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_bookDetails = new rojeru_san.complementos.RSTableMetro();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        registeredStudentTable = new javax.swing.JTable();
        txtSearchStudents = new app.bolivia.swing.JCTextField();

        tbl_bookDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book Id", "Name", "Author", "Quantity"
            }
        ));
        tbl_bookDetails.setColorBackgoundHead(new java.awt.Color(102, 102, 255));
        tbl_bookDetails.setColorBordeFilas(new java.awt.Color(102, 102, 255));
        tbl_bookDetails.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tbl_bookDetails.setColorSelBackgound(new java.awt.Color(255, 51, 51));
        tbl_bookDetails.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 25)); // NOI18N
        tbl_bookDetails.setFuenteFilas(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        tbl_bookDetails.setFuenteFilasSelect(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        tbl_bookDetails.setFuenteHead(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        tbl_bookDetails.setRowHeight(40);
        jScrollPane2.setViewportView(tbl_bookDetails);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Book Catalogue");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, -1, -1));

        registeredStudentTable.setAutoCreateRowSorter(true);
        registeredStudentTable.setBackground(new java.awt.Color(255, 255, 255));
        registeredStudentTable.setForeground(new java.awt.Color(102, 102, 102));
        registeredStudentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Student Name", "Email", "Batch", "Depertment"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        registeredStudentTable.setDragEnabled(true);
        registeredStudentTable.setEnabled(false);
        registeredStudentTable.setRequestFocusEnabled(false);
        registeredStudentTable.setSelectionBackground(new java.awt.Color(204, 204, 204));
        registeredStudentTable.setSelectionForeground(new java.awt.Color(51, 51, 51));
        registeredStudentTable.setShowGrid(true);
        registeredStudentTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registeredStudentTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(registeredStudentTable);
        if (registeredStudentTable.getColumnModel().getColumnCount() > 0) {
            registeredStudentTable.getColumnModel().getColumn(0).setPreferredWidth(10);
            registeredStudentTable.getColumnModel().getColumn(1).setPreferredWidth(70);
            registeredStudentTable.getColumnModel().getColumn(2).setPreferredWidth(150);
            registeredStudentTable.getColumnModel().getColumn(3).setPreferredWidth(20);
            registeredStudentTable.getColumnModel().getColumn(4).setPreferredWidth(20);
        }

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 960, -1));

        txtSearchStudents.setPlaceholder("Search Books");
        txtSearchStudents.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchStudentsKeyReleased(evt);
            }
        });
        jPanel1.add(txtSearchStudents, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 20, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(976, 608));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void registeredStudentTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registeredStudentTableMouseClicked
        
    }//GEN-LAST:event_registeredStudentTableMouseClicked

    private void txtSearchStudentsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchStudentsKeyReleased
        String searchString=txtSearchStudents.getText().toLowerCase();
        search(searchString);
    }//GEN-LAST:event_txtSearchStudentsKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(registeredStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(registeredStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(registeredStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(registeredStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new registeredStudents().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable registeredStudentTable;
    private rojeru_san.complementos.RSTableMetro tbl_bookDetails;
    private app.bolivia.swing.JCTextField txtSearchStudents;
    // End of variables declaration//GEN-END:variables

}
