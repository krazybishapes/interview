package chessgame.pieces;

import chessgame.Position;
import chessgame.enums.Color;
import chessgame.enums.PieceType;
import chessgame.move.MoveStrategy;

public abstract  class Piece {
    Color color;
    Position position;
    MoveStrategy moveStrategy;

    public Piece(Color color, Position position, MoveStrategy moveStrategy){
        this.color = color;
        this.position = position;
        this.moveStrategy = moveStrategy;
    }

    abstract PieceType getPieceType();

}
