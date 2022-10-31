/**
 * An API for the car object.
 *
 * @author James Hering, CSE 271, 10 February 2022
 */
public class Car {
    
    /**
     * make of the car.
     */
    private String make;
    
    /**
     * mileage on the car.
     */
    private int mileage;
    
    /**
     * Parameter Constructor for the car object.
     * @param theMake make of the car
     * @param theMileage mileage on the car
     */
    public Car(String theMake, int theMileage) {
        make = theMake;
        mileage = theMileage;
    }
    
    /**
     * 2nd parameter constructor with no mileage on it yet.
     * @param theMake make of the car
     */
    public Car(String theMake) {
        make = theMake;
    }
    
    /**
     * Getter for the make of the car.
     * @return make of the car
     */
    public String getMake() {
        return make;
    }
    
    /**
     * Getter for the mileage of the car.
     * @return mileage of the car
     */
    public int getMileage() {
        return mileage;
    }
    
    /**
     * Method that adds mileage to the car regardless of direction.
     * @param distance distance to drive
     */
    public void drive(int distance) {
        mileage += Math.abs(distance);
    }
    
    /**
     * honks the horn as instructed.
     */
    public void honkHorn() {
        System.out.println(make + ": beep");
    }
    
    /**
     * ToString method for the car.
     */
    public String toString() {
        return make + ": " + mileage;
    }
}
