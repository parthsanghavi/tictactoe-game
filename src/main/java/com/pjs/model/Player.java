package com.pjs.model;

public class Player {

    private String name;
    private BoardPiece boardPiece;

    public Player(String name, BoardPiece boardPiece) {
        this.name = name;
        this.boardPiece = boardPiece;
    }

    public String getName() {
        return name;
    }

    public BoardPiece getBoardPiece() {
        return boardPiece;
    }
}
