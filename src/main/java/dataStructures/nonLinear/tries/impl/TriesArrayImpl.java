package dataStructures.nonLinear.tries.impl;

import dataStructures.nonLinear.tries.Tries;

import java.util.List;

public class TriesArrayImpl implements Tries {

    private final static int ALPHABET_SIZE = 26;

    private static class Node {
        char value;
        Node[] children = new Node[ALPHABET_SIZE];// Problem here is when create new node we will create 26 node also, but sometimes we need  less than this number on nodes
        boolean isEndOfWord;

        public Node(char value) {
            this.value = value;
        }

        public boolean isEndOfWord() {
            return isEndOfWord;
        }

        public boolean hasChild(char ch) {
            return children[ch - 'a'] != null;
        }

        public Node getChild(char ch) {
            return children[ch - 'a'];
        }

        @Override
        public String toString() {
            return "value=" + value;
        }
    }

    private final Node root = new Node(' ');

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
        if (word == null) return false;

        Node current = root;
        for (char ch : word.toCharArray()) {
            if (!current.hasChild(ch))
                return false;
            current = current.getChild(ch);
        }
        return current.isEndOfWord;
    }

    @Override
    public void traversPreOrder() {
        traversPreOrder(root);
    }

    private void traversPreOrder(Node root) {
        if (root == null) return;
        System.out.print(root.value + "  ");
        for (Node node : root.children)
            traversPreOrder(node);

    }

    @Override
    public void traversPostOrder() {
        traversPostOrder(root);
    }

    @Override
    public void remove(String word) {

    }


    private void traversPostOrder(Node root) {
        if (root == null) return;
        for (Node node : root.children)
            traversPostOrder(node);
        System.out.print(root.value + "  ");

    }

    @Override
    public List<String> findWords(String prefix) {
        return null;
    }
}
