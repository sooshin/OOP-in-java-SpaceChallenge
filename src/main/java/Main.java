import java.util.ArrayList;

public class Main {

    public static void main(String [] args) {
        // Create a Simulation object
        Simulation simulation = new Simulation();

        // ############################### For U1 rockets ######################################
        System.out.println("############### The way to load items on each U1 rocket ###############");
        // Load Items for Phase-1
        ArrayList<Item> itemsForU1Phase1 = simulation.loadItems("phase-1.txt");
        // Load Items for Phase-2
        ArrayList<Item> itemsForU1Phase2 = simulation.loadItems("phase-2.txt");

        // Load a fleet of U1 rockets for Phase-1
        ArrayList<Rocket> u1RocketsForPhase1 = simulation.loadU1(itemsForU1Phase1);
        System.out.println("The minimum number of u1 rockets for Phase-1: " + u1RocketsForPhase1.size());

        // Load a fleet of U1 rockets for Phase-2
        ArrayList<Rocket> u1RocketsForPhase2 = simulation.loadU1(itemsForU1Phase2);
        System.out.println("The minimum number of u1 rockets for Phase-2: " + u1RocketsForPhase2.size());

        System.out.println("####################### Run the simulation #############################");

        // The total budget required to send all rockets including the crashed ones
        int budgetForU1Phase1 = simulation.runSimulation(u1RocketsForPhase1);
        System.out.println("The total budget required to send all U1 rockets for Phase-1: $" + budgetForU1Phase1);

        int budgetForU1Phase2 = simulation.runSimulation(u1RocketsForPhase2);
        System.out.println("The total budget required to send all U1 rockets for Phase-2: $" + budgetForU1Phase2);

        // ############################### For U2 rockets ######################################
        System.out.println("############### The way to load items on each U2 rocket ###############");
        // Load Items for Phase-1
        ArrayList<Item> itemsForU2Phase1 = simulation.loadItems("phase-1.txt");
        // Load Items for Phase-2
        ArrayList<Item> itemsForU2Phase2 = simulation.loadItems("phase-2.txt");

        // Load a fleet of U2 rockets for Phase-1
        ArrayList<Rocket> u2RocketsForPhase1 = simulation.loadU2(itemsForU2Phase1);
        System.out.println("The minimum number of u2 rockets for Phase-1: " + u2RocketsForPhase1.size());

        // Load a fleet of U2 rockets for Phase-2
        ArrayList<Rocket> u2RocketsForPhase2 = simulation.loadU2(itemsForU2Phase2);
        System.out.println("The minimum number of u2 rockets for Phase-2: " + u2RocketsForPhase2.size());

        System.out.println("####################### Run the simulation #############################");

        // The total budget required to send all rockets including the crashed ones
        int budgetForU2Phase1 = simulation.runSimulation(u2RocketsForPhase1);
        System.out.println("The total budget required to send all U2 rockets for Phase-1: $" + budgetForU2Phase1);

        int budgetForU2Phase2 = simulation.runSimulation(u2RocketsForPhase2);
        System.out.println("The total budget required to send all U2 rockets for Phase-2: $" + budgetForU2Phase2);
    }
}
