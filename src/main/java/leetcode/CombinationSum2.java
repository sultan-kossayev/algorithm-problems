package leetcode;

import java.util.*;

// https://leetcode.com/problems/combination-sum-ii/
public class CombinationSum2 {

    /**
     * Backtracking
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> comb = new ArrayList<>();

        generate(candidates, target, comb, new boolean[candidates.length], 0, 0, new ArrayDeque<>());
        return comb;
    }

    private void generate(int[] candidates, int target, List<List<Integer>> comb, boolean[] used, int start, int stateSum, Deque<Integer> state) {
        if (stateSum == target) {
            comb.add(new ArrayList<>(state));
            return;
        } else if (stateSum > target) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            state.push(candidates[i]);

            generate(candidates, target, comb, used, i + 1, stateSum + candidates[i], state);

            state.pop();
        }
    }
}
