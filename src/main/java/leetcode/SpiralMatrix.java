package leetcode;

import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/spiral-matrix/
public class SpiralMatrix {

    /**
     * assume that you are piling an onion: first, we you take out the most outer layer, then 2nd, 3rd and so on.
     * <p>
     * Spiral order can be obtained by the same principle i.e. by "piling" the N by M array
     * First you iterate through the elements of 1st row, M column, N (backward) row, and 1st column (backward)
     * Then you move the to elements of 2nd row, M-1 column, N-1 row, and 2nd column
     * and so forth until you reach the center of the array.
     * <p>
     * Time: O(N * M), N and M a size of the matrix
     * Space: O(1)
     */
    private static List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new ArrayList<>();
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        List<Integer> list = new ArrayList<>();

        int r1 = 0, r2 = rows - 1;
        int c1 = 0, c2 = cols - 1;

        while (r1 <= r2 && c1 <= c2) {
            for (int c = c1; c <= c2; c++) { // increase cols (to right)
                list.add(matrix[r1][c]);
            }
            for (int r = r1 + 1; r <= r2; r++) { //increase rows (to down)
                list.add(matrix[r][c2]);
            }

            if (r1 < r2 && c1 < c2) {
                for (int c = c2 - 1; c >= c1 + 1; c--) { //decrease cols (to left)
                    list.add(matrix[r2][c]);
                }
                for (int r = r2; r >= r1 + 1; r--) { //decrease rows (to up)
                    list.add(matrix[r][c1]);
                }
            }

            r1++;
            c1++;
            r2--;
            c2--;
        }

        return list;
    }

    public static void main(String... args) {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        List<Integer> list = spiralOrder(matrix);
        Assertions.assertArrayEquals(list.stream().mapToInt(i -> i).toArray(), new int[]{1, 2, 3, 6, 9, 8, 7, 4, 5});
    }
}
