package dataStructures.nonLinear.bst;

import dataStructures.nonLinear.bst.enums.TraversalType;
import dataStructures.nonLinear.bst.impl.BinarySearchTree;

public class Main {
    public static void main(String[] args) {
        Tree<Integer> tree = new BinarySearchTree<>();
        tree.insert(4);
        tree.insert(5);
        tree.insert(2);
        tree.insert(3);
        tree.insert(9);
        tree.insert(10);

        BinarySearchTree<Integer> binarySearchTree = (BinarySearchTree<Integer>)tree;
        binarySearchTree.recursiveInsert(7);

        System.out.println(tree.contains(7));
        System.out.println(tree.search(10));
        System.out.println(binarySearchTree.iterativeSearch(10));
        System.out.println(binarySearchTree.iterativeSearch(5));
        tree.remove(5);
//        tree.remove(5);
        System.out.println();
        tree.traverse(TraversalType.PRE_ORDER);
        System.out.println();
        tree.traverse(TraversalType.IN_ORDER);
        System.out.println();
        tree.traverse(TraversalType.POST_ORDER);
        System.out.println();
    }
}
