package Model;

/**
 * Outsourced Class creates Outsourced objects.
 */
public class Outsourced extends Part {

    private String companyName;

    // constructor
    public Outsourced(int id, String name, double price, int stock, int min, int max, String companyName) {
        super(id, name, price, stock, min, max);
        this.companyName = companyName;
    }

    /**
     * Sets the company name.
     * @param companyName the value to be set
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * Returns company name value.
     * @return the company name value
     */
    public String getCompanyName() {
        return companyName;
    }

}
