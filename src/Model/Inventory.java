package Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Inventory {

    private static ObservableList<Part> allParts = FXCollections.observableArrayList();
    private static ObservableList<Product> allProducts = FXCollections.observableArrayList();


   public static void addPart(Part newPart){
       allParts.add(newPart);
   }

   public static void addProduct(Product newProduct) {
       allProducts.add(newProduct);
   }

   public static Part lookupPart(int partId) {
       for (Part item : allParts) {
           if(item.getId() == partId)
               return item;
       }
       return null;
   }

   public static Product lookupProduct(int productId) {
       for (Product item : allProducts) {
           if(item.getId() == productId)
               return item;
       }
       return null;
   }

   public static ObservableList<Part> lookupPart(String partName) {
       for (Part item : allParts) {
           if(item.getName().equals(partName))
               return allParts;
       }
       return null;
   }


   public static ObservableList<Product> lookupProduct(String productName) {
       for (Product item : allProducts) {
           if(item.getName().equals(productName))
               return allProducts;
       }
       return null;
   }

   public static void updatePart(int index, Part selectedPart) {
      allParts.set(index, selectedPart);
   }

   public static void updateProduct(int index, Product newProduct){
       allProducts.set(index, newProduct);
   }

   public static boolean deletePart(Part selectedPart) {
       //loop through to find part????
       allParts.remove(selectedPart);
       return false;
   }

   public static boolean deleteProduct(Product selectedProduct) {
       //loop through to find product????
       allProducts.remove(selectedProduct);
       return false;
   }

   public static ObservableList<Part> getAllParts(){
       return allParts;
   }

   public static ObservableList<Product> getAllProducts() {
       return allProducts;
   }

}
