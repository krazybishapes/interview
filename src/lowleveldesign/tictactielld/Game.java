package lowleveldesign.tictactielld;

public class Game {

    char[][] board;
    Player X;
    Player Y;
    GameStatus gameStatus;
    PlayerService playerService;

    public void initGame(Game game){
        board = new char[3][3];
        X = new Player();
        Y = new Player();
        gameStatus = GameStatus.IN_PLAY;
        playerService = new PlayerService(game);
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public static void main(String[] args) {

        Game game = new Game();

        game.initGame(game);

        game.startGame();

        game.getStatus(game);
    }

    private void getStatus(Game game) {
        if(WinStatus.WINNER.equals(X.getWinStatus()) || WinStatus.WINNER.equals(Y.getWinStatus())) game.setGameStatus(GameStatus.COMPLETED);
        System.out.println("Game status:"+game.gameStatus+" and Player X:"+ X.getWinStatus() + " and Player Y:" + Y.getWinStatus());
    }

    private void startGame() {


        playerService.move(0, 0, X);
        playerService.move(1, 1, Y);
        playerService.move(0, 1, X);
        playerService.move(1, 0, Y);
        playerService.move(0, 2, X);


    }
}
