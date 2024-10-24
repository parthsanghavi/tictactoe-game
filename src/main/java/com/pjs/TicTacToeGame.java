package com.pjs;

import com.pjs.enums.BoardPieceType;
import com.pjs.model.Board;
import com.pjs.model.BoardPiece;
import com.pjs.model.BoardPieceO;
import com.pjs.model.BoardPieceX;
import com.pjs.model.Player;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class TicTacToeGame {

    private final Deque<Player> players;
    private Board board;

    public TicTacToeGame() {
        this.players = new LinkedList<>();
    }

    public void initGame(int n) {
        Player player1 = new Player("P1", new BoardPieceO());
        Player player2 = new Player("P2", new BoardPieceX());
        players.add(player1);
        players.add(player2);
        this.board = new Board(n);
    }

    public void startGame() {
        while (true) {

            if (!board.areFreeCellsPresent()) {
                System.out.println("Game Tied !!");
                break;
            }

            Player playerTurn = findPlayerTurn();
            System.out.println("Player Turn: " + playerTurn.getName());

            System.out.println("Enter the row,column: ");
            Scanner scanner = new Scanner(System.in);
            String s = scanner.nextLine();
            String[] values = s.split(",");
            int row = Integer.parseInt(values[0]);
            int column = Integer.parseInt(values[1]);
            boolean isPieceAdded = board.addPiece(row, column, playerTurn.getBoardPiece());
            if (!isPieceAdded) {
                System.out.println("Incorrect position chosen, try again: ");
                players.addFirst(playerTurn);
                continue;
            }

            printBoard();
            boolean isThereAWinner = isThereAWinner(row, column, playerTurn.getBoardPiece().getBoardPieceType());
            if (isThereAWinner) {
                System.out.println("Winner: " + playerTurn.getName());
                break;
            }
        }
    }

    public void printBoard() {
        board.printBoard();
    }

    private Player findPlayerTurn() {

        Player playerTurns = players.removeFirst();
        players.addLast(playerTurns);
        return playerTurns;
    }

    public boolean isThereAWinner(int inputRow, int inputColumn, BoardPieceType boardPieceType) {
        boolean rowMatch = true;
        boolean columnMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;

        //check row
        for (int i = 0; i < board.getSize(); i++) {
            if (board.getBoardPieces()[inputRow][i] == null || board.getBoardPieces()[inputRow][i].getBoardPieceType() != boardPieceType) {
                rowMatch = false;
            }
        }

        //check column
        for (int i = 0; i < board.getSize(); i++) {
            if (board.getBoardPieces()[i][inputColumn] == null || board.getBoardPieces()[i][inputColumn].getBoardPieceType() != boardPieceType) {
                columnMatch = false;
            }
        }

        //check diagonal
        for (int i=0, j=0; i < board.getSize(); i++,j++) {
            if (board.getBoardPieces()[i][j] == null || board.getBoardPieces()[i][j].getBoardPieceType() != boardPieceType) {
                diagonalMatch = false;
            }
        }

        //check anti diagonal
        for (int i=0, j=board.getSize()-1; i < board.getSize(); i++,j--) {
            if (board.getBoardPieces()[i][j] == null || board.getBoardPieces()[i][j].getBoardPieceType() != boardPieceType) {
                antiDiagonalMatch = false;
            }
        }

        return rowMatch || columnMatch || diagonalMatch || antiDiagonalMatch;
    }

}
