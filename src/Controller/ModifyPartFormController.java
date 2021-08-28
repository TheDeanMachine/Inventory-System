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




    //// Part form methods ////
    @FXML
    void onActionSaveDisplayMainScreen() throws IOException {
        //TODO



        displayNewScreen(saveButton, "/View/MainScreen.fxml", "Main Screen");
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


    ///////////
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        parIdTxt.setText(String.valueOf(item.getId()));
        partNameTxt.setText(item.getName());
        partInvTxt.setText(String.valueOf(item.getStock()));
        partPriceTxt.setText(String.valueOf(item.getPrice()));
        partMaxTxt.setText(String.valueOf(item.getMax()));
        partMinTxt.setText(String.valueOf(item.getMin()));

        if (item instanceof InHouse) {
            machineCompanyTxt.setText(String.valueOf(((InHouse)item).getMachineId()));
            machineCompanyLabel.setText("Machine Id");
            inHouseRadioButton.setSelected(true);
        } else {
            machineCompanyTxt.setText(String.valueOf(((Outsourced)item).getCompanyName()));
            machineCompanyLabel.setText("Company Name");
            outSourcedRadioButton.setSelected(true);
        }

    }

    private static Part item = null;

    public static void holdData(Part selectedPart) {
        item = selectedPart;
    }

//    private Part item = null;
//
//    public void holdData(Part selectedPart) {
//        item = selectedPart;
//        //System.out.println(selectedPart.getId());
//    }


}

