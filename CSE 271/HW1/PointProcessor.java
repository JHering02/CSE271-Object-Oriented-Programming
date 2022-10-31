import java.awt.Point;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This is an helper class that is used to perform different operations using a
 * list of points.
 * 
 * @author James Hering, CSE 271, 1 February 2022
 */

public class PointProcessor {
    /**
     * Reads points from a given text file and makes them into an ArrayList.
     * 
     * @param fileName name of text file
     * @return ArrayList with points in it
     * @throws FileNotFoundException This will be thrown if the text file
     *                               doesn't exist
     */
    public static ArrayList<Point> readPointsFromFile(final String fileName)
            throws FileNotFoundException {
        ArrayList<Point> res = new ArrayList<Point>();
        Scanner reader = new Scanner(new File(fileName));
        while (reader.hasNextInt()) {
            res.add(new Point(reader.nextInt(), reader.nextInt()));
        }
        reader.close();
        return res;
    }

    /**
     * Returns the "taxicab" or "Manhatten" distance of a point from (0,0).
     * 
     * @param pt a point Object
     * @return a distance in the form of an integer
     */
    public static int cabDistance(final Point pt) {
        return (int) (Math.abs(pt.getX()) + Math.abs(pt.getY()));
    }

    /**
     * Prints a points coordinates in parentheses separated by a comma.
     * 
     * @param pt a point Object
     */
    public static void showPoint(final Point pt) {
        System.out.printf("(%d, %d)\t%d", (int) pt.getX(), (int) pt.getY(),
                cabDistance(pt));
    }

    /**
     * Prints all points in ptList, one line at a time with the given index
     * preceeding it.
     * 
     * @param ptList Array list of points
     */
    public static void showAllPoints(final ArrayList<Point> ptList) {
        if (ptList.isEmpty()) {
            System.out.println("Empty list");
        } else {
            for (int i = 0; i < ptList.size(); i++) {
                System.out.printf("[%d] (%d, %d)\t%d\n", i,
                        (int) ptList.get(i).getX(),
                        (int) ptList.get(i).getY(), cabDistance(ptList.get(i)));
            }
        }
    }

    /**
     * Returns a new list of points that contain all points exactly at a given
     * cab distance.
     * 
     * @param ptList ArrayList of points
     * @param dist   key distance that will be compared
     * @return ArrayList with values that match the cabdistance
     */
    public static ArrayList<Point> findAll(final ArrayList<Point> ptList,
            int dist) {
        ArrayList<Point> res = new ArrayList<Point>();
        for (int i = 0; i < ptList.size(); i++) {
            if (cabDistance(ptList.get(i)) == dist) {
                res.add(ptList.get(i));
            }
        }
        return res;
    }
}
