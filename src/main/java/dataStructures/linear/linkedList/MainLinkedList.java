package dataStructures.linear.linkedList;

import java.util.Arrays;

public class MainLinkedList {
    public static void main(String[] args) {

        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addLast(10);
        linkedList.addLast(20);
        linkedList.addLast(30);

        linkedList.addFirst(5);
        linkedList.addFirst(0);
        linkedList.removeFirst();
        linkedList.removeLast();

        System.out.println(linkedList.size());
        System.out.println(Arrays.toString(linkedList.toArray()));
        System.out.println(Arrays.toString(linkedList.toArrays()));
//        System.out.println(linkedList.indexOf(20));
//        System.out.println(linkedList.contains(20));
//        System.out.println(linkedList.contains(100));

    }
}
