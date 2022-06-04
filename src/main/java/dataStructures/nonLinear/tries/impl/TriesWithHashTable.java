package dataStructures.nonLinear.tries.impl;

import dataStructures.nonLinear.tries.Tries;

import java.util.*;

public class TriesWithHashTable implements Tries {

    private final static int ALPHABETIC_SIZE = 26;

    private class Node {
        char value;
        Map<Character, Node> children = new HashMap<>();
        boolean isEndOfWord;

        public Node(char value) {
            this.value = value;
        }

        public boolean hasChild(char child) {
            return children.containsKey(child);
        }

        public void addChild(Node node) {
            children.put(node.value, node);
        }

        public Node getChild(char node) {
            return children.get(node);
        }

        public Node[] children() {
            return this.children.values().toArray(new Node[0]);
        }

        @Override
        public String toString() {
            return "value=" + value;
        }
    }

    private Node root = new Node(' ');

    @Override
    public void insert(String word) {
        Node current = root;
        for (char ch : word.toCharArray()) {
            if (!current.hasChild(ch))
                current.addChild(new Node(ch));
            current = current.getChild(ch);
        }
        current.isEndOfWord = true;
    }

    @Override
    public boolean contains(String word) {
        if (word == null)
            return false;
        //throw new IllegalArgumentException();
        Node current = root;
        for (char ch : word.toCharArray()) {
            if (current.hasChild(ch)) {
                current = current.getChild(ch);
            } else
                return false;
        }
        return current.isEndOfWord;
    }

    @Override
    public void traversPreOrder() {
        traversPreOrder(root);
    }

    private void traversPreOrder(Node root) {
        System.out.print(root.value + "  ");

        for (Node current : root.children())
            traversPreOrder(current);

    }

    @Override
    public void traversPostOrder() {
        traversPostOrder(root);
    }

    private void traversPostOrder(Node root) {
        for (Node current : root.children())
            traversPostOrder(current);

        System.out.print(root.value + "  ");
    }


}