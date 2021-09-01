package Controller;

import Model.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
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

    /// Product Form TextArea Fields fx:id ///
    @FXML
    private TextArea productTxtArea;


    @FXML
    void onActionSearchParts(ActionEvent event) {
    }



    /// Product Form change screen methods
    @FXML
    void onActionSaveDisplayMainScreen() throws IOException {

        // Get Input from user
        int id = Integer.parseInt(productIdTxt.getText());
        String name = productNameTxt.getText();
        double price = Double.parseDouble(productPriceTxt.getText());
        int stock = Integer.parseInt(productInvTxt.getText());
        int min = Integer.parseInt(productMinTxt.getText());
        int max = Integer.parseInt(productMaxTxt.getText());

        // get the items index
        int index = Inventory.getAllProducts().indexOf(item);

        // updated the product item
        Product newPart = new Product(id, name, price, stock, min, max);
        Inventory.updateProduct(index, newPart);

        displayNewScreen(saveButton, "/View/MainScreen.fxml", "Main Screen");
    }

    @FXML
    void onActionCancelDisplayMainScreen() throws IOException {
       displayNewScreen(cancelButton, "/View/MainScreen.fxml", "Main Screen");
    }

    /// Product Form Add/Remove Associated part methods
    @FXML
    void onActionAddPart(ActionEvent event) {

    }

    @FXML
    void onActionRemovePart(ActionEvent event) {

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

        /////////// set the form with the user selected objects value
        productIdTxt.setText(String.valueOf(item.getId()));
        productNameTxt.setText(item.getName());
        productInvTxt.setText(String.valueOf(item.getStock()));
        productPriceTxt.setText(String.valueOf(item.getPrice()));
        productMaxTxt.setText(String.valueOf(item.getMax()));
        productMinTxt.setText(String.valueOf(item.getMin()));

    }
}

