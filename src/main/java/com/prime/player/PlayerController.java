package com.prime.player;

import com.prime.cardDeck.Deck;
import com.prime.gameBoard.InputReader;

import java.util.List;
import java.util.Scanner;

public class PlayerController {
    private final InputReader inputReader;
    private final List<Player> players;

    private class defaultReader implements InputReader {
        private final Scanner scanner = new Scanner(System.in);

        public String readInput() {
            return scanner.next();
        }
    }

    public PlayerController(List<Player> players) {
        this.inputReader = new defaultReader();
        this.players = players;
    }

    public void distributeCards(Deck deck) {
        try {
            Thread.sleep(1000);
            System.out.println("Distributing card to each players.. \n");
            for(Player player : players) {
                player.hit(deck.pickCard());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private PlayerCommand insertCommand() {
        while(true) {
            System.out.println("Which one do you want? (hit/stay/show)");
            String answer = inputReader.readInput();
            if (answer.equals("hit")) {
                return PlayerCommand.HIT;
            }
            if (answer.equals("stay")) {
                return PlayerCommand.STAY;
            }
            if (answer.equals("show")) {
                return PlayerCommand.SHOW;
            }
            System.out.println("Please enter a valid option");
        }
    }

    private void doTurn(Player player, Deck deck) {
        try {
            Thread.sleep(1000);
            System.out.println(player.getName() + "'s turn");
            while(!player.isDone()) {
                if(player.isBusted()) {
                    System.out.println(player.getName() + "'s turn is over");
                    return;
                }
                System.out.println(player.getStatus());
                PlayerCommand command = insertCommand();
                if(command == PlayerCommand.STAY) {
                    player.stay();
                }
                if(command == PlayerCommand.HIT) {
                    player.hit(deck.pickCard());
                }
                if(command == PlayerCommand.SHOW) {
                    System.out.println(player.getStatus());
                }
            }
        } catch(Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void doEachPlayerTurn(Deck deck) {
        for(Player player : players) {
            doTurn(player, deck);
        }
    }




}
