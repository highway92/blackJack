package com.prime.gameBoard;

import com.prime.Dealer.Dealer;
import com.prime.Dealer.DealerController;
import com.prime.player.Player;
import com.prime.player.PlayerController;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameBoardController {
    private final InputReader inputReader;
    private final GameBoard gameBoard;
    private final DealerController dealerController;
    private final PlayerController playerController;

    private class defaultReader implements InputReader {
        private final Scanner scanner = new Scanner(System.in);

        public String readInput() {
            return scanner.nextLine();
        }
    }

    public GameBoardController(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
        this.inputReader = new defaultReader();
        try {
            welcome();
            gatherPlayers();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.playerController = new PlayerController(gameBoard.getPlayers());
        this.dealerController = new DealerController(gameBoard.getDealer());
        gameStart();
    }

    private void gameStart() {
        try {
            cardDistribute();
            playersTurn();
            dealerTurn();
            defineWinner();
            thankYouForPlaying();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void welcome() throws Exception {
        Thread.sleep(1500);
        System.out.println("Welcome this is command line BlackJack");
        Thread.sleep(1500);
        System.out.println("Let's play some game now o(*^＠^*)o ");
    }

    private void addPlayer() throws Exception {
        Thread.sleep(1500);
        System.out.println("Enter player name : ");
        String playerName = inputReader.readInput();
        gameBoard.addPlayer(playerName);
        Thread.sleep(1000);
    }


    private void gatherPlayers() throws Exception {
        addPlayer();
        while (true) {
            System.out.println("Do you want to add more player? (y/n)");
            String answer = inputReader.readInput();
            if (answer.equals("yes") || answer.equals("y")) {
                addPlayer();
            }else if (answer.equals("no") || answer.equals("n")) {
                break;
            } else {
                System.out.println("Invalid input detected. Please try again.");
            }
        }
    }

    private void cardDistribute() throws Exception {
        playerController.distributeCards(gameBoard.getDeck());
        dealerController.distributeCards(gameBoard.getDeck());
        playerController.distributeCards(gameBoard.getDeck());
        dealerController.distributeCards(gameBoard.getDeck());
        Thread.sleep(1500);
        System.out.println("All Cards distributed");
        Thread.sleep(1500);
        System.out.println("Now Begin with " + gameBoard.getPlayers().size() + " players");
    }

    private void playersTurn() throws Exception {
        playerController.doEachPlayerTurn(gameBoard.getDealer(), gameBoard.getDeck());
    }

    private void dealerTurn() throws Exception {
        dealerController.doTurn(gameBoard.getDeck());
    }

    private void defineWinner() throws Exception {
        Thread.sleep(1000);
        System.out.println("Let's see who's winner");
        Dealer dealer = gameBoard.getDealer();
        List<Player> winners = new ArrayList<>();
        if (dealer.isBusted()) {
            for (Player player : gameBoard.getPlayers()) {
                if (!player.isBusted()) {
                    winners.add(player);
                }
            }
        } else {
            if (dealer.getScore().equals(21)) {
                for (Player player : gameBoard.getPlayers()) {
                    if (player.getScore().equals(21)) {
                        winners.add(player);
                    }
                }
            } else {
                for (Player player : gameBoard.getPlayers()) {
                    if (player.getScore() > dealer.getScore()) {
                        winners.add(player);
                    }
                }
            }
        }

        if (winners.size() > 0) {
            for (Player player : winners) {
                System.out.println(player.getName() + " won the game");
                System.out.println(player.getStatus());
                System.out.println("---------------------------");
            }
        } else {
            System.out.println("Dealer won the game");
            System.out.println(dealer.getFullStatus());
        }
    }

    private void thankYouForPlaying() throws Exception {
        Thread.sleep(1000);
        System.out.println("Thank you for playing!");
    }

}