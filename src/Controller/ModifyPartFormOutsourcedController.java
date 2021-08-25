package Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.event.ActionEvent;
import java.io.IOException;


public class ModifyPartFormOutsourcedController extends SuperController {

    //// Part From Fields ////
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
    private TextField companyTxt;

    //// Toggle Group ////
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
    void onActionDisplayInHousePartFrom(ActionEvent event) throws IOException {
        displayNewToggleGroup(event, "/View/ModifyPartFormInHouse.fxml", "Part Form In-House");
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
