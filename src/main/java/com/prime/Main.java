package com.prime;
import com.prime.Dealer.DealerController;
import com.prime.gameBoard.GameBoard;
import com.prime.gameBoard.GameBoardController;
import com.prime.player.PlayerController;


public class Main {
    public static void main(String[] args) {
        GameBoard gameBoard = new GameBoard();
        new GameBoardController(gameBoard);
    }
}