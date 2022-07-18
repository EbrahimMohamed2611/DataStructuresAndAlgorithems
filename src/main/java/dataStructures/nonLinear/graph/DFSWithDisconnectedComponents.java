package dataStructures.nonLinear.graph;

import java.util.ArrayList;
import java.util.List;

public class DFSWithDisconnectedComponents {

    public static List<Integer> dfsTraversal(int v, List<List<Integer>> graph) {
        List<Integer> traversed = new ArrayList<>();
        boolean[] visited = new boolean[v + 1];
        for (int i = 1; i <= v; i++) {
            if (!visited[i]) {
                dfs(i, traversed, graph, visited);
            }
        }
        return traversed;
    }

    private static void dfs(int i, List<Integer> traversed, List<List<Integer>> graph, boolean[] visited) {
        traversed.add(i);
        visited[i] = true;
        for (int neighbour : graph.get(i)) {
            if (!visited[neighbour]) {
                dfs(neighbour, traversed, graph, visited);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= 7; i++) {
            graph.add(i, new ArrayList<>());
        }

        graph.get(1).add(2);
        graph.get(2).add(1);

        graph.get(2).add(7);
        graph.get(7).add(2);
        graph.get(2).add(3);
        graph.get(3).add(2);

        graph.get(7).add(5);
        graph.get(5).add(7);

        graph.get(3).add(5);
        graph.get(5).add(3);

        graph.get(4).add(6);
        graph.get(6).add(4);

        System.out.println(dfsTraversal(7, graph));


    }
}
