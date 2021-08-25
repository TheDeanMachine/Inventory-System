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
    public Button cancelButton;

    @FXML
    public Button saveButton;


    //// Part form methods for switching screens ////
    @FXML
    void onActionDisplayOutsourcedPartForm(ActionEvent event) throws IOException {
      displayNewToggleGroup(event, "/View/ModifyPartFormOutsourced.fxml", "Part Form Outsourced");
    }

    @FXML
    void onActionCancelDisplayMainScreen() throws IOException {
        displayNewScreen(cancelButton, "/View/MainScreen.fxml", "Main Screen");
    }

    @FXML
    void onActionSaveDisplayMainScreen() throws IOException {
        displayNewScreen(saveButton, "/View/MainScreen.fxml", "Main Screen");
    }

}

