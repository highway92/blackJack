package com.prime.gameBoard;

import com.prime.cardDeck.Deck;
import com.prime.player.Player;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class GameBoard {

    private List<Player> players = new ArrayList<Player>();
    private Deck deck = new Deck();
    private Scanner scanner = new Scanner(System.in);

    public GameBoard() {
        gatherPlayers();
    }

    public void gatherPlayers() {
        System.out.println("Gathering players for Black Jack");
        boolean isGatheringEnd = false;
        while (!isGatheringEnd){
            if(players.size() >= 4) {
                isGatheringEnd = true;
                break;
            }
            addPlayer();
            System.out.println("Do you want to add more player (true / false)");
            boolean addMorePlayer = scanner.nextBoolean();
            isGatheringEnd = !addMorePlayer;
        }
    }

    private void addPlayer() {
        System.out.println("Enter player name: ");
        String playerName = scanner.next();
        Player newPlayer = new Player(playerName,deck.pickCard(),deck.pickCard());
        players.add(newPlayer);
    }


}
