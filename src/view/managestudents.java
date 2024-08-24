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
public class managestudents extends javax.swing.JFrame {
    
    String studentName;
    String course;
    String faculty;
    int studentID;
    
    DefaultTableModel model;
    
    
    public managestudents() {
        initComponents();
        setstudentDetailsToTable();
        
    }
    
    public void setstudentDetailsToTable(){
    
    
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms","root","root");
        PreparedStatement pst =  con.prepareStatement("SELECT * FROM  studentDetails");
        ResultSet rs = pst.executeQuery();
        
        while(rs.next()){
            String studentID = rs.getString("studentID");
            String studentName = rs.getString("name");
            String course = rs.getString("course");
            String faculty = rs.getString("branch");
            
            
            Object [] obj = {studentID,studentName,course,faculty};
            model = (DefaultTableModel) tbl_studentDetails.getModel();
            model.addRow(obj);
        }
            
        
}
    catch(Exception ex){
            ex.getMessage();
    }
    
    
    }
    
    public void refreshTable() {
        model.setRowCount(0); 
        setstudentDetailsToTable(); 
    }
    
    
    
    //To add student to student details table
    public boolean addstudent(){
        boolean isAdded = false;
        studentID = Integer.parseInt(txt_studentID.getText());
        studentName = txt_studentName.getText();
        course = combo_course.getSelectedItem().toString();
        faculty = combo_faculty.getSelectedItem().toString();
        
        
      
            
        try{
            Connection conn = DBConnection.getConnection();
            PreparedStatement pst = conn.prepareStatement("insert into studentdetails values(?,?,?,?)");
            pst.setInt(1, studentID);
            pst.setString(2, studentName);
            pst.setString(3, course);
            pst.setString(4, faculty);
            
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
        txt_studentID.setText("");
        txt_studentName.setText("");
        
    }
    
public boolean updatestudents() {
    boolean isUpdated = false;
    studentID = Integer.parseInt(txt_studentID.getText());
    studentName = txt_studentName.getText();
    course = combo_course.getSelectedItem().toString();
    faculty = combo_faculty.getSelectedItem().toString();

    try {
        Connection conn = DBConnection.getConnection();
        PreparedStatement pst = conn.prepareStatement("UPDATE studentDetails SET name = ?, course = ?, branch = ? WHERE studentID = ?");

        pst.setString(1, studentName);
        pst.setString(2, course);
        pst.setString(3, faculty);
        pst.setInt(4, studentID);

        int i = pst.executeUpdate();

        if (i > 0) {
            isUpdated = true;
            refreshTable();
        } else {
            isUpdated = false;
        }
    } catch (Exception ex) {
        ex.printStackTrace();
    }
    return isUpdated;
}


    
    public boolean deletestudents(){
        boolean isDeleted = false;
        studentID = Integer.parseInt(txt_studentID.getText());
    
        try{
            Connection conn = DBConnection.getConnection();
            PreparedStatement pst = conn.prepareStatement("DELETE FROM studentDetails WHERE studentID = ?");
            pst.setInt(1, studentID);

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
        txt_studentID = new app.bolivia.swing.JCTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_studentName = new app.bolivia.swing.JCTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        rSMaterialButtonCircle1 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle2 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle3 = new rojerusan.RSMaterialButtonCircle();
        combo_faculty = new javax.swing.JComboBox<>();
        combo_course = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_studentDetails = new rojerusan.RSTableMetro();
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

        getContentPane().add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1700, 0, 30, -1));

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
        jLabel2.setText("Enter Student ID");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(100, 130, 170, 30);

        txt_studentID.setBackground(new java.awt.Color(153, 153, 0));
        txt_studentID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txt_studentID.setFont(new java.awt.Font("Lucida Console", 1, 14)); // NOI18N
        txt_studentID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_studentIDFocusLost(evt);
            }
        });
        jPanel1.add(txt_studentID);
        txt_studentID.setBounds(100, 160, 410, 32);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/AddNewBookIcons/icons8_Contact_26px.png"))); // NOI18N
        jPanel1.add(jLabel7);
        jLabel7.setBounds(50, 140, 40, 50);

        jLabel3.setFont(new java.awt.Font("Quicksand Light", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Enter Student Name");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(100, 220, 200, 30);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/AddNewBookIcons/icons8_Moleskine_26px.png"))); // NOI18N
        jPanel1.add(jLabel8);
        jLabel8.setBounds(50, 230, 60, 60);

        txt_studentName.setBackground(new java.awt.Color(153, 153, 0));
        txt_studentName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txt_studentName.setFont(new java.awt.Font("Lucida Console", 1, 14)); // NOI18N
        txt_studentName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_studentNameFocusLost(evt);
            }
        });
        jPanel1.add(txt_studentName);
        txt_studentName.setBounds(100, 250, 410, 32);

        jLabel4.setFont(new java.awt.Font("Quicksand Light", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Course");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(100, 300, 160, 30);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/AddNewBookIcons/icons8_Collaborator_Male_26px.png"))); // NOI18N
        jPanel1.add(jLabel9);
        jLabel9.setBounds(50, 310, 60, 60);

        jLabel5.setFont(new java.awt.Font("Quicksand Light", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Faculty");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(100, 380, 90, 30);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/AddNewBookIcons/icons8_Unit_26px.png"))); // NOI18N
        jPanel1.add(jLabel10);
        jLabel10.setBounds(50, 390, 60, 60);

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

        combo_faculty.setFont(new java.awt.Font("Lucida Console", 1, 14)); // NOI18N
        combo_faculty.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Computing", "Engineering", "Designing", "Management" }));
        jPanel1.add(combo_faculty);
        combo_faculty.setBounds(100, 410, 410, 40);

        combo_course.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        combo_course.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bachelor of Business Administration (BBA)", "Master of Business Administration (MBA) ", "Diploma in Business Information Systems", "Diploma in Information and Communication Technology" }));
        jPanel1.add(combo_course);
        combo_course.setBounds(100, 330, 410, 40);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 830));
        jPanel1.getAccessibleContext().setAccessibleName("");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(null);

        tbl_studentDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student_ID", "Name", "Course", "Faculty"
            }
        ));
        tbl_studentDetails.setColorBackgoundHead(new java.awt.Color(153, 153, 0));
        tbl_studentDetails.setColorBordeFilas(new java.awt.Color(153, 153, 0));
        tbl_studentDetails.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tbl_studentDetails.setColorSelBackgound(new java.awt.Color(255, 51, 51));
        tbl_studentDetails.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 24)); // NOI18N
        tbl_studentDetails.setFuenteFilas(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        tbl_studentDetails.setFuenteFilasSelect(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        tbl_studentDetails.setFuenteHead(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        tbl_studentDetails.setRowHeight(40);
        tbl_studentDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_studentDetailsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_studentDetails);

        jPanel3.add(jScrollPane2);
        jScrollPane2.setBounds(130, 180, 750, 440);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 0, 0));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/AddNewBookIcons/icons8_Student_Male_100px.png"))); // NOI18N
        jLabel6.setText("Manage Students");
        jPanel3.add(jLabel6);
        jLabel6.setBounds(330, 20, 340, 90);

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

    private void txt_studentIDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentIDFocusLost

        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentIDFocusLost

    private void txt_studentNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentNameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentNameFocusLost

    private void tbl_studentDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_studentDetailsMouseClicked

        int rowNo = tbl_studentDetails.getSelectedRow();
        TableModel model = tbl_studentDetails.getModel();
        
        txt_studentID.setText(model.getValueAt(rowNo, 0).toString());
        txt_studentName.setText(model.getValueAt(rowNo, 1).toString());
        combo_course.setSelectedItem(model.getValueAt(rowNo,2).toString());
        combo_faculty.setSelectedItem(model.getValueAt(rowNo, 3).toString());
    }//GEN-LAST:event_tbl_studentDetailsMouseClicked

    private void rSMaterialButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2ActionPerformed
        if(addstudent() == true){
            JOptionPane.showMessageDialog(this, "Student Added");
            removeFields();
            
        }       
        else{
            JOptionPane.showMessageDialog(this, "Student Not Added");
            removeFields();
        }
    }//GEN-LAST:event_rSMaterialButtonCircle2ActionPerformed

    private void rSMaterialButtonCircle3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle3ActionPerformed
          if(updatestudents() == true){
              JOptionPane.showMessageDialog(this, "Student Updated");
              removeFields();
          }       
        else{
              JOptionPane.showMessageDialog(this, "Student Not Updated");
              removeFields();
          }
    }//GEN-LAST:event_rSMaterialButtonCircle3ActionPerformed

    private void rSMaterialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1ActionPerformed
            if(deletestudents() == true){
              JOptionPane.showMessageDialog(this, "Student Deleted");
              removeFields();
          }       
             else{
              JOptionPane.showMessageDialog(this, "Student Not Deleted");
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
            java.util.logging.Logger.getLogger(managestudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(managestudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(managestudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(managestudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new managestudents().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combo_course;
    private javax.swing.JComboBox<String> combo_faculty;
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
    private rojerusan.RSTableMetro tbl_studentDetails;
    private app.bolivia.swing.JCTextField txt_studentID;
    private app.bolivia.swing.JCTextField txt_studentName;
    // End of variables declaration//GEN-END:variables
}
