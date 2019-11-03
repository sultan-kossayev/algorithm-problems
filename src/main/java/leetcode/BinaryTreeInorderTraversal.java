package leetcode;

import org.junit.jupiter.api.Assertions;
import utils.TreeBuilder;
import utils.TreeBuilder.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/binary-tree-inorder-traversal/
public class BinaryTreeInorderTraversal {

    /**
     * Morris traversal
     * <p>
     * Time: O(n)
     * Space: O(1)
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode pred = curr.left;
                while (pred.right != null && pred.right != curr) {
                    pred = pred.right;
                }

                if (pred.right == null) {
                    pred.right = curr;
                    curr = curr.left;
                } else {
                    pred.right = null;
                    list.add(curr.val);
                    curr = curr.right;
                }

            } else {
                list.add(curr.val);
                curr = curr.right;
            }
        }

        return list;
    }

    /**
     * Iterative using stack
     * <p>
     * Time: O(n)
     * Space: O(n)
     */
    public static List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();

        while (root != null || !stack.isEmpty()) {

            // traverse left
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            // capture node's value
            TreeNode top = stack.pop();
            list.add(top.val);

            // traverse right
            root = top.right;
        }

        return list;
    }

    public static void main(String... args) {
        List<Integer> inorder = inorderTraversal(TreeBuilder.build(1, 2, 3, 4, 5, 6, 7));
        List<Integer> inorder2 = inorderTraversal2(TreeBuilder.build(1, 2, 3, 4, 5, 6, 7));

        Assertions.assertArrayEquals(inorder.stream().mapToInt(i -> i).toArray(), new int[]{4, 2, 5, 1, 6, 3, 7});
        Assertions.assertArrayEquals(inorder2.stream().mapToInt(i -> i).toArray(), new int[]{4, 2, 5, 1, 6, 3, 7});
    }
}
