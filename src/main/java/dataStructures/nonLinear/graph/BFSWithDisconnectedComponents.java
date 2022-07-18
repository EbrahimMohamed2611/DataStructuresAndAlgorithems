package dataStructures.nonLinear.graph;

import java.util.*;

public class BFSWithDisconnectedComponents {

    public static List<Integer> bfsTraversal(int v, List<List<Integer>> graph) {
        List<Integer> nodes = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[v + 1];

        for (int i = 1; i <= v; i++) { // to ensure you will iterate over all components
            if (!visited[i]) {
                queue.add(i);
                visited[i] = true;
                while (!queue.isEmpty()) {
                    Integer currentNode = queue.poll();
                    nodes.add(currentNode);
                    List<Integer> neighbours = graph.get(i);
                    for (int neighbour : neighbours) {
                        if (!visited[neighbour]) {
                            visited[neighbour] = true;
                            queue.add(neighbour);
                        }
                    }
                }
            }
        }
        return nodes;
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

        System.out.println(bfsTraversal(7,graph));


    }
}
