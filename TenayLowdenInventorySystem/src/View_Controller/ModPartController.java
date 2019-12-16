/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View_Controller;

import Model.InHousePart;
import Model.Inventory;
import Model.OutsourcedPart;
import Model.Part;
import static View_Controller.AddPartController.generateRandomInt;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Tenay
 */
public class ModPartController implements Initializable {
    Stage stage;
    Parent scene;
    
    Part part;

    @FXML
    private RadioButton InHouseToggle;
    @FXML
    private RadioButton OutsourceToggle;
    @FXML
    private ToggleGroup group;
    @FXML
    private TextField partIdtxt;
    @FXML
    private TextField partNametxt;
    @FXML
    private TextField partStocktxt;
    @FXML
    private TextField partPricetxt;
    @FXML
    private TextField maxtxt;
    @FXML
    private TextField machineIDtxt;
    @FXML
    private TextField mintxt;
    @FXML
    private Label machIDlbl;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        partIdtxt.setDisable(true);
        InHouseToggle.setToggleGroup(group);
        OutsourceToggle.setToggleGroup(group);
    }    

    @FXML
    private void inHouseToggleHandler(ActionEvent event) {
        if(InHouseToggle.isSelected()) {
            machIDlbl.setText("Machine ID");
            machineIDtxt.setPromptText("Machine ID");
        }
    }

    @FXML
    private void outsourceToggleHandler(ActionEvent event) {
        if(OutsourceToggle.isSelected()) {
            machIDlbl.setText("Company Name");
            machineIDtxt.setPromptText("Company Name");
        }
    }

    @FXML
    private void modPartSaveHandler(ActionEvent event) throws IOException {
        try {
            
        int partId = generateRandomInt(1, 50);
        String partName = partNametxt.getText();
        int partStock = Integer.parseInt(partStocktxt.getText());
        double partPrice = Double.parseDouble(partPricetxt.getText());
        int min = Integer.parseInt(mintxt.getText());
        int max = Integer.parseInt(maxtxt.getText());
        
        if (InHouseToggle.isSelected()) {
            int machineID = Integer.parseInt(machineIDtxt.getText());
            Inventory.addPart(new InHousePart(machineID, partId, partName, partPrice, partStock, min, max));
        }
        else if (OutsourceToggle.isSelected()) {
            String companyName = machineIDtxt.getText();
            Inventory.addPart(new OutsourcedPart(companyName, partId, partName, partPrice, partStock, min, max));
        }
        Inventory.deletePart(part);
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/View_Controller/MainScreen.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
        }catch(NumberFormatException e) {
            Alert invalidEntry = new Alert(Alert.AlertType.WARNING,
                "Please enter valid input for all fields.",
                ButtonType.OK);
                invalidEntry.showAndWait();
        }
    }

    @FXML
    private void modPartCancelHandler(ActionEvent event) throws IOException {
        
        Alert cancelModPart = new Alert(Alert.AlertType.CONFIRMATION, 
        "Return to Inventory? No changes will be saved.",
        ButtonType.OK,
        ButtonType.CANCEL);
        cancelModPart.setTitle("Cancel?");
        Optional<ButtonType> result = cancelModPart.showAndWait();
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
    public void setPart(Part part) {
       this.part = part;
       
       partIdtxt.setText(Integer.toString(part.getPartId()));
       partNametxt.setText(part.getPartName());
       partStocktxt.setText(Integer.toString(part.getPartStock()));
       partPricetxt.setText(Double.toString(part.getPartPrice()));
       maxtxt.setText(Integer.toString(part.getMax()));
       mintxt.setText(Integer.toString(part.getMin()));
       
       if (part instanceof InHousePart) {
            InHouseToggle.setSelected(true);
            machIDlbl.setText("Machine ID");
            machineIDtxt.setText(Integer.toString(((InHousePart)part).getMachineID()));
            }
       else if (part instanceof OutsourcedPart) {
           OutsourceToggle.setSelected(true);
           machIDlbl.setText("Company Name");
           machineIDtxt.setText(((OutsourcedPart)part).getCompanyName());
       }
    }
}
