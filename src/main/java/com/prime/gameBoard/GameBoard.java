package com.prime.gameBoard;

import com.prime.cardDeck.Deck;
import com.prime.Dealer.Dealer;
import com.prime.player.Player;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class GameBoard {
    private final List<Player> players = new ArrayList<>();
    private final Deck deck = new Deck();
    private final Dealer dealer = new Dealer();


    public void addPlayer(String playerName) {
        if(players.size() > 4) {
            return;
        }
        players.add(new Player(playerName));
    }

}
