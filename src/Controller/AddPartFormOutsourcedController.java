package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.io.IOException;

public class AddPartFormOutsourcedController {

    //// Part Form Fields ////
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
    private TextField companyTxt;

    //// Toggle Group ////
    @FXML
    private ToggleGroup partFormToggle;

    @FXML
    private RadioButton inHouseToggle;

    @FXML
    private RadioButton outSourcedToggle;


    //// Buttons ////
    @FXML
    private Button cancelButton;

    @FXML
    private Button addInventoryButton;


    //// Part Form Methods ///
    @FXML
     void onActionAddDisplayMainScreen(ActionEvent event) throws IOException {
        Stage stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/View/MainScreen.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    void onActionCancelDisplayMainScreen(ActionEvent event) throws IOException {
        Stage stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/View/MainScreen.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    void onActionDisplayInHousePartForm(ActionEvent event) throws IOException {
        Stage stage = (Stage)((RadioButton)event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/View/AddPartFormInHouse.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }

}

