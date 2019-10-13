package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

// https://leetcode.com/problems/combination-sum/
public class CombinationSum {

    /**
     * Backtracking
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> sets = new ArrayList<>();
        generate(candidates, target, sets, new ArrayDeque<>(), 0, 0);

        return sets;
    }

    private void generate(int[] candidates, int target, List<List<Integer>> sets, Deque<Integer> stateSet, int stateSum, int startIdx) {
        if (stateSum == target) {
            sets.add(new ArrayList<>(stateSet));
            return;
        } else if (stateSum > target) {
            return;
        }

        for (int i = startIdx; i < candidates.length; i++) {
            stateSum += candidates[i];
            stateSet.push(candidates[i]);
            generate(candidates, target, sets, stateSet, stateSum, i);
            stateSet.pop();
            stateSum -= candidates[i];
        }
    }
}
