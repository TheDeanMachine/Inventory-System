package Controller;


/**
 * The Main Screen Class
 * Displays two screens, one for parts and one for products
 */

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import java.io.IOException;

public class MainScreenController extends SuperController {

    ///// Parts Screen Fields /////

    @FXML
    private TextField searchPartTxt;

    @FXML
    private TableView<?> partsTableView;

    @FXML
    private TableColumn<?, ?> partIdColumn;

    @FXML
    private TableColumn<?, ?> partNameColumn;

    @FXML
    private TableColumn<?, ?> partInventoryColumn;

    @FXML
    private TableColumn<?, ?> partPriceColumn;

    /// Buttons

    @FXML
    private Button deletePartButton;

    @FXML
    public Button modifyPartButton;

    @FXML
    private Button addPartButton;

    public Button getAddPartButton(){
        return addPartButton;
    }


    //// Product Screen Fields ////

    @FXML
    private TextField searchProductTxt;

    @FXML
    private TableView<?> productsTableView;

    @FXML
    private TableColumn<?, ?> productIdColumn;

    @FXML
    private TableColumn<?, ?> productNameColumn;

    @FXML
    private TableColumn<?, ?> productInventoryColumn;

    @FXML
    private TableColumn<?, ?> productPriceColumn;

    @FXML
    private Button deleteProductButton;

    @FXML
    public Button modifyProductButton;

    @FXML
    public Button addProductButton;

    /// Exit Button ///
    @FXML
    private Button exitButton;

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
        displayNewScreen(modifyPartButton, "/View/ModifyPartFormInHouse.fxml", "Modify Part Form");
    }

    @FXML
    void onActionDisplayAddPartForm() throws IOException {
        displayNewScreen(getAddPartButton(), "/View/AddPartForm.fxml", "Add Part Form");
    }


    //// Product Methods ////
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







}

