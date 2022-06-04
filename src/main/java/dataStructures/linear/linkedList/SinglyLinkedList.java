package dataStructures.linear.linkedList;

import java.util.NoSuchElementException;

public class SinglyLinkedList<E> implements LinkedList<E> {

    private class Node<E> {
        private E value;
        private Node<E> nextNode;

        public Node(E value) {
            this.value = value;
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private int size;

    @Override
    public void insertAtEnd(E value) {
        Node<E> node = new Node<>(value);
        if (isEmpty()) {
            head = tail = node;
        } else {
            tail.nextNode = node;
        }
        size++;
    }

    @Override
    public void deleteAtHead() {
        // first case there's no Elements
        //second case there is only one element
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else if (head == tail) {
            head = tail = null;
        } else {
            // [10 -> 20 -> 30]
            Node<E> second = head.nextNode;
            head.nextNode = null;
            head = second;
        }
        size--;
    }

    @Override
    public void deleteAtEnd() {
        if (isEmpty())
            throw new NoSuchElementException();

        if (head == tail)
            head = tail = null;
        else {
            Node<E> previous = getPrevious(tail);
            tail = previous;
            tail.nextNode = null;

        }
        size--;
    }

    @Override
    public void deleteByValue(E data) {
        if (isEmpty())
            throw new IllegalStateException("List is Empty");
        Node<E> current = head;
        Node<E> prev = null;
        while (current != null && !current.value.equals(data)) {
            prev = current;
            current = current.nextNode;
        }

        if (prev == null) { // that is mean the list have only one element
//           Node<E> second = current;
//           head = current.nextNode;
//           second.nextNode = null;
            deleteAtHead();
        } else if (current != null) {
            Node<E> second = current.nextNode;
            prev.nextNode = second;
            current.nextNode = null;
            size--;
        }
    }

    @Override
    public void printList() {
        Node<E> current = head;
        while (current!=null){
            System.out.print(current.value + "\t");
            current = current.nextNode;
        }
    }

    @Override
    public boolean search(E data) {
        return indexOf(data) != -1;
    }

    @Override
    public void insertAtHead(E value) {
        Node<E> node = new Node<>(value);
        if (isEmpty()) {
            head = tail = node;
        } else {
            node.nextNode = head;
            head = node;
        }
        size++;
    }

    private int indexOf(E value) {
        int index = 0;
        Node<E> currentNode = head;
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

    @Override
    public int size() {
        return size;
    }

    @Override
    public E[] toArray() {
        E[] array = (E[]) new Object[size];
        int index = 0;
        Node<E> current = head;
        while (current != null) {
            array[index++] = current.value;
            current = current.nextNode;
        }
        return array;
    }

    /**
     * public E[] toArrays(){
     * E[] array = (E[]) new Object[size];
     * Node<E> currentNode = first;
     * for (int i = 0; i < size; i++) {
     * array[i] = currentNode.value;
     * currentNode = currentNode.nextNode;
     * }
     * return array;
     * }
     */

    private Node<E> getPrevious(Node<E> node) {
        Node<E> current = head;
        while (current.nextNode != null) {
            if (current.nextNode == node)
                return current;
            current = current.nextNode;
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

}
