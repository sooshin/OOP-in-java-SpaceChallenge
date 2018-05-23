/**
 * A Rocket class that implements the SpaceShip Interface includes the information related to a rocket.
 */
public class Rocket implements SpaceShip {

    /** Cost of the rocket */
    private int rocketCost;

    /** Weight of the rocket */
    private int rocketWeight;

    /** Current weight of the rocket */
    private int currentWeight;

    /** Max weight (with cargo) of the rocket */
    private int maxWeight;

    /**
     * Constructs a new Rocket object.
     *
     * @param rocketCost is the cost of the rocket
     * @param rocketWeight is the weight of the rocket
     * @param maxWeight is the max weight of the rocket with cargo
     */
    public Rocket(int rocketCost, int rocketWeight, int maxWeight) {
        this.rocketCost = rocketCost;
        this.rocketWeight = rocketWeight;
        this.maxWeight = maxWeight;
        this.currentWeight = rocketWeight;
    }

    /**
     * Returns the cost of the rocket
     */
    public int getRocketCost() {
        return rocketCost;
    }

    /**
     * Returns the current weight of the rocket
     */
    public int getCurrentWeight() {
        return currentWeight;
    }

    /**
     * Returns the max weight (with cargo) of the rocket
     */
    public int getMaxWeight() {
        return maxWeight;
    }

    /**
     * Returns always true
     */
    @Override
    public boolean launch() {
        return true;
    }

    /**
     * Returns always true
     */
    @Override
    public boolean land() {
        return true;
    }

    /**
     * Returns true if the rocket can carry such item or false if it will exceed the weight limit.
     */
    @Override
    public final boolean canCarry(Item item) {
        return maxWeight >= currentWeight + item.getWeight();
    }

    /**
     * Updates the current weight of the rocket.
     */
    @Override
    public final void carry(Item item) {
        currentWeight += item.getWeight();
        System.out.println("Item carried: " + item.getName() + " " + item.getWeight());
    }

    /**
     * Gets the free space available on the rocket.
     */
    public int getFreeSpace() {
        return maxWeight - currentWeight;
    }
}
