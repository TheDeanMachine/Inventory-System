package Model;

/**
 * InHouse Class creates InHouse objects.
 */
public class InHouse extends Part {

    private int machineId;

    // constructor
    public InHouse(int id, String name, double price, int stock, int min, int max, int machineId) {
        super(id, name, price, stock, min, max);
        this.machineId = machineId;
    }

    /**
     * Sets the machine id value.
     * @param machineId the value to be set.
     */
    public void setMachineId(int machineId) {
        this.machineId = machineId;
    }

    /**
     * Gets the machine id value.
     * @return the machine id value.
     */
    public int getMachineId() {
        return machineId;
    }

}
