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


    // Tests if a string is numeric
    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


//
//    // Overloaded super method for switching screens on button clicks
//    public void displayNewScreen(Node node, String locationString, String setTitle, Part selectedPart) throws IOException {
//        // load the screen
//        FXMLLoader loader = new FXMLLoader(getClass().getResource(locationString));
//        root = loader.load(); // initialize the next controller
//
//        // pass the data to controller
//        ModifyPartFormController passData = loader.getController();
//        passData.holdData(selectedPart);
//
//        // display the new scene
//        stage = (Stage)(node).getScene().getWindow();
//        stage.setScene(new Scene(root));
//        stage.setTitle(setTitle);
//        stage.show();
//    }
}
