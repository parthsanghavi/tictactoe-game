package com.pjs.model;

import com.pjs.enums.BoardPieceType;

public class BoardPiece {

    BoardPieceType boardPieceType;

    public BoardPiece(BoardPieceType boardPieceType) {
        this.boardPieceType = boardPieceType;
    }

    public BoardPieceType getBoardPieceType() {
        return boardPieceType;
    }
}
