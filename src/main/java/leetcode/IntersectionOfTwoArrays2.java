package leetcode;

import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/intersection-of-two-arrays-ii/
public class IntersectionOfTwoArrays2 {

    /**
     * First sort both arrays and then use two pointer technique
     * <p>
     * Time: O(max(M,N)log(max(M,N)), where M and N are lengths of the arrays
     * Space: O(N + M) (sorting allocates additional space)
     */
    private static int[] intersect1(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int[] common = new int[Math.max(nums1.length, nums2.length)];
        int idx = 0;
        for (int n1 = 0, n2 = 0; n1 < nums1.length && n2 < nums2.length; ) {
            if (nums1[n1] == nums2[n2]) {
                common[idx++] = nums1[n1];
                n1++;
                n2++;
            } else if (nums1[n1] < nums2[n2]) {
                n1++;
            } else {
                n2++;
            }
        }

        return Arrays.copyOfRange(common, 0, idx);
    }

    public static void main(String[] args) {
        int[] common = intersect1(new int[]{3, 2, 5, 3, 2}, new int[]{2, 3, 7, 2, 9});
        Assertions.assertArrayEquals(common, new int[]{2, 2, 3});
    }

    /**
     * Using hashmap.
     * The algo can be improved further by accounting the fact that one array can be too small than the other.
     * So, the idea is to put small array into hashmap
     * <p>
     * Time: O(M), where M is length of the 2nd array
     * Space: O(N), where N is length of the 1st array
     */
    public int[] intersect2(int[] nums1, int[] nums2) {
        Map<Integer, Integer> seen = new HashMap<>();
        for (int n : nums1) {
            seen.put(n, seen.getOrDefault(n, 0) + 1);
        }

        int[] common = new int[Math.max(nums1.length, nums2.length)];
        int idx = 0;
        for (int n : nums2) {
            if (seen.containsKey(n) && seen.get(n) > 0) {
                common[idx++] = n;
                seen.put(n, seen.get(n) - 1);
            }
        }

        return Arrays.copyOfRange(common, 0, idx);
    }
}
