package leetcode;

import org.junit.jupiter.api.Assertions;

// https://leetcode.com/problems/maximum-depth-of-binary-tree/
public class MaximumDepthOfBinaryTree {

    /**
     * DFS.
     * Might cause stackoverflow for tall trees.
     * In this case, can be redone using stack data structure and for loop
     * <p>
     * Time: O(N)
     * Space: O(N) for unbalanced tree, O(logN) for balanced
     */
    private static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int d1 = maxDepth(root.left);
        int d2 = maxDepth(root.right);

        return Math.max(d1, d2) + 1;
    }

    public static void main(String... args) {
        TreeNode r = new TreeNode(1);
        r.left = new TreeNode(2);
        r.left.left = new TreeNode(3);

        int d = maxDepth(r);

        Assertions.assertEquals(d, 3);
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
