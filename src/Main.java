import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    /**
     * @param args expects two args for the random numbers range  (origin, bound). Default range is (1, 3)
     */
    public static void main(String[] args) {
        int origin;
        int bound;
        try {
            origin = Integer.parseInt(args[0]);
            bound = Integer.parseInt(args[1]);
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            origin = 1;
            bound = 3;
        }
        System.out.printf("Using range of numbers (%d, %d)%n", origin, bound);

        Random random = new Random();
        int reward = random.nextInt(origin, bound + 1);

        Scanner scanner = new Scanner(System.in);
        int guess = readValidGuess(scanner, origin, bound);

        int emptyBox = differentRandom(origin, bound, Arrays.asList(reward, guess));

        System.out.printf("Would you like to change to box number %d? Enter Y for YES or any key for NO %n", emptyBox);
        boolean changeBox = scanner.next().toUpperCase().startsWith("Y");
        if (changeBox) {
            guess = emptyBox;
        }
        if (!changeBox && guess == reward) {
            System.out.printf("You win! The correct value is %d.%nGame over.", reward);
        } else {
            System.out.printf("You lose. Your guess was number %d.%nBox with a reward was number %d. Game over.", guess, reward);
        }
    }

    static int readValidGuess(Scanner scanner, int origin, int bound) {
        int guess;
        boolean validInput;
        do {
            System.out.printf("Enter a number between %d and %d:%n", origin, bound);
            guess = scanner.nextInt();
            validInput = guess >= origin && guess <= bound;
            if (!validInput) {
                System.out.println("Invalid input value: " + guess);
            }
        } while (!validInput);
        return guess;
    }

    static int differentRandom(int origin, int bound, List<Integer> values) {
        int different;
        Random random = new Random();
        do {
            different = random.nextInt(origin, bound + 1);
        } while (values.contains(different));
        return different;
    }

}