package dataStructures.nonLinear.bst;

public class Node<T extends Comparable<T>> {
    public T data;
    public Node<T> leftChild;
    public Node<T> rightChild;

    public Node(T data) {
        this.data = data;
        this.leftChild = null;
        this.rightChild = null;
    }

    @Override
    public String toString() {
        return "" + data + "";
    }
}
