/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class_File;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author junyong is DaShuaiGe
 */
public class Booking_Class {
    private String Booking_ID;
    private CustomerClass Customer_ID;
    private LocalDateTime StartDateTime;
    private LocalDateTime EndDateTime;
    private int Reservation_people;
    private String Booking_Remark;
    private HallClass Hall_1;

    public Booking_Class(String Booking_ID, CustomerClass Customer_ID, LocalDateTime StartDateTime, LocalDateTime EndDateTime, HallClass Hall_1, int Reservation_people, String Booking_Remark) {
        this.Booking_ID = Booking_ID;
        this.Customer_ID = Customer_ID;
        this.StartDateTime = StartDateTime;
        this.EndDateTime = EndDateTime;
        this.Reservation_people = Reservation_people;
        this.Booking_Remark = Booking_Remark;
        this.Hall_1 = Hall_1;
    }

    public Booking_Class() {
    }
    
    public boolean CheckBooking(String HallID, LocalDateTime startdatetime, LocalDateTime enddatetime) throws Exception{
        FILE_IO F = new FILE_IO();
        List<Booking_Class> BookingDetails = F.getAllBooking();
        List<HallClass> HallsDetails = F.getAllHall();
        boolean found = true;
        
        for (Booking_Class Booking : BookingDetails) {
            if (Booking.getHall_1().getHall_ID().equals(HallID)) {
                // Check for overlap in booking times
                LocalDateTime existingStart = Booking.getStartDateTime();
                LocalDateTime existingEnd = Booking.getEndDateTime();
                
                System.out.println("If you see this, then it go well");

                // Overlap condition: (new start < existing end) and (new end > existing start)
                if (startdatetime.isBefore(existingEnd) && enddatetime.isAfter(existingStart)) {
                    found = false;
                    // This Hall is not available during that time, cannot book
                }
             

            }
        }   
        return found;
    }
    public boolean checkBookingByCustomer(String customerID, String bookingID) throws Exception {
        // Retrieve all bookings for the given customer ID
        FILE_IO F = new FILE_IO();
        List<Booking_Class> customerBookings = F.getBookingsByCustomerID(customerID);

        // Debugging statement
        System.out.println("Checking for bookingID: " + bookingID + " in customerID: " + customerID + "'s bookings.");

        // Loop through the customer's bookings to find a match
        for (Booking_Class booking : customerBookings) {
            System.out.println("Checking booking: " + booking.getBooking_ID());
            if (booking.getBooking_ID().equalsIgnoreCase(bookingID.trim())) {
                System.out.println("Booking found: " + bookingID);
                return true; // Booking found, return true
            }
        }

        // No match found
        System.out.println("Booking not found: " + bookingID);
        return false; // Booking not found, return false
    }
    
    public boolean CheckBookingDelete(String bookingID, List<Booking_Class> bookings) {
        // Get current date and time
        LocalDateTime now = LocalDateTime.now();
        
        for (Booking_Class booking : bookings) {
            if (booking.getBooking_ID().equals(bookingID)) {
                LocalDateTime startDateTime = booking.getStartDateTime();
                long daysUntilStart = ChronoUnit.DAYS.between(now, startDateTime);
                
                return daysUntilStart >= 3;
            }
        }
        
        // Return false if the booking ID is not found in the list
        return false;
    }
    
    public String getHallIDByBookingID(String bookingID) throws Exception {
        // Retrieve all bookings
        FILE_IO F = new FILE_IO();
        List<Booking_Class> allBookings = F.getAllBooking();

        // Debugging statement
        System.out.println("Searching for bookingID: " + bookingID);

        // Loop through the bookings to find the matching bookingID
        for (Booking_Class booking : allBookings) {
            System.out.println("Checking booking: " + booking.getBooking_ID());
            if (booking.getBooking_ID().equalsIgnoreCase(bookingID.trim())) {
                System.out.println("Booking found. Hall ID: " + booking.getHall_1().getHall_ID());
                return booking.getHall_1().getHall_ID(); // Return the hall ID
            }
        }

        // If no matching booking is found
        throw new Exception("Booking ID " + bookingID + " not found.");
    }
    
    public double calculateBookingCost(String bookingID, LocalDateTime startDateTime, LocalDateTime endDateTime, String hallID) throws Exception {
        FILE_IO F = new FILE_IO();
        List<Booking_Class> bookings = F.getAllBooking();
        List<HallClass> halls = F.getAllHall();

//        Booking_Class selectedBooking = null;
        HallClass selectedHall = null;

        // Debugging: Print all bookings and halls

        System.out.println("Available halls:");
        for (HallClass hall : halls) {
            System.out.println("Hall ID: " + hall.getHall_ID());
        }


        // Find the hall by ID
        for (HallClass hall : halls) {
            if (hall.getHall_ID().equals(hallID)) {
                selectedHall = hall;
                break;
            }
        }

        if (selectedHall == null) {
            throw new Exception("Hall not found.");
        }

        // Calculate the duration of the booking in hours
        Duration duration = Duration.between(startDateTime, endDateTime);
        long hours = duration.toHours();

        // Debugging: Print selected booking and hall
//        System.out.println("Selected Booking ID: " + selectedBooking.getBooking_ID());
        System.out.println("Selected Hall ID: " + selectedHall.getHall_ID());
        System.out.println("Selected Hall Price: " + selectedHall.getPrice());
        System.out.println("Booking duration in hours: " + hours);

        // Calculate the cost
        double cost = hours * selectedHall.getPrice();

        return cost;
    }


    
    public String toFileFormat() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return String.join(",",
            Booking_ID,
            Customer_ID.getUserID(), // Assuming getUID() returns the customer ID
            StartDateTime.format(formatter),
            EndDateTime.format(formatter),
            Hall_1.getHall_ID(), // Assuming getHallID() returns the hall ID
            String.valueOf(Reservation_people),
            Booking_Remark != null ? Booking_Remark : ""
        );
    }

    public String getBooking_ID() {
        return Booking_ID;
    }

    public CustomerClass getCustomer_ID() {
        return Customer_ID;
    }
    
    public String getCustomer_IDString() {
        return Customer_ID.getUserID();
    }

    public LocalDateTime getStartDateTime() {
        return StartDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return EndDateTime;
    }

    public int getReservation_people() {
        return Reservation_people;
    }

    public String getBooking_Remark() {
        return Booking_Remark;
    }

    public HallClass getHall_1() {
        return Hall_1;
    }

    public void setBooking_ID(String Booking_ID) {
        this.Booking_ID = Booking_ID;
    }

    public void setCustomer_ID(CustomerClass Customer_ID) {
        this.Customer_ID = Customer_ID;
    }

    public void setStartDateTime(LocalDateTime StartDateTime) {
        this.StartDateTime = StartDateTime;
    }

    public void setEndDateTime(LocalDateTime EndDateTime) {
        this.EndDateTime = EndDateTime;
    }

    public void setReservation_people(int Reservation_people) {
        this.Reservation_people = Reservation_people;
    }

    public void setBooking_Remark(String Booking_Remark) {
        this.Booking_Remark = Booking_Remark;
    }

    public void setHall_1(HallClass Hall_1) {
        this.Hall_1 = Hall_1;
    }
    
    
    
    
}
