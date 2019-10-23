/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;


import Model.InHousePart;
import Model.Inventory;
import Model.Product;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Tenay
 */
public class TenayLowdenInventorySystem extends Application {
    
    
    @Override
    public void start(Stage stage) throws Exception {
        
    Parent root = FXMLLoader.load(getClass().getResource("/View_Controller/MainScreen.fxml"));

    Scene scene = new Scene(root);
    scene.setRoot(root);

    stage.setScene(scene);
    stage.show();
    
    }
   
     /**
     * @param args the command line arguments
     */
     public static void main(String[] args) {
        //partsTable data
        InHousePart partOne = new InHousePart(355, 1, "Part One", 5.99, 5, 3, 20);
        InHousePart partTwo = new InHousePart(480, 2, "Part Two", 7.99, 8, 2, 15);
        InHousePart partThree = new InHousePart(559, 3, "Part Three", 2.99, 6, 3, 25);
        Inventory.addPart(partOne);
        Inventory.addPart(partTwo);
        Inventory.addPart(partThree);
        
        //productsTable data
        /*Product prodOne = new Product(1, "Product One", 8.50, 7, 3, 20);
        Product prodTwo = new Product(2, "Product Two", 9.00, 6, 2, 18);
        Inventory.addProduct(prodOne);
        Inventory.addProduct(prodTwo);*/
         
        launch(args);
    }
    
    
}
