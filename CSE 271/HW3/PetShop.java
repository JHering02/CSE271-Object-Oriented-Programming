import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * A simple pet store that has pets and food things.
 *
 */
public class PetShop {
    /**
     * The items available for sale in this pet shop. The items are added to
     * this list via the addItemsFromFile method.
     */
    private ArrayList<Thing> things;

    /**
     * This is an intermediate summary string that has been used to generate the
     * full summary format below. Don't use this one. Instead, use the
     * SUMMARY_FORMAT string below.
     */
    private static final String SUMMARY_SUB_FORMAT = 
            "    Number of pets      : %d%n"
            + "    Total price pets    : $%.2f%n"
            + "    Number of food items: %d%n"
            + "    Total price of food : $%.2f%n";

    /**
     * Format string to print summary of pets and food items in the pet store.
     */
    private static final String SUMMARY_FORMAT = 
            "Summary of items in Pet Shop%n"
            + "Aquatic pets & food summary%n"
            + SUMMARY_SUB_FORMAT
            + "Non-aquatic pets & food summary%n"
            + SUMMARY_SUB_FORMAT;

    /**
     * Format string to print food status for the pet store.
     */
    private static final String FOOD_STATUS = "Pet Shop food status:%n"
            + "    Daily aquatic food needed      : %.2f lb%n"
            + "    Daily non-aquatic food needed  : %.2f lb%n"
            + "    Aquatic food stock in store    : %.2f lb%n"
            + "    Non-aquatic food stock in store: %.2f lb%n";

    /**
     * Creates an empty shop without any items.
     */
    public PetShop() {
        things = new ArrayList<>();
    }

    /**
     * Returns the number of food objects in the list of things in this pet
     * store.
     * 
     * @return The number of food things currently in the list of things in this
     *         pet store.
     */
    public int getFoodCount() {
        int res = 0;
        for (int i = 0; i < things.size(); i++) {
            if (things.get(i) instanceof Food) {
                res++;
            }
        }
        return res;
    }

    /**
     * Returns the number of food objects depending on being Aquatic or not.
     * 
     * @return The amount of food objects currently in the store
     */
    public int getAqFood(boolean aquatic) {
        int res = 0;
        for (Thing th : things) {
            if (!(th instanceof Food)) {
                continue;
            }
            if (th.isAquatic() == aquatic) {
                res++;
            }
        }
        return res;
    }

    /**
     * Returns the number of pet objects in the list of things in this pet
     * store.
     * 
     * @return The number of pets currently in the list of things in this pet
     *         store.
     */
    public int getPetCount() {
        int res = 0;
        for (int i = 0; i < things.size(); i++) {
            if (things.get(i) instanceof Pet) {
                res++;
            }
        }
        return res;
    }

    /**
     * Returns the number of pet objects depending on being Aquatic or not.
     * 
     * @return The number of aquatic pets in the list of things with aquatic
     *         consideration
     */
    public int getAqPet(boolean aquatic) {
        int res = 0;
        for (Thing th : things) {
            if (!(th instanceof Pet)) {
                continue;
            }
            if (th.isAquatic() == aquatic) {
                res++;
            }
        }
        return res;
    }

    /**
     * Adds items loaded from a given text file to the list of items in the
     * store. The items are stored line-by-line in the text file. Each line
     * contains values separated by a tab character. The data in the lines are
     * with: 3-columns for Food: FoodName Price Weight 4-columns for Pet :
     * PetNamme PetKind Price FoodPerDay
     * 
     * @param fileName The text file from where Things are to be added to the
     *                 list of items for sale in the pet store.
     */
    public void addItemsFromFile(String fileName) throws FileNotFoundException {
        Scanner reader = new Scanner(new File(fileName));
        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            String[] values = line.split("\t");
            if (values.length == 4) {
                createPet(values);
            } else if (values.length == 3) {
                createFood(values);
            }
        }
    }

    /**
     * Takes a split line in a text file and determines what type of pet to
     * make.
     * 
     * @param values array of Strings
     */
    public void createPet(String[] values) {
        switch (values[0]) {
        case "Dog":
            things.add(new Dog(values[1], Float.parseFloat(values[2]),
                    Float.parseFloat(values[3])));
            break;
        case "Cat":
            things.add(new Cat(values[1], Float.parseFloat(values[2]),
                    Float.parseFloat(values[3])));
            break;
        case "Octopus":
            things.add(
                    new Octopus(values[1], Float.parseFloat(values[2]),
                            Float.parseFloat(values[3])));
            break;
        case "Fish":
            things.add(new Fish(values[1], Float.parseFloat(values[2]),
                    Float.parseFloat(values[3])));
            break;
        default:
            break;
        }
    }

    /**
     * Takes a split line in a text file and determines what type of food to
     * make.
     * 
     * @param values array of Strings
     */
    public void createFood(String[] values) {
        switch (values[0]) {
        case "WormCan":
            things.add(new WormCan(Float.parseFloat(values[1]),
                    Float.parseFloat(values[2])));
            break;
        case "ChowBag":
            things.add(new ChowBag(Float.parseFloat(values[1]),
                    Float.parseFloat(values[2])));
            break;
        default:
            break;
        }
    }

    /**
     * Interface method to print a summary of the items in the pet store. The
     * summary is computed and printed using the supplied SUMMARY_FORMAT string.
     * 
     * @see SUMMARY_FORMAT
     */
    public void printSummary() {
        System.out.printf(SUMMARY_FORMAT, getAqPet(true),
                petTotal(things, true), getAqFood(true),
                foodTotal(things, true), getAqPet(false),
                petTotal(things, false), getAqFood(false),
                foodTotal(things, false));
    }

    /**
     * A simple method that prints all of the things in the store.
     */
    public void printAllThings() {
        System.out.print("List of all items:\n");
        for (Thing th : things) {
            System.out.println(th.toString());
        }
    }

    /**
     * Method to add up the price of every pet in a list of things.
     * 
     * @param pets    a list of things
     * @param aquatic a boolean to add either aquatic or non-aquatic
     * @return the total price of every pet in the shop
     */
    public float petTotal(ArrayList<Thing> pets, boolean aquatic) {
        float res = 0.0f;
        for (Thing th : pets) {
            if (!(th instanceof Pet)) {
                continue;
            }
            if (th.isAquatic() == aquatic) {
                res += th.getPrice();
            }

        }
        return res;
    }

    /**
     * Method to add up the price of every food item in a list of things.
     * 
     * @param food a list of things
     * @return the total price of every food item in the shop
     */
    public float foodTotal(ArrayList<Thing> food, boolean aquatic) {
        float res = 0.0f;
        for (Thing th : food) {
            if (!(th instanceof Food)) {
                continue;
            }
            if (th.isAquatic() == aquatic) {
                res += th.getPrice();
            }

        }
        return res;
    }

    /**
     * Computes and prints the amount of aquatic and non-aquatic food needed to
     * feed all of the pets in the store along with the amount of food currently
     * available. The food needed by pets is computed by adding the daily food
     * needs of all the pets. The food available is computed by adding the
     * weight of all the food things.
     * 
     * @see FOOD_STATUS
     */
    public void reportFoodStatus() {
        float aqFood = 0;
        float food = 0;
        float currFood = 0;
        float currAqFood = 0;
        for (Thing th : things) {
            if (th instanceof Pet && th.isAquatic()) {
                aqFood += ((Pet) th).getFoodPerDay();
            } else if (th instanceof Pet && !th.isAquatic()) {
                food += ((Pet) th).getFoodPerDay();
            } else if (th instanceof Food && th.isAquatic()) {
                currAqFood += ((Food) th).getWeight();
            } else if (th instanceof Food && !th.isAquatic()) {
                currFood += ((Food) th).getWeight();
            }
        }
        System.out.printf(FOOD_STATUS, aqFood, food, currAqFood, currFood);
    }
}
