package dataStructures.linear.linkedList.doubly;

import dataStructures.linear.linkedList.LinkedList;

public class DoublyLinkedListWithoutTail<T extends Comparable<T>> implements LinkedList<T> {
    // Class Node
    private class Node<T> {
        private Node<T> next;
        private Node<T> prev;
        private T data;

        public Node(T data) {
            this.data = data;
            next = prev = null;
        }
    }

    // Create LinkedList Class To point the chaining
    private Node<T> head;
    private int size;

    public DoublyLinkedListWithoutTail() {
        head = null;
        size = 0;
    }

    @Override
    public void insertAtHead(T data) {
        Node<T> node = new Node<>(data);
        if (!isEmpty()) {
            head.prev = node;
            node.next = head;
        }
        head = node; // in case the list empty or not
        size++;
    }

    @Override
    public void insertAtEnd(T data) {
        if (isEmpty()) {
            insertAtHead(data);
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            Node<T> node = new Node<>(data);
            current.next = node;
            node.prev = current;
            size++;
        }
    }

    @Override
    public void deleteAtHead() {
        if (isEmpty())
            throw new IllegalStateException("List already empty!!");

        Node<T> nodeToBeDeleted = head;
        head = head.next;
        nodeToBeDeleted.next = null;
        nodeToBeDeleted.prev = null;
        size--;
    }

    @Override
    public void deleteAtEnd() {
        if (isEmpty())
            throw new IllegalStateException("List already empty!!");

        Node<T> current = head;
        while (current.next != null)
            current = current.next;

        current.prev.next = null;
        current.prev = null;
        size--;
    }

    @Override
    public void deleteByValue(T data) {
        if (isEmpty())
            throw new IllegalStateException();

        Node<T> current = head;
        while (current != null && !current.data.equals(data))
            current = current.next;

        if (current == null)
            throw new IllegalArgumentException("Not Found this value");

        else if (current.prev == null) {
            deleteAtHead();
        } else if (current.next == null) {
            deleteAtEnd();
        } else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
            current.next = current.prev = null;
            size--;
        }
    }

    @Override
    public void printList() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + "\t");
            current = current.next;
        }
    }

    @Override
    public boolean contains(T data) {
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(data))
                return true;
            current = current.next;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public T[] toArray() {
        T[] elements = (T[]) new Object[size];
        Node<T> current = head;
        int index = 0;
        while (current != null) {
            elements[index++] = current.data;
            current = current.next;
        }
        return elements;
    }

    @Override
    public int indexOf(T value) {
        return 0;
    }


}
