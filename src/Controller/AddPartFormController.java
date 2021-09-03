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
import java.util.Scanner;

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

        try {
            // Get Input from user
            //int id = Integer.parseInt(parIdTxt.getText());
            int id = generateID();
            String name = partNameTxt.getText();
            double price = Double.parseDouble(partPriceTxt.getText());
            int stock = Integer.parseInt(partInvTxt.getText());
            int min = Integer.parseInt(partMinTxt.getText());
            int max = Integer.parseInt(partMaxTxt.getText());

            // Distinguish between which radio button input was selected and add part to part list
            if (inHouseRadioButton.isSelected()) {
                int machineId = Integer.parseInt(machineCompanyTxt.getText());
                InHouse newPart = new InHouse(id, name, price, stock, min, max, machineId);
                Inventory.addPart(newPart);
            } else {
                String companyName = machineCompanyTxt.getText();
                Outsourced newPart = new Outsourced(id, name, price, stock, min, max, companyName);
                Inventory.addPart(newPart);
            }

        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Number Format Exception");
            alert.setContentText("Please provide numeric digits for: \n" + "Inventory, Price, Min, Max, MachineID");
            alert.showAndWait();
            return;
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


//
//    public static void storeID(int inputFile) {
//        PrintWriter outputFile = null;
//        try {
//            outputFile = new PrintWriter("uniqueID.txt");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        outputFile.println(inputFile);
//        outputFile.close();
//    }
//
//    public static int generateID(){
//        File file = new File("uniqueID.txt");
//        Scanner inputFile = null;
//        try {
//            inputFile = new Scanner(file);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        // Read the first line from the file.
//        int line = inputFile.nextInt();
//
//        //increment the number by one write to the file
//        line++;
//        storeID(line);
//
//        // Close the file.
//        inputFile.close();
//
//        return line;
//    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
      //generateID();

    }
}

