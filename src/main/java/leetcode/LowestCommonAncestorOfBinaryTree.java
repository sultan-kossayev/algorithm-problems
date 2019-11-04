package leetcode;

import utils.TreeBuilder.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
public class LowestCommonAncestorOfBinaryTree {

    /**
     * Recursive approach.
     *
     * Two cases we have to handle:
     * 1. if p and q sit in the same subtree of root, then ancestor will be p or q,
     * depending which we will reach first
     * 2. if p and q sit in separate subtrees of root, then root is the ancestor of p and q
     * <p>
     * Time: O(n)
     * Space: O(n)
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // we might reach a leaf node first then return null
        // or we might reach p or q. In that case if we reached p first then q sits in one of the subtrees of p
        // and it means that p is ancestor of q.
        // and vise versa if we reached q first then q is ancestor of p
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // p and q sit in left and right subtrees of root, then root is ancestor for both p and q
        if (left != null && right != null) {
            return root;
        }

        // ancestor is in left or right subtree of root
        return left != null ? left : right;
    }

    /**
     * Iterative approach.
     * The idea is to use postorder traversal to build a path to p and q nodes
     * and the compare both paths and get the last common node.
     * <p>
     * Time: O(n)
     * Space: O(n)
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode curr = root;
        TreeNode prev = null;

        // path to p or q
        Deque<TreeNode> path = null;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            TreeNode top = stack.peek();
            if (top.right != null && top.right != prev) {
                curr = top.right;
            } else {
                if (top == p || top == q) {
                    if (path == null) {
                        path = new LinkedList<>(stack);
                    } else {
                        // we already have path to p or q, then whatever we have in stack will serve as 2nd path for us
                        break;
                    }
                    // edge case when p equals to q
                    if (p == q) {
                        break;
                    }
                }

                prev = top;
                stack.pop();
            }
        }

        // get last common node
        TreeNode common = null;
        while (!path.isEmpty() && !stack.isEmpty()) {
            TreeNode top = null;
            if ((top = path.removeLast()) != stack.removeLast()) {
                break;
            }

            common = top;
        }

        return common;
    }
}
