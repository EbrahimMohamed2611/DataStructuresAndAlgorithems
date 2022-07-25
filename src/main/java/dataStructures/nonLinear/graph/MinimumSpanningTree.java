package dataStructures.nonLinear.graph;

import java.util.*;

public class MinimumSpanningTree {
    // There are 2 Algorithms to Build MST ( Prims and Kruskal's)

    //(1) First using Array With brutForce
    public static void minimumSpanningTree(List<List<int[]>> adjacencyList, int nodes) {
        final int[] nodesWeight = new int[nodes];
        final int[] parents = new int[nodes];
        final boolean[] mstExist = new boolean[nodes];

        for (int i = 0; i < nodes; i++) {
            nodesWeight[i] = Integer.MAX_VALUE;
            parents[i] = -1;
        }
        nodesWeight[0] = 0;
        int min;
        int minNodeWeightSelected;
        for (int i = 0; i < nodes - 1; i++) {
            min = Integer.MAX_VALUE;
            minNodeWeightSelected = 0;
            for (int j = 0; j < nodesWeight.length; j++) {
                // get the smallest weight and should not be a part of MST Tree To Avoid Cycle
                if (!mstExist[j] && min > nodesWeight[j]) {
                    min = nodesWeight[j];
                    minNodeWeightSelected = j;
                }
            }
            mstExist[minNodeWeightSelected] = true;

            List<int[]> neighbours = adjacencyList.get(minNodeWeightSelected);
            for (int[] edge : neighbours) {
                int to = edge[0];
                int weight = edge[1];
                if (!mstExist[to] && weight < nodesWeight[to]) {
                    nodesWeight[to] = weight;
                    parents[to] = minNodeWeightSelected;
                }
            }
        }

        for (int i = 1; i < parents.length; i++) {
            System.out.println("Parent of " + parents[i] + " is " + i);
        }


    }


    //(2) Second using Prims Algorithm Using Heap (Priority Queue )
    public static void buildMinimumSpanningTree(List<List<int[]>> adjacencyList, int nodes) {
        int[] parents = new int[nodes];
        boolean[] mstExist = new boolean[nodes];
        int[] weights = new int[nodes];
        for (int i = 0; i < nodes; i++) {
            parents[i] = -1;
            weights[i] = Integer.MAX_VALUE;
        }

        Queue<int[]> minHeap = new PriorityQueue<>((node1, node2) -> node1[1] - node2[1]);
        minHeap.add(new int[]{0, 0});
        weights[0] = 0;
        for (int i = 0; i < nodes - 1; i++) { // nodes -1 to Build N-1 Edges
            int[] currentNode = minHeap.poll();
            mstExist[currentNode[0]] = true;

            List<int[]> neighbours = adjacencyList.get(currentNode[0]);
            for (int[] neighbour : neighbours) {
                if (mstExist[neighbour[0]])
                    continue;
                if (neighbour[1] < weights[neighbour[0]]) {
                    parents[neighbour[0]] = currentNode[0];
                    weights[neighbour[0]] = neighbour[1];
                    minHeap.add(new int[]{neighbour[0], neighbour[1]});
                }
            }
        }

        for (int i = 1; i < parents.length; i++) {
            System.out.println("Parent of " + parents[i] + " is " + i);
        }
    }

    public static void main(String[] args) {
        List<List<int[]>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            adjacencyList.add(i, new ArrayList<>());

        adjacencyList.get(0).add(new int[]{1, 2});
        adjacencyList.get(0).add(new int[]{3, 6});

        adjacencyList.get(1).add(new int[]{0, 2});
        adjacencyList.get(3).add(new int[]{0, 6});

        adjacencyList.get(1).add(new int[]{3, 8});
        adjacencyList.get(3).add(new int[]{1, 8});

        adjacencyList.get(1).add(new int[]{4, 5});
        adjacencyList.get(4).add(new int[]{1, 5});

        adjacencyList.get(1).add(new int[]{2, 3});
        adjacencyList.get(2).add(new int[]{1, 3});

        adjacencyList.get(2).add(new int[]{4, 7});
        adjacencyList.get(4).add(new int[]{2, 7});

        buildMinimumSpanningTree(adjacencyList, 5);
        System.out.println("========================");
        minimumSpanningTree(adjacencyList, 5);

    }
}
