/**	
 * @author: Prithviraj Deshmane
 * 
 * Problem Source:
 * Site: https://adventofcode.com
 * Year: 2023
 * Day: 2
 * Problem: #1
 * Problem Statement: https://adventofcode.com/2023/day/2
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * This class reads game data from an input file, evaluates whether games are possible
 * based on draw limits for each color, and calculates a sum of game numbers for valid games.
 */
public class App {
	// Total count of maximum allowed colors
    private static final int TOTAL_RED = 12;
    private static final int TOTAL_GREEN = 13;
    private static final int TOTAL_BLUE = 14;

    /**
     * Main method to read input from a file, evaluate games, and print the total sum.
     */
    public static void main() {
        int sum = 0;
        try (Scanner sc = new Scanner(new File("input.txt"))) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] arr = line.split(":");
                int gameNumber = Integer.parseInt(arr[0].substring(5));

                if (isGameValid(arr[1].trim())) {
                    sum += gameNumber;
                }
            }
            System.out.println("Total sum: " + sum);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Checks if all hands in the game details are valid.
     *
     * @param gameDetails A string representing the details of the game.
     * @return True if the game is valid, otherwise false.
     */
    private static boolean isGameValid(String gameDetails) {
    	// Separate hands listed in the game
        for (String hand : gameDetails.split(";")) {
        	
        	// Determine if each hand is valid or not
            if (!isHandValid(hand.trim())) {
            	
            	// if any single hand is invalid, then that game is invalid
                return false;
            }
        }
        
        // If all hands in the game are valid, then the game is valid
        return true;
    }

    /**
     * Checks if a single hand is valid by verifying all its draws.
     *
     * @param hand A string representing a hand within the game.
     * @return True if the hand is valid, otherwise false.
     */
    private static boolean isHandValid(String hand) {
    	// Separate draws from the hand
        for (String draw : hand.split(",")) {
        	
        	// Check if each draw is valid, return false otherwise
            if (!isDrawValid(draw.trim())) {
                return false;
            }
        }
        
        // If all draws in hand are valid, then the hand is valid
        return true;
    }

    /**
     * Checks if a single draw is valid based on the color limits.
     *
     * @param draw A string representing the count and color of a draw.
     * @return True if the draw is valid, otherwise false.
     */
    private static boolean isDrawValid(String draw) {
    	// Split the draw into count and color respectively 
        String[] drawDetails = draw.split(" ");
        int count = Integer.parseInt(drawDetails[0].trim());
        String color = drawDetails[1].trim().toLowerCase();
        
        // Draw is valid only if number of balls drawn are <= the number allowed
        switch (color) {
            case "green": return count <= TOTAL_GREEN;
            case "blue": return count <= TOTAL_BLUE;
            case "red": return count <= TOTAL_RED;
            default: return false; // Return false for unsupported colors
        }
    }
}
