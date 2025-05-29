package chessgame.move;

import chessgame.Board;
import chessgame.Position;

import java.util.List;

public class KingMoveStrategy implements MoveStrategy{
    @Override
    public List<Position> getValidMoves(Board board, Position from) {
        return List.of();
    }
}
