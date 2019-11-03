package leetcode;

import org.junit.jupiter.api.Assertions;
import utils.TreeBuilder;
import utils.TreeBuilder.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

// https://leetcode.com/problems/validate-binary-search-tree/
public class ValidateBinarySearchTree {

    /**
     * Iterative approach utilizing inorder traversal's property:
     * nodes are visited sorted
     * <p>
     * Time: O(n)
     * Space: O(n)
     */
    public static boolean isValidBST(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();

        Integer prevValue = null;
        while (root != null || !stack.isEmpty()) {

            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            // because nodes are visited sorted thus if the current node is less or equal to previous
            // then BST is invalid
            if (prevValue != null && root.val <= prevValue) {
                return false;
            }

            prevValue = root.val;

            root = root.right;
        }

        return true;
    }

    /**
     * Recursive approach.
     * Each node puts min and max constraints to nodes in left and right subtrees that valid BST should adhere.
     * <p>
     * 1) in BST, nodes in the left subtree should be less than their parent's value.
     * Thus, parent's value is a max value (exclusive) up to which nodes in the left subtree can have a value.
     * 2) in BST, nodes in the right subtree should be greater than their parent's value.
     * Thus, parent's value is a min value (exclusive) starting from which nodes in the right subtree can have a value.
     */
    public static boolean isValidBST2(TreeNode root) {
        return check(root, null, null);
    }

    private static boolean check(TreeNode node, Integer min, Integer max) {
        if (node == null) {
            return true;
        }

        int val = node.val;

        // checking min constraint
        if (min != null && val <= min) {
            return false;
        }

        // checking max constraint
        if (max != null && val >= max) {
            return false;
        }

        return check(node.left, min, val)
                && check(node.right, val, max);
    }

    public static void main(String... args) {
        boolean valid = isValidBST(TreeBuilder.build(40, 20, 60, 10, 25));
        boolean valid2 = isValidBST2(TreeBuilder.build(40, 20, 60, 10, 25));

        Assertions.assertTrue(valid);
        Assertions.assertTrue(valid2);
    }
}
