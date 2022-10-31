/**
 * This class is a Unit testing class in which tests are to be added as features
 * are added to the Car class.
 * 
 * @author James Hering, CSE 271, 10 February 2022
 */
public class CarTester {
    /**
     * The main method that is used to test the operations of the Car class.
     * 
     * @param args The arguments are currently not used.
     */
    public static void main(String[] args) {
        // AFTER writing your constructors...
        // Create a car using the two-parameter constructor
        // (make it a Toyota-Corolla with 10000 miles)
        Car toyota = new Car("Toyota-Corolla", 10000);

        // Create a car using the one-parameter constructor
        // (make it a Ford)
        Car escape = new Car("Ford");

        // ------------------------------------------------
        // AFTER writing your getter methods ...
        // Print the make and mileage for each car:
        System.out.println(toyota.getMileage());
        System.out.println(escape.getMileage());
        
        // ------------------------------------------------
        // AFTER writing the drive method ...
        // drive the first car FORWARD 223 miles
        toyota.drive(223);

        // drive the second car BACKWARD 20556 miles
        // THEN, print the mileage of each car to verify
        // that it changed correctly.
        escape.drive(-20556);
        // ------------------------------------------------
        // AFTER writing the honkHorn() method ...
        // make each car honk its horn.
        toyota.honkHorn();
        escape.honkHorn();
        // ------------------------------------------------
        // AFTER writing the toString() method in Task #5...
        // print the toString() for each car.
        System.out.println(toyota);
        System.out.println(escape);
    }
}
