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
        InHouse part1 = new InHouse(35, "Handle Bars", 99, 2,1, 10, 22);
        InHouse part2 = new InHouse(53, "Grips", 34, 8,1, 56, 22);
        InHouse part3 = new InHouse(8, "Brakes", 229, 2,1, 10, 22);
        InHouse part4 = new InHouse(101, "Wheels", 289, 4,1, 30, 22);
        InHouse part5 = new InHouse(15, "Saddle", 159, 8,1, 25, 22);
        InHouse part6 = new InHouse(102, "Tires", 60.30, 112,1, 200, 22);

        Inventory.getAllParts().addAll(part1, part2, part3, part4, part5, part6);

        // Launch JavaFx
        launch(args);
    }
}
