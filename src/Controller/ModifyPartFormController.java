package Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class ModifyPartFormController extends SuperController {

    /// Part Form Text Fields fx:id ///
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

    @FXML
    private Label machineCompanyLabel;

    /// Part Form Toggle Group Fields fx:id ///
    @FXML
    private ToggleGroup partFormToggle;

    @FXML
    private RadioButton inHouseToggle;

    @FXML
    private RadioButton outSourcedToggle;

    /// Part Form Button Fields fx:id ///
    @FXML
    public Button cancelButton;

    @FXML
    public Button saveButton;


    //// Part form methods for switching screens ////
    @FXML
    void onActionCancelDisplayMainScreen() throws IOException {
        displayNewScreen(cancelButton, "/View/MainScreen.fxml", "Main Screen");
    }

    @FXML
    void onActionSaveDisplayMainScreen() throws IOException {
        displayNewScreen(saveButton, "/View/MainScreen.fxml", "Main Screen");
    }

    //// Part form methods for toggling between machine/company label
    @FXML
    void onActionInHouseRadioButton(ActionEvent event) {
        machineCompanyLabel.setText("Machine ID");
    }

    @FXML
    void onActionOutsourcedRadioButton(ActionEvent event) {
        machineCompanyLabel.setText("Company Name");
    }

}

