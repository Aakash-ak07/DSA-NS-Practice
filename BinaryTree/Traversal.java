package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Node {
    int data;
    // int height;
    Node left, right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

// 2
// / \
// 7 5
// / \ \
// 2 6 9
// / \ /
// 5 11 4

public class Traversal {
    public static int getHeight(Node root) {
        if (root == null)
            return -1;
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    // using recursion [O(n^2)]
    public static void levelOrder(Node root) {
        if (root == null)
            return;
        int height = getHeight(root);
        for (int i = 0; i <= height; i++) {
            printAtGivenLevel(root, i + 1);
            System.out.println();
        }
    }

    public static void printAtGivenLevel(Node root, int level) {
        if (root == null)
            return;
        if (level == 1) {
            System.out.print(root.data + " ");
        }
        printAtGivenLevel(root.left, level - 1);
        printAtGivenLevel(root.right, level - 1);
    }

    // without recursion Using Queue
    public static void levelOrderUsingQueue(Node root) {
        if (root == null)
            return;

        Queue<Node> q = new LinkedList<Node>();
        q.add(root);

        while (q.size() > 0) {
            Node top = q.remove();
            System.out.print(top.data + " ");

            if (top.left != null)
                q.add(top.left);

            if (top.right != null)
                q.add(top.right);
        }
    }

    // using recursion
    public static void reverseLevelOrder(Node root) {
        if (root == null)
            return;
        int height = getHeight(root);

        for (int i = height; i >= 0; i--) {
            printAtGivenLevel2(root, i + 1);
            System.out.println();
        }
    }

    public static void printAtGivenLevel2(Node root, int level) {
        if (root == null)
            return;
        if (level == 1) {
            System.out.print(root.data + " ");
        }
        printAtGivenLevel2(root.left, level - 1);
        printAtGivenLevel2(root.right, level - 1);
    }

    public static void reverseLevelOrderUsingQueue(Node root) {
        if (root == null)
            return;

        Queue<Node> q = new LinkedList<Node>();
        q.add(root);

        Stack<Node> st = new Stack<Node>();

        while (q.size() > 0) {
            Node top = q.remove();

            if (top.left != null)
                q.add(top.left);

            if (top.right != null)
                q.add(top.right);

            st.push(top);
        }

        while (st.size() > 0) {
            System.out.print(st.pop().data + " ");
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // Traversal tree = new Traversal(); // if use this remove static function ...

        Node root = new Node(2);
        root.left = new Node(7);
        root.right = new Node(5);
        root.left.left = new Node(2);
        root.left.right = new Node(6);
        root.right.right = new Node(9);
        root.right.right.left = new Node(4);
        root.left.right.left = new Node(5);
        root.left.right.right = new Node(11);

        Traversal.levelOrder(root);
        Traversal.levelOrderUsingQueue(root);
        Traversal.reverseLevelOrder(root);
        Traversal.reverseLevelOrderUsingQueue(root);
    }
}

// preOrder inOrder and postOrder traversal using itrative method
// if(pair.level == 1){

// // print the node in 'pre-order' answer

// // increase the level of pair

// // push to stack

// // push left child to stack as new pair (child,1)

// }else if(pair.level == 2){

// // print the node in 'In-order' answer

// // increase the level of pair

// // push to stack

// // push right child to stack as new pair (child, 1)

// }else if(pair.level == 3){

// // print the node in 'post-order' answer

// }

//inorder traversal
// Node c = root;

// while(!st.isEmpty() || c != null){

// if(c != null){

// st.push(c);

// c = c.left;

// }else{

// c = st.pop();

// syso(c.val);

// c = c.right;

// }

// }


