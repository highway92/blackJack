package com.prime;
import com.prime.gameBoard.Controller;
import com.prime.gameBoard.GameBoard;
import com.prime.player.Dealer;


public class Main {
    public static void main(String[] args) {
        Controller c = new Controller();
        Dealer d = new Dealer();
        new GameBoard(c,d);
    }
}