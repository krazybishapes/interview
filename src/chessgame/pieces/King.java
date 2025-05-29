package chessgame.pieces;

import chessgame.Position;
import chessgame.enums.Color;
import chessgame.enums.PieceType;
import chessgame.move.KingMoveStrategy;

public class King extends Piece{

    public King(Color color, Position position){
        super(color, position, new KingMoveStrategy());
    }
    @Override
    PieceType getPieceType() {
        return PieceType.KING;
    }
}
