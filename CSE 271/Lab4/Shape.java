import java.awt.Polygon;
import java.util.Scanner;

/**
 * This class is meant to serve as the parent class (aka base class) for the
 * different shapes. The objective is to use inheritance and polymorphism to
 * streamline the code.
 *
 * @author James Hering, CSE 271, 17 February 2022
 */
public class Shape {
    // Instance variable for x-position
    protected int xpos;
    // Instance variable for y-position
    protected int ypos;
    // Instance variable for height
    protected int height;
    // Instance variable for width
    protected int width;
    // String with color -- valid values are:
    // "red", "yellow", "green", and "blue"
    private String color;
    
    /**
     * This is the default Constructor for any shape.
     * @param num number associated with shape
     * @param keyboard the scanner object reading the input
     */
    public Shape(int num, Scanner keyboard) {
        xpos = keyboard.nextInt();
        ypos = keyboard.nextInt();
        width = keyboard.nextInt();
        height = keyboard.nextInt();
        color = keyboard.next();
        // Flush out trailing new line to read numbers next
        keyboard.nextLine();
    }
    
    /**
     * Default method for getting the area of a shape.
     * @return returns the width times the height
     */
    public double getArea() {
        return width * height;
    }
    
    /**
     * Default method for getting the color of a shape.
     * @return the String of color
     */
    public String getColor() {
        return color;
    }

    /**
     * Obtain the vertices that can be used to draw this polygon.
     * 
     * @return The vertices associated with this shape.
     */
    public Polygon getVertices() {
        Polygon vertices = new Polygon();
        // Add vertex in clock-wise order.
        vertices.addPoint(xpos, ypos);
        vertices.addPoint(xpos + width, ypos);
        vertices.addPoint(xpos + width, ypos + height);
        vertices.addPoint(xpos, ypos + height);
        // Return the vertices for this shape
        return vertices;
    }
}
