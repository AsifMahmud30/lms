package JFrame;


import java.sql.PreparedStatement;

import javax.swing.JOptionPane;
import javax.swing.table.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;


public class BookEntry extends javax.swing.JFrame {

    private String title, author, edition, language, publisher, series;
    private int ID,year,pages, isbn, quantity;

    
    DefaultTableModel model;//creating a model which will be representing the calalogue table
    
    public BookEntry() {
        
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

    //add books to the databse
        public boolean bookEntry(){
       
       /*1*/ID=Integer.parseInt(txtBookID.getText());
       /*2*/author=txtAuthor.getText();
       /*3*/title=txtTitle.getText();
       /*4*/edition=txtEdition.getText();
       /*5*/language=txtLanguage.getText();
       /*6*/publisher=txtPublisher.getText();
       /*7*/series=txtSeries.getText();
       /*8*/year=Integer.parseInt(txtYearOfPublication.getText());
       /*9*/pages=Integer.parseInt(txtNumberOfPages.getText());
       /*10*/isbn=Integer.parseInt(txtISBN.getText());
       /*11*/quantity=Integer.parseInt(txtQuantity.getText());
       
       try{
           Connection connection= DatabaseConnectionClass.getConnection();
           String sql="insert into bookdetails(ID,author,title,edition,language,publisher,year,pages,series,isbn,quantity) values(?,?,?,?,?,?,?,?,?,?,?)";
           
           PreparedStatement  statement=  connection.prepareStatement(sql);
           
           statement.setInt(1,ID);
           statement.setString(2,author);
           statement.setString(3,title);
           statement.setString(4,edition);
           statement.setString(5,language);
           statement.setString(6,publisher);
           statement.setInt(7,year);
           statement.setInt(8,pages);
           statement.setString(9,series);
           statement.setInt(10,isbn);
           statement.setInt(11,quantity);
           
           int rowCount=statement.executeUpdate();
           
           if(rowCount>0){
              return true;
           }
         
       }catch(Exception e){
          System.out.println(e);
       }
       return false;
    }
    public boolean bookUpdate(){
        
       ID=Integer.parseInt(txtBookID.getText());
       author=txtAuthor.getText();
       title=txtTitle.getText();
       edition=txtEdition.getText();
       language=txtLanguage.getText();
       publisher=txtPublisher.getText();
       series=txtSeries.getText();
       year=Integer.parseInt(txtYearOfPublication.getText());
       pages=Integer.parseInt(txtNumberOfPages.getText());
       isbn=Integer.parseInt(txtISBN.getText());
       quantity=Integer.parseInt(txtQuantity.getText());
       
       try{
           Connection connection= DatabaseConnectionClass.getConnection();
           String sql="update bookdetails set author=?,title=?,edition=?,language=?,publisher=?,year=?,pages=?,Series=?,isbn=?,quantity=? where ID=?";
           
           PreparedStatement  statement=  connection.prepareStatement(sql);

           //
           statement.setString(1,author);
           statement.setString(2,title);
           statement.setString(3,edition);
           statement.setString(4,language);
           statement.setString(5,publisher);
           statement.setInt(6,year);
           statement.setInt(7,pages);
           statement.setString(8,series);
           statement.setInt(9,isbn);
           statement.setInt(10 ,quantity);
           statement.setInt(11,ID);
           
           int rowCount=statement.executeUpdate();
           
           if(rowCount>0){
              return true;
           }
         
       }catch(Exception e){
          System.out.println(e);
       }
       return false;
    }
    
    public boolean bookRemove(){
        ID=Integer.parseInt(txtBookID.getText());
        
        try {
            Connection connection= DatabaseConnectionClass.getConnection();
            String sql = "delete from bookdetails where ID = ? ";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, ID);
            
            int rowCount = statement.executeUpdate();
            if (rowCount > 0) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public void refresh(){
        DefaultTableModel model = (DefaultTableModel) bookCatalogueTable1.getModel();
        model.setRowCount(0);
    }
    
    
    public void search(String string){
        model=(DefaultTableModel) bookCatalogueTable1.getModel();
        TableRowSorter<DefaultTableModel> trs=new TableRowSorter<>(model);
        bookCatalogueTable1.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter("(?i)"+string));
    }
    
    public void clearTextFileds(){
        txtBookID.setText(null);
        txtAuthor.setText(null);
        txtTitle.setText(null);
        txtEdition.setText(null);
        txtLanguage.setText(null);
        txtPublisher.setText(null);
        txtYearOfPublication.setText(null);
        txtNumberOfPages.setText(null);
        txtSeries.setText(null);
        txtISBN.setText(null);
        txtQuantity.setText(null);
    }
    
    public boolean duplicateIDChecker(){
        
        String ID=txtBookID.getText();
      
        try{
            Connection connection = DatabaseConnectionClass.getConnection();
            
            PreparedStatement statement= connection.prepareStatement("select * from bookdetails where ID =?");
            statement.setString(1, ID);
            ResultSet resultState=statement.executeQuery();
            
            if(resultState.next()){
                return true;
            }
            
        }
        catch(Exception e){
            System.out.println(e);
        }
        return false;
    }
    public boolean duplicateBookCheckerAuthor(){
        
        String author=txtAuthor.getText();
      
        try{
            Connection connection = DatabaseConnectionClass.getConnection();
            
            PreparedStatement statement= connection.prepareStatement("select * from bookdetails where author =?");
            statement.setString(1, author);
            ResultSet resultState=statement.executeQuery();
            
            if(resultState.next()){
                return true;
            }
            
        }
        catch(Exception e){
            System.out.println(e);
        }
        return false;
    }
    public boolean duplicateBookCheckerTitle(){
        
        String title=txtTitle.getText();
      
        try{
            Connection connection = DatabaseConnectionClass.getConnection();
            
            PreparedStatement statement= connection.prepareStatement("select * from bookdetails where title =?");
            statement.setString(1, title);
            ResultSet resultState=statement.executeQuery();
            
            if(resultState.next()){
                return true;
            }
            
        }
        catch(Exception e){
            System.out.println(e);
        }
        return false;
    }
    public boolean duplicateBookCheckerEdition(){
        
        String edition=txtEdition.getText();
      
        try{
            Connection connection = DatabaseConnectionClass.getConnection();
            
            PreparedStatement statement= connection.prepareStatement("select * from bookdetails where edition =?");
            statement.setString(1, edition);
            ResultSet resultState=statement.executeQuery();
            
            if(resultState.next()){
                return true;
            }
            
        }
        catch(Exception e){
            System.out.println(e);
        }
        return false;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BookEntryPanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        bookCatalogueTable1 = new javax.swing.JTable();
        BookInformationPanel = new javax.swing.JPanel();
        txtBookID = new app.bolivia.swing.JCTextField();
        txtTitle = new app.bolivia.swing.JCTextField();
        txtLanguage = new app.bolivia.swing.JCTextField();
        txtEdition = new app.bolivia.swing.JCTextField();
        txtPublisher = new app.bolivia.swing.JCTextField();
        txtYearOfPublication = new app.bolivia.swing.JCTextField();
        txtNumberOfPages = new app.bolivia.swing.JCTextField();
        txtSeries = new app.bolivia.swing.JCTextField();
        txtISBN = new app.bolivia.swing.JCTextField();
        txtQuantity = new app.bolivia.swing.JCTextField();
        removeBook = new rojeru_san.complementos.RSButtonHover();
        BackToHomePanel = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        addBook = new rojeru_san.complementos.RSButtonHover();
        updateBook = new rojeru_san.complementos.RSButtonHover();
        txtAuthor = new app.bolivia.swing.JCTextField();
        txtSearchBooks = new app.bolivia.swing.JCTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BookEntryPanel.setBackground(new java.awt.Color(240, 247, 255));
        BookEntryPanel.setMinimumSize(new java.awt.Dimension(860, 600));
        BookEntryPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane3.setBackground(new java.awt.Color(0, 0, 0));

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
        bookCatalogueTable1.setCellSelectionEnabled(true);
        bookCatalogueTable1.setFocusable(false);
        bookCatalogueTable1.setOpaque(false);
        bookCatalogueTable1.setRequestFocusEnabled(false);
        bookCatalogueTable1.setSelectionBackground(new java.awt.Color(204, 204, 204));
        bookCatalogueTable1.setSelectionForeground(new java.awt.Color(51, 51, 51));
        bookCatalogueTable1.setShowGrid(true);
        bookCatalogueTable1.setUpdateSelectionOnSort(false);
        bookCatalogueTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bookCatalogueTable1MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(bookCatalogueTable1);

        BookEntryPanel.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 60, 1020, 610));

        BookInformationPanel.setBackground(new java.awt.Color(255, 255, 255));
        BookInformationPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtBookID.setBackground(new java.awt.Color(255, 255, 255));
        txtBookID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(99, 166, 211)));
        txtBookID.setForeground(new java.awt.Color(102, 102, 102));
        txtBookID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtBookID.setPlaceholder("Book ID");
        txtBookID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBookIDActionPerformed(evt);
            }
        });
        BookInformationPanel.add(txtBookID, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 290, 30));

        txtTitle.setBackground(new java.awt.Color(255, 255, 255));
        txtTitle.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(99, 166, 211)));
        txtTitle.setForeground(new java.awt.Color(102, 102, 102));
        txtTitle.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTitle.setPlaceholder("Ttitle");
        txtTitle.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTitleFocusLost(evt);
            }
        });
        txtTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTitleActionPerformed(evt);
            }
        });
        BookInformationPanel.add(txtTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 290, 30));

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
        BookInformationPanel.add(txtLanguage, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 290, 30));

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
        BookInformationPanel.add(txtEdition, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 290, 30));

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
        BookInformationPanel.add(txtPublisher, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 290, 30));

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
        BookInformationPanel.add(txtYearOfPublication, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 290, 30));

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
        BookInformationPanel.add(txtNumberOfPages, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 290, 30));

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
        BookInformationPanel.add(txtSeries, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 290, 30));

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
        BookInformationPanel.add(txtISBN, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 290, 30));

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
        BookInformationPanel.add(txtQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 290, 30));

        removeBook.setBackground(new java.awt.Color(99, 166, 211));
        removeBook.setText("Remove");
        removeBook.setColorHover(new java.awt.Color(51, 153, 255));
        removeBook.setColorTextHover(new java.awt.Color(204, 204, 204));
        removeBook.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        removeBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                removeBookMouseClicked(evt);
            }
        });
        removeBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeBookActionPerformed(evt);
            }
        });
        BookInformationPanel.add(removeBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 510, 90, 30));

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

        BookInformationPanel.add(BackToHomePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 560, 290, 40));

        jLabel2.setText("Please Enter the books information");
        BookInformationPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        addBook.setBackground(new java.awt.Color(99, 166, 211));
        addBook.setText("Add");
        addBook.setColorHover(new java.awt.Color(51, 153, 255));
        addBook.setColorTextHover(new java.awt.Color(204, 204, 204));
        addBook.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        addBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addBookMouseClicked(evt);
            }
        });
        addBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBookActionPerformed(evt);
            }
        });
        BookInformationPanel.add(addBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, 90, 30));

        updateBook.setBackground(new java.awt.Color(99, 166, 211));
        updateBook.setText("Update");
        updateBook.setColorHover(new java.awt.Color(51, 153, 255));
        updateBook.setColorTextHover(new java.awt.Color(204, 204, 204));
        updateBook.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        updateBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateBookMouseClicked(evt);
            }
        });
        updateBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBookActionPerformed(evt);
            }
        });
        BookInformationPanel.add(updateBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 510, 90, 30));

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
        BookInformationPanel.add(txtAuthor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 290, 30));

        BookEntryPanel.add(BookInformationPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 670));

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
        BookEntryPanel.add(txtSearchBooks, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 20, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BookEntryPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 1410, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BookEntryPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 665, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtBookIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBookIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBookIDActionPerformed

    private void txtTitleFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTitleFocusLost

    }//GEN-LAST:event_txtTitleFocusLost

    private void txtTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTitleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTitleActionPerformed

    private void txtEditionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEditionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEditionActionPerformed

    private void txtLanguageFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtLanguageFocusLost

    }//GEN-LAST:event_txtLanguageFocusLost

    private void txtLanguageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLanguageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLanguageActionPerformed

    private void txtPublisherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPublisherActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPublisherActionPerformed

    private void txtYearOfPublicationFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtYearOfPublicationFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtYearOfPublicationFocusLost

    private void txtYearOfPublicationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtYearOfPublicationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtYearOfPublicationActionPerformed

    private void txtNumberOfPagesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumberOfPagesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumberOfPagesActionPerformed

    private void txtQuantityFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtQuantityFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQuantityFocusLost

    private void txtQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQuantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQuantityActionPerformed

    private void txtSeriesFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSeriesFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSeriesFocusLost

    private void txtSeriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSeriesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSeriesActionPerformed

    private void txtISBNFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtISBNFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtISBNFocusLost

    private void txtISBNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtISBNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtISBNActionPerformed

    private void removeBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeBookActionPerformed
        if(bookRemove()==true){
            JOptionPane.showMessageDialog(this, "Book Removed");
            refresh();
            catalogue();
            
        }
        else{
            JOptionPane.showMessageDialog(this, "Please Insert the information currectly");
        }
        clearTextFileds();
    }//GEN-LAST:event_removeBookActionPerformed

    private void BackToHomePanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackToHomePanelMouseClicked
        HomePage homePage=new HomePage();
        homePage.setVisible(true);
        dispose();
    }//GEN-LAST:event_BackToHomePanelMouseClicked

    private void removeBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeBookMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_removeBookMouseClicked

    private void addBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addBookMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_addBookMouseClicked

    private void addBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBookActionPerformed
        if(duplicateIDChecker()==true||duplicateBookCheckerAuthor()==true&&duplicateBookCheckerTitle()==true&&duplicateBookCheckerEdition()==true){
            JOptionPane.showMessageDialog(this, "Book Already Exist");
        }
        else{
            if(bookEntry()==true){
            JOptionPane.showMessageDialog(this, "Book Added");
            refresh();
            catalogue();
        }
            else{
                JOptionPane.showMessageDialog(this, "Please Insert the information currectly");
        }
            clearTextFileds();
        }
    }//GEN-LAST:event_addBookActionPerformed

    private void updateBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateBookMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_updateBookMouseClicked

    private void updateBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBookActionPerformed

        if(bookUpdate()==true){
            JOptionPane.showMessageDialog(this, "Book Updated");
            refresh();
            catalogue();
        }
        else{
            JOptionPane.showMessageDialog(this, "Please Insert the information currectly");
        }
        clearTextFileds();
    }//GEN-LAST:event_updateBookActionPerformed

    private void txtAuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAuthorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAuthorActionPerformed

    private void bookCatalogueTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookCatalogueTable1MouseClicked
        int rowNumber=bookCatalogueTable1.getSelectedRow();
        TableModel model=bookCatalogueTable1.getModel();
        
        txtBookID.setText(model.getValueAt(rowNumber,0).toString());
        txtAuthor.setText(model.getValueAt(rowNumber,1).toString());
        txtTitle.setText(model.getValueAt(rowNumber,2).toString());
        txtEdition.setText(model.getValueAt(rowNumber,3).toString());
        txtLanguage.setText(model.getValueAt(rowNumber,4).toString());
        txtPublisher.setText(model.getValueAt(rowNumber,5).toString());
        txtYearOfPublication.setText(model.getValueAt(rowNumber,6).toString());
        txtNumberOfPages.setText(model.getValueAt(rowNumber,7).toString());
        txtSeries.setText(model.getValueAt(rowNumber,8).toString());
        txtISBN.setText(model.getValueAt(rowNumber,9).toString());
        txtQuantity.setText(model.getValueAt(rowNumber,10).toString());
        
        
    }//GEN-LAST:event_bookCatalogueTable1MouseClicked

    private void txtSearchBooksKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchBooksKeyReleased
        String searchString=txtSearchBooks.getText().toLowerCase();
        search(searchString);
    }//GEN-LAST:event_txtSearchBooksKeyReleased

    private void txtSearchBooksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchBooksActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchBooksActionPerformed

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
            java.util.logging.Logger.getLogger(BookEntry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BookEntry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BookEntry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookEntry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BookEntry().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BackToHomePanel;
    private javax.swing.JPanel BookEntryPanel;
    private javax.swing.JPanel BookInformationPanel;
    private rojeru_san.complementos.RSButtonHover addBook;
    private javax.swing.JTable bookCatalogueTable1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JScrollPane jScrollPane3;
    private rojeru_san.complementos.RSButtonHover removeBook;
    private app.bolivia.swing.JCTextField txtAuthor;
    private app.bolivia.swing.JCTextField txtBookID;
    private app.bolivia.swing.JCTextField txtEdition;
    private app.bolivia.swing.JCTextField txtISBN;
    private app.bolivia.swing.JCTextField txtLanguage;
    private app.bolivia.swing.JCTextField txtNumberOfPages;
    private app.bolivia.swing.JCTextField txtPublisher;
    private app.bolivia.swing.JCTextField txtQuantity;
    private app.bolivia.swing.JCTextField txtSearchBooks;
    private app.bolivia.swing.JCTextField txtSeries;
    private app.bolivia.swing.JCTextField txtTitle;
    private app.bolivia.swing.JCTextField txtYearOfPublication;
    private rojeru_san.complementos.RSButtonHover updateBook;
    // End of variables declaration//GEN-END:variables

    private void setString(int i, String author) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
