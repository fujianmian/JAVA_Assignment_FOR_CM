package Class_File;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author junyong is DaShuaiGe
 */
public class CustomerClass extends UserClass implements Payment_Inheritant{
    
    String type = "C";

    public CustomerClass(String UID, String Name, String Email, String Pass, String Type) {
        
        super(UID, Name, Email, Pass);
        this.type = Type;
    }

    public CustomerClass() {
        super("", "", "", ""); // Initialize base class with default values
        this.type = "C"; // Default type value
    }
    
    

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    @Override
    public void updateCustomerByID(String customerID, String newName, String newEmail, String newPassword) throws Exception {
        // Step 1: Read all customers from the file
        FILE_IO F = new FILE_IO();
        List<CustomerClass> users = F.getAllUsers();

        boolean customerFound = false;

        // Step 2: Loop through the list to find the customer by ID
        for (CustomerClass user : users) {
            if (user.getUserID().equals(customerID)) {
                // Step 3: Update the user's details
                user.setName(newName);
                user.setEmail(newEmail);
                user.setPassword(newPassword);
                customerFound = true;
                break;  // Exit the loop once the customer is found
            }
        }

        if (!customerFound) {
            throw new Exception("Customer with ID " + customerID + " not found.");
        }

        // Step 4: Write the updated list back to the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Customer.txt", false))) {  // 'false' to overwrite the file
            for (CustomerClass user : users) {
                // Recreate the data string for each customer
                String data = String.join(",", user.getUserID(), user.getName(), user.getEmail(), user.getPassword(), "C");
                writer.write(data);
                writer.newLine();
            }
        }
    }
    
    
    
    public boolean FindSpecificCus(String UID, String Pass) throws Exception {
        FILE_IO fileIO = new FILE_IO(); // Create an instance of FILE_IO
        List<CustomerClass> users = fileIO.getAllUsers();
        for (CustomerClass user : users) {
            if (user.getUserID().equals(UID) && user.getPassword().equals(Pass)) {
                return true;
            }
        }

        return false;
    }
    
    public String getUserTYPE(String userID) throws Exception {
        List<CustomerClass> users = new ArrayList<>();
        String userType = null;
        try (BufferedReader br = new BufferedReader(new FileReader("Customer.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] userDetails = line.split(",");
                if (userDetails.length >= 5 && userDetails[0].equals(userID)) {
                    userType = userDetails[4]; // Return the userType
                    break; // Exit the loop once the userID is found
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new Exception("Error reading user data file.", e);
        }
        return userType;
    }


    //for parse purpose
    public static CustomerClass parse(String customerID) throws Exception {
        FILE_IO fileIO = new FILE_IO(); // Assuming FILE_IO handles file reading
        List<CustomerClass> customers = fileIO.getAllUsers(); // Get all users
        
        // Loop through customers to find the one with matching ID
        for (CustomerClass customer : customers) {
            if (customer.getUserID().equals(customerID)) {
                return customer; // Return the customer object if ID matches
            }
        }
        
        // If no customer with that ID was found, throw an exception or return null
        throw new Exception("Customer with ID " + customerID + " not found.");
    }
    
    @Override
    public boolean makepayment(String creditcard_No){
        if(creditcard_No.equals("")){
            return false;
        }
        return true;
    }
    
    @Override
    public boolean makepayment(){
        boolean success = true; // Simulate payment success
        if (!success) {
            try {
                throw new Exception("Payment failed");
            } catch (Exception ex) {
                Logger.getLogger(CustomerClass.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return success;
    }
    
    @Override
    public void login(){}
    
    
    
}
