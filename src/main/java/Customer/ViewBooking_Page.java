/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Customer;

import Admin.*;
import Class_File.Booking_Class;
import Class_File.FILE_IO;
import Class_File.HallClass;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author siowa
 */


public class ViewBooking_Page extends javax.swing.JFrame {

    /**
     * Creates new form Profile_Page
     */
    private String customerID;
    public ViewBooking_Page(String customerID) throws Exception {
        this.customerID = customerID;
        initComponents();
        FILE_IO F = new FILE_IO();
        try {
                // Catch the exception thrown by getBookingsByCustomerID
                List<Booking_Class> bookings = F.getBookingsByCustomerID(customerID);
                System.out.println("Number of bookings found: " + bookings.size());

                DefaultTableModel model = (DefaultTableModel) Tbl_MyBooking.getModel();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                model.setRowCount(0);

                // 将每个 Hall 数据添加到表格中
                for (Booking_Class booking : bookings) {
                    Object[] rowData = {
                        booking.getBooking_ID(),
                        booking.getStartDateTime().format(formatter),
                        booking.getEndDateTime().format(formatter)
                    };
                    model.addRow(rowData);
                    System.out.println("Added booking: " + booking);
                }
            } catch (Exception ex) {
                // Log the exception
                Logger.getLogger(ViewBooking_Page.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("An error occurred: " + ex.getMessage());
            }
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tbl_MyBooking = new javax.swing.JTable();
        CB_Filter = new javax.swing.JComboBox<>();
        Txt_BID_ToDelete = new javax.swing.JTextField();
        Btn_Delete = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 500));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(1000, 500));
        jPanel2.setLayout(null);

        jPanel6.setBackground(new java.awt.Color(153, 153, 153));
        jPanel6.setMinimumSize(new java.awt.Dimension(200, 500));
        jPanel6.setName(""); // NOI18N
        jPanel6.setPreferredSize(new java.awt.Dimension(200, 500));

        jLabel3.setBackground(new java.awt.Color(51, 51, 51));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Dashboard");

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));

        jLabel14.setBackground(new java.awt.Color(153, 153, 153));
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("New Booking");
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(102, 102, 102));

        jLabel9.setBackground(new java.awt.Color(102, 102, 102));
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("My Booking");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 45, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(153, 153, 153));

        jLabel11.setBackground(new java.awt.Color(51, 51, 51));
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Feedback");
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 45, Short.MAX_VALUE)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(153, 153, 153));

        jLabel12.setBackground(new java.awt.Color(51, 51, 51));
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("My Profile");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 45, Short.MAX_VALUE)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(153, 153, 153));

        jLabel13.setBackground(new java.awt.Color(51, 51, 51));
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Log Out");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(0, 45, Short.MAX_VALUE)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel10)
                .addGap(4, 4, 4)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(263, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel6);
        jPanel6.setBounds(0, 0, 170, 470);

        jLabel1.setFont(new java.awt.Font("Segoe UI Emoji", 1, 36)); // NOI18N
        jLabel1.setText("Booking");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(420, 20, 150, 50);

        Tbl_MyBooking.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Booking ID", "Start Date Time", "End Date Time"
            }
        ));
        jScrollPane1.setViewportView(Tbl_MyBooking);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(210, 170, 550, 230);

        CB_Filter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Past", "Upcoming" }));
        CB_Filter.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CB_FilterItemStateChanged(evt);
            }
        });
        CB_Filter.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                CB_FilterPropertyChange(evt);
            }
        });
        jPanel2.add(CB_Filter);
        CB_Filter.setBounds(210, 110, 130, 22);

        Txt_BID_ToDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Txt_BID_ToDeleteActionPerformed(evt);
            }
        });
        jPanel2.add(Txt_BID_ToDelete);
        Txt_BID_ToDelete.setBounds(390, 110, 180, 22);

        Btn_Delete.setText("Cancel Booking");
        Btn_Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_DeleteActionPerformed(evt);
            }
        });
        jPanel2.add(Btn_Delete);
        Btn_Delete.setBounds(630, 110, 130, 23);

        jLabel2.setText("Booking ID to Cancel:");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(390, 90, 140, 16);

        jLabel4.setText("Filter Booking:");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(210, 90, 90, 16);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
  
        CustomerProfile_Page ProfileFrame = null;
        try {
            ProfileFrame = new CustomerProfile_Page(customerID);
        } catch (Exception ex) {
            Logger.getLogger(RaiseIssue_Page.class.getName()).log(Level.SEVERE, null, ex);
        }
        ProfileFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        NewBooking_Page_2 BookingFrame2 = null;
        try {
            BookingFrame2 = new NewBooking_Page_2(customerID);
        } catch (Exception ex) {
            Logger.getLogger(RaiseIssue_Page.class.getName()).log(Level.SEVERE, null, ex);
        }
        BookingFrame2.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel14MouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        RaiseIssue_Page RaiseIssueFrame = new RaiseIssue_Page(customerID);
        RaiseIssueFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel11MouseClicked

    private void Txt_BID_ToDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Txt_BID_ToDeleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Txt_BID_ToDeleteActionPerformed

    private void CB_FilterPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_CB_FilterPropertyChange

    }//GEN-LAST:event_CB_FilterPropertyChange

    private void CB_FilterItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CB_FilterItemStateChanged
        String CBox = (String) CB_Filter.getSelectedItem();
        FILE_IO F = new FILE_IO();
        
        if ("All".equals(CBox)) {  // 用 .equals() 比较字符串内容
            try {
                // Catch the exception thrown by getBookingsByCustomerID
                List<Booking_Class> bookings = F.getBookingsByCustomerID(customerID);
                System.out.println("Number of bookings found: " + bookings.size());

                DefaultTableModel model = (DefaultTableModel) Tbl_MyBooking.getModel();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                model.setRowCount(0);

                // 将每个 Hall 数据添加到表格中
                for (Booking_Class booking : bookings) {
                    Object[] rowData = {
                        booking.getBooking_ID(),
                        booking.getStartDateTime().format(formatter),
                        booking.getEndDateTime().format(formatter)
                    };
                    model.addRow(rowData);
                    System.out.println("Added booking: " + booking);
                }
            } catch (Exception ex) {
                // Log the exception
                Logger.getLogger(ViewBooking_Page.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("An error occurred: " + ex.getMessage());
            }
        }
        if ("Past".equals(CBox)){
            try {
                // Get current date and time
                LocalDateTime now = LocalDateTime.now();
                List<Booking_Class> bookings = F.getBookingsByCustomerID(customerID);

                List<Booking_Class> endedBookings = new ArrayList<>();

                DefaultTableModel model = (DefaultTableModel) Tbl_MyBooking.getModel();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                model.setRowCount(0);

                // Process each booking
                for (Booking_Class booking : bookings) {
                    // Compare the end date of the booking with the current date and time
                    if (booking.getEndDateTime().isBefore(now)) {endedBookings.add(booking);}
                }

                // Display ongoing bookings in the table
                for (Booking_Class booking : endedBookings) {
                    Object[] rowData = {
                        booking.getBooking_ID(),
                        booking.getStartDateTime().format(formatter),
                        booking.getEndDateTime().format(formatter)
                    };
                    model.addRow(rowData);
                }


            } catch (Exception ex) {
                // Log the exception
                Logger.getLogger(ViewBooking_Page.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("An error occurred: " + ex.getMessage());
            }

        }
        if ("Upcoming".equals(CBox)){
            try {
                // Get current date and time
                LocalDateTime now = LocalDateTime.now();

                List<Booking_Class> bookings = F.getBookingsByCustomerID(customerID);
                List<Booking_Class> ongoingBookings = new ArrayList<>();

                DefaultTableModel model = (DefaultTableModel) Tbl_MyBooking.getModel();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                model.setRowCount(0);

                // Process each booking
                for (Booking_Class booking : bookings) {
                    // Compare the end date of the booking with the current date and time
                    if (booking.getEndDateTime().isAfter(now)) {
                        ongoingBookings.add(booking);
                    }
                }
                // Display ongoing bookings in the table
                for (Booking_Class booking : ongoingBookings) {
                    Object[] rowData = {
                        booking.getBooking_ID(),
                        booking.getStartDateTime().format(formatter),
                        booking.getEndDateTime().format(formatter)
                    };
                    model.addRow(rowData);
                }

            } catch (Exception ex) {
                Logger.getLogger(ViewBooking_Page.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_CB_FilterItemStateChanged

    private void Btn_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_DeleteActionPerformed

        String BookingID = Txt_BID_ToDelete.getText();
        Booking_Class B = new Booking_Class();
        FILE_IO F = new FILE_IO();
        List<Booking_Class> bookings = null;
        try {
            bookings = F.getBookingsByCustomerID(customerID);
        } catch (Exception ex) {
            Logger.getLogger(ViewBooking_Page.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        boolean result = B.CheckBookingDelete(BookingID, bookings);
        
        if (result){
            try {
                F.deleteBookingByID(BookingID);
                JOptionPane.showMessageDialog(null, "Your Booking has been canceled, Please enjoy our service");
            } catch (IOException ex) {
                Logger.getLogger(ViewBooking_Page.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(ViewBooking_Page.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(null, "This order is less than three days from the start date and cannot be canceled");
        }
        
        
    }//GEN-LAST:event_Btn_DeleteActionPerformed

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
            java.util.logging.Logger.getLogger(NewBooking_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewBooking_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewBooking_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewBooking_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewBooking_Page().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Delete;
    private javax.swing.JComboBox<String> CB_Filter;
    private javax.swing.JTable Tbl_MyBooking;
    private javax.swing.JTextField Txt_BID_ToDelete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
