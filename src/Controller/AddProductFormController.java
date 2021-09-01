package Controller;

import Model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class AddProductFormController extends SuperController implements Initializable {

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
    public Button addInventoryButton;

    /// Product Form TextArea Fields fx:id ///
    @FXML
    private TextArea productTxtArea;



    @FXML
    void onActionSearchParts(ActionEvent event) {

        // get the users input
        String item = partSearchTxt.getText();
        // create an empty list to hold the results
        ObservableList<Part> foundParts = FXCollections.observableArrayList();

        // search based on numeric or string input
        if (isNumeric(item)) {
            int anInt = Integer.parseInt(partSearchTxt.getText());
            Part itemReturned = Inventory.lookupPart(anInt);
            foundParts.add(itemReturned);
        } else {
            foundParts = Inventory.lookupPart(item);
        }

        // set the TableView with the found items
        partsTableView1.setItems(foundParts);
    }


    /// Product Form change screen methods
    @FXML
    void onActionAddDisplayMainScreen() throws IOException {

        // Get Input from user
        //int id = Integer.parseInt(productIdTxt.getText());
        int id = generateID();
        String name = productNameTxt.getText();
        double price = Double.parseDouble(productPriceTxt.getText());
        int stock = Integer.parseInt(productInvTxt.getText());
        int min = Integer.parseInt(productMinTxt.getText());
        int max = Integer.parseInt(productMaxTxt.getText());

        // Create the product and add it to product list
        Product newProduct = new Product(id, name, price, stock, min, max);
        Inventory.addProduct(newProduct);

       displayNewScreen(addInventoryButton, "/View/MainScreen.fxml", "Main Screen");
    }

    @FXML
    void onActionCancelDisplayMainScreen() throws IOException {
       displayNewScreen(cancelButton, "/View/MainScreen.fxml", "Main Screen");
    }

    /// Product Form Add/Remove Associated part methods
    @FXML
    void onActionAddPart(ActionEvent event) {
        Part selectedItem = partsTableView1.getSelectionModel().getSelectedItem();
        Product tempProduct = new Product(0, "", 0, 0, 0, 0);
        tempProduct.addAssociatedPart(selectedItem);

        partsTableView2.setItems(tempProduct.getAllAssociatedParts());

        partIdColumn2.setCellValueFactory(new PropertyValueFactory<>("id"));
        partNameColumn2.setCellValueFactory(new PropertyValueFactory<>("name"));
        partInventoryColumn2.setCellValueFactory(new PropertyValueFactory<>("stock"));
        partPriceColumn2.setCellValueFactory(new PropertyValueFactory<>("price"));

    }

    @FXML
    void onActionRemovePart(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //generateID();

        // set the parts' tableview with the data it will be working with
        partsTableView1.setItems(Inventory.getAllParts());

        // set the columns with the data
        partIdColumn1.setCellValueFactory(new PropertyValueFactory<>("id"));
        partNameColumn1.setCellValueFactory(new PropertyValueFactory<>("name"));
        partInventoryColumn1.setCellValueFactory(new PropertyValueFactory<>("stock"));
        partPriceColumn1.setCellValueFactory(new PropertyValueFactory<>("price"));


//
//         //set the second parts' tableview with the data it will be working with
//        partsTableView2.setItems(tempProduct.getAllAssociatedParts());
//
//        // set the columns with the data
//        partIdColumn2.setCellValueFactory(new PropertyValueFactory<>("id"));
//        partNameColumn2.setCellValueFactory(new PropertyValueFactory<>("name"));
//        partInventoryColumn2.setCellValueFactory(new PropertyValueFactory<>("stock"));
//        partPriceColumn2.setCellValueFactory(new PropertyValueFactory<>("price"));


    }

    ////////////////////////
    //get the users' selection
    //on button click do the following
        ///associate with a product -- ie add to observable list, but a product is a list already
        ///then display it the in second window --in order to display needs to be observable list
    // be able to remove it as well




}

