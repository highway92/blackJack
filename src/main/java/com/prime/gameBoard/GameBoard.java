package com.prime.gameBoard;

import com.prime.cardDeck.Deck;
import com.prime.player.Player;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

public class GameBoard {

    private List<Player> players = new ArrayList<Player>();
    private Deck deck = new Deck();

    private void gatherPlayer() {
        if(players.size() > 4) {
            // todo 최대 게임 가능인원은 4명으로 4명이상이 등록하려고 할 경우 게임을 시작해야함
        }
        String playerName = "";
        Console console = System.console();
        playerName = console.readLine("Enter Player name: ");
        Player newPlayer = new Player(playerName,deck.pickCard(),deck.pickCard());
        players.add(newPlayer);
    }
}
