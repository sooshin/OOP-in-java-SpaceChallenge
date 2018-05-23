/**
 * An Item class represent an item to be carried by the rockets.
 * It contains a String name and an int weight for that item.
 */
public class Item {

    private String name;
    private int weight;

    /**
     * Construct a new Item object.
     *
     * @param name is the name of the item
     * @param weight is the weight of the item
     */
    public Item (String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    /**
     * Returns the name of the item.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the weight of the item.
     */
    public int getWeight() {
        return weight;
    }
}
