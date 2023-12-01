package Number_Guessing_Game;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
// this is a simple number guessing game, where we take a guess and the system gives us the number of attempts we made and at which try we got it right.
public class NumberGuessingGame {
// constants for settign the lower and upper bounds of the random number
    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 100;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            playNumberGuessingGame(scanner);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid number.");
        }
    }

    private static void playNumberGuessingGame(Scanner scanner) throws InputMismatchException { // this is the method to play the game
        Random random = new Random(); // here the random number is generated

        System.out.println("Welcome to the Number Guessing Game!"); // welcoming the user

        boolean playAgain;
        do {
            int randomNumber = generateRandomNumber(); // generating a random number for the current game
            int attempts = 0; // the starting attempt is 0, we will increment it by +1 everytime we make a guess
            boolean hasGuessedCorrectly = false; // the guess correct will become true after we have guessed the number

            System.out.println("I've selected a random number between " + LOWER_BOUND + " and " + UPPER_BOUND + ". Try to guess it."); // this line shows the details of the random number

            while (!hasGuessedCorrectly) { // while we haven't guessed correctly, keep on going
                int userGuess = getUserGuess(scanner);
                attempts++; // incrementing the attempt

                if (userGuess < LOWER_BOUND || userGuess > UPPER_BOUND) { // here we check if the guessing number is even within the bounds or not
                    System.out.println("Please enter a number between " + LOWER_BOUND + " and " + UPPER_BOUND + ".");
                } else if (userGuess < randomNumber) {// checking if the number isn't equal to random number then how much high or low it is
                    System.out.println("Too low! Try again.");
                } else if (userGuess > randomNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    hasGuessedCorrectly = true; // as we have gone through all the other possible cases, the only case that remains is this
                    System.out.println("Congratulations! You've guessed the number " + randomNumber + " correctly!");
                    System.out.println("It took you " + attempts + " attempts.");
//                     we have the details about our guessing
                }
            }

            playAgain = promptPlayAgain(scanner);
        } while (playAgain);

        System.out.println("Thank you for playing!"); //display a farewell message
    }

    private static int generateRandomNumber() { // generating a random number within the specified limit
        return new Random().nextInt(UPPER_BOUND - LOWER_BOUND + 1) + LOWER_BOUND;
    }

    private static int getUserGuess(Scanner scanner) { // taking the users guess
        System.out.print("Enter your guess: ");
        return scanner.nextInt();
    }

    private static boolean promptPlayAgain(Scanner scanner) { // prompting the player to play again after they have guessed the number correctly
        while (true) {
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainChoice = scanner.next().toLowerCase();
            if (playAgainChoice.equals("yes") || playAgainChoice.equals("no")) {
                return playAgainChoice.equals("yes");
            } else {
                System.out.println("Invalid choice. Please enter 'yes' or 'no'."); // if the answer isn't yes/no then handle that
            }
        }
    }
}

// this is oibsip taskno2