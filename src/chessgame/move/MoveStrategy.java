package chessgame.move;

import chessgame.Board;
import chessgame.Position;

import java.util.List;

public interface MoveStrategy {

    public List<Position> getValidMoves(Board board, Position from);
}
