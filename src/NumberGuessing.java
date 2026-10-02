import java.util.Random;
import java.util.Scanner;

/** Number Guessing Game: I pick a number from 1 to 100, you guess it. */
public class NumberGuessing {
    static final int LOW = 1;
    static final int HIGH = 100;

    /** Returns -1 if the guess is too low, 1 if too high, 0 if correct. */
    static int check(int secret, int guess) {
        return Integer.compare(guess, secret);
    }

    /** Parses a guess. Returns null for invalid input, Integer.MIN_VALUE for quit. */
    static Integer parse(String raw) {
        String s = raw.trim().toLowerCase();
        if (s.equals("quit") || s.equals("q") || s.equals("exit")) return Integer.MIN_VALUE;
        try {
            int v = Integer.parseInt(s);
            return (v >= LOW && v <= HIGH) ? v : null;
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        Integer best = null;

        System.out.println("Number Guessing Game");
        System.out.println("I picked a number from 1 to 100. Try to guess it. (type q to quit)");
        System.out.println();

        game:
        while (true) {
            int secret = random.nextInt(HIGH) + LOW;
            int tries = 0;
            while (true) {
                System.out.print("Your guess: ");
                if (!scanner.hasNextLine()) break game;
                Integer guess = parse(scanner.nextLine());
                if (guess == null) {
                    System.out.println("Please enter a whole number from 1 to 100.");
                    System.out.println();
                    continue;
                }
                if (guess == Integer.MIN_VALUE) break game;
                tries++;
                int result = check(secret, guess);
                if (result < 0) {
                    System.out.println("Too low.");
                } else if (result > 0) {
                    System.out.println("Too high.");
                } else {
                    System.out.println("Correct! You got it in " + tries + (tries == 1 ? " try." : " tries."));
                    if (best == null || tries < best) {
                        best = tries;
                        System.out.println("That's your best this session.");
                    }
                    break;
                }
                System.out.println();
            }
            System.out.print("\nPlay again? [y/N] ");
            if (!scanner.hasNextLine() || !scanner.nextLine().trim().toLowerCase().startsWith("y")) break;
            System.out.println();
        }

        System.out.println("Goodbye." + (best != null ? " Best score: " + best + " tries." : ""));
        scanner.close();
    }
}
