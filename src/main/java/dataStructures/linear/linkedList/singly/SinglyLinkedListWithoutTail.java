package dataStructures.linear.linkedList.singly;

import dataStructures.linear.linkedList.LinkedList;

import java.util.NoSuchElementException;

public class SinglyLinkedListWithoutTail<E extends Comparable<E>> implements LinkedList<E> {


    private class Node<E> {
        private E value;
        private Node<E> next;

        public Node(E value) {
            this.value = value;
            this.next = null;
        }

        public String toString() {
            return "" + value;
        }
    }

    private Node<E> head;
    private int size;

    @Override
    public void insertAtHead(E data) {
        Node<E> node = new Node<>(data);
        if (head != null)
            node.next = head;
        head = node;
        size++;
    }

    @Override
    public void insertAtEnd(E data) {
        Node<E> node = new Node<>(data);
        if (isEmpty())
            head = node;
        else {
            Node<E> current = head;
            Node<E> prev = null;
            while (current != null) {
                prev = current;
                current = current.next;
            }
            prev.next = node;
        }
        size++;
    }

    @Override
    public void deleteAtHead() {
        if (isEmpty())
            throw new NoSuchElementException();

        Node<E> temp = head;
        head = head.next;
        temp.next = null;
        size--;
    }

    @Override
    public void deleteAtEnd() {
        if (isEmpty())
            throw new NoSuchElementException();

        if (head.next == null) {
            head = null;
        } else {
            Node<E> current = head;
            Node<E> prev = null;
            while (current.next != null) {
                prev = current;
                current = current.next;
            }
            prev.next = null;
        }
        size--;
    }

    @Override
    public void deleteByValue(E data) {
        if (isEmpty())
            throw new NoSuchElementException();
        Node<E> current = head;
        if (head.value.equals(data)) {
            head = head.next;
        } else {
            Node<E> prev = null;
            while (current != null && !current.value.equals(data)) {
                prev = current;
                current = current.next;
            }
            if (current == null)
                throw new NoSuchElementException(data + " not exist!");
            prev.next = current.next;
        }
        current.next = null;
        size--;
    }

    @Override
    public void printList() {
        Node<E> current = head;
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }

    @Override
    public boolean contains(E data) {
        try {
            indexOf(data);
            return true;
        } catch (NoSuchElementException noSuchElementException) {
            return false;
        }
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
        E[] array = (E[]) new Comparable[size];
        int index = 0;
        Node<E> current = head;
        while (current != null) {
            array[index++] = current.value;
            current = current.next;
        }
        return array;
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
        throw new NoSuchElementException("Node With Value " + value.toString() + " not exist");
    }

}
