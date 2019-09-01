package leetcode;

import org.junit.jupiter.api.Assertions;

// https://leetcode.com/problems/median-of-two-sorted-arrays/
public class MedianOfTwoSortedArrays {

    /**
     * Traverse arrays as if they were already merged into one also sorted.
     * The number of traversal steps equals to half of the total of elements from both array + 1.
     * Thus, think about it as traversing the left part of the "merged" array
     * <p>
     * Time: O(l1 + l2)
     * Space: O(1)
     */
    private static double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;

        int threshold = (l1 + l2) / 2 + 1; // the number of elements in the left part of the "merged" array

        int med1 = 0;
        int med2 = 0;
        int p1 = 0; // a pointer to the 1st array
        int p2 = 0; // a pointer to the 2nd array
        for (int i = 0; i < threshold; i++) {
            med1 = med2;

            if (p1 == l1) { // reached the end of the 1st array
                med2 = nums2[p2++];
            } else if (p2 == l2) { // reached the end of the 2nd array
                med2 = nums2[p1++];
            } else if (nums1[p1] <= nums2[p2]) { // moving 1st
                med2 = nums1[p1++];
            } else {
                med2 = nums2[p2++];
            }
        }

        return (l1 + l2) % 2 == 0 ? (med1 + med2) / 2.0 : med2;
    }

    /**
     * Given arrays N with length n and M with length m, we divide each to the left and right partitions
     * left part      | right part
     * N[0]...N[i-1]  | N[i]...N[n-1]
     * M[0]...M[j-1]  | M[j]...M[j-1]
     * <p>
     * We keep dividing both arrays until we reach the point where N[i-1] <= M[j] AND M[j-1] <= N[i].
     * If this conditions are true then the median is found.
     * <p>
     * If not then we have to check 2 below cases:
     * 1) if N[i-1] > M[j] then it means that we have to move towards left in N array because that's where
     * elements that less than or equal M[j] sit.
     * 2) if M[j-1] > N[i] then we have to move towards right in N array because that's where
     * elements that greater than or equal M[j-1] sit.
     * <p>
     * Kind of complex logic behind this algorithm,
     * so for more details check out https://www.youtube.com/watch?v=LPFhl65R7ww
     * <p>
     * Time: O(log(min(n,m))
     * Space: O(1)
     */
    private static double findMedianSortedArrays2(int[] nArr, int[] mArr) {
        int n = nArr.length;
        int m = mArr.length;

        // the edge case: two arrays are empty
        if (n + m == 0) {
            return 0.0d;
        }

        // the first array's length must be less or equal to the 2nd array's length
        // otherwise we will have to deal with negative indexes in the 2nd array
        if (n > m) {
            return findMedianSortedArrays2(mArr, nArr);
        }

        int lo = 0;
        int hi = n;

        double median = 0.0d;
        while (lo <= hi) {
            // pivot element to partition the 1st array
            // length(left1) = p1
            // length(right2) = n - p1
            int p1 = (lo + hi) / 2;

            // pivot element to partition the 2nd array
            // length(left2) = p2
            // length(right2) = m - p2
            // thus, p1 + p2 = n - p1 + m - p2
            // p2 = (n + m) / 2 - p1
            // 1 is added to (n + m) because it plays nice with odd and even lengths
            int p2 = (n + m + 1) / 2 - p1;

            int left1 = byIdx(nArr, p1 - 1);   // N[i-1]
            int right1 = byIdx(nArr, p1);           // N[i]

            int left2 = byIdx(mArr, p2 - 1);   // M[j-1]
            int right2 = byIdx(mArr, p2);           // M[j]

            if (left1 <= right2 && left2 <= right1) {
                if ((n + m) % 2 == 1) {
                    median = Math.max(left1, left2);
                } else {
                    median = (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
                }
                break;
            } else if (left1 > right2) { // moving towards left
                hi = p1 - 1;
            } else {    // moving towards right
                lo = p1 + 1;
            }
        }

        return median;
    }

    private static int byIdx(int[] num, int idx) {
        if (idx < 0) {
            return Integer.MIN_VALUE;
        } else if (idx >= num.length) {
            return Integer.MAX_VALUE;
        } else {
            return num[idx];
        }
    }

    public static void main(String... args) {
        double median1 = findMedianSortedArrays1(new int[]{1, 6}, new int[]{3, 8});
        Assertions.assertEquals(median1, 4.5d);

        double median2 = findMedianSortedArrays2(new int[]{1, 6}, new int[]{3, 8});
        Assertions.assertEquals(median2, 4.5d);
    }
}
