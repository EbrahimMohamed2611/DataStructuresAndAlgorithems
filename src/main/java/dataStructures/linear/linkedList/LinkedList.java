package dataStructures.linear.linkedList;

public interface LinkedList<T extends Comparable<T>> {

    void insertAtHead(T data);

    void insertAtEnd(T data);

    void deleteAtHead();

    void deleteAtEnd();

    void deleteByValue(T data);

    void printList();

    boolean contains(T data);

    int size();

    boolean isEmpty();

    T[] toArray();

    int indexOf(T value);

}
