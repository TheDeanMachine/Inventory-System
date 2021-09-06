package Controller;

import Model.InHouse;
import Model.Inventory;
import Model.Outsourced;
import Model.Product;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The Main Class.
 * Creates an inventory management application with parts and products.
 */
public class Main extends Application {

    /**
     * The start method.
     * This is an overridden method that is implemented through the application class, starts JavaFX.
     * @param primaryStage The main stage
     * @throws Exception Catches IO Errors
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/View/MainScreen.fxml"));
        primaryStage.setTitle("Main Screen");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    /**
     * The main method.
     * Contains preloaded objects for part and product.
     * @param args Contains the code for the main method.
     */
    public static void main(String[] args) {

        // Add initial data to the parts TableView
        InHouse part1 = new InHouse(1, "Handle Bars", 99, 2,1, 10, 22);
        InHouse part2 = new InHouse(2, "Grips", 34, 18,1, 56, 22);
        InHouse part3 = new InHouse(3, "Brakes", 229, 2,1, 10, 22);
        InHouse part4 = new InHouse(4, "Wheels", 289, 14,1, 30, 22);
        InHouse part5 = new InHouse(5, "Saddle", 159, 8,1, 25, 22);
        InHouse part6 = new InHouse(6, "Tires", 60.30, 112,1, 200, 22);
        Outsourced part7 = new Outsourced(7,"Fox 38 Fork", 1139, 1,1,10, "Fox");
        Outsourced part8 = new Outsourced(8,"Fox DPX2 Suspension", 679, 1,1,10, "Fox");
        Inventory.getAllParts().addAll(part1, part2, part3, part4, part5, part6, part7, part8);

        // Add initial data to the products TableView
        Product product1 = new Product(1, "Yeti", 4999, 2, 1,5);
        Product product2 = new Product(2, "Kona", 3999, 1, 1,5);
        Product product3 = new Product(3, "Rocky Mountain", 6596, 5, 1,5);
        Product product4 = new Product(4, "Santa Cruz", 5149, 3, 1,5);
        Inventory.getAllProducts().addAll(product1, product2, product3, product4);

        // Launch JavaFx
        launch(args);
    }
}
