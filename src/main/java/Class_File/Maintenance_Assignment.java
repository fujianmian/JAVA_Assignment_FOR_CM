/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class_File;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author junyong is DaShuaiGe
 */
public class Maintenance_Assignment {
    private String AssignmentID;
    private HandleCustomerFeedback Issue;
    private HallClass Hall;
    private ManagerClass Manager;
    private SchedulerClass scheduler;
    private LocalDateTime AssignDateTime;
    private String Status;
    private String Remark;

    public Maintenance_Assignment(String AssignmentID, HandleCustomerFeedback feedback, HallClass Hall, ManagerClass Manager, SchedulerClass Scheduler, LocalDateTime AssignDateTime, String Status, String Remark) {
        this.AssignmentID = AssignmentID;
        this.Issue = feedback;
        this.Hall = Hall;
        this.Manager = Manager;
        this.scheduler = Scheduler;
        this.AssignDateTime = AssignDateTime;
        this.Status = Status;
        this.Remark = Remark;
    }

    public String getAssignmentID() {
        return AssignmentID;
    }

    public ManagerClass getManager() {
        return Manager;
    }

    public HandleCustomerFeedback getIssue() {
        return Issue;
    }

    public HallClass getHall() {
        return Hall;
    }

    public SchedulerClass getScheduler() {
        return scheduler;
    }

    public LocalDateTime getAssignDateTime() {
        return AssignDateTime;
    }

    public String getStatus() {
        return Status;
    }

    public String getRemark() {
        return Remark;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }
    
    public String assignmentToString(Maintenance_Assignment assignment) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String remark = (assignment.getRemark() != null) ? assignment.getRemark() : "";

        // Construct a CSV-like string for the assignment
        return String.join(",",
                assignment.getAssignmentID(),
                assignment.getIssue().getFeedback_ID(),
                assignment.getHall().getHall_ID(),
                assignment.getManager().getUserID(),
                assignment.getScheduler().getUserID(),
                assignment.getAssignDateTime().format(formatter),
                assignment.getStatus(),
                remark); // Ensure no missing fields
    }
    
    
}
