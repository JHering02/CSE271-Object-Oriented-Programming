/**
 * An API for the Dog object which is a part of Pet.
 *
 * @author James Hering, CSE 271, 21 February 2022
 */

public class Dog extends Pet {

    public Dog(String k, float pr, float fpd) {
        super(k, pr, fpd);
    }

    @Override
    public String getKind() {
        return "Dog: " + kind;
    }

    public String toString() {
        return String.format(TOSTRING_FORMAT, "Dog", kind, price, foodPerDay);
    }

    @Override
    public boolean isAquatic() {
        return false;
    }
}
