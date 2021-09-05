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

        int id = generateID();

        // Get Input from user in the following fields
        String name = null;
        try {
            name = partNameTxt.getText();
            if(!name.matches("^[a-zA-Z]*$")) {
                throw new Exception();
            }
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Name Format Error");
            alert.setContentText("Please provide character strings only");
            alert.showAndWait();
            return;
        }

        double price = 0;
        try {
            price = Double.parseDouble(partPriceTxt.getText());
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Price Format Error");
            alert.setContentText("Please provide a numeric digits only. \n" +
                            "You may include a decimal point" );
            alert.showAndWait();
            return;
        }

        int stock = 0;
        try {
            stock = Integer.parseInt(partInvTxt.getText());
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Inventory Format Error");
            alert.setContentText("Please provide whole numbers only");
            alert.showAndWait();
            return;
        }

        int min = 0;
        try {
            min = Integer.parseInt(partMinTxt.getText());
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Min Inventory Format Error");
            alert.setContentText("Please provide whole numbers only");
            alert.showAndWait();
            return;
        }

        int max = 0;
        try {
            max = Integer.parseInt(partMaxTxt.getText());
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Max Inventory Format Error");
            alert.setContentText("Please provide whole numbers only");
            alert.showAndWait();
            return;
        }


        // Distinguish between which radio button input was selected and add part to part list
        if (inHouseRadioButton.isSelected()) {
            int machineId = 0;
            try {
                machineId = Integer.parseInt(machineCompanyTxt.getText());
            } catch (NumberFormatException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setHeaderText("Machine ID Format Error");
                alert.setContentText("Please provide whole numbers only");
                alert.showAndWait();
                return;
            }
            InHouse newPart = new InHouse(id, name, price, stock, min, max, machineId);
            Inventory.addPart(newPart);
        } else {
            String companyName = null;
            try {
                companyName = machineCompanyTxt.getText();
                if(!companyName.matches("^[a-zA-Z]*$")) {
                    throw new Exception();
                }
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setHeaderText("Company Name Format Error");
                alert.setContentText("Please provide character strings only");
                alert.showAndWait();
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

