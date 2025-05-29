package chessgame;

import chessgame.pieces.Piece;



public class Square {

    Position position;
    Piece piece;

    public Square(Position position){
        this.position = position;
    }

    public boolean isOccupied(){
        return piece!=null;
    }
}
