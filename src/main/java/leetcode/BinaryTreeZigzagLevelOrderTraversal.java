package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static utils.TreeBuilder.TreeNode;

// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
public class BinaryTreeZigzagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        dfs(res, root, 0);

        return res;
    }

    private void dfs(List<List<Integer>> res, TreeNode node, int depth) {
        if (node == null) {
            return;
        }

        if (depth == res.size()) {
            List<Integer> list = (depth & 1) == 0 ? new ArrayList<>() : new LinkedList<>();
            res.add(list);
        }

        if ((depth & 1) == 0) {
            res.get(depth).add(node.val);
        } else {
            ((LinkedList) res.get(depth)).push(node.val);
        }

        dfs(res, node.left, depth + 1);
        dfs(res, node.right, depth + 1);
    }
}
