package dataStructures.nonLinear.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeightedGraph<T> {

    private class Node<T> {
        private final T label;
        private final List<Edge<T>> edges = new ArrayList<>();

        public Node(T label) {
            this.label = label;
        }

        public void addEdge(Node<T> to, double weight) {
            edges.add(new Edge<>(this, to, weight));
        }

        public List<Edge<T>> getEdges() {
            return edges;
        }

        @Override
        public String toString() {
            return label.toString();
        }
    }

    private class Edge<T> {
        private Node<T> from;
        private Node<T> to;
        private double weight;

        public Edge(Node<T> from, Node<T> to, double weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return from + " -> " + to;
        }
    }

    private final Map<T, Node<T>> nodes = new HashMap<>();

    public void addNode(T label) {
        nodes.put(label, new Node<>(label));
    }

    public void addEdge(T from, T to, double weight) {
        Node<T> fromNode = nodes.get(from);
        if (fromNode == null)
            throw new IllegalArgumentException();
        Node<T> toNode = nodes.get(to);
        if (toNode == null)
            throw new IllegalArgumentException();

        fromNode.addEdge(toNode, weight);
        toNode.addEdge(fromNode, weight);
    }

    public void print() {
        for (Node<T> node : nodes.values()) {
            List<Edge<T>> edges = node.getEdges();
            if (!edges.isEmpty())
                System.out.println(edges);
        }
    }
}
