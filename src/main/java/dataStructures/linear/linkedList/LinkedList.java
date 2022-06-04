package dataStructures.linear.linkedList;

public interface LinkedList<T> {

    void insertAtHead(T data);

    void insertAtEnd(T data);

    void deleteAtHead();

    void deleteAtEnd();

    void deleteByValue(T data);

    void printList();

    boolean search(T data);

    int size();

    boolean isEmpty();

    T[] toArray();

}
