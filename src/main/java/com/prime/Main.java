package com.prime;
import com.prime.gameBoard.GameBoard;
import com.prime.gameBoard.GameBoardController;


public class Main {
    public static void main(String[] args) {
        GameBoard gameBoard = new GameBoard();
        new GameBoardController(gameBoard);
    }
}