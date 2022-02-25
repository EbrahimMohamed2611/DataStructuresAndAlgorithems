package dataStructures.linear.queue.standard;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class StandardQueue<T> {
    private final T[] items;
    private int counter;
    private int front;
    private int rear;

    public StandardQueue(int capacity) {
        items = (T[]) new Object[capacity];
    }

    public void enqueue(T item) {
        if (isFull())
            throw new IllegalStateException();

        items[rear++] = item;
        counter++;
    }

    public T dequeue() {
     // [1, 5, 6, 7, 2]
     //  F           R
        T item = items[front];
        if (item == null)
            throw new NoSuchElementException();
        items[front++] = null;
        counter--;
        return item;
    }

    public boolean isFull() {
        return counter == items.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }
}
