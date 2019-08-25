package leetcode;

import org.junit.jupiter.api.Assertions;

// https://leetcode.com/problems/search-in-rotated-sorted-array/
public class SearchInRotatedSortedArray {

    // 1. find the index of the rotated element (the pivot)
    // 2. use the pivot index to look up the target element using binary search technique
    //
    // Time: O(logN)
    // Space: O(1)
    private static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        // the pivot implicitly divides the array to left and right part
        // and everything to the left and right of the pivot is sorted in ascending order
        int pivotIdx = findPivotIdx(nums);
        int targetIdx;
        if (pivotIdx == 0) {
            // if the array was not rotated at all
            targetIdx = binarySearch(nums, 0, nums.length - 1, target);
        }else if (target > nums[0]) {
            // if the target is bigger than the first element
            // then it can only sit in the left part of the array
            // thus binary search the left part
            targetIdx = binarySearch(nums, 0, pivotIdx - 1, target);
        }else {
            // binary search the right part including pivot
            targetIdx = binarySearch(nums, pivotIdx, nums.length - 1, target);
        }

        return targetIdx;
    }

    // the default implementation of binary search
    // low and high are inclusive
    private static int binarySearch(int[] nums, int low, int high, int target) {
        while(low <= high) {
            int mid = (low + high) >>> 1; // to avoid overflow

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    private static int findPivotIdx(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        int pivotIdx = 0;
        while(low < high) {
            int mid = (low + high) >>> 1; // to avoid overflow

            if (nums[mid] > nums[mid + 1]) {
                // the pivot is just the next element
                pivotIdx = mid + 1;
                break;
            }

            if (nums[mid] >= nums[low]) {
                // mid element sits in the sorted left part of the array
                // thus we should look up the pivot element
                // in the other part of the array
                low = mid + 1;
            } else {
                // mid element sits in the rotated part of the array
                // thus we reducing the search space and continue
                high = mid;
            }
        }

        return pivotIdx;
    }

    public static void main(String[] args) {
        int idx = search(new int[]{4,5,6,7,0,1,2}, 1);
        Assertions.assertEquals(idx, 5);

        int idx2 = search(new int[]{4,5,6,7,0,1,2}, 10);
        Assertions.assertEquals(idx2, -1);
    }
}
