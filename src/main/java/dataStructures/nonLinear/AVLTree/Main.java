package dataStructures.nonLinear.AVLTree;

public class Main {
    public static void main(String[] args) {
        AVLTree avlTree = new AVLTree();
        avlTree.insert(30);
        avlTree.insert(10);
        avlTree.insert(20);
//        avlTree.insert(15);


//        avlTree.insert(7);
//        avlTree.insert(8);
//        avlTree.insert(9);
        avlTree.traversePreOrder();
//        System.out.println(avlTree.heightOfTree());
    }
}
