package Controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;
import java.io.IOException;


public abstract class SuperController {
    // Reference Attributes
    Stage stage;
    Parent root;
    Node node;

    // Super Method for switching screens on button clicks
    public void displayNewScreen(Node node, String locationString, String setTitle ) throws IOException {
        //stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        stage = (Stage)(node).getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource(locationString));
        stage.setScene(new Scene(root));
        stage.setTitle(setTitle);
        stage.show();
    }

    // Super Method for switching screens on toggle group button
    public void displayNewToggleGroup(ActionEvent event, String locationString, String setTitle ) throws IOException {
        stage = (Stage)((RadioButton)event.getSource()).getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource(locationString));
        stage.setScene(new Scene(root));
        stage.setTitle(setTitle);
        stage.show();
    }
}
