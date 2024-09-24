/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class_File;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author junyong is DaShuaiGe
 */
public class SalesClass {
    private String PaymentID;
    private CustomerClass Customer;
    private Booking_Class Booking;
    private LocalDate Payment_Time;
    private double amount;
    private String Payment_Method;

    public SalesClass(String PaymentID, CustomerClass Customer, Booking_Class Booking, LocalDate Payment_Time, double amount, String Payment_Method) {
        this.PaymentID = PaymentID;
        this.Customer = Customer;
        this.Booking = Booking;
        this.Payment_Time = Payment_Time;
        this.amount = amount;
        this.Payment_Method = Payment_Method;
    }

    public LocalDate getPayment_Time() {
        return Payment_Time;
    }

    public double getAmount() {
        return amount;
    }

    public String getPaymentID() {
        return PaymentID;
    }
    
    
}
