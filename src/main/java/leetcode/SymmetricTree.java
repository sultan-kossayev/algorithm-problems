package leetcode;

import org.junit.jupiter.api.Assertions;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/symmetric-tree/
public class SymmetricTree {

    /**
     * Breadth-first search of mirrored nodes
     * <p>
     * Time: O(N), N is a number of nodes in the tree
     * Space: O(N)
     */
    private static boolean isSymmetric1(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);

        while (!queue.isEmpty()) {

            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();

            if (node1 == null && node2 == null) {
                continue;
            } else if (node1 == null || node2 == null) {
                return false;
            } else if (node1.val != node2.val) {
                return false;
            }

            queue.add(node1.left);
            queue.add(node2.right);
            queue.add(node1.right);
            queue.add(node2.left);
        }

        return true;
    }

    /**
     * Use stack to check mirrored nodes
     * <p>
     * Time: O(N)
     * Space: O(h), h is height of the tree
     */
    private static boolean isSymmetric2(TreeNode root) {
        if (root == null) {
            return true;
        }

        return check(root.left, root.right);
    }

    private static boolean check(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        } else if (node1 == null || node2 == null) {
            return false;
        }

        return node1.val == node2.val
                && check(node1.left, node2.right)
                && check(node1.right, node2.left);
    }

    public static void main(String... args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        Assertions.assertTrue(isSymmetric1(root));
        Assertions.assertTrue(isSymmetric2(root));
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
