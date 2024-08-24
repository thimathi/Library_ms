package reports;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import net.sf.jasperreports.view.*;
import view.adminDashboard;

public class mainReport extends javax.swing.JFrame {

    /**
     * Creates new form mainReport
     */
    public mainReport() {
        initComponents();
    }

    public void getbookInventoryReport() {
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms", "root", "root")) {
            JasperDesign jdesign = JRXmlLoader.load("F:\\Library_Management_System\\Library_Management_System\\src\\reports\\report1.jrxml");

            String query = "SELECT bookdetails.bookID, bookdetails.bookName, bookdetails.author, bookdetails.qty, issuebookdetails.studentName, issuebookdetails.issueDate, issuebookdetails.dueDate, issuebookdetails.status FROM bookdetails INNER JOIN issuebookdetails ON bookdetails.bookID = issuebookdetails.bookID";

            JRDesignQuery updateQuery = new JRDesignQuery();
            updateQuery.setText(query);
            jdesign.setQuery(updateQuery);

            JasperReport jReport1 = JasperCompileManager.compileReport(jdesign);
            JasperPrint jPrint1 = JasperFillManager.fillReport(jReport1, null, con);

            JasperViewer.viewReport(jPrint1);

        } catch (SQLException | JRException ex) {
            Logger.getLogger(mainReport.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void getstudentBorrowingReport() {
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms", "root", "root")) {
            JasperDesign jdesign = JRXmlLoader.load("F:\\Library_Management_System\\Library_Management_System\\src\\reports\\report2.jrxml");

            String query = "SELECT studentdetails.*, issuebookdetails.id, issuebookdetails.bookName, issuebookdetails.issueDate, issuebookdetails.dueDate, issuebookdetails.status FROM studentdetails JOIN issuebookdetails ON issuebookdetails.studentID = studentdetails.studentID";

            JRDesignQuery updateQuery = new JRDesignQuery();
            updateQuery.setText(query);
            jdesign.setQuery(updateQuery);

            JasperReport jReport = JasperCompileManager.compileReport(jdesign);
            JasperPrint jPrint = JasperFillManager.fillReport(jReport, null, con);
            JasperViewer.viewReport(jPrint);

        } catch (SQLException | JRException ex) {
            Logger.getLogger(mainReport.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void getreturnReport() {
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms", "root", "root")) {
            JasperDesign jdesign = JRXmlLoader.load("F:\\Library_Management_System\\Library_Management_System\\src\\reports\\report3.jrxml");

            String query = "SELECT * FROM library_ms.issuebookdetails Where status = 'RETURNED' ";

            JRDesignQuery updateQuery = new JRDesignQuery();
            updateQuery.setText(query);
            jdesign.setQuery(updateQuery);

            JasperReport jReport = JasperCompileManager.compileReport(jdesign);
            JasperPrint jPrint = JasperFillManager.fillReport(jReport, null, con);
            JasperViewer.viewReport(jPrint);

        } catch (SQLException | JRException ex) {
            Logger.getLogger(mainReport.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btn_lateReturnReport = new rojerusan.RSMaterialButtonRectangle();
        btn_bookInventoryReport = new rojerusan.RSMaterialButtonRectangle();
        btn_studentBorrowingReport = new rojerusan.RSMaterialButtonRectangle();
        jPanel8 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 135, 320, 5));

        jPanel2.setBackground(new java.awt.Color(153, 153, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Yu Gothic UI", 1, 24));
        jLabel13.setForeground(new java.awt.Color(204, 51, 0));
        jLabel13.setIcon(new javax.swing.ImageIcon("C:\\Users\\Thimathi\\Downloads\\icons8-report-50.png"));
        jLabel13.setText("Reports");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, -1, 80));

        jPanel3.setBackground(new java.awt.Color(204, 51, 0));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 16));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/AddNewBookIcons/icons8_Rewind_48px.png")));
        jLabel1.setText("Back");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, 30));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 50));

        btn_lateReturnReport.setBackground(new java.awt.Color(204, 51, 0));
        btn_lateReturnReport.setText("RETURN REPORT");
        btn_lateReturnReport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_lateReturnReportMouseClicked(evt);
            }
        });
        btn_lateReturnReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lateReturnReportActionPerformed(evt);
            }
        });
        jPanel2.add(btn_lateReturnReport, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 480, -1, -1));

        btn_bookInventoryReport.setBackground(new java.awt.Color(204, 51, 0));
        btn_bookInventoryReport.setText("BOOK INVENTORY REPORT");
        btn_bookInventoryReport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_bookInventoryReportMouseClicked(evt);
            }
        });
        btn_bookInventoryReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_bookInventoryReportActionPerformed(evt);
            }
        });
        jPanel2.add(btn_bookInventoryReport, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, -1, -1));

        btn_studentBorrowingReport.setBackground(new java.awt.Color(204, 51, 0));
        btn_studentBorrowingReport.setText("STUDENT BORROWING REPORT");
        btn_studentBorrowingReport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_studentBorrowingReportMouseClicked(evt);
            }
        });

        btn_studentBorrowingReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_studentBorrowingReportActionPerformed(evt);
            }
        });
        jPanel2.add(btn_studentBorrowingReport, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 350, -1, -1));

        jPanel8.setBackground(new java.awt.Color(204, 0, 0));
        jPanel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel8MouseClicked(evt);
            }
        });
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18));
        jLabel4.setText("X");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel8.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        jPanel2.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 0, 30, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 660));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 660));

        setSize(new java.awt.Dimension(551, 654));
        setLocationRelativeTo(null);
    }

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {
        adminDashboard adminDB = new adminDashboard();
        adminDB.setVisible(true);
        dispose();
    }

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {
        dispose();
    }

    private void jPanel8MouseClicked(java.awt.event.MouseEvent evt) {
        System.exit(0);
    }

    private void btn_bookInventoryReportActionPerformed(java.awt.event.ActionEvent evt) {
        getbookInventoryReport();
    }

    private void btn_bookInventoryReportMouseClicked(java.awt.event.MouseEvent evt) {
        getbookInventoryReport();
    }

    private void btn_studentBorrowingReportActionPerformed(java.awt.event.ActionEvent evt) {
        getstudentBorrowingReport();
    }

    private void btn_studentBorrowingReportMouseClicked(java.awt.event.MouseEvent evt) {
        getstudentBorrowingReport();
    }

    private void btn_lateReturnReportActionPerformed(java.awt.event.ActionEvent evt) {
        getreturnReport();
    }

    private void btn_lateReturnReportMouseClicked(java.awt.event.MouseEvent evt) {
        getreturnReport();
    }

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new mainReport().setVisible(true);
        });
    }

    // Variables declaration - do not modify
    private rojerusan.RSMaterialButtonRectangle btn_bookInventoryReport;
    private rojerusan.RSMaterialButtonRectangle btn_lateReturnReport;
    private rojerusan.RSMaterialButtonRectangle btn_studentBorrowingReport;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    // End of variables declaration
}
