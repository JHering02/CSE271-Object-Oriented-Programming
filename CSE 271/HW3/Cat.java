/**
 * An API for the Cat object which is a part of Pet.
 *
 * @author James Hering, CSE 271, 21 February 2022
 */

public class Cat extends Pet {

    public Cat(String k, float pr, float fpd) {
        super(k, pr, fpd);
    }

    @Override
    public String getKind() {
        return "Cat: " + kind;
    }

    @Override
    public boolean isAquatic() {
        return false;
    }

    public String toString() {
        return String.format(TOSTRING_FORMAT, "Cat", kind, price, foodPerDay);
    }
}
