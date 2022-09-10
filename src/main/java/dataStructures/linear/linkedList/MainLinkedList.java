package dataStructures.linear.linkedList;

import dataStructures.linear.linkedList.singly.SinglyLinkedListWithoutTail;

import java.util.Arrays;

public class MainLinkedList {
    public static void main(String[] args) {
//
//        SinglyLinkedListWithTail<Integer> linkedList = new SinglyLinkedListWithTail<>();
//        linkedList.insertAtEnd(20);
//        linkedList.insertAtEnd(10);
////        linkedList.deleteByValue(10);
//        linkedList.insertAtEnd(30);
//        System.out.println(linkedList.search(30));
//
//        System.out.println(linkedList.size());
//        linkedList.printList();
//        SinglyLinkedListWithTail.reverse(linkedList);
//        linkedList.printList();
//        SinglyLinkedListWithTail.reverseRecursively(linkedList);
//        linkedList.printList();
//        System.out.println("\n=============");

//        LinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();
//        doublyLinkedList.insertAtEnd(20);
//        doublyLinkedList.insertAtEnd(10);
//        doublyLinkedList.deleteByValue(10);
//        doublyLinkedList.insertAtEnd(30);
//        System.out.println(doublyLinkedList.search(30));
//        System.out.println(doublyLinkedList.size());
//        doublyLinkedList.printList();
        SinglyLinkedListWithoutTail<Integer> integerSinglyLinkedListWithoutTail = new SinglyLinkedListWithoutTail<>();
        integerSinglyLinkedListWithoutTail.insertAtHead(4);
        integerSinglyLinkedListWithoutTail.insertAtHead(3);
        integerSinglyLinkedListWithoutTail.insertAtHead(2);
//        System.out.println(integerSinglyLinkedListWithoutTail.indexOf(5));
//        System.out.println(integerSinglyLinkedListWithoutTail.contains(5));
//        System.out.println(integerSinglyLinkedListWithoutTail.contains(2));
//        integerSinglyLinkedListWithoutTail.deleteAtHead();
//        integerSinglyLinkedListWithoutTail.deleteAtHead();
//        integerSinglyLinkedListWithoutTail.deleteByValue(4);
//        integerSinglyLinkedListWithoutTail.deleteByValue(2);
        integerSinglyLinkedListWithoutTail.deleteByValue(3);
//        integerSinglyLinkedListWithoutTail.deleteByValue(3);
//        integerSinglyLinkedListWithoutTail.deleteByValue(2);
//        integerSinglyLinkedListWithoutTail.deleteAtEnd();
        integerSinglyLinkedListWithoutTail.printList();

        System.out.println(Arrays.toString(integerSinglyLinkedListWithoutTail.toArray()));

    }
}
