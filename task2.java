import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    public static void main(String[] args) {
        Random random = new Random();
        int randomNumber = random.nextInt(100) + 1; 

        Scanner scanner = new Scanner(System.in);
        int guess;
        int attempts = 0;   
        System.out.println("Guess the Number!");
        System.out.println("Generated a random number between 1 and 100. Can you guess it?");
        do {
            System.out.print("Enter your guess: ");
            guess = scanner.nextInt();
            attempts++;
            if (guess < randomNumber) {
                System.out.println("Try again.");
            } else if (guess > randomNumber) {
                System.out.println("Try again.");
            } else   
               {
                System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                break;   
            }
        } 
while (true);
        scanner.close();
    }
}
