package leetcode;

import java.util.*;

// https://leetcode.com/problems/permutations-ii/
public class Permutations2 {

    /**
     * Backtracking
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> perms = new ArrayList<>();

        generate(nums, new boolean[nums.length], perms, new ArrayDeque<>());

        return perms;
    }

    private void generate(int[] nums, boolean[] used, List<List<Integer>> perms, Deque<Integer> state) {
        if (state.size() == nums.length) {
            perms.add(new ArrayList<>(state));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                    continue;
                }

                used[i] = true;
                state.push(nums[i]);
                generate(nums, used, perms, state);
                used[i] = false;
                state.pop();
            }
        }
    }
}
