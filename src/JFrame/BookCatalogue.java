/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package JFrame;



/**
 *
 * @author light
 */
public class BookCatalogue extends javax.swing.JFrame {

    /**
     * Creates new form BookCatalogue
     */
    
    public BookCatalogue() {
        initComponents();
    }
   
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_bookDetails = new rojeru_san.complementos.RSTableMetro();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

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

        jTable1.setBackground(new java.awt.Color(255, 255, 255));
        jTable1.setForeground(new java.awt.Color(102, 102, 102));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, "What does it all mean? A Very Short Introduction to Philosophy by Thomas Nagel", "What does it all mean? A Very Short Introduction to Philosophy ", "10th", "USA", "Thomas", "1987", "500", "none", "6040", null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Author", "Title", "Edition", "Place of Publication", "Publisher", "Year", "Pages", "Series", "ISBN", "Quantity"
            }
        ));
        jTable1.setSelectionBackground(new java.awt.Color(204, 204, 204));
        jTable1.setSelectionForeground(new java.awt.Color(51, 51, 51));
        jTable1.setShowGrid(true);
        jTable1.setShowVerticalLines(true);
        jScrollPane3.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(10);
            jTable1.getColumnModel().getColumn(0).setHeaderValue("ID");
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(70);
            jTable1.getColumnModel().getColumn(1).setHeaderValue("Author");
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(150);
            jTable1.getColumnModel().getColumn(2).setHeaderValue("Title");
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(20);
            jTable1.getColumnModel().getColumn(3).setHeaderValue("Edition");
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(20);
            jTable1.getColumnModel().getColumn(4).setHeaderValue("Place of Publication");
            jTable1.getColumnModel().getColumn(5).setHeaderValue("Publisher");
            jTable1.getColumnModel().getColumn(6).setPreferredWidth(15);
            jTable1.getColumnModel().getColumn(6).setHeaderValue("Year");
            jTable1.getColumnModel().getColumn(7).setPreferredWidth(15);
            jTable1.getColumnModel().getColumn(7).setHeaderValue("Pages");
            jTable1.getColumnModel().getColumn(8).setPreferredWidth(20);
            jTable1.getColumnModel().getColumn(8).setHeaderValue("Series");
            jTable1.getColumnModel().getColumn(9).setPreferredWidth(15);
            jTable1.getColumnModel().getColumn(9).setHeaderValue("ISBN");
            jTable1.getColumnModel().getColumn(10).setPreferredWidth(15);
            jTable1.getColumnModel().getColumn(10).setHeaderValue("Quantity");
        }

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 960, -1));

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
            java.util.logging.Logger.getLogger(BookCatalogue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BookCatalogue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BookCatalogue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookCatalogue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BookCatalogue().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private rojeru_san.complementos.RSTableMetro tbl_bookDetails;
    // End of variables declaration//GEN-END:variables

    private void CeateColumns() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void sort() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
