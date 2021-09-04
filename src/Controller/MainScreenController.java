package Controller;

/**
 * The Main Screen Class.
 * Displays two screens, one for parts and one for products
 */

import Model.Inventory;
import Model.Part;
import Model.Product;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.Scene;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class MainScreenController extends SuperController implements Initializable {

    /// Part Form Search Field fx:id ///
    @FXML
    private TextField searchPartTxt;

    /// Part Form TableView Fields fx:id ///
    @FXML
    private TableView<Part> partsTableView;

    @FXML
    private TableColumn<Part, Integer> partIdColumn;

    @FXML
    private TableColumn<Part, String> partNameColumn;

    @FXML
    private TableColumn<Part, Integer> partInventoryColumn;

    @FXML
    private TableColumn<Part, Double> partPriceColumn;

    /// Part Form Button Fields fx:id ///
    @FXML
    private Button deletePartButton;

    @FXML
    public Button modifyPartButton;

    @FXML
    public Button addPartButton;



    /// Product Form Search Fields fx:id ///
    @FXML
    private TextField searchProductTxt;

    /// Product Form TableView Fields fx:id ///
    @FXML
    private TableView<Product> productsTableView;

    @FXML
    private TableColumn<Product, Integer> productIdColumn;

    @FXML
    private TableColumn<Product, String> productNameColumn;

    @FXML
    private TableColumn<Product, Integer> productInventoryColumn;

    @FXML
    private TableColumn<Product, Double> productPriceColumn;

    /// Product Form Button Fields fx:id ///
    @FXML
    private Button deleteProductButton;

    @FXML
    public Button modifyProductButton;

    @FXML
    public Button addProductButton;

    @FXML
    private Button exitButton;

    /// Exit Method ///
    @FXML
    void onActionExitApplication(ActionEvent event) {
        Platform.exit();
    }

    /// Search Methods ///
    @FXML
    void onActionSearchParts(ActionEvent event) {
        // get the users input
        String userString = searchPartTxt.getText();

        // after clearing the search bar display all current parts
        if(userString == null || userString.isBlank()){
            partsTableView.setItems(Inventory.getAllParts());
            partsTableView.getSelectionModel().clearSelection();
            return;
        }

        try {
            // search by id
            int parsedInt = Integer.parseInt(searchPartTxt.getText());
            Part foundId = Inventory.lookupPart(parsedInt);

            // if not found, search by name
            if(foundId == null) {
                throw new NumberFormatException();
            }
            // if found, highlight the found item
            partsTableView.getSelectionModel().select(foundId);

        } catch (NumberFormatException e) {
            // create an empty list to hold the results
            ObservableList<Part> foundNames = FXCollections.observableArrayList();

            // search by name
            foundNames = Inventory.lookupPart(userString);

            // if found display the list, else display a not found message
            if(foundNames.size() > 0 ) {
                partsTableView.setItems(foundNames);
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("search results");
                alert.setHeaderText("No matching parts found");
                alert.setContentText("Try searching by part name or part id");
                alert.showAndWait();
            }
        }
    }

    @FXML
    void onActionSearchProducts(ActionEvent event) {
        // get the users input
        String userString = searchProductTxt.getText();

        // after clearing the search bar display all current parts
        if(userString == null || userString.isBlank()){
            productsTableView.setItems(Inventory.getAllProducts());
            productsTableView.getSelectionModel().clearSelection();
            return;
        }

        try {
            // search by id
            int parsedInt = Integer.parseInt(searchProductTxt.getText());
            Product foundId = Inventory.lookupProduct(parsedInt);

            // if not found, search by name
            if(foundId == null) {
                throw new NumberFormatException();
            }
            // if found, highlight the found item
            productsTableView.getSelectionModel().select(foundId);

        } catch (NumberFormatException e) {
            // create an empty list to hold the results
            ObservableList<Product> foundNames = FXCollections.observableArrayList();

            // search by name
            foundNames = Inventory.lookupProduct(userString);

            // if found display the list, else display a not found message
            if(foundNames.size() > 0 ) {
                productsTableView.setItems(foundNames);
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("search results");
                alert.setHeaderText("No matching products found");
                alert.setContentText("Try searching by product name or product id");
                alert.showAndWait();
            }
        }
    }



    //// Part Screen Methods ////
    @FXML
    void onActionDeletePart(ActionEvent event) {
        // if the user selects the delete part button without selecting an item, display an alert box
        if(partsTableView.getSelectionModel().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle(null);
            alert.setHeaderText("No selected item found");
            alert.setContentText("PLease select an item to delete");
            alert.showAndWait();
            return;
        }else {
            // display a confirmation box for the users selected part to delete
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("Are you sure you want to delete this Part?");
            alert.setContentText("Press ok to delete, and cancel to go back");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                // get user selected part and delete it
                Part selectedItem = partsTableView.getSelectionModel().getSelectedItem();
                Inventory.deletePart(selectedItem);
            } else {
                return;
            }
        }

    }

    /**
     * RUNTIME ERROR.
     * Had issues with passing the selected part object to the part from controller
     * There were a few solutions, including adding an overloaded method to the
     * super controller, which did get the item into the part form controller.
     * However, I could not populate the form field with data on load.
     * The next solution was to create a static method in the part form controller
     * and then pass the item to it, that way on initialize I could populate the
     * form with the data.
     *
     * @throws IOException
     */

    @FXML
    void onActionDisplayModifyPartForm() throws IOException {
        // if the user selects the modify part button, without selecting an item display an alert box
        if(partsTableView.getSelectionModel().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle(null);
            alert.setHeaderText("No selected item found");
            alert.setContentText("PLease select an item to modify");
            alert.showAndWait();
            return;
        }else {
            // get user selected part
            Part selectedItem = partsTableView.getSelectionModel().getSelectedItem();
            // pass the item to part form
            ModifyPartFormController.holdData(selectedItem);
        }

        displayNewScreen(modifyPartButton, "/View/ModifyPartForm.fxml", "Modify Part Form");
    }

    @FXML
    void onActionDisplayAddPartForm() throws IOException {
        displayNewScreen(addPartButton, "/View/AddPartForm.fxml", "Add Part Form");
    }


    //// Product Screen Methods ////
    @FXML
    void onActionDeleteProduct(ActionEvent event) {
        // if the user selects the delete product button without selecting an item, display an alert box
        if(productsTableView.getSelectionModel().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle(null);
            alert.setHeaderText("No selected item found");
            alert.setContentText("PLease select an item to delete");
            alert.showAndWait();
            return;
        }else {
            // display a confirmation box for the users selected product to delete
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("Are you sure you want to delete this Product?");
            alert.setContentText("Press ok to delete, and cancel to go back");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                // get user selected part
                Product selectedItem = productsTableView.getSelectionModel().getSelectedItem();
                Inventory.deleteProduct(selectedItem);
            } else {
                return;
            }
        }
    }

    @FXML
    void onActionDisplayModifyProductForm() throws IOException {
        // if the user selects the modify product button, without selecting an item display an alert box
        if(productsTableView.getSelectionModel().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle(null);
            alert.setHeaderText("No selected item found");
            alert.setContentText("PLease select an item to modify");
            alert.showAndWait();
            return;
        }else {
            // get user selected part
            Product selectedItem = productsTableView.getSelectionModel().getSelectedItem();
            // pass the item to product form
            ModifyProductFormController.holdData(selectedItem);
        }

        displayNewScreen(modifyProductButton, "/View/ModifyProductForm.fxml", "Product Form");
    }

    @FXML
    void onActionDisplayAddProductForm() throws IOException {
       displayNewScreen(addProductButton, "/View/AddProductForm.fxml", "Product Form");
    }

    /// Initialize method
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        // set the parts' tableview with the data it will be working with
        partsTableView.setItems(Inventory.getAllParts());

        // set the columns with the data
        partIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        partNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        partInventoryColumn.setCellValueFactory(new PropertyValueFactory<>("stock"));
        partPriceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));


        // set the products' tableview with the data it will be working with
        productsTableView.setItems(Inventory.getAllProducts());

        // set the columns with the data
        productIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        productNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        productInventoryColumn.setCellValueFactory(new PropertyValueFactory<>("stock"));
        productPriceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));


    }


}

