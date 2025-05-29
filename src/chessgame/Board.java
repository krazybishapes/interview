package chessgame;

import chessgame.pieces.Piece;

public class Board {

    Square[][] squares;

    public Board(){
        squares = new Square[8][8];
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                squares[i][j] = new Square(new Position(i,j));
            }
        }
    }

    public void placePiece(Piece piece, Position position){
        squares[position.row][position.col].piece = piece;
    }

    public void removePiece(Position position){
        squares[position.row][position.col].piece = null;
    }

    public void initializeBoard() {
    }
}
