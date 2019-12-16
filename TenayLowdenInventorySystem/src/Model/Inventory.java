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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

public class Inventory {
    
    private static ObservableList<Part> allParts = FXCollections.observableArrayList();
    private static ObservableList<Product> allProducts = FXCollections.observableArrayList();
    

    public Inventory() {
    }
   
    //part functionalities
    //constructs new part and adds to Observable List
    public static void addPart(Part newPart) {
        allParts.add(newPart);
        }

    //part search by name
    public static ObservableList<Part> lookupPart(String partName) {
        ObservableList<Part> result = FXCollections.observableArrayList();
        for(Part part: Inventory.getAllParts()) {
            if(part.getPartName().toLowerCase().contains(partName.toLowerCase())) {
               result.add(part);
            }
        }
        //dialogue box for invalid searches
        if(result == null || result.isEmpty()){
            Alert partSearch = new Alert(AlertType.WARNING,
                "No Matching Parts Found",
                ButtonType.OK);
                partSearch.showAndWait();
                result = Inventory.getAllParts();
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
    
    //product search by name
    public static ObservableList<Product> lookupProduct(String productName) {
        ObservableList<Product> result = FXCollections.observableArrayList();
        for(Product prod: Inventory.getAllProducts()) {
            if(prod.getProdName().toLowerCase().contains(productName.toLowerCase())) {
               result.add(prod);
            }
        }
        if(result == null || result.isEmpty()){
            Alert prodSearch = new Alert(AlertType.WARNING,
                "No Matching Products Found",
                ButtonType.OK);
                prodSearch.showAndWait();
                result = Inventory.getAllProducts();
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
   
