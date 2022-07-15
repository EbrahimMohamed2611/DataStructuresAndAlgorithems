package dataStructures.nonLinear.binarySearchTree;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.insert(4);
        tree.insert(5);
        tree.insert(2);
        tree.insert(3);
        tree.insert(9);
        tree.insert(10);

//        tree.add(10);
//        tree.add(20);
//        tree.add(5);
//        tree.add(7);
//        tree.add(25);
//        tree.add(23);
//        tree.add(2);
//
//        tree.insertRecursively(20);
//        tree.insertRecursively(10);
//        tree.insertRecursively(5);
//        tree.insertRecursively(7);
//        tree.insertRecursively(25);
//        tree.insertRecursively(23);
//        tree.insertRecursively(2);
//        System.out.println(tree.searchIterative(10));
//        System.out.println(tree.searchRecursively(10));
//        System.out.println(tree.findMinElement());
//        System.out.println(tree.findMinElementRecursively());
//        System.out.println(tree.findMaxElement());
//        System.out.println(tree.findMaxElementRecursively());
//        tree.traverseBF();
//        System.out.println(tree.isBinarySearchTree());
//        System.out.println(tree.isBinarySearchTreeValid());
        tree.traverseInOrder();
        tree.delete(5);
        tree.traverseInOrder();
    }
}
