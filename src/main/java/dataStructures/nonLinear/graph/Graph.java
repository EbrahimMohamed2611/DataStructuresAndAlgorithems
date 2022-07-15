package dataStructures.nonLinear.graph;

import java.util.*;

public class Graph {

    private class Node {
        private String label;

        public Node(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return label;
        }

//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (o == null || getClass() != o.getClass()) return false;
//            Node node = (Node) o;
//            return Objects.equals(label, node.label);
//        }
//
//        @Override
//        public int hashCode() {
//            return Objects.hash(label);
//        }
    }

    private Map<String, Node> nodes = new HashMap<>();
    private Map<Node, List<Node>> adjacencyList = new HashMap<>();

    public void addNode(String label) {
        Node node = new Node(label);
        nodes.putIfAbsent(label, node);
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    public void removeNode(String label) {
        Node node = nodes.get(label);
        if (node == null)
            return;

        for (Map.Entry<Node, List<Node>> source : adjacencyList.entrySet())
            source.getValue().remove(node);
        adjacencyList.remove(node);
        nodes.remove(label);
    }

    public void addEdge(String from, String to) {
        Node fromNode = nodes.get(from);
        if (fromNode == null) throw new IllegalArgumentException();
        Node toNode = nodes.get(to);
        if (toNode == null) throw new IllegalArgumentException();

        adjacencyList.get(fromNode).add(toNode);
    }

    public void removeEdge(String from, String to) {
        Node fromNode = nodes.get(from);
        Node toNode = nodes.get(to);
        if (toNode == null || fromNode == null) return;

        adjacencyList.get(fromNode).remove(toNode);
    }

    public void traverseDepthFirstRec(String root) {
        Node node = nodes.get(root);
        if (node == null)
            return;
        traverseDepthFirstRec(node, new HashSet<>());
    }

    public void traverseDepthFirstIterative(String root) {
        Node node = nodes.get(root);
        if (node == null)
            return;
        Set<Node> visited = new HashSet<>();
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            Node currentNode = stack.pop();
            if (visited.contains(currentNode)) continue;
            System.out.println(currentNode);
            visited.add(currentNode);
            for (Node neighbour : adjacencyList.get(currentNode))
                if (!visited.contains(neighbour))
                    stack.push(neighbour);
        }
    }

    private void traverseDepthFirstRec(Node node, Set<Node> visited) {
        System.out.println(node);
        visited.add(node);

        for (Node currentNode : adjacencyList.get(node))
            if (!visited.contains(currentNode))
                traverseDepthFirstRec(currentNode, visited);

    }

    public void traverseBreadthFirst(String root) {
        Node node = nodes.get(root);
        if (node == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        Set<Node> visited = new HashSet<>();

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            if (visited.contains(currentNode)) continue;
            System.out.println(currentNode);
            visited.add(currentNode);
            for (Node neighbour : adjacencyList.get(currentNode))
                if (!visited.contains(neighbour))
                    queue.add(neighbour);
        }
    }

    public List<String> topologicalSort() {
        Set<Node> visited = new HashSet<>();
        Stack<Node> stack = new Stack<>();
        for (Node node : nodes.values())
            topologicalSort(node, visited, stack);

        List<String> sorted = new ArrayList<>();
        while (!stack.isEmpty())
            sorted.add(stack.pop().label);

        return sorted;
    }

    private void topologicalSort(Node node, Set<Node> visited, Stack<Node> stack) {
        if (visited.contains(node)) // we will return because if we visited before that's mean we visited Its Children
            return;
        visited.add(node);
        for (Node neighbour : adjacencyList.get(node))
            if (!visited.contains(neighbour))
                topologicalSort(neighbour, visited, stack);
        // when backtrack add the independent Node First
        stack.push(node);
    }

    public void print() {
        for (Map.Entry<Node, List<Node>> node : adjacencyList.entrySet())
            System.out.println(node.getKey() + " is Connected With " + node.getValue());
    }
}
