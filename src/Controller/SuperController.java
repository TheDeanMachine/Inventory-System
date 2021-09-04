package Controller;

import Model.Part;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import java.io.IOException;


public abstract class SuperController {
    // Reference Variables
    private Stage stage;
    private Parent root;
    private static int uniqueID = 10;

    // Super Method for switching screens on button clicks
    public void displayNewScreen(Node node, String locationString, String setTitle) throws IOException {
        stage = (Stage)(node).getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource(locationString));
        stage.setScene(new Scene(root));
        stage.setTitle(setTitle);
        stage.show();
    }

    // generates an id for parts/products
    public static int generateID(){
        uniqueID++;
        return uniqueID;
    }

}
