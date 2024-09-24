/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class_File;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author junyong is DaShuaiGe
 */
public abstract class UserClass extends JFrame{
    
    private String UserID;
    private String Name;
    private String Email;
    private String Password;

    public UserClass(String UserID, String Name, String Email, String Password) {
        this.UserID = UserID;
        this.Name = Name;
        this.Email = Email;
        this.Password = Password;
    }
    
    
//    public abstract void updateCustomerByID(String customerID, String newName, String newEmail, String newPassword) throws Exception;
    
    
    @Override
    public String toString(){
        return UserID;
    }
    
    public abstract void login(String UserID);

    public String getUserID() {
        return UserID;
    }

    public String getName() {
        return Name;
    }

    public String getEmail() {
        return Email;
    }

    public String getPassword() {
        return Password;
    }

    public void setUserID(String UserID) {
        this.UserID = UserID;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
    
    
}
