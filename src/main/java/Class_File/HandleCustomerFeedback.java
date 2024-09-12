/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class_File;

import java.time.LocalDateTime;

/**
 *
 * @author junyong is DaShuaiGe
 */
public class HandleCustomerFeedback implements HandleCusComment{
    private String Feedback_ID;
    private String Title;
    private CustomerClass IssueCustomer;
    private LocalDateTime FeedbackDateTime;
    private HallClass Issue_hall;
    private String Content;

    public HandleCustomerFeedback(String Feedback_ID, String Title, CustomerClass IssueCustomer, LocalDateTime FeedbackDateTime, HallClass Issue_hall, String Content) {
        this.Feedback_ID = Feedback_ID;
        this.Title = Title;
        this.IssueCustomer = IssueCustomer;
        this.FeedbackDateTime = FeedbackDateTime;
        this.Issue_hall = Issue_hall;
        this.Content = Content;
    }

    public HandleCustomerFeedback() {
    }
    
    

    public String getFeedback_ID() {
        return Feedback_ID;
    }
    
    
    
    public String handlecustomercomment(String ID, String Title, String CustID, String FeedbackDateTime, String HallID, String Content){
        
        String result = String.join(",", ID, Title, CustID, FeedbackDateTime, HallID, Content);
        return result;
    }
    
}
