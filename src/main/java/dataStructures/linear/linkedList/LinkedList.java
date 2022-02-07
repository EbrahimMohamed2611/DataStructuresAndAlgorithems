package dataStructures.linear.linkedList;

import java.util.NoSuchElementException;

public class LinkedList<E> {

    private class Node<E> {
        private E value;
        private Node<E> nextNode;

        public Node(E value) {
            this.value = value;
        }
    }

    private Node<E> first;
    private Node<E> last;
    private int size;

    public void addLast(E value) {
        Node<E> node = new Node<>(value);
        if (isEmpty()) {
            first = last = node;
        } else {
            last.nextNode = node;
            last = node;
        }
        size++;
    }

    public void addFirst(E value) {
        Node<E> node = new Node<>(value);
        if (isEmpty()) {
            first = last = node;
        } else {
            node.nextNode = first;
            first = node;
        }
        size++;
    }

    public int indexOf(E value) {
        int index = 0;
        Node<E> currentNode = first;
        while (currentNode != null) {
            if (currentNode.value == value)
                return index;
            else {
                currentNode = currentNode.nextNode;
                index++;
            }
        }
        return -1;
    }

    public boolean contains(E value) {
        return indexOf(value) != -1;
    }

    public void removeFirst() {
        // first case there's no Elements
        //second case there is only one element
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else if (first == last) {
            first = last = null;
        } else {
            // [10 -> 20 -> 30]
            Node<E> second = first.nextNode;
            first.nextNode = null;
            first = second;
        }
        size--;
    }

    /**
     * public void removeLast() {
     * if (isEmpty())
     * throw new NoSuchElementException();
     * <p>
     * if (first == last)
     * first = last = null;
     * Node<E> current = first;
     * while (current.nextNode != null) {
     * if (current.nextNode != last)
     * current = current.nextNode;
     * else
     * current.nextNode = null;
     * }
     * last = current;
     * }
     */

    public void removeLast() {
        if (isEmpty())
            throw new NoSuchElementException();

        if (first == last)
            first = last = null;
        else {
            Node<E> previous = getPrevious(last);
            last = previous;
            last.nextNode = null;

        }
        size--;
    }

    public int size() {
        return size;
    }

    public E[] toArray(){
        E[] array =(E[]) new Object[size];
        int index = 0;
        Node<E> current = first;
        while (current != null ){
            array[index++] = current.value;
            current = current.nextNode;
        }
        return array;
    }

    /**
     public E[] toArrays(){
     E[] array = (E[]) new Object[size];
     Node<E> currentNode = first;
     for (int i = 0; i < size; i++) {
     array[i] = currentNode.value;
     currentNode = currentNode.nextNode;
     }
     return array;
     }
     */

    private Node<E> getPrevious(Node<E> node) {
        Node<E> current = first;
        while (current.nextNode != null) {
            if (current.nextNode == node)
                return current;
            current = current.nextNode;
        }
        return null;
    }

    private boolean isEmpty() {
        return first == null;
    }

}
