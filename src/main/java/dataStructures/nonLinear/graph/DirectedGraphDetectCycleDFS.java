package dataStructures.nonLinear.graph;

import java.util.ArrayList;
import java.util.List;

public class DirectedGraphDetectCycleDFS {


    public static boolean isGraphContainCycle(List<List<Integer>> adjacencyList, int vertexes) {
        boolean[] visited = new boolean[vertexes + 1];
        boolean[] visiting = new boolean[vertexes + 1];

        for (int node = 1; node <= vertexes; node++) {
            if (!visited[node]) {
                if (isGraphContainCycle(node, adjacencyList, visited, visiting))
                    return true;
            }
        }
        return false;
    }


    private static boolean isGraphContainCycle(int node, List<List<Integer>> adjacencyList, boolean[] visited, boolean[] visiting) {
        visited[node] = true;
        visiting[node] = true;
        for (int neighbour : adjacencyList.get(node)) {
            if (!visited[neighbour]) {
                if (isGraphContainCycle(neighbour, adjacencyList, visited, visiting))
                    return true;
            } else if (visiting[neighbour])
                return true;
        }
        visiting[node] = false;
        return false;
    }

    public static void main(String[] args) {
        int nodes = 9;
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i <= nodes; i++)
            adjacencyList.add(i, new ArrayList<>());

        adjacencyList.get(1).add(2);


        adjacencyList.get(2).add(3);


        adjacencyList.get(3).add(4);
        adjacencyList.get(4).add(3);

        adjacencyList.get(3).add(6);
        adjacencyList.get(6).add(5);

        adjacencyList.get(7).add(2);
        adjacencyList.get(7).add(8);

        adjacencyList.get(8).add(9);

        adjacencyList.get(9).add(7);

        System.out.println(isGraphContainCycle(adjacencyList, nodes));

        int numberOfNodes = 3;
        List<List<Integer>> adjacencyList2 = new ArrayList<>();
        for (int i = 0; i <= numberOfNodes; i++)
            adjacencyList2.add(i, new ArrayList<>());

        adjacencyList2.get(1).add(2);

        adjacencyList2.get(2).add(3);
//        adjacencyList2.get(3).add(4);
        System.out.println(isGraphContainCycle(adjacencyList2, numberOfNodes));


    }
}
