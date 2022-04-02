package dataStructures.linear.stack.stackLinkedListBasedImpl;

import dataStructures.linear.stack.Stack;

import java.util.*;

public class StackLinkedListBasedImpl<T> implements Stack<T>, Iterable<T> {
    private final LinkedList<T> list = new LinkedList<>();


    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void push(T item) {
        list.addFirst(item);
    }

    @Override
    public T pop() {
        if (list.isEmpty())
            throw new EmptyStackException();
        return list.removeFirst();
    }

    @Override
    public T peek() {
        if (list.isEmpty())
            throw new EmptyStackException();
        return list.peekFirst();
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }
}
