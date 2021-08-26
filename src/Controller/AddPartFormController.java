package Controller;

import Model.InHouse;
import Model.Inventory;
import Model.Outsourced;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddPartFormController extends SuperController implements Initializable {

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
    private TextField machineCompanyTxt;

    @FXML
    private Label machineCompanyLabel;

    /// Part Form Toggle Group Fields fx:id ///
    @FXML
    private ToggleGroup partFormToggle;

    @FXML
    private RadioButton inHouseRadioButton;

    @FXML
    private RadioButton outSourcedRadioButton;


    /// Part Form Button Fields fx:id ///
    @FXML
    public Button cancelButton;

    @FXML
    public Button addInventoryButton;


    //// Part form methods ////
    @FXML
     void onActionAddDisplayMainScreen() throws IOException {

        // Get Input from user
        int id = Integer.parseInt(parIdTxt.getText());
        String name = partNameTxt.getText();
        double price = Double.parseDouble(partPriceTxt.getText());
        int stock = Integer.parseInt(partInvTxt.getText());
        int min = Integer.parseInt(partMinTxt.getText());
        int max = Integer.parseInt(partMaxTxt.getText());
        int machineId = 0; // place holder values
        String companyName = "null"; // place holder values

        // Distinguish between which radio button input was selected for the last text field option
        if (inHouseRadioButton.isSelected()){
            machineId = Integer.parseInt(machineCompanyTxt.getText());

        } else {
            companyName = machineCompanyTxt.getText();
        }

        // Create an object based on the input that was selected for the last text field option
        if (inHouseRadioButton.isSelected()){
            InHouse newPart = new InHouse(id, name, price, stock, min, max, machineId);
            Inventory.addPart(newPart);
        } else {
            Outsourced newPart = new Outsourced(id, name, price, stock, min, max, companyName);
            Inventory.addPart(newPart);
        }

        displayNewScreen(addInventoryButton, "/View/MainScreen.fxml", "Main Screen");
    }

    @FXML
    void onActionCancelDisplayMainScreen() throws IOException {
        displayNewScreen(cancelButton, "/View/MainScreen.fxml", "Main Screen");
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

    ////////////
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}

