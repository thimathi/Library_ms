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
public class returnBooks extends javax.swing.JFrame {

    /**
     * Creates new form issueBooks
     */
    public returnBooks() {
        initComponents();
    }
    //to fetch the issue book details from the database and display it to panel
    public void getIssueBookDetails(){
        
        int bookID = Integer.parseInt(txt_bookID.getText());
        int studentID = Integer.parseInt(txt_stdID.getText());
        
        try{
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("Select * from issuebookdetails where bookID = ? and studentID = ? and status = ?");
            pst.setInt(1, bookID);
            pst.setInt(2, studentID);
            pst.setString(3, "PENDING");
            
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                
                lbl_issueID.setText(rs.getString("id"));
                lbl_bookName.setText(rs.getString("bookName"));
                lbl_stdName.setText(rs.getString("studentName"));
                lbl_issueDate.setText(rs.getString("issueDate"));
                lbl_dueDate.setText(rs.getString("dueDate"));
                lbl_returnError.setText("");
                                                
            }
            else{
             lbl_returnError.setText("No record found");   
             
             lbl_issueID.setText(rs.getString(""));
             lbl_bookName.setText(rs.getString(""));
             lbl_stdName.setText(rs.getString(""));
             lbl_issueDate.setText(rs.getString(""));
             lbl_dueDate.setText(rs.getString(""));
            }
        }
        catch (Exception ex){
            ex.getMessage();
        }
        
    }
    
    //return the book
    public boolean returnBook(){
        boolean isReturned = false;
        int bookID = Integer.parseInt(txt_bookID.getText());
        int studentID = Integer.parseInt(txt_stdID.getText());
        
        try{
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("update issuebookdetails set status = ? where studentID = ? and bookID = ? and status = ?");
            pst.setString(1, "RETURNED");
            pst.setInt(2, studentID);
            pst.setInt(3, bookID);
            pst.setString(4, "PENDING");
            int i = pst.executeUpdate();
            
            if(i > 0){
                isReturned = true;
            }
            else{
                isReturned = false;
            }
            
        }
        catch (Exception ex){
            ex.getMessage();
        }
    return isReturned;
    }
    
    //updating book count
    public void updateBookCount(){
        int bookID = Integer.parseInt(txt_bookID.getText());
        
        try{
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("update bookdetails set qty = qty + 1 where bookID = ?");
            pst.setInt(1, bookID);
            int i = pst.executeUpdate();
            
            if(i > 0){
                JOptionPane.showMessageDialog(this, "Book count Updated");
            }
            else{
                JOptionPane.showMessageDialog(this, "Book count Update Error");
            }
            
            
        }
        catch(Exception ex){
            ex.getMessage();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        main_panel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbl_issueDate = new javax.swing.JTextField();
        lbl_issueID = new javax.swing.JTextField();
        lbl_bookName = new javax.swing.JTextField();
        lbl_stdName = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        lbl_dueDate = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        lbl_returnError = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txt_bookID = new javax.swing.JTextField();
        txt_stdID = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        btn_add = new rojerusan.RSMaterialButtonCircle();
        jPanel8 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btn_add1 = new rojerusan.RSMaterialButtonCircle();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        main_panel.setBackground(new java.awt.Color(255, 255, 255));
        main_panel.setForeground(new java.awt.Color(255, 255, 255));
        main_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 102, 0));
        jPanel1.setToolTipText("");
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jLabel4.setText("Issue ID :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 100, 30));

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel5.setText("Book Name :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 130, 30));

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel6.setText("Student Name :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 520, 150, 30));

        lbl_issueDate.setBackground(new java.awt.Color(0, 102, 0));
        lbl_issueDate.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_issueDate.setBorder(null);
        lbl_issueDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbl_issueDateActionPerformed(evt);
            }
        });
        jPanel1.add(lbl_issueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 590, 320, -1));

        lbl_issueID.setBackground(new java.awt.Color(0, 102, 0));
        lbl_issueID.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_issueID.setBorder(null);
        jPanel1.add(lbl_issueID, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 380, 340, -1));

        lbl_bookName.setBackground(new java.awt.Color(0, 102, 0));
        lbl_bookName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_bookName.setBorder(null);
        jPanel1.add(lbl_bookName, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 450, 310, -1));

        lbl_stdName.setBackground(new java.awt.Color(0, 102, 0));
        lbl_stdName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_stdName.setBorder(null);
        jPanel1.add(lbl_stdName, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 520, 280, -1));

        jLabel18.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel18.setText("Issue Date :");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 590, 110, 30));

        lbl_dueDate.setBackground(new java.awt.Color(0, 102, 0));
        lbl_dueDate.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_dueDate.setBorder(null);
        lbl_dueDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbl_dueDateActionPerformed(evt);
            }
        });
        jPanel1.add(lbl_dueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 670, 320, -1));

        jLabel19.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel19.setText("Due Date :");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 660, 110, 30));

        lbl_returnError.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_returnError.setForeground(new java.awt.Color(0, 255, 255));
        jPanel1.add(lbl_returnError, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 730, 410, 40));

        main_panel.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 0, 450, 810));

        jPanel5.setBackground(new java.awt.Color(255, 255, 204));
        jPanel5.setForeground(new java.awt.Color(204, 51, 0));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Yu Gothic UI", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(204, 51, 0));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/AddNewBookIcons/icons8_Books_52px_1.png"))); // NOI18N
        jLabel13.setText("Return Book");
        jPanel5.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(137, 140, -1, 80));

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

        btn_add.setBackground(new java.awt.Color(153, 153, 0));
        btn_add.setText("FIND");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });
        jPanel5.add(btn_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 530, 270, 70));

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

        btn_add1.setBackground(new java.awt.Color(204, 0, 0));
        btn_add1.setText("RETURN BOOK");
        btn_add1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_add1ActionPerformed(evt);
            }
        });
        jPanel5.add(btn_add1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 620, 270, 70));

        main_panel.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 0, 450, 810));

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

        main_panel.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 50));

        jLabel8.setIcon(new javax.swing.ImageIcon("C:\\Users\\Thimathi\\Downloads\\library-2.png")); // NOI18N
        main_panel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 500, 420));

        getContentPane().add(main_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1410, 810));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        adminDashboard adminDB = new adminDashboard();
        adminDB.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void lbl_issueDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbl_issueDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_issueDateActionPerformed

    private void txt_bookIDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_bookIDFocusLost
       
    }//GEN-LAST:event_txt_bookIDFocusLost

    private void txt_stdIDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_stdIDFocusLost
       
    }//GEN-LAST:event_txt_stdIDFocusLost

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        getIssueBookDetails();        
    }//GEN-LAST:event_btn_addActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        dispose();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void btn_add1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_add1ActionPerformed

       if(returnBook() == true){
           JOptionPane.showMessageDialog(this, "Returned Successfully");
           updateBookCount();
       }
       else{
           JOptionPane.showMessageDialog(this, "Returned Unsuccessfully");
       }
    }//GEN-LAST:event_btn_add1ActionPerformed

    private void lbl_dueDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbl_dueDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_dueDateActionPerformed

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
            java.util.logging.Logger.getLogger(returnBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(returnBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(returnBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(returnBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new returnBooks().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSMaterialButtonCircle btn_add;
    private rojerusan.RSMaterialButtonCircle btn_add1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JTextField lbl_bookName;
    private javax.swing.JTextField lbl_dueDate;
    private javax.swing.JTextField lbl_issueDate;
    private javax.swing.JTextField lbl_issueID;
    private javax.swing.JLabel lbl_returnError;
    private javax.swing.JTextField lbl_stdName;
    private javax.swing.JPanel main_panel;
    private javax.swing.JTextField txt_bookID;
    private javax.swing.JTextField txt_stdID;
    // End of variables declaration//GEN-END:variables
}
