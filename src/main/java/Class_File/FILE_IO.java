/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class_File;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 *
 * @author junyong is DaShuaiGe
 */
public class FILE_IO {
    
    
    //below it mehod to get arraylist from a text file
    public List<CustomerClass> getAllUsers() throws Exception {
        List<CustomerClass> users = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("Customer.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] userDetails = line.split(",");
                if (userDetails.length >= 5) {
                    users.add(new CustomerClass(userDetails[0], userDetails[1], userDetails[2], userDetails[3], userDetails[4]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new Exception("Error reading user data file.", e);
        }
        return users;
    }
    
    public List<HallClass> getAllHall() throws Exception {
        List<HallClass> halls = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("Hall.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] userDetails = line.split(",");
                if (userDetails.length >= 4) {
                    halls.add(new HallClass(userDetails[0], userDetails[1], Integer.parseInt(userDetails[2]), Integer.parseInt(userDetails[3])));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new Exception("Error reading user data file.", e);
        }
        return halls;
    }
    
    public List<Booking_Class> getAllBooking() throws Exception {
        List<Booking_Class> bookings = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("Booking.txt"))) { // Ensure file name is correct
            String line;
            while ((line = br.readLine()) != null) {
                String[] BookingDetails = line.split(",");
                if (BookingDetails.length >= 6) {

                    // Assuming you have a method to fetch the customer by ID
                    CustomerClass customer = CustomerClass.parse(BookingDetails[1]); // Fetch customer based on ID

                    // Assuming you have a method to fetch the hall by ID
                    HallClass hall = HallClass.parse(BookingDetails[4]); // Fetch hall based on ID

                    // Parse LocalDateTime from a string (make sure the format matches)
                    LocalDateTime startDateTime = LocalDateTime.parse(BookingDetails[2], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                    LocalDateTime endDateTime = LocalDateTime.parse(BookingDetails[3], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

                    String remark = (BookingDetails.length == 7) ? BookingDetails[6] : null;
                    
                    // Add booking to the list
                    bookings.add(new Booking_Class(
                        BookingDetails[0], // Booking ID
                        customer, // Customer object
                        startDateTime, // Start date and time
                        endDateTime, // End date and time
                        hall, // Hall object
                        Integer.parseInt(BookingDetails[5]), // Reservation people
                        remark // Booking remark
                    ));
                    
                    
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new Exception("Error reading booking data file.", e);
        }
        return bookings;
    }
    
    public List<HandleCustomerFeedback> getAllFeedback() throws Exception {
        List<HandleCustomerFeedback> feedbacks = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        try (BufferedReader br = new BufferedReader(new FileReader("Feedback.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] feedbackDetails = line.split(",");
                if (feedbackDetails.length >= 6) {
                    // Assuming CustomerClass and HallClass are already loaded or can be fetched
                    CustomerClass customer = getCustomerByID(feedbackDetails[2]); // Assuming you have a method to get CustomerClass by ID
                    HallClass hall = getHallByID(feedbackDetails[4]); // Assuming you have a method to get HallClass by ID

                    HandleCustomerFeedback feedback = new HandleCustomerFeedback(
                        feedbackDetails[0], // Feedback_ID
                        feedbackDetails[1], // Title
                        customer, // CustomerClass object
                        LocalDateTime.parse(feedbackDetails[3], formatter), // FeedbackDateTime
                        hall, // HallClass object
                        feedbackDetails[5]  // Content
                    );

                    feedbacks.add(feedback);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new Exception("Error reading feedback data file.", e);
        }
        return feedbacks;
    }
    
    
    public String getNextFeedbackID() throws Exception {
        List<HandleCustomerFeedback> feedbackdetails = getAllFeedback();
        
        // Regex pattern to match Booking IDs in the format BXXX
        Pattern pattern = Pattern.compile("F(\\d+)");
        int maxID = 0;
        
        for (HandleCustomerFeedback feedback : feedbackdetails) {
            String bookingID = feedback.getFeedback_ID();
            Matcher matcher = pattern.matcher(bookingID);
            if (matcher.matches()) {
                int id = Integer.parseInt(matcher.group(1));
                if (id > maxID) {
                    maxID = id;
                }
            }
        }
        
        // Increment the maximum ID found
        int newID = maxID + 1;
        
        // Format the new ID as BXXX
        return String.format("F%03d", newID);
    }
    
    public String getNextBookingID() throws Exception {
        List<Booking_Class> bookings = getAllBooking();
        
        // Regex pattern to match Booking IDs in the format BXXX
        Pattern pattern = Pattern.compile("B(\\d+)");
        int maxID = 0;
        
        for (Booking_Class booking : bookings) {
            String bookingID = booking.getBooking_ID(); // Assuming Booking_Class has a getBookingID method
            Matcher matcher = pattern.matcher(bookingID);
            if (matcher.matches()) {
                int id = Integer.parseInt(matcher.group(1));
                if (id > maxID) {
                    maxID = id;
                }
            }
        }
        
        // Increment the maximum ID found
        int newID = maxID + 1;
        
        // Format the new ID as BXXX
        return String.format("B%03d", newID);
    }
    
    public List<Booking_Class> getBookingsByCustomerID(String customerID) throws Exception {
        List<Booking_Class> allBookings = getAllBooking();
        List<Booking_Class> filteredBookings = new ArrayList<>();

        // Debugging statement
        System.out.println("Filtering bookings for customerID: " + customerID);

        for (Booking_Class booking : allBookings) {
            System.out.println("Checking booking: " + booking.getBooking_ID() + ", Customer ID: " + booking.getCustomer_ID());
            if (booking.getCustomer_IDString().equalsIgnoreCase(customerID.trim())) {
                filteredBookings.add(booking);
                System.out.println("Matched booking: " + booking.getBooking_ID());
            }
        }

        return filteredBookings;
    }
    
    public List<HallClass> SearchBooking(int peopleCount, LocalDateTime startdatetime, LocalDateTime enddatetime) throws Exception{
        FILE_IO F = new FILE_IO();
        List<Booking_Class> BookingDetails = F.getAllBooking();  // 从文件读取所有预定信息
        List<HallClass> HallsDetails = F.getAllHall();  // 从文件读取所有 Hall 信息
        List<HallClass> ReturnList = new ArrayList<>();

        // 遍历所有 Hall
        for (HallClass hall : HallsDetails) {
            String hallID = hall.getHall_ID();  // 获取当前 Hall 的 ID

            // 如果当前 Hall 的人数满足条件
            if (hall.getNo_People() >= peopleCount) {
                boolean isAvailable = true;  // 标志位，表示当前 Hall 是否可用

                // 遍历所有的 Booking
                for (Booking_Class booking : BookingDetails) {
                    System.out.println("Booking HallID: " + booking.getHall_1().getHall_ID() + " vs Current HallID: " + hallID);

                    // 如果 HallID 匹配，检查时间是否冲突
                    if (booking.getHall_1().getHall_ID().equals(hallID)) {
                        LocalDateTime existingStart = booking.getStartDateTime();
                        LocalDateTime existingEnd = booking.getEndDateTime();

                        // 输出调试信息，检查时间
                        System.out.println("Comparing times: " + startdatetime + " to " + existingEnd + " and " + enddatetime + " to " + existingStart);

                        // 如果时间有重叠，则该 Hall 不可用
                        if (startdatetime.isBefore(existingEnd) && enddatetime.isAfter(existingStart)) {
                            isAvailable = false;  // 设置为不可用
                            System.out.println("Time conflict detected!");
                            break;  // 跳出内层循环，不再检查该 Hall
                        }
                    }
                }

                // 如果当前 Hall 没有时间冲突且容量满足条件，添加到 ReturnList 列表
                if (isAvailable) {
                    ReturnList.add(hall);
                }
            }
        }

        // 返回所有可用的 Hall 列表
        return ReturnList;
    }
    
    
    //method to return object
    public CustomerClass getCustomerByID(String customerID) throws Exception {
        FILE_IO fileIO = new FILE_IO(); // Ensure FILE_IO is properly instantiated
        List<CustomerClass> customers = fileIO.getAllUsers(); // Ensure this method returns the correct list

        for (CustomerClass customer : customers) {
            if (customer.getUserID().equals(customerID)) {
                return customer; // Return the matching customer object
            }
        }

        // If no matching customer is found, you can throw an exception or return null
        throw new Exception("Customer with ID: " + customerID + " not found.");
    }
    
    public HallClass getHallByID(String customerID) throws Exception {
        FILE_IO fileIO = new FILE_IO(); // Ensure FILE_IO is properly instantiated
        List<HallClass> hallslist = fileIO.getAllHall(); // Ensure this method returns the correct list

        for (HallClass hall : hallslist) {
            if (hall.getHall_ID().equals(customerID)) {
                return hall; // Return the matching customer object
            }
        }

        // If no matching customer is found, you can throw an exception or return null
        throw new Exception("Customer with ID: " + customerID + " not found.");
    }
    
    
    
    //method to write data into file
    public void TOWriteFile(String filename, String data) throws IOException {
        // Use try-with-resources to ensure the BufferedWriter is closed properly
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            // Write the data followed by a new line
            writer.write(data);
            writer.newLine();
        }
    }
    
    
    public void createNewFile(String fileName, String content) {
        File file = new File(fileName);
        
        try {
            if (!file.exists()) {
                file.createNewFile();
            } 

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
                bw.write(content);
                bw.newLine();  // change line
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void deleteBookingByID(String BOOKID) throws IOException, Exception {
        // Read the file and filter out the booking to be deleted
        List<Booking_Class> bookings = getAllBooking(); // Read all bookings
        List<Booking_Class> bookingsthatdeleted = new ArrayList<>();;

        for (Booking_Class B : bookings) {
            System.out.println("Checking booking ID: " + B.getBooking_ID()); // Debugging line
            System.out.println("Comparing bookingID: [" + BOOKID + "] with Booking_ID: [" + B.getBooking_ID() + "]");

            
            if (B.getBooking_ID().trim().equalsIgnoreCase(BOOKID)) {
                System.out.println("Booking ID matched for deletion: " + BOOKID); // Debugging line
            } else {
                bookingsthatdeleted.add(B);
            }
        }

        // Rewrite the file without the deleted booking
        System.out.println("Number of bookings after deletion: " + bookingsthatdeleted.size()); // Debugging line

        // Rewrite the file without the deleted booking
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Booking.txt"))) {
            for (Booking_Class booking : bookingsthatdeleted) {
                writer.write(booking.toFileFormat());
                writer.newLine();
            }
        }
    }
    
}
