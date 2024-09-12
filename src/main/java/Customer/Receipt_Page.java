/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Customer;

import Class_File.Booking_Class;
import Class_File.CustomerClass;
import Class_File.FILE_IO;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author junyong is DaShuaiGe
 */

public class Receipt_Page extends javax.swing.JFrame {

    /**
     * Creates new form Payment_Page
     */
    
    private static String Data;
    public Receipt_Page(String data) throws Exception {
        Receipt_Page.Data = data;
        initComponents();
        
        
        
        
        String[] values = Receipt_Page.Data.split(",");
        
        Booking_Class B = new Booking_Class();
        
        
        String remark = (values.length == 7) ? values[7] : "";
        
        String bookingID = values[0];
        LocalDateTime startDateTime = LocalDateTime.parse(values[2], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        LocalDateTime endDateTime = LocalDateTime.parse(values[3], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String hallID = values[4];
        String cost = Double.toString(B.calculateBookingCost(bookingID, startDateTime, endDateTime, hallID));
        
        LbL_DispBookingID.setText(values[0]);
        Lbl_DispCusID.setText(values[1]);
        Lbl_DispStartDateTime.setText(values[2]);
        Lbl_DispEndDateTime.setText(values[3]);
        Lbl_DispHallID.setText(values[4]);
        Lbl_DispPrice.setText(cost);
        Lbl_DispRemark.setText(remark);
        
        FILE_IO F = new FILE_IO();
        try {
                F.TOWriteFile("Booking.txt", data);
            } catch (IOException ex) {
                Logger.getLogger(NewBooking_Page_2.class.getName()).log(Level.SEVERE, null, ex);
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

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        Btn_Back = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        Lbl_DispEndDateTime = new javax.swing.JLabel();
        Lbl_DispPrice = new javax.swing.JLabel();
        Lbl_DispHallID = new javax.swing.JLabel();
        LbL_DispBookingID = new javax.swing.JLabel();
        Lbl_DispRemark = new javax.swing.JLabel();
        Lbl_DispCusID = new javax.swing.JLabel();
        Lbl_DispStartDateTime = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI Emoji", 1, 36)); // NOI18N
        jLabel2.setText("Receipt");

        jLabel1.setText("Booking ID:");

        Btn_Back.setText("Back");
        Btn_Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_BackActionPerformed(evt);
            }
        });

        jLabel4.setText("Customer ID:");

        jLabel5.setText("Start Date Time:");

        jLabel6.setText("End Date Time:");

        jLabel7.setText("Price (Price): ");

        jLabel8.setText("Hall ID:");

        jLabel9.setText("Remark");

        Lbl_DispEndDateTime.setText("                        ");

        Lbl_DispPrice.setText("                          ");

        Lbl_DispHallID.setText("                             ");

        LbL_DispBookingID.setText("                       ");

        Lbl_DispRemark.setText("                           ");

        Lbl_DispCusID.setText("                         ");

        Lbl_DispStartDateTime.setText("                       ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Btn_Back, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Lbl_DispCusID)
                            .addComponent(LbL_DispBookingID)
                            .addComponent(Lbl_DispStartDateTime)
                            .addComponent(Lbl_DispEndDateTime)
                            .addComponent(Lbl_DispPrice)
                            .addComponent(Lbl_DispHallID)
                            .addComponent(Lbl_DispRemark))))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LbL_DispBookingID)
                        .addGap(18, 18, 18)
                        .addComponent(Lbl_DispCusID)
                        .addGap(18, 18, 18)
                        .addComponent(Lbl_DispStartDateTime)
                        .addGap(18, 18, 18)
                        .addComponent(Lbl_DispEndDateTime)
                        .addGap(18, 18, 18)
                        .addComponent(Lbl_DispHallID)
                        .addGap(18, 18, 18)
                        .addComponent(Lbl_DispPrice)
                        .addGap(18, 18, 18)
                        .addComponent(Lbl_DispRemark)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                .addComponent(Btn_Back, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_BackActionPerformed
        System.out.println(Receipt_Page.Data);
        
        try {
            NewBooking_Page_2 Frame = new NewBooking_Page_2(Receipt_Page.Data);
            Frame.setVisible(true);
            this.dispose();
        } catch (Exception ex) {
            Logger.getLogger(NewBooking_Page_2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Btn_BackActionPerformed

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
            java.util.logging.Logger.getLogger(Payment_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Payment_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Payment_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Payment_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                String data = Receipt_Page.Data;
                try {
                    new Receipt_Page(data).setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(Receipt_Page.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Back;
    private javax.swing.JLabel LbL_DispBookingID;
    private javax.swing.JLabel Lbl_DispCusID;
    private javax.swing.JLabel Lbl_DispEndDateTime;
    private javax.swing.JLabel Lbl_DispHallID;
    private javax.swing.JLabel Lbl_DispPrice;
    private javax.swing.JLabel Lbl_DispRemark;
    private javax.swing.JLabel Lbl_DispStartDateTime;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
