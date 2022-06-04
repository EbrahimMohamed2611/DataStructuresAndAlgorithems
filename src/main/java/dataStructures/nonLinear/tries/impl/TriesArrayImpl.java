package dataStructures.nonLinear.tries.impl;

import dataStructures.nonLinear.tries.Tries;

public class TriesArrayImpl implements Tries {

    private final static int ALPHABETIC_SIZE = 26;

    private class Node {
        char value;
        // Problem here is when create new node we will create 26 node also, but sometimes we need  less than this number on nodes
        Node[] children = new Node[ALPHABETIC_SIZE];
        boolean isEndOfWord;

        public Node(char value) {
            this.value = value;
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
            int index = (ch - 'a');
            if (current.children[index] == null)
                current.children[index] = new Node(ch);
            current = current.children[index];
        }
        current.isEndOfWord = true;
    }

    @Override
    public boolean contains(String word) {
        return false;
    }

    @Override
    public void traversPreOrder() {

    }

    @Override
    public void traversPostOrder() {

    }
}
