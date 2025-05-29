package graph;

import java.util.ArrayList;
import java.util.List;


public class rottenorange {

    static  int minutes=0;

    public static void main(String[] args) {

        int[][] grid = {
            {2, 1, 1},
            {1, 1, 0},
            {0, 1, 2}
        };

        int result = orangesRotting(grid);
        System.out.println("Minimum time to rot all oranges: " + result);
    }

    private static int orangesRotting(int[][] grid) {
        //add all rotten oranges to queue
        List<Integer> queue = new ArrayList<>();
        for(int i=0;i< grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j] == 2){
                    queue.add(i*grid[i].length + j);
                }

            }
        }
        //do bfs and rott all neighbour orange and increment minute count
        bfs(queue, grid);
        return minutes;
    }

    private static void bfs(List<Integer> queue, int[][] grid) {


        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        while(!queue.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            for(int i=0;i<queue.size();i++){
                int index = queue.get(i);
                int row = index / grid[0].length;
                int col = index % grid[0].length;

                for(int j=0;j<directions.length;j++){
                    int newRow = row + directions[j][0];
                    int newCol = col + directions[j][1];

                    if(newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length && grid[newRow][newCol] == 1){
                        grid[newRow][newCol] = 2;
                        temp.add(newRow*grid[0].length + newCol);
                    }
                }
            }
            if(temp.size() > 0){
                minutes++;
            }
            queue = temp;
        }

    }
}
