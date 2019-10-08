package leetcode;

import java.util.*;

// https://leetcode.com/problems/subsets/
public class Subsets {

    /**
     * Backtracking
     * <p>
     * Time: O(2^n)
     * Space: O(n)
     */
    private static List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> powerset = new ArrayList<>();

        generate(nums, 0, powerset, new ArrayDeque<>());

        return powerset;
    }

    private static void generate(int[] nums, int start, List<List<Integer>> powerset, Deque<Integer> state) {
        powerset.add(new ArrayList<>(state));

        for (int i = start; i < nums.length; i++) {
            state.push(nums[i]);
            generate(nums, i + 1, powerset, state);
            state.pop();
        }
    }
}
