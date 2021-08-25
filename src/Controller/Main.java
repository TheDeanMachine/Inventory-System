package Controller;

import Model.InHouse;
import Model.Inventory;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/View/MainScreen.fxml"));
        primaryStage.setTitle("Main Screen");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args) {

        // Add initial data to the TableView
        InHouse part1 = new InHouse(1, "Handle Bars", 99, 2,1, 10, 22);
        Inventory.addPart(part1);

        // Launch JavaFx
        launch(args);
    }
}
