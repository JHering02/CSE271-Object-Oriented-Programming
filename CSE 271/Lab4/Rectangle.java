import java.awt.Polygon;
import java.util.Scanner;

/**
 * A simple rectangle class.
 */
public class Rectangle extends Shape {
    
    /**
     * Constructor to create a rectangle using information from the supplied
     * scanner. Input is read in the order x, y, width, height, and color.
     * 
     * @param num      Just some number associated with the shape.
     * @param keyboard The scanner from where the information for the shape is
     *                 to bread.
     */
    public Rectangle(int num, Scanner keyboard) {
        // Build this shape inherited from Shape class
        super(num, keyboard);
    }

    
}
