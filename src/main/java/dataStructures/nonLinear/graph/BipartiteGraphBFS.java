package dataStructures.nonLinear.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;




public class BipartiteGraphBFS {
    // first check if the Bipartite using BFS
    public static boolean isBipartite(int v, List<List<Integer>> adjacencyList) {
        Color[] colors = new Color[v + 1];
        for (int i = 1; i <= v; i++)
            if (colors[i] == null)
                if (!isBipartite(i, adjacencyList, colors))
                    return false;
        return true;
    }

    private static boolean isBipartite(int node, List<List<Integer>> adjacencyList, Color[] colors) {
        colors[node] = Color.READ;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Integer currentNode = queue.poll();
            for (int neighbour : adjacencyList.get(currentNode)) {
                if (colors[neighbour] == null) {
                    colors[neighbour] = (colors[currentNode] == Color.READ) ? Color.BLACK : Color.READ;
                    queue.add(neighbour);
                } else if (colors[neighbour] == colors[currentNode]) {
                    return false;
                }
            }
        }
        return true;
    }


    // second check if the Bipartite using DFS


    public static void main(String[] args) {
        int nodes = 11;
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i <= nodes; i++)
            adjacencyList.add(i, new ArrayList<>());

        adjacencyList.get(1).add(2);
        adjacencyList.get(2).add(1);

        adjacencyList.get(2).add(4);
        adjacencyList.get(4).add(2);

        adjacencyList.get(3).add(5);
        adjacencyList.get(5).add(3);

        adjacencyList.get(5).add(10);
        adjacencyList.get(10).add(5);
        adjacencyList.get(5).add(6);
        adjacencyList.get(6).add(5);

        adjacencyList.get(6).add(7);
        adjacencyList.get(7).add(6);

        adjacencyList.get(10).add(9);
        adjacencyList.get(9).add(10);

        adjacencyList.get(6).add(7);
        adjacencyList.get(7).add(6);

        adjacencyList.get(9).add(8);
        adjacencyList.get(8).add(9);

        adjacencyList.get(8).add(11);
        adjacencyList.get(11).add(8);


        System.out.println(isBipartite(nodes,adjacencyList));
    }
}
