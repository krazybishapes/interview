package graph;

import java.util.*;

public class graph {

    public static void main(String[] args) {
      //create graph with 10 nodes
        int[][] graph = {{0, 1, 2},
                         {1, 0, 3},
                         {2, 0, 4},
                         {3, 1, 5},
                         {4, 2, 6},
                         {5, 3, 7},
                         {6, 4, 8},
                         {7, 5, 9},
                         {8, 6},
                         {9, 7}};

        Map<Integer, List<Integer>> adjacentList = createAdjList(graph);

        //bfs(adjacentList, 0);
        //Stack<Integer> stack = new Stack<>();
        //dfs(adjacentList,0,stack);
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[adjacentList.size()];
        getAllPathfromSrctoTarget(new Stack<>(), adjacentList, 0, 5,result, visited);
        for(List<Integer> res: result){
            System.out.println(res.toString());
        }



    }

    private static void getAllPathfromSrctoTarget(Stack<Integer> stack, Map<Integer, List<Integer>> adjacentList, int src, int target, List<List<Integer>> result, boolean[] visited ) {

        if(src == target){
            List<Integer> path = new ArrayList<>();
            for(int i=0;i<stack.size();i++){
                //System.out.println("path" + stack.get(i));
                path.add(stack.get(i));
            }
            result.add(path);
            return;
        }

        stack.add(src);
        visited[src] = true;

        for(int neighbour : adjacentList.get(src)){
            if(!visited[neighbour]){
                stack.push(neighbour);
                getAllPathfromSrctoTarget(stack, adjacentList, neighbour, target, result, visited);
                stack.pop();
            }

        }
    }

    private static void dfs(Map<Integer, List<Integer>> adjacentList, int i,Stack<Integer> stack ) {
        boolean[] visited = new boolean[adjacentList.size()];
        dfsHelper(adjacentList, i, visited, stack);
    }

    private static void dfsHelper(Map<Integer, List<Integer>> adjacentList, int i, boolean[] visited,Stack<Integer> stack ) {
        visited[i] = true;
        stack.push(i);

        for(int neighbour : adjacentList.get(i)){
            if(!visited[neighbour]){
                dfsHelper(adjacentList, neighbour, visited,stack);
            }
        }
    }

    private static void bfs(Map<Integer, List<Integer>> adjacentList, int root) {
        List<Integer> queue = new ArrayList<>();
        boolean[] visited = new boolean[adjacentList.size()];

        queue.add(root);
        visited[root] = true;

        while(!queue.isEmpty()){
            int node = queue.remove(0);
            System.out.print(node + " ");

            for(int neighbour : adjacentList.get(node)){
                if(!visited[neighbour]){
                    queue.add(neighbour);
                    visited[neighbour] = true;
                }
            }
        }
    }

    private static Map<Integer, List<Integer>> createAdjList(int[][] graph) {
        Map<Integer, List<Integer>> adjacentList = new HashMap<>();

        for(int i=0;i<graph.length;i++){
            int node = graph[i][0];
            List<Integer> neighbours = adjacentList.getOrDefault(node, new ArrayList<>());

            for(int j=1;j<graph[i].length;j++){
                neighbours.add(graph[i][j]);
            }
            adjacentList.put(node, neighbours);

        }

        return adjacentList;

    }


}
