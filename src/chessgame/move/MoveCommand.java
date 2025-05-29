package chessgame.move;

import chessgame.Board;
import chessgame.Move;
import chessgame.pieces.Piece;

public class MoveCommand implements Command{

    private Board board;
    private Move move;
    private Piece piece;

    public MoveCommand(Board board, Move move){
        this.board = board;
        this.move = move;
        this.piece = move.getMovedPiece();
    }

    @Override
    public void execute() {
        board.removePiece(move.getFrom());
        board.placePiece(piece, move.getTo());

    }

    @Override
    public void undo() {
        //implement undo
    }
}
