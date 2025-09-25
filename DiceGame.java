import java.util.Scanner; // Import Scanner to read input from user
import java.util.Random;  // Import Random to generate random numbers

/**
 * The program generates a random number between 1 and 6,
 * and asks the user to guess the number. It gives hints
 * whether the guess was too high or too low, and counts
 * the number of attempts until the correct guess.
 *
 * @author Angel
 * @version 1.1
 * @since 2025-09-24
 */
public final class DiceGame { // Define the DiceGame class

    /** Constant for minimum dice value. */
    public static final int MIN = 1; // Minimum dice number

    /** Constant for maximum dice value. */
    public static final int MAX = 6; // Maximum dice number

    /**
     * Private constructor to prevent creating objects.
     */
    private DiceGame() {
        throw new IllegalStateException("Utility class");
    }

    /**.
     * Main method for the dice game.
     *
     * @param args
     */
    public static void main(final String[] args) {
        System.out.println("Welcome to the Dice Game!");
        // Print welcome message
        System.out.println("I have rolled a number between " + MIN);
        System.out.println("" + " and " + MAX + "."); // Show dice range
        System.out.println("Try to guess it!"); // Tell user to guess

        Random random = new Random();
        // Create random number generator
        int targetNumber = random.nextInt(MAX - MIN + 1) + MIN;
        // Generate random number between MIN and MAX
        Scanner scanner = new Scanner(System.in); // Create scanner

        int userGuess = 0; // Variable for user guess
        int attempts = 0; // Count of attempts

        boolean guessedCorrectly = false; // check if guess was right

        while (!guessedCorrectly) { // Repeat until user guesses correctly
            System.out.print("Enter your guess: "); // Ask for user input
            String input = scanner.nextLine(); // Read user input as string

            try {
                userGuess = Integer.parseInt(input);
                // Convert input to integer

                if (userGuess < MIN || userGuess > MAX) {
                    // Check if guess is out of allowed range
                    System.out.println("Please enter a number between ");
                    System.out.println(MIN + " and " + MAX + ".");
                    continue; // Ask again
                }

                attempts = attempts + 1; // Increase attempt count

                if (userGuess < targetNumber) {  // If guess is too low
                    System.out.println("Too low! Try again.");
                } else if (userGuess > targetNumber) { // If guess is too high
                    System.out.println("Too high! Try again.");
                } else {
                    guessedCorrectly = true; // Correct guess now the loop ends
                }

            } catch (NumberFormatException e) {
                 // If input is not a valid number
                System.out.println("Invalid input.");
                System.out.println(" Please enter a whole between 1 and 6.");
                 // for errors
            }
        }

        // Print congratulations with number of attempts
        if (attempts == 1) {
            System.out.println("Correct!");
            System.out.println("You guessed it in 1 attempt.");
        } else {
            System.out.println("Correct! ");
            System.out.println("You guessed it in " + attempts + " attempts.");
        }

        scanner.close(); // Close scanner resource
    }
}
