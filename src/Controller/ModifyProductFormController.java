package Controller;

import Model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class ModifyProductFormController extends SuperController implements Initializable {

    /// Product Form Text Fields fx:id ///
    @FXML
    private TextField partSearchTxt;

    @FXML
    private TextField productIdTxt;

    @FXML
    private TextField productNameTxt;

    @FXML
    private TextField productInvTxt;

    @FXML
    private TextField productPriceTxt;

    @FXML
    private TextField productMinTxt;

    @FXML
    private TextField productMaxTxt;


    /// Product Form, Parts TableView Fields fx:id ///
    @FXML
    private TableView<Part> partsTableView1;

    @FXML
    private TableColumn<Part, Integer> partIdColumn1;

    @FXML
    private TableColumn<Part, String> partNameColumn1;

    @FXML
    private TableColumn<Part, Integer> partInventoryColumn1;

    @FXML
    private TableColumn<Part, Double> partPriceColumn1;


    /// Product Form, Associated Parts TableView Fields fx:id ///
    @FXML
    private TableView<Part> partsTableView2;

    @FXML
    private TableColumn<Part, Integer> partIdColumn2;

    @FXML
    private TableColumn<Part, String> partNameColumn2;

    @FXML
    private TableColumn<Part, Integer> partInventoryColumn2;

    @FXML
    private TableColumn<Part, Double> partPriceColumn2;

    /// Product Form Button Fields fx:id ///
    @FXML
    private Button addPartButton;

    @FXML
    private Button removePartButton;

    @FXML
    public Button cancelButton;

    @FXML
    public Button saveButton;

    /**
     * FUTURE ENHANCEMENT.
     * Provides a brief description of the product
     */
    @FXML
    private TextArea productTxtArea;


    @FXML
    void onActionSearchParts(ActionEvent event) {
        // get the users input
        String userString = partSearchTxt.getText();

        // after clearing the search bar display all current parts
        if(userString == null || userString.isBlank()){
            partsTableView1.setItems(Inventory.getAllParts());
            partsTableView1.getSelectionModel().clearSelection();
            return;
        }

        try {
            // search by id
            int parsedInt = Integer.parseInt(partSearchTxt.getText());
            Part foundId = Inventory.lookupPart(parsedInt);

            // if not found, search by name
            if(foundId == null) {
                throw new NumberFormatException();
            }
            // if found, highlight the found item
            partsTableView1.getSelectionModel().select(foundId);

        } catch (NumberFormatException e) {
            // create an empty list to hold the results
            ObservableList<Part> foundNames = FXCollections.observableArrayList();

            // search by name
            foundNames = Inventory.lookupPart(userString);

            // if found display the list, else display a not found message
            if(foundNames.size() > 0 ) {
                partsTableView1.setItems(foundNames);
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("search results");
                alert.setHeaderText("No matching parts found");
                alert.setContentText("Try searching by part name or part id");
                alert.showAndWait();
            }
        }
    }



    /// Product Form change screen methods
    @FXML
    void onActionSaveDisplayMainScreen() throws IOException {

        // Create alert objects, to be set in the following catch blocks
        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        Alert warningAlert = new Alert(Alert.AlertType.WARNING);

        // Displays the unique id, but does not allow for modification
        int id = Integer.parseInt(productIdTxt.getText());

        // Get input from the user in the following fields and check for input validation
        String name = null;
        try {
            name = productNameTxt.getText();
            if(!name.matches("^[a-z \\d A-Z]*$")) {
                throw new Exception();
            }
        } catch (Exception e) {
            errorAlert.setHeaderText("Name Format Error");
            errorAlert.setContentText("Please provide numbers or characters only \nNO special characters");
            errorAlert.showAndWait();
            return;
        }

        double price = 0;
        try {
            price = Double.parseDouble(productPriceTxt.getText());
        } catch (NumberFormatException e) {
            errorAlert.setHeaderText("Price Format Error");
            errorAlert.setContentText("Please provide a numeric digits only. \n" +
                    "You may include a decimal point" );
            errorAlert.showAndWait();
            return;
        }

        int stock = 0;
        try {
            stock = Integer.parseInt(productInvTxt.getText());
        } catch (NumberFormatException e) {
            errorAlert.setHeaderText("Inventory Format Error");
            errorAlert.setContentText("Please provide whole numbers only");
            errorAlert.showAndWait();
            return;
        }

        int min = 0;
        try {
            min = Integer.parseInt(productMinTxt.getText());
        } catch (NumberFormatException e) {
            errorAlert.setHeaderText("Min Inventory Format Error");
            errorAlert.setContentText("Please provide whole numbers only");
            errorAlert.showAndWait();
            return;
        }

        int max = 0;
        try {
            max = Integer.parseInt(productMaxTxt.getText());
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

        // update the item with the changes
        item.setId(id);
        item.setName(name);
        item.setPrice(price);
        item.setStock(stock);
        item.setMin(min);
        item.setMax(max);

        // get the items index
        int index = Inventory.getAllProducts().indexOf(item);

        // save the changes to the list
        Inventory.updateProduct(index, item);

        displayNewScreen(saveButton, "/View/MainScreen.fxml", "Main Screen");
    }

    @FXML
    void onActionCancelDisplayMainScreen() throws IOException {
       displayNewScreen(cancelButton, "/View/MainScreen.fxml", "Main Screen");
    }

    /// Product Form Add/Remove Associated part methods
    @FXML
    void onActionAddPart(ActionEvent event) {
        // if the user selects the add part button without selecting an item, display an alert box
        if(partsTableView1.getSelectionModel().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle(null);
            alert.setHeaderText("No selected item found");
            alert.setContentText("PLease select an item to add");
            alert.showAndWait();
            return;
        }else {
            // get user input
            Part selectedItem = partsTableView1.getSelectionModel().getSelectedItem();
            // add the part to a new list
            item.addAssociatedPart(selectedItem);
            // display the new list
            partsTableView2.setItems(item.getAllAssociatedParts());
        }
    }

    @FXML
    void onActionRemovePart(ActionEvent event) {
        // if the user selects the remove part button without selecting an item, display an alert box
        if(partsTableView2.getSelectionModel().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle(null);
            alert.setHeaderText("No selected item found");
            alert.setContentText("PLease select an item to remove");
            alert.showAndWait();
            return;
        } else {
            // display a confirmation box for the users selected part to remove
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("Are you sure you want to remove this Part?");
            alert.setContentText("Press ok to remove, and cancel to go back");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                // get user selected part and remove it
                Part selectedItem = partsTableView2.getSelectionModel().getSelectedItem();
                item.deleteAssociatedPart(selectedItem);
            } else {
                return;
            }
        }
    }


    // field for holding the passed item
    private static Product item = null;

    // method for catching the passed item from main controller
    public static void holdData(Product selectedPart) {
        item = selectedPart;
    }

    ////////
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        /////////// Product Form
        // set the form with the user selected objects value
        productIdTxt.setText(String.valueOf(item.getId()));
        productNameTxt.setText(item.getName());
        productInvTxt.setText(String.valueOf(item.getStock()));
        productPriceTxt.setText(String.valueOf(item.getPrice()));
        productMaxTxt.setText(String.valueOf(item.getMax()));
        productMinTxt.setText(String.valueOf(item.getMin()));


        ///////////// Parts TableView
        // set the parts' tableview with the data it will be working with
        partsTableView1.setItems(Inventory.getAllParts());

        // set the columns with the data
        partIdColumn1.setCellValueFactory(new PropertyValueFactory<>("id"));
        partNameColumn1.setCellValueFactory(new PropertyValueFactory<>("name"));
        partInventoryColumn1.setCellValueFactory(new PropertyValueFactory<>("stock"));
        partPriceColumn1.setCellValueFactory(new PropertyValueFactory<>("price"));

        // set the second column with the associated parts
        partsTableView2.setItems(item.getAllAssociatedParts());

        // set the second columns with the data
        partIdColumn2.setCellValueFactory(new PropertyValueFactory<>("id"));
        partNameColumn2.setCellValueFactory(new PropertyValueFactory<>("name"));
        partInventoryColumn2.setCellValueFactory(new PropertyValueFactory<>("stock"));
        partPriceColumn2.setCellValueFactory(new PropertyValueFactory<>("price"));

    }
}

