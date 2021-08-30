package Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Inventory Class, contains static methods and fields.
 * Contains two observable array list parts and products
 * with methods to access and modify those list.
 */
public class Inventory {
    private static ObservableList<Part> allParts = FXCollections.observableArrayList();
    private static ObservableList<Product> allProducts = FXCollections.observableArrayList();

    /**
     * Adds a part to the ObservableList.
     * @param newPart the part to be added
     */
   public static void addPart(Part newPart){
       allParts.add(newPart);
   }

    /**
     * Adds a product to the ObservableList.
     * @param newProduct the product to be added
     */
   public static void addProduct(Product newProduct) {
       allProducts.add(newProduct);
   }

    /**
     * Finds a part object in the ObservableList.
     * @param partId Part objects ID
     * @return the Part object if found matching ID
     */
   public static Part lookupPart(int partId) {
       for (Part item : allParts) {
           if(item.getId() == partId)
               return item;
       }
       return null;
   }
    /**
     * Finds a product object in the ObservableList.
     * @param productId Product objects ID
     * @return the Product object if found matching ID
     */
   public static Product lookupProduct(int productId) {
       for (Product item : allProducts) {
           if(item.getId() == productId)
               return item;
       }
       return null;
   }
    /**
     * Finds a part object in the ObservableList.
     * @param partName Part objects name
     * @return the Part observableArrayList if found matching name
     */
   public static ObservableList<Part> lookupPart(String partName) {
       for (Part item : allParts) {
           if(item.getName().equals(partName))
               return allParts;
       }
       return null;
   }

    /**
     * Finds a product object in the ObservableList.
     * @param productName Products objects name
     * @return the Products observableArrayList if found matching name
     */
   public static ObservableList<Product> lookupProduct(String productName) {
       for (Product item : allProducts) {
           if(item.getName().equals(productName))
               return allProducts;
       }
       return null;
   }

    /**
     * Replaces the ObservableList Part with the newly changed part.
     * @param index the location of the part
     * @param selectedPart the modified Part object passed in
     */
   public static void updatePart(int index, Part selectedPart) {
      allParts.set(index, selectedPart);
   }

    /**
     * Replaces the ObservableList Product with the newly changed product.
     * @param index the location of the product
     * @param newProduct the modified Product object passed in
     */
   public static void updateProduct(int index, Product newProduct){
       allProducts.set(index, newProduct);
   }

    /**
     * Deletes the selected part from the observableArrayList of Parts.
     * @param selectedPart the object to be deleted
     * @return
     */
   public static boolean deletePart(Part selectedPart) {
       //loop through to find part????
       allParts.remove(selectedPart);
       return false;
   }

    /**
     * Deletes the Product from the observableArrayList of Products.
     * @param selectedProduct the object to be deleted
     * @return
     */
   public static boolean deleteProduct(Product selectedProduct) {
       //loop through to find product????
       allProducts.remove(selectedProduct);
       return false;
   }

    /**
     * @return the observableArrayList of Parts
     */
   public static ObservableList<Part> getAllParts(){
       return allParts;
   }

    /**
     * @return the observableArrayList of Products
     */
   public static ObservableList<Product> getAllProducts() {
       return allProducts;
   }

}
