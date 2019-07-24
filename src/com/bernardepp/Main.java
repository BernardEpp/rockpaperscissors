package com.bernardepp;

import java.util.Scanner;

public class Main {

    private enum Choice {ROCK, PAPER, SCISSOR}


    public static void main(String[] args) {
        // write your code here

        System.out.println("Welcome to the rock paper scissors (Schere Stein Papie) game!");

        private Choice userChoice;
        private Choice computerChoice;

        // Using Scanner for Getting Input from User
        Scanner in = new Scanner(System.in);


        // main loop

        private boolean runGame = true;
        while (runGame) {
            String userCommand = in.nextLine();
            switch (userCommand) {
                case "q":
                case "quit":
                case "Q":
                    runGame = false;
                    System.out.println("Bye. See you next time");
                    break;
                case "S":
                case "s":

                    break;
                default:

            }
        }


    }
}
