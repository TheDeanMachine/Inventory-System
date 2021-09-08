package Controller;

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

/**
 * The Main Screen Class is the controller for the main screen.
 * Displays two forms, one for parts and one for products.
 */
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

    /**
     * Exit Method.
     */
    @FXML
    void onActionExitApplication(ActionEvent event) {
        Platform.exit();
    }

    /// Search Methods ///

    /**
     * Part Search method.
     * Gets the users input and then searches by id. If it doesn't find it by id it then searches by name.
     * If it finds the part by id, it highlights the item, if it finds the part by name then
     * it displays a list of found parts, else display a not found message.
     */
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

    /**
     * Products Search method.
     * Gets the users input and then searches by id. If it doesn't find it by id it then searches by name.
     * If it finds the product by id, it highlights the item, if it finds the product by name then
     * it displays a list of found products, else display a not found message.
     */
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

    /**
     * Delete Part Method.
     * Once the user selects an item to delete the method deletes the item, but it first displays
     * a confirmation message asking the user if they want to delete this part, with the option to cancel.
     */
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
     * Modify Part Method.
     * Once the user selects an item to modify, the modify part screen loads with the data
     * for that object populated in the text fields.
     * @throws IOException catches IO errors.
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

    /**
     * Add Part Method.
     * The method displays the add part form.
     * @throws IOException catches IO errors.
     */
    @FXML
    void onActionDisplayAddPartForm() throws IOException {
        displayNewScreen(addPartButton, "/View/AddPartForm.fxml", "Add Part Form");
    }

    //// Product Screen Methods ////

    /**
     * Delete Product Method.
     * Once the user selects an item to delete the method deletes the item, but it first displays
     * a confirmation message asking the user if they want to delete this product, with the option to cancel.
     * Also preforms a check if the product contains any associated parts, if it finds any it will prevent the user
     * from deleting that product, until they have disassociated those parts.
     */
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
            if(result.get() == ButtonType.OK) {
                // get user selected part
                Product selectedItem = productsTableView.getSelectionModel().getSelectedItem();

                // if the product has no associated parts, delete the product.
                // else display warning message stating you cannot delete
                if(selectedItem.getAllAssociatedParts().isEmpty()){
                    Inventory.deleteProduct(selectedItem);
                }else {
                    Alert associatedPartsFound = new Alert(Alert.AlertType.WARNING);
                    associatedPartsFound.setTitle("Warning Dialog");
                    associatedPartsFound.setHeaderText("Associated parts found");
                    associatedPartsFound.setContentText("The Product you are trying to delete has associated parts \n" +
                            "please remove the parts first then delete the product");
                    associatedPartsFound.showAndWait();
                }

            } else {
                return;
            }
        }
    }

    /**
     * Modify Product Method.
     * Once the user selects an item to modify, the modify product screen loads with the data
     * for that object populated in the text fields.
     * @throws IOException catches IO errors.
     */
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

    /**
     * Add Product Method.
     * The method displays the add product form.
     * @throws IOException catches IO errors.
     */
    @FXML
    void onActionDisplayAddProductForm() throws IOException {
       displayNewScreen(addProductButton, "/View/AddProductForm.fxml", "Product Form");
    }

    /**
     * Initialize Method.
     * This method is from the interface Initializable, and is overridden here.
     * The method is loaded(initialized) when this controller gets called.
     * It contains instructions to set TableViews with the data that they will be working with.
     */
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

