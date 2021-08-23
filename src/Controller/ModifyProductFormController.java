package Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import java.io.IOException;

public class ModifyProductFormController extends SuperController {

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


    /// Product Form TableViews Fields fx:id ///
    @FXML
    private TableView<?> partsTableView1;

    @FXML
    private TableColumn<?, ?> partIdColumn1;

    @FXML
    private TableColumn<?, ?> partNameColumn1;

    @FXML
    private TableColumn<?, ?> partInventoryColumn1;

    @FXML
    private TableColumn<?, ?> partPriceColumn1;

    @FXML
    private TableView<?> partsTableView2;

    @FXML
    private TableColumn<?, ?> partIdColumn2;

    @FXML
    private TableColumn<?, ?> partNameColumn2;

    @FXML
    private TableColumn<?, ?> partInventoryColumn2;

    @FXML
    private TableColumn<?, ?> partPriceColumn2;

    /// Product Form Button Fields fx:id ///
    @FXML
    private Button addPartButton;

    @FXML
    private Button removePartButton;

    @FXML
    private Button cancelButton;

    @FXML
    private Button SaveButton;

    /// Product Form TextArea Fields fx:id ///
    @FXML
    private TextArea productTxtArea;


    /// Product Form change screen methods
    @FXML
    void onActionCancelDisplayMainScreen(ActionEvent event) throws IOException {
        displayNewScreen(event, "/View/MainScreen.fxml");
    }

    @FXML
    void onActionSaveDisplayMainScreen(ActionEvent event) throws IOException {
        displayNewScreen(event, "/View/MainScreen.fxml");
    }

    /// Product Form Add/Remove Associated part methods
    @FXML
    void onActionAddPart(ActionEvent event) {

    }

    @FXML
    void onActionRemovePart(ActionEvent event) {

    }

}

