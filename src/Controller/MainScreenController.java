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

public class MainScreenController {

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

    @FXML
    private Button deletePartButton;

    @FXML
    private Button modifyPartButton;

    @FXML
    private Button addPartButton;


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
    private Button modifyProductButton;

    @FXML
    private Button addProductButton;

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
    void onActionDisplayModifyPartForm(ActionEvent event) {

    }

    @FXML
    void onActionDisplayAddPartForm(ActionEvent event) throws IOException {
        Stage stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/View/AddPartFormInHouse.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }


    //// Product Methods ////

    @FXML
    void onActionDeleteProduct(ActionEvent event) {

    }

    @FXML
    void onActionDisplayModifyProductForm(ActionEvent event) {

    }

    @FXML
    void onActionDisplayAddProductForm(ActionEvent event) {

    }







}

