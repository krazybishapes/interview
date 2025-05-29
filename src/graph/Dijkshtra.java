package graph;

import java.util.*;

public class Dijkshtra {

    static class Edge{
        int source;
        int dest;
        int weight;

        public Edge(int dest, int weight){
            this.dest = dest;
            this.weight = weight;
        }

        public Edge(int source, int dest, int weight){
            this.source = source;
            this.dest = dest;
            this.weight = weight;
        }
    }


    public static void main(String[] args) {

        int[][] edges = {
                {0, 1, 4},
                {0, 2, 1},
                {2, 1, 2},
                {1, 3, 1},
                {2, 3, 5}
        };
        Map<Integer, List<Edge>> graph = buildGraph(edges,4);

        findShortestDistance(graph,0);

    }

    private static void findShortestDistance(Map<Integer, List<Edge>> graph, int source) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        int[] distance = new int[graph.size()];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[0] = 0;
        queue.add(new int[]{source,0});
        boolean[] visited = new boolean[graph.size()];

        while(!queue.isEmpty()){
            int[] pair = queue.poll();
            source = pair[0];
            if (!visited[source]) {

                visited[source] = true;

                for(Edge edge: graph.get(source)){
                    int dest = edge.dest;
                    int weight = edge.weight;
                    if(distance[dest]> distance[source]+weight){
                        distance[dest] = distance[source]+weight;
                        queue.add(new int[]{dest, distance[dest]});
                    }

                }
            }
        }

        for(int dis: distance){
            System.out.println(dis);
        }
    }

    public static Map<Integer, List<Edge>> buildGraph(int[][] edges, int n) {
        Map<Integer, List<Edge>> graph = new HashMap<>();

        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            graph.get(u).add(new Edge(v,w));

            // If the graph is undirected, add this line:
            // graph.get(v).add(new int[]{u, w});
        }

        return graph;
    }

}
