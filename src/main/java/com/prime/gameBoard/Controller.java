package com.prime.gameBoard;
import java.util.Scanner;

public class Controller {
    private final InputReader inputReader;
    private final String addMorePlayerQuestion = "Do you want to add more player? (y/n)";
    private final String inputValueError = "Invalid input detected. Please try again.";
    private final String addPlayerNameQuestion = "Enter player name : ";

    private class defaultReader implements InputReader {
        private Scanner scanner = new Scanner(System.in);

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
            System.out.println(addMorePlayerQuestion);
            String answer = inputReader.readInput();

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
        String playerName = inputReader.readInput();
        return playerName;
    }
}