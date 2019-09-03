package leetcode;

import org.junit.jupiter.api.Assertions;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/number-of-islands
public class NumberOfIslands {

    /**
     * Using Depth-first search.
     * We have to scan the matrix and find a node that contains '1'.
     * Such node is considered a root node and triggers DFS.
     * DFS checks adjacent nodes of a node that contains '1'.
     * DFS stops when we completely all adjacent nodes contains '0'.
     * <p>
     * Time: O(N * M), N is a number of rows and M is a number of columns
     * Space: O(N * M), because of the recursion stacks
     */
    private static int numIslandsUsingDFS(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }

        return count;
    }

    private static void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length) {
            return;
        }

        if (grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0'; // mark the node as '0' so that we don't scan it twice

        dfs(grid, i - 1, j); // check the above cell
        dfs(grid, i, j - 1); // check the left cell
        dfs(grid, i, j + 1); // check the right cell
        dfs(grid, i + 1, j); // check the below cell
    }

    /**
     * Using Breadth-first search. The logic is the same as with DFS.
     * <p>
     * Time: O(N * M)
     * Space: O(min(N, M)), the queue will at most contain N or M '1' in the worst case
     * i.e. when the whole matrix is filled with '1'
     */
    private static int numIslandsUsingBFS(char[][] grid) {
        Queue<int[]> island = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;

                    grid[i][j] = '0';
                    island.add(new int[]{i, j});
                    bfs(grid, island);
                }
            }
        }

        return count;
    }

    private static void bfs(char[][] grid, Queue<int[]> island) {
        while (island.peek() != null) {
            int[] curr = island.remove();
            int i = curr[0];
            int j = curr[1];

            if (i - 1 >= 0 && grid[i - 1][j] == '1') { // check the above cell
                island.add(new int[]{i - 1, j});
                grid[i - 1][j] = '0';
            }

            if (j - 1 >= 0 && grid[i][j - 1] == '1') { // check the left cell
                island.add(new int[]{i, j - 1});
                grid[i][j - 1] = '0';
            }

            if (j + 1 < grid[i].length && grid[i][j + 1] == '1') { // check the right cell
                island.add(new int[]{i, j + 1});

                grid[i][j + 1] = '0';
            }

            if (i + 1 < grid.length && grid[i + 1][j] == '1') { // check the bellow cell
                island.add(new int[]{i + 1, j});
                grid[i + 1][j] = '0';
            }
        }
    }

    public static void main(String[] args) {
        int num1 = numIslandsUsingDFS(new char[][]{{'1', '1', '1'}, {'0', '1', '0'}, {'1', '1', '1'}});
        Assertions.assertEquals(num1, 1);

        int num2 = numIslandsUsingBFS(new char[][]{{'1', '1', '1'}, {'0', '1', '0'}, {'1', '1', '1'}});
        Assertions.assertEquals(num2, 1);
    }
}
