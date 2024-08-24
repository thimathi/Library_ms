/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import models.DBConnection;

/**
 *
 * @author Thimathi
 */
public class issueBooks extends javax.swing.JFrame {

    /**
     * Creates new form issueBooks
     */
    public issueBooks() {
        initComponents();
    }
    
    public void getBookDetails(){
        
        int bookID = Integer.parseInt(txt_bookID.getText());
        
        try{
            Connection con = DBConnection.getConnection();
            java.sql.PreparedStatement pst = con.prepareStatement("select * from bookdetails where bookID = ?");
            pst.setInt(1, bookID);
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                lbl_bookID.setText(rs.getString("bookID"));
                lbl_bookName.setText(rs.getString("bookName"));
                lbl_author.setText(rs.getString("author"));
                lbl_qty.setText(rs.getString("qty"));
                
            }
            else{
                lbl_bookID.setText("");
                lbl_bookName.setText("");
                lbl_author.setText("");
                lbl_qty.setText("");
                lbl_bookError.setText("Invalid Book ID");
                
                
            }
        }
        catch(Exception ex){
            ex.getMessage();
        }
    }
    
    public void getStudentDetails(){
        
        int studentID = Integer.parseInt(txt_stdID.getText());
        
        try{
            Connection con = DBConnection.getConnection();
            java.sql.PreparedStatement pst = con.prepareStatement("select * from studentdetails where studentID = ?");
            pst.setInt(1, studentID);
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                lbl_stdID.setText(rs.getString("studentID"));
                lbl_stdName.setText(rs.getString("name"));
                lbl_course.setText(rs.getString("course"));
                lbl_faculty.setText(rs.getString("branch"));
                
            }
            else{
                lbl_stdID.setText("");
                lbl_stdName.setText("");
                lbl_course.setText("");
                lbl_faculty.setText("");
                lbl_studentError.setText("Invalid Student ID");
            }
        }
        catch(Exception ex){
            ex.getMessage();
        }
    }
    
    //Insert issue book details to database
    //Insert issue book details to database
public boolean issueBook(){
    boolean isIssued = false;
    int bookID = Integer.parseInt(txt_bookID.getText());
    int studentID = Integer.parseInt(txt_stdID.getText());
    String bookName = lbl_bookName.getText();
    String studentName = lbl_stdName.getText();
    
    Date uIssueDate = date_issueDate.getDatoFecha();
    Date uDueDate = date_dueDate.getDatoFecha();
    
    long l1 = uIssueDate.getTime();
    long l2 = uDueDate.getTime();
    
    java.sql.Date sIssueDate = new java.sql.Date(l1);
    java.sql.Date sDueDate = new java.sql.Date(l2);
    
    try{
        Connection con = DBConnection.getConnection();
        String sql = "insert into issuebookdetails(bookID,bookName,studentID,studentName,issueDate,dueDate,status) values(?,?,?,?,?,?,?)";
        java.sql.PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, bookID);
        pst.setString(2,bookName);
        pst.setInt(3,studentID);
        pst.setString(4,studentName);
        pst.setDate(5, sIssueDate);
        pst.setDate(6, sDueDate);
        pst.setString(7, "PENDING");
        
       int i = pst.executeUpdate();
       if (i > 0){
           isIssued = true;
       }
       else{
           isIssued = false;
       }
        
    }
    catch(Exception ex){
        ex.getMessage();
    }
    return isIssued;
}
          
        //updating book count
    public void updateBookCount(){
        int bookID = Integer.parseInt(txt_bookID.getText());
        
        try{
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("update bookdetails set qty = qty - 1 where bookID = ?");
            pst.setInt(1, bookID);
            int i = pst.executeUpdate();
            
            if(i > 0){
                JOptionPane.showMessageDialog(this, "Book count Updated");
                int initialCount = Integer.parseInt(lbl_qty.getText());
                lbl_qty.setText(Integer.toString(initialCount - 1));
            }
            else{
                JOptionPane.showMessageDialog(this, "Book count Update Error");
            }
            
            
        }
        catch(Exception ex){
            ex.getMessage();
        }
    }
    
    //checking whether book already allocated or not
    public boolean isAlreadyIssued(){
        boolean isAllreadyIssued = false;
        int bookID = Integer.parseInt(txt_bookID.getText());
        int studentID = Integer.parseInt(txt_stdID.getText());
        
        try{
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from issuebookdetails where bookID = ? and studentID = ? and status =?");
            pst.setInt(1, bookID);
            pst.setInt(2,studentID);
            pst.setString(3,"PENDING");
            
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                isAllreadyIssued = true;
            }
            else{
                isAllreadyIssued = false;
            }
        }
        catch(Exception ex){
            ex.getMessage();
        }
        
        return isAllreadyIssued;
        
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        main_panel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbl_qty = new javax.swing.JTextField();
        lbl_bookID = new javax.swing.JTextField();
        lbl_bookName = new javax.swing.JTextField();
        lbl_author = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        lbl_bookError = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lbl_stdID = new javax.swing.JTextField();
        lbl_stdName = new javax.swing.JTextField();
        lbl_course = new javax.swing.JTextField();
        lbl_faculty = new javax.swing.JTextField();
        lbl_studentError = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txt_bookID = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txt_stdID = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        date_issueDate = new rojeru_san.componentes.RSDateChooser();
        date_dueDate = new rojeru_san.componentes.RSDateChooser();
        btn_add = new rojerusan.RSMaterialButtonCircle();
        jPanel8 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        main_panel.setBackground(new java.awt.Color(255, 255, 255));
        main_panel.setForeground(new java.awt.Color(255, 255, 255));
        main_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 102, 0));
        jPanel1.setToolTipText("");
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(153, 153, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel1.setText("Back");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 50));

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI", 1, 24)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/AddNewBookIcons/icons8_Literature_100px_1.png"))); // NOI18N
        jLabel2.setText("Book Details");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 270, 100));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 320, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 320, 5));

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel4.setText("Book ID :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 100, 30));

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel5.setText("Book Name :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 130, 30));

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel6.setText("Author :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 520, 100, 30));

        lbl_qty.setBackground(new java.awt.Color(0, 102, 0));
        lbl_qty.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_qty.setBorder(null);
        lbl_qty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbl_qtyActionPerformed(evt);
            }
        });
        jPanel1.add(lbl_qty, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 590, 380, -1));

        lbl_bookID.setBackground(new java.awt.Color(0, 102, 0));
        lbl_bookID.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_bookID.setBorder(null);
        jPanel1.add(lbl_bookID, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 380, 340, -1));

        lbl_bookName.setBackground(new java.awt.Color(0, 102, 0));
        lbl_bookName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_bookName.setBorder(null);
        jPanel1.add(lbl_bookName, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 450, 310, -1));

        lbl_author.setBackground(new java.awt.Color(0, 102, 0));
        lbl_author.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_author.setBorder(null);
        jPanel1.add(lbl_author, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 520, 350, -1));

        jLabel18.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel18.setText("QTY :");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 590, 100, 30));

        lbl_bookError.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_bookError.setForeground(new java.awt.Color(0, 255, 255));
        jPanel1.add(lbl_bookError, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 660, 410, 30));

        main_panel.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 810));

        jPanel4.setBackground(new java.awt.Color(153, 153, 0));
        jPanel4.setToolTipText("");
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Yu Gothic UI", 1, 24)); // NOI18N
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/AddNewBookIcons/icons8_Student_Registration_100px_2.png"))); // NOI18N
        jLabel8.setText("Student Details");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, 280, 100));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 320, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, 320, 5));

        jLabel9.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel9.setText("Faculty :");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 590, 100, 30));

        jLabel10.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel10.setText("Student ID :");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 130, 30));

        jLabel11.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel11.setText("Student Name :");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 170, 30));

        jLabel12.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel12.setText("Course :");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 520, 100, 30));

        lbl_stdID.setBackground(new java.awt.Color(153, 153, 0));
        lbl_stdID.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_stdID.setBorder(null);
        lbl_stdID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbl_stdIDActionPerformed(evt);
            }
        });
        jPanel4.add(lbl_stdID, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 380, 350, -1));

        lbl_stdName.setBackground(new java.awt.Color(153, 153, 0));
        lbl_stdName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_stdName.setBorder(null);
        jPanel4.add(lbl_stdName, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 450, 320, -1));

        lbl_course.setBackground(new java.awt.Color(153, 153, 0));
        lbl_course.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_course.setBorder(null);
        jPanel4.add(lbl_course, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 520, 380, -1));

        lbl_faculty.setBackground(new java.awt.Color(153, 153, 0));
        lbl_faculty.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_faculty.setBorder(null);
        jPanel4.add(lbl_faculty, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 590, 380, -1));

        lbl_studentError.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_studentError.setForeground(new java.awt.Color(0, 255, 255));
        jPanel4.add(lbl_studentError, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 660, 460, 30));

        main_panel.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 0, 490, 810));

        jPanel5.setBackground(new java.awt.Color(255, 255, 204));
        jPanel5.setForeground(new java.awt.Color(204, 51, 0));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Yu Gothic UI", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(204, 51, 0));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/AddNewBookIcons/icons8_Books_52px_1.png"))); // NOI18N
        jLabel13.setText("Issue Book");
        jPanel5.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 190, 80));

        jPanel7.setBackground(new java.awt.Color(204, 51, 0));
        jPanel7.setForeground(new java.awt.Color(204, 51, 0));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 320, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel5.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, 320, 5));

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Book ID :");
        jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 100, 30));

        txt_bookID.setBackground(new java.awt.Color(255, 255, 204));
        txt_bookID.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_bookID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txt_bookID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_bookIDFocusLost(evt);
            }
        });
        jPanel5.add(txt_bookID, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 380, 270, -1));

        jLabel14.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Due Date :");
        jPanel5.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 590, 130, 30));

        txt_stdID.setBackground(new java.awt.Color(253, 253, 204));
        txt_stdID.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_stdID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txt_stdID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_stdIDFocusLost(evt);
            }
        });
        jPanel5.add(txt_stdID, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 450, 270, -1));

        jLabel15.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("Student ID :");
        jPanel5.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 130, 30));

        jLabel16.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Issue Date :");
        jPanel5.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 520, 130, 30));

        date_issueDate.setColorBackground(new java.awt.Color(204, 0, 51));
        date_issueDate.setColorButtonHover(new java.awt.Color(204, 0, 51));
        date_issueDate.setColorDiaActual(new java.awt.Color(204, 0, 51));
        date_issueDate.setColorForeground(new java.awt.Color(204, 0, 51));
        jPanel5.add(date_issueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 520, 270, -1));

        date_dueDate.setColorBackground(new java.awt.Color(204, 0, 51));
        date_dueDate.setColorButtonHover(new java.awt.Color(204, 0, 51));
        date_dueDate.setColorDiaActual(new java.awt.Color(204, 0, 51));
        date_dueDate.setColorForeground(new java.awt.Color(204, 0, 51));
        jPanel5.add(date_dueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 590, 270, -1));

        btn_add.setBackground(new java.awt.Color(204, 0, 0));
        btn_add.setText("ISSUE BOOK");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });
        jPanel5.add(btn_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 680, 270, 70));

        jPanel8.setBackground(new java.awt.Color(204, 0, 0));
        jPanel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel8MouseClicked(evt);
            }
        });
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("X");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel8.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        jPanel5.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 0, 30, 30));

        main_panel.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 0, 450, 810));

        getContentPane().add(main_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1410, 810));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        adminDashboard adminDB = new adminDashboard();
        adminDB.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void lbl_qtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbl_qtyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_qtyActionPerformed

    private void lbl_stdIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbl_stdIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_stdIDActionPerformed

    private void txt_bookIDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_bookIDFocusLost
        if(!txt_bookID.getText().equals("")){
            getBookDetails();
        }
        else{
            JOptionPane.showMessageDialog(this, "No BookID Entered");
        }
    }//GEN-LAST:event_txt_bookIDFocusLost

    private void txt_stdIDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_stdIDFocusLost
        if(!txt_stdID.getText().equals("")){
            getStudentDetails();
        }
        else{
            JOptionPane.showMessageDialog(this, "No studentID Entered");
        }

    }//GEN-LAST:event_txt_stdIDFocusLost

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        
        if(lbl_qty.getText().equals("0")){
            JOptionPane.showMessageDialog(this, "Book Is Not Available");
        }
        else{
        
            if (isAlreadyIssued() == false){
        
                if(issueBook() == true){
                JOptionPane.showMessageDialog(this, "Book Issued Successfully");
                updateBookCount();

                }
                    else{
                    JOptionPane.showMessageDialog(this, "Book Issued Unsuccessfully");
                    }

        }
            else{
            JOptionPane.showMessageDialog(this, "Book Already Issued");
        }
        }
    }//GEN-LAST:event_btn_addActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        dispose();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jPanel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseClicked
       System.exit(0);
    }//GEN-LAST:event_jPanel8MouseClicked

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
            java.util.logging.Logger.getLogger(issueBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(issueBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(issueBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(issueBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new issueBooks().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSMaterialButtonCircle btn_add;
    private rojeru_san.componentes.RSDateChooser date_dueDate;
    private rojeru_san.componentes.RSDateChooser date_issueDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JTextField lbl_author;
    private javax.swing.JLabel lbl_bookError;
    private javax.swing.JTextField lbl_bookID;
    private javax.swing.JTextField lbl_bookName;
    private javax.swing.JTextField lbl_course;
    private javax.swing.JTextField lbl_faculty;
    private javax.swing.JTextField lbl_qty;
    private javax.swing.JTextField lbl_stdID;
    private javax.swing.JTextField lbl_stdName;
    private javax.swing.JLabel lbl_studentError;
    private javax.swing.JPanel main_panel;
    private javax.swing.JTextField txt_bookID;
    private javax.swing.JTextField txt_stdID;
    // End of variables declaration//GEN-END:variables
}
