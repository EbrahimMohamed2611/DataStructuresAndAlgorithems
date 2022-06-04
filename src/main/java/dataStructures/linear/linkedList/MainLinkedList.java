package dataStructures.linear.linkedList;

import java.util.Arrays;

public class MainLinkedList {
    public static void main(String[] args) {

        LinkedList<Integer> linkedList = new SinglyLinkedList<>();
        linkedList.insertAtEnd(20);
        linkedList.insertAtEnd(10);
        linkedList.deleteByValue(10);
        linkedList.insertAtEnd(30);
//        linkedList.addLast(20);
//        linkedList.addLast(30);
//
//        linkedList.addFirst(5);
//        linkedList.addFirst(0);
//        linkedList.removeFirst();
//        linkedList.removeLast();
        System.out.println(linkedList.size());
        linkedList.printList();
       // System.out.println(Arrays.toString(linkedList.toArrays()));
//        System.out.println(linkedList.indexOf(20));
//        System.out.println(linkedList.contains(20));
//        System.out.println(linkedList.contains(100));
        System.out.println("=============");
        LinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();
        doublyLinkedList.insertAtEnd(20);
        doublyLinkedList.insertAtEnd(10);
        doublyLinkedList.deleteByValue(10);
        doublyLinkedList.insertAtEnd(30);
//        linkedList.addLast(20);
//        linkedList.addLast(30);
//
//        linkedList.addFirst(5);
//        linkedList.addFirst(0);
//        linkedList.removeFirst();
//        linkedList.removeLast();
        System.out.println(doublyLinkedList.size());
        doublyLinkedList.printList();
    }
}
