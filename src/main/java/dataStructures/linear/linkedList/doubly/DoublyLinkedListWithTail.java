package dataStructures.linear.linkedList.doubly;

import dataStructures.linear.linkedList.LinkedList;

import java.util.NoSuchElementException;

public class DoublyLinkedListWithTail<E extends Comparable<E>> implements LinkedList<E> {

    private class Node<E> {
        private Node<E> next;
        private Node<E> prev;
        private E value;

        public Node(E value) {
            this.value = value;
            this.next = this.prev = null;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    //         __________________
    //     <--|  prev | 4 | next |-->
    private Node<E> head;
    private Node<E> tail;
    private int size;


    @Override
    public void insertAtHead(E data) {
        Node<E> node = new Node<>(data);
        if (isEmpty()) {
            head = tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        size++;
    }

    @Override
    public void insertAtEnd(E data) {
        Node<E> node = new Node<>(data);
        if (isEmpty()) {
            head = tail = node;
        } else {
            node.prev = tail;
            tail.next = node;
            tail = node;
        }
        size++;
    }

    @Override
    public void deleteAtHead() {
        if (isEmpty())
            throw new NoSuchElementException();
        else if (head == tail) {
            head = tail = null;
        } else {
            Node<E> current = head;
            head = head.next;
            current.next = head.prev = null;
        }
        size--;
    }

    @Override
    public void deleteAtEnd() {
        if (isEmpty())
            throw new NoSuchElementException();
        else if (head == tail) {
            head = tail = null;
        } else {
            Node<E> prev = tail.prev;
            prev.next = tail.prev = null;
            tail = prev;
        }
        size--;
    }

    @Override
    public void deleteByValue(E data) {
        if (head.value.equals(data)) {
            deleteAtHead();
        } else if (tail.value.equals(data)) {
            deleteAtEnd();
        } else {
            Node<E> current = head;
            while (current != null && !current.value.equals(data)) {
                current = current.next;
            }
            if (current == null || !current.value.equals(data))
                throw new NoSuchElementException("Element not exist !!");

            current.prev.next = current.next;
            current.next.prev = current.prev;
            current.next = current.prev = null;
            size--;
        }
    }

    @Override
    public void printList() {
        Node<E> current = head;
        while (current != null) {
            System.out.print("<- " + current.value + " -> ");
            current = current.next;
        }
    }

    @Override
    public boolean contains(E data) {
        Node<E> current = head;
        while (current != null) {
            if (current.value.equals(data))
                return true;
            current = current.next;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public E[] toArray() {
        E[] nodes = (E[]) new Comparable[size];
        int index = 0;
        Node<E> current = head;
        while (current != null) {
            nodes[index++] = current.value;
            current = current.next;
        }
        return nodes;
    }

    @Override
    public int indexOf(E value) {
        int index = 0;
        Node<E> current = head;
        while (current != null) {
            if (current.value.equals(value))
                return index;
            index++;
            current = current.next;
        }
        return -1;
    }

}
