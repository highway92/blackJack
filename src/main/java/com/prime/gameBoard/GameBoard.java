package com.prime.gameBoard;

import com.prime.cardDeck.Deck;
import com.prime.player.Player;

import java.util.ArrayList;
import java.util.List;

public class GameBoard {

    private List<Player> players = new ArrayList<Player>();
    private Deck deck = new Deck();
    private Controller controller;

    public GameBoard(Controller controller) {
        this.controller = controller;
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


}
