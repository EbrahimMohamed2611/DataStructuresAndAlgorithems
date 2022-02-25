package dataStructures.linear.queue.stackQueue;

import java.util.Arrays;
import java.util.Stack;

public class QueueWithTwoStacks<T> {

    // first Queue for add items
    private final Stack<T> firstStack;
    // second Queue for remove items
    private final Stack<T> secondStack;

    public QueueWithTwoStacks() {
        firstStack = new Stack<>();
        secondStack = new Stack<>();
    }

    public void enqueue(T item) {
        firstStack.push(item);
    }

    public T dequeue() {
        if (isEmpty())
            throw new IllegalStateException();
        moveStack1ToStack2();
        return secondStack.pop();
    }

    public T peek(){
        if (isEmpty())
            throw new IllegalStateException();
        moveStack1ToStack2();
        return secondStack.peek();
    }

    private void moveStack1ToStack2() {
        if (secondStack.isEmpty())
            while (!firstStack.isEmpty())
                secondStack.push(firstStack.pop());
    }

    private boolean isEmpty() {
        return firstStack.isEmpty() && secondStack.isEmpty();

    }

    @Override
    public String toString() {
        return "QueueWithTwoStacks{" +
                "firstStack=" + firstStack +
                ", secondStack=" + secondStack +
                '}';
    }
}
