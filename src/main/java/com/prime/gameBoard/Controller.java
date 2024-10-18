package com.prime.gameBoard;

import java.util.Scanner;

public class Controller {
    private final Scanner scanner = new Scanner(System.in);
    private final String addMorePlayerQuestion = "Do you want to add more player? (y/n)";
    private final String inputValueError = "Invalid input detected. Please try again.";
    private final String addPlayerNameQuestion = "Enter player name : ";

    public Controller() {}


    public boolean addMorePlayer() {
        while (true) {
            System.out.println(addMorePlayerQuestion);
            String answer = scanner.next().toLowerCase().trim();

            if (answer.equals("yes") || answer.equals("y")) {
                return true;
            }
            if (answer.equals("no") || answer.equals("n")) {
                return false;
            }
            System.out.println(inputValueError);
        }
    }

    public String addPlayerName() {
        System.out.println(addPlayerNameQuestion);
        String playerName = scanner.next();
        return playerName;
    }
}