package dataStructures.linear.stack.stackLinkedListBasedImpl;

import dataStructures.linear.stack.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<Integer>  stack = new StackLinkedListBasedImpl<>();
        stack.push(1);
        stack.push(5);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }
}
