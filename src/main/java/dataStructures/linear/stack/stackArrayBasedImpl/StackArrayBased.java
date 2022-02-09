package dataStructures.linear.stack.stackArrayBasedImpl;

import java.util.Arrays;

public class StackArrayBased<T> {
    private final int size;
    private int top;
    private final T[] items;

    public StackArrayBased(int size) {
        this.size = size;
        this.top = 0;
        this.items = (T[]) new Object[size];
    }

    boolean isFull() {
        return top == size;
    }

    boolean isEmpty() {
        return top == 0;
    }

    public void push(T item) {
        if (!isFull())
            items[top++] = item;
        else
            throw new StackOverflowError();
    }

    public T pop() {
        if (!isEmpty())
            return items[--top];
        else
            throw new IllegalStateException();
    }

    public T peek() {
        if (!isEmpty())
            return items[top - 1];
        else
            throw new IllegalStateException();
    }

    public void clear() {
        for (int i = 0; i < items.length; i++) {
            items[i] = null;
        }
        //Arrays.fill(items, null);
        top = 0;
    }

    @Override
    public String toString() {
        // return Arrays.stream(items).limit(top).collect(Collectors.toList()).toString();
        T[] ts = Arrays.copyOfRange(items, 0, top);
        return Arrays.toString(ts);
    }
}
