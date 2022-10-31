/**
 * An API for the Pet object which is a part of Thing.
 *
 * @author James Hering, CSE 271, 21 February 2022
 */

public abstract class Pet extends Thing {
    protected String kind;
    protected float price;
    protected float foodPerDay;
    public static final String TOSTRING_FORMAT = "%s\t%s\t%.2f\t%.2f";

    public Pet(String k, float pr, float fpd) {
        this.kind = k;
        this.price = pr;
        this.foodPerDay = fpd;
    }

    @Override
    public float getPrice() {
        return this.price;
    }

    public float getFoodPerDay() {
        return this.foodPerDay;
    }

    @Override
    public boolean equals(Object pet) {
        if (pet == null || !(pet instanceof Pet)) {
            return false;
        }
        Pet other = (Pet) pet;
        return other.getClass() == this.getClass()
                && other.getKind().equals(this.getKind());
    }

}
