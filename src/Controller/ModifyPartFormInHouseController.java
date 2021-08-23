package Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.event.ActionEvent;

public class ModifyPartFormInHouseController {

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

    @FXML
    private Button cancelButton;

    @FXML
    private Button saveButton;

    @FXML
    private RadioButton inHouseToggle;

    @FXML
    private ToggleGroup partFormToggle;

    @FXML
    private RadioButton outSourcedToggle;

    @FXML
    void onActionCancelDisplayMainScreen(ActionEvent event) {

    }

    @FXML
    void onActionSaveDisplayMainScreen(ActionEvent event) {

    }

}

