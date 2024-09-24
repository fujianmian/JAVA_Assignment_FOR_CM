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
public class SchedulerClass extends UserClass {
    
    String type = "S";

    public SchedulerClass(String UserID, String Name, String Email, String Password, String Type) {
        super(UserID, Name, Email, Password);
        this.type = Type;
    }


    @Override
    public void login(String SchedulerID) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    

    
}
