package BinaryTree;

class Node
{
    int data;
    Node left, right;
  
    public Node(int data)
    {
        this.data = data;
        this.left = null; 
        this.right = null;
    }
}

public class MergeBinaryTree {

    Node root;
    Node buildTree(int inorder[], int start, int end, Node node)
    {
        if (start > end)
            return null;
  
        int i = max(inorder, start, end);       /* Find index of the maximum element from Binary Tree */
  
        node = new Node(inorder[i]);    /* Pick the maximum value and make it root */
  
        /* If this is the only element in inorder[start..end],
         then return it */
        if (start == end)
            return node;
  
        /* Using index in Inorder traversal, construct left and
         right subtress */
        node.left = buildTree(inorder, start, i - 1, node.left);
        node.right = buildTree(inorder, i + 1, end, node.right);
  
        return node;
    }
  
    public static int max(int arr[], int strt, int end)
    {
        int i, max = arr[strt], maxind = strt;
        for (i = strt + 1; i <= end; i++)
        {
            if (arr[i] > max)
            {
                max = arr[i];
                maxind = i;
            }
        }
        return maxind;
    }
  
    public static void printInorder(Node node)
    {
        if (node == null)
            return;

        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }

    // public static Node mergeBT(Node root1, Node root2)
    // {
    //     if(root1 == null)  return root2;
    //     if(root2 == null)  return root1;


    // }
    public static void main(String[] args) {
        MergeBinaryTree tree = new MergeBinaryTree();
        int inorder[] = new int[] {5, 10, 40, 30, 28};
        int len = inorder.length;
        Node mytree = tree.buildTree(inorder, 0, len-1, tree.root);
        System.out.println("");
        MergeBinaryTree.printInorder(mytree);
    }
}
