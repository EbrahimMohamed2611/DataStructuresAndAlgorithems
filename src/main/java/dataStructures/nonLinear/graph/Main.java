package dataStructures.nonLinear.graph;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();
//        graph.addNode("A");
//        graph.addNode("B");
//        graph.addNode("C");
//
//        graph.addEdge("A", "B");
//        graph.addEdge("A", "C");
//        graph.addEdge("B", "C");
//        graph.removeEdge("B", "C");
//        graph.addEdge("C", "A");
//        graph.addEdge("B", "C");
//

//        graph.addNode("A");
//        graph.addNode("B");
//        graph.addNode("C");
//        graph.addNode("D");
//        graph.addNode("E");
//        graph.addEdge("A", "B");
//        graph.addEdge("A", "E");
//        graph.addEdge("B", "C");
//        graph.addEdge("B", "D");
//        graph.addEdge("C", "D");
//        graph.print();
//        graph.traverseDepthFirstRec("A");
//        System.out.println("================");
//        graph.traverseBreadthFirst("A");
//        System.out.println("================");
//        graph.traverseDepthFirstIterative("A");

        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");
        graph.addNode("E");
        graph.addNode("F");
        graph.addNode("J");
        graph.addNode("H");

        graph.addEdge("A", "B");
        graph.addEdge("A", "C");

        graph.addEdge("B", "E");
        graph.addEdge("B", "C");
        graph.addEdge("B", "D");

        graph.addEdge("C", "D");
        graph.addEdge("C", "J");

        graph.addEdge("D", "E");
        graph.addEdge("D", "F");
        graph.addEdge("D", "J");

        graph.addEdge("E", "H");
        graph.addEdge("F", "H");
        graph.addEdge("J", "H");
        List<String> sorted = graph.topologicalSort();
        System.out.println(sorted);

    }
}
