/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class_File;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedWriter;
import java.time.LocalDate;
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
    
    //for login use
    public boolean validateCredentials(String inputUserID, String inputPassword) throws IOException {
        String fileName = "Staff.txt"; // Replace with the actual file path

        // Open the file for reading
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            // Loop through each line in the file
            while ((line = br.readLine()) != null) {
                // Split the line into fields (assuming comma-separated)
                String[] userDetails = line.split(",");
                if (userDetails.length >= 4) {
                    String fileUserID = userDetails[0];    // First field is UserID
                    String filePassword = userDetails[3];  // Fourth field is Password
                    
                    // Check if UserID and Password match
                    if (fileUserID.equals(inputUserID) && filePassword.equals(inputPassword)) {
                        return true; // Return true if a match is found
                    }
                }
            }
        } catch (IOException e) {
            throw new IOException("Error reading file", e);
        }
        return false; // Return false if no match is found
    }
    //below it mehod to get arraylist from a text file
    public List<String[]> readDataFromFile() throws IOException {
        List<String[]> data = new ArrayList<>();
        System.out.println("here");
        try (BufferedReader br = new BufferedReader(new FileReader("HallMaintenance.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Split the line into an array of strings
                String[] rowData = line.split(",");
                if(rowData.length > 5){
                    data.add(rowData);
                }
                
            }
        }
        return data;
    }
    
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
    
    public List<ManagerClass> getAllManager() throws Exception {
        List<ManagerClass> managers = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("Staff.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] managerDetails = line.split(",");
                if (managerDetails.length >= 5 && managerDetails[0].startsWith("M")) {
                    managers.add(new ManagerClass(managerDetails[0], managerDetails[1], managerDetails[2], managerDetails[3], managerDetails[4]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new Exception("Error reading user data file.", e);
        }
        return managers;
    }
    
        public List<SchedulerClass> getAllScheduler() throws Exception {
        List<SchedulerClass> schedulers = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("Staff.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] SchedulerDetails = line.split(",");
                if (SchedulerDetails.length >= 5 && SchedulerDetails[0].startsWith("S")) {
                    schedulers.add(new SchedulerClass(SchedulerDetails[0], SchedulerDetails[1], SchedulerDetails[2], SchedulerDetails[3], SchedulerDetails[4]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new Exception("Error reading user data file.", e);
        }
        return schedulers;
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
    
    public List<SalesClass> getAllSales() throws Exception {
        List<SalesClass> sales = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("Sales.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] SalesDetails = line.split(",");
                if (SalesDetails.length >= 6) {
//                    System.out.println("Are we here");
                    sales.add(new SalesClass(
                        SalesDetails[0],
                        getCustomerByID(SalesDetails[1]),
                        getBookingByID(SalesDetails[2]),
                        LocalDate.parse(SalesDetails[3]),
                        Double.parseDouble(SalesDetails[4]),
                        SalesDetails[5] 
                    ));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new Exception("Error reading sales data file.", e);
        }
        return sales;
    }
    
    public List<HandleCustomerFeedback> getAllFeedback() throws Exception {
        List<HandleCustomerFeedback> feedbacks = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        try (BufferedReader br = new BufferedReader(new FileReader("Feedback.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] feedbackDetails = line.split(",");
                if (feedbackDetails.length >= 6 && feedbackDetails[0].startsWith("F")) {
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
    public List<HandleCustomerFeedback> getAllIssue() throws Exception {
        List<HandleCustomerFeedback> Issues = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        try (BufferedReader br = new BufferedReader(new FileReader("Feedback.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] issuesDetails = line.split(",");
                if (issuesDetails.length >= 6 && issuesDetails[0].startsWith("I")) {
                    // Assuming CustomerClass and HallClass are already loaded or can be fetched
                    CustomerClass customer = getCustomerByID(issuesDetails[2]); // Assuming you have a method to get CustomerClass by ID
                    HallClass hall = getHallByID(issuesDetails[4]); // Assuming you have a method to get HallClass by ID
                    HandleCustomerFeedback Issue = new HandleCustomerFeedback(
                        issuesDetails[0], // Feedback_ID
                        issuesDetails[1], // Title
                        customer, // CustomerClass object
                        LocalDateTime.parse(issuesDetails[3], formatter), // FeedbackDateTime
                        hall, // HallClass object
                        issuesDetails[5]  // Content
                    );

                    Issues.add(Issue);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new Exception("Error reading feedback data file.", e);
        }
        return Issues;
    }
    public List<Maintenance_Assignment> getAllIAssignment() throws Exception {
        List<Maintenance_Assignment> Assignments = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        try (BufferedReader br = new BufferedReader(new FileReader("SchedulerAssignment.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] AssignmentDetails = line.split(",");
                if (AssignmentDetails.length >= 7) {
                    // Assuming CustomerClass and HallClass are already loaded or can be fetched
                    
                    ManagerClass manager = getManagerByID(AssignmentDetails[3]);
                    SchedulerClass scheduler = getSchedulerByID(AssignmentDetails[4]);
                    HandleCustomerFeedback Issue = new HandleCustomerFeedback(AssignmentDetails[1],null,null,null,null,null);
                    String remark = (AssignmentDetails.length == 8) ? AssignmentDetails[7] : null;
                    HallClass Hall = getHallByID(AssignmentDetails[2]);
                    
                    Maintenance_Assignment Assignment = new Maintenance_Assignment(
                        AssignmentDetails[0], // Feedback_ID
                        Issue, // Issue
                        Hall, // Hall in class
                        manager,
                        scheduler,    
                        LocalDateTime.parse(AssignmentDetails[5], formatter), // FeedbackDateTime
                        AssignmentDetails[6], // HallClass object
                        remark  // Content
                    );

                    Assignments.add(Assignment);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new Exception("Error reading feedback data file.", e);
        }
        return Assignments;
    }
    
    
    public String getNextFeedbackID() throws Exception {
        List<HandleCustomerFeedback> feedbackdetails = getAllFeedback();
        
        if (feedbackdetails.isEmpty()) {
            System.out.println("No Feedback found.");
            return "F001"; // Or handle this case as needed
        }
        
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
    
    public String getNextIssueID() throws Exception {
        List<HandleCustomerFeedback> feedbackdetails = getAllIssue();
        
        if (feedbackdetails.isEmpty()) {
            System.out.println("No Feedback found.");
            return "I001"; // Or handle this case as needed
        }
        
        // Regex pattern to match Booking IDs in the format BXXX
        Pattern pattern = Pattern.compile("I(\\d+)");
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
        return String.format("I%03d", newID);
    }
    
    public String getNextAssignmentID() throws Exception {
        List<Maintenance_Assignment> Assignmentdetails = getAllIAssignment();
        
        if (Assignmentdetails.isEmpty()) {
            System.out.println("No assignments found.");
            return "AS001"; // Or handle this case as needed
        }
        
        // Regex pattern to match Booking IDs in the format BXXX
        Pattern pattern = Pattern.compile("AS(\\d+)");
        int maxID = 0;
        
        for (Maintenance_Assignment Assignment : Assignmentdetails) {
            String AssignmentID = Assignment.getAssignmentID();
            Matcher matcher = pattern.matcher(AssignmentID);
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
        return String.format("AS%03d", newID);
    }
    
    public String getNextPaymentID() throws Exception {
        List<SalesClass> Payments = getAllSales();
        
        System.out.println("Payments size: " + Payments.size());
        for (SalesClass Payment : Payments) {
            System.out.println("Found Payment ID: " + Payment.getPaymentID());
        }
        
        if (Payments.isEmpty()) {
            System.out.println("No Payment found.");
            return "P001"; // Or handle this case as needed
        }
        
        // Regex pattern to match Booking IDs in the format BXXX
        Pattern pattern = Pattern.compile("P(\\d+)");
        int maxID = 0;
        
        for (SalesClass Payment : Payments) {
            String PaymentID = Payment.getPaymentID();
            Matcher matcher = pattern.matcher(PaymentID);
            if (matcher.matches()) {
                int id = Integer.parseInt(matcher.group(1));
                if (id > maxID) {
                    maxID = id;
                }else {
                    System.out.println("Failed to match Payment ID: " + PaymentID);
                }
            }
        }
        int newID = maxID + 1;
        
        return String.format("P%03d", newID);
    }
    
    public String getNextBookingID() throws Exception {
        List<Booking_Class> bookings = getAllBooking();
        
        if (bookings.isEmpty()) {
            System.out.println("No Booking found.");
            return "B001"; // Or handle this case as needed
        }
        
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
    
     public Booking_Class getBookingByID(String bookingID) throws Exception {
        FILE_IO fileIO = new FILE_IO(); // Ensure FILE_IO is properly instantiated
        List<Booking_Class> Bookings = fileIO.getAllBooking(); // Ensure this method returns the correct list

        for (Booking_Class Booking : Bookings) {
            if (Booking.getBooking_ID().equals(bookingID)) {
                return Booking; // Return the matching customer object
            }
        }

        // If no matching customer is found, you can throw an exception or return null
        throw new Exception("Booking with ID: " + bookingID + " not found.");
    }
     
    public ManagerClass getManagerByID(String managerID) throws Exception {
        FILE_IO fileIO = new FILE_IO(); // Ensure FILE_IO is properly instantiated
        List<ManagerClass> Managers = fileIO.getAllManager(); // Ensure this method returns the correct list

        for (ManagerClass manager : Managers) {
            if (manager.getUserID().equals(managerID)) {
                return manager; // Return the matching customer object
            }
        }

        // If no matching customer is found, you can throw an exception or return null
        throw new Exception("Manager with ID: " + managerID + " not found.");
    }
    public SchedulerClass getSchedulerByID(String managerID) throws Exception {
        FILE_IO fileIO = new FILE_IO(); // Ensure FILE_IO is properly instantiated
        List<SchedulerClass> Schedulers = fileIO.getAllScheduler(); // Ensure this method returns the correct list

        for (SchedulerClass Scheduler : Schedulers) {
            if (Scheduler.getUserID().equals(managerID)) {
                return Scheduler; // Return the matching customer object
            }
        }

        // If no matching customer is found, you can throw an exception or return null
        throw new Exception("Manager with ID: " + managerID + " not found.");
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
        throw new Exception("Hall with ID: " + customerID + " not found.");
    }
    
    public HandleCustomerFeedback getIssueByID(String IssueID) throws Exception {
        FILE_IO fileIO = new FILE_IO(); // Ensure FILE_IO is properly instantiated
        List<HandleCustomerFeedback> Issuelist = fileIO.getAllIssue(); // Ensure this method returns the correct list

        for (HandleCustomerFeedback Issue : Issuelist) {
            if (Issue.getFeedback_ID().equals(IssueID)) {
                return Issue; // Return the matching customer object
            }
        }

        // If no matching customer is found, you can throw an exception or return null
        throw new Exception("here?: " + IssueID + " not found.");
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
    //overload it
    public void TOWriteFile(String fileName, List<String> lines) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
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
    
    public void deleteIssueByID(String issueID) throws IOException, Exception {
        // Read all issues from the file
        List<HandleCustomerFeedback> issues = getAllIssue();
        List<HandleCustomerFeedback> Feedbacks = getAllFeedback();
        List<HandleCustomerFeedback> issuesToKeep = new ArrayList<>();

        for (HandleCustomerFeedback issue : issues) {
            // Assuming getIssueID() is the method to get the issue ID
            if (!issue.getFeedback_ID().trim().equalsIgnoreCase(issueID)) {
                issuesToKeep.add(issue); // Keep if it doesn't match
            } else {
                System.out.println("Issue ID matched for deletion: " + issueID); // Debugging line
            }
        }

        // Rewrite the file without the deleted issue
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Feedback.txt"))) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            for (HandleCustomerFeedback issue : issuesToKeep) {
                // Manually format the issue data for writing to the file
                writer.write(issue.getFeedback_ID() + "," + issue.getTitle() + "," + 
                             issue.getIssueCustomer().getUserID() + "," + issue.getFeedbackDateTime().format(formatter) + "," + 
                             issue.getIssue_hall().getHall_ID() + "," + issue.getContent()); // Adjust as needed
                writer.newLine();
            }
            for (HandleCustomerFeedback Feeback : Feedbacks) {
                // Manually format the issue data for writing to the file
                writer.write(Feeback.getFeedback_ID() + "," + Feeback.getTitle() + "," + 
                             Feeback.getIssueCustomer().getUserID() + "," + Feeback.getFeedbackDateTime().format(formatter) + "," + 
                             Feeback.getIssue_hall().getHall_ID() + "," + Feeback.getContent()); // Adjust as needed
                writer.newLine();
            }
        }

        System.out.println("Number of issues after deletion: " + issuesToKeep.size()); // Debugging line
    }
    
    

    
}
