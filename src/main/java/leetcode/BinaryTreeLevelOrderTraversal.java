package leetcode;

import utils.TreeBuilder.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://leetcode.com/problems/binary-tree-level-order-traversal/
public class BinaryTreeLevelOrderTraversal {

    /**
     * Iterative approach using queue
     * Time: O(n)
     * Space: O(n)
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            // shows how many nodes at the current level we have to process
            int levelSize = queue.size();
            List<Integer> level = new ArrayList<>(levelSize);
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            list.add(level);
        }

        return list;
    }

    /**
     * Recursive approach
     * <p>
     * Time: O(n)
     * Space: O(n)
     */
    public static List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        collect(res, root, 0);

        return res;
    }

    private static void collect(List<List<Integer>> res, TreeNode curr, int depth) {
        if (curr == null) {
            return;
        }

        if (depth == res.size()) {
            res.add(new ArrayList<>());
        }

        res.get(depth).add(curr.val);

        collect(res, curr.left, depth + 1);
        collect(res, curr.right, depth + 1);
    }
}
