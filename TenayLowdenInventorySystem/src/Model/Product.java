/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/**
 *
 * @author Tenay
 */
public class Product {
    
    private ObservableList<Part> associatedParts = FXCollections.observableArrayList();
    private int prodId;
    private String prodName;
    private double prodPrice;
    private int prodStock;
    private int min;
    private int max;
    
    //constructor
    public Product(int id, String name, double price, int stock, int min, int max) {
        this.prodId = id;
        this.prodName = name;
        this.prodPrice = price;
        this.prodStock = stock;
        this.min = min;
        this.max = max;
    }

    //setters and getters
    public int getProdId() {
        return prodId;
    }

    public void setProdId(int id) {
        this.prodId = id;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String name) {
        this.prodName = name;
    }

    public double getProdPrice() {
        return prodPrice;
    }

    public void setProdPrice(double price) {
        this.prodPrice = price;
    }

    public int getProdStock() {
        return prodStock;
    }

    public void setProdStock(int stock) {
        this.prodStock = stock;
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

   
   //associated parts functions 
    public void addAssociatedPart(Part part) {
        associatedParts.add(part);
    }
    public void deleteAssociatedPart(Part part) {
        associatedParts.remove(part);
    }
    public ObservableList<Part> getAllAssociatedParts() {
        return associatedParts;
    }
}
