import java.util.Random;

public class U2 extends Rocket {

    /** Constant for the chance of launch explosion */
    private static final double LAUNCH_EXPLOSION_U2 = 4.0 / 100;

    /** Constant for the chance of landing crash */
    private static final double LANDING_CRASH_U2 = 8.0 / 100;

    /** Constant for converting Tonnes to Kilograms */
    private static final int TON_TO_KG = 1000;

    /**
     * Constructs a new U2 object.
     * U-2 Rocket costs $120 Million to build.
     * It weighs 18 tonnes and can carry a total of 29 tonnes of cargo.
     */
    public U2() {
        super(120, 18 * TON_TO_KG, 29 * TON_TO_KG);
    }

    /**
     * Returns true if the launch was successful based on the actual probability
     */
    @Override
    public boolean launch() {
        // Calculates the chance of exploding while launching
        double chanceOfLaunchExplosion
                = LAUNCH_EXPLOSION_U2 * this.getCurrentWeight() / this.getMaxWeight();

        // The probability of a successful launch
        double probabilityOfSuccessfulLaunch = 1.0 - chanceOfLaunchExplosion;

        // new Random().nextDouble() returns uniformly distributed double value between 0.0 and 1.0.
        double randomNumber = new Random().nextDouble();

        // Returns true or false based on a random number.
        if (randomNumber < probabilityOfSuccessfulLaunch) {
            System.out.println("U-2 Rocket successfully launched!");
            return true;
        } else {
            System.out.println("U-2 Rocket exploded while launching... Send that rocket again");
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
                = LANDING_CRASH_U2 * this.getCurrentWeight() / this.getMaxWeight();

        // The probability of a successful landing
        double probabilityOfSuccessfulLanding = 1.0 - chanceOfLandingCrash;

        // new Random.nextDouble() returns uniformly distributed double value between 0.0 and 1.0
        double randomNumber = new Random().nextDouble();

        // Returns true or false based on a random number.
        if (randomNumber < probabilityOfSuccessfulLanding) {
            System.out.println("U-2 Rocket successfully landed!");
            return true;
        } else {
            System.out.println("U-2 Rocket crashed while landing... Send that rocket again");
            return false;
        }
    }
}
