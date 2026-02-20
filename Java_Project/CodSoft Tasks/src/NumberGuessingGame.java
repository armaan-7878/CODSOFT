import java.util.Random;
import java.util.Scanner;

class RandomNumberGenerator {
    private Random random;

    public RandomNumberGenerator() {
        random = new Random();
    }

    public int generateNumber(int min, int max) {
        return random.nextInt((max - min) + 1) + min;
    }
}

class GameStatistics {
    private int totalAttempts;
    private int totalWins;

    public void recordGame(int attempts) {
        totalAttempts += attempts;
        totalWins++;
    }

    public void displayStats() {
        System.out.println("Total Attempts: " + totalAttempts);
        System.out.println("Total Wins: " + totalWins);

        if (totalAttempts > 0) {
            double winRate = ((double) totalWins / totalAttempts) * 100;
            System.out.printf("Win Rate: %.2f%%\n", winRate);
        }
    }
}

public class NumberGuessingGame {

    private static Scanner scanner = new Scanner(System.in);
    private static RandomNumberGenerator generator = new RandomNumberGenerator();
    private static GameStatistics stats = new GameStatistics();

    public static void main(String[] args) {

        System.out.println("=== Welcome to the Number Guessing Game ===");

        boolean playAgain = true;

        while (playAgain) {
            int min = getInput("Enter minimum value: ");
            int max = getInput("Enter maximum value: ");

            while (max <= min) {
                System.out.println("Maximum must be greater than minimum. Try again.");
                max = getInput("Enter maximum value: ");
            }

            int secretNumber = generator.generateNumber(min, max);
            int attempts = playRound(secretNumber, min, max);

            stats.recordGame(attempts);
            stats.displayStats();

            System.out.print("Play again? (y/n): ");
            String choice = scanner.next();

            playAgain = choice.equalsIgnoreCase("y");
        }

        System.out.println("Thanks for playing!");
        scanner.close();
    }

    private static int playRound(int secretNumber, int min, int max) {
        int attempts = 0;
        boolean guessedCorrectly = false;

        while (!guessedCorrectly) {
            System.out.print("Guess a number between " + min + " and " + max + ": ");
            int guess = scanner.nextInt();
            attempts++;

            if (guess > secretNumber) {
                System.out.println("Too high!");
            } else if (guess < secretNumber) {
                System.out.println("Too low!");
            } else {
                System.out.println("Correct! You guessed it in " + attempts + " attempts.");
                guessedCorrectly = true;
            }
        }

        return attempts;
    }

    private static int getInput(String message) {
        System.out.print(message);
        return scanner.nextInt();
    }
}
