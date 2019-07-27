import java.util.*;

//https://leetcode.com/problems/contains-duplicate-ii/
public class Duplicates2 {
    
    public static void main(String... args) {
        int[] nums = new int[]{1,2,3,1};
        int k = 3;
        boolean b = containsNearbyDuplicate(nums, k);

        System.out.println(b);
    }

    private static boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        
        for (int i = 0; i < nums.length;i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
            
            if (set.size() > k) {
                set.remove(nums[i-k]);
            }
        }
        
        return false;
    }
}