/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View_Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import Model.Inventory;
import Model.Part;
import Model.Product;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author Tenay
 */
public class MainScreenController implements Initializable {
    Stage stage;
    Parent scene;

    @FXML
    private TableView<Part> partsTable;
    @FXML
    private TableColumn<Part, Integer> partID;
    @FXML
    private TableColumn<Part, String> partName;
    @FXML
    private TableColumn<Part, Integer> partStock;
    @FXML
    private TableColumn<Part, Double> partPrice;
    @FXML
    private TextField SearchPartField;
    @FXML
    private Button PartSearch;
    @FXML
    private Button AddPart;
    @FXML
    private Button ModifyPart;
    @FXML
    private Button DeletePart;
    @FXML
    private TableView<Product> productsTable;
    @FXML
    private TableColumn<Product, Integer> prodID;
    @FXML
    private TableColumn<Product, String> prodName;
    @FXML
    private TableColumn<Product, Integer> prodStock;
    @FXML
    private TableColumn<Product, Double> prodPrice;
    @FXML
    private TextField SearchProductField;
    @FXML
    private Button SearchProduct;
    @FXML
    private Button AddProduct;
    @FXML
    private Button ModifyProduct;
    @FXML
    private Button DeleteProduct;
    @FXML
    private Button Exit;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
        /*partsTable.setItems(Inventory.getAllParts());
        
        partID.setCellValueFactory(new PropertyValueFactory("partID"));
        partName.setCellValueFactory(new PropertyValueFactory<>("partName"));
        partStock.setCellValueFactory(new PropertyValueFactory<>("partStock"));
        partPrice.setCellValueFactory(new PropertyValueFactory<>("partPrice"));*/
        
        
        productsTable.setItems(Inventory.getAllProducts());
        
        prodID.setCellValueFactory(new PropertyValueFactory("prodID"));
        prodName.setCellValueFactory(new PropertyValueFactory("prodName"));
        prodStock.setCellValueFactory(new PropertyValueFactory("prodStock"));
        prodPrice.setCellValueFactory(new PropertyValueFactory("prodPrice"));
      
    }

  

    @FXML
    private void searchPartHandler(ActionEvent event) {
    }

    @FXML
    private void addPartHandler(ActionEvent event) throws IOException {
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/View_Controller/AddPart.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    @FXML
    private void modifyPartHandler(ActionEvent event) throws IOException {
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/View_Controller/ModPart.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    @FXML
    private void deleterPartHandler(ActionEvent event) {
    }

    @FXML
    private void searchProdHandler(ActionEvent event) {
    }

    @FXML
    private void addProdHandler(ActionEvent event) throws IOException {
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/View_Controller/AddProduct.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    @FXML
    private void modifyProdHandler(ActionEvent event) throws IOException {
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/View_Controller/ModProduct.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    @FXML
    private void deleterProdHandler(ActionEvent event) {
    }

    @FXML
    private void exitHandler(ActionEvent event) {
        System.exit(0);
    }
    
}
