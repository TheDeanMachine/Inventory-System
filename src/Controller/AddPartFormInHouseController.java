package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

import java.io.IOException;

public class AddPartFormInHouseController {

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
    private Button addInventoryButton;

    @FXML
    private RadioButton inHouseToggle;

    @FXML
    private ToggleGroup partFormToggle;

    @FXML
    private RadioButton outSourcedToggle;

    @FXML
    void onActionAddDisplayMainScreen(ActionEvent event) {

    }

    @FXML
    void onActionCancelDisplayMainScreen(ActionEvent event) throws IOException {

    }

    @FXML
    void onActionDisplayInHousePartForm(ActionEvent event) {
    }

}
