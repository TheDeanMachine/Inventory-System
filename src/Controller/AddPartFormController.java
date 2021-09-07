package Controller;

import Model.InHouse;
import Model.Inventory;
import Model.Outsourced;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import java.io.*;
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

    public AddPartFormController() throws FileNotFoundException {
    }


    //// Part form methods ////
    @FXML
    void onActionAddDisplayMainScreen() throws IOException {

        // Create alert objects, to be set in the following catch blocks
        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        Alert warningAlert = new Alert(Alert.AlertType.WARNING);

        // creates uniques ud
        int id = generateID();

        // Get input from the user in the following fields and check for input validation
        String name = null;
        try {
            name = partNameTxt.getText();
            //if(!name.matches("^[a-z \\d A-Z]*$")) {
            if(name == null || name.isBlank()){
                throw new Exception();
            }
        } catch (Exception e) {
            errorAlert.setHeaderText("Name Format Error");
            errorAlert.setContentText("Please provide a part name");
            errorAlert.showAndWait();
            return;
        }

        double price = 0;
        try {
            price = Double.parseDouble(partPriceTxt.getText());
        } catch (NumberFormatException e) {
            errorAlert.setHeaderText("Price Format Error");
            errorAlert.setContentText("Please provide a numeric digits only. \n" +
                            "You may include a decimal point" );
            errorAlert.showAndWait();
            return;
        }

        int stock = 0;
        try {
            stock = Integer.parseInt(partInvTxt.getText());
        } catch (NumberFormatException e) {
            errorAlert.setHeaderText("Inventory Format Error");
            errorAlert.setContentText("Please provide whole numbers only");
            errorAlert.showAndWait();
            return;
        }

        int min = 0;
        try {
            min = Integer.parseInt(partMinTxt.getText());
        } catch (NumberFormatException e) {
            errorAlert.setHeaderText("Min Inventory Format Error");
            errorAlert.setContentText("Please provide whole numbers only");
            errorAlert.showAndWait();
            return;
        }

        int max = 0;
        try {
            max = Integer.parseInt(partMaxTxt.getText());
        } catch (NumberFormatException e) {
            errorAlert.setHeaderText("Max Inventory Format Error");
            errorAlert.setContentText("Please provide whole numbers only");
            errorAlert.showAndWait();
            return;
        }

        // logical check for inventory levels
        if (min > max){
            warningAlert.setHeaderText("Inventory Levels Incorrect");
            warningAlert.setContentText("The minimum inventory level cannot not be greater then the maximum inventory");
            warningAlert.showAndWait();
            return;
        }
        if (stock < min || stock > max){
            warningAlert.setHeaderText("Inventory Levels Incorrect");
            warningAlert.setContentText("The current inventory must be between the min and max values");
            warningAlert.showAndWait();
            return;
        }



        // Distinguish between which radio button input was selected and add part to part list
        if (inHouseRadioButton.isSelected()) {
            int machineId = 0;
            // input validation
            try {
                machineId = Integer.parseInt(machineCompanyTxt.getText());
            } catch (NumberFormatException e) {
                errorAlert.setHeaderText("Machine ID Format Error");
                errorAlert.setContentText("Please provide whole numbers only");
                errorAlert.showAndWait();
                return;
            }
            InHouse newPart = new InHouse(id, name, price, stock, min, max, machineId);
            Inventory.addPart(newPart);

        } else {
            String companyName = null;
            // input validation
            try {
                companyName = machineCompanyTxt.getText();
                if(companyName == null || companyName.isBlank()){
                    throw new Exception();
                }
            } catch (Exception e) {
                errorAlert.setHeaderText("Company Name Format Error");
                errorAlert.setContentText("Please provide a company name");
                errorAlert.showAndWait();
                return;
            }
            Outsourced newPart = new Outsourced(id, name, price, stock, min, max, companyName);
            Inventory.addPart(newPart);
        }

        // display the new screen
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


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
      //generateID();

    }
}

