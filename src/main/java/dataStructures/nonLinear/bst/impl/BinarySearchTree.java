package dataStructures.nonLinear.bst.impl;

import dataStructures.nonLinear.bst.Node;
import dataStructures.nonLinear.bst.Tree;
import dataStructures.nonLinear.bst.enums.TraversalType;

public class BinarySearchTree<T extends Comparable<T>> implements Tree<T> {

    private Node<T> root;
    private int size;

    public BinarySearchTree() {
        this.root = null;
        this.size = 0;
    }

    @Override
    public boolean insert(T data) {
        if (isEmpty()) {
            root = new Node<>(data);
            size++;
            return true;
        } else {
            Node<T> currentNode = root;
            while (currentNode != null) {
                if (data.compareTo(currentNode.data) > 0) {
                    if (currentNode.rightChild == null) {
                        currentNode.rightChild = new Node<>(data);
                        size++;
                        return true;
                    }
                    currentNode = currentNode.rightChild;
                } else {
                    if (currentNode.leftChild == null) {
                        currentNode.leftChild = new Node<>(data);
                        size++;
                        return true;
                    }
                    currentNode = currentNode.leftChild;
                }
            }
        }
        return false;
    }

    public boolean recursiveInsert(T data) {
        if (contains(data)) {
            System.out.println(data + " Already Exist");
            return false;
        }
        root = recursiveInsert(root, data);
        size++;
        return true;
    }

    private Node<T> recursiveInsert(Node<T> currentNode, T data) {
        if (currentNode == null)
            return new Node<>(data);

        if (data.compareTo(currentNode.data) > 0)
            currentNode.rightChild = recursiveInsert(currentNode.rightChild, data);
        else
            currentNode.leftChild = recursiveInsert(currentNode.leftChild, data);

        return currentNode;
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public Node<T> search(T data) {
        return recursiveSearch(root, data);
    }

    private Node<T> recursiveSearch(Node<T> currentNode, T data) {
        if (currentNode == null || currentNode.data.equals(data))
            return currentNode;

        if (data.compareTo(currentNode.data) > 0) {
            return recursiveSearch(currentNode.rightChild, data);
        } else {
            return recursiveSearch(currentNode.leftChild, data);
        }
    }

    public Node<T> iterativeSearch(T data) {
        Node<T> currentNode = root;
        while (currentNode != null) {
            if (currentNode.data.equals(data))
                return currentNode;
            else if (currentNode.data.compareTo(data) > 0) {
                currentNode = currentNode.leftChild;
            } else {
                currentNode = currentNode.rightChild;
            }
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0 || root == null;
    }

    @Override
    public boolean contains(T data) {
        return contains(root, data);
    }

    private boolean contains(Node<T> currentNode, T data) {
        if (currentNode == null)
            return false;
        if (currentNode.data.compareTo(data) > 0) {
            return contains(currentNode.leftChild, data);
        } else if (currentNode.data.compareTo(data) < 0) {
            return contains(currentNode.rightChild, data);
        } else {
            return true;
        }
    }


    // Remove a value from this binary tree if it exists, O(n)
    @Override
    public T remove(T data) {

        if (contains(data)) {
            root = remove(root, data);
            size--;
            return data;
        }
        return null;
    }

    private Node<T> remove(Node<T> current, T data) {
        if (current == null) {
            return null;
        }
        // first we need to get the node
        if (data.compareTo(current.data) > 0) {
            current.rightChild = remove(current.rightChild, data);
        } else if (data.compareTo(current.data) < 0) {
            current.leftChild = remove(current.leftChild, data);
        } else {

            if (isLeaf(current)) {
                current.data = null;
                return null;
            } else if (current.leftChild != null && current.rightChild == null) {
                return current.leftChild;
            } else if (current.rightChild != null && current.leftChild == null) {
                return current.rightChild;
            } else {
                Node<T> smallestValueInRight = min(current.rightChild);
                current.data = smallestValueInRight.data;
                current.rightChild = remove(current.rightChild, smallestValueInRight.data);
            }
        }
        return current;
    }


    private boolean isLeaf(Node<T> node) {
        return node.leftChild == null && node.rightChild == null;
    }

    private Node<T> min(Node<T> node) {
        while (node.leftChild != null) {
            node = node.leftChild;
        }
        return node;
    }

    private Node<T> max(Node<T> node) {
        while (node.rightChild != null) {
            node = node.rightChild;
        }
        return node;
    }

    @Override
    public T findMin() {
        return min(root).data;
    }

    @Override
    public T findMax() {
        return max(root).data;
    }

    @Override
    public int height() {
        return 0;
    }

    @Override
    public void traverse(TraversalType traversalType) {
        switch (traversalType) {
            case IN_ORDER:
                inOrder(root);
                break;
            case POST_ORDER:
                postOrder(root);
                break;
            case PRE_ORDER:
                preOrder(root);
                break;
            case LEVEL_ORDER:
                break;
        }
    }

    private void inOrder(Node<T> node) {
        if (node == null)
            return;
        inOrder(node.leftChild);
        System.out.print(node.data + "  ");
        inOrder(node.rightChild);
    }

    private void preOrder(Node<T> node) {
        if (node == null)
            return;
        System.out.print(node.data + "  ");
        preOrder(node.leftChild);
        preOrder(node.rightChild);
    }

    private void postOrder(Node<T> node) {
        if (node == null)
            return;
        postOrder(node.leftChild);
        postOrder(node.rightChild);
        System.out.print(node.data + "  ");
    }
}
