package leetcode;

import utils.TreeBuilder.TreeNode;

// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
public class LowestCommonAncestorOfBinaryTree {

    /**
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
}
