package dataStructures.nonLinear.AVLTree;

public class AVLTree {

    private class Node {
        private Node left, right;
        int value, height;

        public Node(int value) {
            this.value = value;
            right = left = null;
        }

        @Override
        public String toString() {
            return "Node = " + value;
        }
    }

    private Node root;

    public AVLTree() {
        root = null;
    }

    public void insert(int value) {
        root = insert(root, value);
    }

    private Node insert(Node root, int value) {
        if (root == null)
            return new Node(value);
        else if (value > root.value)
            root.right = insert(root.right, value);
        else
            root.left = insert(root.left, value);

        // here the back to every parent for the new node will start so this is the best place to update the parent height
//        root.height = 1 + Math.max(height(root.right), height(root.left));
        setHeight(root);
        // here we need to calc the balance factor for every parent for the new node
        if (height(root.left) - height(root.right) > 1) {
            System.out.println("Left Heavy on Node " + root.value);

            if (height(root.left.left) - height(root.left.right) < 0){
                System.out.println("Left Rotate ( " + root.left.value + " )");
                root.left = rotateLeft(root.left);
            }
            System.out.println("Right Rotate ( " + root.value + " )");
            return  rotateRight(root);
        }
        else if (height(root.left) - height(root.right) < -1) {
            System.out.println("Right Heavy on Node " + root.value);

            if (height(root.right.left) - height(root.right.right) > 0){
                System.out.println("Right Rotate ( " + root.right.value + " )");
                root.right = rotateRight(root.right);
            }
            System.out.println("Left Rotate ( " + root.value + " )");
            return rotateLeft(root);
        }
        return root;
    }

    private Node rotateLeft(Node node){
        Node newRoot = node.right;
        node.right = newRoot.left;
        newRoot.left = node;
        // before returning we need to calc the new height for both root and new root
        setHeight(node);
        setHeight(newRoot);
        return newRoot;
    }

    private Node rotateRight(Node node){
        Node newRoot = node.left;
        node.left = newRoot.right;
        newRoot.right = node;

        // before returning we need to calc the new height for both root and new root
        setHeight(node);
        setHeight(newRoot);
        return newRoot;
    }

    private void setHeight(Node node){
        node.height = 1 + Math.max(height(node.right), height(node.left));
    }

    private int height(Node node) {
//        if(node == null)
//            return -1;
//        else
//            return node.height;
        return node == null ? -1 : node.height;
    }

    public void traversePreOrder() {
        traversePreOrder(root);
    }

    private void traversePreOrder(Node root) {
        if (root == null)
            return;
        System.out.print(root.value + "\t");
        traversePreOrder(root.left);
        traversePreOrder(root.right);
    }

    public int heightOfTree() {
        return heightOfTreeHelper(root);
    }

    private int heightOfTreeHelper(Node root) {
        if (root == null)
            return -1;
        int rightHeight = heightOfTreeHelper(root.right);
        int leftHeight = heightOfTreeHelper(root.left);
        return 1 + Math.max(rightHeight, leftHeight);
    }
}
