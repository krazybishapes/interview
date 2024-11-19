package lowleveldesign.snakenladder;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Game {


    Queue<Player> players;
    Dice dice;
    Board board;

    public Board getBoard() {
        return board;
    }

    public Game(List<Player> playerList){
        players = new LinkedList<>(playerList);
        dice = new Dice();
        board = new Board(100);
    }

    public void startGame(){

        while(true){
            Player player = players.poll();
            play(player);
            if(isWinner(player)){
                System.out.println("Player:" + player.getName()+" is winner.");
                break;
            }
            players.add(player);

        }

    }

    private boolean isWinner(Player player) {
        if(player.getCurrentPosition()>= board.getSize()){
            System.out.println(player.getCurrentPosition());
            player.setStatus(PlayerStatus.WINNER);
            return true;
        }
        return false;
    }

    private void play(Player player) {
        int val = dice.roll();
        System.out.println("Player:" + player.getName()+" got dice value:" + val);
        int currentPosition = player.getCurrentPosition();
        int newPosition = currentPosition + val;
        if(board.getSnakeOrLadderPosition(newPosition)!=-1){
            newPosition = board.getSnakeOrLadderPosition(newPosition);
        }
        player.setPosition(newPosition);


    }


}
