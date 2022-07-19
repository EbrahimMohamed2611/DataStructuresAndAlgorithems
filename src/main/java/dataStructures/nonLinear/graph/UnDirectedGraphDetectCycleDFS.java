package dataStructures.nonLinear.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class UnDirectedGraphDetectCycleDFS {

    // (2) Second using DFS (Dfs with modification)
    public static boolean isGraphContainCycle(List<List<Integer>> adjacencyList, int nodes) {
        boolean[] visited = new boolean[nodes + 1];
        for (int i = 1; i <= nodes; i++) { // to ensure you will traverse all components
            if (!visited[i]) {
                if (isCycle(i, -1, visited, adjacencyList))
                    return true;
            }
        }
        return false;
    }

    private static boolean isCycle(int currentNode, int parent, boolean[] visited, List<List<Integer>> adjacencyList) {
        visited[currentNode] = true;

        for (int neighbour : adjacencyList.get(currentNode)) {
            if (!visited[neighbour]) {
                if (isCycle(neighbour, currentNode, visited, adjacencyList))
                    return true;
            } else if (neighbour != parent) {
                return true;
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

        System.out.println(isGraphContainCycle(adjacencyList, nodes));

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
