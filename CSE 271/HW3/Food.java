/**
 * An API for the Food object which is a part of Thing.
 *
 * @author James Hering, CSE 271, 21 February 2022
 */

public abstract class Food extends Thing {
    protected float price;
    protected float weight;
    public static final String TOSTRING_FORMAT = "%s\t%.2f\t%.2f";

    public Food(float pr, float we) {
        this.price = pr;
        this.weight = we;
    }

    @Override
    public float getPrice() {
        return this.price;
    }

    public float getWeight() {
        return this.weight;
    }

    @Override
    public boolean equals(Object food) {
        if (food == null || food.getClass() != Food.class) {
            return false;
        }
        Food other = (Food) food;
        return price == other.getPrice() && weight == other.getWeight();

    }

}
