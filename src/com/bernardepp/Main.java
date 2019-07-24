package com.bernardepp;

import java.util.Random;
import java.util.Scanner;

/**
 * This is the main class for the RPS game implementation with a command line interface..
 */
public class Main {

    private enum Choices {ROCK, PAPER, SCISSORS}

    private static Choices userChoice = null;
    private static Choices computerChoice = null;

    private static int userWins = 0;
    private static int computerWins = 0;

    /**
     * The main loop to play several rounds of RPS.
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Welcome to the rock paper scissors (Schere Stein Papie) game!");

        // Using Scanner for Getting Input from User
        Scanner in = new Scanner(System.in);

        // main loop
        boolean runGame = true;
        String userCommand;
        while (runGame) {
            System.out.println("Do you want to play? (y/n)");
            userCommand = in.nextLine();
            switch (userCommand) {
                case "y":
                case "Y":
                case "Yes":
                    // pick a symbol
                    userChoice = select();
                    // computer picks randomly
                    computerChoice = randomPick();
                    determineWinner();
                    break;
                case "n":
                case "N":
                case "No":
                    runGame = false;
                    break;
                default:
                    break;
            }
            System.out.println("The Score is    You:" + userWins + "    Computer:" + computerWins);
        }
        System.out.println("Bye. See you next time");
    }

    /**
     * User can select a symbol.
     *
     * @return Returns the selected symbol.
     */
    private static Choices select() {
        Scanner in = new Scanner(System.in);
        Choices choice = null;
        boolean validInput = false;
        while (!validInput) {
            System.out.println("Pick your Symbol ('R', 'P' or 'S')");
            String userCommand = in.nextLine();
            switch (userCommand) {
                case "S":
                case "s":
                    choice = Choices.SCISSORS;
                    validInput = true;
                    break;
                case "R":
                case "r":
                    choice = Choices.ROCK;
                    validInput = true;
                    break;
                case "P":
                case "p":
                    choice = Choices.PAPER;
                    validInput = true;
                    break;
                default:
            }
        }

        return choice;
    }

    /**
     * Random pick by the computer
     *
     * @return Returns the randomly selected symbol.
     */
    private static Choices randomPick() {
        Random random = new Random();
        return Choices.values()[random.nextInt(Choices.values().length)];
    }

    /**
     * Compares the pick by the user with the pick by the computer and determines a winner.
     * Increases the score accordingly.
     */
    private static void determineWinner() {
        System.out.println("Let's go: ");
        System.out.printf("Rock....");
        try {
            Thread.sleep(1000);
            System.out.printf("Paper....");
            Thread.sleep(1000);
            System.out.printf("Scissors!\n");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("You played: " + userChoice.toString() + " " + "The Computer randomly played: " + computerChoice.toString());
        if (userChoice.equals(computerChoice)) {
            // draw
            System.out.println("It's a draw. No one wins. Lets play again.");
        } else if (userChoice.equals(Choices.PAPER) && computerChoice.equals(Choices.ROCK)) {
            userWins += 1; // user wins
            System.out.println("You win!");
        } else if (userChoice.equals(Choices.PAPER) && computerChoice.equals(Choices.SCISSORS)) {
            computerWins += 1; // user looses, computer wins
            System.out.println("Computer wins!");
        } else if (userChoice.equals(Choices.ROCK) && computerChoice.equals(Choices.SCISSORS)) {
            userWins += 1;
            System.out.println("You win!");
        } else if (userChoice.equals(Choices.ROCK) && computerChoice.equals(Choices.PAPER)) {
            computerWins += 1;
            System.out.println("Computer wins!");
        } else if (userChoice.equals(Choices.SCISSORS) && computerChoice.equals(Choices.PAPER)) {
            userWins += 1;
            System.out.println("You win!");
        } else if (userChoice.equals(Choices.SCISSORS) && computerChoice.equals(Choices.ROCK)) {
            computerWins += 1;
            System.out.println("Computer wins!");
        }
    }
}
