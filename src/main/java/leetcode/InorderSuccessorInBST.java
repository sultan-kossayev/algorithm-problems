package leetcode;

import org.junit.jupiter.api.Assertions;

// https://leetcode.com/problems/inorder-successor-in-bst/
public class InorderSuccessorInBST {

    /**
     * we need to handle 2 cases:
     * 1) if p node has a right subtree, then the successor is the minimum element in that subtree
     * 2) otherwise we start from the root and go down. The last node that is greater than p node is the successor.
     */
    private static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // 1st case
        if (p.right != null) {
            p = p.right;
            while (p.left != null) {
                p = p.left;
            }

            return p;
        }

        // 2nd case
        TreeNode min = null;
        while (root != null) {
            if (root.val > p.val) {
                min = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }

        return min;
    }

    public static void main(String... args) {
        TreeNode r = new TreeNode(20);
        r.left = new TreeNode(8);
        r.right = new TreeNode(17);
        r.left.left = new TreeNode(4);
        r.left.right = new TreeNode(11);
        r.left.right.left = new TreeNode(9);

        // 8 -> 9
        Assertions.assertEquals(inorderSuccessor(r, r.left), r.left.right.left);

        // 4 -> 8
        Assertions.assertEquals(inorderSuccessor(r, r.left.left), r.left);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
