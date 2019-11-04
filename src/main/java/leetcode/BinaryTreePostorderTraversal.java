package leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import static utils.TreeBuilder.TreeNode;

// https://leetcode.com/problems/binary-tree-postorder-traversal/
public class BinaryTreePostorderTraversal {

    /**
     * Check out the explanation in https://github.com/sultan-kossayev/algorithm-design/blob/master/src/main/java/treetraversal/PostOrder.java
     * <p>
     * Time: O(n)
     * Space: O(n)
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode curr = root;
        TreeNode prev = null;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            TreeNode top = stack.peek();
            if (top.right != null && top.right != prev) {
                curr = top.right;
            } else {
                // visit a node
                stack.pop();
                prev = top;
                list.add(top.val);
            }
        }

        return list;
    }
}
