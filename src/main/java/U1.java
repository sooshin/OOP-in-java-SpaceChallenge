import java.util.Random;

public class U1 extends Rocket {

    /** Constant for the chance of launch explosion */
    private static final double LAUNCH_EXPLOSION_U1 = 5.0 / 100;

    /** Constant for the chance of landing crash */
    private static final double LANDING_CRASH_U1 = 1.0 / 100;

    /** Constant for converting Tonnes to Kilograms */
    private static final int TON_TO_KG = 1000;

    /**
     * Constructs a new U1 object.
     * U-1 Rocket costs $100 Million to build.
     * It weighs 10 Tonnes and can only carry a total of 18 tonnes of cargo.
     */
    public U1() {
        super(100, 10 * TON_TO_KG, 18 * TON_TO_KG);
    }

    /**
     * Returns true if the launch was successful based on the actual probability
     */
    @Override
    public boolean launch() {
        // Calculates the chance of exploding while launching
        double chanceOfLaunchExplosion
                = LAUNCH_EXPLOSION_U1 * (this.getCurrentWeight() / this.getMaxWeight());

        System.out.println(1.0 - chanceOfLaunchExplosion);
        System.out.println("Random number: " + new Random().nextDouble());

        // Returns true or false based on a random number.
        // 'new Random().nextDouble()' returns uniformly distributed double value between 0.0 and 1.0.
        // '1.0 - chanceOfLaunchExplosion' is the probability of a successful launch
        return new Random().nextDouble() < 1.0 - chanceOfLaunchExplosion;
    }

    /**
     * Returns true if the landing was successful based on the actual probability
     */
    @Override
    public boolean land() {
        // Calculate the chance of crashing while landing
        double chanceOfLandingCrash
                = LANDING_CRASH_U1 * (this.getCurrentWeight() / this.getMaxWeight());

        // Returns true or false based on a random number.
        // 'new Random.nextDouble()' returns uniformly distributed double value between 0.0 and 1.0
        // '1.0 - chanceOfLadingCrash' is the probability of a successful landing
        return new Random().nextDouble() < 1.0 - chanceOfLandingCrash;
    }

    /**
     * Print message to indicate the launching was successful or not
     */
    public void printLaunch() {
        if (launch()){
            System.out.println("U-1 Rocket successfully launched!");
        } else {
            System.out.println("U-1 Rocket exploded while launching...");
        }
    }

    /**
     * Print message to indicate the landing was successful or not
     */
    public void printLand() {
        if (land()) {
            System.out.println("U-1 Rocket successfully landed!");
        } else {
            System.out.println("U-1 Rocket crashed while landing...");
        }
    }
}
