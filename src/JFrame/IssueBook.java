package JFrame;


import java.sql.PreparedStatement;

import javax.swing.JOptionPane;
import javax.swing.table.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.Locale;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;


public class IssueBook extends javax.swing.JFrame{

    private String title, author, edition, language, publisher, series;
    private int ID,year,pages, isbn, quantity;

    
    DefaultTableModel model;//creating a model which will be representing the calalogue table
    
    Locale l = null;
    public IssueBook() {
        
        initComponents();
        bookCatalogueTable.setAutoCreateRowSorter(true);
        catalogue();
        l = new Locale("en", "US");
        dateIssueDate.setLocale(l);
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
                
                model =(DefaultTableModel)bookCatalogueTable.getModel(); // using this model object to insert data inside the row
                model.addRow(obj); 
                
            }
            
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
    public boolean issueBook(){
        StudentLoginPage sLgoinPage=new StudentLoginPage();
        int ID=Integer.parseInt(txtBookID1.getText());
        String studentID=sLgoinPage.getID();
        String title=txtTitle1.getText();
        Date issueDate= dateIssueDate.getDatoFecha();
        Long l1 = issueDate.getTime();
        java.sql.Date sIssueDate = new java.sql.Date(l1);
        
        try {
            
            Connection connection = DatabaseConnectionClass.getConnection();
            String sql = "insert into issuebookdetails(bookID,title,studentID," + "issueDate) values(?,?,?,?)";
            
            PreparedStatement  statement=  connection.prepareStatement(sql);
           
            statement.setInt(1,ID);
            statement.setString(2,title);
            statement.setString(3,studentID);
            statement.setDate(4,sIssueDate);


            int rowCount = statement.executeUpdate();
            
            if (rowCount > 0) {
                return true;
            } 

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
 
    }
    public void updateBookCount(){
        int ID= Integer.parseInt(txtBookID1.getText());
        try{
            Connection connection= DatabaseConnectionClass.getConnection();
            String sql="update bookdetails set quantity= quantity-1 where ID=?";
            PreparedStatement  statement=  connection.prepareStatement(sql);
            statement.setInt(1, ID);
            int rowCount = statement.executeUpdate();

            if (rowCount > 0) {
                JOptionPane.showMessageDialog(this, "book count updated");
                int initialCount = Integer.parseInt(txtQuantity.getText());
                txtQuantity.setText(Integer.toString(initialCount - 1));
            } else {
                JOptionPane.showMessageDialog(this, "can't update book count");
            }
        }catch(Exception e){
            
        }
    }
    
    public boolean isAlreadyIssued() {
        
        StudentLoginPage sLgoinPage=new StudentLoginPage();
        boolean isAlreadyIssued = false;
        int Id = Integer.parseInt(txtBookID1.getText());
        String studentID =sLgoinPage.txtStudentID.getText();

        try {
            Connection connection = DatabaseConnectionClass.getConnection();
            String sql = "select * from issuebookdetails where bookID = ? and studentID = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, ID);
            statement.setString(2, studentID);

            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                isAlreadyIssued = true;
            } else {
                isAlreadyIssued = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isAlreadyIssued;

    }
    
    public void search(String string){
        model=(DefaultTableModel) bookCatalogueTable.getModel();
        TableRowSorter<DefaultTableModel> trs=new TableRowSorter<>(model);
        bookCatalogueTable.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter("(?i)"+string));
    }
    
    public void clearTextFileds(){
        txtBookID1.setText(null);
        txtAuthor.setText(null);
        txtTitle1.setText(null);
        txtEdition.setText(null);
        txtLanguage.setText(null);
        txtPublisher.setText(null);
        txtYearOfPublication.setText(null);
        txtNumberOfPages.setText(null);
        txtSeries.setText(null);
        txtISBN.setText(null);
        txtQuantity.setText(null);
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BookEntryPanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        bookCatalogueTable = new javax.swing.JTable();
        BookInformationPanel = new javax.swing.JPanel();
        txtBookID1 = new app.bolivia.swing.JCTextField();
        txtTitle1 = new app.bolivia.swing.JCTextField();
        txtLanguage = new app.bolivia.swing.JCTextField();
        txtEdition = new app.bolivia.swing.JCTextField();
        txtPublisher = new app.bolivia.swing.JCTextField();
        txtYearOfPublication = new app.bolivia.swing.JCTextField();
        txtNumberOfPages = new app.bolivia.swing.JCTextField();
        txtSeries = new app.bolivia.swing.JCTextField();
        txtISBN = new app.bolivia.swing.JCTextField();
        txtQuantity = new app.bolivia.swing.JCTextField();
        BackToHomePanel = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        issueBook = new rojeru_san.complementos.RSButtonHover();
        txtAuthor = new app.bolivia.swing.JCTextField();
        dateIssueDate = new rojeru_san.componentes.RSDateChooser();
        jLabel6 = new javax.swing.JLabel();
        txtTitle = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtSearchBooks = new app.bolivia.swing.JCTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BookEntryPanel.setBackground(new java.awt.Color(240, 247, 255));
        BookEntryPanel.setMinimumSize(new java.awt.Dimension(860, 600));
        BookEntryPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane3.setBackground(new java.awt.Color(0, 0, 0));

        bookCatalogueTable.setBackground(new java.awt.Color(255, 255, 255));
        bookCatalogueTable.setForeground(new java.awt.Color(102, 102, 102));
        bookCatalogueTable.setModel(new javax.swing.table.DefaultTableModel(
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
        bookCatalogueTable.setCellSelectionEnabled(true);
        bookCatalogueTable.setFocusable(false);
        bookCatalogueTable.setOpaque(false);
        bookCatalogueTable.setRequestFocusEnabled(false);
        bookCatalogueTable.setSelectionBackground(new java.awt.Color(204, 204, 204));
        bookCatalogueTable.setSelectionForeground(new java.awt.Color(51, 51, 51));
        bookCatalogueTable.setShowGrid(true);
        bookCatalogueTable.setUpdateSelectionOnSort(false);
        bookCatalogueTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bookCatalogueTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(bookCatalogueTable);

        BookEntryPanel.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 60, 1020, 730));

        BookInformationPanel.setBackground(new java.awt.Color(255, 255, 255));
        BookInformationPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtBookID1.setBackground(new java.awt.Color(255, 255, 255));
        txtBookID1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(99, 166, 211)));
        txtBookID1.setForeground(new java.awt.Color(102, 102, 102));
        txtBookID1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtBookID1.setPlaceholder("Book ID");
        txtBookID1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBookID1ActionPerformed(evt);
            }
        });
        BookInformationPanel.add(txtBookID1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 290, 30));

        txtTitle1.setBackground(new java.awt.Color(255, 255, 255));
        txtTitle1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(99, 166, 211)));
        txtTitle1.setForeground(new java.awt.Color(102, 102, 102));
        txtTitle1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTitle1.setPlaceholder("Ttitle");
        txtTitle1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTitle1FocusLost(evt);
            }
        });
        txtTitle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTitle1ActionPerformed(evt);
            }
        });
        BookInformationPanel.add(txtTitle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 290, 30));

        txtLanguage.setBackground(new java.awt.Color(255, 255, 255));
        txtLanguage.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(99, 166, 211)));
        txtLanguage.setForeground(new java.awt.Color(102, 102, 102));
        txtLanguage.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtLanguage.setPlaceholder("Language");
        txtLanguage.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtLanguageFocusLost(evt);
            }
        });
        txtLanguage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLanguageActionPerformed(evt);
            }
        });
        BookInformationPanel.add(txtLanguage, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 290, 30));

        txtEdition.setBackground(new java.awt.Color(255, 255, 255));
        txtEdition.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(99, 166, 211)));
        txtEdition.setForeground(new java.awt.Color(102, 102, 102));
        txtEdition.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtEdition.setPlaceholder("Edition");
        txtEdition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEditionActionPerformed(evt);
            }
        });
        BookInformationPanel.add(txtEdition, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 290, 30));

        txtPublisher.setBackground(new java.awt.Color(255, 255, 255));
        txtPublisher.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(99, 166, 211)));
        txtPublisher.setForeground(new java.awt.Color(102, 102, 102));
        txtPublisher.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPublisher.setPlaceholder("Publisher");
        txtPublisher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPublisherActionPerformed(evt);
            }
        });
        BookInformationPanel.add(txtPublisher, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 290, 30));

        txtYearOfPublication.setBackground(new java.awt.Color(255, 255, 255));
        txtYearOfPublication.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(99, 166, 211)));
        txtYearOfPublication.setForeground(new java.awt.Color(102, 102, 102));
        txtYearOfPublication.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtYearOfPublication.setPlaceholder("Year of publication");
        txtYearOfPublication.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtYearOfPublicationFocusLost(evt);
            }
        });
        txtYearOfPublication.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtYearOfPublicationActionPerformed(evt);
            }
        });
        BookInformationPanel.add(txtYearOfPublication, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 290, 30));

        txtNumberOfPages.setBackground(new java.awt.Color(255, 255, 255));
        txtNumberOfPages.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(99, 166, 211)));
        txtNumberOfPages.setForeground(new java.awt.Color(102, 102, 102));
        txtNumberOfPages.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNumberOfPages.setPlaceholder("Number of pages");
        txtNumberOfPages.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumberOfPagesActionPerformed(evt);
            }
        });
        BookInformationPanel.add(txtNumberOfPages, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 290, 30));

        txtSeries.setBackground(new java.awt.Color(255, 255, 255));
        txtSeries.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(99, 166, 211)));
        txtSeries.setForeground(new java.awt.Color(102, 102, 102));
        txtSeries.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSeries.setPlaceholder("Series");
        txtSeries.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSeriesFocusLost(evt);
            }
        });
        txtSeries.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSeriesActionPerformed(evt);
            }
        });
        BookInformationPanel.add(txtSeries, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 290, 30));

        txtISBN.setBackground(new java.awt.Color(255, 255, 255));
        txtISBN.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(99, 166, 211)));
        txtISBN.setForeground(new java.awt.Color(102, 102, 102));
        txtISBN.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtISBN.setPlaceholder("ISBN");
        txtISBN.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtISBNFocusLost(evt);
            }
        });
        txtISBN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtISBNActionPerformed(evt);
            }
        });
        BookInformationPanel.add(txtISBN, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 290, 30));

        txtQuantity.setBackground(new java.awt.Color(255, 255, 255));
        txtQuantity.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(99, 166, 211)));
        txtQuantity.setForeground(new java.awt.Color(102, 102, 102));
        txtQuantity.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtQuantity.setPlaceholder("Quantity");
        txtQuantity.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtQuantityFocusLost(evt);
            }
        });
        txtQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQuantityActionPerformed(evt);
            }
        });
        BookInformationPanel.add(txtQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, 290, 30));

        BackToHomePanel.setBackground(new java.awt.Color(175, 193, 231));
        BackToHomePanel.setForeground(new java.awt.Color(255, 0, 51));
        BackToHomePanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BackToHomePanelMouseClicked(evt);
            }
        });
        BackToHomePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        BackToHomePanel.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 240, 40));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Back to Home");
        BackToHomePanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, -1, -1));

        BookInformationPanel.add(BackToHomePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 670, 290, 40));

        jLabel2.setText("Please Enter the books information");
        BookInformationPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        issueBook.setBackground(new java.awt.Color(99, 166, 211));
        issueBook.setText("Issue");
        issueBook.setColorHover(new java.awt.Color(51, 153, 255));
        issueBook.setColorTextHover(new java.awt.Color(204, 204, 204));
        issueBook.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        issueBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                issueBookMouseClicked(evt);
            }
        });
        issueBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                issueBookActionPerformed(evt);
            }
        });
        BookInformationPanel.add(issueBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 620, 290, 30));

        txtAuthor.setBackground(new java.awt.Color(255, 255, 255));
        txtAuthor.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(99, 166, 211)));
        txtAuthor.setForeground(new java.awt.Color(102, 102, 102));
        txtAuthor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtAuthor.setPlaceholder("Author");
        txtAuthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAuthorActionPerformed(evt);
            }
        });
        BookInformationPanel.add(txtAuthor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 290, 30));

        dateIssueDate.setPlaceholder("Issue Date");
        BookInformationPanel.add(dateIssueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, 290, -1));

        jLabel6.setText("jLabel6");
        BookInformationPanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 210, 230, 50));
        BookInformationPanel.add(txtTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 90, 230, 50));

        jLabel8.setText("jLabel6");
        BookInformationPanel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 150, 230, 50));

        BookEntryPanel.add(BookInformationPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 790));

        txtSearchBooks.setPlaceholder("Search");
        txtSearchBooks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchBooksActionPerformed(evt);
            }
        });
        txtSearchBooks.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchBooksKeyReleased(evt);
            }
        });
        BookEntryPanel.add(txtSearchBooks, new org.netbeans.lib.awtextra.AbsoluteConstraints(1480, 20, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BookEntryPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BookEntryPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 792, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtTitle1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTitle1FocusLost

    }//GEN-LAST:event_txtTitle1FocusLost

    private void txtTitle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTitle1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTitle1ActionPerformed

    private void BackToHomePanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackToHomePanelMouseClicked
        HomePage homePage=new HomePage();
        homePage.setVisible(true);
        dispose();
    }//GEN-LAST:event_BackToHomePanelMouseClicked

    private void issueBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_issueBookMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_issueBookMouseClicked

    private void issueBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_issueBookActionPerformed
        if (txtQuantity.getText().equals("0")) {
            JOptionPane.showMessageDialog(this, "book is not available");
        } 
        else {

            if (isAlreadyIssued() == false) {

                if (issueBook() == true) {
                    JOptionPane.showMessageDialog(this, "book issued successfully");
                    updateBookCount();
                } else {
                    JOptionPane.showMessageDialog(this, "can't issue the book");
                }

            } else {
                JOptionPane.showMessageDialog(this, "this student already has this book");
            }

        }   
        StudentLoginPage sLgoinPage=new StudentLoginPage();
        
    }//GEN-LAST:event_issueBookActionPerformed

    private void txtAuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAuthorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAuthorActionPerformed

    private void bookCatalogueTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookCatalogueTableMouseClicked
        int rowNumber=bookCatalogueTable.getSelectedRow();
        TableModel model=bookCatalogueTable.getModel();
        
        txtBookID1.setText(model.getValueAt(rowNumber,0).toString());
        txtAuthor.setText(model.getValueAt(rowNumber,1).toString());
        txtTitle1.setText(model.getValueAt(rowNumber,2).toString());
        txtEdition.setText(model.getValueAt(rowNumber,3).toString());
        txtLanguage.setText(model.getValueAt(rowNumber,4).toString());
        txtPublisher.setText(model.getValueAt(rowNumber,5).toString());
        txtYearOfPublication.setText(model.getValueAt(rowNumber,6).toString());
        txtNumberOfPages.setText(model.getValueAt(rowNumber,7).toString());
        txtSeries.setText(model.getValueAt(rowNumber,8).toString());
        txtISBN.setText(model.getValueAt(rowNumber,9).toString());
        txtQuantity.setText(model.getValueAt(rowNumber,10).toString());
        
        
    }//GEN-LAST:event_bookCatalogueTableMouseClicked

    private void txtSearchBooksKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchBooksKeyReleased
        String searchString=txtSearchBooks.getText().toLowerCase();
        search(searchString);
    }//GEN-LAST:event_txtSearchBooksKeyReleased

    private void txtSearchBooksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchBooksActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchBooksActionPerformed

    private void txtBookID1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBookID1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBookID1ActionPerformed

    private void txtEditionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEditionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEditionActionPerformed

    private void txtLanguageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLanguageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLanguageActionPerformed

    private void txtLanguageFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtLanguageFocusLost

    }//GEN-LAST:event_txtLanguageFocusLost

    private void txtPublisherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPublisherActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPublisherActionPerformed

    private void txtYearOfPublicationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtYearOfPublicationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtYearOfPublicationActionPerformed

    private void txtYearOfPublicationFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtYearOfPublicationFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtYearOfPublicationFocusLost

    private void txtNumberOfPagesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumberOfPagesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumberOfPagesActionPerformed

    private void txtSeriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSeriesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSeriesActionPerformed

    private void txtSeriesFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSeriesFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSeriesFocusLost

    private void txtISBNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtISBNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtISBNActionPerformed

    private void txtISBNFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtISBNFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtISBNFocusLost

    private void txtQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQuantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQuantityActionPerformed

    private void txtQuantityFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtQuantityFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQuantityFocusLost

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
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IssueBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BackToHomePanel;
    private javax.swing.JPanel BookEntryPanel;
    private javax.swing.JPanel BookInformationPanel;
    private javax.swing.JTable bookCatalogueTable;
    private rojeru_san.componentes.RSDateChooser dateIssueDate;
    private rojeru_san.complementos.RSButtonHover issueBook;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JScrollPane jScrollPane3;
    private app.bolivia.swing.JCTextField txtAuthor;
    private app.bolivia.swing.JCTextField txtBookID1;
    private app.bolivia.swing.JCTextField txtEdition;
    private app.bolivia.swing.JCTextField txtISBN;
    private app.bolivia.swing.JCTextField txtLanguage;
    private app.bolivia.swing.JCTextField txtNumberOfPages;
    private app.bolivia.swing.JCTextField txtPublisher;
    private app.bolivia.swing.JCTextField txtQuantity;
    private app.bolivia.swing.JCTextField txtSearchBooks;
    private app.bolivia.swing.JCTextField txtSeries;
    private javax.swing.JLabel txtTitle;
    private app.bolivia.swing.JCTextField txtTitle1;
    private app.bolivia.swing.JCTextField txtYearOfPublication;
    // End of variables declaration//GEN-END:variables

    private void setString(int i, String author) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
