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
                = LAUNCH_EXPLOSION_U1 * this.getCurrentWeight() / this.getMaxWeight();

        // The probability of a successful launch
        double probabilityOfSuccessfulLaunch = 1.0 - chanceOfLaunchExplosion;

        // new Random().nextDouble() returns uniformly distributed double value between 0.0 and 1.0.
        double randomNumber = new Random().nextDouble();

        // Returns true or false based on a random number.
        if (randomNumber < probabilityOfSuccessfulLaunch) {
            System.out.println("U-1 Rocket successfully launched!");
            return true;
        } else {
            System.out.println("U-1 Rocket exploded while launching...");
            return false;
        }
    }

    /**
     * Returns true if the landing was successful based on the actual probability
     */
    @Override
    public boolean land() {
        // Calculate the chance of crashing while landing
        double chanceOfLandingCrash
                = LANDING_CRASH_U1 * this.getCurrentWeight() / this.getMaxWeight();

        // The probability of a successful landing
        double probabilityOfSuccessfulLanding = 1.0 - chanceOfLandingCrash;

        // new Random.nextDouble() returns uniformly distributed double value between 0.0 and 1.0
        double randomNumber = new Random().nextDouble();

        // Returns true or false based on a random number.
        if (randomNumber < probabilityOfSuccessfulLanding) {
            System.out.println("U-1 Rocket successfully landed!");
            return true;
        } else {
            System.out.println("U-1 Rocket crashed while landing...");
            return false;
        }
    }
}
