package Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * The Product Class creates product objects.
 */
public class Product {

    ///Fields
    private final ObservableList<Part> associatedParts = FXCollections.observableArrayList();
    private int id;
    private String name;
    private double price;
    private int stock;
    private int min;
    private int max;

    //Constructor
    public Product(int id, String name, double price, int stock, int min, int max) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.min = min;
        this.max = max;
    }

    //Setters
    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @param stock the stock to set
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * @param min the min to set
     */
    public void setMin(int min) {
        this.min = min;
    }

    /**
     * @param max the max to set
     */
    public void setMax(int max) {
        this.max = max;
    }


    //Getters
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @return the stock
     */
    public int getStock() {
        return stock;
    }

    /**
     * @return the min
     */
    public int getMin() {
        return min;
    }


    /**
     * @return the max
     */
    public int getMax() {
        return max;
    }

    /**
     * Adds a part to the associated parts list.
     * @param part the part to be added
     */
    public void addAssociatedPart(Part part) {
        associatedParts.add(part);
    }

    /**
     * Deletes a part from the associated parts list.
     * @param selectedAssociatedPart the part to be deleted
     * @return true if deleted, else return false
     */
    public boolean deleteAssociatedPart(Part selectedAssociatedPart) {
        if(associatedParts.remove(selectedAssociatedPart)){
            return true;
        }
        return false;
    }

    /**
     * Gets all the associated parts.
     * @return the associated parts list
     */
    public ObservableList<Part> getAllAssociatedParts() {
        return associatedParts;
    }

}
