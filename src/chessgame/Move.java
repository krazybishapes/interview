package chessgame;

import chessgame.pieces.Piece;

public class Move {
    Position from;
    Position to;
    Piece movedPiece;
    Piece capturedPiece;

    public Move(Position from, Position to, Piece movedPiece, Piece capturedPiece){
        this.from= from;
        this.to = to;
        this.movedPiece = movedPiece;
        this.capturedPiece = capturedPiece;
    }

    public Position getFrom() {
        return from;
    }

    public void setFrom(Position from) {
        this.from = from;
    }

    public Position getTo() {
        return to;
    }

    public void setTo(Position to) {
        this.to = to;
    }

    public Piece getMovedPiece() {
        return movedPiece;
    }

    public void setMovedPiece(Piece movedPiece) {
        this.movedPiece = movedPiece;
    }

    public Piece getCapturedPiece() {
        return capturedPiece;
    }

    public void setCapturedPiece(Piece capturedPiece) {
        this.capturedPiece = capturedPiece;
    }
}
