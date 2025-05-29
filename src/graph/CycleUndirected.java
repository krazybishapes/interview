package graph;

import java.util.*;

public class CycleUndirected {

    public static void main(String[] args) {

        int[][] edges = {
                {0, 1},
                {1, 2},
                {2, 3},
                {3,0}// This edge creates the cycle
        };

        Map<Integer, List<Integer>> graph = new HashMap<>();

        for(int[] edge: edges){
            int first = edge[0];
            int second = edge[1];
            graph.computeIfAbsent(first,k->new ArrayList<>()).add(second);
            graph.computeIfAbsent(second,k->new ArrayList<>()).add(first);

        }
        Set<Integer> visited = new HashSet<>();
        for(int i=0;i< graph.size();i++){
            if(!visited.contains(i)){
                if(detectCycle(graph,visited,i,-1)){
                    System.out.println("cycle detected");
                }
            }
        }
    }

    private static boolean detectCycle(Map<Integer, List<Integer>> graph, Set<Integer> visited, int source, int parent) {


        visited.add(source);
        for(int node: graph.get(source)){
            if(!visited.contains(node )){
                if(detectCycle(graph,visited,node, source)){
                    return true;
                }
            }else if(node != parent){
                return true;
            }
        }

        return false;
    }
}
