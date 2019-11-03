package leetcode;

import org.junit.jupiter.api.Assertions;
import utils.TreeBuilder;
import utils.TreeBuilder.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

// https://leetcode.com/problems/binary-tree-preorder-traversal/
public class BinaryTreePreorderTraversal {

    /**
     * Using Morris traversal
     * <p>
     * Time: O(n)
     * Space: O(1)
     */
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> state = new ArrayList<>();

        TreeNode curr = root;
        while (curr != null) {
            // if current node has a left child go left
            if (curr.left != null) {
                // find rightmost node in the left subtree. It can be current's direct left child or it can sit
                // in the right subtree of the current's left child
                TreeNode pred = curr.left;
                // second condition ensures that rightmost node will not be equal to the current node
                while (pred.right != null && pred.right != curr) {
                    pred = pred.right;
                }

                if (pred.right == null) {
                    pred.right = curr;
                    state.add(curr.val);
                    curr = curr.left;
                } else {
                    pred.right = null;
                    curr = curr.right;
                }
            } else {
                state.add(curr.val);
                curr = curr.right;
            }
        }

        return state;
    }

    /**
     * Iterative approach using stack
     * <p>
     * Time: O(n)
     * Space: O(n)
     */
    public static List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> state = new ArrayList<>();
        if (root == null) {
            return state;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            root = stack.pop();
            state.add(root.val);

            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null) {
                stack.push(root.left);
            }
        }

        return state;
    }

    public static void main(String... args) {
        List<Integer> preorder = preorderTraversal(TreeBuilder.build(1, 2, 3, 4, 5, 6, 7));
        List<Integer> preorder2 = preorderTraversal2(TreeBuilder.build(1, 2, 3, 4, 5, 6, 7));

        Assertions.assertArrayEquals(preorder.stream().mapToInt(i -> i).toArray(), new int[]{1, 2, 4, 5, 3, 6, 7});
        Assertions.assertArrayEquals(preorder2.stream().mapToInt(i -> i).toArray(), new int[]{1, 2, 4, 5, 3, 6, 7});
    }
}
