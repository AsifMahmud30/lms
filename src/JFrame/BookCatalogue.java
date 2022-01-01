package JFrame;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class BookCatalogue extends javax.swing.JFrame {


    private String title, author, edition, language, publisher, series;
    private int ID,year,pages, isbn, quantity;
    
    DefaultTableModel model;//creating a model which will be representing the calalogue table
    
    public BookCatalogue() {
        
        initComponents();
        bookCatalogueTable1.setAutoCreateRowSorter(true);
        catalogue();
    }
 
    public void catalogue(){
        
        try{
            Connection connection = DatabaseConnectionClass.getConnection();
            Statement st=connection.createStatement();
            ResultSet resultSet=st.executeQuery("select * from bookdetails");
            
            while (resultSet.next()){
                String bookID=resultSet.getString("ID");
                String author=resultSet.getString("author");
                String title=resultSet.getString("title");
                String edition=resultSet.getString("edition");
                String language=resultSet.getString("language");
                String publisher=resultSet.getString("publisher");
                int year=resultSet.getInt("year");
                int pages=resultSet.getInt("pages");
                String series=resultSet.getString("series");
                int isbn=resultSet.getInt("isbn");
                int quantity=resultSet.getInt("quantity");
                
                Object[] obj={bookID,author,title,edition,language,publisher,year,pages,series,isbn,quantity};
                
                model =(DefaultTableModel)bookCatalogueTable1.getModel(); // using this model object to insert data inside the row
                model.addRow(obj); 
                
            }
            
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
        public void search(String string){
        model=(DefaultTableModel) bookCatalogueTable1.getModel();
        TableRowSorter<DefaultTableModel> trs=new TableRowSorter<>(model);
        bookCatalogueTable1.setRowSorter(trs);
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
        bookCatalogueTable1 = new javax.swing.JTable();
        txtSearchBooks = new app.bolivia.swing.JCTextField();

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

        bookCatalogueTable1.setAutoCreateRowSorter(true);
        bookCatalogueTable1.setBackground(new java.awt.Color(255, 255, 255));
        bookCatalogueTable1.setForeground(new java.awt.Color(102, 102, 102));
        bookCatalogueTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Author", "Title", "Edition", "Language", "Publisher", "Year", "Pages", "Series", "ISBN", "Quantity"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        bookCatalogueTable1.setDragEnabled(true);
        bookCatalogueTable1.setEnabled(false);
        bookCatalogueTable1.setRequestFocusEnabled(false);
        bookCatalogueTable1.setSelectionBackground(new java.awt.Color(204, 204, 204));
        bookCatalogueTable1.setSelectionForeground(new java.awt.Color(51, 51, 51));
        bookCatalogueTable1.setShowGrid(true);
        bookCatalogueTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bookCatalogueTable1MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(bookCatalogueTable1);
        if (bookCatalogueTable1.getColumnModel().getColumnCount() > 0) {
            bookCatalogueTable1.getColumnModel().getColumn(0).setPreferredWidth(10);
            bookCatalogueTable1.getColumnModel().getColumn(1).setPreferredWidth(70);
            bookCatalogueTable1.getColumnModel().getColumn(2).setPreferredWidth(150);
            bookCatalogueTable1.getColumnModel().getColumn(3).setPreferredWidth(20);
            bookCatalogueTable1.getColumnModel().getColumn(4).setPreferredWidth(20);
            bookCatalogueTable1.getColumnModel().getColumn(6).setPreferredWidth(15);
            bookCatalogueTable1.getColumnModel().getColumn(7).setPreferredWidth(15);
            bookCatalogueTable1.getColumnModel().getColumn(8).setPreferredWidth(20);
            bookCatalogueTable1.getColumnModel().getColumn(9).setPreferredWidth(15);
            bookCatalogueTable1.getColumnModel().getColumn(10).setPreferredWidth(15);
        }

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 960, -1));

        txtSearchBooks.setPlaceholder("Search Books");
        txtSearchBooks.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchBooksKeyReleased(evt);
            }
        });
        jPanel1.add(txtSearchBooks, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 20, -1, -1));

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

    private void bookCatalogueTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookCatalogueTable1MouseClicked
        
    }//GEN-LAST:event_bookCatalogueTable1MouseClicked

    private void txtSearchBooksKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchBooksKeyReleased
        String searchString=txtSearchBooks.getText().toLowerCase();
        search(searchString);
    }//GEN-LAST:event_txtSearchBooksKeyReleased

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
    private javax.swing.JTable bookCatalogueTable1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private rojeru_san.complementos.RSTableMetro tbl_bookDetails;
    private app.bolivia.swing.JCTextField txtSearchBooks;
    // End of variables declaration//GEN-END:variables

}
