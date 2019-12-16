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
import java.util.Optional;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
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
    private TableColumn<Part, Integer> partId;
    @FXML
    private TableColumn<Part, String> partName;
    @FXML
    private TableColumn<Part, Integer> partStock;
    @FXML
    private TableColumn<Part, Double> partPrice;
    @FXML
    private TextField SearchPartField;
    @FXML
    private TableView<Product> productsTable;
    @FXML
    private TableColumn<Product, Integer> prodId;
    @FXML
    private TableColumn<Product, String> prodName;
    @FXML
    private TableColumn<Product, Integer> prodStock;
    @FXML
    private TableColumn<Product, Double> prodPrice;
    @FXML
    private TextField SearchProductField;
     

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //sets parts data
        partsTable.setItems(Inventory.getAllParts());
        
        partId.setCellValueFactory(new PropertyValueFactory<>("partId"));
        partName.setCellValueFactory(new PropertyValueFactory<>("partName"));
        partStock.setCellValueFactory(new PropertyValueFactory<>("partStock"));
        partPrice.setCellValueFactory(new PropertyValueFactory<>("partPrice"));
        
        //sets products data
        productsTable.setItems(Inventory.getAllProducts());
        
        prodId.setCellValueFactory(new PropertyValueFactory<>("prodId"));
        prodName.setCellValueFactory(new PropertyValueFactory<>("prodName"));
        prodStock.setCellValueFactory(new PropertyValueFactory<>("prodStock"));
        prodPrice.setCellValueFactory(new PropertyValueFactory<>("prodPrice"));
      
    }

    @FXML
    private void searchPartHandler(ActionEvent event) {
        
        String searchName = SearchPartField.getText(); 
        partsTable.setItems(Inventory.lookupPart(searchName));  
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
        //modified to set tabledata to textfields on next screen
        Stage stage;
        Parent root;
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View_Controller/ModPart.fxml"));
        root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        ModPartController controller = loader.getController();
        Part parts = partsTable.getSelectionModel().getSelectedItem();
        controller.setPart(parts);
    }
    
     @FXML
    void deleterPartHandler(ActionEvent event) {
        Alert delPart = new Alert(AlertType.CONFIRMATION, 
        "Are you sure you want to delete this part?",
        ButtonType.OK,
        ButtonType.CANCEL);
        delPart.setTitle("Delete Warning");
        Optional<ButtonType> result = delPart.showAndWait();
            if(result.get() == ButtonType.OK) {
            Inventory.deletePart(partsTable.getSelectionModel().getSelectedItem());
        }
        else if(result.get() == ButtonType.CANCEL) {
            event.consume();
        }
    }

    @FXML
    private void searchProdHandler(ActionEvent event) {
        String searchName = SearchProductField.getText(); 
        productsTable.setItems(Inventory.lookupProduct(searchName));
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
        Stage stage;
        Parent root;
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View_Controller/ModProduct.fxml"));
        root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        ModProductController controller = loader.getController();
        Product product = productsTable.getSelectionModel().getSelectedItem();
        controller.setProduct(product);
    }

    @FXML
    private void deleterProdHandler(ActionEvent event) {
        Alert delProd = new Alert(AlertType.CONFIRMATION, 
        "Are you sure you want to delete this product?",
        ButtonType.OK,
        ButtonType.CANCEL);
        delProd.setTitle("Delete Warning");
        Optional<ButtonType> result = delProd.showAndWait();
            if(result.get() == ButtonType.OK) {
            Inventory.deleteProduct(productsTable.getSelectionModel().getSelectedItem());
        }
        else if(result.get() == ButtonType.CANCEL) {
            event.consume();
        }
    }

    @FXML
    private void exitHandler(ActionEvent event) {
        System.exit(0);
    }

}
