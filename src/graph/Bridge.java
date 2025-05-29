package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bridge {

    static int time = 0;

    public static void main(String[] args) {
        int[][] connections = {
                {0, 1},
                {1, 2},
                {2, 0},
                {1, 3}
        };

        Map<Integer, List<Integer>> graph = new HashMap<>();

        for(int[] connection: connections){
            int source = connection[0];
            int dest = connection[1];
            graph.computeIfAbsent(source, k-> new ArrayList<>()).add(dest);
            graph.computeIfAbsent(dest, k-> new ArrayList<>()).add(source);
        }

//        graph.forEach((k,v)->{
//            System.out.println(k+" "+ v);
//        });

        int n = 4;
        int[] dt = new int[n+1];
        int[] low = new int[n+1];

        boolean[] visited = new boolean[n];

        for(int i=0;i<4;i++){
            if(!visited[i]){
                dfs(graph,visited,dt, low,i, -1);
            }
        }
    }

    private static void dfs(Map<Integer,List<Integer>> graph, boolean[] visited, int[] dt, int[] low, int source, int parent){

        visited[source] = true;
        dt[source]  = low[source] = ++time;

        //System.out.println(source);

        for(int nei: graph.getOrDefault(source, new ArrayList<>())){
            //parent

            //System.out.println(source);
            if(nei == parent){
                continue;
            }
            //not visited
            else if(!visited[nei]){
                dfs(graph,visited,dt,low,nei,source);
                low[source] = Math.min(low[source], low[nei]);
                //if bridge

                if(dt[source]<low[nei]){
                    System.out.println(nei + "----"+ source);
                }
            }else{
                low[source] = Math.min(low[source], dt[nei]);
            }
        }

    }


}
