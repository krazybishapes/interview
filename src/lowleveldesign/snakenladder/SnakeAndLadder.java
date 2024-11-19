package lowleveldesign.snakenladder;

import java.util.ArrayList;
import java.util.List;

public class SnakeAndLadder {

    public static void main(String[] args) {
        List<Player> players = new ArrayList<>();
        Player player1 = new Player(1,"Santosh");
        Player player2 = new Player(2, "Preety");
        players.add(player1);
        players.add(player2);

        Game game = new Game(players);

        Board board = game.getBoard();
        board.addSnake(99, 54);
        board.addSnake(70, 55);
        board.addLadder(2, 38);
        board.addLadder(15, 26);


        game.startGame();

    }
}
