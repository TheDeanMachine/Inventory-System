package Controller;

/**
 * The Main Screen Class
 * Displays two screens, one for parts and one for products
 */

import Model.Inventory;
import Model.Part;
import Model.Product;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.Scene;
import java.io.IOException;
import java.net.URL;
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


    //// Part Screen Methods ////
    @FXML
    void onActionDeletePart(ActionEvent event) {

    }



    @FXML
    void onActionDisplayModifyPartForm() throws IOException {
        // get user selected part
        Part selectedItem = partsTableView.getSelectionModel().getSelectedItem();
        ModifyPartFormController.holdData(selectedItem);

        displayNewScreen(modifyPartButton, "/View/ModifyPartForm.fxml", "Modify Part Form");


        // call the overloaded display method passing the selected item
        //displayNewScreen(modifyPartButton, "/View/ModifyPartForm.fxml", "Modify Part Form", selectedItem);
    }

    @FXML
    void onActionDisplayAddPartForm() throws IOException {
        displayNewScreen(addPartButton, "/View/AddPartForm.fxml", "Add Part Form");
    }


    //// Product Screen Methods ////
    @FXML
    void onActionDeleteProduct(ActionEvent event) {

    }

    @FXML
    void onActionDisplayModifyProductForm() throws IOException {
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

