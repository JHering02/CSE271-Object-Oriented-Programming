import java.util.Scanner;

/**
 * This program determines whether a word is an int, double or String.
 * 
 * @author James Hering, CSE 271, 1 February 2022
 */
public class Numero {
    /**
     * Program that reads a word, and then interprets the data type using try
     * catch statements.
     * 
     * @param args unused command line arguments.
     */
    public static void main(String[] args) {
        // Prompting the user to enter a word or number
        Scanner reader = new Scanner(System.in);
        System.out.printf("Enter a word or number:\n");
        String word = reader.next();
        String datType = "String";
        // Using try catch statements to see what type the variable is
        try {
            Integer.parseInt(word);
            datType = "int";
        } catch (NumberFormatException notI) {

        }
        if (datType.equals("int") == false) {
            try {
                Double.parseDouble(word);
                datType = "double";
            } catch (NumberFormatException notD) {

            }
        }
        // Printing the result
        System.out.println(word + " is a " + datType);
        reader.close();
    }

}
