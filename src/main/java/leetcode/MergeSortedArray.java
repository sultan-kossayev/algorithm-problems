package leetcode;

import org.junit.jupiter.api.Assertions;

// https://leetcode.com/problems/merge-sorted-array/
public class MergeSortedArray {

    /**
     * Starts from filling the end of the array
     * <p>
     * Time: O(N + M), N is a size of nums1, M is a size of nums2.
     * Space: O(1)
     */
    private static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;

        for (int i = nums1.length - 1; i >= 0 && p2 >= 0 && p1 >= 0; i--) {
            if (nums2[p2] > nums1[p1]) {
                nums1[i] = nums2[p2];
                p2--;
            } else {
                nums1[i] = nums1[p1];
                p1--;
            }
        }

        // p2 >= 0 if nums1 elements get processed first
        // thus we have to copy all nums2 elements that left
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }

    public static void main(String... args) {
        int[] nums1 = new int[]{2, 4, 6, 0, 0, 0};
        int[] nums2 = new int[]{1, 3, 5};
        merge(nums1, 3, nums2, 3);

        Assertions.assertArrayEquals(nums1, new int[]{1, 2, 3, 4, 5, 6});
    }
}
