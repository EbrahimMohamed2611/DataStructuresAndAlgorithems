package dataStructures.nonLinear.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        Graph graph = new Graph();
////        graph.addNode("A");
////        graph.addNode("B");
////        graph.addNode("C");
////
////        graph.addEdge("A", "B");
////        graph.addEdge("A", "C");
////        graph.addEdge("B", "C");
////        graph.removeEdge("B", "C");
////        graph.addEdge("C", "A");
////        graph.addEdge("B", "C");
////
//
////        graph.addNode("A");
////        graph.addNode("B");
////        graph.addNode("C");
////        graph.addNode("D");
////        graph.addNode("E");
////        graph.addEdge("A", "B");
////        graph.addEdge("A", "E");
////        graph.addEdge("B", "C");
////        graph.addEdge("B", "D");
////        graph.addEdge("C", "D");
////        graph.print();
////        graph.traverseDepthFirstRec("A");
////        System.out.println("================");
////        graph.traverseBreadthFirst("A");
////        System.out.println("================");
////        graph.traverseDepthFirstIterative("A");
//
//        graph.addNode("A");
//        graph.addNode("B");
//        graph.addNode("C");
//        graph.addNode("D");
//        graph.addNode("E");
//        graph.addNode("F");
//        graph.addNode("J");
//        graph.addNode("H");
//
//        graph.addEdge("A", "B");
//        graph.addEdge("A", "C");
//
//        graph.addEdge("B", "E");
//        graph.addEdge("B", "C");
//        graph.addEdge("B", "D");
//
//        graph.addEdge("C", "D");
//        graph.addEdge("C", "J");
//
//        graph.addEdge("D", "E");
//        graph.addEdge("D", "F");
//        graph.addEdge("D", "J");
//
//        graph.addEdge("E", "H");
//        graph.addEdge("F", "H");
//        graph.addEdge("J", "H");
//        List<String> sorted = graph.topologicalSort();
//        System.out.println(sorted);

        WeightedGraph<Character> graph = new WeightedGraph<>();
        graph.addNode('A');
        graph.addNode('B');
        graph.addNode('C');
        graph.addEdge('A', 'B', 5);
        graph.addEdge('A', 'C', 10);
        graph.print();

        // Simulate graph with list<int[]> graph
        int capacity = 5;
        List<List<int[]>> weightedGraph = new ArrayList<>(capacity);
        for (int i = 0; i <= capacity; i++) {
            weightedGraph.add(new ArrayList<>());
        }
        weightedGraph.get(1).add(new int[]{2, 4});
        weightedGraph.get(2).add(new int[]{1, 4});
        weightedGraph.get(1).add(new int[]{3, 3});
        weightedGraph.get(3).add(new int[]{1, 3});
        weightedGraph.get(1).add(new int[]{5, 2});
        weightedGraph.get(5).add(new int[]{1, 2});

        weightedGraph.get(5).add(new int[]{3, 5});
        weightedGraph.get(3).add(new int[]{5, 5});

        weightedGraph.get(2).add(new int[]{3, 6});
        weightedGraph.get(3).add(new int[]{2, 6});

        weightedGraph.get(2).add(new int[]{4, 1});
        weightedGraph.get(4).add(new int[]{2, 1});

        weightedGraph.get(3).add(new int[]{4, 7});
        weightedGraph.get(4).add(new int[]{3, 7});

        for (int i = 1; i <= capacity; i++) {
            System.out.print(i + " is connected With => ");
            for (int[] edge : weightedGraph.get(i))
                System.out.print(Arrays.toString(edge));
            System.out.println();
        }


    }
}
