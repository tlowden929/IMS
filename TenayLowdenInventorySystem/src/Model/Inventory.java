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

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Inventory {
    
    private static ObservableList<Part> allParts = FXCollections.observableArrayList();
    private static ObservableList<Product> allProducts = FXCollections.observableArrayList();

    public Inventory() {
    }
   
    //part functionalities
    public static void addPart(Part newPart) {
        allParts.add(newPart);
        }
    
    public static Part lookupPart(int partId) {
        Part result = null;
        for(int i=0; i<allParts.size();i++) {
           if (partId == allParts.get(i).getId()) {
              result = allParts.get(i);
           }
           else {
                System.out.println("Part Not Found");
           }
        }
        return result;  
    }
    
    public static ObservableList<Part> lookupPart(String partName) {
        ObservableList<Part> result = FXCollections.observableArrayList();
        for(int i=0; i<allParts.size(); i++) {
            if (partName.equals(allParts.get(i).getName())) {
                result.add(allParts.get(i));
            }
            else {
                System.out.println("Part Not Found");
            }
        }
        return result;
    }
    
    public static void updatePart(int index, Part selectedPart) {
        allParts.set(index, selectedPart);
    }
    public static void deletePart(Part selectedPart) {
        allParts.remove(selectedPart);
    }
    public static ObservableList<Part> getAllParts() {
        return allParts;
    }
    
    //product functionality
    public static void addProduct(Product newProduct) {
        allProducts.add(newProduct);
    }
    
    public static Product lookupProduct(int productId) {
        Product result = null;
        for(int i=0; i<allProducts.size();i++) {
           if (productId == allProducts.get(i).getId()) {
              result = allProducts.get(i);
           }
           else {
                System.out.println("Part Not Found");
           }
        }
        return result;  
    }
    
    public static ObservableList<Product> lookupProduct(String productName) {
        ObservableList<Product> result = FXCollections.observableArrayList();
        for(int i=0; i<allProducts.size(); i++) {
            if (productName.equals(allProducts.get(i).getName())) {
                result.add(allProducts.get(i));
            }
            else {
                System.out.println("Part Not Found");
            }
        }
        return result;
    }
    
    public static void updateProduct(int index, Product selectedProduct) {
        allProducts.set(index, selectedProduct);
    }
    public static void deleteProduct(Product selectedProduct) {
        allProducts.remove(selectedProduct);
    }
    public static ObservableList<Product> getAllProducts() {
        return allProducts;
    }
}
   
