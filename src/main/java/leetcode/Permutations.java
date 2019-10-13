package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

// https://leetcode.com/problems/permutations
public class Permutations {

    /**
     * Backtracking
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> perms = new ArrayList<>();
        generate(nums, perms, new ArrayDeque<>());

        return perms;
    }

    private void generate(int[] nums, List<List<Integer>> perms, Deque<Integer> state) {
        if (state.size() == nums.length) {
            perms.add(new ArrayList<>(state));
        }
        for (int i = 0; i < nums.length; i++) {
            if (!state.contains(nums[i])) {
                state.push(nums[i]);
                generate(nums, perms, state);
                state.pop();
            }
        }
    }
}
