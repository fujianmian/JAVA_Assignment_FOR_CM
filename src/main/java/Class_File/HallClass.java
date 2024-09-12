/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class_File;

import java.util.List;

/**
 *
 * @author junyong is DaShuaiGe
 */
public class HallClass{
    private String Hall_ID;
    private String Hall_Type;
    private int No_People;
    private int Price;

    public HallClass(String Hall_ID, String Hall_Type, int No_People, int Price) {
        this.Hall_ID = Hall_ID;
        this.Hall_Type = Hall_Type;
        this.No_People = No_People;
        this.Price = Price;
    }
    
    
    // Custom method to parse a HallClass object from a hall ID
    public static HallClass parse(String hallID) throws Exception {
        FILE_IO fileIO = new FILE_IO(); // Assuming FILE_IO handles file reading
        List<HallClass> halls = fileIO.getAllHall(); // Get all halls
        
        // Loop through halls to find the one with matching ID
        for (HallClass hall : halls) {
            if (hall.getHall_ID().equals(hallID)) {
                return hall; // Return the hall object if ID matches
            }
        }
        
        // If no hall with that ID was found, throw an exception or return null
        throw new Exception("Hall with ID " + hallID + " not found.");
    }
    
    

    public String getHall_ID() {
        return Hall_ID;
    }

    public String getHall_Type() {
        return Hall_Type;
    }

    public int getNo_People() {
        return No_People;
    }

    public int getPrice() {
        return Price;
    }


    
}
