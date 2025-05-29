package chessgame;

import chessgame.enums.Color;

public class Game {

    private static Game instance;
    private Board board;
    private Player[] players;
    private Color currentPlayer;

    private Game(){}

    public Game getInstance(){
        if(instance == null){
            instance = new Game();
        }
        return  instance;
    }

    public void startGame(){
        board.initializeBoard();
        while(!isGameOver()){
            Color player = currentPlayer;

            //get player move
            Move move = getPlayerMove();
            //use move command to move the piece

            currentPlayer = player==Color.WHITE ? Color.BLACK: Color.WHITE;
        }

    }

    private Move getPlayerMove() {
        //get all available moves for selected piece using move strateg
        // y
        return null;
    }

    private boolean isGameOver() {
        return false;
    }
}
