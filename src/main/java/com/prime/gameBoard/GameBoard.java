package com.prime.gameBoard;

import com.prime.cardDeck.Card;
import com.prime.cardDeck.Deck;
import com.prime.player.Dealer;
import com.prime.player.Player;

import java.util.ArrayList;
import java.util.List;

public class GameBoard {

    private List<Player> players = new ArrayList<Player>();
    private Deck deck = new Deck();
    private Controller controller;
    private Dealer dealer;

    public GameBoard(Controller controller, Dealer dealer) {
        this.controller = controller;
        this.dealer = dealer;
        gatherPlayers();
        prepareGameStart();

    }

    public void gatherPlayers() {
        System.out.println("Gathering players for Black Jack");
        boolean isGatheringEnd = false;
        while (!isGatheringEnd){
            if(players.size() >= 4) {
                isGatheringEnd = true;
                break;
            }
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

}
