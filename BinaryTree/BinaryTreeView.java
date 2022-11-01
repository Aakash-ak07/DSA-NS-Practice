package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

/*
          1
        /   \
       2     3
        \   / \
         4 5   6
          / \
         7   8
         
*/

class Node {
    int data;
    int height;
    Node left, right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class Pair {
    int hd;
    Node root;

    public Pair(int hd, Node root) {
        this.root = root;
        this.hd = hd;
    }
}

class BinarytreeView {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);

        rightView(root);
        System.out.println("");
        leftView(root);
        System.out.println("");
        topView(root);
        System.out.println("");
        bottomView(root);
        System.out.println("");
    }

    public static void rightView(Node root) {
        rightViewHelper(root, 1, 0);
    }

    public static int rightViewHelper(Node root, int level, int last) {
        if (root == null)
            return last;
        if (last < level) {
            System.out.print(root.data + " ");
            last = level;
        }
        last = rightViewHelper(root.right, level + 1, last);
        last = rightViewHelper(root.left, level + 1, last);

        return last;
    }

    public static void leftView(Node root) {
        leftViewHelper(root, 1, 0);
    }

    public static int leftViewHelper(Node root, int level, int last) {
        if (root == null)
            return last;

        if (last < level) {
            System.out.print(root.data + " ");
            last = level;
        }
        last = leftViewHelper(root.left, level + 1, last);
        last = leftViewHelper(root.right, level + 1, last);

        return last;
    }

    public static void topView(Node root) {
        if (root == null)
            return;

        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();

        Queue<Node> qu = new LinkedList<Node>();
        qu.add(root);

        while (!qu.isEmpty()) {
            Node temp = qu.remove();
            int hd = temp.height;

            if (map.get(hd) == null) {
                map.put(hd, temp.data);
            }
            if (temp.left != null) {
                temp.left.height = hd - 1;
                qu.add(temp.left);
            }
            if (temp.right != null) {
                temp.right.height = hd + 1;
                qu.add(temp.right);
            }
        }
        System.out.println(map.values());
    }

    public static void bottomView(Node root) {
        if (root == null)
            return;
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        Queue<Node> qu = new LinkedList<Node>();
        qu.add(root);
        while (!qu.isEmpty()) {
            Node temp = qu.remove();
            int hd = temp.height;

            map.put(hd, temp.data);

            if (temp.left != null) {
                temp.left.height = hd - 1;
                qu.add(temp.left);
            }
            if (temp.right != null) {
                temp.right.height = hd + 1;
                qu.add(temp.right);
            }
        }
        System.out.println(map.values());
    }
}
