package personal;
import java.util.Random;
import java.util.Scanner;

public class Battleship {
    public static void main(String[] args) {
    	
    	/*
    	// Developer: Nikita Ghimire
    	// Date: 11/23/2024
    	// System description: 
    	 * Computer randomly places ship location and user has multiple tries to hit
    	 * the ship until 4 index values of the ship is hit. User is prompted to enter
    	 * a value from 0-19 for each try. If a guess is a hit, the word “Hit!” is printed
    	 * If a guess is a miss, the word “Miss!” is printed. Congratulations message 
    	 * is printed along with total number of guesses made.
    	*/
    	
        // Declare variables and instantiate objects
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        // Array sea 
        int[] sea = new int[20]; 
        // Array hits 
        int[] hit = new int[20];
        
        // Randomly set the ship location 
        int ship1 = random.nextInt(17);
        int guess;
        int guesses = 0; 
        int sum = 0; 

        // Populate the sea array with the ship's location 
        for (int i = ship1; i < ship1 + 4; i++) {
            sea[i] = 1; // Mark the ship's location
        }

        // Game loop
        while (sum < 4) {
            // Prompt the user for a guess
            System.out.print("Enter an index value to try to hit the battleship (0-19): ");
            guess = scanner.nextInt();
            guesses++; // Increment total guesses

            // Check if the guess is a hit or miss
            if (sea[guess] == 1) {
                System.out.println();
                System.out.println("HIT!");
                hit[guess] = 1; 
            } else {
                System.out.println();
                System.out.println("MISS!");
            }

            // Sum the hits (calculate how many spots have been hit)
            sum = 0; 
            for (int value : hit) {
                sum += value; 
            }

            // Print the hit array to show user their progress
            printHitArray(hit);
        }

        // Print result message
        System.out.println();
        System.out.println("SUNK!");
        System.out.println("Congratulations on sinking the battleship!");
        System.out.println("It took you " + guesses + " guesses.");

        // Close the scanner
        scanner.close();
    }

    // Method to print the hit array (showing user's progress)
    private static void printHitArray(int[] hit) {
        System.out.print("Hit: ");
        for (int value : hit) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
