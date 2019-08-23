package leetcode;

import org.junit.jupiter.api.Assertions;
import utils.ArrayUtil;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/intersection-of-two-arrays/
public class IntersectionOfTwoArrays {

    // using two-pointer technique
    private static int[] intersection1(int[] nums1, int[] nums2) {
        Arrays.sort(nums1); // assuming arrays are sorted
        Arrays.sort(nums2);

        int n1 = 0; // nums1 pointer
        int n2 = 0; // nums2 pointer

        int[] intersection = new int[Math.min(nums1.length, nums2.length)];
        int idx = 0;

        while (n1 < nums1.length && n2 < nums2.length) {
            if (nums1[n1] == nums2[n2]) {
                intersection[idx] = nums1[n1];

                // skip equal elements
                while (n1 < nums1.length && nums1[n1] == intersection[idx]) {
                    n1++;
                }
                // skip equal elements
                while (n2 < nums2.length && nums2[n2] == intersection[idx]) {
                    n2++;
                }
                idx++;
            } else if (nums1[n1] < nums2[n2]) { // have to catch up with nums2 elements
                n1++;
            } else if (nums1[n1] > nums2[n2]) { // have to catch up with nums1 elements
                n2++;
            }
        }

        return Arrays.copyOfRange(intersection, 0, idx);
    }

    // using hash set
    private static int[] intersection2(int[] nums1, int[] nums2) {
        Set<Integer> nums1Set = new HashSet<>();
        for (int i = 0; i < nums1.length;i++) {
            nums1Set.add(nums1[i]);
        }

        Set<Integer> intersectionSet = new HashSet<>();
        for (int i = 0; i < nums2.length;i++) {
            if (nums1Set.contains(nums2[i])) {
                intersectionSet.add(nums2[i]);
            }
        }

        int[] intersection = new int[intersectionSet.size()];
        int idx = 0;
        for (Integer s : intersectionSet) {
            intersection[idx++] = s;
        }

        return intersection;
    }

    public static void main(String[] args) {
        int[] intersection1 = intersection1(new int[]{4,9,5}, new int[]{9,4,9,8,4});
        int[] intersection2 = intersection2(new int[]{4,9,5}, new int[]{9,4,9,8,4});
        ArrayUtil.assertAllEqual(intersection1, new int[]{4,9});
        ArrayUtil.assertAllEqual(intersection2, new int[]{4,9});
    }
}
