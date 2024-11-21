package com.prime.gameBoard;

import com.prime.cardDeck.Deck;
import com.prime.player.Action;
import com.prime.player.Dealer;
import com.prime.player.Player;

import java.util.ArrayList;
import java.util.List;

public class GameBoard {

    private final List<Player> players = new ArrayList<>();
    private final Deck deck = new Deck();
    private final Controller controller;
    private final Dealer dealer;

    public GameBoard(Controller controller, Dealer dealer) {
        this.controller = controller;
        this.dealer = dealer;
        gatherPlayers();
        prepareGameStart();
    }

    public void gatherPlayers() {
        System.out.println("Gathering players for Black Jack");
        boolean isGatheringEnd = false;
        while (players.size() <= 4 && !isGatheringEnd) {
            Player newPlayer = new Player(controller.addPlayerName());
            players.add(newPlayer);
            boolean addMorePlayer = controller.addMorePlayer();
            isGatheringEnd = !addMorePlayer;
        }
    }

    public void prepareGameStart() throws RuntimeException {
        try {
        System.out.println("Distributing first card to each players.. \n");
        for(Player player : players) {
            player.hit(deck.pickCard());
        }
        Thread.sleep(1000);
        System.out.println("Distributing first card to dealer.. \n");
        dealer.hit(deck.pickCard());
        Thread.sleep(1000);

        System.out.println("Distributing second card to each players.. \n");
        for(Player player : players) {
            player.hit(deck.pickCard());
        }
        Thread.sleep(1000);
        System.out.println("Distributing second card to dealer.. \n");
        dealer.hit(deck.pickCard());
        Thread.sleep(1000);
        System.out.println("Distributing finished Let's start ╰(*°▽°*)╯ \n");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void playersTurn() {
        try {
            for(Player player : players) {
                System.out.println(player.getName() + "'s turn");
                while(!player.isDone()) {
                    player.printStatus();
                    Action action = controller.hitOrStay(player);
                    if (action.equals(Action.HIT)) {
                        player.hit(deck.pickCard());
                    } else if (action.equals(Action.STAY)) {
                        player.stay();
                    } else {
                        player.printStatus();
                    }
                }
                System.out.println(player.getName() + "'s turn end o(*^＠^*)o ");
            }
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }


}
