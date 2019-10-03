package leetcode;

import org.junit.jupiter.api.Assertions;

// https://leetcode.com/problems/inorder-successor-in-bst-ii/
public class InorderSuccessorInBST2 {

    /**
     * we need to handle 2 cases:
     * 1) if the x node has a right subtree, the successor is a node with minimum value in that subtree
     * 2) otherwise, the successor is a node which has x node in its left subtree.
     */
    private static Node inorderSuccessor(Node x) {
        // case 1
        if (x.right != null) {
            x = x.right;
            while (x.left != null) {
                x = x.left;
            }
            return x;
        }

        //case 2
        Node parent = x.parent;
        while (parent != null && parent.right == x) {
            x = parent;
            parent = x.parent;
        }

        return parent;
    }

    private static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;

        Node(int v, Node p) {
            val = v;
            parent = p;
        }
    }

    public static void main(String... args) {
        Node r = new Node(20, null);
        r.left = new Node(8, r);
        r.right = new Node(21, r);
        r.left.left = new Node(4, r.left);
        r.left.right = new Node(11, r.left);
        r.left.right.left = new Node(9, r.left.right);

        // 8 -> 9
        Assertions.assertEquals(inorderSuccessor(r.left), r.left.right.left);

        // 11 -> 20
        Assertions.assertEquals(inorderSuccessor(r.left.right), r);
    }
}
