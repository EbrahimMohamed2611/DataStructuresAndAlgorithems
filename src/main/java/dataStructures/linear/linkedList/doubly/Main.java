package dataStructures.linear.linkedList.doubly;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedListWithTail<Integer> list = new DoublyLinkedListWithTail<>();
//        list.insertAtHead(4);
//        list.insertAtHead(3);
//        list.insertAtHead(2);
        list.insertAtEnd(2);
        list.insertAtEnd(3);
        list.insertAtEnd(4);
        System.out.println(list.contains(3));
        System.out.println(list.contains(21));
//        list.deleteByValue(3);
//        list.deleteByValue(3);
//        list.deleteByValue(3);
//        list.deleteAtEnd();
        list.printList();
//        System.out.println();
    }
}
