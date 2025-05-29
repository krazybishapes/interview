package graph;

import java.util.*;

public class MSTPrisms {

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
                {0, 1, 10},
                {0, 2, 6},
                {0, 3, 5},
                {1, 3, 15},
                {2, 3, 4}
        };

        Map<Integer, List<Edge>> graph = buildGraph(edges,4);
        findMST(graph,4);
    }

    private static void findMST(Map<Integer, List<Edge>> graph, int v) {

        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->Integer.compare(a[1],b[1]));
        queue.offer(new int[]{0,0});
        boolean[] visited = new boolean[v];
        int cost = 0;
        List<Integer> path = new ArrayList<>();
        while(!queue.isEmpty()){
            int[] pair = queue.poll();
            int source = pair[0];

            if(!visited[source]){
                visited[source] = true;
                path.add(source);
                cost+=pair[1];
                //System.out.println(source +" "+ cost);
                for(Edge edge: graph.get(source)){
                    if(!visited[edge.dest]){
                        queue.add(new int[]{edge.dest, edge.weight});
                    }

                }
            }
        }

        System.out.println(cost);
        for(int p: path){
            System.out.println(p);
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
            graph.get(v).add(new Edge(v,u,w));
        }

        return graph;
    }


}
