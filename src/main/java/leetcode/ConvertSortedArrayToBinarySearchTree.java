package leetcode;

import org.junit.jupiter.api.Assertions;

// https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
public class ConvertSortedArrayToBinarySearchTree {

    /**
     * DFS and binary search approach
     * <p>
     * Time: O(N), N is a size of the array
     * Space: O(logN)
     */
    private static TreeNode sortedArrayToBST(int... nums) {
        return build(nums, 0, nums.length - 1);
    }

    private static TreeNode build(int[] nums, int lo, int hi) {
        if (lo > hi) {
            return null;
        }

        int p = lo + (hi - lo) / 2;

        TreeNode parent = new TreeNode(nums[p]);
        parent.left = build(nums, lo, p - 1);
        parent.right = build(nums, p + 1, hi);

        return parent;
    }

    public static void main(String... args) {
        TreeNode head = sortedArrayToBST(1, 2, 3, 4, 5);
        // [3,1,4,null,2,null,5]
        Assertions.assertEquals(head.val, 3);
        Assertions.assertEquals(head.left.val, 1);
        Assertions.assertEquals(head.right.val, 4);
        Assertions.assertEquals(head.left.right.val, 2);
        Assertions.assertEquals(head.right.right.val, 5);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
