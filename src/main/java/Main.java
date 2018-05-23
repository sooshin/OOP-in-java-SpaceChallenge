import java.util.ArrayList;

public class Main {

    public static void main(String [] args) {
        Simulation simulation = new Simulation();
        ArrayList<Item> items = simulation.loadItems("phase-1.txt");
        ArrayList<Rocket> u1Rockets = simulation.loadU1(items);
        System.out.println("The number of u1 rockets(phase-1): " + u1Rockets.size());

        Simulation simulation2 = new Simulation();
        ArrayList<Item> items2 = simulation2.loadItems("phase-1.txt");
        ArrayList<Rocket> u2Rockets = simulation2.loadU2(items2);
        System.out.println("The number of u2 rockets(phase-1): " + u2Rockets.size());

        Simulation simulation3 = new Simulation();
        ArrayList<Item> items3 = simulation3.loadItems("phase-2.txt");
        ArrayList<Rocket> u1Rockets3 = simulation3.loadU1(items3);
        System.out.println("The number of u1 rockets(phase-2): " + u1Rockets3.size());

        Simulation simulation4 = new Simulation();
        ArrayList<Item> items4 = simulation4.loadItems("phase-2.txt");
        ArrayList<Rocket> u2Rockets4 = simulation4.loadU2(items4);
        System.out.println("The number of u2 rockets(phase-2): " + u2Rockets4.size());

        System.out.println(simulation.runSimulation(u1Rockets));
        System.out.println(simulation.runSimulation(u2Rockets));
    }


}
