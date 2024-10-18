package com.prime.gameBoard;
import java.util.Scanner;

public class Controller {
    private final InputReader inputReader;

    private class defaultReader implements InputReader {
        private final Scanner scanner = new Scanner(System.in);

        public String readInput() {
            return scanner.next();
        }
    }

    public Controller() {
        this.inputReader = new defaultReader();
    }

    public Controller(InputReader inputReader) {
        this.inputReader = inputReader;
    }


    public boolean addMorePlayer() {
        while (true) {
            String addMorePlayerQuestion = "Do you want to add more player? (y/n)";
            System.out.println(addMorePlayerQuestion);
            String answer = inputReader.readInput();

            if (answer.equals("yes") || answer.equals("y")) {
                return true;
            }
            if (answer.equals("no") || answer.equals("n")) {
                return false;
            }
            String inputValueError = "Invalid input detected. Please try again.";
            System.out.println(inputValueError);
        }
    }

    public String addPlayerName() {
        String addPlayerNameQuestion = "Enter player name : ";
        System.out.println(addPlayerNameQuestion);
        String playerName = inputReader.readInput();
        return playerName;
    }
}