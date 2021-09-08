package Controller;

import Model.InHouse;
import Model.Inventory;
import Model.Outsourced;
import Model.Part;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * The Controller class for the modify part form.
 * The modify part class loads the values of a previously added part and allows for modification of that part.
 */
public class ModifyPartFormController extends SuperController implements Initializable {

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
    public Button saveButton;

    /**
     * Save Part Method.
     * This method loads input data that the user previously entered and displays it. It allows for the user
     * to make and save those changes to the parts list. Like the add part form this method also performs
     * input validation on the users entries.
     * @throws IOException catches IO errors.
     */
    @FXML
    void onActionSaveDisplayMainScreen() throws IOException {

        // Create alert objects, to be set in the following catch blocks
        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        Alert warningAlert = new Alert(Alert.AlertType.WARNING);

        // Displays the unique id, but does not allow for modification
        int id = Integer.parseInt(parIdTxt.getText());

        // Get input from the user in the following fields and check for input validation
        String name = null;
        try {
            name = partNameTxt.getText();
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

        // get the items index to pass into the update method
        int index = Inventory.getAllParts().indexOf(item);

        // Distinguish between which radio button input was selected and update the part list
        if (item instanceof InHouse) {
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
            Inventory.updatePart(index, newPart);

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
            Inventory.updatePart(index, newPart);
        }

        displayNewScreen(saveButton, "/View/MainScreen.fxml", "Main Screen");
    }

    /**
     * Cancel method.
     * Displays the main screen, without saving work.
     * @throws IOException catches IO errors.
     */
    @FXML
    void onActionCancelDisplayMainScreen() throws IOException {
        displayNewScreen(cancelButton, "/View/MainScreen.fxml", "Main Screen");
    }

    /**
     * Method for toggling between machine/company label.
     */
    @FXML
    void onActionInHouseRadioButton(ActionEvent event) {
        machineCompanyLabel.setText("Machine ID");
    }

    /**
     * Method for toggling between machine/company label.
     */
    @FXML
    void onActionOutsourcedRadioButton(ActionEvent event) {
        machineCompanyLabel.setText("Company Name");
    }

    // field for holding the passed item object
    private static Part item = null;

    /**
     * Method for catching the passed part from main controller.
     * @param selectedPart the object that was passed in.
     */
    public static void holdData(Part selectedPart) {
        item = selectedPart;
    }

    /**
     * Initialize Method.
     * This method is from the interface Initializable, and is overridden here.
     * The method is loaded(initialized) when this controller gets called.
     * It contains the object values that were passed in and sets the label
     * fields with those values.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        // set the form with the user selected objects value
        parIdTxt.setText(String.valueOf(item.getId()));
        partNameTxt.setText(item.getName());
        partInvTxt.setText(String.valueOf(item.getStock()));
        partPriceTxt.setText(String.valueOf(item.getPrice()));
        partMaxTxt.setText(String.valueOf(item.getMax()));
        partMinTxt.setText(String.valueOf(item.getMin()));

        if (item instanceof InHouse) {
            machineCompanyTxt.setText(String.valueOf(((InHouse)item).getMachineId()));
            inHouseRadioButton.setSelected(true);
            outSourcedRadioButton.setDisable(true);
            machineCompanyLabel.setText("Machine ID");
        } else {
            machineCompanyTxt.setText(String.valueOf(((Outsourced)item).getCompanyName()));
            outSourcedRadioButton.setSelected(true);
            inHouseRadioButton.setDisable(true);
            machineCompanyLabel.setText("Company Name");
        }
    }

}

