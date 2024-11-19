package lowleveldesign.snakenladder;

import java.util.HashMap;
import java.util.Map;

public class Board {


    int size;
    Map<Integer, Integer> snakePositions;
    Map<Integer,Integer> ladderPositions;

    public Board(int size){
        snakePositions = new HashMap<>();
        ladderPositions = new HashMap<>();
        this.size = size;
    }

    public void addSnake(int x, int y){
        snakePositions.put(x,y);
    }

    public void addLadder(int x, int y){
        snakePositions.put(x,y);
    }

    public boolean isSnake(int x){
        return snakePositions.containsKey(x);
    }

    public boolean isLadder(int x){
        return ladderPositions.containsKey(x);
    }

    public int getSnakeOrLadderPosition(int x){
        if(snakePositions.containsKey(x)){
            return snakePositions.get(x);
        }else if(ladderPositions.containsKey(x)){
            return ladderPositions.get(x);
        }
        return -1;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
