package chessgame;

import chessgame.enums.Color;

public class Player {
    String name;
    boolean isWinner;
    Color color;

    public Player(String name, Color color){
        this.name = name;
        this.color = color;
    }

    public void makeMove(Board board, Move move){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isWinner() {
        return isWinner;
    }

    public void setWinner(boolean winner) {
        isWinner = winner;
    }
}
