package leetcode;

import utils.TreeBuilder.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

// https://leetcode.com/problems/kth-smallest-element-in-a-bst/
public class KthSmallestElementInBST {

    public int kthSmallest(TreeNode root, int k) {
        int n = 1;
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            if (n++ == k) {
                return curr.val;
            }

            curr = curr.right;
        }

        return -1;
    }

    public int kthSmallest2(TreeNode root, int k) {

        int[] count = new int[]{k};
        return find(root, count).val;
    }

    private TreeNode find(TreeNode curr, int[] count) {
        if (curr == null) {
            return null;
        }

        TreeNode found = null;
        if ((found = find(curr.left, count)) != null) {
            return found;
        }

        if (--count[0] == 0) {
            return curr;
        }

        return find(curr.right, count);
    }
}
