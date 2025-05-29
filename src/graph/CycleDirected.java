package graph;

import java.util.*;

public class CycleDirected {

    public static void main(String[] args) {
        int[][] edges = {
                {0, 1},
                {1, 2},
                {2, 3},
                {3, 1} // 🔁 This creates a cycle: 1 → 2 → 3 → 1
        };

        Map<Integer, List<Integer>> graph = new HashMap<>();

        for(int i=0;i<4;i++){
            int first = edges[i][0];
            int second = edges[i][1];
            graph.computeIfAbsent(first,k->new ArrayList<>()).add(second);
        }
        Set<Integer> visited = new HashSet<>();
        Set<Integer> visiting = new HashSet<>();
        for(int i=0;i<4;i++){
            if(!visited.contains(i)){
                if(detectCycle(graph,visited, visiting,i)){
                    System.out.println("cycle detected");
                    break;
                }
            }
        }


    }

    private static boolean detectCycle(Map<Integer, List<Integer>> graph, Set<Integer> visited,Set<Integer> visiting, int src) {

        if(visited.contains(src)) return false;
        if(visiting.contains(src)) return true;

        visiting.add(src);
        for(int neighbour: graph.get(src)){

            if(detectCycle(graph,visited,visiting,neighbour)){
                return true;
            }

        }
        visiting.remove(src);
        visited.add(src);

        return false;
    }
}
