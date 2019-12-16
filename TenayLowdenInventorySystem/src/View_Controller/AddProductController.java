/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View_Controller;

import Model.Inventory;
import Model.Part;
import Model.Product;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Tenay
 */
public class AddProductController implements Initializable {
    Stage stage;
    Parent scene;
    private ObservableList<Part> assocParts = FXCollections.observableArrayList();
    
    public static int generateRandomInt(int min, int max) {
    Random r = new Random();
    return r.nextInt((max - min) + 1) + min;
    }

    
    @FXML
    private TextField prodIdtxt;
    @FXML
    private TextField mintxt;
    @FXML
    private TextField prodStocktxt;
    @FXML
    private TextField prodNametxt;
    @FXML
    private TextField prodPricetxt;
    @FXML
    private TextField maxtxt;
    @FXML
    private TableView<Part> partsTable;
    @FXML
    private TextField partSearchtxt;
    @FXML
    private TableView<Part> assocPartsTable;
    @FXML
    private TableColumn<Part, Integer> partId;
    @FXML
    private TableColumn<Part, String> partName;
    @FXML
    private TableColumn<Part, Integer> partStock;
    @FXML
    private TableColumn<Part, Double> partPrice;
    @FXML
    private TableColumn<Part, Integer> assocPartId;
    @FXML
    private TableColumn<Part, String> assocPartName;
    @FXML
    private TableColumn<Part, Integer> assocPartStock;
    @FXML
    private TableColumn<Part, Double> assocPartPrice;

    @FXML
    void cancelAddProd(ActionEvent event) throws IOException {
        Alert cancelAddProd = new Alert(Alert.AlertType.CONFIRMATION, 
        "Return to Inventory? No changes will be saved.",
        ButtonType.OK,
        ButtonType.CANCEL);
        cancelAddProd.setTitle("Cancel?");
        Optional<ButtonType> result = cancelAddProd.showAndWait();
            if(result.get() == ButtonType.OK) {
                stage = (Stage)((Button)event.getSource()).getScene().getWindow();
                scene = FXMLLoader.load(getClass().getResource("/View_Controller/MainScreen.fxml"));
                stage.setScene(new Scene(scene));
                stage.show();
        }
        else if(result.get() == ButtonType.CANCEL) {
            event.consume();
        }
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        prodIdtxt.setDisable(true);
        
        //set searchable parts table
        partsTable.setItems(Inventory.getAllParts());
        
        partId.setCellValueFactory(new PropertyValueFactory<>("partId"));
        partName.setCellValueFactory(new PropertyValueFactory<>("partName"));
        partStock.setCellValueFactory(new PropertyValueFactory<>("partStock"));
        partPrice.setCellValueFactory(new PropertyValueFactory<>("partPrice"));
        
    }    

    @FXML
    private void addAssocPart(ActionEvent event) {
        Part ap = partsTable.getSelectionModel().getSelectedItem();
        assocParts.add(ap);
        
        //set associated parts table
        assocPartsTable.setItems(assocParts);
        
        assocPartId.setCellValueFactory(new PropertyValueFactory<>("partId"));
        assocPartName.setCellValueFactory(new PropertyValueFactory<>("partName"));
        assocPartStock.setCellValueFactory(new PropertyValueFactory<>("partStock"));
        assocPartPrice.setCellValueFactory(new PropertyValueFactory<>("partPrice"));
    }

    @FXML
    private void delAssocPart(ActionEvent event) {
        Alert delPart = new Alert(Alert.AlertType.CONFIRMATION, 
        "Remove Associated Part?",
        ButtonType.OK,
        ButtonType.CANCEL);
        delPart.setTitle("Remove?");
        Optional<ButtonType> result = delPart.showAndWait();
        if(result.get() == ButtonType.OK) {
        Part del = assocPartsTable.getSelectionModel().getSelectedItem();
        assocPartsTable.getItems().remove(del);
        }
        else if(result.get() == ButtonType.CANCEL) {
            event.consume();
        }
    }


    @FXML
    private void saveNewProd(ActionEvent event) throws IOException {
        try {
            
        int prodId = generateRandomInt(1, 50);
        String prodName = prodNametxt.getText();
        int prodStock = Integer.parseInt(prodStocktxt.getText());
        double prodPrice = Double.parseDouble(prodPricetxt.getText());
        int min = Integer.parseInt(mintxt.getText());
        int max = Integer.parseInt(maxtxt.getText());
        
        if(assocParts == null || assocParts.isEmpty()){
            Alert noParts = new Alert(Alert.AlertType.WARNING,
                "All products must have at least one associated part.",
                ButtonType.OK);
                noParts.showAndWait();
            }
        else {
        Product addNewProd = new Product(prodId, prodName, prodPrice, prodStock, min, max);
        for (int i = 0; i < assocParts.size(); ++i) {
            addNewProd.addAssociatedPart(assocParts.get(i));
        }
        Inventory.addProduct(addNewProd);
        
        
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/View_Controller/MainScreen.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
        }
        }
        catch(NumberFormatException e) {
            Alert invalidEntry = new Alert(Alert.AlertType.WARNING,
                "Please enter valid input for all fields.",
                ButtonType.OK);
                invalidEntry.showAndWait();
        }
    }

    @FXML
    private void partSearchHandler(ActionEvent event) {
        String searchName = partSearchtxt.getText(); 
        partsTable.setItems(Inventory.lookupPart(searchName));
    }
    
}
