package leetcode;

import utils.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// https://leetcode.com/problems/merge-intervals/
public class MergeIntervals {

    // The general idea is first to sort intervals by their left borders.
    // After, take the first interval's right border and compare with left border of the next interval.
    // Intervals overlap if the left border of the next interval is behind the right border of current interval.
    //
    // Time: O(N * logN)
    // Space: O(1)
    private static int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }

        List<int[]> merged = new ArrayList<>();

        // sorting by intervals by left borders
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

        int left = intervals[0][0]; // left border
        int right = intervals[0][1]; // right border
        for(int[] interval : intervals) {
            if(interval[0] <= right) { // This will check whether these 2 intervals overlap.
                right = Math.max(right, interval[1]); // expanding the interval to the right.
            } else {
                merged.add(new int[]{left, right}); // interval was found
                left = interval[0]; // setting borders of the new interval
                right = interval[1];
            }
        }

        merged.add(new int[]{left, right}); // adding the last interval

        return merged.toArray(new int[merged.size()][]);
    }


    public static void main(String... args) {
        int[][] intervals = new int[][]{{1,3},{2,6},{8,10},{5,7},{15,18}};
        int[][] merged = merge(intervals);

        ArrayUtil.assertAllEqual(merged, new int[][]{{1,7},{8,10},{15,18}});
    }
}
