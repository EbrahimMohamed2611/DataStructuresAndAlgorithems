package dataStructures.nonLinear.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class UnDirectedGraphDetectCycleBFS {

    // (1) first using BFS (Bfs with modification)
    public static boolean isGraphContainCycle(List<List<Integer>> adjacencyList, int nodes) {
        boolean[] visited = new boolean[nodes + 1];
        for (int i = 1; i <= nodes; i++) { // to ensure you will traverse all components
            if (!visited[i]) {
                if (isCycle(i, visited, adjacencyList))
                    return true;
            }
        }
        return false;
    }

    private static boolean isCycle(int i, boolean[] visited, List<List<Integer>> adjacencyList) {
        visited[i] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, -1}); // pairs<currentNode, previous>
        while (!queue.isEmpty()) {
            int[] currentNode = queue.poll();
            int node = currentNode[0];
            int prev = currentNode[1];
            for (int neighbour : adjacencyList.get(node)) {
                if (!visited[neighbour]) {
                    queue.add(new int[]{neighbour, node});
                    visited[neighbour] = true;
                } else if (prev != neighbour) {
                    return true;
                }
            }
        }
        return false;
    }

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

        System.out.println(isGraphContainCycle(adjacencyList,nodes));

        int numberOfNodes = 3;
        List<List<Integer>> adjacencyList2 = new ArrayList<>();
        for (int i = 0; i <= numberOfNodes; i++)
            adjacencyList2.add(i, new ArrayList<>());

        adjacencyList2.get(1).add(2);
        adjacencyList2.get(2).add(1);

        adjacencyList2.get(2).add(3);
        adjacencyList2.get(3).add(2);
        System.out.println(isGraphContainCycle(adjacencyList2, numberOfNodes));

    }
}
