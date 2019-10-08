package leetcode;

import java.util.*;

// https://leetcode.com/problems/subsets-ii/
public class Subsets2 {

    /**
     * Backtracking
     * <p>
     * Time: O(2^n)
     * Space: O(n)
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> powerset = new ArrayList<>();
        generate(nums, 0, powerset, new ArrayDeque<>());

        return powerset;
    }

    private void generate(int[] nums, int start, List<List<Integer>> powerset, Deque<Integer> state) {
        powerset.add(new ArrayList<>(state));

        Integer last = null;
        for (int i = start; i < nums.length; i++) {
            if (last == null || last != nums[i]) {
                state.push(nums[i]);
                generate(nums, i + 1, powerset, state);
                last = state.pop();
            }
        }
    }
}
