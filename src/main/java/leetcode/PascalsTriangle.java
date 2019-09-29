package leetcode;

import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/pascals-triangle/
public class PascalsTriangle {

    /**
     * Kth element in Nth row can be calculated using formula:
     * [N/K] = [N/K-1] * (N - K + 1) / K
     * where, [N/K-1] is a result of K-1 element in Nth row
     * <p>
     * Note, that [N/0] i.e. 0st element always equals 1
     * <p>
     * Time: O(N), N is a number of elements in the triangle
     * Space: O(1)
     */
    private static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        for (int N = 0; N < numRows; N++) {

            List<Integer> row = new ArrayList<>();
            row.add(1); // 0st element [N/0]

            int prev = 1; // [N/K-1] result
            for (int K = 1; K <= N; K++) {
                int curr = prev * (N - K + 1) / K;
                row.add(curr);

                prev = curr;
            }
            list.add(row);
        }

        return list;
    }


    public static void main(String... args) {
        List<List<Integer>> triangle = generate(3);
        Assertions.assertArrayEquals(triangle.get(0).stream().mapToInt(i -> i).toArray(), new int[]{1});
        Assertions.assertArrayEquals(triangle.get(1).stream().mapToInt(i -> i).toArray(), new int[]{1, 1});
        Assertions.assertArrayEquals(triangle.get(2).stream().mapToInt(i -> i).toArray(), new int[]{1, 2, 1});
    }
}
