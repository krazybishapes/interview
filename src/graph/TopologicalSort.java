package graph;

import java.util.*;

public class TopologicalSort {

    public static void main(String[] args) {
        int numCourses = 6;
        int[][] prerequisites = {
                {2, 5},
                {0, 5},
                {0, 4},
                {1, 4},
                {3, 2},
                {1, 3}
        };
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i=0;i< numCourses;i++){
            int course = prerequisites[i][0];
            int pre = prerequisites[i][1];
            graph.computeIfAbsent(course,k->new ArrayList<>()).add(pre);
        }
        Stack<Integer> stack = new Stack<>();
        HashSet<Integer> visited = new HashSet<>();
        //Implementation of directed graph
        for(int i=0;i<numCourses;i++){
            if(!visited.contains(i)){
                topologicalSort(graph,stack,visited,i);

            }
        }

        while(!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
        System.out.println();


    }

    private static void topologicalSort(Map<Integer, List<Integer>> graph, Stack<Integer> stack,HashSet<Integer> visited, int start){


        visited.add(start);
        for(int course: graph.getOrDefault(start, List.of())){
            if(!visited.contains(course)){
                topologicalSort(graph,stack,visited,course);
            }
        }

        stack.add(start);
    }
}
