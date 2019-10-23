/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View_Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Tenay
 */
public class ModPartController implements Initializable {
    Stage stage;
    Parent scene;

    @FXML
    private RadioButton InHouseToggle;
    @FXML
    private RadioButton OutsourceToggle;
    @FXML
    private Button ModPartSave;
    @FXML
    private Button ModPartCancel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void inHouseToggleHandler(ActionEvent event) {
    }

    @FXML
    private void outsourceToggleHandler(ActionEvent event) {
    }

    @FXML
    private void modPartSaveHandler(ActionEvent event) {
    }

    @FXML
    private void modPartCancelHandler(ActionEvent event) throws IOException {
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/View_Controller/MainScreen.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }
    
}
