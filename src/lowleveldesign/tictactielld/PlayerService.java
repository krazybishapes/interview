package lowleveldesign.tictactielld;

public class PlayerService {

    Game game;
    int n;
    char[][] board;

    int[] rows;
    int[] cols;
    int diagonal;
    int antidiagonal;


    public PlayerService(Game game){
        this.game = game;
        this. n = game.board.length;
        this.board = game.board;
        this.rows = new int[n];
        this.cols = new int[n];
    }

    public boolean move(int row, int col, Player player){

        if (board[row][col] == 'X' || board[row][col] == 'O') {
            return false;
        }
        int dis;
        if("X".equals(player.getName())){
            dis = 1;
            board[row][col] = 'X';
        }else{
            dis = -1;
            board[row][col] = 'O';
        }

        rows[row] +=dis;
        cols[col] += dis;
        if(row == col) diagonal +=dis;
        if(row+col == 2) antidiagonal += dis;

        if(Math.abs(rows[row])==n || Math.abs(cols[col])==n ||
        Math.abs(diagonal)==n | Math.abs(antidiagonal)==n){
            player.setWinStatus(WinStatus.WINNER);
            return true;
        }

        return false;






    }
}
