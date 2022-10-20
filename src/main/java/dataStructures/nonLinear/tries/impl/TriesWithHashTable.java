package dataStructures.nonLinear.tries.impl;

import dataStructures.nonLinear.tries.Tries;

import java.util.*;

public class TriesWithHashTable implements Tries {

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

    private final Node root = new Node(' ');

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

    @Override
    public void remove(String word) {
        if (word == null) return;
        remove(root, word, 0);
    }


    private void remove(Node root, String word, int index) {
        if (index == word.length()) {
            root.isEndOfWord = false;
            return;
        }
        char ch = word.charAt(index);
        Node child = root.children.get(ch);
        if (child == null) return;

        remove(child, word, index + 1);

        if (root.children().length == 0 && !root.isEndOfWord)
            root.children.remove(root.value);

    }

    @Override
    public List<String> findWords(String prefix) {
        List<String> words = new ArrayList<>();
        if (prefix == null)
            return words;
        Node lastNode = findLastNodeOf(prefix);
        if (lastNode == null)
            return words;
        findWords(lastNode, prefix, words);
        return words;
    }

    private void findWords(Node node, String prefix, List<String> words) {
        if (node == null) return;

        if (node.isEndOfWord)
            words.add(prefix);

        for (Node current : node.children())
            findWords(current, prefix + current.value, words);

    }

    private Node findLastNodeOf(String prefix) {
        Node current = root;
        for (char ch : prefix.toCharArray()) {
            if (!current.children.containsKey(ch))
                return null;
            current = current.getChild(ch);
        }
        return current;
    }



}