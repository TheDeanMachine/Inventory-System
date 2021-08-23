package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;
import java.io.IOException;

public abstract class SuperController {

    // Super Method for switching screens on button clicks
    public void displayNewScreen(ActionEvent event, String locationString ) throws IOException {
        Stage stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource(locationString));
        stage.setScene(new Scene(root));
        stage.show();
    }

    // Super Method for switching screens on toggle group button
    public void displayNewToggleGroup(ActionEvent event, String locationString ) throws IOException {
        Stage stage = (Stage)((RadioButton)event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource(locationString));
        stage.setScene(new Scene(root));
        stage.show();
    }
}
