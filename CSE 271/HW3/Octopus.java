/**
 * An API for the Octopus object which is a part of Pet.
 *
 * @author James Hering, CSE 271, 21 February 2022
 */

public class Octopus extends Pet {

    public Octopus(String k, float pr, float fpd) {
        super(k, pr, fpd);
    }

    @Override
    public String getKind() {
        return "Octopus: " + kind;
    }

    @Override
    public boolean isAquatic() {
        return true;
    }

    public String toString() {
        return String.format(TOSTRING_FORMAT, "Octopus", kind, price,
                foodPerDay);
    }
}
