/**
 * An API for the Fish object which is a part of Pet.
 *
 * @author James Hering, CSE 271, 21 February 2022
 */

public class Fish extends Pet {
    
    public Fish(String k, float pr, float fpd) {
        super(k, pr, fpd);
    }

    @Override
    public String getKind() {
        return "Fish: " + kind;
    }

    @Override
    public boolean isAquatic() {
        return true;
    }

    public String toString() {
        return String.format(TOSTRING_FORMAT, "Fish", kind, price, foodPerDay);
    }
}
