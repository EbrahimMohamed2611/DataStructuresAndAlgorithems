package dataStructures.nonLinear.bst;

import dataStructures.nonLinear.bst.enums.TraversalType;

public interface Tree <T extends Comparable<T>>{

    boolean insert(T data);

    T remove(T data);

    int size();

    Node<T> search(T data);

    boolean isEmpty();

    boolean contains(T data);

    T findMin();

    T findMax();

    int height();

    void traverse(TraversalType traversalType);
}
