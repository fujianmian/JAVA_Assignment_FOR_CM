/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.java_assignemt_1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author junyong is DaShuaiGe
 */
public class CustomerClass {
    
    private String UserID;
    private String Name;
    private String Email;
    private String Password;
    
    
    public boolean FindSpecificCus(String UID, String Pass) throws Exception{
        FileReader fr_findUser = new FileReader (
            "C:\\Users\\junyong is DaShuaiGe\\Desktop\\CustomerUser.txt");
        BufferedReader br = new BufferedReader(fr_findUser);
        
        String line;
        while ((line = br.readLine()) != null) {
            String[] userDetails = line.split(" ");

            // userDetails[0] = ID, userDetails[1] = Name, userDetails[2] = Email, userDetails[3] = Password
            if (userDetails[0].equals(UID) && userDetails[3].equals(Pass)) {
                br.close();
                return true; 
            }
        }

        br.close();
        return false;
    }
}
