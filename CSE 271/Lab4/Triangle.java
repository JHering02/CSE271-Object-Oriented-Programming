import java.awt.Polygon;
import java.util.Scanner;

/**
 * A simple triangle class.
 */
public class Triangle extends Shape {


    /**
     * Constructor to create a triangle using information from the supplied
     * scanner. Input is read in the order x, y, width, height, and color.
     * 
     * @param num      Just some number associated with the shape.
     * @param keyboard The scanner from where the information for the shape is
     *                 to bread.
     */
    public Triangle(int num, Scanner keyboard) {
        // Build this shape inherited from Shape class
        super(num, keyboard);
    }

    /**
     * Obtain the vertices that can be used to draw this polygon.
     * 
     * @return The vertices associated with this shape.
     */
    @Override
    public Polygon getVertices() {
        Polygon vertices = new Polygon();
        // Add vertex in clock-wise order.
        vertices.addPoint(xpos + (width / 2), ypos);
        vertices.addPoint(xpos + width, ypos + height);
        vertices.addPoint(xpos, ypos + height);
        return vertices;
    }

    /**
     * Obtain the area.
     * 
     * @return Return the area
     */
    @Override
    public double getArea() {
        return (width * height) / 2;
    }
}
