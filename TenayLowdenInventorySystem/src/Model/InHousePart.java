/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Tenay
 */
public class InHousePart extends Part {
    private int machineID;
    
    //constructor
    public InHousePart(int machineID, int id, String name, double price, int stock, int min, int max) {
        super(id, name, price, stock, min, max);
        this.machineID = machineID;
    }

    //setter and getter
    public int getMachineID() {
        return machineID;
    }

    public void setMachineID(int machineID) {
        this.machineID = machineID;
    }
   
}
