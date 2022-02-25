package dataStructures.linear.queue.reverseQueue;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class ReverseQueue {
    public static void main(String[] args) {
        Queue<String> queue = new ArrayDeque<>();
        queue.add("E");
        queue.add("b");
        queue.add("r");
        queue.add("a");
        queue.add("h");
        queue.add("i");
        queue.add("m");
        System.out.println(queue);
        System.out.println("====== After Reversing ======");
        reverseQueue(queue);
        System.out.println(queue);
    }

    public static void reverseQueue(Queue<String> queue){
        Stack<String> stack = new Stack<>();
        while (!queue.isEmpty())
            stack.push(queue.remove());
        while (!stack.isEmpty())
            queue.add(stack.pop());
    }
}
