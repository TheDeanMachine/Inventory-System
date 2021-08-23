package Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class ModifyPartFormInHouseController extends SuperController{

    //// Parts Form Fields ////
    @FXML
    private TextField parIdTxt;

    @FXML
    private TextField partNameTxt;

    @FXML
    private TextField partInvTxt;

    @FXML
    private TextField partPriceTxt;

    @FXML
    private TextField partMinTxt;

    @FXML
    private TextField partMaxTxt;

    @FXML
    private TextField machineIdTxt;

    /// Toggle Group ///
    @FXML
    private ToggleGroup partFormToggle;

    @FXML
    private RadioButton inHouseToggle;

    @FXML
    private RadioButton outSourcedToggle;

    //// Buttons ////
    @FXML
    private Button cancelButton;

    @FXML
    private Button saveButton;


    //// Part form methods for switching screens ////
    @FXML
    void onActionDisplayOutsourcedPartForm(ActionEvent event) throws IOException {
      displayNewToggleGroup(event, "/View/ModifyPartFormOutsourced.fxml");
    }

    @FXML
    void onActionCancelDisplayMainScreen(ActionEvent event) throws IOException {
        displayNewScreen(event, "/View/MainScreen.fxml");
    }

    @FXML
    void onActionSaveDisplayMainScreen(ActionEvent event) throws IOException {
        displayNewScreen(event, "/View/MainScreen.fxml");
    }

}

