import java.util.Scanner;

/**
 * A class that interacts with the user to enable guessing the secret word.
 *
 * @author James Hering, CSE 271, 8 February 2022
 */
public class GameConsole {

    /**
     * A String that the GameConsole uses to identify the alphabet of the
     * language being used (English).
     */
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    /**
     * This string keeps track of every letter the user guesses.
     */
    private static String guessed = "";

    /**
     * A simple string to generate initial word with a bunch of stars. This
     * string is setup on the assumption on the longest possible word.
     */
    private static final String STARS = "******************************";

    /**
     * The prompt string used to prompt the user for input. The prompt string
     * can be used as: System.out.printf(InputPrompt, currWord);
     */
    private static final String INPUT_PROMPT = "Word so far: %s%n"
            + "Enter a word or a letter [*: quit, +: AI, ?: hint]: ";

    /**
     * A simple message that is printed whenever the user guesses a character
     * correctly. This string is used as: System.out.printf(MatchMessage, c,
     * e.getMessage());
     */
    private static final String MATCH_MESSAGE = "You guessed a character "
            + "correctly!%nThe character '%c' occurs at index position(s) %s%n";
    /**
     * A private static variable that is used to track the characters that have
     * been guessed by the user so far. This word is initialized to a bunch of
     * stars and as the user guesses characters, the corresponding characters
     * are filled-in until the whole word is guessed.
     */
    private static String currWord = "*";

    /**
     * This startup method will determine the amount of characters that are in
     * the secret word.
     * 
     * @param wt The Word Throws Object from the play method
     * 
     * @throws WordThrow.CorrectWordException This exeption needs to be thrown
     *                                        but won't be handled in startup
     */
    public static void startup(WordThrow wt)
            throws WordThrow.CorrectWordException {
        for (int i = 0; i < currWord.length(); i++) {
            try {
                wt.guess(currWord);
            } catch (WordThrow.WordLengthMismatchException j) {
                currWord += "*";
            }
        }
        System.out.println("Guess the " + currWord.length()
                + " character word.");
    }

    /**
     * The top-level method that is invoked by WordThrow class to enable the
     * user to use different operations to guess the secret word. This method is
     * expected to prompt the user for input and perform the necessary
     * operations based on user-input. This method essentially uses a set of
     * helper methods to accomplish the necessary functionality.
     * 
     * @param wt The word throw object to be used by this method.
     * @throws WordThrow.CorrectWordException    This exception will be handled
     *                                           in phase 2
     * 
     * @throws WordThrow.MatchAndOccursException This exeption is handled within
     *                                           the processCharacter method
     */
    public static void play(WordThrow wt)
            throws WordThrow.CorrectWordException,
            WordThrow.MatchAndOccursException {
        startup(wt);
        Scanner reader = new Scanner(System.in);
        while (currWord.contains("*")) {
            System.out.printf(INPUT_PROMPT, currWord);
            String choice = reader.next();
            // These if statements handle most user input
            if (choice.equals("*")) {
                currWord = "";
            } else if (choice.equals("?")) {
                useHint();

            } else if (choice.equals("+")) {
                botHelper(wt);
            } else if (ALPHABET.contains(choice) && choice.length() == 1) {
                guessed += choice;
                char temp = choice.charAt(0);
                processCharacter(wt, temp);
            } else if (choice.length() > 1) { // Guessing a word
                processWord(wt, choice);
            }
        }
        if (!(currWord.equals("")) && !(currWord.contains("*"))) {
            System.out.println("You guessed the word! Congratulations!");
        }
        reader.close();
    }

    /**
     * This method will proccess the guessing of a word if the user inputs one
     * character.
     * 
     * @param wt The word throw object from the play method
     * @throws WordThrow.MatchAndOccursException This is thrown if the character
     *                                           doesn't exist in the word
     */
    public static void processCharacter(WordThrow wt, char ch)
            throws WordThrow.MatchAndOccursException {
        try {
            wt.guess(ch);
        } catch (WordThrow.MismatchException e) {
            // Prints if the character wasn't in the word
            System.out.printf("The character '%c' is not in the word.\n", ch);
        } catch (WordThrow.MatchAndOccursException f) {
            // Prints if the character was in the word
            System.out.printf(MATCH_MESSAGE, ch, f.getMessage());
            Scanner reader = new Scanner(f.getMessage());
            while (reader.hasNextInt()) {
                int j = reader.nextInt();
                currWord = currWord.substring(0, j) + ch
                        + currWord.substring(j + 1);
            }
        }
    }

    /**
     * This method effectively gives the user a hint for how many letters the
     * user has guessed when called.
     */
    public static void useHint() {
        String res = "";
        // Adds already guessed values and prints the remaining
        for (int i = 0; i < ALPHABET.length(); i++) {
            if (guessed.contains(ALPHABET.substring(i, i + 1))) {
                res += "-";
            } else {
                res += ALPHABET.charAt(i);
            }
        }
        System.out.printf("Letters left to guess: %s\n", res);
    }

    /**
     * This method processes a word given by the user if they didn't type in a
     * single character.
     * 
     * @param wt  The WordThrow object
     * @param str The word the user typed in
     */
    public static void processWord(WordThrow wt, String str) {
        try {
            wt.guess(str);
            System.out.println("Good try, but you guessed wrong.");
        } catch (WordThrow.WordLengthMismatchException e) {
            // Prints if the word isn't the same length as the secret
            System.out.printf(
                    "Your guessed word did not have same length.\n");
        } catch (WordThrow.CorrectWordException e) {
            // Prints if the word is the same as the secret
            currWord = str;
        }
    }

    /**
     * This method finds a letter for the user that hasn't been guessed yet.
     * 
     * @param wt The current WordThrow Object
     * @throws WordThrow.MatchAndOccursException Handled in ProcessCharacter
     */
    public static void botHelper(WordThrow wt)
            throws WordThrow.MatchAndOccursException {
        int i = 0;
        int countMin = 0;
        int countMax = 0;
        processBotHelper(countMin, countMax, i, wt);
    }

    /**
     * This method is just meant to contain bothelper to the line limit. :(
     * 
     * @param min     minimum counter
     * @param max     maximum counter
     * @param current current letter
     * @param wt      Word Throw object
     * @throws WordThrow.MatchAndOccursException Handled in processCharacter
     */
    private static void processBotHelper(int min, int max, int current,
            WordThrow wt) throws WordThrow.MatchAndOccursException {
        boolean complete = false;
        while (!complete) {
            char ch = ALPHABET.charAt(current);
            try {
                // This if statement is only used if the character has already
                // been guessed
                if (currWord.contains("" + ch)) {
                    throw new WordThrow.MismatchException(ch);
                }
                wt.guess(ch);
            } catch (WordThrow.MismatchException e) {
                if (current > ALPHABET.length() / 2) {
                    // Counts the values guessed above half of the alphabet and
                    // switches to the other half
                    max++;
                    current = 0 + min;
                } else if (current < ALPHABET.length() / 2) {
                    // Counts the values guessed below half of the alphabet and
                    // switches to the other half
                    min++;
                    current = (ALPHABET.length() - 1) - max;
                }
            } catch (WordThrow.MatchAndOccursException f) {
                // Prints if the character was in the word
                processCharacter(wt, ch);
                complete = true;
            }
        }
    }
}
