package dataStructures.linear.queue.priority;

public class Main {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(5);
        priorityQueue.add(5);
        priorityQueue.add(4);
        priorityQueue.add(2);
        priorityQueue.add(3);
        priorityQueue.add(1);
        System.out.println(priorityQueue.remove());
        priorityQueue.add(0);
        System.out.println(priorityQueue.remove());
        System.out.println(priorityQueue.remove());
        System.out.println(priorityQueue.remove());
        System.out.println(priorityQueue.remove());
        System.out.println(priorityQueue.remove());
//        System.out.println(priorityQueue.remove());

        System.out.println(priorityQueue);
    }
}
