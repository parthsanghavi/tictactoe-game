package com.pjs.model;

public class Board {

    private int size;
    private BoardPiece[][] boardPieces;

    public Board(int boardSize) {
        this.size = boardSize;
        this.boardPieces = new BoardPiece[boardSize][boardSize];
    }

    public int getSize() {
        return size;
    }

    public BoardPiece[][] getBoardPieces() {
        return boardPieces;
    }

    public boolean addPiece(int row, int column, BoardPiece boardPiece) {
        if (boardPieces[row][column] != null) {
            return false;
        }
        boardPieces[row][column] = boardPiece;
        return true;
    }

    public boolean areFreeCellsPresent() {
        for (int i = 0; i <= boardPieces.length - 1; i++) {
            for (int j = 0; j <= boardPieces.length - 1; j++) {
                if (boardPieces[i][j] == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public void printBoard() {
        System.out.println("====================================");
        System.out.println("Displaying the board !!!");
        System.out.println("====================================");
        for (int i = 0; i <= boardPieces.length - 1; i++) {
            for (int j = 0; j <= boardPieces.length - 1; j++) {
                if (boardPieces[i][j] != null) {
                    System.out.print(boardPieces[i][j].getBoardPieceType().name() + "   ");
                } else {
                    System.out.print("    ");
                }
                System.out.print(" | ");
            }
            System.out.println();
        }
    }
}
