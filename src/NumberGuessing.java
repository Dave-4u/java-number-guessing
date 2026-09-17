import java.util.Random;
import java.util.Scanner;

public class NumberGuessing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int secret = random.nextInt(100) + 1;
        int tries = 0;

        System.out.println("Number Guessing Game");
        System.out.println("I picked a number from 1 to 100. Try to guess it.");
        System.out.println();

        while (true) {
            System.out.print("Your guess: ");
            String raw = scanner.nextLine().trim();

            if (raw.equalsIgnoreCase("quit")
                    || raw.equalsIgnoreCase("q")
                    || raw.equalsIgnoreCase("exit")) {
                System.out.println("Goodbye.");
                break;
            }

            int guess;
            try {
                guess = Integer.parseInt(raw);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a whole number.");
                System.out.println();
                continue;
            }

            tries++;

            if (guess < secret) {
                System.out.println("Too low.");
            } else if (guess > secret) {
                System.out.println("Too high.");
            } else {
                System.out.println("Correct! You got it in " + tries + " tries.");
                break;
            }
            System.out.println();
        }

        scanner.close();
    }
}
