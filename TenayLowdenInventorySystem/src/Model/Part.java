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
public abstract class Part {
    
    private int partId;
    private String partName;
    private double partPrice;
    private int partStock;
    private int min;
    private int max;
    
    //constructor
    public Part(int id, String name, double price, int stock, int min, int max) {
        this.partId = id;
        this.partName = name;
        this.partPrice = price;
        this.partStock = stock;
        this.min = min;
        this.max = max;
    }

    //setters and getters
    public int getPartId() {
        return partId;
    }

    public void setPartId(int id) {
        this.partId = id;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String name) {
        this.partName = name;
    }

    public double getPartPrice() {
        return partPrice;
    }

    public void setPartPrice(double price) {
        this.partPrice = price;
    }

    public int getPartStock() {
        return partStock;
    }

    public void setPartStock(int stock) {
        this.partStock = stock;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }
    
}
