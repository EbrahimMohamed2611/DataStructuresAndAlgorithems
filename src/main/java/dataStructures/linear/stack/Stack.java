package dataStructures.linear.stack;

public interface Stack<T> {

    boolean isEmpty();

    void push(T item);

    T pop();

    public T peek();

    void clear();
}
