import java.util.Arrays;

//https://leetcode.com/problems/merge-sorted-array/
public class MergeSortedArray {
    
    public static void main(String... args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = new int[]{2,5,6};
        int n = 3;

        merge(nums1, m, nums2, n);

        System.out.println(Arrays.toString(nums1));
    }

    private static void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int p = nums1.length - 1;
        int p1 = m - 1;
        int p2 = n - 1;
        
        while(p1 >= 0 && p2 >= 0) {
            if(nums2[p2] > nums1[p1]) {
                nums1[p] = nums2[p2];
                p2--;
                p--;
            } else {
                nums1[p] = nums1[p1];
                p--;
                p1--;
            }
        }
        
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }
}