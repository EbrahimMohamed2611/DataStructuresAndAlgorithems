package dataStructures.nonLinear.binarySearchTree;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class BinarySearchTree<T extends Number> {

    private class Node<T extends Number> {
        Node<T> leftChild;
        Node<T> rightChild;
        T data;

        Node(T data) {
            this.data = data;
            this.rightChild = this.leftChild = null;
        }

        @Override
        public String toString() {
            return "Node = " + data;
        }
    }

    /*============================================*/
    private Node<T> root;

    BinarySearchTree() {
        this.root = null;
    }

    /**
     * Using Iteration Approach
     *
     * @param data
     */
    public void insert(T data) {
        if (root == null) {
            root = new Node<>(data);
        } else {
            Node<T> current = root;
            Node<T> prev = null;
            while (current != null) {
                prev = current;
                if (current.data.doubleValue() < data.doubleValue())
                    current = current.rightChild;
                else
                    current = current.leftChild;
            }
            // we need to decide to add the node either right or left the current Node
            if (prev.data.doubleValue() < data.doubleValue())
                prev.rightChild = new Node<>(data);
            else
                prev.leftChild = new Node<>(data);
        }
    }

    /**
     * Another way to add new node using iteration
     */
    public void add(T data) {
        if (root == null) {
            root = new Node<>(data);
        } else {
            Node<T> travers = root; // to keep the root on the top
            while (true) {
                if (travers.data.doubleValue() < data.doubleValue()) {
                    if (travers.rightChild == null) {
                        travers.rightChild = new Node<>(data);
                        return;
                    }
                    travers = travers.rightChild;
                } else {
                    if (travers.leftChild == null) {
                        travers.leftChild = new Node<>(data);
                        return;
                    }
                    travers = travers.leftChild;
                }
            }
        }
    }


    /**
     * Insert using recursion
     */

    public void insertRecursively(final T data) {
        root = insertRecursivelyHelper(root, data);
    }

    private Node<T> insertRecursivelyHelper(Node<T> root, final T data) {
        if (root == null)
            root = new Node<>(data);
        else if (root.data.doubleValue() < data.doubleValue())
            root.rightChild = insertRecursivelyHelper(root.rightChild, data);
        else
            root.leftChild = insertRecursivelyHelper(root.leftChild, data);
        return root;
    }

    /**
     * Search using Iteration Approach
     */
    public boolean searchIterative(T data) {
        Node<T> current = root;
        boolean isFound = false;
        while (current != null) {
            if (current.data.doubleValue() == data.doubleValue()) {
                isFound = true;
                break;
            } else if (data.doubleValue() > current.data.doubleValue()) {
                current = current.rightChild;
            } else {
                current = current.leftChild;
            }
        }
        return isFound;
    }


    /**
     * Search using Iteration Approach
     */
    public boolean searchRecursively(T data) {
        return searchRecursivelyHelper(root, data);
    }

    private boolean searchRecursivelyHelper(Node<T> root, T data) {
        if (root == null)
            return false;
        else if (root.data.doubleValue() == data.doubleValue())
            return true;
        else if (data.doubleValue() > root.data.doubleValue())
            return searchRecursivelyHelper(root.rightChild, data);
        else
            return searchRecursivelyHelper(root.leftChild, data);
    }


    /**
     * Find Min Element
     * Using Iterative Approach
     */

    public T findMinElement() {
        Node<T> current = root;
        if (current == null)
            throw new NoSuchElementException();
        else {
            while (current.leftChild != null) {
                current = current.leftChild;
            }
            return current.data;
        }
    }

    /**
     * Find Min Element
     * Using Recursion Approach
     */
    public T findMinElementRecursively() {
        return findMinElementRecursivelyHelper(root);

    }

    private T findMinElementRecursivelyHelper(Node<T> root) {
        if (root == null)
            throw new NoSuchElementException();
        else if (root.leftChild == null) {
            return root.data;
        } else {
            return findMinElementRecursivelyHelper(root.leftChild);
        }
    }


    /**
     * Find Max Element
     * Using Iterative Approach
     */

    public T findMaxElement() {
        Node<T> current = root;
        if (current == null)
            throw new NoSuchElementException();
        else {
            while (current.rightChild != null) {
                current = current.rightChild;
            }
            return current.data;
        }
    }


    public T findMaxElementRecursively() {
        return findMaxElementRecursivelyHelper(root);

    }

    private T findMaxElementRecursivelyHelper(Node<T> root) {
        if (root == null)
            throw new NoSuchElementException();
        else if (root.rightChild == null) {
            return root.data;
        } else {
            return findMaxElementRecursivelyHelper(root.rightChild);
        }
    }

    /**
     * Traverse using Breadth First using Queue
     * using iteration approach
     */
    public void traverseBF() {
        if (root == null)
            throw new NoSuchElementException();
        else {
            Queue<Node<T>> queueOfNodes = new LinkedList<>();
            queueOfNodes.add(root);
            while (!queueOfNodes.isEmpty()) {
                Node<T> currentNode = queueOfNodes.poll();
                System.out.print(currentNode.data + "\t");
                if (currentNode.leftChild != null)
                    queueOfNodes.add(currentNode.leftChild);
                if (currentNode.rightChild != null)
                    queueOfNodes.add(currentNode.rightChild);
            }
            System.out.println();
        }
    }

    /**
     * Is Binary Search Tree
     * using Recursion
     * Time O(N)
     */
    public boolean isBinarySearchTree() {

        return isBinarySearchTreeHelper(root, Double.MIN_VALUE, Double.MAX_VALUE);
    }

    private boolean isBinarySearchTreeHelper(Node<T> root, Double minValue, Double maxValue) {
        if (root == null)
            return true;
        if (root.data.doubleValue() > minValue
                && root.data.doubleValue() < maxValue
                && isBinarySearchTreeHelper(root.leftChild, minValue, root.data.doubleValue())
                && isBinarySearchTreeHelper(root.rightChild, root.data.doubleValue(), maxValue))
            return true;
        else
            return false;
    }

    /**
     * Is Binary Search Tree
     * Time O(N^2)
     */

    public boolean isBinarySearchTreeValid() {
        swapLeftChildWithRight(root);
        return isBinarySearchTreeValidHelper(root);
    }

    private boolean isBinarySearchTreeValidHelper(Node<T> root) {
        if (root == null)
            return true;

        if (
                isSubTreeLesser(root.leftChild, root.data)
                        && isSubTreeGreater(root.rightChild, root.data)
                        && isBinarySearchTreeValidHelper(root.rightChild)
                        && isBinarySearchTreeValidHelper(root.leftChild)
        )
            return true;
        else
            return false;
    }

    private boolean isSubTreeLesser(Node<T> root, T value) {
        if (root == null)
            return true;
        if (root.data.doubleValue() < value.doubleValue()
                && isSubTreeLesser(root.rightChild, value)
                && isSubTreeLesser(root.rightChild, value))
            return true;
        else
            return false;
    }


    private boolean isSubTreeGreater(Node<T> root, T value) {
        if (root == null)
            return true;
        if (root.data.doubleValue() > value.doubleValue()
                && isSubTreeGreater(root.rightChild, value)
                && isSubTreeGreater(root.rightChild, value))
            return true;
        else
            return false;
    }

    private void swapLeftChildWithRight(Node<T> root) {
        T left = root.leftChild.data;
        root.leftChild.data = root.rightChild.data;
        root.rightChild.data = left;
    }

    public void delete(T data) {
        root = deleteHelper(root, data);
    }

    private Node<T> deleteHelper(Node<T> root, T data) {
        if (root == null)
            return root; // or return null
        if (data.doubleValue() > root.data.doubleValue()) {
            root.rightChild = deleteHelper(root.rightChild, data);
        } else if (data.doubleValue() < root.data.doubleValue()) {
            root.leftChild = deleteHelper(root.leftChild, data);
        } else { // (3) I found it
            // we have 4 cases
            if (isLeaf(root)) {  // first case : the node is leaf
                root = null;
            } else if (root.rightChild == null && root.leftChild != null) { // second case : the node have one child (leftChild)
                root.data = root.leftChild.data;
                root.leftChild = null;
            } else if (root.rightChild != null && root.leftChild == null) { // third case : the node have one child (rightChild)
                root.data = root.rightChild.data;
                root.rightChild = null;
            } else { // fourth case : the node is Internal node ( have two children
                // we can use the min value from right or max value from left
                T leftMax = findMaxElementRecursivelyHelper(root.leftChild);
                root.data = leftMax;
                root.leftChild = deleteHelper(root.leftChild, leftMax);
            }
        }
        return root;
    }

    private boolean isLeaf(Node<T> node) {
        return node.rightChild == null & node.leftChild == null;
    }

    public void traverseInOrder(){
        traverseInOrderHelper(root);
        System.out.println();
    }

    private void traverseInOrderHelper(Node<T> root){
        if(root == null)
            return;
        traverseInOrderHelper(root.leftChild);
        System.out.print(root.data + "\t");
        traverseInOrderHelper(root.rightChild);
    }

}
