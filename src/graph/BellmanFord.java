package graph;

import java.util.*;


public class BellmanFord {

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

    public static Map<Integer, List<Edge>> buildGraph(int[][] edges, int n) {
        Map<Integer, List<Edge>> graph = new HashMap<>();

        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            graph.get(u).add(new Edge(u,v,w));

            // If the graph is undirected, add this line:
            // graph.get(v).add(new int[]{u, w});
        }

        return graph;
    }


    public static void main(String[] args) {
        int[][] edges = {
                {0, 1, 4},
                {0, 2, 5},
                {1, 2, -3},
                {2, 3, 4},
                {3, 1, 2}
        };
        Map<Integer, List<Edge>> graph = buildGraph(edges,4);

        findShortestDistance(graph,4,0);

        int[][] edges1 = {
                {0, 1, 1},
                {1, 2, -1},
                {2, 3, -1},
                {3, 1, -1}  // Creates a negative cycle: 1 -> 2 -> 3 -> 1
        };

        Map<Integer, List<Edge>> graph1 = buildGraph(edges,4);

        findShortestDistanceWithNegative(graph,4,0);
    }

    private static void findShortestDistanceWithNegative(Map<Integer, List<Edge>> graph, int size, int source) {
        int[] distance = new int[size];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[source] = 0;
        for(int i=0;i<size-1;i++){
            for(int j=0;j<size;j++){
                for(Edge edge: graph.get(j)){
                    source = edge.source;
                    int dest = edge.dest;
                    int weight = edge.weight;
                    if(distance[source] != Integer.MAX_VALUE && distance[dest]>distance[source]+weight){
                        distance[dest] = distance[source]+weight;
                    }

                }
            }

        }

        for(int j=0;j<size;j++){
            for(Edge edge: graph.get(j)){
                source = edge.source;
                int dest = edge.dest;
                int weight = edge.weight;
                if(distance[source] != Integer.MAX_VALUE && distance[dest]<distance[source]+weight){
                    System.out.println("cycle exist");
                    return;
                }

            }
        }
    }

    private static void findShortestDistance(Map<Integer, List<Edge>> graph, int size, int source) {

        int[] distance = new int[size];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[source] = 0;
        for(int i=0;i<size-1;i++){
            for(int j=0;j<size;j++){
                for(Edge edge: graph.get(j)){
                    source = edge.source;
                    int dest = edge.dest;
                    int weight = edge.weight;
                    if(distance[source] != Integer.MAX_VALUE && distance[dest]>distance[source]+weight){
                        distance[dest] = distance[source]+weight;
                    }

                }
            }

        }

        for(int dis: distance){
            System.out.println(dis);
        }
    }
}
