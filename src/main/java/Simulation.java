import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Simulation class is responsible for reading item data and filling up the rockets.
 */
public class Simulation {

    /**
     * Loads all items from a text file and returns an ArrayList of Items.
     * Each line in the text file consists of the item name followed by = then its weigh in kg.
     * (e.g. habitat=3000)
     *
     * @param fileName a text file name
     */
    public ArrayList<Item> loadItems(String fileName) {
        File file = new File(fileName);
        ArrayList<Item> items = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine(); // Read the text file line by line
                String[] split = line.split("=");
                Item item = new Item(split[0], Integer.parseInt(split[1])); // Create an item object for each
                items.add(item); // Add the item to an ArrayList of Items
            }
        } catch (FileNotFoundException e) {
            System.out.println("Failed to find that file");
        }
        return items;
    }

    /**
     * This method tries to fill up 1 rocket with as many items as possible before creating a new rocket
     * and filling that one until all items are loaded.
     * Sort the ArrayList of Items in descending order by weight (heaviest item first).
     * Then, as long as the list is not empty, load the heaviest item on the rocket and remove it
     * in the ArrayList of Items. For the rest of items in the ArrayList of Items, find items which
     * can be loaded and also fill up the rocket. The item which loaded on the rocket is moved to the
     * itemCarriedList and remove those by using the removeAll method.
     *
     * @param items the ArrayList of Items returned from the loadItems method
     * @return the ArrayList of U1 rockets that are fully loaded
     */
    public ArrayList<Rocket> loadU1(ArrayList<Item> items) {
        // Sort the ArrayList of Items in descending order by weight
        items.sort(Comparator.comparingInt(Item::getWeight).reversed());

        // Create an ArrayList of Rockets. Since the runSimulation method takes an ArrayList of Rockets,
        // creating an ArrayList<U1> cause incompatible type error. As U1 class extends Rocket class,
        // this inheritance has allowed an object to become polymorphic.
        // Therefore we create ArrayList of Rockets, instead of creating ArrayList of U1.
        ArrayList<Rocket> u1Rockets = new ArrayList<>();

        // Creates an ArrayList of Items. When an item is loaded on the rocket, add it to this list.
        ArrayList<Item> itemCarriedList = new ArrayList<>();

        int rocketNumber = 0; // Keep track of the rocket number

        while (items.size() > 0) {
            U1 u1Rocket = new U1(); // Create the U1 rocket
            rocketNumber ++;
            System.out.println("u1Rocket " + rocketNumber);

            // First, make sure that the U1 rocket can carry the heaviest item on it, then load it.
            if (u1Rocket.canCarry(items.get(0))) {
                u1Rocket.carry(items.get(0)); // Carry the heaviest item
                items.remove(0); // Remove that item in the ArrayList of Items
            } else {
                // If there is an item that the U1 Rocket cannot carry, then remove it.
                items.remove(0);
            }

            // Get the ArrayList of Integers which consists of the weight of items.
            ArrayList<Integer> weightList = getWeightList(items);
            for (Item item: items) {
                // Calculate the free space supposing that an item is loaded
                int freeSpace = u1Rocket.getFreeSpace() - item.getWeight();

                // If there is no space in the rocket, terminate the loop immediately.
                if (u1Rocket.getFreeSpace() == 0) {
                    break;
                }

                // If the rocket can carry the item and fill up the rocket with as many items as possible,
                // carry the item and add it to the itemCarriedList.
                if (u1Rocket.canCarry(item) && fillUpFreeSpace(weightList, freeSpace)) {
                    u1Rocket.carry(item);
                    itemCarriedList.add(item);
                } else if (u1Rocket.canCarry(item) && items.size() == 1) {
                    // For the last item in the list, if the current rocket can carry that item,
                    // carry it not to create a new rocket.
                    u1Rocket.carry(item);
                    itemCarriedList.add(item);
                }
            }
            // Remove all items that are loaded
            items.removeAll(itemCarriedList);
            // Add U1 rocket that is fully loaded to the ArrayList of Rockets
            u1Rockets.add(u1Rocket);
        }
        return u1Rockets;
    }

    /**
     * This method tries to fill up 1 rocket with as many items as possible before creating a new rocket
     * and filling that one until all items are loaded. The same way as the loadU1 method is.
     *
     * @param items the ArrayList of Items returned from the loadItems method
     * @return the ArrayList of U2 rockets that are fully loaded
     */
    public ArrayList<Rocket> loadU2(ArrayList<Item> items) {
        // Sort the ArrayList of Items in descending order by weight
        items.sort(Comparator.comparingInt(Item::getWeight).reversed());

        // Create an ArrayList of Rockets.
        ArrayList<Rocket> u2Rockets = new ArrayList<>();

        // Creates an ArrayList of Items. When an item is loaded on the rocket, add it to this list.
        ArrayList<Item> itemCarriedList = new ArrayList<>();

        int rocketNumber = 0; // Keep track of the rocket number
        while (items.size() > 0) {
            U2 u2Rocket = new U2(); // Create the U2 rocket
            rocketNumber ++;
            System.out.println("u2Rocket " + rocketNumber);

            // First, make sure that the U2 rocket can carry the heaviest item on it, then load it.
            if (u2Rocket.canCarry(items.get(0))) {
                u2Rocket.carry(items.get(0)); // Carry the heaviest item
                items.remove(0); // Remove that item in the ArrayList of Items
            } else {
                // If there is an item that the U1 Rocket cannot carry, then remove it.
                items.remove(0);
            }

            // Get the ArrayList of Integers which consists of the weight of items.
            ArrayList<Integer> weightList = getWeightList(items);
            for (Item item: items) {
                // Calculate the free space supposing that an item is loaded
                int freeSpace = u2Rocket.getFreeSpace() - item.getWeight();

                // If there is no space in the rocket, terminate the loop immediately.
                if (u2Rocket.getFreeSpace() == 0) {
                    break;
                }

                // If the rocket can carry the item and fill up the rocket with as many items as possible,
                // carry the item and add it to the itemCarriedList.
                if (u2Rocket.canCarry(item) && fillUpFreeSpace(weightList, freeSpace)) {
                    u2Rocket.carry(item);
                    itemCarriedList.add(item);
                } else if (u2Rocket.canCarry(item) && items.size() == 1) {
                    // For the last item in the list, if the current rocket can carry that item,
                    // carry it not to create a new rocket.
                    u2Rocket.carry(item);
                    itemCarriedList.add(item);
                }
            }
            // Remove all items that are loaded
            items.removeAll(itemCarriedList);
            // Add U2 rocket that is fully loaded to the ArrayList of Rockets
            u2Rockets.add(u2Rocket);
        }
        return u2Rockets;
    }

    /**
     * Get the ArrayList of Integers which consists of the weight of items.
     *
     * @param items ArrayList of Items
     */
    private ArrayList<Integer> getWeightList(ArrayList<Item> items) {
        ArrayList<Integer> weightList = new ArrayList<>();
        for (Item item: items) {
            weightList.add(item.getWeight());
        }
        return weightList;
    }

     /**
     * Returns whether or not the sum of items combined in the weightList can make a value of the
     * freeSpace by using recursion.
     *
     * @param weightList ArrayList of Integers returned from the getWeightList method
     * @param freeSpace where you can load items on the rocket.
     * @return true if the rocket is full of items or if the sum of the weightList is equal to
     *          the free space, or the last item is left
     */
    private boolean fillUpFreeSpace(ArrayList<Integer> weightList, int freeSpace) {
        if (freeSpace == 0) {
            // If the rocket is full of items, return true.
            return true;
        } else if (sumItemWeight(weightList) == freeSpace) {
            // If the sum of items in the weightList is equal to the value of the freeSpace, return true.
            return true;
        }
        // Since this method use recursion, if the sum of combined items in the weightList cannot a value of
        // the freeSpace, return false without using recursion.
        if (weightList.isEmpty() || freeSpace > sumItemWeight(weightList) || freeSpace < Collections.min(weightList)) {
            return false;
        }

        // As items in the weightList as an argument are already sorted, the first item is the heaviest one.
        while (weightList.size() > 0) {
            // The rocket carries the heaviest one first and we consider the rest of items, so remove it from the list.
            int itemWeight = weightList.get(0);
            weightList.remove(0);

            // If there is a weight corresponding to the difference between the free space and
            // the weight of the current item, items of this weightList can fill up free space.
            if (weightList.contains(freeSpace - itemWeight)) {
                return true;
            }
            // We repeat the process that removes the heaviest one and verifies that the sum of combined items can fill
            // up the free space.
            if (fillUpFreeSpace(weightList, freeSpace - itemWeight)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the sum of items in the weighList
     */
    private int sumItemWeight(ArrayList<Integer> weightList) {
        int sum = 0;
        for (int itemWeight: weightList) {
            sum += itemWeight;
        }
        return sum;
    }

    /**
     *
     * @param rockets
     * @return
     */
    public int runSimulation(ArrayList<Rocket> rockets) {
        if (rockets.get(0) instanceof U1) {
            int totalBudgetForU1 = 0;
            int rocketNum = 0;
            int i = 0;
            while (i < rockets.size()) {
                U1 u1 = (U1) rockets.get(i);
                totalBudgetForU1 += u1.getRocketCost();
                rocketNum++;
                System.out.println("Create U1 rocket # " + rocketNum);
                if (u1.launch()) {
                    if (u1.land()) {
                        i++;
                    }
                }
            }
            System.out.println("The number of U1 rockets : " + rocketNum);
            System.out.println("U1 launching budget: $" + totalBudgetForU1);
            return totalBudgetForU1;
        } else {
            int totalBudgetForU2 = 0;
            int rocketNum = 0;
            int i = 0;
            while (i < rockets.size()) {
                U2 u2 = (U2) rockets.get(i);
                totalBudgetForU2 += u2.getRocketCost();
                rocketNum++;
                System.out.println("Create U2 rocket # " + rocketNum);
                if (u2.launch()) {
                    if (u2.land()) {
                        i++;
                    }
                }
            }
            System.out.println("The number of U2 rockets : " + rocketNum);
            System.out.println("U2 launching budget: $" + totalBudgetForU2);
            return totalBudgetForU2;
        }
    }
}
