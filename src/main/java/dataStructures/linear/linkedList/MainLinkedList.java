package dataStructures.linear.linkedList;

public class MainLinkedList {
    public static void main(String[] args) {

        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
        linkedList.insertAtEnd(20);
        linkedList.insertAtEnd(10);
        linkedList.deleteByValue(10);
        linkedList.insertAtEnd(30);
        System.out.println(linkedList.search(30));

        System.out.println(linkedList.size());
        linkedList.printList();
        SinglyLinkedList.reverse(linkedList);
        linkedList.printList();
        SinglyLinkedList.reverseRecursively(linkedList);
        linkedList.printList();
        System.out.println("\n=============");

//        LinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();
//        doublyLinkedList.insertAtEnd(20);
//        doublyLinkedList.insertAtEnd(10);
//        doublyLinkedList.deleteByValue(10);
//        doublyLinkedList.insertAtEnd(30);
//        System.out.println(doublyLinkedList.search(30));
//        System.out.println(doublyLinkedList.size());
//        doublyLinkedList.printList();
    }
}
