package com.pjs;

public class Main {

    public static void main(String[] args) {
        TicTacToeGame ticTacToeGame = new TicTacToeGame();
        ticTacToeGame.initGame(3);
        ticTacToeGame.printBoard();
        ticTacToeGame.startGame();
    }
}