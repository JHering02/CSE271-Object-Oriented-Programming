/**
 * An API for the WormCan object which is a part of Food.
 *
 * @author James Hering, CSE 271, 21 February 2022
 */

public class WormCan extends Food {

    public WormCan(float pr, float we) {
        super(pr, we);
    }

    @Override
    public String getKind() {
        return "WormCan";
    }

    @Override
    public boolean isAquatic() {
        return true;
    }

    public String toString() {
        return String.format(TOSTRING_FORMAT, "WormCan", price, weight);
    }

}
