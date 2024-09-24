/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class_File;

import Manager.ManagerMainPage;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author junyong is DaShuaiGe
 */
public class ManagerClass extends UserClass {
    
    String type = "M";

    public ManagerClass(String UserID, String Name, String Email, String Password, String Type) {
        super(UserID, Name, Email, Password);
        this.type = Type;
    }
    


    @Override
    public void login(String ManagerID) {
        ManagerMainPage BookingFrame2 = new ManagerMainPage(ManagerID);
        BookingFrame2.setVisible(true);
        this.dispose();
    }
    
    public void AssignScheduler(String ASID, String IID, String HID, String MID, String SID, String AS_Status, String remark) throws IOException, Exception{   

        LocalDateTime now = LocalDateTime.now();
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter_datetime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter formatter_date = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // 将日期格式化为字符串
        String todayString = today.format(formatter_date);
        String formattedDateTime = now.format(formatter_datetime);

        String AssignData_1 = String.join(",", 
                ASID, //assignment id
                IID,  //Issue id
                HID,  //Hall Id
                MID,  //Manager Id
                SID,  //Sheduler Id
                formattedDateTime,
                AS_Status,
                remark);
        String AssignData_2 = String.join(",", 
                HID,  //Hall Id
                SID,  //Sheduler Id
                MID,  //Manager Id
                todayString);

        System.out.println(AssignData_1);
        FILE_IO F = new FILE_IO();
        F.TOWriteFile("SchedulerAssignment.txt", AssignData_1);
        F.TOWriteFile("HallMaintenance.txt", AssignData_2);
        F.deleteIssueByID(IID);
    }
    
    public static void updateAssignmentStatus(String assignmentID, String newStatus) throws Exception {
        FILE_IO F = new FILE_IO();
        List<Maintenance_Assignment> assignments = F.getAllIAssignment(); // Read all assignments from the file
        boolean assignmentFound = false;

        // Loop through the list to find the assignment with the matching ID
        for (Maintenance_Assignment assignment : assignments) {
            if (assignment.getAssignmentID().equals(assignmentID)) {
                assignment.setStatus(newStatus);  // Update the status
                assignmentFound = true;
                break;  // Exit the loop once the assignment is found
            }
        }

        if (!assignmentFound) {
            throw new Exception("Assignment with ID: " + assignmentID + " not found.");
        }
        
        List<String> assignmentStrings = new ArrayList<>();
        for (Maintenance_Assignment assignment : assignments) {
            assignmentStrings.add(assignment.assignmentToString(assignment)); // Convert each assignment to a string
        }

        // Write back the updated assignments to the file
        F.TOWriteFile("SchedulerAssignment.txt",assignmentStrings);
    }
    
}
