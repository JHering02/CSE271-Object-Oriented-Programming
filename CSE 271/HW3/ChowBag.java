/**
 * An API for the ChowBag object which is a part of Food.
 *
 * @author James Hering, CSE 271, 21 February 2022
 */

public class ChowBag extends Food {
    public ChowBag(float pr, float we) {
        super(pr, we);
    }

    @Override
    public String getKind() {
        return "ChowBag";
    }

    @Override
    public boolean isAquatic() {
        return false;
    }

    public String toString() {
        return String.format(TOSTRING_FORMAT, "ChowBag", price, weight);
    }
}
