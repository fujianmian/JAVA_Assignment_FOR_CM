/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Customer;

import Class_File.Booking_Class;
import Class_File.CustomerClass;
import Class_File.FILE_IO;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author junyong is DaShuaiGe
 */
public class Payment_Page extends javax.swing.JFrame {

    /**
     * Creates new form Payment_Page
     */
    
    private static String Data;
    
    
    public Payment_Page(String data) throws Exception {
        initComponents();
        Payment_Page.Data = data;
        System.out.println(Payment_Page.Data);
        
        String[] values = Payment_Page.Data.split(",");
        if (values.length < 1) {
            throw new IllegalArgumentException("Data format is incorrect.");
        }
        String bookingID = values[0];
        LocalDateTime startDateTime = LocalDateTime.parse(values[2], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        LocalDateTime endDateTime = LocalDateTime.parse(values[3], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String hallID = values[4];

        // Calculate the booking cost
        Booking_Class B = new Booking_Class();
        double cost = B.calculateBookingCost(bookingID, startDateTime, endDateTime, hallID);
        Lbl_DispPrice.setText(Double.toString(cost));
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
        Txt_CreditNo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        Btn_CreditCard = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        Btn_Cash = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        Lbl_DispPrice = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI Emoji", 1, 36)); // NOI18N
        jLabel2.setText("Payment");

        jLabel1.setText("Credit Card No.");

        Btn_CreditCard.setText("Credit Card");
        Btn_CreditCard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_CreditCardActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Pay by:");

        Btn_Cash.setText("Cash");
        Btn_Cash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_CashActionPerformed(evt);
            }
        });

        jLabel4.setText("Total Price: ");

        Lbl_DispPrice.setText("                                        ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(Btn_Cash, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Btn_CreditCard, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(Lbl_DispPrice, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(85, 85, 85)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel1)
                            .addComponent(Txt_CreditNo, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Lbl_DispPrice)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Txt_CreditNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Btn_CreditCard, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btn_Cash, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(80, 80, 80))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_CashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_CashActionPerformed
    try {
        CustomerClass C = new CustomerClass();
        boolean paid = C.makepayment();

        if(paid){
            Receipt_Page ReceiptFrame = new Receipt_Page(Payment_Page.Data);
            ReceiptFrame.setVisible(true);
            this.dispose();
        }
    } catch (Exception e) {
        e.printStackTrace();
        javax.swing.JOptionPane.showMessageDialog(this, "An error occurred: " + e.getMessage());
    }
    
    }//GEN-LAST:event_Btn_CashActionPerformed

    private void Btn_CreditCardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_CreditCardActionPerformed
    try {
        CustomerClass C = new CustomerClass();
        boolean paid = C.makepayment(Txt_CreditNo.getText());

        if(paid){
            Receipt_Page ReceiptFrame = new Receipt_Page(Payment_Page.Data);
            ReceiptFrame.setVisible(true);
            this.dispose();
        }
    } catch (Exception e) {
        e.printStackTrace();
        javax.swing.JOptionPane.showMessageDialog(this, "An error occurred: " + e.getMessage());
    }
    
    }//GEN-LAST:event_Btn_CreditCardActionPerformed

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
                String data = Payment_Page.Data;
                try {
                    new Payment_Page(data).setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(Payment_Page.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Cash;
    private javax.swing.JButton Btn_CreditCard;
    private javax.swing.JLabel Lbl_DispPrice;
    private javax.swing.JTextField Txt_CreditNo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
