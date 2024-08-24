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
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import models.DBConnection;


/**
 *
 * @author Thimathi
 */
public class managebooks extends javax.swing.JFrame {

    /**
     * Creates new form managebooks
     */
    
    String bookName;
    String author;
    int bookID;
    int qty;
    DefaultTableModel model;
    
    
    public managebooks() {
        initComponents();
        setbookDetailsToTable();
        
    }
    
    public void setbookDetailsToTable(){
    
    
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms","root","root");
        PreparedStatement pst =  con.prepareStatement("SELECT * FROM  bookDetails");
        ResultSet rs = pst.executeQuery();
        
        while(rs.next()){
            String bookID = rs.getString("bookID");
            String bookName = rs.getString("bookName");
            String author = rs.getString("author");
            int qty = rs.getInt("qty");
            
            Object [] obj = {bookID,bookName,author,qty};
            model = (DefaultTableModel) tbl_bookDetails.getModel();
            model.addRow(obj);
        }
            
        
}
    catch(Exception ex){
            ex.getMessage();
    }
    
    
    }
    
    public void refreshTable() {
        model.setRowCount(0); 
        setbookDetailsToTable(); 
    }
    
    
    
    //To add book to book details table
    public boolean addbook(){
        boolean isAdded = false;
        bookID = Integer.parseInt(txt_bookID.getText());
        bookName = txt_bookName.getText();
        author = txt_author.getText();
        qty = Integer.parseInt(txt_qty.getText());
        
        
        try{
            Connection conn = DBConnection.getConnection();
            PreparedStatement pst = conn.prepareStatement("insert into bookdetails values(?,?,?,?)");
            pst.setInt(1, bookID);
            pst.setString(2, bookName);
            pst.setString(3, author);
            pst.setInt(4, qty);
            
            int i = pst.executeUpdate();
            if (i > 0){
                isAdded = true;
                refreshTable();
            }
            else{
                isAdded = false;
            }
                                
        }
        catch(Exception ex){
            ex.getMessage();
        }
        return isAdded;
    }
    
    public void removeFields(){
        txt_bookID.setText("");
        txt_bookName.setText("");
        txt_author.setText("");
        txt_qty.setText("");
    }
    
    public boolean updatebook(){
    boolean isUpdated = false;
    bookID = Integer.parseInt(txt_bookID.getText());
    bookName = txt_bookName.getText();
    author = txt_author.getText();
    qty = Integer.parseInt(txt_qty.getText());
    
    try{
        Connection conn = DBConnection.getConnection();
        PreparedStatement pst = conn.prepareStatement("update bookdetails set bookName = ?, author = ?, qty = ? where bookID = ?");
        pst.setString(1, bookName);
        pst.setString(2, author);
        pst.setInt(3, qty);
        pst.setInt(4, bookID);

        int i = pst.executeUpdate();
        
        if (i > 0){
            isUpdated = true;
            refreshTable();
        } else {
            isUpdated = false;
        }                           
    } catch (Exception ex){
        ex.printStackTrace();
    }
    return isUpdated;
}

    
    public boolean deletebook(){
        boolean isDeleted = false;
        bookID = Integer.parseInt(txt_bookID.getText());
    
        try{
            Connection conn = DBConnection.getConnection();
            PreparedStatement pst = conn.prepareStatement("delete from bookDetails where bookID = ?");
            pst.setInt(1, bookID);

        int i = pst.executeUpdate();
        
        if (i > 0){
            isDeleted = true;
            refreshTable();
        } else{
            isDeleted = false;
        }
    }
    catch (Exception ex){
        ex.printStackTrace();
        return false;
    }
    return isDeleted;
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rSButtonMetroBeanInfo1 = new rojerusan.RSButtonMetroBeanInfo();
        jPanel11 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_bookID = new app.bolivia.swing.JCTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_bookName = new app.bolivia.swing.JCTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_author = new app.bolivia.swing.JCTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_qty = new app.bolivia.swing.JCTextField();
        rSMaterialButtonCircle1 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle2 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle3 = new rojerusan.RSMaterialButtonCircle();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_bookDetails = new rojerusan.RSTableMetro();
        jLabel6 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel11.setBackground(new java.awt.Color(204, 0, 0));
        jPanel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel11MouseClicked(evt);
            }
        });
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("X");
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        jPanel11.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 20, 30));

        getContentPane().add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1690, 0, 40, -1));

        jPanel1.setBackground(new java.awt.Color(153, 153, 0));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(204, 0, 0));
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

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 110, 50);

        jLabel2.setFont(new java.awt.Font("Quicksand Light", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Enter Book ID");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(100, 130, 170, 30);

        txt_bookID.setBackground(new java.awt.Color(153, 153, 0));
        txt_bookID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txt_bookID.setFont(new java.awt.Font("Lucida Console", 1, 14)); // NOI18N
        txt_bookID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_bookIDFocusLost(evt);
            }
        });
        jPanel1.add(txt_bookID);
        txt_bookID.setBounds(100, 160, 410, 32);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/AddNewBookIcons/icons8_Contact_26px.png"))); // NOI18N
        jPanel1.add(jLabel7);
        jLabel7.setBounds(50, 140, 40, 50);

        jLabel3.setFont(new java.awt.Font("Quicksand Light", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Enter Book Name");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(100, 220, 160, 30);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/AddNewBookIcons/icons8_Moleskine_26px.png"))); // NOI18N
        jPanel1.add(jLabel8);
        jLabel8.setBounds(50, 230, 60, 60);

        txt_bookName.setBackground(new java.awt.Color(153, 153, 0));
        txt_bookName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txt_bookName.setFont(new java.awt.Font("Lucida Console", 1, 14)); // NOI18N
        txt_bookName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_bookNameFocusLost(evt);
            }
        });
        jPanel1.add(txt_bookName);
        txt_bookName.setBounds(100, 250, 410, 32);

        jLabel4.setFont(new java.awt.Font("Quicksand Light", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Author Name");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(100, 300, 160, 30);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/AddNewBookIcons/icons8_Collaborator_Male_26px.png"))); // NOI18N
        jPanel1.add(jLabel9);
        jLabel9.setBounds(50, 310, 60, 60);

        txt_author.setBackground(new java.awt.Color(153, 153, 0));
        txt_author.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txt_author.setFont(new java.awt.Font("Lucida Console", 1, 14)); // NOI18N
        txt_author.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_authorFocusLost(evt);
            }
        });
        jPanel1.add(txt_author);
        txt_author.setBounds(100, 330, 410, 32);

        jLabel5.setFont(new java.awt.Font("Quicksand Light", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("QTY");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(100, 380, 90, 30);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/AddNewBookIcons/icons8_Unit_26px.png"))); // NOI18N
        jPanel1.add(jLabel10);
        jLabel10.setBounds(50, 390, 60, 60);

        txt_qty.setBackground(new java.awt.Color(153, 153, 0));
        txt_qty.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txt_qty.setFont(new java.awt.Font("Lucida Console", 1, 14)); // NOI18N
        txt_qty.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_qtyFocusLost(evt);
            }
        });
        jPanel1.add(txt_qty);
        txt_qty.setBounds(100, 410, 410, 32);

        rSMaterialButtonCircle1.setBackground(new java.awt.Color(204, 0, 0));
        rSMaterialButtonCircle1.setText("DELETE");
        rSMaterialButtonCircle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle1ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle1);
        rSMaterialButtonCircle1.setBounds(370, 470, 140, 90);

        rSMaterialButtonCircle2.setBackground(new java.awt.Color(204, 0, 0));
        rSMaterialButtonCircle2.setText("ADD");
        rSMaterialButtonCircle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle2ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle2);
        rSMaterialButtonCircle2.setBounds(40, 470, 140, 90);

        rSMaterialButtonCircle3.setBackground(new java.awt.Color(204, 0, 0));
        rSMaterialButtonCircle3.setText("UPDATE");
        rSMaterialButtonCircle3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle3ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle3);
        rSMaterialButtonCircle3.setBounds(200, 470, 140, 90);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 830));
        jPanel1.getAccessibleContext().setAccessibleName("");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(null);

        tbl_bookDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book_ID", "Name", "Author", "QTY"
            }
        ));
        tbl_bookDetails.setColorBackgoundHead(new java.awt.Color(153, 153, 0));
        tbl_bookDetails.setColorBordeFilas(new java.awt.Color(153, 153, 0));
        tbl_bookDetails.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tbl_bookDetails.setColorSelBackgound(new java.awt.Color(255, 51, 51));
        tbl_bookDetails.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 24)); // NOI18N
        tbl_bookDetails.setFuenteFilas(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        tbl_bookDetails.setFuenteFilasSelect(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        tbl_bookDetails.setFuenteHead(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        tbl_bookDetails.setRowHeight(40);
        tbl_bookDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_bookDetailsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_bookDetails);

        jPanel3.add(jScrollPane2);
        jScrollPane2.setBounds(130, 180, 750, 440);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 0, 0));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/AddNewBookIcons/icons8_Books_52px_1.png"))); // NOI18N
        jLabel6.setText("Manage Books");
        jPanel3.add(jLabel6);
        jLabel6.setBounds(370, 70, 260, 40);

        jPanel4.setBackground(new java.awt.Color(204, 0, 0));
        jPanel3.add(jPanel4);
        jPanel4.setBounds(310, 120, 390, 5);

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 0, 1150, 830));

        setSize(new java.awt.Dimension(1724, 824));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        adminDashboard adminDB = new adminDashboard();
        adminDB.setVisible(true);
        dispose();       
    }//GEN-LAST:event_jLabel1MouseClicked

    private void txt_bookIDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_bookIDFocusLost

        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bookIDFocusLost

    private void txt_bookNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_bookNameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bookNameFocusLost

    private void txt_authorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_authorFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_authorFocusLost

    private void txt_qtyFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_qtyFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_qtyFocusLost

    private void tbl_bookDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_bookDetailsMouseClicked

        int rowNo = tbl_bookDetails.getSelectedRow();
        TableModel model = tbl_bookDetails.getModel();
        
        txt_bookID.setText(model.getValueAt(rowNo, 0).toString());
        txt_bookName.setText(model.getValueAt(rowNo, 1).toString());
        txt_author.setText(model.getValueAt(rowNo, 2).toString());
        txt_qty.setText(model.getValueAt(rowNo, 3).toString());
    
    }//GEN-LAST:event_tbl_bookDetailsMouseClicked

    private void rSMaterialButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2ActionPerformed
        if(addbook() == true){
            JOptionPane.showMessageDialog(this, "book Added");
            removeFields();
        }       
        else{
            JOptionPane.showMessageDialog(this, "book Not Added");
            removeFields();
        }
    }//GEN-LAST:event_rSMaterialButtonCircle2ActionPerformed

    private void rSMaterialButtonCircle3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle3ActionPerformed
          if(updatebook() == true){
              JOptionPane.showMessageDialog(this, "book Updated");
              removeFields();
          }       
        else{
              JOptionPane.showMessageDialog(this, "book Not Updated");
              removeFields();
          }
    }//GEN-LAST:event_rSMaterialButtonCircle3ActionPerformed

    private void rSMaterialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1ActionPerformed
            if(deletebook() == true){
              JOptionPane.showMessageDialog(this, "book Deleted");
              removeFields();
          }       
             else{
              JOptionPane.showMessageDialog(this, "book Not Deleted");
              removeFields();
          }

        
    }//GEN-LAST:event_rSMaterialButtonCircle1ActionPerformed

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked

        System.exit(0);
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jPanel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jPanel11MouseClicked

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
            java.util.logging.Logger.getLogger(managebooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(managebooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(managebooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(managebooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new managebooks().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private rojerusan.RSButtonMetroBeanInfo rSButtonMetroBeanInfo1;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle1;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle2;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle3;
    private rojerusan.RSTableMetro tbl_bookDetails;
    private app.bolivia.swing.JCTextField txt_author;
    private app.bolivia.swing.JCTextField txt_bookID;
    private app.bolivia.swing.JCTextField txt_bookName;
    private app.bolivia.swing.JCTextField txt_qty;
    // End of variables declaration//GEN-END:variables
}
